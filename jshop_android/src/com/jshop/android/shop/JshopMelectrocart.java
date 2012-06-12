package com.jshop.android.shop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TabHost;
import android.widget.TextView;

import com.jshop.android.index.JshopMIndex;
import com.jshop.android.index.JshopMIndexbottom;
import com.jshop.android.index.JshopMIndexcenter;
import com.jshop.android.index.JshopMIndexmsgconfirm;
import com.jshop.android.index.R;
import com.jshop.android.login.JshopActivityLogin;
import com.jshop.android.register.JshopActivityRegister;
import com.jshop.android.table.JshopMtable;
import com.jshop.android.util.Arith;
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
				findelectrocart(temp[0],temp[1]);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(goodsid!=null){
			try {
				this.addGoodstoElectrocart(goodsid,tablestate,tableNumber);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		
		totalcartprice.setText(totalprice.toString());
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
					String backstring=addelectororder(tablestate,tableNumber);
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
				
			
					String backstring=addelectororder(tablestate,tableNumber,paymentid,paymentname);
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
	private String addelectororder(String tablestate,String tableNumber){
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
	private String addelectororder(String tablestate,String tableNumber,String paymentid,String paymentname){
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
	
	
	
	private void addGoodstoElectrocart(String goodsid,String tablestate,String tableNumber) throws IOException, JSONException{
		requestjsonstr=addelectrocartForJshop(goodsid,tablestate,tableNumber);
		if(requestjsonstr!=null){
			if("success".equals(requestjsonstr)){
				//进入到读取电子菜单购物车列表
				findelectrocart(tablestate,tableNumber);
			}else{
				//加入购物车出错
			}
		}
	}
	/**
	 * 进入到读取电子菜单购物车列表
	 * @param tablestate
	 * @param tableNumber
	 * @throws JSONException
	 * @throws IOException
	 */
	public void findelectrocart(String tablestate,String tableNumber) throws JSONException, IOException{
		electrocartgoodslists.clear();
		totalprice=0.0;
		requestjsonstr=findelectrocartForJshop(tablestate,tableNumber);
		String []strs=requestjsonstr.split("--");
		for(int i=0;i<strs.length;i++){
			HashMap<String,Object>map=new HashMap<String,Object>();
			JSONObject jo=new JSONObject(strs[i].toString());
			map.put("picture", getPictureurlImg(JshopActivityUtil.BASE_URL+jo.getString("picture")));
			map.put("goodsname", jo.getString("goodsname"));
			map.put("memberprice", "￥"+jo.getString("memberprice"));
			map.put("goodsid", jo.getString("goodsid"));
			map.put("needquantity", jo.getString("needquantity").toString()+"份");
			totalprice=Arith.add(totalprice, Arith.mul(Double.parseDouble(jo.getString("memberprice")), Double.parseDouble(jo.getString("needquantity"))));
			electrocartgoodslists.add(map);
		}
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
	private Bitmap getPictureurlImg(String pictureurl) throws IOException{
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
