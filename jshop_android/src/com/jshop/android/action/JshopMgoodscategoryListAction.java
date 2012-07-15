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

public class JshopMgoodscategoryListAction {
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
}
