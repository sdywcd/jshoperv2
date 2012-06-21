package com.jshop.android.shop;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.util.EncodingUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jshop.android.index.R;
import com.jshop.android.util.Arith;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopMPostActionList;

/**
 * 餐饮系统主界面
 * 
 * @Description TODO
 * 
 * @Author "chenda"
 * 
 * @File JshopMelectroorderdetail.java
 * 
 * @Package com.jshop.android.index
 * 
 * @ProjectName jshop_android
 * 
 * @Data 2012-5-14 下午01:27:46
 */
public class JshopMelectroorderdetail extends Activity {

	private ImageButton sit, ordingfoods, checkout, calculator, callservice,vipcenter;
	private TextView orderdetail;
	private ArrayList<HashMap<String,Object>>eleorderdetail=new ArrayList<HashMap<String,Object>>();
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();
	private Double totalprice=0.0;//购物车总价
	private Double totalneedquantity=0.0;//共计
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setTitle(JshopMParams.SYSTEMNAME.toString());
		this.setContentView(R.layout.jshop_m_goodselectroorderdetail);
		sit = (ImageButton) this.findViewById(R.id.sit);
		ordingfoods = (ImageButton) this.findViewById(R.id.ordingfoods);
		checkout = (ImageButton) this.findViewById(R.id.checkout);
		calculator = (ImageButton) this.findViewById(R.id.calculator);
		callservice = (ImageButton) this.findViewById(R.id.callservice);
		vipcenter = (ImageButton) this.findViewById(R.id.vipcenter);
		final String []temp=readJmtable().split(",");
		//接收传递过来的订单号获取详细
//		Intent intent=this.getIntent();
//		String electronicMenuOrderid=intent.getStringExtra("electronicMenuOrderid");
//		if(electronicMenuOrderid!=null){
//			//进行获取订单详细操作
//			
//		}
		if("-1".equals(temp[0])){
			Toast t=Toast.makeText(getApplicationContext(), "您还没有消费", Toast.LENGTH_LONG);
			t.show();
		}else{
			findelectrocart(temp[0],temp[1]);
		}
		//向页面注入订单详细信息
		orderdetail=(TextView)this.findViewById(R.id.orderdetail);
		orderdetail.setText(Html.fromHtml(processOrderdetailtext()));
		orderdetail.setMovementMethod(ScrollingMovementMethod.getInstance());
		
		/**
		 * 点击进入点餐页面
		 */
		ordingfoods.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMelectroorderdetail.this,JshopActivityGoodsCategoryList.class);
				startActivity(intent);
					
			}

		});
		/**
		 * 点击进入结算页面
		 */
		checkout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMelectroorderdetail.this,JshopMelectrocart.class);
				startActivity(intent);
					
			}

		});
		
		
		
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
	public void findelectrocart(String tablestate,String tableNumber){
		electrocartgoodslists.clear();
		requestjsonstr=findelectrocartForJshop(tablestate,tableNumber);
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
	}
	
	/**
	 * 处理订单详细字段
	 */
	private String processOrderdetailtext(){
		String tempvalue="";
		for(int i=0;i<electrocartgoodslists.size();i++){
			tempvalue+=electrocartgoodslists.get(i).get("goodsname").toString()+" "+electrocartgoodslists.get(i).get("needquantity").toString()+""+electrocartgoodslists.get(i).get("memberprice").toString()+"<br><br>";
		}
		tempvalue+="共计"+totalneedquantity+"道菜品"+"合计"+totalprice+"元";
		return tempvalue;
	}
	
//	private void findElectronicMenuOrderTByelectronicMenuOrderid(String electronicMenuOrderid) throws JSONException{
//		requestjsonstr=this.findElectronicMenuOrderTByelectronicMenuOrderidForJshop(electronicMenuOrderid);
//		if(requestjsonstr!=null){
//			String []strs=requestjsonstr.split("--");
//			for(int i=0;i<strs.length;i++){
//				HashMap<String,Object>map=new HashMap<String,Object>();
//				JSONObject jo=new JSONObject(strs[i].toString());
//				map.put("", value)
//				
//				
//			}
//		}
//	}
	
	
	/**
	 * 读取餐桌信息文件
	 * @return
	 */
	private String readJmtable(){
		String res="";
		try{
			FileInputStream fis=openFileInput(JshopMParams.SHAREMTABLEPARAM);
			byte[]buffer=new byte[fis.available()];
			fis.read(buffer);
			res=EncodingUtils.getString(buffer,"UTF-8");
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
	
}
