package com.jshop.android.widget;

import java.util.ArrayList;

import com.jshop.android.index.JshopActivityIndex;
import com.jshop.android.index.JshopMIndex;
import com.jshop.android.index.R;
import com.jshop.android.index.WelcomeAct;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.ImageView;

public class JshopViewpagerAdapter extends Activity {

	public class JshopActivityIndexViewpagerAdapter extends PagerAdapter {

		private ArrayList<View> pageViews;

		public JshopActivityIndexViewpagerAdapter() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * 对左右滚动空间进行适配器定义和操作
		 */
		public JshopActivityIndexViewpagerAdapter(ArrayList<View> pv) {
			this.pageViews = pv;
		}

		@Override
		public int getCount() {
			return pageViews.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			((ViewPager) container).removeView(pageViews.get(position));
		}

		@Override
		public void finishUpdate(View container) {
			// TODO Auto-generated method stub
		}

		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			((ViewPager) container).addView(pageViews.get(position));
			return pageViews.get(position);
		}

		@Override
		public void setPrimaryItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			super.setPrimaryItem(container, position, object);
		}

		@Override
		public void startUpdate(View container) {
			// TODO Auto-generated method stub
			super.startUpdate(container);
		}

	}
	 // 指引页面更改事件监听器
    public class JshopActivityIndexViewpagerPageChangeListener  implements OnPageChangeListener {  
    	private Context context;
    	private ImageView[] imageViews;
    	
    	public JshopActivityIndexViewpagerPageChangeListener(Context ctx,ImageView[] v){
    		this.context=ctx;
    		this.imageViews=v;
    	}
        @Override  
        public void onPageScrollStateChanged(int arg0) {  
            // TODO Auto-generated method stub  
        }
  
        @Override  
        public void onPageScrolled(int arg0, float arg1, int arg2) {  
            // TODO Auto-generated method stub  
        }  
  
        @Override  
        public void onPageSelected(int arg0) {
            for (int i = 0; i < imageViews.length; i++) {  
                imageViews[arg0].setBackgroundResource(R.drawable.page_indicator_focused);
                
                if (arg0 != i) {  
                    imageViews[i].setBackgroundResource(R.drawable.page_indicator);  
                }  
            }
            if(arg0==5){
            	Intent intent = new Intent(context,JshopMIndex.class);
				startActivity(intent);
            }
        }  
    }

	
}
