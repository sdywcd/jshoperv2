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
	private String queryGoodsCategoryForJshop(){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDALLGOODSCATEGORYTFORANDROID;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	/**
	 * 处理服务器端返回的json数据
	 * @throws JSONException 
	 */
	private void getGoodsCategoryList(){
		requestjsonstr=this.queryGoodsCategoryForJshop();
		if(requestjsonstr!=null){
			JSONArray ja=(JSONArray)JSONValue.parse(requestjsonstr);
			for(int i=0;i<ja.size();i++){
				JSONObject jo=(JSONObject)(ja.get(i));
				if(jo.get("grade").toString().equals("0")){
					HashMap<String,Object>map=new HashMap<String,Object>();
					map.put("goodsCategoryTid", jo.get("goodsCategoryTid").toString());
					map.put("grade", jo.get("grade").toString());
					map.put("name", jo.get("name").toString());
					map.put("goodsTypeId", jo.get("goodsTypeId").toString());
					map.put("sort", jo.get("sort").toString());
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
			//此处进入商品程序读取商品列表传�?分类信息
			Intent intent = new Intent(JshopActivityGoodsCategoryList.this,JshopActivityGoodsList.class);
			intent.putExtra("goodsCategoryTid", goodscategoryList.get(arg2).get("goodsCategoryTid").toString());
			startActivity(intent);
			
			
		}
	}
	   
	
}
