package com.jshop.android.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

import com.jshop.android.action.JshopMGoodsListAction;
import com.jshop.android.action.JshopMelectrocartAction;
import com.jshop.android.action.JshopMgoodscategoryListAction;
import com.jshop.android.holder.ElecartListViewHolder;
import com.jshop.android.holder.GoodsListViewHolder;
import com.jshop.android.index.R;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.util.Arith;
import com.jshop.android.widget.JshopListViewAdapter;

public class JshopActivityNGoodsList extends TabActivity  implements TabContentFactory{
	private final DBHelper dbhelper=new DBHelper(this);
	private String[]tabTitle=null;
	private GridView gv;
	private ListView listViews;//used by goodslist
	private ListView listViewForCart;//used by cartlist
	private TextView totalmemberprice;//显示我的菜单总价
	private Double total=0.0;
	private List<Map<String,Object>>goodscategoryList=new ArrayList<Map<String,Object>>();//商品分类
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();//elecart
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();//商品列表
	private JshopMgoodscategoryListAction jmgclAction=new JshopMgoodscategoryListAction();
	private JshopMGoodsListAction jmGoodslistAction=new JshopMGoodsListAction();
	private JshopMelectrocartAction jmelecart=new JshopMelectrocartAction();
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题窗口
		super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏模式
		super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		this.setContentView(R.layout.jshop_m_newgoodslist);
		listViews=(ListView)this.findViewById(R.id.listViewfornewgoods);//商品列表的listview
		listViewForCart=(ListView)this.findViewById(R.id.listViewforelecart);//我的菜单listview
		setElecartListView();//调用读取我的菜单数据
		
		//读取商品分类缓存
		Cursor c=dbhelper.query(DBHelper.GOODS_CATEGORY_TM_NAME);
		goodscategoryList=jmgclAction.getGoodsCategoryListtoSQLite(c);
		c.close();
		if(goodscategoryList.isEmpty()){
			goodscategoryList=jmgclAction.getGoodsCategoryList();
			//缓存goodscategorylist
			jmgclAction.setGoodsCategoryListtoSQLite(goodscategoryList, this.getApplicationContext());
		}
		setTabTitle(goodscategoryList);
		if(tabTitle!=null){
			TabHost th = getTabHost();
			for(int i = 0; i < tabTitle.length;i++){
				LinearLayout view = (LinearLayout) getLayoutInflater().inflate(R.layout.jshop_m_textfortabtitle,null);
				((TextView) view.findViewById(R.id.tv_title)).setText(tabTitle[i]);
				th.addTab(th.newTabSpec(tabTitle[i]).setIndicator(view).setContent(this));
			}
			
			th.setOnTabChangedListener(new OnTabChangeListener(){

				@Override
				public void onTabChanged(String tabId) {
					// TODO Auto-generated method stub
					SimpleListView(tabId);
				}
				
			});
		}
	}


	/**
	 * 读取我的菜单数据
	 */
	public void setElecartListView(){
		electrocartgoodslists.clear();
		//读取ele_cart缓存
		Cursor ec=dbhelper.query(DBHelper.ELE_CART_TM_NAME);
		electrocartgoodslists=jmelecart.getElecarttoSQLite(ec);
		ec.close();
		listViewForCart.setAdapter(new JshopMyElecartListViewAdapter(electrocartgoodslists,this.getApplicationContext()));
		
		setTotalMemberprice();
	}
	
	/**
	 * 设置计算我的菜单总价
	 */
	public void setTotalMemberprice(){
		total=0.0;
		if(!electrocartgoodslists.isEmpty()){
			for(int i=0;i<electrocartgoodslists.size();i++){
				total=Arith.add(total, Arith.mul(Double.parseDouble(electrocartgoodslists.get(i).get("memberprice").toString()), Double.parseDouble(electrocartgoodslists.get(i).get("needquantity").toString())));
			}
			totalmemberprice=(TextView) this.findViewById(R.id.totalmemberprice);
			totalmemberprice.setText("￥"+total);
		}else{
			totalmemberprice=(TextView) this.findViewById(R.id.totalmemberprice);
			totalmemberprice.setText("￥"+total);
		}
	}
	
	/**
	 * 刷新我的菜单数据
	 */
//	public void rfreshElecartListView(){
//		electrocartgoodslists.clear();
//		//读取ele_cart缓存
//		Cursor ec=dbhelper.query(DBHelper.ELE_CART_TM_NAME);
//		electrocartgoodslists=jmelecart.getElecarttoSQLite(ec);
//		ec.close();
//		
//	}
	
	
	/**
	 * 动态获取tabhost需要的title
	 * @param goodscategoryList
	 * @return
	 */
	@SuppressWarnings("unused")
	private void setTabTitle(List<Map<String,Object>>goodscategoryList){
		String [] t=new String[goodscategoryList.size()];
		for(int i=0;i<goodscategoryList.size();i++){
			t[i]=goodscategoryList.get(i).get("name").toString();
		}
		this.tabTitle=t;

	}
	
	/**
	 * 切换tabhost时调用的方法
	 * @param tag
	 * @return
	 */
	public View SimpleListView(String tag){
		collectSqliteGoodsList(tag);
		listViews.setAdapter(new JshopMyGoodsListViewAdapter(goodslists,this.getApplicationContext()));
		return listViews;
	}
	
	
	@Override
	public View createTabContent(String tag) {
		View view = new View(this);
			if(tabTitle!=null){
				if(tabTitle[0].equals(tag)){
					collectSqliteGoodsList(tag);
				}else if (tabTitle[1].equals(tag)){
					collectSqliteGoodsList(tag);
				}else if (tabTitle[2].equals(tag)){
					collectSqliteGoodsList(tag);
				}else{
					collectSqliteGoodsList(tag);
				}
				listViews.setAdapter(new JshopMyGoodsListViewAdapter(goodslists,this.getApplicationContext()));
			}
		return view;
	}
	

	@SuppressWarnings("unused")
	private  void collectSqliteGoodsList(String tag){
		
		Cursor c=dbhelper.queryByParamGoodsCategoryTName(DBHelper.GOODS_TM_NAME,tag);
		try {
			goodslists=jmGoodslistAction.getGoodsListSQLite(c);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		c.close();
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
				setElecartListView();
				
			}

		}).setNegativeButton("取消", null);
		AlertDialog alert=bulider.create();
		alert.show();
	}
	
	/**
	 * 商品listview的适配器
	 * @author "chenda"
	 *
	 */
	public class JshopMyGoodsListViewAdapter extends BaseAdapter {
		private ArrayList<HashMap<String, Object>> list;
		private LayoutInflater myInflater;

		public JshopMyGoodsListViewAdapter(
				ArrayList<HashMap<String, Object>> list, Context context) {
			this.list = list;
			this.myInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			GoodsListViewHolder holder = null;
			if (convertView == null) {
				holder = new GoodsListViewHolder();
				convertView = myInflater.inflate(
						R.layout.jshop_m_listforcategory, null);
				holder.setPictureurl((ImageView) convertView
						.findViewById(R.id.pictureurl));
				holder.setGoodsname((TextView) convertView
						.findViewById(R.id.goodsname));
				holder.setMemberprice((TextView) convertView
						.findViewById(R.id.memberprice));
				holder.setWeight((TextView) convertView
						.findViewById(R.id.weight));
				holder.setUnitname((TextView) convertView
						.findViewById(R.id.unitname));
				holder.setAddtomyelecartmenu((ImageView) convertView
						.findViewById(R.id.addtomyelecartmenu));
				holder.setDetail((TextView) convertView
						.findViewById(R.id.detail));
				convertView.setTag(holder);
			} else {
				holder = (GoodsListViewHolder) convertView.getTag();
			}
			holder.getPictureurl().setImageBitmap(
					(Bitmap) list.get(position).get("pictureurl"));
			holder.getGoodsname().setText(
					list.get(position).get("goodsname").toString());
			holder.getMemberprice().setText(
					list.get(position).get("memberprice").toString());
			holder.getWeight().setText(
					list.get(position).get("weight").toString());
			holder.getUnitname().setText(
					list.get(position).get("unitname").toString());
			holder.getDetail().setText(
					list.get(position).get("detail").toString());
			holder.getAddtomyelecartmenu().setOnClickListener(
					new OnClickListener() {
						@Override
						public void onClick(View v) {
							showConfirmAddtoCart(list,
									position);
							
						}
					});
			return convertView;
		}

		@Override
		public void notifyDataSetChanged() {
			// TODO Auto-generated method stub
			super.notifyDataSetChanged();
		}
		
		
		
	}
	
	
	/**
	 * 我的elecart的适配器
	 * @author "chenda"
	 *
	 */
	public class JshopMyElecartListViewAdapter extends BaseAdapter {
		private final ArrayList<HashMap<String, Object>> list;
		private LayoutInflater myInflater;

		public JshopMyElecartListViewAdapter(
				ArrayList<HashMap<String, Object>> list, Context context) {
			this.list = list;
			this.myInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				final ViewGroup parent) {
			ElecartListViewHolder holder = null;
			if (convertView == null) {
				holder = new ElecartListViewHolder();
				convertView = myInflater.inflate(
						R.layout.jshop_m_detaillistview, null);
				holder.setGoodsname((TextView) convertView
						.findViewById(R.id.goodsname));
				holder.setMemberprice((TextView) convertView
						.findViewById(R.id.memberprice));
				holder.setNeedquantity((TextView) convertView.findViewById(R.id.needquantity));
				holder.setPlus((ImageView) convertView.findViewById(R.id.plus));
				holder.setMinus((ImageView) convertView.findViewById(R.id.minus));
				convertView.setTag(holder);
			} else {
				holder = (ElecartListViewHolder) convertView.getTag();
			}
			holder.getGoodsname().setText(
					list.get(position).get("goodsname").toString());
			holder.getMemberprice().setText(
					list.get(position).get("memberprice").toString());
			holder.getNeedquantity().setText(
					list.get(position).get("needquantity").toString());
			holder.getPlus().setOnClickListener(
					new OnClickListener() {
						@Override
						public void onClick(View v) {
							jmelecart.plusorMinusElecart(list, position, "plus", v.getContext());
							setElecartListView();
							setTotalMemberprice();
						}
					});
			holder.getMinus().setOnClickListener(
					new OnClickListener() {
						@Override
						public void onClick(View v) {
							jmelecart.plusorMinusElecart(list, position, "minus", v.getContext());
							
							setElecartListView();
							setTotalMemberprice();
						}
					});
			return convertView;
		}

		@Override
		public void notifyDataSetChanged() {
			// TODO Auto-generated method stub
			super.notifyDataSetChanged();
		}
	}
}
