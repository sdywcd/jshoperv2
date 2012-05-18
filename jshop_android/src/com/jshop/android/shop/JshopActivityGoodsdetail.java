package com.jshop.android.shop;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.jshop.android.index.R;
import com.jshop.android.util.JshopActivityUtil;

public class JshopActivityGoodsdetail extends Activity {
	public static final String ACTION="findGoodsByGoodsidforAndroid"; 
	
	private WebView webView;
	private ImageView detailpicutureurlimageView;
	private TextView detailgoodsname,usersetnum,detailmemberprice,price,weight,star,quantity;
	private String goodsdetailstr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_activity_goodsdetail);
		webView=(WebView)this.findViewById(R.id.webView);
		detailgoodsname=(TextView)this.findViewById(R.id.detailgoodsname);
		usersetnum=(TextView)this.findViewById(R.id.usersetnum);
		detailmemberprice=(TextView)this.findViewById(R.id.detailmemberprice);
		price=(TextView)this.findViewById(R.id.price);
		weight=(TextView)this.findViewById(R.id.weight);
		star=(TextView)this.findViewById(R.id.star);
		quantity=(TextView)this.findViewById(R.id.quantity);
		detailpicutureurlimageView=(ImageView)this.findViewById(R.id.detailpicutureurlimageView);
		Intent intent=this.getIntent();
		String goodsid=intent.getStringExtra("goodsid");
		goodsdetailstr=queryGoodsdetail(goodsid);
		if(goodsdetailstr==null){
			return;
		}else{
			String goodsname1 = null;
			String usersetnum1=null;
			String memberprice1=null;
			String price1=null;
			String weight1=null;
			String star1=null;
			String quantity1=null;
			String pictureurl1=null;
			String detail1=null;
			try{
				JSONObject jo=new JSONObject(goodsdetailstr);
				goodsname1=jo.getString("goodsname");
				usersetnum1=jo.getString("usersetnum");
				memberprice1=jo.getString("memberprice");
				price1=jo.getString("price");
				weight1=jo.getString("weight");
				star1=jo.getString("star");
				quantity1=jo.getString("quantity");
				pictureurl1=jo.getString("pictureurl");
				detail1=jo.getString("detail");
				
			}catch(JSONException e){
				e.printStackTrace();
			}
			
			/**
			 * 开始注入值
			 */
			detailgoodsname.setText(goodsname1);
			usersetnum.setText(usersetnum1);
			detailmemberprice.setText(memberprice1);
			price.setText(price1);
			weight.setText(weight1);
			star.setText(star1);
			quantity.setText(quantity1);
			try {
				detailpicutureurlimageView.setImageBitmap(getPictureurlImg(pictureurl1));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			webView.loadData(detail1, "text/html", "utf-8");
			
		}
	}
	
	private Bitmap getPictureurlImg(String pictureurl) throws IOException{
		URL url=new URL(pictureurl);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5*1000);
		InputStream in=conn.getInputStream();
		Bitmap bm=BitmapFactory.decodeStream(in);
		in.close();
		return bm;
	}
	/**
	 * 获取服务器的商品列表数据
	 * @return
	 */
	private String queryGoodsdetail(String param){
		String url=JshopActivityUtil.BASE_URL+ACTION+"?goodsid="+param;
		return JshopActivityUtil.queryStringForPost(url);
	}
	
}
