package com.jshop.android.index;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.http.util.EncodingUtils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.sqlite.DBHelper1;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.widget.JshopViewpagerAdapter;
/**
 * 
 * @Description  Android实现左右滑动指引效果
 *
 * @Author "chenda"
 *
 * @File JshopActivityIndex.java
 *
 * @Package com.jshop.android.index
 *
 * @ProjectName jshop_android
 * 
 * @Data 2012-5-9 下午08:41:42
 */
public class JshopActivityIndex extends Activity{
	
	
//	private JshopViewpagerAdapter jViewPagerAdapter=new JshopViewpagerAdapter();
	private ViewPager viewPager;
	private ArrayList<View>pageViews;
	
	private ImageView imageView;
	private ImageView[] imageViews;
	
	private ViewGroup maingroup;//包含滑动的图片组LinearLayout
	private ViewGroup dotgroup;//包裹小圆点的LinearLayout
	private MenuInflater mi;//系统菜单
	
	
	/**
	 * 当系统启动时从的入口方法
	 */
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题窗口
		gethosturl();
		
		LayoutInflater inflater=getLayoutInflater();
		//这里开始从服务器获取通讯地址
		mi=new MenuInflater(this);
		pageViews=new ArrayList<View>();
		pageViews.add(inflater.inflate(R.layout.item01, null));
		pageViews.add(inflater.inflate(R.layout.item02, null));
		pageViews.add(inflater.inflate(R.layout.item03, null));
		pageViews.add(inflater.inflate(R.layout.item06, null));
		
		//pageViews.add(inflater.inflate(R.layout.jshop_activity_register, null));//只要把有数据的布局放入即可滑动
		//服务器地址
//		write("192.168.1.103:8088");
		imageViews=new ImageView[pageViews.size()];
		maingroup=(ViewGroup)inflater.inflate(R.layout.jshop_activity_index, null);
		dotgroup=(ViewGroup)maingroup.findViewById(R.id.dotviewGroup);
		viewPager=(ViewPager)maingroup.findViewById(R.id.guidePages);
		writeJmtable("-1"+",");//写入一个默认餐桌
		for(int i=0;i<pageViews.size();i++){
			imageView=new ImageView(JshopActivityIndex.this);
			imageView.setLayoutParams(new LayoutParams(20,20));
			imageView.setPadding(20, 0, 20, 0);
			imageViews[i]=imageView;
			if(i==0){
				imageViews[i].setBackgroundResource(R.drawable.page_indicator_focused);
			}else{
				imageViews[i].setBackgroundResource(R.drawable.page_indicator);
			}
			dotgroup.addView(imageViews[i]);
		}
		setContentView(maingroup);
		viewPager.setAdapter(new JshopViewpagerAdapter().new JshopActivityIndexViewpagerAdapter(pageViews));
		viewPager.setOnPageChangeListener(new JshopActivityIndexViewpagerPageChangeListener());
	}
	
	 // 指引页面更改事件监听器
    public class JshopActivityIndexViewpagerPageChangeListener  implements OnPageChangeListener {
    	
    	
        @Override  
        public void onPageScrollStateChanged(int arg0) {  
            // TODO Auto-generated method stub  
        }
  
        @Override  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
            // TODO Auto-generated method stub  
        }  
  
        @Override  
        public void onPageSelected(int arg0) {
            for (int i = 0; i < imageViews.length; i++) {  
                imageViews[arg0].setBackgroundResource(R.drawable.page_indicator_focused);
                
                if (arg0 != i) {  
                    imageViews[i].setBackgroundResource(R.drawable.page_indicator);  
                }  
            }
            if(arg0==3){
            	Intent intent = new Intent(JshopActivityIndex.this,JshopMIndex.class);
				startActivity(intent);
            }
        }  
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
	
	//重置db
	private void resetDB(){
		DBHelper dbHelper=new DBHelper(this.getApplicationContext());
		dbHelper.deleteAllData(DBHelper.ELE_CART_TM_NAME);
		dbHelper.close();
	}
	
	
//	//点击进入登录页面
//	private void enterIntoLogin(){
//		Intent intent = new Intent(JshopActivityIndex.this,JshopActivityLogin.class);
//		startActivity(intent);
//	}
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
