package com.jshop.android.table;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
import android.database.Cursor;
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

import com.jshop.android.action.JshopMtableAction;
import com.jshop.android.index.JshopActivityIndex;
import com.jshop.android.index.JshopMIndex;
import com.jshop.android.index.R;
import com.jshop.android.shop.JshopActivityGoodsCategoryList;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.sqlite.DBHelper1;
import com.jshop.android.util.BaseTools;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.widget.JshopGridViewAdapter;
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
	private List<Map<String,Object>>tableList=new ArrayList<Map<String,Object>>();
	private JshopMtableAction jmAction=new JshopMtableAction();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_table);
		gv=(GridView) this.findViewById(R.id.tablegridView);
		gv.setOnItemClickListener(new ItemClickListener());
		final DBHelper dbhelper=new DBHelper(this);
		Cursor c=dbhelper.query(DBHelper.TABLE_TM_NAME);
		tableList=jmAction.getTabletoSQLite(c);
		c.close();
		if(tableList.isEmpty()){
			//获取table信息
			tableList=jmAction.getTablelist();
			//缓存table
			jmAction.setTabletoSQLite(tableList, this.getApplicationContext());
		}
		gv.setAdapter(new JshopGridViewAdapter().new JMTableImageAdapter(this,tableList));
	}
	
	/**
	 * 餐桌列表单击事件触发，显示详细的餐桌信息并选取此座位
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
		tableNumber.setText("桌号："+tableList.get(index).get("tableNumber").toString());
		roomName.setText("包厢："+tableList.get(index).get("roomName").toString());
		floor.setText("楼层："+tableList.get(index).get("floor").toString());
		nop.setText("人数："+tableList.get(index).get("nop").toString());
		rnop.setText("就餐人数："+tableList.get(index).get("rnop").toString());
		if(tableList.get(index).get("tablestate").toString().equals("1")){
			tablestate.setText("状态：使用");
		}else{
			tablestate.setText("状态：空闲");
		}
		note.setText("备注："+tableList.get(index).get("note").toString());
		//final String tablestates=tableList.get(index).get("tablestate").toString();
		final String tablenumber=tableList.get(index).get("tableNumber").toString();
		AlertDialog.Builder bulider=new AlertDialog.Builder(this);
		bulider.setMessage("餐桌信息").setCancelable(false).setView(vTableinfo).setPositiveButton(R.string.seattable,new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				//这里开始确认座位
				if(ctablestate.equals("1")){
					Toast t=Toast.makeText(getApplicationContext(), "餐桌已经被使用", Toast.LENGTH_LONG);
					t.show();
				}else{
					String tag=jmAction.updateTableTtablestateBytableNo(tableid,"1");
					if("success".equals(tag)){
						Toast t=Toast.makeText(getApplicationContext(), "就座成功", Toast.LENGTH_LONG);
						t.show();
						Intent intent = new Intent(JshopMtable.this,JshopActivityGoodsCategoryList.class);
						startActivity(intent);
						
						
						//携带餐桌号和餐桌状态传递给商品分类开始点菜
						writeJmtable("1"+","+tablenumber);
					}else{
						Toast t=Toast.makeText(getApplicationContext(), "更新座位状态时系统异常", Toast.LENGTH_LONG);
						t.show();
					}
				}
				
			}
		}).setNegativeButton(R.string.changetable, new DialogInterface.OnClickListener(){
			//这里判断当这个作为是使用状态就不能更换
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				if(ctablestate.equals("1")){
					Toast t=Toast.makeText(getApplicationContext(), "当前餐桌正在使用不能更换座位到这里", Toast.LENGTH_LONG);
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
	 * 写入一个默认的餐桌值，用来检测未就做即可点菜的问题
	 * @param content
	 */
	public void writeJmtable(String content){
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
