package com.jshop.android.index;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.http.util.EncodingUtils;

import com.jshop.android.shop.JshopActivityGoodsCategoryList;
import com.jshop.android.shop.JshopActivityGoodsList;
import com.jshop.android.shop.JshopActivityGoodsListViewPager;
import com.jshop.android.shop.JshopMelectrocart;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.sqlite.DBHelper1;
import com.jshop.android.table.JshopMtable;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * 餐饮系统主界面
 * 
 * @Description TODO
 * 
 * @Author "chenda"
 * 
 * @File JshopMIndex.java
 * 
 * @Package com.jshop.android.index
 * 
 * @ProjectName jshop_android
 * 
 * @Data 2012-5-14 下午01:27:46
 */
public class JshopMIndex extends Activity {

	private ImageButton sit, ordingfoods, checkout, calculator, callservice,vipcenter;
	private MenuInflater mi;//系统菜单
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setTitle(JshopMParams.SYSTEMNAME.toString());
		this.setContentView(R.layout.jshop_m_index);
		sit = (ImageButton) this.findViewById(R.id.sit);
		ordingfoods = (ImageButton) this.findViewById(R.id.ordingfoods);
		checkout = (ImageButton) this.findViewById(R.id.checkout);
		calculator = (ImageButton) this.findViewById(R.id.calculator);
		callservice = (ImageButton) this.findViewById(R.id.callservice);
		vipcenter = (ImageButton) this.findViewById(R.id.vipcenter);
		mi=new MenuInflater(this);
		gethosturl();
		/**
		 * 点击sit按钮时进入餐桌页面
		 */
		sit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMIndex.this, JshopMtable.class);
				startActivity(intent);
			}

		});
		sit.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					// 更改为按下时的背景图片
					v.setBackgroundResource(R.drawable.findsitsnormal);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					// 改为抬起时的图片
					v.setBackgroundResource(R.drawable.findsitshover);
				}
				return false;
			}
		});
		/**
		 * 点击进入点餐页面
		 */
		ordingfoods.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMIndex.this,JshopActivityGoodsCategoryList.class);
				startActivity(intent);
					
			}

		});
		/**
		 * 点击进入结算页面
		 */
		checkout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMIndex.this,JshopMelectrocart.class);
				startActivity(intent);
					
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
		AlertDialog.Builder bulider=new AlertDialog.Builder(this);
		bulider.setMessage(msg).setCancelable(false).setPositiveButton("确定", new DialogInterface.OnClickListener() {
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
		AlertDialog alert=bulider.create();
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
		dbHelper.DropDB();
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
	
}
