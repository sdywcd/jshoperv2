package com.jshop.android;



import com.jshop.android.coupon.JshopActivityCoupon;
import com.jshop.android.location.JshopActivityLocationer;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;
import android.view.View;

public class JshopActivity extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] strs ={"优惠券信息","标记自己","我的好友"};
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strs);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l,View v,int position,long id){
    	Intent intent = null;
    	switch (position){
    		case 0:
    			intent = new Intent(JshopActivity.this,JshopActivityCoupon.class);
    			startActivity(intent);
    			break;
    		case 1:
    			intent = new Intent(JshopActivity.this,JshopActivityLocationer.class);
    			startActivity(intent);
    			break;
    		default:
    			break;
    	}
    }
}