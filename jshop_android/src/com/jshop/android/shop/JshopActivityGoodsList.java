package com.jshop.android.shop;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
/**
 * 读取分类下的所有商品列表
 * @Description TODO
 *
 * @Author "chenda"
 *
 * @File JshopActivityGoodsList.java
 *
 * @Package com.jshop.android.shop
 *
 * @ProjectName jshop_android
 * 
 * @Data 2012-5-10 下午03:47:04
 */
public class JshopActivityGoodsList extends ListActivity{
	public static final String ACTION="findAllGoodsByismobileplatformgoodsforAndroid";
	
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();
	private List<View>listViews;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_goodslist);
		
//		Intent intent=this.getIntent();
//		String creatorid=intent.getStringExtra("creatorid");
//		goodsstrs=this.queryGoodsList(creatorid);
//		if(goodsstrs==null){
//			return;
//		}else{
//			String []strs=goodsstrs.split("-");
//			try{
//				for(int i=0;i<strs.length;i++){
//					JSONObject jo=new JSONObject(strs[i].toString());
//					String goodsid=jo.getString("goodsid");
//					String pictureurl=jo.getString("pictureurl");
//					String goodsname=jo.getString("goodsname");
//					String memberprice=jo.getString("memberprice");
//					if(pictureurl.indexOf(",")<0){
//						HashMap<String, Object> list = new HashMap<String, Object>(); 
//						Bitmap bm=getPictureurlImg(pictureurl);
//						list.put("pictureurl", bm);
//						list.put("goodsname", goodsname);
//						list.put("memberprice", memberprice);
//						list.put("goodsid", goodsid);
//						goodslists.add(list);
//					}
//				}
//			}catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		SimpleAdapter sap=new SimpleAdapter(this,goodslists,R.layout.jshop_activity_goodsoutline,new String[]{"pictureurl","goodsname","memberprice"},new int[]{R.id.smallpictureurlimageView,R.id.goodsname,R.id.memberprice});
//		sap.setViewBinder(new MyViewBinder());
		//this.setListAdapter(sap);
	}
	
	/**
	 * 向服务器端发送请求获取goodslist信息
	 * @return
	 */
	private String queryGoodsListForJshop(){
		String 
	}
	
	
	private void getGoodsList(){
		requestjsonstr=this.queryTableForJshop();
		if(requestjsonstr!=null){
			String []strs=requestjsonstr.split("--");
			for(int i=0;i<strs.length;i++){
				Map<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=new JSONObject(strs[i].toString());
				map.put("tableid", jo.getString("tableid"));
				map.put("tableNumber", jo.getString("tableNumber"));
				map.put("roomName", jo.getString("roomName"));
				map.put("androidDevicesCount", jo.getString("androidDevicesCount"));
				map.put("note", jo.getString("note"));
				map.put("createtime", jo.getString("createtime"));
				map.put("nop", jo.getString("nop"));
				map.put("tablestate", jo.getString("tablestate"));
				map.put("floor", jo.getString("floor"));
				map.put("rnop", jo.getString("rnop"));
				tableList.add(map);
			}
		}
	}
	

//	@Override
//	protected void onListItemClick(ListView l,View v,int position,long id){
//		Intent intent=null;
//		String goodsid=goodslists.get(position).get("goodsid").toString();
//		Bundle data=new Bundle();
//		data.putString("goodsid", goodsid);
//		intent = new Intent(JshopActivityGoodsList.this,JshopActivityGoodsdetail.class);
//		intent.putExtras(data);
//		startActivity(intent);
//	}
//	
//	private Bitmap getPictureurlImg(String pictureurl) throws IOException{
//		URL url=new URL(pictureurl);
//		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setConnectTimeout(5*1000);
//		InputStream in=conn.getInputStream();
//		Bitmap bm=BitmapFactory.decodeStream(in);
//		in.close();
//		return bm;
//	}
//	/**
//	 * 获取服务器的商品列表数据
//	 * @return
//	 */
//	private String queryGoodsList(String param){
//		String url=JshopActivityUtil.BASE_URL+ACTION+"?creatorid="+param;
//		return JshopActivityUtil.queryStringForPost(url);
//	}
//	
//	
	
	
	
	

}
