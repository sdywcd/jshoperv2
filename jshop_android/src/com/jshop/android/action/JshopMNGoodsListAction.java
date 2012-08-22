package com.jshop.android.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import android.os.Environment;

import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.sqlite.DBHelper1;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.util.Validate;

public class JshopMNGoodsListAction {
	private String downloadpcurl;
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

	/**
	 * 获取服务器端的商品数据
	 */
	public ArrayList<HashMap<String, Object>> getGoodsList(String goodsCategoryTid) throws IOException {
		requestjsonstr = this.queryGoodsListForJshop(goodsCategoryTid);
		if (Validate.StrNotNull(requestjsonstr)) {
			JSONArray ja = (JSONArray) JSONValue.parse(requestjsonstr);
			for (int i = 0; i < ja.size(); i++) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				JSONObject jo = (JSONObject) (ja.get(i));
				map.put("pictureurl",getPictureurlImg(JshopActivityUtil.BASE_URL+ jo.get("pictureurl").toString()));
				map.put("goodsname", jo.get("goodsname").toString());
				map.put("memberprice", "￥" + jo.get("memberprice").toString());
				map.put("goodsid", jo.get("goodsid").toString());
				map.put("goodsCategoryTid", goodsCategoryTid);
				map.put("pictureurlpath", downloadpcurl);
				goodslists.add(map);
			}
		}
		return goodslists;
	}

	/**
	 * 下载服务器图片
	 * @param pictureurl
	 * @return
	 * @throws IOException
	 */
	private Bitmap getPictureurlImg(String pictureurl) throws IOException {
		URL url = new URL(pictureurl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5 * 1000);
		InputStream in = conn.getInputStream();
		Bitmap bm = BitmapFactory.decodeStream(in);
		// 保存本地图片
		String fileName=savePicturetoDeviceAndReturnFixedUrl(pictureurl);
		saveOnlinePictureToCard(bm,fileName);
		in.close();
		return bm;

	}
	


	/**
	 * 获取网络图片名称
	 * 
	 * @param pictureurl
	 * @return
	 */
	private String savePicturetoDeviceAndReturnFixedUrl(String pictureurl) {

		String regstr = "(http:|https:)\\/\\/[\\S\\.:/]*\\/(\\S*)\\.(jpg|png|gif)";
		String postfix = "", filename = "";
		Pattern patternForImg = Pattern.compile(regstr,Pattern.CASE_INSENSITIVE);
		Matcher matcher = patternForImg.matcher(pictureurl);
		if (matcher.find()) {
			filename = matcher.group(2);
			postfix = matcher.group(3);
		}
		return filename + "." + postfix;
	}

	private void saveOnlinePictureToCard(Bitmap bm, String fileName)
			throws IOException {
		File dirFile = new File(JshopMParams.SAVEPCPATH);
		if (!dirFile.exists()) {
			dirFile.mkdir();
		}
		String onlineFilePath = JshopMParams.SAVEPCPATH +fileName;
		File myOnlineFile = new File(onlineFilePath);
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(myOnlineFile));
		bm.compress(Bitmap.CompressFormat.JPEG, 100, bos);
		bos.flush();
		bos.close();
		this.downloadpcurl = onlineFilePath;
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
				values.put("goodsCategoryTid", map.get("goodsCategoryTid").toString());
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
			map.put("pictureurl", c.getString(c.getColumnIndex("pictureurl")).toString());
			goodslists.add(map);
			c.moveToNext();
		}
		return goodslists;
	}
	/**
	 * 清空商品表中的所有数据SQLite
	 */
	public void deleteGoodsListSQLite(Context context){
		DBHelper dbhelper = new DBHelper(context);
		dbhelper.deleteAll(DBHelper.GOODS_TM_NAME);
	}
	

}
