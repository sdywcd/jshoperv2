package com.jshop.android.pad.shop;

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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.jshop.android.pad.R;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMParams;
import com.jshop.android.util.JshopMPostActionList;

public class JshopActivityGoodsdetail extends Activity {

	private ImageView mainimageView;
	private TextView goodsname,usersetnum,memberprice,price,weight,star,quantity;
	private Button addtoelectrocartconfirm,back;
	private String requestjsonstr;
	private ArrayList<HashMap<String, Object>> goodsdetail = new ArrayList<HashMap<String, Object>>();
	private ArrayList<HashMap<String, Object>> goodslists = new ArrayList<HashMap<String, Object>>();
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
		back=(Button)this.findViewById(R.id.back);
		Intent intent=this.getIntent();
		String goodsid=intent.getStringExtra("goodsid");
		try {
			getGoodsList();
			getGoodsdetail(goodsid);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//想页面注入
		goodsname.setText(goodsdetail.get(0).get("goodsname").toString());
		memberprice.setText(goodsdetail.get(0).get("memberprice").toString());
		mainimageView.setImageResource((Integer) goodsdetail.get(0).get("pictureurl"));
		weight.setText("份量"+goodsdetail.get(0).get("weight").toString()+"g");
		
		addtoelectrocartconfirm.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
//				String []temp=readJmtable().split(",");
//				if("-1".equals(temp[0])){
//					Toast t=Toast.makeText(getApplicationContext(), "您还没有就座无法点菜", Toast.LENGTH_LONG);
//					t.show();
//				}else{
					//进入购物车处理页
					Toast t=Toast.makeText(getApplicationContext(), "加入餐车成功", Toast.LENGTH_LONG);
					t.show();
					this.addGoodstoElectrocart(goodsdetail.get(0).get("goodsid").toString(),"1","001");
					finish();
//					Intent intent=new Intent(JshopActivityGoodsdetail.this,JshopMelectrocart.class);
//					intent.putExtra("goodsid", goodsdetail.get(0).get("goodsid").toString());
//					intent.putExtra("tablestate", "1");//假的餐桌状态
//					intent.putExtra("tableNumber", "001");//假的餐桌号
//					startActivity(intent);
//				}
				
			}

			private void addGoodstoElectrocart(String string, String string2,
					String string3) {
				// TODO Auto-generated method stub
				
			}
		});
		
		back.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v)
			{
				finish();
			}

		});
		
	}
	
	private void getGoodsList() throws IOException{
		Integer[]lc={
				R.drawable.lc001,
				R.drawable.lc002
		};
		Integer[]rc={
				R.drawable.rc001,
				R.drawable.rc002
		};
		Integer[]dx={
				R.drawable.dx001,
				R.drawable.dx002
		};
		Integer[]yl={
				R.drawable.yl001,
				R.drawable.yl002
		};
		HashMap<String,Object>map=new HashMap<String,Object>();
		map.put("pictureurl", lc[0]);
		map.put("goodsname", "钵钵鸡");
		map.put("memberprice", "￥32");
		map.put("goodsid", "001");	
		
		HashMap<String,Object>map1=new HashMap<String,Object>();
		map1.put("pictureurl", lc[1]);
		map1.put("goodsname", "冷拌翡翠豆芽");
		map1.put("memberprice", "￥16");
		map1.put("goodsid", "002");	
		
		HashMap<String,Object>map2=new HashMap<String,Object>();
		map2.put("pictureurl", rc[0]);
		map2.put("goodsname", "丰收日红烧肉");
		map2.put("memberprice", "￥28");
		map2.put("goodsid", "003");	
		
		HashMap<String,Object>map3=new HashMap<String,Object>();
		map3.put("pictureurl", rc[1]);
		map3.put("goodsname", "椒盐龙头烤");
		map3.put("memberprice", "￥58");
		map3.put("goodsid", "004");	
		
		HashMap<String,Object>map4=new HashMap<String,Object>();
		map4.put("pictureurl", dx[0]);
		map4.put("goodsname", "芒果芝士慕斯");
		map4.put("memberprice", "￥28");
		map4.put("goodsid", "005");	
		
		HashMap<String,Object>map5=new HashMap<String,Object>();
		map5.put("pictureurl", dx[1]);
		map5.put("goodsname", "抹茶欧培拉");
		map5.put("memberprice", "￥28");
		map5.put("goodsid", "006");	
		
		HashMap<String,Object>map6=new HashMap<String,Object>();
		map6.put("pictureurl", yl[0]);
		map6.put("goodsname", "桂圆红枣茶");
		map6.put("memberprice", "￥12");
		map6.put("goodsid", "007");	
		
		HashMap<String,Object>map7=new HashMap<String,Object>();
		map7.put("pictureurl", yl[1]);
		map7.put("goodsname", "招牌手工咖啡");
		map7.put("memberprice", "￥18");
		map7.put("goodsid", "008");	
		
		goodslists.add(map);
		goodslists.add(map1);
		goodslists.add(map2);
		goodslists.add(map3);
		goodslists.add(map4);
		goodslists.add(map5);
		goodslists.add(map6);
		goodslists.add(map7);
		
	}
	/**
	 * 向服务器发�?请求获取goodsdetail信息
	 * @param goodsid
	 * @return
	 */
//	private String queryGoodsdetailForJshop(String goodsid){
//		String posturl=JshopActivityUtil.BASE_URL+"/"+JshopMPostActionList.FINDGOODSBYGOODSIDFORANDROID+"?goodsid="+goodsid;
//		return JshopActivityUtil.queryStringForPost(posturl);
//	}
	
	private void getGoodsdetail(String goodsid) throws  IOException{
		
		HashMap<String,Object>map=new HashMap<String,Object>();
		for(int i=0;i<goodslists.size();i++){
			if(goodslists.get(i).get("goodsid").equals(goodsid)){
				map.put("pictureurl",goodslists.get(i).get("pictureurl"));
				map.put("goodsname", goodslists.get(i).get("goodsname"));
				map.put("memberprice", goodslists.get(i).get("memberprice").toString()+"/份");
				map.put("goodsid",goodslists.get(i).get("goodsid").toString());	
				map.put("weight", "300g");
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
