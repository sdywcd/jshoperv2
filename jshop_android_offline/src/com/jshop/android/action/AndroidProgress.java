package com.jshop.android.action;


import com.jshop.android.index.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
public class AndroidProgress extends Activity {
	private ProgressBar pro;
	protected static final int 	STOP_NOTIFIER=000;
	protected static final int THREADING_NOTIFIER=111;
	public int intCounter=0; 
	private Button btn;
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//设置窗口模式，，因为需要显示进度条在标题栏 
		requestWindowFeature(Window.FEATURE_PROGRESS);
		//设置标题栏上的进度条可见  
		setProgressBarVisibility(true);
		setContentView(R.layout.android_progress_bar);
		//取得ProgressBar 
		pro=(ProgressBar) findViewById(R.id.progress);
		//setProgressBarIndeterminateVisibility(true);
		//设置进度条是否自动运转，即设置其不确定模式，false表是不自动运转
		pro.setIndeterminate(false);
		btn=(Button) findViewById(R.id.addtoelectrocartconfirm);
		//当按钮按下时开始执行,  
		btn.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				//设置ProgressBar为可见状态  
				pro.setVisibility(View.VISIBLE);
				//设置ProgressBar的最大值 
				pro.setMax(100);
				//设置ProgressBar当前值  
				pro.setProgress(0);
				 //通过线程来改变ProgressBar的值  
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						for(int i =0;i<10;i++){
							try {
								intCounter=(i+1)*20;
								Thread.sleep(1000);
								if(i==4){
									Message m =new Message();
									m.what=AndroidProgress.STOP_NOTIFIER;
									AndroidProgress.this.myMessageHandler.sendMessage(m);
									break;
								}else{
									Message m =new Message();
									m.what=AndroidProgress.STOP_NOTIFIER;
									AndroidProgress.this.myMessageHandler.sendMessage(m);
								}
							} catch (Exception e) {								
								e.printStackTrace();
							}
							
						}
						
					}
				}).start();
				
			}
		});
		
	}		
	
	
	Handler myMessageHandler = new Handler() {		
		@SuppressWarnings({ "static-access", "unused" })
		public void handlerMessage (Message msg){
			switch(msg.what){
			//ProgressBar已经是对大值  
			case AndroidProgress.STOP_NOTIFIER:			
			pro.setVisibility(View.GONE);
			Thread.currentThread().interrupt();
			break;	
			
			case AndroidProgress.THREADING_NOTIFIER:
				if(!Thread.currentThread().interrupted()){
					 // 改变ProgressBar的当前值  
					pro.setProgress(intCounter);
					// 设置标题栏中前景的一个进度条进度值
					setProgress(intCounter*100);
					 // 设置标题栏中后面的一个进度条进度值 
					setSecondaryProgress(intCounter*100);
					
				}
				break;
			}
			super.handleMessage(msg);
		}
	};
 
}
