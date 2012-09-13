package com.jshop.android.util;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class JshopTabHostViewPagerAdapter extends PagerAdapter {
	public ArrayList<View> pageViews;

	public void JshopTabHostViewPagerAdapter(ArrayList<View> pageViews){
		this.pageViews = pageViews;		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pageViews.size();
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		return super.instantiateItem(container, position);
	}
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
