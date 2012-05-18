package com.jshop.android.shop;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.jshop.android.index.R;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.shop.JshopActivityGoodsList;
public class JshopActivityShopList extends Activity{
	public static final String ACTION="findAllJshopbasicInfoLogoforAndroid.action";
	private GridView gv;
	
	//存储精品商品json字符串
	private String boutiquesjsonstr;
	private List sitelogolist=new ArrayList();
	private List creatoridlist=new ArrayList();
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_activity_shoplist);
		gv=(GridView)this.findViewById(R.id.shoplistgridView);
		gv.setOnItemClickListener(new ItemClickListener());
		boutiquesjsonstr=this.queryBoutiquesForJshopbasicInfoList();
		if(boutiquesjsonstr==null){
			return;
		}else{
			String []strs=boutiquesjsonstr.split("-");
			try {
				for(int i=0;i<strs.length;i++){
					JSONObject jo=new JSONObject(strs[i].toString());
					String sitelogo=jo.getString("sitelogo");
					String creatorid=jo.getString("creatorid");
					if(sitelogo.indexOf(",")<0){
						sitelogolist.add(sitelogo.toString());
						creatoridlist.add(creatorid.toString());
					}
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gv.setAdapter(new ImageAdapter(this));
		
	}
	
	
	
	
	/**
	 * 获取服务器端的商城基本数据
	 * @return
	 */
	private String queryBoutiquesForJshopbasicInfoList(){
		String url=JshopActivityUtil.BASE_URL+ACTION;
		return JshopActivityUtil.queryStringForPost(url);
	}
	
	public class ImageAdapter extends BaseAdapter{
		private Context mContext;
		
		public ImageAdapter(Context mContext) {
			this.mContext = mContext;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return sitelogolist.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater=LayoutInflater.from(JshopActivityShopList.this);
			View v=null;
			ImageView imageView=new ImageView(this.mContext);
			if(convertView==null){
				v=inflater.inflate(R.layout.jshop_activity_imageview, null);
				
			}else{
				v=(View)convertView;
			}
			imageView=(ImageView)v.findViewById(R.id.imageViewForshoplist);
			try{
				URL url=new URL(sitelogolist.get(position).toString());
				HttpURLConnection conn=(HttpURLConnection)url.openConnection();
				conn.setRequestMethod("GET");
				conn.setConnectTimeout(5*1000);
				InputStream in=conn.getInputStream();
				Bitmap bm=BitmapFactory.decodeStream(in);
				in.close();
				imageView.setImageBitmap(bm);
			}catch(Exception e){
				e.printStackTrace();
			}
			imageView.setPadding(8, 8, 8, 8);
			imageView.setAdjustViewBounds(false);
			
			return v;
		}
		
		
	}
	

	class ItemClickListener implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			//int a=(Integer) arg0.getItemAtPosition(arg2);
			String creatorid=creatoridlist.get(arg2).toString();
			Bundle data=new Bundle();
			data.putString("creatorid", creatorid);
			Intent intent = new Intent(JshopActivityShopList.this,JshopActivityGoodsList.class);
			intent.putExtras(data);
			startActivity(intent);
		}
	}
	   
	
}
