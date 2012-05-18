package com.jshop.android.register;

import com.jshop.android.login.JshopActivityLogin;
import com.jshop.android.index.R;
import com.jshop.android.util.JshopActivityUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JshopActivityRegister extends Activity{
	//private TextView username,password,confirmpassword,email;
	private EditText registerusername,registeruserpassword,confirmregisterpassword,registeremail;
	private Button login,register;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jshop_activity_register);
//		username = (TextView)findViewById(R.id.username);
//		password = (TextView)findViewById(R.id.userpassword);
//		confirmpassword = (TextView)findViewById(R.id.confirmpassword);
//		email = (TextView)findViewById(R.id.email);
		registerusername = (EditText)findViewById(R.id.registerusername);
		registeruserpassword = (EditText)findViewById(R.id.registeruserpassword);
		confirmregisterpassword = (EditText)findViewById(R.id.confirmregisterpassword);
		registeremail = (EditText)findViewById(R.id.registeremail);
		login = (Button)findViewById(R.id.login);
		register = (Button)findViewById(R.id.register);
		register.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				if(validate()){
					if(submit()){
						showDialog("注册成功");
						//注册成功进入首页
						Intent intent = new Intent(JshopActivityRegister.this,JshopActivityLogin.class);
						startActivity(intent);
					}else{
						showDialog("注册失败");
					}
				}
			}
		});
		login.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				//点击登录进入到登录页面
				Intent intent = new Intent(JshopActivityRegister.this,JshopActivityLogin.class);
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
		String username = registerusername.getText().toString();
		if(username.equals("")&&(username.length()<6||username.length()>20)){
			showDialog("请输入用户名");
			return false;
		}
		String password = registeruserpassword.getText().toString();
		if(password.equals("")&&(username.length()<6||username.length()>20)){
			showDialog("请输入密码");
			return false;
		}
		String password2 = confirmregisterpassword.getText().toString();
		if(password2.equals("")){
			showDialog("请确认密码");
			return false;
		}
		String Email = registeremail.getText().toString();
		if(Email.equals("")){
			showDialog("请输入邮箱");
			return false;
		}
		if(!password.equals(password2)){
			showDialog("密码不一致");
			return false;
		}
		return true;
	}
	private String query(String username,String password,String password2,String Email){
		String queryString = "?username="+username+"&password="+password+"&email="+Email;
		String url = JshopActivityUtil.BASE_URL+"registerforAndroid.action"+queryString;
		return JshopActivityUtil.queryStringForPost(url);
	}
	private boolean submit(){
		String username = registerusername.getText().toString();
		String password = registeruserpassword.getText().toString();
		String password2 = confirmregisterpassword.getText().toString();
		String Email = registeremail.getText().toString();
		String result = query(username,password,password2,Email);
		if(result!=null&&result.equals("1")){
			return true;
		}else if(result!=null&&result.equals("0")){
			showDialog("用户名已被使用");
			return false;
		}else if(result!=null&&result.equals("4")){
			showDialog("邮箱已被使用");
			return false;
		}else{
			return false;
		}
	}
}
