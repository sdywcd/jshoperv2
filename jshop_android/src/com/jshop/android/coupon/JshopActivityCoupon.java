package com.jshop.android.coupon;

import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.jshop.android.index.R;
import com.jshop.android.util.JshopActivityUtil;

public class JshopActivityCoupon extends Activity{
	private TextView TextTitle;
	private ImageView CouponImage;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jshop_activity_coupon);
		TextTitle = (TextView)findViewById(R.id.ctitle);
		CouponImage = (ImageView)findViewById(R.id.cimage);
		String result = query();
		try {
			JSONArray res = new JSONArray(result);
			for(int i=0;i<res.length();i++)
			{
				JSONObject item = res.getJSONObject(i);
				String title = item.getString("ctitle");
				TextTitle.setText(title);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//showalert(result);
	}
	private String query()
	{
		String url = JshopActivityUtil.BASE_URL+"findAllCoupon.action";
		return JshopActivityUtil.queryStringForPost(url);
	}
	private void showalert(String msg)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
			.setCancelable(false)
			.setPositiveButton("确定", new DialogInterface.OnClickListener(){
				public void onClick(DialogInterface dialog,int id){
					
				}
			});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
