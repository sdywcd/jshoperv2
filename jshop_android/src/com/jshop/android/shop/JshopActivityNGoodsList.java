package com.jshop.android.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

import com.jshop.android.action.JshopMGoodsListAction;
import com.jshop.android.action.JshopMelectrocartAction;
import com.jshop.android.action.JshopMgoodscategoryListAction;
import com.jshop.android.index.R;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.table.JshopMtable;
public class JshopActivityNGoodsList extends TabActivity{
	private final DBHelper dbhelper=new DBHelper(this);
	//页卡内容
	private ViewPager mPager;
	//Tab页面列表
	private List<View>tablistViews;
	//动画图片
	private ImageView cursor;
	//页卡头标
	private String[]tabTitle=null;
	//动画图片偏移量
	private int offset=0;
	//当前页卡编号
	private int currentIndex=0;
	//动画图片高度
	private int bmpW;
	private LocalActivityManager  manager=null;
	private final static String TAG="JshopActivityNGoodsList";
	private final Class<JshopActivityNGoodsList> context=JshopActivityNGoodsList.class;
	private TabHost mTabHost;
	private GridView gv;
	private ListView listViews;//used by goodslist
	private ListView listViewForCart;//used by cartlist
	private String requestjsonstr;
	private List<Map<String,Object>>goodscategoryList=new ArrayList<Map<String,Object>>();//商品分类
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();//elecart
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();//商品列表
	private ArrayList<HashMap<String, Object>> goodslists0 = new ArrayList<HashMap<String, Object>>();
	private ArrayList<HashMap<String, Object>> goodslists1 = new ArrayList<HashMap<String, Object>>();
	private ArrayList<HashMap<String, Object>> goodslists2 = new ArrayList<HashMap<String, Object>>();
	private ArrayList<HashMap<String, Object>> goodslists3 = new ArrayList<HashMap<String, Object>>();
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
		listViewForCart=(ListView)this.findViewById(R.id.listViewmyelectrocart);
		//读取ele_cart缓存
		Cursor ec=dbhelper.query(DBHelper.ELE_CART_TM_NAME);
		electrocartgoodslists=jmelecart.getElecarttoSQLite(ec);
		ec.close();
		SimpleAdapter cartlistItemAdapter=new SimpleAdapter(this,electrocartgoodslists,R.layout.jshop_m_detaillistview,new String[]{"needquantity","goodsname","memberprice"},new int[]{R.id.needquantity,R.id.goodsname,R.id.memberprice});
		cartlistItemAdapter.setViewBinder(new MyViewBinder());
		listViews.setAdapter(cartlistItemAdapter);
		//添加点击
		listViews.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				//这里要加入elecart
			}
		});
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
			mTabHost= getTabHost();
			for(int i = 0; i < tabTitle.length;i++){
				LinearLayout view = (LinearLayout) getLayoutInflater().inflate(R.layout.jshop_m_textfortabtitle,null);
				((TextView) view.findViewById(R.id.tv_title)).setText(tabTitle[i]);
				mTabHost.addTab(mTabHost.newTabSpec(tabTitle[i]).setIndicator("").setContent(new Intent(this,JshopTabHostGoodsList.class)));
			}
			mTabHost.setCurrentTab(0);
			manager=new LocalActivityManager (this,true);
			manager.dispatchCreate(savedInstanceState);
			
		}
	}
	
	
	private void InitTextView(){
		for(int i=0;i<tabTitle.length;i++){
			
		}
	}

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
	
//	@Override
//	public View createTabContent(String tag) {
//		
//		View view = new View(this);
//			if(tabTitle!=null){
//				if(tabTitle[0].equals(tag)){
//					goodslists0=collectSqliteGoodsList(tag);
//					SimpleAdapter listItemAdapter=new SimpleAdapter(this,goodslists0,R.layout.jshop_m_listforcategory,new String[]{"pictureurl","goodsname","memberprice","weight","detail","unitname"},new int[]{R.id.pictureurl,R.id.goodsname,R.id.memberprice,R.id.weight,R.id.detail,R.id.unitname});
//					listItemAdapter.setViewBinder(new MyViewBinder());
//					listViews.setAdapter(listItemAdapter);
//					//添加点击
//					listViews.setOnItemClickListener(new OnItemClickListener() {
//
//						@Override
//						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//								long arg3) {
//							showConfirmAddtoCart(goodslists0,arg2);
//						}
//					});
//					listItemAdapter.notifyDataSetChanged();
//				}else if (tabTitle[1].equals(tag)){
//					goodslists1=collectSqliteGoodsList(tag);
//					SimpleAdapter listItemAdapter=new SimpleAdapter(this,goodslists1,R.layout.jshop_m_listforcategory,new String[]{"pictureurl","goodsname","memberprice","weight","detail","unitname"},new int[]{R.id.pictureurl,R.id.goodsname,R.id.memberprice,R.id.weight,R.id.detail,R.id.unitname});
//					listItemAdapter.setViewBinder(new MyViewBinder());
//					listViews.setAdapter(listItemAdapter);
//					//添加点击
//					listViews.setOnItemClickListener(new OnItemClickListener() {
//
//						@Override
//						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//								long arg3) {
//							showConfirmAddtoCart(goodslists1,arg2);
//						}
//					});
//					listItemAdapter.notifyDataSetChanged();
//				}else if (tabTitle[2].equals(tag)){
//					goodslists2=collectSqliteGoodsList(tag);
//					SimpleAdapter listItemAdapter=new SimpleAdapter(this,goodslists2,R.layout.jshop_m_listforcategory,new String[]{"pictureurl","goodsname","memberprice","weight","detail","unitname"},new int[]{R.id.pictureurl,R.id.goodsname,R.id.memberprice,R.id.weight,R.id.detail,R.id.unitname});
//					listItemAdapter.setViewBinder(new MyViewBinder());
//					listViews.setAdapter(listItemAdapter);
//					//添加点击
//					listViews.setOnItemClickListener(new OnItemClickListener() {
//
//						@Override
//						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//								long arg3) {
//							showConfirmAddtoCart(goodslists2,arg2);
//						}
//					});
//					listItemAdapter.notifyDataSetChanged();
//				}else{
//					goodslists3=collectSqliteGoodsList(tag);
//					SimpleAdapter listItemAdapter=new SimpleAdapter(this,goodslists3,R.layout.jshop_m_listforcategory,new String[]{"pictureurl","goodsname","memberprice","weight","detail","unitname"},new int[]{R.id.pictureurl,R.id.goodsname,R.id.memberprice,R.id.weight,R.id.detail,R.id.unitname});
//					listItemAdapter.setViewBinder(new MyViewBinder());
//					listViews.setAdapter(listItemAdapter);
//					//添加点击
//					listViews.setOnItemClickListener(new OnItemClickListener() {
//
//						@Override
//						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
//								long arg3) {
//							showConfirmAddtoCart(goodslists3,arg2);
//						}
//					});
//					listItemAdapter.notifyDataSetChanged();
//				}
//			
//			}
//		return view;
//	}
	
	@SuppressWarnings("unused")
	private  ArrayList<HashMap<String, Object>> collectSqliteGoodsList(String tag){
		
		Cursor c=dbhelper.queryByParamGoodsCategoryTName(DBHelper.GOODS_TM_NAME,tag);
		try {
			goodslists=jmGoodslistAction.getGoodsListSQLite(c);
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		c.close();
		return goodslists;
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
	
	
}
