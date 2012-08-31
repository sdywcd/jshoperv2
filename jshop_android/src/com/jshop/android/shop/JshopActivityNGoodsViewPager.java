package com.jshop.android.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.jshop.android.action.JshopMGoodsListAction;

import com.jshop.android.holder.GoodsListViewHolder;
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
import android.widget.TextView;

public class JshopActivityNGoodsViewPager extends Activity {
	private final DBHelper dbhelper=new DBHelper(this);
	private ViewPager goodsViewPager;
	private Context mContext;
	private String goodsCategoryTid;
	private ArrayList<HashMap<String,Object>> goodslist;
	//private JshopMGoodsListAction jmGoodsListAction = new JshopMGoodsListAction();
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题窗口
		super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏模式
		super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		this.setContentView(R.layout.jshop_m_goodslistviewpager); //有android.support.v4.view.ViewPager外层layout
		this.mContext = JshopActivityNGoodsViewPager.this;
		int curpositoin = this.getIntent().getIntExtra("curposition", 0);
		goodsCategoryTid = this.getIntent().getStringExtra("goodsCategoryTid");
		
		
		collectSqliteGoodsList(goodsCategoryTid); //通过商品分类ID 得到商品数据

		
		InitialViewPager(); //初始化ViewPager
		
		
		//goodsViewPager.setAdapter(goodsViewPagerAdapter);
		
		
	}
	/**
	 * 通过商品分类ID 得到商品数据
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
	 * 这个要写到action
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
	 * viewpager没做出来
	 * 
	 */
	private void InitialViewPager(){
		
		//goodsViewPager = (ViewPager) this.findViewById(R.id.goodslistPages);//找到jshop_m_goodslistviewpager的ViewPager
		ArrayList<View> views = null;
		LayoutInflater minflater = LayoutInflater.from(this);
		for(int i=0;i<goodslist.size();i++){
			final GoodsListViewHolder holder = new GoodsListViewHolder();
			View view = minflater.inflate(R.layout.jshop_m_forgoodsviewpager,null);//ViewPager的Layout
			holder.setPictureurl((ImageView) view.findViewById(R.id.goodsimage));
			holder.setGoodsname((TextView) view.findViewById(R.id.goodsname));
			holder.setWeight((TextView) view.findViewById(R.id.valueweight));
			holder.setUnitname((TextView) view.findViewById(R.id.unit));
			holder.setMemberprice((TextView) view.findViewById(R.id.memprice));
			holder.setDetail((TextView) view.findViewById(R.id.goodsdetail));
			holder.setAddtomyelecartmenu((ImageView) view.findViewById(R.id.addtoelectrocartconfirm));
			views.add(view);
		}
			
		goodsViewPager.setAdapter(new GoodsPagerAdapter(mContext,goodslist));
		
		
	}
	/**
	 * ViewPager的适配器
	 * @author "chenda"
	 *
	 */
	
	public class GoodsPagerAdapter extends PagerAdapter{
		private ArrayList<HashMap<String, Object>> list; 
		private Context ctx; 
		
		
		public  GoodsPagerAdapter(Context ctx, ArrayList<HashMap<String, Object>> list){
			this.ctx = ctx;
			this.list = list;
			
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			super.destroyItem(container, position, object);
		}


		@Override
		public void finishUpdate(View container) {
			// TODO Auto-generated method stub
			super.finishUpdate(container);
		}


		@Override
		public void startUpdate(View container) {
			// TODO Auto-generated method stub
			super.startUpdate(container);
		}



		@Override
		public void setPrimaryItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			return super.instantiateItem(container, position);
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
