package com.jshop.android.shop;

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
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.SimpleAdapter.ViewBinder;

import com.jshop.android.index.R;
import com.jshop.android.shop.JshopActivityGoodsList.JshopAndroidIndexGuidePageAdapter;
import com.jshop.android.shop.JshopActivityGoodsList.JshopAndroidIndexGuidePageChangeListener;
import com.jshop.android.shop.JshopActivityGoodsList.MyViewBinder;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
 
public class JshopActivityGoodsListViewPager extends Activity {
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();

	private ViewPager viewPager;//
	private ViewGroup maingroup;
	private ArrayList<View>pageViews;
	private ImageView mainimageView;//图片
	private TextView goodsname,memberprice;
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		LayoutInflater inflater=getLayoutInflater();
		pageViews=new ArrayList<View>();
		maingroup=(ViewGroup)inflater.inflate(R.layout.jshop_m_goodslistviewpager, null);
		viewPager=(ViewPager)maingroup.findViewById(R.id.goodslistPages);
		
		Intent intent=this.getIntent();
		String goodsCategoryTid=intent.getStringExtra("goodsCategoryTid");
		try {
			this.getGoodsList(goodsCategoryTid);
		}catch (IOException e) {
			// TODO Auto-generated catch block    
			e.printStackTrace();
		}

		for(int i=0;i<goodslists.size();i++){
			View v=inflater.inflate(R.layout.viewpagergoods, null);
			
			mainimageView=(ImageView)v.findViewById(R.id.pictureurl);
			mainimageView.setImageBitmap((Bitmap) goodslists.get(i).get("pictureurl"));
			goodsname=(TextView)v.findViewById(R.id.goodsname);
			goodsname.setText(goodslists.get(i).get("goodsname").toString());
//			memberprice=(TextView)v.findViewById(R.id.memberprice);
//			memberprice.setText(goodslists.get(i).get("memberprice").toString());
			pageViews.add(v);
		}
		setContentView(maingroup);
	
		viewPager.setAdapter(new JshopAndroidIndexGuidePageAdapter());
		viewPager.setOnPageChangeListener(new JshopAndroidIndexGuidePageChangeListener());
		
	}
	
	
	/**
	 * 向服务器端发送请求获取goodslist信息
	 * @return
	 */
	
	private String queryGoodsListForJshop(String goodsCategoryTid){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDGOODSBYGOODSCATEGORYIDFORANDROID+"?goodsCategoryTid="+goodsCategoryTid;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	
	private void getGoodsList(String goodsCategoryTid) throws IOException{
		requestjsonstr=this.queryGoodsListForJshop(goodsCategoryTid);
		if(requestjsonstr!=null){
			JSONArray ja=(JSONArray)JSONValue.parse(requestjsonstr);
			for(int i=0;i<ja.size();i++){
				HashMap<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=(JSONObject)(ja.get(i));
				map.put("pictureurl", getPictureurlImg(JshopActivityUtil.BASE_URL+jo.get("pictureurl").toString()));
				map.put("goodsname", jo.get("goodsname").toString());
				map.put("memberprice", "￥"+jo.get("memberprice").toString());
				map.put("goodsid", jo.get("goodsid").toString());	
				goodslists.add(map);
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
	 * 对左右滚动空间进行适配器定义和操作
	 */
	class JshopAndroidIndexGuidePageAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(pageViews.get(position));
		}

		@Override
		public void finishUpdate(View container) {
			// TODO Auto-generated method stub
		}

		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			 ((ViewPager) container).addView(pageViews.get(position));  
	            return pageViews.get(position);  
		}

		@Override
		public void setPrimaryItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			super.setPrimaryItem(container, position, object);
		}

		@Override
		public void startUpdate(View container) {
			// TODO Auto-generated method stub
			super.startUpdate(container);
		}
	}
	 // 指引页面更改事件监听器
    class JshopAndroidIndexGuidePageChangeListener implements OnPageChangeListener {  
    	  
    
        @Override  
        public void onPageScrollStateChanged(int arg0) {  
            // TODO Auto-generated method stub  
        }  
  
        @Override  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
            // TODO Auto-generated method stub  
        }  
  
        @Override  
        public void onPageSelected(int arg0) { 
        	
           
        }  
    }

}
