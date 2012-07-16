package com.jshop.android.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jshop.android.index.R;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class JshopGridViewAdapter extends Activity {
	
	public class JMTableImageAdapter extends BaseAdapter{
		private List<Map<String,Object>>tableList=new ArrayList<Map<String,Object>>();
		
		private Integer[]imgs={
				R.drawable.sitbuttonfree,
				R.drawable.sitbuttonoccupied
		};
		
		private Context mContext;
		
		
		public JMTableImageAdapter(Context mContext,List<Map<String,Object>>tl) {
			this.mContext = mContext;
			this.tableList=tl;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return tableList.size();
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
			//ImageView imageView;
			if(convertView==null){
				//imageView=new ImageView(mContext);
				//imageView.setLayoutParams(new GridView.LayoutParams(85,85));
				//imageView.setAdjustViewBounds(false);
				//imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				//imageView.setPadding(8, 8, 8, 8);
				textView=new TextView(mContext);
				textView.setLayoutParams(new GridView.LayoutParams(63,48));
				textView.setPadding(22,8,10,10);
				if(tableList.get(position).get("tablestate").toString().equals("1")){
					textView.setText(tableList.get(position).get("tableNumber").toString());
					textView.setBackgroundResource(imgs[1]);
					
				}else{
					textView.setText(tableList.get(position).get("tableNumber").toString());
					textView.setBackgroundResource(imgs[0]);
				}
			}else{
				textView=(TextView)convertView;
			}
			
			return textView;
		}
	}
	
	/**
	 * 商品分类gridview
	 * @author "chenda"
	 *
	 */
	public class JMGoodscategoryListImageAdapter extends BaseAdapter{
		private List<Map<String,Object>>goodscategoryList=new ArrayList<Map<String,Object>>();
		private Context mContext;
		
		public JMGoodscategoryListImageAdapter(Context mContext,List<Map<String,Object>> gl) {
			this.mContext = mContext;
			this.goodscategoryList=gl;
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
	
	
}
