package com.jshop.android.shop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

import com.jshop.android.action.JshopMGoodsListAction;
import com.jshop.android.action.JshopMelectrocartAction;
import com.jshop.android.action.JshopMgoodscategoryListAction;
import com.jshop.android.index.R;
import com.jshop.android.sqlite.DBHelper;
public class JshopActivityNGoodsList extends TabActivity implements TabContentFactory{
	private final DBHelper dbhelper=new DBHelper(this);

	private String[]tabTitle=null;
	private GridView gv;
	private ListView listViews;//used by goodslist
	private ListView listViewForCart;//used by cartlist
	private String requestjsonstr;
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
		//读取ele_cart缓存
		Cursor ec=dbhelper.query(DBHelper.ELE_CART_TM_NAME);
		electrocartgoodslists=jmelecart.getElecarttoSQLite(ec);
		ec.close();
		SimpleAdapter cartlistItemAdapter=new SimpleAdapter(this,electrocartgoodslists,R.layout.jshop_m_detaillistview,new String[]{"needquantity","goodsname","memberprice"},new int[]{R.id.needquantity,R.id.goodsname,R.id.memberprice});
		cartlistItemAdapter.setViewBinder(new MyElecartViewBinder());
		listViewForCart.setAdapter(cartlistItemAdapter);
		//添加点击
		listViewForCart.setOnItemClickListener(new OnItemClickListener() {

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
	
	public View SimpleListView(String tag){
		collectSqliteGoodsList(tag);
		View view = new View(this);
		SimpleAdapter listItemAdapter=new SimpleAdapter(this,goodslists,R.layout.jshop_m_listforcategory,new String[]{"pictureurl","goodsname","memberprice","weight","detail","unitname"},new int[]{R.id.pictureurl,R.id.goodsname,R.id.memberprice,R.id.weight,R.id.detail,R.id.unitname});
		listItemAdapter.setViewBinder(new MyViewBinder());
		listViews.setAdapter(listItemAdapter);
		//添加点击
		listViews.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				showConfirmAddtoCart(goodslists,arg2);
			}
		});
		listItemAdapter.notifyDataSetChanged();
		return view;
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
				SimpleAdapter listItemAdapter=new SimpleAdapter(this,goodslists,R.layout.jshop_m_listforcategory,new String[]{"pictureurl","goodsname","memberprice","weight","detail","unitname"},new int[]{R.id.pictureurl,R.id.goodsname,R.id.memberprice,R.id.weight,R.id.detail,R.id.unitname});
				listItemAdapter.setViewBinder(new MyViewBinder());
				listViews.setAdapter(listItemAdapter);
				//添加点击
				listViews.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
							long arg3) {
						showConfirmAddtoCart(goodslists,arg2);
					}
				});
				listItemAdapter.notifyDataSetChanged();
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
	 * 商品显示用
	 * @author "chenda"
	 *
	 */
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
	/**
	 * 我的菜单用
	 * @author "chenda"
	 *
	 */
	public class MyElecartViewBinder implements ViewBinder{
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
