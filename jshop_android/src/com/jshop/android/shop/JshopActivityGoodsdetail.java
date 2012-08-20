package com.jshop.android.shop;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.util.EncodingUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jshop.android.action.JshopMGoodsdetailAction;
import com.jshop.android.index.R;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.sqlite.DBHelper1;
import com.jshop.android.util.BaseTools;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopMPostActionList;

public class JshopActivityGoodsdetail extends Activity {

	private ImageView mainimageView;
	private TextView goodsname,usersetnum,memberprice,price,weight,star,quantity;
	private Button addtoelectrocartconfirm,back;
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodsdetail = new ArrayList<HashMap<String, Object>>();
	private JshopMGoodsdetailAction jmgoodsdetailAction=new JshopMGoodsdetailAction();
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
		//读取缓存
		final DBHelper dbhelper=new DBHelper(this);
		Cursor c=dbhelper.queryByParamgoodsid(DBHelper.GOODS_TM_NAME,goodsid);
		
		try {
			goodsdetail=jmgoodsdetailAction.getGoodsDetailSQLite(c);
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
	 * 读取餐桌信息文件
	 * @return
	 */
	public String readJmtable(){
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
