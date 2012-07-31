package com.jshop.android.pad.shop;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.SimpleAdapter.ViewBinder;



import com.jshop.android.pad.R;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
/**
 * 读取分类下的�?��商品列表
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
public class JshopActivityGoodsList extends Activity{
	
	private Button goodscategory;
	private Button selectedorder;
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();
	private ListView listViews;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_goodslist);
		listViews=(ListView) this.findViewById(R.id.listViewgoods);
		goodscategory=(Button)this.findViewById(R.id.goodscategory);
		selectedorder=(Button)this.findViewById(R.id.selectedorder);
		Intent intent=this.getIntent();
		String goodsCategoryTid=intent.getStringExtra("goodsCategoryTid");
		try {
			this.getGoodsList(goodsCategoryTid);
		}catch (IOException e) {
			// TODO Auto-generated catch block    
			e.printStackTrace();
		}
		SimpleAdapter listItemAdapter=new SimpleAdapter(this,goodslists,R.layout.jshop_m_goodslistitem,new String[]{"pictureurl","goodsname","memberprice"},new int[]{R.id.pictureurl,R.id.goodsname,R.id.memberprice});
		listItemAdapter.setViewBinder(new MyViewBinder());
		listViews.setAdapter(listItemAdapter);
		//添加点击
		listViews.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//点击进入商品详细页面
				Intent intent=new Intent(JshopActivityGoodsList.this,JshopActivityGoodsdetail.class);
				intent.putExtra("goodsid", goodslists.get(arg2).get("goodsid").toString());
				
				startActivity(intent);
			}
		});
		goodscategory.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(JshopActivityGoodsList.this,JshopActivityGoodsCategoryList.class);
				startActivity(intent);
			}
		});
		selectedorder.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0){
				Intent intent=new Intent(JshopActivityGoodsList.this,JshopMelectrocart.class);
				startActivity(intent);
			}
		});


	}
	
	/**
	 * 向服务器端发送请求获取goodslist信息
	 * @return
	 */
//	private String queryGoodsListForJshop(String goodsCategoryTid){
//		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDGOODSBYGOODSCATEGORYIDFORANDROID+"?goodsCategoryTid="+goodsCategoryTid;
//		return JshopActivityUtil.queryStringForPost(posturl);
//	}
	
	
	private void getGoodsList(String goodsCategoryTid) throws IOException{
		Integer[]lc={
				R.drawable.lc001,
				R.drawable.lc002
		};
		Integer[]rc={
				R.drawable.rc001,
				R.drawable.rc002
		};
		Integer[]dx={
				R.drawable.dx001,
				R.drawable.dx002
		};
		Integer[]yl={
				R.drawable.yl001,
				R.drawable.yl002
		};
		HashMap<String,Object>map=new HashMap<String,Object>();
		map.put("pictureurl", lc[0]);
		map.put("goodsname", "钵钵鸡");
		map.put("memberprice", "￥32");
		map.put("goodsid", "001");	
		
//		HashMap<String,Object>map1=new HashMap<String,Object>();
//		map1.put("pictureurl", lc[1]);
//		map1.put("goodsname", "冷拌翡翠豆芽");
//		map1.put("memberprice", "￥16");
//		map1.put("goodsid", "002");	
		
		HashMap<String,Object>map2=new HashMap<String,Object>();
		map2.put("pictureurl", rc[0]);
		map2.put("goodsname", "丰收日红烧肉");
		map2.put("memberprice", "￥28");
		map2.put("goodsid", "003");	
		
		HashMap<String,Object>map3=new HashMap<String,Object>();
		map3.put("pictureurl", rc[1]);
		map3.put("goodsname", "椒盐龙头烤");
		map3.put("memberprice", "￥58");
		map3.put("goodsid", "004");	
		
		HashMap<String,Object>map4=new HashMap<String,Object>();
		map4.put("pictureurl", dx[0]);
		map4.put("goodsname", "芒果芝士慕斯");
		map4.put("memberprice", "￥28");
		map4.put("goodsid", "005");	
		
//		HashMap<String,Object>map5=new HashMap<String,Object>();
//		map5.put("pictureurl", dx[1]);
//		map5.put("goodsname", "抹茶欧培拉");
//		map5.put("memberprice", "￥28");
//		map5.put("goodsid", "006");	
//		
//		HashMap<String,Object>map6=new HashMap<String,Object>();
//		map6.put("pictureurl", yl[0]);
//		map6.put("goodsname", "桂圆红枣茶");
//		map6.put("memberprice", "￥12");
//		map6.put("goodsid", "007");	
//		
//		HashMap<String,Object>map7=new HashMap<String,Object>();
//		map7.put("pictureurl", yl[1]);
//		map7.put("goodsname", "招牌手工咖啡");
//		map7.put("memberprice", "￥18");
//		map7.put("goodsid", "008");	
		
		goodslists.add(map);
//		goodslists.add(map1);
		goodslists.add(map2);
		goodslists.add(map3);
		goodslists.add(map4);
//		goodslists.add(map5);
//		goodslists.add(map6);
//		goodslists.add(map7);
		
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
	

}
