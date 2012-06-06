package com.jshop.android.shop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.util.EncodingUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jshop.android.index.R;
import com.jshop.android.login.JshopActivityLogin;
import com.jshop.android.register.JshopActivityRegister;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopMPostActionList;

public class JshopActivityGoodsdetail extends Activity {

	private ImageView mainimageView;
	private TextView goodsname,usersetnum,memberprice,price,weight,star,quantity;
	private Button addtoelectrocartconfirm,back;
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodsdetail = new ArrayList<HashMap<String, Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_goodsdetail);
		goodsname=(TextView)this.findViewById(R.id.goodsname);
		//usersetnum=(TextView)this.findViewById(R.id.usersetnum);
		memberprice=(TextView)this.findViewById(R.id.memberprice);
//		price=(TextView)this.findViewById(R.id.price);
		weight=(TextView)this.findViewById(R.id.weight);
//		star=(TextView)this.findViewById(R.id.star);
//		quantity=(TextView)this.findViewById(R.id.quantity);
		mainimageView=(ImageView)this.findViewById(R.id.mainimageView);
		addtoelectrocartconfirm=(Button) this.findViewById(R.id.addtoelectrocartconfirm);
		Intent intent=this.getIntent();
		String goodsid=intent.getStringExtra("goodsid");
		try {
			getGoodsdetail(goodsid);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//想页面注入值
		goodsname.setText(goodsdetail.get(0).get("goodsname").toString());
		memberprice.setText(goodsdetail.get(0).get("memberprice").toString());
		mainimageView.setImageBitmap((Bitmap) goodsdetail.get(0).get("pictureurl"));
		weight.setText("份量："+goodsdetail.get(0).get("weight").toString()+"g");
		
		addtoelectrocartconfirm.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				String []temp=readJmtable().split(",");
				if("-1".equals(temp[0])){
					Toast t=Toast.makeText(getApplicationContext(), "您还没有就座无法点菜", Toast.LENGTH_LONG);
					t.show();
				}else{
					//进入购物车处理页面
					Intent intent=new Intent(JshopActivityGoodsdetail.this,JshopMelectrocart.class);
					intent.putExtra("goodsid", goodsdetail.get(0).get("goodsid").toString());
					intent.putExtra("tablestate", temp[0].toString());
					intent.putExtra("tableNumber", temp[1].toString());
					startActivity(intent);
				}
				
			}
		});
	}
	
	
	/**
	 * 向服务器发送请求获取goodsdetail信息
	 * @param goodsid
	 * @return
	 */
	private String queryGoodsdetailForJshop(String goodsid){
		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDGOODSBYGOODSIDFORANDROID+"?goodsid="+goodsid;
		return JshopActivityUtil.queryStringForPost(posturl);
	}
	
	private void getGoodsdetail(String goodsid) throws JSONException, IOException{
		requestjsonstr=this.queryGoodsdetailForJshop(goodsid);
		if(requestjsonstr!=null){
			String[]strs=requestjsonstr.split("--");
			for(int i=0;i<strs.length;i++){
				HashMap<String,Object>map=new HashMap<String,Object>();
				JSONObject jo=new JSONObject(strs[i].toString());
				map.put("pictureurl", getPictureurlImg(JshopActivityUtil.BASE_URL+jo.getString("pictureurl")));
				map.put("goodsname", jo.getString("goodsname"));
				map.put("memberprice", "￥"+jo.getString("memberprice")+"/份");
				map.put("goodsid", jo.getString("goodsid"));	
				map.put("weight", jo.getString("weight").toString());
				goodsdetail.add(map);
			}
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
	 * 读取餐桌信息文件
	 * @return
	 */
	private String readJmtable(){
		String res="";
		try{
			FileInputStream fis=openFileInput(JshopMParams.SHAREMTABLEPARAM);
			byte[]buffer=new byte[fis.available()];
			fis.read(buffer);
			res=EncodingUtils.getString(buffer,"UTF-8");
			fis.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return res;
	}
}
