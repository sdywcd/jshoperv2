package com.jshop.android.pad.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.jshop.android.pad.R;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
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
	
		this.getGoodsCategoryList();
		gv.setAdapter(new ImageAdapter(this));
		
	}
	
	/**
	 * 向服务器发�?请求获取商品分类信息
	 */
//	private String queryGoodsCategoryForJshop(){
//		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDALLGOODSCATEGORYTFORANDROID;
//		return JshopActivityUtil.queryStringForPost(posturl);
//	}
	
	/**
	 * 处理服务器端返回的json数据
	 * @throws JSONException 
	 */
	private void getGoodsCategoryList(){
		HashMap<String,Object>map=new HashMap<String,Object>();
		map.put("goodsCategoryTid", "001");
		map.put("grade", "0");
		map.put("name","冷菜");
		map.put("goodsTypeId", "1");
		map.put("sort", "1");
		HashMap<String,Object>map1=new HashMap<String,Object>();
		map1.put("goodsCategoryTid", "002");
		map1.put("grade", "0");
		map1.put("name","点心");
		map1.put("goodsTypeId", "1");
		map1.put("sort", "2");
		HashMap<String,Object>map2=new HashMap<String,Object>();
		map2.put("goodsCategoryTid", "003");
		map2.put("grade", "0");
		map2.put("name","热菜");
		map2.put("goodsTypeId", "1");
		map2.put("sort", "1");
		HashMap<String,Object>map3=new HashMap<String,Object>();
		map3.put("goodsCategoryTid", "004");
		map3.put("grade", "0");
		map3.put("name","饮料");
		map3.put("goodsTypeId", "1");
		map3.put("sort", "1");
		
		goodscategoryList.add(map);
		goodscategoryList.add(map1);
		goodscategoryList.add(map2);
		goodscategoryList.add(map3);
		
		
	}
	
	public class ImageAdapter extends BaseAdapter{
		private Integer[]imgs={
				R.drawable.colddish,
				R.drawable.hotdish,
				R.drawable.dessert,
				R.drawable.drink
		};
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
				textView.setText(goodscategoryList.get(position).get("name").toString());
				textView.setBackgroundResource(imgs[position]);
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
			//此处进入商品程序读取商品列表
			Intent intent = new Intent(JshopActivityGoodsCategoryList.this,JshopActivityGoodsList.class);
			intent.putExtra("goodsCategoryTid", goodscategoryList.get(arg2).get("goodsCategoryTid").toString());
			startActivity(intent);
			
			
		}
	}
	   
	
}
