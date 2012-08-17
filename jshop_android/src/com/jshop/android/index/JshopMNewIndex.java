package com.jshop.android.index;

import com.jshop.android.shop.JshopActivityGoodsList;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
/**
 * new pad ui index 
 * @author chenda
 *
 */
public class JshopMNewIndex extends Activity {
	
	private ImageView sit,ordingfoods,calculator,logo;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题窗口
		super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏模式
		super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
		this.setContentView(R.layout.jshop_m_newindex);
		//初始化页面元素
		ordingfoods=(ImageView) this.findViewById(R.id.ordingfoods);
		calculator=(ImageView) this.findViewById(R.id.calculator);
		logo=(ImageView) this.findViewById(R.id.logo);
		
		//绑定页面元素事件
		/**
		 * 进入点餐页面
		 */
		ordingfoods.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMNewIndex.this, JshopActivityGoodsList.class);
				startActivity(intent);
			}
		});
	}
}

