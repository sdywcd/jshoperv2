package com.jshop.android.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jshop.android.action.JshopMGoodsListAction;
import com.jshop.android.holder.GoodsListViewHolder;
import com.jshop.android.index.R;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.view.ViewPager;
import android.text.Html;


public class JshopTabHostViewPagerAdapter extends PagerAdapter {
	private ArrayList<View> mListViews;
	private Context ctx;
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();
	/*	private GoodsListViewHolder holder = new GoodsListViewHolder();
	private JshopMGoodsListAction jmGoodsListAction = new JshopMGoodsListAction();*/
	public JshopTabHostViewPagerAdapter(Context ctx,ArrayList<View> mListViews){
		this.mListViews = mListViews;
		this.ctx = ctx;		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListViews.size();
	}

	@Override
	public Object instantiateItem(View container, int position) {
		// TODO Auto-generated method stub

		//View v = new View(ctx);
		((ViewPager) container).addView(mListViews.get(position));
		return mListViews.get(position);
	}
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0==arg1;
		//return false;
	}
	
	@Override
	public void setPrimaryItem(View container, int position, Object object) {
		// TODO Auto-generated method stub
		
		super.setPrimaryItem(container, position, object);
	}
	@Override
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(mListViews.get(position));
	}
	@Override
	public void finishUpdate(View container) {
		// TODO Auto-generated method stub
		super.finishUpdate(container);
	}
	@Override
	public void startUpdate(View container) {
		// TODO Auto-generated method stub
		super.startUpdate(container);
	}
	@Override
	public void notifyDataSetChanged() {
		// TODO Auto-generated method stub
		super.notifyDataSetChanged();
	}
	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
		// TODO Auto-generated method stub
		super.restoreState(state, loader);
	}
	@Override
	public Parcelable saveState() {
		// TODO Auto-generated method stub
		return super.saveState();
	}
	
}
