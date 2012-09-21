package com.jshop.android.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jshop.android.action.JshopMGoodsListAction;
import com.jshop.android.action.JshopMelectrocartAction;
import com.jshop.android.holder.ElecartListViewHolder;
import com.jshop.android.holder.GoodsListViewHolder;
import com.jshop.android.index.R;
import com.jshop.android.shop.JshopActivityNGoodsList.JshopMyElecartListViewAdapter;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.util.Arith;

public class JshopActivityNGoodsViewPager extends Activity {
	private final DBHelper dbhelper=new DBHelper(this);
	//private View v;//viewpager中的视图
	private ViewGroup maingroup;
	private ViewPager viewPager;
	private ImageView addtomyelecartmenu;//加入我的菜单按钮
	private ArrayList<View>pageViews=new ArrayList<View>();
	private ListView listViewForCart;//used by cartlist
	private Double total=0.0;
	private TextView totalmemberprice;//显示我的菜单总价
	private GoodsListViewHolder holder = new GoodsListViewHolder();
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();//elecart
	private ArrayList<HashMap<String,Object>> goodslist=new ArrayList<HashMap<String,Object>>();
	private JshopMGoodsListAction jmGoodsListAction = new JshopMGoodsListAction();
	private JshopMelectrocartAction jmelecart=new JshopMelectrocartAction();
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题窗口
		super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏模式
		super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		final LayoutInflater inflater=getLayoutInflater();
		maingroup=(ViewGroup) inflater.inflate(R.layout.jshop_m_goodslistviewpager, null);
		viewPager=(ViewPager) maingroup.findViewById(R.id.goodslistPages);
		//调用另一个布局初始化我的菜单
		Context mContext = JshopActivityNGoodsViewPager.this;
		LayoutInflater inflaterele = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
		String goodsCategoryTid = this.getIntent().getStringExtra("goodsCategoryTid");
		Cursor c = dbhelper.queryByParamgoodsCategoryTid(DBHelper.GOODS_TM_NAME,goodsCategoryTid);
		try{
			goodslist = jmGoodsListAction.getGoodsListSQLiteNoBitmap(c);
		}catch(IOException e){
			e.printStackTrace();
		}//通过商品分类ID 得到商品数据
		if(!goodslist.isEmpty()){
			pageViews.clear();
			for(int i=0;i<goodslist.size();i++){
				View view=inflater.inflate(R.layout.jshop_m_forgoodsviewpager, null);
				holder.setPictureurl((ImageView) view.findViewById(R.id.goodsimage));
				holder.setGoodsname((TextView) view.findViewById(R.id.goodsname));
				holder.setWeight((TextView) view.findViewById(R.id.valueweight));
				holder.setUnitname((TextView) view.findViewById(R.id.unit));
				holder.setMemberprice((TextView) view.findViewById(R.id.memprice));
				holder.setDetail((TextView) view.findViewById(R.id.goodsdetail));
				holder.setAddtomyelecartmenu((ImageView) view.findViewById(R.id.addtomyelecartmenu));
				pageViews.add(view);
			}
		}
		this.setContentView(maingroup);
		viewPager.setAdapter(new JshopActivityNGoodsViewPageAdapter());
		viewPager.setOnPageChangeListener(new JshopActivityNGoodsViewPagerChangeListener());
	}


	
	/**
	 * 点击加入我的菜单
	 * @param goodslists
	 * @param arg2
	 */
	public void showConfirmAddtoCart(final ArrayList<HashMap<String, Object>> goodslists,final int arg2){

		AlertDialog.Builder bulider=new AlertDialog.Builder(this);
		bulider.setMessage("确定加入我的菜单吗?").setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				String goodsid=goodslists.get(arg2).get("goodsid").toString();
				String goodsname=goodslists.get(arg2).get("goodsname").toString();
				String memberprice=goodslists.get(arg2).get("memberprice").toString();
				String pictureurl=goodslists.get(arg2).get("pictureurl").toString();
				String needquantity="1";
				jmelecart.setGoodsToElecartSQLite(goodsid,goodsname,memberprice,pictureurl,needquantity, getApplicationContext());
				
			}

		}).setNegativeButton("取消", null);
		AlertDialog alert=bulider.create();
		alert.show();
	}
	

	/**
	 * ViewPager的适配器
	 * @author "chenda"
	 *
	 */
	/**
	 * 对左右滚动空间进行适配器定义和操作
	 */
	class JshopActivityNGoodsViewPageAdapter extends PagerAdapter{

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
		public Object instantiateItem(View container, final int position) {
			// TODO Auto-generated method stub
			View v=new View(container.getContext());
			LayoutInflater inflater=(LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v=inflater.inflate(R.layout.jshop_m_forgoodsviewpager, null, false);
			holder.setPictureurl((ImageView) v.findViewById(R.id.goodsimage));
			holder.setGoodsname((TextView) v.findViewById(R.id.goodsname));
			holder.setWeight((TextView) v.findViewById(R.id.valueweight));
			holder.setUnitname((TextView) v.findViewById(R.id.unit));
			holder.setMemberprice((TextView) v.findViewById(R.id.memprice));
			holder.setDetail((TextView) v.findViewById(R.id.goodsdetail));
			holder.setAddtomyelecartmenu((ImageView) v.findViewById(R.id.addtomyelecartmenu));
			try {
				holder.getPictureurl().setImageBitmap(jmGoodsListAction.GetLocalOrNetBitmapWithoutScale(goodslist.get(position).get("pictureurl").toString()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			holder.getGoodsname().setText(goodslist.get(position).get("goodsname").toString());
			holder.getWeight().setText(goodslist.get(position).get("weight").toString());
			holder.getMemberprice().setText(goodslist.get(position).get("memberprice").toString());
			holder.getUnitname().setText(goodslist.get(position).get("unitname").toString());
			holder.getDetail().setText(Html.fromHtml(goodslist.get(position).get("detail").toString()));
			holder.getAddtomyelecartmenu().setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					showConfirmAddtoCart(goodslist,
							position);
				}
			 });
			 ((ViewPager) container).addView(v,0);
			 return v;
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
    class JshopActivityNGoodsViewPagerChangeListener implements OnPageChangeListener {  

    	public JshopActivityNGoodsViewPagerChangeListener(){
		
    	}
    	
    	
    	@Override  
        public void onPageScrollStateChanged(int arg0) {  
            // TODO Auto-generated method stub  
        }  
  
        @Override  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
            // TODO Auto-generated method stub  
        }  
  
		@Override  
        public void onPageSelected(final int arg0) {
       
        }  
    }


}
