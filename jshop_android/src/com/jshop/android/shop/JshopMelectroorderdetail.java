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

import com.jshop.android.action.JshopMelectroorderdetailAction;
import com.jshop.android.index.R;
import com.jshop.android.util.Arith;
import com.jshop.android.util.BaseTools;
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
	private JshopMelectroorderdetailAction jmelectroorderdetailAction=new JshopMelectroorderdetailAction();
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
			electrocartgoodslists=jmelectroorderdetailAction.findelectrocart(temp[0],temp[1]);
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
	 * 处理订单详细字段
	 */
	private String processOrderdetailtext(){
		String tempvalue="";
		for(int i=0;i<electrocartgoodslists.size();i++){
			tempvalue+=electrocartgoodslists.get(i).get("goodsname").toString()+" "+electrocartgoodslists.get(i).get("needquantity").toString()+""+electrocartgoodslists.get(i).get("memberprice").toString()+"<br><br>";
		}
		tempvalue+="共计"+jmelectroorderdetailAction.getTotalneedquantity()+"道菜品"+"合计"+jmelectroorderdetailAction.getTotalprice()+"元";
		return tempvalue;
	}
	

	/**
	 * 读取餐桌信息文件
	 * @return
	 */
	public String readJmtable(){
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
