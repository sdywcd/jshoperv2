package com.jshop.android.shop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.util.EncodingUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextView;
import android.widget.Toast;

import com.jshop.android.action.JshopMelectrocartAction;
import com.jshop.android.index.R;
import com.jshop.android.util.Arith;
import com.jshop.android.util.BaseTools;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopMPostActionList;
/**
 * 读取电子菜单商品列表
 * @Description TODO
 *
 * @Author "chenda"
 *
 * @File JshopMelectrocart.java
 *
 * @Package com.jshop.android.shop
 *
 * @ProjectName jshop_android
 * 
 * @Data 2012-5-10 下午03:47:04
 */
public class JshopMelectrocart extends Activity{

	private Button buttonmaidan,buttondiandan;
	private TextView totalcartprice;
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();
	private ListView listViews;
	private String needquantity="1";//默认一个
	private Double totalprice=0.0;//购物车总价
	private String paymentid="1";//选择的支付方式
	private String paymentname="现金";
	private boolean tag;
	private JshopMelectrocartAction jmelectrocartAction=new JshopMelectrocartAction();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_goodselectrocart);
		listViews=(ListView) this.findViewById(R.id.listViewmyelectrocart);
		totalcartprice=(TextView)this.findViewById(R.id.totalprice);
		buttondiandan=(Button)this.findViewById(R.id.Buttondiandan);
		buttonmaidan=(Button)this.findViewById(R.id.Buttonmaidan);
		
		Intent intent=this.getIntent();
		String goodsid=intent.getStringExtra("goodsid");
		String tablestate=intent.getStringExtra("tablestate");
		String tableNumber=intent.getStringExtra("tableNumber");
		final String []temp=readJmtable().split(",");
		if("-1".equals(temp[0])){
			Toast t=Toast.makeText(getApplicationContext(), "您还没有消费", Toast.LENGTH_LONG);
			t.show();
		}else{
			try {
				electrocartgoodslists=jmelectrocartAction.findelectrocart(temp[0],temp[1]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(goodsid!=null){
			try {
				if(jmelectrocartAction.addGoodstoElectrocart(goodsid,tablestate,tableNumber)){
					electrocartgoodslists=jmelectrocartAction.findelectrocart(tablestate,tableNumber);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block    
				e.printStackTrace();
			}	
		}
		
		SimpleAdapter listItemAdapter=new SimpleAdapter(this,electrocartgoodslists,R.layout.jshop_m_goodselectrocartitem,new String[]{"picture","goodsname","memberprice","needquantity"},new int[]{R.id.pictureurl,R.id.goodsname,R.id.memberprice,R.id.needquantity});
		listItemAdapter.setViewBinder(new MyViewBinder());
		listViews.setAdapter(listItemAdapter);
		//添加点击
		listViews.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//点击进入查看菜品的制作进度和相关情况
//				Intent intent=new Intent(JshopMelectrocart.this,JshopActivityGoodsdetail.class);
//				intent.putExtra("goodsid", electrocartgoodslists.get(arg2).get("goodsid").toString());
//				startActivity(intent);
			}
		});
		
		
		//注入总价值
		
		totalcartprice.setText(jmelectrocartAction.getTotalprice().toString());
		/**
		 * 点击点菜按钮
		 */
		buttondiandan.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//可能需要通知服务员
				if(temp!=null){
					String tablestate=temp[0].toString();
					String tableNumber=temp[1].toString();
					String backstring=jmelectrocartAction.addelectororder(tablestate,tableNumber);
					if(!"failed".equals(backstring)){
						Intent intent=new Intent(JshopMelectrocart.this,JshopMelectroorderdetail.class);
						intent.putExtra("electronicMenuOrderid",backstring);
						startActivity(intent);
					}
				}
				
			}
		});
		
		/**
		 * 点击买单按钮
		 */
		buttonmaidan.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(temp!=null){
					//可能需要通知服务员
					String tablestate=temp[0].toString();
					String tableNumber=temp[1].toString();
					//获取选择的支付方式
					getPayway(tablestate,tableNumber);
					
					
				}
				
			}
		});
		
	
		
		
		
	}
	
	private void getPayway(final String tablestate,final String tableNumber ){
		LayoutInflater inflater=LayoutInflater.from(this);
		final View payway=inflater.inflate(R.layout.jshop_m_payway, null);
		RadioGroup radioGrouppayway=(RadioGroup)payway.findViewById(R.id.radioGrouppayway);
		radioGrouppayway.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId==R.id.cash1radioButton){
					paymentid="1";
					paymentname="现金";
				}
				if(checkedId==R.id.creditcard2radioButton){
					paymentid="2";
					paymentname="刷卡";
				}
			}
			
		});
		AlertDialog.Builder bulider=new AlertDialog.Builder(this);
		bulider.setMessage("请选择支付方式").setCancelable(false).setView(payway).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			
					String backstring=jmelectrocartAction.addelectororder(tablestate,tableNumber,paymentid,paymentname);
					if(!"failed".equals(backstring)){
						//
						Intent intent=new Intent(JshopMelectrocart.this,JshopMelectroorderdetail.class);
						intent.putExtra("electronicMenuOrderid",backstring);
						startActivity(intent);
					}
				}
			
		}).setNegativeButton("取消", null);
		AlertDialog alert=bulider.create();
		alert.show();
	}
	
	
	
	
	
	
	public class MyViewBinder implements ViewBinder{
		@Override
		public boolean setViewValue(View view, Object data, String text) {
			if((view instanceof ImageView)&&(data instanceof Bitmap)){
				ImageView iv=(ImageView)view;
				Bitmap bm=(Bitmap)data;
				iv.setImageBitmap(bm);
				return true;
			}
			return false;
		}
		
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
