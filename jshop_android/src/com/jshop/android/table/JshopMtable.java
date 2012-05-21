package com.jshop.android.table;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jshop.android.index.R;
import com.jshop.android.shop.JshopActivityGoodsList;
import com.jshop.android.shop.JshopActivityShopList;
import com.jshop.android.shop.JshopActivityShopList.ItemClickListener;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
/**
 * 餐桌显示
 * @Description TODO
 *
 * @Author "chenda"
 *
 * @File JshopMtable.java
 *
 * @Package com.jshop.android.table
 *
 * @ProjectName jshop_android
 * 
 * @Data 2012-5-15 下午02:24:58
 */
public class JshopMtable extends Activity {
	
	//左右楼层按钮
	private ImageButton floorleftbutton,floorrightbutton;
	private GridView gv;
	
	private String requestjsonstr;
	private List tableNumberlist=new ArrayList();
	private List tablestatelist=new ArrayList();
	private List<Map<String,Object>>tableList=new ArrayList<Map<String,Object>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_table);
		gv=(GridView) this.findViewById(R.id.tablegridView);
		gv.setOnItemClickListener(new ItemClickListener());
		//获取table信息
		try {
			processJsonstrs();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gv.setAdapter(new ImageAdapter(this));
	}
	
	/**
	 * 向服务器端发送请求获取table信息
	 * @return
	 */
	private String queryTableForJshop(){
		String url=JshopActivityUtil.BASE_URL+JshopMPostActionList.FINDALLTABLETFORANDROID;
		return JshopActivityUtil.queryStringForPost(url);
	}
	
	/**
	 * 处理服务器端返回的json数据
	 * @throws JSONException 
	 */
	private void processJsonstrs() throws JSONException{
		requestjsonstr=this.queryTableForJshop();
		if(requestjsonstr!=null){
			String []strs=requestjsonstr.split("--");
			for(int i=0;i<strs.length;i++){
				Map<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=new JSONObject(strs[i].toString());
				map.put("tableNumber", jo.getString("tableNumber"));
				map.put("tablestate", jo.getString("tablestate"));
				tableList.add(map);
			}
		}
	}
	
	
	
	
	
	public class ItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			Intent intent = new Intent(JshopMtable.this,JshopActivityGoodsList.class);
			
			startActivity(intent);
			
		}
		
	}
	
	
	public class ImageAdapter extends BaseAdapter{
		private Integer[]imgs={
				R.drawable.sitbuttonfree,
				R.drawable.sitbuttonoccupied
		};
		
		private Context mContext;
		
		public ImageAdapter(Context mContext) {
			this.mContext = mContext;
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
				textView.setPadding(22,8,0,0);
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
	
}
