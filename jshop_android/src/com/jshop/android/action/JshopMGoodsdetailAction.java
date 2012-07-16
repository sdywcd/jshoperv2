package com.jshop.android.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.util.Validate;

public class JshopMGoodsdetailAction {
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
				goodsdetail.add(map);
			}
		}
		return goodsdetail;
	}
	/**
	 * 获取网络图片
	 * @param pictureurl
	 * @return
	 * @throws IOException
	 */
	public  Bitmap getPictureurlImg(String pictureurl) throws IOException{
		URL url=new URL(pictureurl);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5*1000);
		InputStream in=conn.getInputStream();
		Bitmap bm=BitmapFactory.decodeStream(in);
		in.close();
		return bm;
	}	
}
