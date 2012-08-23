package com.jshop.android.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jshop.android.action.JshopMGoodsListAction;
import com.jshop.android.index.R;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.widget.JshopViewpagerAdapter;

public class JshopMGoodsListViewPager extends Activity {
	private final DBHelper dbhelper=new DBHelper(this);
	private ViewPager viewPager;//大图切换用的viewpager
	private ArrayList<View>pageViews;//存放图片的集合
	private ViewGroup maingroup;//进行viewpager的容器
	private ImageView mainimageView;
	private TextView goodsname;
	private JshopMGoodsListAction jmGoodslistAction=new JshopMGoodsListAction();
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();//商品列表
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Intent intent=this.getIntent();
		String goodsCategoryTid=intent.getStringExtra("goodsCategoryTid");
		if(goodsCategoryTid!=null){
			Cursor c=dbhelper.queryByParamgoodsCategoryTid(DBHelper.GOODS_TM_NAME, goodsCategoryTid);
			try {
				goodslists=jmGoodslistAction.getGoodsListSQLiteNoZip(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		LayoutInflater inflater=getLayoutInflater();
		pageViews=new ArrayList<View>();
		
		maingroup=(ViewGroup)inflater.inflate(R.layout.jshop_m_goodslistviewpager, null);
		viewPager=(ViewPager)maingroup.findViewById(R.id.goodslistPages);
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
		viewPager.setAdapter(new JshopViewpagerAdapter().new JshopActivityGoodsListPageAdapter(pageViews) );
		viewPager.setOnPageChangeListener(new JshopActivityGoodsListPageChangeListener());
	}
	
	   // 指引页面更改事件监听器
 class JshopActivityGoodsListPageChangeListener implements OnPageChangeListener {  
 	  
 
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
