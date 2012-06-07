package com.jshop.android.shop;

import com.jshop.android.index.JshopMIndex;
import com.jshop.android.index.R;
import com.jshop.android.shop.JshopActivityGoodsCategoryList;
import com.jshop.android.shop.JshopActivityGoodsList;
import com.jshop.android.shop.JshopMelectrocart;
import com.jshop.android.table.JshopMtable;
import com.jshop.android.util.JshopMParams;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

/**
 * 餐饮系统主界面
 * 
 * @Description TODO
 * 
 * @Author "chenda"
 * 
 * @File JshopMelectroorderdetail.java
 * 
 * @Package com.jshop.android.index
 * 
 * @ProjectName jshop_android
 * 
 * @Data 2012-5-14 下午01:27:46
 */
public class JshopMelectroorderdetail extends Activity {

	private ImageButton sit, ordingfoods, checkout, calculator, callservice,vipcenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setTitle(JshopMParams.SYSTEMNAME.toString());
		this.setContentView(R.layout.jshop_m_goodselectroorderdetail);
		sit = (ImageButton) this.findViewById(R.id.sit);
		ordingfoods = (ImageButton) this.findViewById(R.id.ordingfoods);
		checkout = (ImageButton) this.findViewById(R.id.checkout);
		calculator = (ImageButton) this.findViewById(R.id.calculator);
		callservice = (ImageButton) this.findViewById(R.id.callservice);
		vipcenter = (ImageButton) this.findViewById(R.id.vipcenter);
		/**
		 * 点击进入点餐页面
		 */
		ordingfoods.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMelectroorderdetail.this,JshopActivityGoodsCategoryList.class);
				startActivity(intent);
					
			}

		});
		/**
		 * 点击进入结算页面
		 */
		checkout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(JshopMelectroorderdetail.this,JshopMelectrocart.class);
				startActivity(intent);
					
			}

		});
		
		
		
	}
	
	
	
	
	
}
