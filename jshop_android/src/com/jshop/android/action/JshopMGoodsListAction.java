package com.jshop.android.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.util.Validate;

public class JshopMGoodsListAction {

	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();

	/**
	 * 向服务器端发送请求获取goodslist信息
	 * 
	 * @return
	 */

	private String queryGoodsListForJshop(String goodsCategoryTid) {
		String posturl = JshopActivityUtil.BASE_URL + "/"
				+ JshopMPostActionList.FINDGOODSBYGOODSCATEGORYIDFORANDROID
				+ "?goodsCategoryTid=" + goodsCategoryTid;
		return JshopActivityUtil.queryStringForPost(posturl);
	}

	public ArrayList<HashMap<String, Object>> getGoodsList(
			String goodsCategoryTid) throws IOException {
		requestjsonstr = this.queryGoodsListForJshop(goodsCategoryTid);
		if (Validate.StrNotNull(requestjsonstr)) {
			JSONArray ja = (JSONArray) JSONValue.parse(requestjsonstr);
			for (int i = 0; i < ja.size(); i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				JSONObject jo = (JSONObject) (ja.get(i));
				map.put("pictureurl",
						getPictureurlImg(JshopActivityUtil.BASE_URL
								+ jo.get("pictureurl").toString()));
				map.put("goodsname", jo.get("goodsname").toString());
				map.put("memberprice", "￥" + jo.get("memberprice").toString());
				map.put("goodsid", jo.get("goodsid").toString());
				map.put("goodsCategoryTid", goodsCategoryTid);
				map.put("pictureurlpath",
						JshopActivityUtil.BASE_URL
								+ jo.get("pictureurl").toString());
				goodslists.add(map);
			}
		}
		return goodslists;
	}

	private Bitmap getPictureurlImg(String pictureurl) throws IOException {
		URL url = new URL(pictureurl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		InputStream in = conn.getInputStream();
		Bitmap bm = BitmapFactory.decodeStream(in);

		in.close();
		return bm;

	}

	private String savePicturetoDeviceAndReturnFixedUrl(String pictureurl)
			throws IOException {
		String regstr = "http:\\/\\/:(.?)*\\/(.?)*\\.(png|PNG|jpg|JPG|GIF|gif)";
		String postfix = "", filename = "", resultstr = "";
		Pattern patternForImg = Pattern.compile(regstr);
		Matcher matcher = patternForImg.matcher(pictureurl);
		if (matcher.find()) {
			filename = matcher.group(3);
			postfix = matcher.group(4);
		}
		resultstr = filename + "." + postfix;
		try {
			// FileOutputStream fos = openFileOutput()
		} catch (Exception e) {

		}
		return resultstr;

	}

	/**
	 * 把服务器上的商品列表数据缓存到本地数据库中
	 * 
	 * @param goodslists
	 * @param context
	 */
	public void setGoodsListSQLite(
			ArrayList<HashMap<String, Object>> goodslists, Context context) {
		ArrayList<HashMap<String, Object>> gl = goodslists;
		if (!gl.isEmpty()) {
			DBHelper dbhelper = new DBHelper(context);
			HashMap<String, Object> map = new HashMap<String, Object>();
			ContentValues values = new ContentValues();
			for (int i = 0; i < gl.size(); i++) {
				map = (HashMap<String, Object>) gl.get(i);
				values.put("goodsid", map.get("goodsid").toString());
				values.put("goodsname", map.get("goodsname").toString());
				values.put("memberprice", map.get("memberprice").toString());
				values.put("pictureurl", map.get("pictureurlpath").toString());
				values.put("goodsCategoryTid", map.get("goodsCategoryTid")
						.toString());
				dbhelper.insert(DBHelper.GOODS_TM_NAME, values);
			}
			dbhelper.close();
		}

	}

	/**
	 * 读取商品列表换群从sqlite
	 * 
	 * @param c
	 * @return
	 * @throws IOException
	 */
	public ArrayList<HashMap<String, Object>> getGoodsListSQLite(Cursor c)
			throws IOException {
		c.moveToFirst();
		while (!c.isAfterLast()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("goodsid", c.getString(c.getColumnIndex("goodsid")));
			map.put("goodsname", c.getString(c.getColumnIndex("goodsname")));
			map.put("memberprice", c.getString(c.getColumnIndex("memberprice")));
			map.put("pictureurl", getPictureurlImg(JshopActivityUtil.BASE_URL
					+ c.getString(c.getColumnIndex("pictureurl")).toString()));
			goodslists.add(map);
			c.moveToNext();
		}
		return goodslists;
	}

}
