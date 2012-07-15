package com.jshop.android.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
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
}
