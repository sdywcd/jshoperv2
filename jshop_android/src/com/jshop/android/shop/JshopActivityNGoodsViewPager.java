package com.jshop.android.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.jshop.android.action.JshopMGoodsListAction;
import com.jshop.android.index.R;
import com.jshop.android.sqlite.DBHelper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class JshopActivityNGoodsViewPager extends Activity {
	private final DBHelper dbhelper=new DBHelper(this);
	private ViewPager goodsViewPager;
	private Context mContext;
	private String goodsCategoryTid;
	private ArrayList<HashMap<String,Object>> goodslist;
	//private JshopMGoodsListAction jmGoodsListAction = new JshopMGoodsListAction();
	private GoodsPagerAdapter goodsViewPagerAdapter;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题窗口
		super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏模式
		super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		this.setContentView(R.layout.jshop_m_goodslistviewpager);
		this.mContext = JshopActivityNGoodsViewPager.this;
		int curpositoin = this.getIntent().getIntExtra("curposition", 0);
		goodsCategoryTid = this.getIntent().getStringExtra("goodsCategoryTid");
		
		
		collectSqliteGoodsList(goodsCategoryTid); //通过商品分类ID 得到商品数据

		
		InitialViewPager(); //初始化ViewPager
		
		
		//goodsViewPager.setAdapter(goodsViewPagerAdapter);
		
		
	}
	/**
	 * 
	 * @param goodsCategoryTid
	 */
	private void collectSqliteGoodsList(String goodsCategoryTid) {
		// TODO Auto-generated method stub
		
		Cursor c = dbhelper.queryByParamgoodsCategoryTid(dbhelper.GOODS_TM_NAME,goodsCategoryTid);
		try{
			goodslist = getGoodsListSqlite(c);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/**
	 * 根据商品分类ID拿到商品数据
	 */
	public ArrayList<HashMap<String,Object>> getGoodsListSqlite(Cursor c) throws IOException{
		ArrayList<HashMap<String,Object>> tempgoodslist = new ArrayList<HashMap<String,Object>>();
		c.moveToFirst();
		while(c.isAfterLast()){
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("goodsid", c.getString(c.getColumnIndex("goodsid")));
			map.put("goodsname", c.getString(c.getColumnIndex("goodsname")));
			map.put("memberprice", c.getString(c.getColumnIndex("memberprice")));
			map.put("pictureurl",subStringPictureurl(c.getString(c.getColumnIndex("pictureurl")).toString()));
			map.put("weight", c.getString(c.getColumnIndex("weight")));
			map.put("unitname", c.getString(c.getColumnIndex("unitname")));
			map.put("detail", c.getString(c.getColumnIndex("detail")));
			map.put("goodsCategoryTid", c.getString(c.getColumnIndex("goodsCategoryTid")));
			tempgoodslist.add(map);
		}
		return tempgoodslist;
	}
	/**
	 * 
	 */
	private String subStringPictureurl(String str){
		return str.substring(0, str.length()-1);
	}
	
	/**
	 * 在layout中通过id找到ViewPager
	 * 
	 */
	private void InitialViewPager(){
		goodsViewPager = (ViewPager) this.findViewById(R.id.goodslistPages);//找到jshop_m_goodslistviewpager的ViewPager
		
		LayoutInflater myinflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
		goodsViewPager.setAdapter(new GoodsPagerAdapter(mContext,goodslist));
		
		
	}
	public class GoodsPagerAdapter extends PagerAdapter{
		private ArrayList<HashMap<String, Object>> list;
		private Context ctx; 
		
		public  GoodsPagerAdapter(Context ctx, ArrayList<HashMap<String, Object>> list){
			this.ctx = ctx;
			this.list = list;
		}
		public Object instantiateItem(View collection, int position) {
			View v;
			v = View.inflate(ctx, R.layout.jshop_m_forgoodsviewpager, null);
			ImageView goodsimage = (ImageView) v.findViewById(R.id.goodsimage);
			goodsimage.setImageBitmap((Bitmap) this.list.get(position).get("pictureurl"));
			return position;	        
	    }

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return false;
		}
		
	}
}
