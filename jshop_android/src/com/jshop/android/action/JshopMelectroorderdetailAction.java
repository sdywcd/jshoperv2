package com.jshop.android.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


import com.jshop.android.util.Arith;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.util.Validate;

public class JshopMelectroorderdetailAction {
	private ArrayList<HashMap<String,Object>>eleorderdetail=new ArrayList<HashMap<String,Object>>();
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();
	private Double totalprice=0.0;//购物车总价
	private Double totalneedquantity=0.0;//共计
	
	
	
	public Double getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}


	public Double getTotalneedquantity() {
		return totalneedquantity;
	}


	public void setTotalneedquantity(Double totalneedquantity) {
		this.totalneedquantity = totalneedquantity;
	}


	/**
	 * 根据餐桌号获取电子菜单信息
	 * @param tablestate
	 * @param tableNumber
	 * @return
	 */
	private String findelectrocartForJshop(String tablestate,String tableNumber){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDALLELECTRONICMENUCARTTBYTABLENUMBERFORANDROID+"?tablestate="+tablestate+"&tableNumber="+tableNumber;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	
	/**
	 * 向服务器发送请求读取订单详细
	 * @param electronicMenuOrderid
	 * @return
	 */
	private String findElectronicMenuOrderTByelectronicMenuOrderidForJshop(String electronicMenuOrderid){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDALLELECTRONICMENUCARTTBYTABLENUMBERFORANDROID+"?electronicMenuOrderid="+electronicMenuOrderid;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	/**
	 * 进入到读取电子菜单购物车列表
	 * @param tablestate
	 * @param tableNumber
	 * @throws JSONException
	 * @throws IOException
	 */
	public ArrayList<HashMap<String, Object>>  findelectrocart(String tablestate,String tableNumber){
		electrocartgoodslists.clear();
		requestjsonstr=findelectrocartForJshop(tablestate,tableNumber);
		if(Validate.StrNotNull(requestjsonstr)){
			JSONArray ja=(JSONArray)JSONValue.parse(requestjsonstr);
			for(int i=0;i<ja.size();i++){
				HashMap<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=(JSONObject)(ja.get(i));
				map.put("goodsname", jo.get("goodsname").toString());
				map.put("memberprice", "￥"+jo.get("memberprice").toString());
				map.put("goodsid", jo.get("goodsid").toString());
				map.put("needquantity", jo.get("needquantity").toString());
				totalneedquantity=Arith.add(totalneedquantity, Double.parseDouble(jo.get("needquantity").toString()));
				totalprice=Arith.add(totalprice, Arith.mul(Double.parseDouble(jo.get("memberprice").toString()), Double.parseDouble(jo.get("needquantity").toString())));
				electrocartgoodslists.add(map);
			}
			return electrocartgoodslists;
		}
		return electrocartgoodslists;
		
	}
	
}
