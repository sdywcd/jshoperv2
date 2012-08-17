package com.jshop.android.index;

import android.app.Activity;
import android.app.TabActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

public class JshopMTabhost extends TabActivity implements TabContentFactory{

	private final String[] tabTitle = {"凉菜","酒水","热菜","甜品","水果","本店至宝","今日特惠"};
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jshop_m_tabhost);
		TabHost th = getTabHost();
		for(int i = 0; i < tabTitle.length;i++){
			LinearLayout view = (LinearLayout) getLayoutInflater().inflate(R.layout.jshop_m_textfortabtitle,null);
			((TextView) view.findViewById(R.id.tv_title)).setText(tabTitle[i]);
			th.addTab(th.newTabSpec(tabTitle[i]).setIndicator(view).setContent(this));
		}
		
		
	}

	@Override
	public View createTabContent(String tag) {
		View view = new View(this);
		if(tabTitle[0].equals(tag)){
			view.setBackgroundColor(Color.BLUE);
		}else if (tabTitle[1].equals(tag)){
			view.setBackgroundColor(Color.CYAN);
		}else if (tabTitle[2].equals(tag)){
			view.setBackgroundColor(Color.YELLOW);
		}else if (tabTitle[3].equals(tag)){
			view.setBackgroundColor(Color.MAGENTA);
		}
		return view;
	}
}
