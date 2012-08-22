package com.jshop.android.action;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.util.Arith;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.util.Validate;

public class JshopMelectrocartAction {
	private String needquantity="1";//默认一个
	private Double totalprice=0.0;//购物车总价
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();
	
	
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	/**
	 * 增加电子订单
	 */
	private String addelectororderForJshop(String tablestate,String tableNumber){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.ADDELECTRONICMENUORDERTFORANDORID+"?tablestate="+tablestate+"&tableNumber="+tableNumber;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	/**
	 * 更新电子订单
	 */
	private String addelectororderForJshop(String tablestate,String tableNumber,String paymentid,String paymentname){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.ADDELECTRONICMENUORDERTFORANDORID+"?tablestate="+tablestate+"&tableNumber="+tableNumber+"&paymentid="+paymentid+"&paymentname="+paymentname;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	/**
	 * 向服务器端发送请求获取goodslist信息
	 * @return
	 */
	private String addelectrocartForJshop(String goodsid,String tablestate,String tableNumber){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.ADDELECTRONICMENUCARTFORANDROID+"?goodsid="+goodsid+"&tableNumber="+tableNumber+"&tablestate="+tablestate+"&needquantity="+needquantity;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	/**
	 * 新增电子订单
	 * @param tablestate
	 * @param tableNumber
	 * @return
	 */
	public String addelectororder(String tablestate,String tableNumber){
		requestjsonstr=addelectororderForJshop(tablestate,tableNumber);
		if(!"failed".equals(requestjsonstr)){
			return null;
		}
		return requestjsonstr;
	}
	/**
	 * 更新电子订单
	 * @param tablestate
	 * @param tableNumber
	 * @return
	 */
	public String addelectororder(String tablestate,String tableNumber,String paymentid,String paymentname){
		requestjsonstr=addelectororderForJshop(tablestate,tableNumber,paymentid,paymentname);
		if(!"failed".equals(requestjsonstr)){
			return null;
		}
		return requestjsonstr;
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
	 *  是否加入电子购物车成功
	 * @param goodsid
	 * @param tablestate
	 * @param tableNumber
	 * @return
	 * @throws IOException
	 */
	public boolean addGoodstoElectrocart(String goodsid,String tablestate,String tableNumber) throws IOException{
		requestjsonstr=addelectrocartForJshop(goodsid,tablestate,tableNumber);
		if(requestjsonstr!=null){
			if("success".equals(requestjsonstr)){
				return true;
			}else{
				return false;
				//加入购物车出错
			}
		}
		return false;
	}
	/**
	 * 进入到读取电子菜单购物车列表
	 * @param tablestate
	 * @param tableNumber
	 * @return 
	 * @throws JSONException
	 * @throws IOException
	 */
	public ArrayList<HashMap<String, Object>> findelectrocart(String tablestate,String tableNumber) throws IOException {
		electrocartgoodslists.clear();
		totalprice=0.0;
		requestjsonstr=findelectrocartForJshop(tablestate,tableNumber);
		if(Validate.StrNotNull(requestjsonstr)){
			JSONArray ja=(JSONArray)JSONValue.parse(requestjsonstr);
			for(int i=0;i<ja.size();i++){
				HashMap<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=(JSONObject)(ja.get(i));
				map.put("picture", getPictureurlImg(JshopActivityUtil.BASE_URL+jo.get("picture").toString()));
				map.put("goodsname", jo.get("goodsname").toString());
				map.put("memberprice", "￥"+jo.get("memberprice").toString());
				map.put("goodsid", jo.get("goodsid").toString());
				map.put("needquantity", jo.get("needquantity").toString()+"份");
				totalprice=Arith.add(totalprice, Arith.mul(Double.parseDouble(jo.get("memberprice").toString()), Double.parseDouble(jo.get("needquantity").toString())));
				electrocartgoodslists.add(map);
			}
			return electrocartgoodslists;
		}
		return electrocartgoodslists;
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
	
	/**
	 * 将商品加入我的菜单
	 */
	public void setGoodsToElecartSQLite(String goodsid,String goodsname,String memberprice,String pictureurl,String needquantity,Context context){
		DBHelper dbhelper = new DBHelper(context);
		ContentValues values = new ContentValues();
		values.put("goodsid",goodsid);
		values.put("goodsname",goodsname);
		values.put("memberprice",memberprice);
		values.put("pictureurl", pictureurl);
		values.put("needquantity",needquantity);
		Cursor c=dbhelper.queryByParamgoodsid(DBHelper.ELE_CART_TM_NAME, goodsid);
		int querycount=c.getCount();
		if(querycount>0){
			dbhelper.updateByElecartNeedquantity(DBHelper.ELE_CART_TM_NAME,goodsid,"plus");
		}else{
			dbhelper.insert(DBHelper.ELE_CART_TM_NAME, values);
		}
		
		dbhelper.close();
	}
	
	
	/**
	 * 从sqlite读取已经点的菜品
	 * @param c
	 * @return
	 */
	public ArrayList<HashMap<String, Object>>getElecarttoSQLite(Cursor c){
		electrocartgoodslists.clear();
		c.moveToFirst();
		while(!c.isAfterLast()){
			HashMap<String,Object>map=new HashMap<String,Object>();
			map.put("goodsid",c.getString(c.getColumnIndex("goodsid")));
			map.put("goodsname", c.getString(c.getColumnIndex("goodsname")));
			map.put("memberprice", c.getString(c.getColumnIndex("memberprice")));
			map.put("needquantity", c.getString(c.getColumnIndex("needquantity")));
			int ineed=Integer.parseInt(map.get("needquantity").toString());
			if(ineed>=1){
				electrocartgoodslists.add(map);
			}
			c.moveToNext();
		}
		return electrocartgoodslists;
	}
	
	public void plusorMinusElecart(ArrayList<HashMap<String, Object>> list,int position,String flag,Context context){
		if(!list.isEmpty()){
			String goodsid=list.get(position).get("goodsid").toString();
			DBHelper dbhelper = new DBHelper(context);
			dbhelper.updateByElecartNeedquantity(DBHelper.ELE_CART_TM_NAME, goodsid, flag);
		}
	}
	
	
	
}
