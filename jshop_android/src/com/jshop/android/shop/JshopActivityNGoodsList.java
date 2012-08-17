package com.jshop.android.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.jshop.android.action.JshopMgoodscategoryListAction;
import com.jshop.android.index.R;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.util.JshopActivityUtil;
import com.jshop.android.util.JshopMPostActionList;
import com.jshop.android.widget.JshopGridViewAdapter;
public class JshopActivityNGoodsList extends Activity{
	private GridView gv;
	private String requestjsonstr;
	private List<Map<String,Object>>goodscategoryList=new ArrayList<Map<String,Object>>();
	private JshopMgoodscategoryListAction jmgclAction=new JshopMgoodscategoryListAction();
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.jshop_m_goodscategory);
		gv=(GridView)this.findViewById(R.id.goodscategorygridView);
		gv.setOnItemClickListener(new ItemClickListener());
		
		//读取商品分类缓存
		final DBHelper dbhelper=new DBHelper(this);
		Cursor c=dbhelper.query(DBHelper.GOODS_CATEGORY_TM_NAME);
		goodscategoryList=jmgclAction.getGoodsCategoryListtoSQLite(c);
		c.close();
		if(goodscategoryList.isEmpty()){
			goodscategoryList=jmgclAction.getGoodsCategoryList();
			//缓存goodscategorylist
			jmgclAction.setGoodsCategoryListtoSQLite(goodscategoryList, this.getApplicationContext());
		}
		gv.setAdapter(new JshopGridViewAdapter().new JMGoodscategoryListImageAdapter(this,goodscategoryList));
		
	}

	public class ItemClickListener implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			//此处进入商品程序读取商品列表传递分类信息
			Intent intent = new Intent(JshopActivityNGoodsList.this,JshopActivityGoodsList.class);
			intent.putExtra("goodsCategoryTid", goodscategoryList.get(arg2).get("goodsCategoryTid").toString());
			startActivity(intent);
			
			
		}
	}
	   
}
