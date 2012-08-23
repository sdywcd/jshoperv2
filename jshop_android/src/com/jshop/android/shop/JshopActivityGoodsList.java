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
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.SimpleAdapter.ViewBinder;

import com.jshop.android.action.JshopMGoodsListAction;
import com.jshop.android.index.JshopActivityIndex;
import com.jshop.android.index.R;
import com.jshop.android.index.WelcomeAct;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.sqlite.DBHelper1;
import com.jshop.android.util.BaseTools;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.widget.JshopViewpagerAdapter;
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
public class JshopActivityGoodsList extends Activity{
	private Context context;
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();
	private ListView listViews;
	private Button changemodel;
	private ViewPager viewPager;//
	private ViewGroup maingroup;
	private ArrayList<View>pageViews;
	private ImageView mainimageView;//图片
	private TextView goodsname,memberprice;
	private JshopMGoodsListAction jmGoodslistAction=new JshopMGoodsListAction();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_goodslist);
		listViews=(ListView) this.findViewById(R.id.listViewgoods);
		changemodel=(Button)this.findViewById(R.id.changemodel);
		
		Intent intent=this.getIntent();
		final String goodsCategoryTid=intent.getStringExtra("goodsCategoryTid");
		//读取缓存
		final DBHelper dbhelper=new DBHelper(this);
		//dbhelper.deleteAll(DBHelper.GOODS_CATEGORY_TM_NAME);
		Cursor c=dbhelper.queryByParamgoodsCategoryTid(DBHelper.GOODS_TM_NAME,goodsCategoryTid);
		try {
			goodslists=jmGoodslistAction.getGoodsListSQLite(c);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		c.close();
		if(goodslists.isEmpty()){
			try {
				goodslists=jmGoodslistAction.getGoodsList(goodsCategoryTid);
				//设置缓存
				jmGoodslistAction.setGoodsListSQLite(goodslists, getApplicationContext());
			}catch (IOException e) {
				// TODO Auto-generated catch block    
				e.printStackTrace();
			}	
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
		
		//切换模式
		changemodel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v1) {
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
//					memberprice=(TextView)v.findViewById(R.id.memberprice);
//					memberprice.setText(goodslists.get(i).get("memberprice").toString());
					pageViews.add(v);
				}
				setContentView(maingroup);
				//listViews.setVisibility(View.GONE);//隐藏listviews
				
				viewPager.setAdapter(new JshopViewpagerAdapter().new JshopActivityGoodsListPageAdapter(pageViews) );
				viewPager.setOnPageChangeListener(new JshopActivityGoodsListPageChangeListener());
//				Intent intent = new Intent(JshopActivityGoodsList.this,JshopActivityGoodsListViewPager.class);
//				intent.putExtra("goodsCategoryTid", goodsCategoryTid);
//				startActivity(intent);
			}
			
		});
		
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

}
