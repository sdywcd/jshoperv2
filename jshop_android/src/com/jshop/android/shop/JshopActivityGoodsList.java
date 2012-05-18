package com.jshop.android.shop;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TabHost;
import android.widget.TextView;

import com.jshop.android.index.JshopMIndex;
import com.jshop.android.index.JshopMIndexbottom;
import com.jshop.android.index.JshopMIndexcenter;
import com.jshop.android.index.JshopMIndexmsgconfirm;
import com.jshop.android.index.R;
import com.jshop.android.login.JshopActivityLogin;
import com.jshop.android.register.JshopActivityRegister;
import com.jshop.android.table.JshopMtable;
import com.jshop.android.util.JshopActivityUtil;
/**
 * 测试tab包含多个activty
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
public class JshopActivityGoodsList extends TabActivity{
	public static final String ACTION="findAllGoodsByismobileplatformgoodsforAndroid";
	
	private String goodsstrs;
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();
	
	//页卡内容
	private ViewPager mPager;
	//tab页面列表
	private List<View>listViews;
	//动画图片
	private ImageView cursor;
	//页卡投标
	private TextView t1,t2,t3;//可能需要从服务器动态获取
	//动画图片偏移量
	private int offset=0;
	//动画图片宽度
	private int bmpW;
	//当前页卡编号
	private int currIndex=0;
	private LocalActivityManager manager=null;
	private final static String TAG="JshopActivityGoodsList";
	private final Context context=JshopActivityGoodsList.this;
	private TabHost mTabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.jshop_activity_goodlisttest);
//		mTabHost=this.getTabHost();
//		mTabHost.addTab(mTabHost.newTabSpec("1").setIndicator("").setContent(new Intent(this,JshopMIndex.class)));
//		mTabHost.addTab(mTabHost.newTabSpec("2").setIndicator("").setContent(new Intent(this,JshopMtable.class)));
//		mTabHost.addTab(mTabHost.newTabSpec("3").setIndicator("").setContent(new Intent(this,JshopMIndexbottom.class)));
//		mTabHost.setCurrentTab(0);
		manager=new LocalActivityManager(this,true);
		manager.dispatchCreate(savedInstanceState);
		InitImageView();
		InitTextView();
		InitViewPager();
//		Intent intent=this.getIntent();
//		String creatorid=intent.getStringExtra("creatorid");
//		goodsstrs=this.queryGoodsList(creatorid);
//		if(goodsstrs==null){
//			return;
//		}else{
//			String []strs=goodsstrs.split("-");
//			try{
//				for(int i=0;i<strs.length;i++){
//					JSONObject jo=new JSONObject(strs[i].toString());
//					String goodsid=jo.getString("goodsid");
//					String pictureurl=jo.getString("pictureurl");
//					String goodsname=jo.getString("goodsname");
//					String memberprice=jo.getString("memberprice");
//					if(pictureurl.indexOf(",")<0){
//						HashMap<String, Object> list = new HashMap<String, Object>(); 
//						Bitmap bm=getPictureurlImg(pictureurl);
//						list.put("pictureurl", bm);
//						list.put("goodsname", goodsname);
//						list.put("memberprice", memberprice);
//						list.put("goodsid", goodsid);
//						goodslists.add(list);
//					}
//				}
//			}catch (JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		SimpleAdapter sap=new SimpleAdapter(this,goodslists,R.layout.jshop_activity_goodsoutline,new String[]{"pictureurl","goodsname","memberprice"},new int[]{R.id.smallpictureurlimageView,R.id.goodsname,R.id.memberprice});
//		sap.setViewBinder(new MyViewBinder());
		//this.setListAdapter(sap);
	}
	
	
	/**
	 * 初始化光标
	 */
	private void InitTextView(){
		t1=(TextView)this.findViewById(R.id.text1);
		t2=(TextView)this.findViewById(R.id.text2);

		
		t1.setOnClickListener(new MyonClickListener(0));
		t2.setOnClickListener(new MyonClickListener(1));

	}
	
	/**
	 * 光标点击监听
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
	 * @Data 2012-5-10 下午07:32:40
	 */
	public class MyonClickListener implements OnClickListener{
		private int index=0;
		
		public MyonClickListener(int i){
			index=i;
		}
		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
			
		}
		
	}
	
	/**
	 * 初始化动画
	 */
	private void InitImageView(){
		cursor=(ImageView)this.findViewById(R.id.cursor);
		bmpW=BitmapFactory.decodeResource(getResources(), R.drawable.page_indicator).getWidth();
		DisplayMetrics dm=new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW=dm.widthPixels;
		offset=(screenW/3-bmpW)/2;
		Matrix matrix=new Matrix();
		matrix.postTranslate(offset, 0);
		cursor.setImageMatrix(matrix);
	}
	
	/**
	 * 初始化ViewPager
	 */
	private void InitViewPager(){
		mPager=(ViewPager)this.findViewById(R.id.vPager);
		listViews=new ArrayList<View>();
		MyPagerAdapter mpAdapter=new MyPagerAdapter(listViews);
		Intent intent=new Intent(context,JshopMIndex.class);
		listViews.add(getView("Black",intent));
		Intent intent2=new Intent(context,JshopMtable.class);
		listViews.add(getView("Gray",intent2));
		Intent intent3=new Intent(context,JshopMIndexbottom.class);
		listViews.add(getView("Gray",intent3));
		Intent intent4=new Intent(context,JshopMIndexcenter.class);
		listViews.add(getView("Gray",intent4));
		Intent intent5=new Intent(context,JshopMIndexmsgconfirm.class);
		listViews.add(getView("Gray",intent5));
		Intent intent6=new Intent(context,JshopMGoodsdetail.class);
		listViews.add(getView("Gray",intent6));
		mPager.setAdapter(mpAdapter);
		mPager.setCurrentItem(0);
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	
	/**
	 *  ViewPager适配器
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
	 * @Data 2012-5-10 下午07:52:59
	 */
	public class MyPagerAdapter extends PagerAdapter{
		public List<View> mListViews;
		
		public MyPagerAdapter(List<View> mListViews) {
			this.mListViews=mListViews;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager)container).removeView(mListViews.get(position));
		}

		@Override
		public void finishUpdate(View container) {
			// TODO Auto-generated method stub
			super.finishUpdate(container);
		}

		@Override
		public Object instantiateItem(View container, int position) {
			((ViewPager) container).addView(mListViews.get(position), 0);
			return mListViews.get(position);
		}

		@Override
		public void setPrimaryItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			super.setPrimaryItem(container, position, object);
		}

		@Override
		public int getCount() {
			return mListViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==(arg1);
		}

		@Override
		public void restoreState(Parcelable state, ClassLoader loader) {
			// TODO Auto-generated method stub
			super.restoreState(state, loader);
		}

		@Override
		public void startUpdate(View container) {
			// TODO Auto-generated method stub
			super.startUpdate(container);
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return super.saveState();
		}
		
		
		
	}
	
	private View getView(String id,Intent intent){
		return manager.startActivity(id, intent).getDecorView();
	}
	
	/**
	 * 页卡切换监听
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
	 * @Data 2012-5-10 下午07:56:59
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener{
		int one = offset * 2 + bmpW;// 页卡1 -> 页卡2 偏移量
		int two = one * 2;// 页卡1 -> 页卡3 偏移量
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
//			Animation animation=null;
//			Intent intent=new Intent();
//			switch(arg0){
//			case 0:
//				mTabHost.setCurrentTab(0);
//				if(currIndex==1){
//					animation=new TranslateAnimation(one,0,0,0);
//				}else if(currIndex==2){
//					animation=new TranslateAnimation(two,0,0,0);
//				}
//				break;
//			case 1:
//				mTabHost.setCurrentTab(1);
//				if(currIndex==0){
//					animation=new TranslateAnimation(offset,one,0,0);
//				}else if(currIndex==2){
//					animation=new TranslateAnimation(two,one,0,0);
//				}
//				break;
//			}
//			currIndex=arg0;
//			animation.setFillAfter(true);
//			animation.setDuration(300);
//			cursor.startAnimation(animation);
			
		}
		
	}
	
	
//	public class MyViewBinder implements ViewBinder{
//
//		@Override
//		public boolean setViewValue(View view, Object data, String text) {
//			if((view instanceof ImageView)&&(data instanceof Bitmap)){
//				ImageView iv=(ImageView)view;
//				Bitmap bm=(Bitmap)data;
//				iv.setImageBitmap(bm);
//				return true;
//			}
//			return false;
//		}
//		
//	}
//	@Override
//	protected void onListItemClick(ListView l,View v,int position,long id){
//		Intent intent=null;
//		String goodsid=goodslists.get(position).get("goodsid").toString();
//		Bundle data=new Bundle();
//		data.putString("goodsid", goodsid);
//		intent = new Intent(JshopActivityGoodsList.this,JshopActivityGoodsdetail.class);
//		intent.putExtras(data);
//		startActivity(intent);
//	}
//	
//	private Bitmap getPictureurlImg(String pictureurl) throws IOException{
//		URL url=new URL(pictureurl);
//		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
//		conn.setRequestMethod("GET");
//		conn.setConnectTimeout(5*1000);
//		InputStream in=conn.getInputStream();
//		Bitmap bm=BitmapFactory.decodeStream(in);
//		in.close();
//		return bm;
//	}
//	/**
//	 * 获取服务器的商品列表数据
//	 * @return
//	 */
//	private String queryGoodsList(String param){
//		String url=JshopActivityUtil.BASE_URL+ACTION+"?creatorid="+param;
//		return JshopActivityUtil.queryStringForPost(url);
//	}
//	
//	
	
	
	
	

}
