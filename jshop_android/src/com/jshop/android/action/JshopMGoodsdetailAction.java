package com.jshop.android.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.util.Validate;

public class JshopMGoodsdetailAction {
	private String downloadpcurl;
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodsdetail = new ArrayList<HashMap<String, Object>>();
	
	/**
	 * 向服务器发送请求获取goodsdetail信息
	 * @param goodsid
	 * @return
	 */
	private String queryGoodsdetailForJshop(String goodsid){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDGOODSBYGOODSIDFORANDROID+"?goodsid="+goodsid;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	/**
	 * 从服务器获取商品详细
	 * @param goodsid
	 * @return
	 * @throws IOException
	 */
	public ArrayList<HashMap<String, Object>> getGoodsdetail(String goodsid) throws  IOException{
		requestjsonstr=this.queryGoodsdetailForJshop(goodsid);
		if(Validate.StrNotNull(requestjsonstr)){
			JSONArray ja=(JSONArray)JSONValue.parse(requestjsonstr);
			for(int i=0;i<ja.size();i++){
				HashMap<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=(JSONObject)(ja.get(i));
				map.put("pictureurl",getPictureurlImg(JshopActivityUtil.BASE_URL+jo.get("pictureurl").toString()));
				map.put("goodsname", jo.get("goodsname").toString());
				map.put("memberprice", "￥"+jo.get("memberprice").toString()+"/份");
				map.put("goodsid", jo.get("goodsid").toString());	
				map.put("weight", jo.get("weight").toString());
				map.put("pictureurlpath", downloadpcurl);
				goodsdetail.add(map);
			}
		}
		return goodsdetail;
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
	 * 读取商品列表换群从sqlite
	 * 
	 * @param c
	 * @return
	 * @throws IOException
	 */
	public ArrayList<HashMap<String, Object>> getGoodsDetailSQLite(Cursor c)
			throws IOException {
		c.moveToFirst();
		while (!c.isAfterLast()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("goodsid", c.getString(c.getColumnIndex("goodsid")));
			map.put("goodsname", c.getString(c.getColumnIndex("goodsname")));
			map.put("memberprice", c.getString(c.getColumnIndex("memberprice")));
			map.put("pictureurl", c.getString(c.getColumnIndex("pictureurl")).toString());
			goodsdetail.add(map);
			c.moveToNext();
		}
		return goodsdetail;
	}
}
