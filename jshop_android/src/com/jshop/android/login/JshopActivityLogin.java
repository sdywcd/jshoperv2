package com.jshop.android.login;

import com.jshop.android.JshopActivity;
import com.jshop.android.index.R;
import com.jshop.android.register.JshopActivityRegister;
import com.jshop.android.util.JshopActivityUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class JshopActivityLogin extends Activity{
	private Button login,register;
	private EditText loginusername,loginpassword;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jshop_activity_login);
		register = (Button)findViewById(R.id.register);
		login = (Button)findViewById(R.id.login);
		loginusername = (EditText)findViewById(R.id.loginusername);
		loginpassword = (EditText)findViewById(R.id.loginpassword);
		login.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				if(validate()){
					if(login()){
						Intent intent = new Intent(JshopActivityLogin.this,JshopActivityLogin.class);
						startActivity(intent);
					}else{
						showDialog("用户名或密码错误");
					}
				}
			}
		});
		register.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Intent intent = new Intent(JshopActivityLogin.this,JshopActivityRegister.class);
				startActivity(intent);
			}
		});
	}
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
	private boolean validate(){
		String username = loginusername.getText().toString();
		if(username.equals("")){
			showDialog("请输入用户名");
			return false;
		}
		String password = loginpassword.getText().toString();
		if(password.equals("")){
			showDialog("请输入密码");
			return false;
		}
		return true;
	}
	private String query(String username,String password){
		String queryString = "?username="+username+"&password="+password;
		String url = JshopActivityUtil.BASE_URL+"loginforAndroid.action"+queryString;
		return JshopActivityUtil.queryStringForPost(url);
	}
	private boolean login(){
		String username = loginusername.getText().toString();
		String password = loginpassword.getText().toString();
		String result = query(username,password);
		if(result!=null&&result.equals("1")){
			return true;
		}else
		{
			return false;
		}
	}
}
