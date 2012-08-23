package com.jshop.android.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.sqlite.DBHelper1;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.util.Validate;

public class JshopMgoodscategoryListAction{
	private String requestjsonstr;
	private List<Map<String,Object>>goodscategoryList=new ArrayList<Map<String,Object>>();
	
	/**
	 * 向服务器发送请求获取商品分类信息
	 */
	private String queryGoodsCategoryForJshop(){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDALLGOODSCATEGORYTFORANDROID;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	/**
	 * 处理服务器端返回的json数据
	 * @throws JSONException 
	 */
	public List<Map<String,Object>> getGoodsCategoryList(){
		requestjsonstr=this.queryGoodsCategoryForJshop();
		if(Validate.StrNotNull(requestjsonstr)){
			JSONArray ja=(JSONArray)JSONValue.parse(requestjsonstr);
			for(int i=0;i<ja.size();i++){
				JSONObject jo=(JSONObject)(ja.get(i));
				if(jo.get("grade").toString().equals("0")){
					HashMap<String,Object>map=new HashMap<String,Object>();
					map.put("goodsCategoryTid", jo.get("goodsCategoryTid").toString());
					map.put("grade", jo.get("grade").toString());
					map.put("name", jo.get("name").toString());
					map.put("goodsTypeId", jo.get("goodsTypeId").toString());
					map.put("sort", jo.get("sort").toString());
					goodscategoryList.add(map);
				}
			}
		}
		return goodscategoryList;
	}
	
	/**
	 * 把服务器上的商品分类数据缓存到本地数据库中
	 * @param goodscategoryList
	 */
	public void setGoodsCategoryListtoSQLite(List<Map<String,Object>> goodscategoryList,Context context){
		List<Map<String,Object>>gcl=goodscategoryList;
		if(!gcl.isEmpty()){
			DBHelper dbhelper=new DBHelper(context);
			HashMap<String,Object>map=new HashMap<String,Object>();
			ContentValues values=new ContentValues();
			for(int i=0;i<gcl.size();i++){
				map=(HashMap<String, Object>) gcl.get(i);
				values.put("goodsCategoryTid",map.get("goodsCategoryTid").toString());
				values.put("grade",map.get("grade").toString());
				values.put("name",map.get("name").toString());
				values.put("goodsTypeId",map.get("goodsTypeId").toString());
				values.put("sort",map.get("sort").toString());
				dbhelper.insert(DBHelper.GOODS_CATEGORY_TM_NAME, values);
			}
			dbhelper.close();
		}
	}
	
	/**
	 * 读取商品分类缓存从sqlite
	 * @param c
	 * @return
	 */
	public List<Map<String,Object>>  getGoodsCategoryListtoSQLite(Cursor c){
		goodscategoryList.clear();
		c.moveToFirst();
		while(!c.isAfterLast()){
			HashMap<String,Object>map=new HashMap<String,Object>();
			map.put("goodsCategoryTid", c.getString(c.getColumnIndex("goodsCategoryTid")));
			map.put("grade",c.getString(c.getColumnIndex("grade")));
			map.put("name", c.getString(c.getColumnIndex("name")));
			map.put("goodsTypeId", c.getString(c.getColumnIndex("goodsTypeId")));
			map.put("sort", c.getString(c.getColumnIndex("sort")));
			goodscategoryList.add(map);
			c.moveToNext();
		}
		return goodscategoryList;
	}
	
	
	
}
