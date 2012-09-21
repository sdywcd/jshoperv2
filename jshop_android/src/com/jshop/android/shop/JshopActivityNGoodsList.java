package com.jshop.android.shop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.util.EncodingUtils;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
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
import android.widget.RelativeLayout;
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
import com.jshop.android.index.JshopMNewIndex;
import com.jshop.android.index.R;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.util.Arith;
import com.jshop.android.util.ChangeTheme;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopTabHostViewPagerAdapter;
import com.jshop.android.util.myOnPageChangeListener;
import com.jshop.android.widget.JshopListViewAdapter;

public class JshopActivityNGoodsList extends TabActivity  implements TabContentFactory{
	//sqllite数据库对象
	private final DBHelper dbhelper=new DBHelper(this);
	//tabhost 对象
	private String[]tabTitle=null;
	//viewpager 对象
	private ViewGroup maingroup;
	private ViewPager viewPager;
	private ArrayList<View>pageViews = new ArrayList<View>();
	//viewpager中的控件对象
	private ImageView addtomyelecartmenu;//加入我的菜单按钮
	//tabhost下每个tab页对应的商品列表保存对象
	private ListView listViews;//used by goodslist
	//我的菜单保存对象
	private ListView listViewForCart;//used by cartlist
	private TextView totalmemberprice;//显示我的菜单总价
	private TextView seatTextView;//显示座位
	private TextView seatSetTextView;//设置座位
	private TextView changeviewlooking;//变换视图模式
	private TextView clearlistTextView;//清空列表
	private static int focusTabhostResId,normalTabhostResId;
	private Double total=0.0;
	//保存商品分类数据对象
	private List<Map<String,Object>>goodscategoryList=new ArrayList<Map<String,Object>>();
	//保存我的菜单数据对象
	private ArrayList<HashMap<String, Object>> electrocartgoodslists = new ArrayList<HashMap<String, Object>>();
	//保存商品列表数据对象
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();
	//保存图片列表数据对象
	private ArrayList<HashMap<String, Object>> piclist = new ArrayList<HashMap<String, Object>>();
	//商品分类数据操作集合
	private JshopMgoodscategoryListAction jmgclAction=new JshopMgoodscategoryListAction();
	//商品列表数据操作集合
	private JshopMGoodsListAction jmGoodslistAction=new JshopMGoodsListAction();
	//我的菜单数据操作集合
	private JshopMelectrocartAction jmelecart=new JshopMelectrocartAction();
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ChangeTheme.onActivityCreateSetTheme(this);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题窗口
		super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏模式
		super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		this.setContentView(R.layout.jshop_m_newgoodslist);
		Resources res = getResources();
		BitmapDrawable background = (BitmapDrawable) res.getDrawable(R.drawable.seat9pacth);//座位的背景图
		background.setTileModeX(Shader.TileMode.REPEAT);
		listViews=(ListView)this.findViewById(R.id.listViewfornewgoods);//商品列表的listview
		listViewForCart=(ListView)this.findViewById(R.id.listViewforelecart);//我的菜单listview
		LayoutInflater inflater=getLayoutInflater();
		maingroup=(ViewGroup) inflater.inflate(R.layout.jshop_m_goodslistviewpager, null);
		viewPager =(ViewPager) this.findViewById(R.id.goodsViewPagers);//菜单ViewPager
				
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
		//int tabhostResId;
		switch(ChangeTheme.getsTheme()){
			default:
			case 0:
				focusTabhostResId = this.getResources().getIdentifier("shape_tabbg_bl","drawable", this.getPackageName());	
				normalTabhostResId = this.getResources().getIdentifier("shape_tabbg_bl_normal","drawable", this.getPackageName());	
				break;
			case 1:
				focusTabhostResId = this.getResources().getIdentifier("shape_tabbg_or","drawable", this.getPackageName());
				normalTabhostResId = this.getResources().getIdentifier("shape_tabbg_or_normal","drawable", this.getPackageName());
				break;
			case 2:
				focusTabhostResId = this.getResources().getIdentifier("shape_tabbg_gr","drawable", this.getPackageName());
				normalTabhostResId = this.getResources().getIdentifier("shape_tabbg_gr_normal","drawable", this.getPackageName());
				break;
		}
		if(tabTitle!=null){
			final TabHost th = getTabHost();
			for(int i = 0; i < tabTitle.length;i++){
				LinearLayout view = (LinearLayout) getLayoutInflater().inflate(R.layout.jshop_m_textfortabtitle,null);
				((TextView) view.findViewById(R.id.tv_title)).setText(tabTitle[i]);
				th.addTab(th.newTabSpec(tabTitle[i]).setIndicator(view).setContent(this));
				th.getTabWidget().getChildAt(i).setBackgroundResource(normalTabhostResId);
			}
			th.getTabWidget().getChildAt(th.getCurrentTab()).setBackgroundResource(focusTabhostResId);
			th.setOnTabChangedListener(new OnTabChangeListener(){

				@Override
				public void onTabChanged(String tabId) {
					// TODO Auto-generated method stub
					SimpleListView(tabId);
					
					   // 设置tab颜色为蓝色
			        for (int i = 0; i < th.getTabWidget().getChildCount(); i++) {
			        	th.getTabWidget().getChildAt(i).setBackgroundResource(normalTabhostResId);
			            View tempView= th.getTabWidget().getChildAt(i);

			        }
			        // 设置当前tab颜色为绿色
			        th.getTabWidget().getChildAt(th.getCurrentTab()).setBackgroundResource(focusTabhostResId);

			        listViews.setVisibility(View.VISIBLE);
				}
				
			});
		}
		seatTextView = (TextView)this.findViewById(R.id.seatnum);
		String text =  readSeat();
		seatTextView.setText(text);
		
		seatSetTextView = (TextView)this.findViewById(R.id.setseat);
		seatSetTextView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setSeat();
			}

		});
		clearlistTextView = (TextView)this.findViewById(R.id.clearlist);
		clearlistTextView.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				clearList();
			}
			
		});

		
	}

	/**
	 * 清空订单列表
	 */
	private void clearList(){
		AlertDialog.Builder bulider=new AlertDialog.Builder(this);
		bulider.setMessage("确定清空点菜列表吗?").setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				clearElecartList();
			}
		}).setNegativeButton("取消", null);
		AlertDialog alert=bulider.create();
		alert.show();
	}
	/**
	 * 设置座位
	 */
	private void setSeat(){
		AlertDialog.Builder builder;
		AlertDialog alertDialog;
		Context mContext = JshopActivityNGoodsList.this;
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
		final View seatPopupLayout = inflater.inflate(R.layout.jshop_m_popupseat,null);
		builder = new AlertDialog.Builder(mContext);		
		builder.setTitle("荔餐厅").setMessage("输入就座位置").setView(seatPopupLayout).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {

				TextView seatwhere = (TextView) seatPopupLayout.findViewById(R.id.desireseat);
				String lctseat = seatwhere.getText().toString();
				//写入文件并保存坐席
				
				writeSeat(lctseat);
				String rlcteat =  readSeat();
				seatTextView.setText(rlcteat);

			}
		});
		String rlcteat =  readSeat();
		if(rlcteat!=null){
			TextView seatwhere=(TextView) seatPopupLayout.findViewById(R.id.desireseat);
			seatwhere.setText(rlcteat);
		}
		alertDialog = builder.create();
		alertDialog.show();
	}

	/**
	 * 写文件，保存就座位置
	 * @param content
	 */
	public void writeSeat(String content){
		try{
			//实例化文件文件输出流
			FileOutputStream fos=openFileOutput(JshopMParams.SEATPLACE,MODE_WORLD_WRITEABLE+MODE_WORLD_WRITEABLE);
			fos.write(content.getBytes());
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取座位文件
	 * @return
	 */
	public String readSeat(){
		String res="";
		try{
			FileInputStream fis=openFileInput(JshopMParams.SEATPLACE);
			byte[]buffer=new byte[fis.available()];
			fis.read(buffer);
			res=EncodingUtils.getString(buffer,"UTF-8");
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
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
	 * 清空我的菜单数据
	 */
	public void clearElecartList(){
		
		dbhelper.deleteAllData(DBHelper.ELE_CART_TM_NAME);
	
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
	
	/**
	 * 根据商品分类名称获取商品列表
	 * @param tag
	 */
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
					Html.fromHtml(list.get(position).get("detail").toString()));
			holder.getAddtomyelecartmenu().setOnClickListener(
					new OnClickListener() {
						@Override
						public void onClick(View v) {
							showConfirmAddtoCart(list,
									position);
							
						}
					});
			holder.getPictureurl().setOnClickListener(
					new OnClickListener(){

						@Override
						public void onClick(View v) {
							listViews.setVisibility(View.GONE);
							try {
								startViewPager(list,position);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
//							Intent intent = new Intent(JshopActivityNGoodsList.this,JshopActivityNGoodsViewPager.class);
//							intent.putExtra("curposition",list.get(position));
//							intent.putExtra("goodsCategoryTid", list.get(position).get("goodsCategoryTid").toString());
//							startActivity(intent);
							
/*							AlertDialog.Builder builder;
							AlertDialog alertDialog;
							Context mContext = JshopActivityNGoodsList.this;
							LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
						
							
							final View bigpicPopupLayout = inflater.inflate(R.layout.jshop_m_bigpic,null);
							builder = new AlertDialog.Builder(mContext);
							ImageView bigpicview = (ImageView) bigpicPopupLayout.findViewById(R.id.bigpic);
						
							
							String goodsid = list.get(position).get("goodsid").toString();
							Cursor c = dbhelper.queryByParamgoodsid(dbhelper.GOODS_TM_NAME,goodsid);
							try {
								piclist =  jmGoodslistAction.GetPicArrayList(c);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Bitmap picurl = (Bitmap) piclist.get(0).get("pictureurl");							
							bigpicview.setImageBitmap(picurl);
							builder.setTitle("荔餐厅")
								   //.setMessage(list.get(position).get("goodsname").toString())
								   .setView(bigpicPopupLayout);
								   //.setNegativeButton("关闭",null);
							final AlertDialog alert = builder.create();
							bigpicview.setOnClickListener(new OnClickListener(){

								@Override
								public void onClick(View v) {
									// TODO Auto-generated method stub
									alert.dismiss();
								}
								
							});
							alert.show();*/
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
	public void startViewPager(final ArrayList<HashMap<String, Object>> goodslists,final int position) throws IOException{
		LayoutInflater inflater=getLayoutInflater();
		JshopMGoodsListAction jmGoodsListAction = new JshopMGoodsListAction();
		
		if(!goodslists.isEmpty()){
			pageViews.clear();
		}
		Cursor c = dbhelper.queryByParamgoodsCategoryTid(dbhelper.GOODS_TM_NAME,goodslists.get(position).get("goodsCategoryTid").toString());
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		list = jmGoodslistAction.getGoodsListSQLiteNoBitmap(c);
		c.close();
		//GoodsListViewHolder holder = new GoodsListViewHolder();
/*		for(int i = 0;i<goodslists.size();i++){
			final int curposition = i;
			View v=(View)inflater.inflate(R.layout.jshop_m_forgoodsviewpager, null);
			holder.setPictureurl((ImageView) v.findViewById(R.id.goodsimage));
			holder.setGoodsname((TextView) v.findViewById(R.id.goodsname));
			holder.setWeight((TextView) v.findViewById(R.id.valueweight));
			holder.setUnitname((TextView) v.findViewById(R.id.unit));
			holder.setMemberprice((TextView) v.findViewById(R.id.memprice));
			holder.setDetail((TextView) v.findViewById(R.id.goodsdetail));
			holder.setAddtomyelecartmenu((ImageView) v.findViewById(R.id.addtomyelecartmenu));
			pageViews.add(v);
		}*/
		//setContentView(maingroup);
		JshopTabHostViewPagerAdapter testadapter = new JshopTabHostViewPagerAdapter(list);
		viewPager.setAdapter(testadapter);
		viewPager.setCurrentItem(position);
		viewPager.setOnPageChangeListener(new myOnPageChangeListener());
		viewPager.setVisibility(View.VISIBLE);
		
		//viewPager.setAdapter(new JshopTabHostViewPagerAdapter(goodslists,position));
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
			//this.list.clear();
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
	public class JshopTabHostViewPagerAdapter extends PagerAdapter {
		private ArrayList<View> mListViews;
		private Context ctx;
		private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();
		private GoodsListViewHolder holder = new GoodsListViewHolder();
		//private JshopMGoodsListAction jmGoodsListAction = new JshopMGoodsListAction();
		public JshopTabHostViewPagerAdapter(ArrayList<HashMap<String, Object>> goodslists){
			this.goodslists = goodslists;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return goodslists.size();
		}

		@Override
		public Object instantiateItem(View container, final int position) {
			// TODO Auto-generated method stub

			//View v = new View(ctx);
			LayoutInflater inflater=getLayoutInflater();
			//holder.getPictureurl().setImageBitmap(jmGoodsListAction.GetLocalOrNetBitmapWithoutScale(goodslists.get(position).get("pictureurl").toString()));
			View v=(View)inflater.inflate(R.layout.jshop_m_forgoodsviewpager, null);
			holder.setPictureurl((ImageView) v.findViewById(R.id.goodsimage));
			holder.setGoodsname((TextView) v.findViewById(R.id.goodsname));
			holder.setWeight((TextView) v.findViewById(R.id.valueweight));
			holder.setUnitname((TextView) v.findViewById(R.id.unit));
			holder.setMemberprice((TextView) v.findViewById(R.id.memprice));
			holder.setDetail((TextView) v.findViewById(R.id.goodsdetail));
			holder.setAddtomyelecartmenu((ImageView) v.findViewById(R.id.addtomyelecartmenu));
			
			try {
				holder.getPictureurl().setImageBitmap((Bitmap) JshopMGoodsListAction.GetLocalOrNetBitmapWithoutScale(goodslists.get(position).get("pictureurl").toString()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			holder.getGoodsname().setText(goodslists.get(position).get("goodsname").toString());
			holder.getWeight().setText(goodslists.get(position).get("weight").toString());
			holder.getMemberprice().setText(goodslists.get(position).get("memberprice").toString());
			holder.getUnitname().setText(goodslists.get(position).get("unitname").toString());
			holder.getDetail().setText(Html.fromHtml(goodslists.get(position).get("detail").toString()));
			holder.getAddtomyelecartmenu().setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				showConfirmAddtoCart(goodslists,position);
			}
		 });
			((ViewPager) container).addView(v);
			return v;
		}
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
			//return false;
		}
		
		@Override
		public void setPrimaryItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			//getGoodsDetail(goodslists,position);
			super.setPrimaryItem(container, position, object);
		}
		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(container);
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
		public void notifyDataSetChanged() {
			// TODO Auto-generated method stub
			super.notifyDataSetChanged();
		}
		@Override
		public void restoreState(Parcelable state, ClassLoader loader) {
			// TODO Auto-generated method stub
			super.restoreState(state, loader);
		}
		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return super.saveState();
		}
		
	}
}
