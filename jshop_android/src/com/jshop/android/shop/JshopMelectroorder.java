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
import android.app.ListActivity;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Context;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
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
public class JshopMelectroorder extends Activity{
	
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();
	private ListView listViews;
	private String needquantity="1";//默认一个
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_goodselectrocart);
		listViews=(ListView) this.findViewById(R.id.listViewmyelectrocart);

		String []temp=readJmtable().split(",");
		if("-1".equals(temp[0])){
			Toast t=Toast.makeText(getApplicationContext(), "您还没有就座无法查看结帐", Toast.LENGTH_LONG);
			t.show();
		}else{
			String tablestate=temp[0].toString();
			String tableNumber=temp[1].toString();
			try {
				this.findGoodstoElectrocart(tablestate,tableNumber);
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
				//点击进入商品详细页面
				Intent intent=new Intent(JshopMelectroorder.this,JshopActivityGoodsdetail.class);
				intent.putExtra("goodsid", electrocartgoodslists.get(arg2).get("goodsid").toString());
				startActivity(intent);
			}
		});
		
	}
	
//	/**
//	 * 向服务器端发送请求获取goodslist信息
//	 * @return
//	 */
//	private String addelectrocartForJshop(String goodsid,String tablestate,String tableNumber){
//		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.ADDELECTRONICMENUCARTFORANDROID+"?goodsid="+goodsid+"&tableNumber="+tableNumber+"&tablestate="+tablestate+"&needquantity="+needquantity;
//		return JshopActivityUtil.queryStringForPost(posturl);
//	}
	
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
	
	
	
	private void findGoodstoElectrocart(String tablestate,String tableNumber) throws IOException, JSONException{
		//进入到读取电子菜单购物车列表
		requestjsonstr=findelectrocartForJshop(tablestate,tableNumber);
		if(requestjsonstr!=null){
			String []strs=requestjsonstr.split("--");
			for(int i=0;i<strs.length;i++){
				HashMap<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=new JSONObject(strs[i].toString());
				map.put("picture", getPictureurlImg(JshopActivityUtil.BASE_URL+jo.getString("picture")));
				map.put("goodsname", jo.getString("goodsname"));
				map.put("memberprice", "￥"+jo.getString("memberprice"));
				map.put("goodsid", jo.getString("goodsid"));
				map.put("needquantity", jo.getString("needquantity").toString()+"份");
				electrocartgoodslists.add(map);
			}
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
