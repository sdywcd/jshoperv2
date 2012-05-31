package com.jshop.android.shop;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import android.widget.TextView;

import com.jshop.android.index.R;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.shop.JshopActivityGoodsList;
public class JshopActivityGoodsCategoryList extends Activity{
	private GridView gv;
	private String requestjsonstr;
	private List<Map<String,Object>>goodscategoryList=new ArrayList<Map<String,Object>>();
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_goodscategory);
		gv=(GridView)this.findViewById(R.id.goodscategorygridView);
		gv.setOnItemClickListener(new ItemClickListener());
		try {
			this.getGoodsCategoryList();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gv.setAdapter(new ImageAdapter(this));
		
	}
	
	/**
	 * 向服务器发送请求获取商品分类信息
	 */
	private String queryGoodsCategoryForJshop(){
		String posturl=JshopActivityUtil.BASE_URL+JshopMPostActionList.FINDALLGOODSCATEGORYTFORANDROID;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	/**
	 * 处理服务器端返回的json数据
	 * @throws JSONException 
	 */
	private void getGoodsCategoryList() throws JSONException{
		requestjsonstr=this.queryGoodsCategoryForJshop();
		if(requestjsonstr!=null){
			String []strs=requestjsonstr.split("--");
			for(int i=0;i<strs.length;i++){
				JSONObject jo=new JSONObject(strs[i].toString());
				if(jo.getString("grade").equals("0")){
					Map<String,Object>map=new HashMap<String,Object>();
					map.put("goodsCategoryTid", jo.getString("goodsCategoryTid"));
					map.put("grade", jo.getString("grade"));
					map.put("name", jo.getString("name"));
					map.put("goodsTypeId", jo.getString("goodsTypeId"));
					map.put("sort", jo.getString("sort"));
					goodscategoryList.add(map);
				}
				
			}
		}
	}
	
	public class ImageAdapter extends BaseAdapter{
		private Context mContext;
		
		public ImageAdapter(Context mContext) {
			this.mContext = mContext;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return goodscategoryList.size();
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
			TextView textView;
			if(convertView==null){
				textView=new TextView(mContext);
				textView.setLayoutParams(new GridView.LayoutParams(100,100));
				textView.setPadding(22,8,10,10);
				//textView.setTextColor(R.color.white);
				textView.setText(goodscategoryList.get(position).get("name").toString());
			}else{
				textView=(TextView)convertView;
			}
			return textView;
		}
		
		
	}
	

	public class ItemClickListener implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
//			Bundle data=new Bundle();
//			data.putString("creatorid", creatorid);
//			Intent intent = new Intent(JshopActivityGoodsCategoryList.this,JshopActivityGoodsList.class);
//			intent.putExtras(data);
//			startActivity(intent);
			//此处进入商品程序读取商品列表传递分类信息
		}
	}
	   
	
}
