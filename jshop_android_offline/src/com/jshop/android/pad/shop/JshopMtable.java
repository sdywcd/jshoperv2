package com.jshop.android.pad.shop;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.jshop.android.pad.R;

import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
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
//	private List tableNumberlist=new ArrayList();
//	private List tablestatelist=new ArrayList();
	private List<Map<String,Object>>tableList=new ArrayList<Map<String,Object>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_table);
		gv=(GridView) this.findViewById(R.id.tablegridView);
		gv.setOnItemClickListener(new ItemClickListener());
		//获取table信息
		getTablelist();
		gv.setAdapter(new ImageAdapter(this));
	}
	
	/**
	 * 向服务器端发送请求获取table信息
	 * @return
	 */
//	private String queryTableForJshop(){
//		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDALLTABLETFORANDROID;
//		return JshopActivityUtil.queryStringForPost(posturl);
//	}
	/**
	 * 更新餐桌使用状
	 * @return
	 */
	private String updateTableTtablestateBytableNo(String tableid,String tablestate){
		String tag="";
		for(int i=0;i<tableList.size();i++){
			if(tableList.get(i).get("tableid").toString().equals(tableid)){
				tableList.get(i).remove("tablestate");
				tableList.get(i).put("tablestate", "1");
				tag="success";
			}
		}
		return tag;
	}
	
	
	/**
	 * 处理服务器端返回的json数据
	 * @throws JSONException 
	 */
	private void getTablelist(){
		for(int i=0;i<8;i++){
			Map<String,Object>map=new HashMap<String,Object>();
			map.put("tableid", "1"+i);
			map.put("tableNumber", 1+i);
			map.put("roomName", "");
			map.put("androidDevicesCount","4");
			map.put("note", "");
			map.put("createtime", "");
			map.put("nop", "4");
			map.put("tablestate", "0");
			map.put("floor", "1楼");
			map.put("rnop", "1");
			tableList.add(map);
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
			if(convertView==null){
				textView=new TextView(mContext);
				textView.setLayoutParams(new GridView.LayoutParams(63,48));
				textView.setPadding(22,8,10,10);
				if(tableList.get(position).get("tablestate").toString().equals("1")){
					textView.setText(tableList.get(position).get("tableNumber").toString());
					textView.setBackgroundResource(imgs[1]);
					if(tableList.get(position).toString().equals("2")){
						textView.setText(tableList.get(position).get("tableNumber").toString());
						textView.setBackgroundResource(imgs[0]);
					}
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
	 * 餐桌列表单击事件触发，显示详细的餐桌信息并�?取此座位
	 * @author "chenda"
	 *
	 */
	public class ItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			getTableinfo(arg2);
		}
		
	}
	
	private void getTableinfo(int index){
		final String ctablestate=tableList.get(index).get("tablestate").toString();
		final String tableid=tableList.get(index).get("tableid").toString();
		LayoutInflater inflater=LayoutInflater.from(this);
		final View vTableinfo=inflater.inflate(R.layout.jshop_m_tabledetail, null);
		TextView tableNumber=(TextView) vTableinfo.findViewById(R.id.tableNumber);
		TextView roomName=(TextView) vTableinfo.findViewById(R.id.roomName);
		TextView floor=(TextView) vTableinfo.findViewById(R.id.floor);
		TextView nop=(TextView) vTableinfo.findViewById(R.id.nop);
		TextView rnop=(TextView) vTableinfo.findViewById(R.id.rnop);
		TextView tablestate=(TextView) vTableinfo.findViewById(R.id.tablestate);
		TextView note=(TextView) vTableinfo.findViewById(R.id.note);
		tableNumber.setText("桌号"+tableList.get(index).get("tableNumber").toString());
		roomName.setText("包厢"+tableList.get(index).get("roomName").toString());
		floor.setText("楼层"+tableList.get(index).get("floor").toString());
		nop.setText("人数"+tableList.get(index).get("nop").toString());
		rnop.setText("就餐人数"+tableList.get(index).get("rnop").toString());
		if(tableList.get(index).get("tablestate").toString().equals("1")){
			tablestate.setText("状态：使用");
		}else{
			tablestate.setText("状态：空闲");
		}
		note.setText("备注"+tableList.get(index).get("note").toString());
		//final String tablestates=tableList.get(index).get("tablestate").toString();
		final String tablenumber=tableList.get(index).get("tableNumber").toString();
		AlertDialog.Builder bulider=new AlertDialog.Builder(this);
		bulider.setMessage("餐桌信息").setCancelable(false).setView(vTableinfo).setPositiveButton(R.string.seattable,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//这里确认座位
				if(ctablestate.equals("1")){
					Toast t=Toast.makeText(getApplicationContext(), "餐桌已经被使用", Toast.LENGTH_LONG);
					t.show();
				}else{
					String tag=updateTableTtablestateBytableNo(tableid,"1");
					if("success".equals(tag)){
						Toast t=Toast.makeText(getApplicationContext(), "就座成功", Toast.LENGTH_LONG);
						t.show();
						
						//携带餐桌号和餐桌状�?传�?给商品分类开始点�?
						writeJmtable("1"+","+tablenumber);
						Intent intent = new Intent(JshopMtable.this,JshopActivityGoodsCategoryList.class);
						startActivity(intent);
					}else{
						Toast t=Toast.makeText(getApplicationContext(), "更新座位状态时系统异常", Toast.LENGTH_LONG);
						t.show();
					}
				}
				
			}
		}).setNegativeButton(R.string.changetable, new DialogInterface.OnClickListener(){
			//这里判断当这个作为是使用
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				if(ctablestate.equals("1")){
					Toast t=Toast.makeText(getApplicationContext(), "当前餐桌正在使用不能更换座位到这", Toast.LENGTH_LONG);
					t.show();
				}else{
					Toast t=Toast.makeText(getApplicationContext(), "请呼叫服务员更换座位", Toast.LENGTH_LONG);
					t.show();
				}
			}
			
		});
		AlertDialog alert=bulider.create();
		alert.show();
	}
	/**
	 * 写文件，保存服务器地
	 * @param content
	 */
	private void writeJmtable(String content){
		try{
			//实例化文件文件输出流
			FileOutputStream fos=openFileOutput(JshopMParams.SHAREMTABLEPARAM,MODE_WORLD_WRITEABLE+MODE_WORLD_WRITEABLE);
			fos.write(content.getBytes());
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
