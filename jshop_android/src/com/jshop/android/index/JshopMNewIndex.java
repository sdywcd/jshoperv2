package com.jshop.android.index;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.http.util.EncodingUtils;

import com.jshop.android.shop.JshopActivityNGoodsList;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.sqlite.DBHelper1;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * new pad ui index 
 * @author chenda
 *
 */
public class JshopMNewIndex extends Activity {
	
	private ImageView sit,ordingfoods,calculator,logo;
	private MenuInflater mi;//系统菜单
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题窗口
		super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏模式
		super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		this.setContentView(R.layout.jshop_m_newindex);
		mi=new MenuInflater(this);
		gethosturl();
		//初始化页面元素
		ordingfoods=(ImageView) this.findViewById(R.id.ordingfoods);
		calculator=(ImageView) this.findViewById(R.id.calculator);
		logo=(ImageView) this.findViewById(R.id.logo);
		sit = (ImageView) this.findViewById(R.id.sit);
		
		//绑定页面元素事件
		/**
		 * 进入点餐页面
		 */
		ordingfoods.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMNewIndex.this, JshopActivityNGoodsList.class);
				
				startActivity(intent);
			}
		});

		/**
		 * 弹出坐席设置
		 */
		sit.setOnClickListener(new OnClickListener(){			
			@Override
			public void onClick(View v){
				setSeat();
			}

		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mi.inflate(R.menu.file_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.search:
			//enterIntoSearch();
			break;
		case R.id.refresh:
			resetDB();
			break;
		case R.id.loginmenu:
			//enterIntoLogin();
			break;
		case R.id.backtoindex:
			break;
		case R.id.host:
			getHost();
			break;
		case R.id.exit:
			exitAlert("真的要退出吗？");
		}
		return super.onOptionsItemSelected(item);
	}
	//显示exit对话框
	private void exitAlert(String msg){
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setMessage(msg).setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int id) {
				finish();
			}
		}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				return;
			}
		});
		AlertDialog alert=builder.create();
		alert.show();
	}
	/**
	 * 提示框
	 * @param msg
	 */
	private void showDialog(String msg){
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
			.setCancelable(false)
			.setPositiveButton("确定", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog,int id){}
			});
		AlertDialog alert = builder.create();
		alert.show();
	}
	private boolean validateserverhost(String serverhost){
		if("".equals(serverhost)){
			showDialog("请输入服务器地址");
			return false;
		}
		return true;
	}
	/**
	 * 获取服务器地址
	 */
	private void getHost(){
		//建立弹出对话框
		//定义服务器地址输入的界面
		LayoutInflater inflater=LayoutInflater.from(this);
		final View vhost=inflater.inflate(R.layout.jshop_m_gethost, null);
		AlertDialog.Builder bulider=new AlertDialog.Builder(this);
		bulider.setMessage("请输入服务器地址").setCancelable(false).setView(vhost).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				// TODO Auto-generated method stub
				//获取服务器地址表单值
				TextView serverhost=(TextView) vhost.findViewById(R.id.serverhost);
				String shost=serverhost.getText().toString();
				//写入文件并保存服务器地址
				if(validateserverhost(shost)){
					write(shost);
				}
				//测试连接
//				String result=jau.readServerhost();
//				showDialog(result);
				
			}
		}).setNegativeButton("取消", null);
		//读取是否有服务器地址
		String oserverhost=read();
		if(oserverhost!=null){
			TextView serverhost=(TextView) vhost.findViewById(R.id.serverhost);
			serverhost.setText(oserverhost);
			//放入静态变量
			JshopActivityUtil.BASE_URL="http://"+oserverhost;
		}
		AlertDialog alert=bulider.create();
		alert.show();
	}
	
	//重置db
	private void resetDB(){
		DBHelper dbHelper=new DBHelper(this.getApplicationContext());
		dbHelper.deleteAllData(DBHelper.ELE_CART_TM_NAME);
		dbHelper.close();
	}
	
	/**
	 * 读取服务器地址
	 */
	public void gethosturl(){
		String oserverhost=read();
		if(oserverhost!=null){
			//放入静态变量
			JshopActivityUtil.BASE_URL="http://"+oserverhost;
		}
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
	/**
	 * 读取服务器地址文件
	 * @return
	 */
	public String read(){
		String res="";
		try{
			FileInputStream fis=openFileInput(JshopMParams.FILENAME);
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
	 * 写文件，保存服务器地址
	 * @param content
	 */
	public void write(String content){
		try{
			//实例化文件文件输出流
			FileOutputStream fos=openFileOutput(JshopMParams.FILENAME,MODE_WORLD_WRITEABLE+MODE_WORLD_WRITEABLE);
			fos.write(content.getBytes());
			fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	/**
	 * 设置客户就座餐桌
	 */
	private void setSeat(){
		//建立弹出框
		AlertDialog.Builder builder;
		AlertDialog alertDialog;
		Context mContext = JshopMNewIndex.this;
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
		final View seatPopupLayout = inflater.inflate(R.layout.jshop_m_popupseat,null);
		builder = new AlertDialog.Builder(mContext);		
		builder.setTitle("荔餐厅").setMessage("输入就座位置").setView(seatPopupLayout).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {

				TextView seatwhere = (TextView) seatPopupLayout.findViewById(R.id.desireseat);
				String lctseat = seatwhere.getText().toString();
				//写入文件并保存坐席
				if(validateserverhost(lctseat)){
					writeSeat(lctseat);
				}
			}
		});
		//读取是否有服务器地址
		String rlcteat =readSeat();
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
	
}

