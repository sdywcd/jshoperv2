package com.jshop.android.index;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.jshop.android.login.JshopActivityLogin;
import com.jshop.android.register.JshopActivityRegister;
import com.jshop.android.search.JshopActivitySearch;
import com.jshop.android.shop.JshopActivityShopList;
import com.jshop.android.util.JshopActivityUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 此类负责菜单的现实，主导航界面
 * @Description TODO
 *
 * @Author "chenda"
 *
 * @File JshopActivityIndexMenu.java
 *
 * @Package com.jshop.android.index
 *
 * @ProjectName jshop_android
 * 
 * @Data 2012-5-10 下午08:41:35
 */
public class JshopActivityIndexMenu extends Activity {

	private Button aboutus,contact,service;
	private TextView contactTextView,register,login;
	private ImageButton boutiques,share,usercenter,search;
	private MenuInflater mi;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_activity_index_menu);
		aboutus=(Button)this.findViewById(R.id.aboutus);
		contact=(Button)this.findViewById(R.id.contact);
		service=(Button)this.findViewById(R.id.service);
		contactTextView=(TextView)this.findViewById(R.id.contactTextView);
		register=(TextView)this.findViewById(R.id.register);
		login=(TextView)this.findViewById(R.id.login);
		boutiques=(ImageButton)this.findViewById(R.id.boutiques);
		
		mi=new MenuInflater(this);
		//定义消息提示时间
		final int longtime=Toast.LENGTH_LONG;
		final String lstr="您可以通过MENU按钮返回首页";
		/**
		 * 点击注册进入注册页面
		 */
		register.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(JshopActivityIndexMenu.this,JshopActivityRegister.class);
				startActivity(intent);
			}
		});
		/**
		 * 点击登录进入登录页面
		 */
		login.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(JshopActivityIndexMenu.this,JshopActivityLogin.class);
				startActivity(intent);
			}
		});
		/**
		 * 点击联系进入联系页面
		 */
		contact.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				int counter=0;
				StringBuilder sb=new StringBuilder();
				Resources r=getResources();
				XmlResourceParser xrp=r.getXml(R.xml.jshop_contact);
				try{
					while(xrp.getEventType()!=XmlResourceParser.END_DOCUMENT){
						if(xrp.getEventType()==XmlResourceParser.START_TAG){
							String name=xrp.getName();
							if(name.equals("contact")){
								counter++;
								sb.append("开发:"+xrp.getAttributeValue(0)+"\n");
								sb.append("网站:"+xrp.getAttributeValue(1)+"\n");
								sb.append("微博:"+xrp.getAttributeValue(2)+"\n");
							}
						}else if(xrp.getEventType()==XmlPullParser.END_TAG){
							
						}else if(xrp.getEventType()==XmlPullParser.TEXT){
							
						}
						xrp.next();
					}
					contactTextView.setText(sb.toString());
				}catch(XmlPullParserException e){
					e.printStackTrace();
				}catch(IOException e){
					e.printStackTrace();
				}
				
				Toast tl=Toast.makeText(getApplicationContext(), lstr, longtime);
				tl.show();
			}	
		});
		
		/**
		 * 点击精品商品按钮
		 */
		boutiques.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(JshopActivityIndexMenu.this,JshopActivityShopList.class);
				startActivity(intent);
			}
			
		});
		
	}
	
	
	/**
	 * 加载系统菜单
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mi.inflate(R.menu.file_menu, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		case R.id.search:
			enterIntoSearch();
			break;
		case R.id.refresh:
			break;
		case R.id.loginmenu:
			enterIntoLogin();
			break;
		case R.id.backtoindex:
			break;
		case R.id.host:
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
	
	//点击进入登录页面
	private void enterIntoLogin(){
		Intent intent = new Intent(JshopActivityIndexMenu.this,JshopActivityLogin.class);
		startActivity(intent);
	}
	
	//进入搜索页面
	private void enterIntoSearch(){
		Intent intent = new Intent(JshopActivityIndexMenu.this,JshopActivitySearch.class);
		startActivity(intent);
	}
	
	//获取服务器端地址
	private void getHostaddress(){
		
	}
	
	
	
	

}
