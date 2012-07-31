package com.jshop.android.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.util.Validate;

public class JshopMtableAction {
	private String requestjsonstr;
	private List<Map<String,Object>>tableList=new ArrayList<Map<String,Object>>();
	/**
	 * 向服务器端发送请求获取table信息
	 * @return
	 */
	public String queryTableForJshop(){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDALLTABLETFORANDROID;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	/**
	 * 更新餐桌使用状态
	 * @return
	 */
	public String updateTableTtablestateBytableNo(String tableid,String tablestate){
		String queryString="?tableid="+tableid+"&tablestate="+tablestate;
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.UPDATETABLETABLESTATEBYTABLENO+queryString;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	
	/**
	 * 处理服务器端返回的json数据
	 * @throws JSONException 
	 */
	public List<Map<String,Object>> getTablelist(){
		requestjsonstr=this.queryTableForJshop();
		if(Validate.StrNotNull(requestjsonstr)){
			JSONArray ja=(JSONArray)JSONValue.parse(requestjsonstr);
			for(int i=0;i<ja.size();i++){
				Map<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=(JSONObject)(ja.get(i));
				map.put("tableid", jo.get("tableid").toString());
				map.put("tableNumber", jo.get("tableNumber").toString());
				map.put("roomName", jo.get("roomName").toString());
				map.put("androidDevicesCount", jo.get("androidDevicesCount").toString());
				map.put("note", jo.get("note").toString());
				map.put("createtime", jo.get("createtime").toString());
				map.put("nop", jo.get("nop").toString());
				map.put("tablestate", jo.get("tablestate").toString());
				map.put("floor", jo.get("floor").toString());
				map.put("rnop", jo.get("rnop").toString());
				tableList.add(map);
			}
		}
		return tableList;
	}
	
	/**
	 * 把服务器上的餐桌缓存到本地数据库中
	 * @param tableList
	 * @param context
	 */
	public void setTabletoSQLite(List<Map<String,Object>> tableList,Context context){
		List<Map<String,Object>>tl=tableList;
		if(!tl.isEmpty()){
			DBHelper dbhelper=new DBHelper(context);
			HashMap<String,Object>map=new HashMap<String,Object>();
			ContentValues values=new ContentValues();
			for(int i=0;i<tl.size();i++){
				map=(HashMap<String,Object>)tl.get(i);
				values.put("tableid", map.get("tableid").toString());
				values.put("tableNumber",map.get("tableNumber").toString());
				values.put("roomName", map.get("roomName").toString());
				values.put("androidDevicesCount", map.get("androidDevicesCount").toString());
				values.put("note", map.get("note").toString());
				values.put("createtime", map.get("createtime").toString());
				values.put("nop", map.get("nop").toString());
				values.put("tablestate", map.get("tablestate").toString());
				values.put("floor", map.get("floor").toString());
				values.put("rnop", map.get("rnop").toString());
				dbhelper.insert(DBHelper.TABLE_TM_NAME, values);
			}
			dbhelper.close();
		}
	}
	
	
	
	
	
	/**
	 * 从sqlite中读取餐桌信息
	 * @param c
	 * @return
	 */
	public List<Map<String,Object>>getTabletoSQLite(Cursor c){
		c.moveToFirst();
		while(!c.isAfterLast()){
			HashMap<String,Object>map=new HashMap<String,Object>();
			map.put("tableid", c.getString(c.getColumnIndex("tableid")));
			map.put("tableNumber", c.getString(c.getColumnIndex("tableNumber")));
			map.put("roomName", c.getString(c.getColumnIndex("roomName")));
			map.put("androidDevicesCount", c.getString(c.getColumnIndex("androidDevicesCount")));
			map.put("note", c.getString(c.getColumnIndex("note")));
			map.put("createtime", c.getString(c.getColumnIndex("createtime")));
			map.put("nop", c.getString(c.getColumnIndex("nop")));
			map.put("tablestate", c.getString(c.getColumnIndex("tablestate")));
			map.put("floor", c.getString(c.getColumnIndex("floor")));
			map.put("rnop", c.getString(c.getColumnIndex("rnop")));
			tableList.add(map);
			c.moveToNext();
		}
		return tableList;
	}
	
	
}
