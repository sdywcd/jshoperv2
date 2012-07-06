package com.jshop.android.index;

import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

public class WelcomeAct extends Activity {
	protected static final int LOGINOVER=0;

	protected static String TAG="welcomeAct";
	private Handler handler;
	@Override 
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.text);
		ProgressBar loading=(ProgressBar) findViewById(R.layout.text);
//		loading.setVisibility(View.VISIBLE);
		HandlerThread thread= new HandlerThread("welcome");
		thread.start();
		handler = new Handler(){
			@Override
			public void handleMessage(Message msg){
				if(msg.what==LOGINOVER){
					Log.i(TAG, Thread.currentThread().getName());
					Intent intent = new Intent(WelcomeAct.this,JshopMIndex.class);
					startActivity(intent);
				}
			}
		};
		tt.run();
		
	}
	TimerTask tt = new TimerTask() {
		
		@Override
		public void run() {			
			Log.i(TAG, Thread.currentThread().getName());
			handler.sendMessageDelayed(handler.obtainMessage(LOGINOVER),3000);
		}
	};
}
