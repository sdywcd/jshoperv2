package com.jshop.android.widget;

import java.util.ArrayList;
import java.util.HashMap;

import com.jshop.android.action.JshopMelectrocartAction;
import com.jshop.android.holder.ElecartListViewHolder;
import com.jshop.android.holder.GoodsListViewHolder;
import com.jshop.android.index.R;
import com.jshop.android.shop.JshopActivityNGoodsList;
import com.jshop.android.sqlite.DBHelper;
import com.jshop.android.util.Arith;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.SimpleAdapter.ViewBinder;

public class JshopListViewAdapter extends Activity {
	private final DBHelper dbhelper=new DBHelper(this);

	public class JshopMyGoodsListViewAdapter extends BaseAdapter {
		
		
		private final ArrayList<HashMap<String, Object>> list;
		private LayoutInflater myInflater;

		public JshopMyGoodsListViewAdapter(
				ArrayList<HashMap<String, Object>> list, Context context) {
			this.list = list;
			this.myInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			GoodsListViewHolder holder = null;
			if (convertView == null) {
				holder = new GoodsListViewHolder();
				convertView = myInflater.inflate(
						R.layout.jshop_m_listforcategory, null);
				holder.setPictureurl((ImageView) convertView
						.findViewById(R.id.pictureurl));
				holder.setGoodsname((TextView) convertView
						.findViewById(R.id.goodsname));
				holder.setMemberprice((TextView) convertView
						.findViewById(R.id.memberprice));
				holder.setWeight((TextView) convertView
						.findViewById(R.id.weight));
				holder.setUnitname((TextView) convertView
						.findViewById(R.id.unitname));
				holder.setAddtomyelecartmenu((ImageView) convertView
						.findViewById(R.id.addtomyelecartmenu));
				holder.setDetail((TextView) convertView
						.findViewById(R.id.detail));
				convertView.setTag(holder);
			} else {
				holder = (GoodsListViewHolder) convertView.getTag();
			}
			holder.getPictureurl().setImageBitmap(
					(Bitmap) list.get(position).get("pictureurl"));
			holder.getGoodsname().setText(
					list.get(position).get("goodsname").toString());
			holder.getMemberprice().setText(
					list.get(position).get("memberprice").toString());
			holder.getWeight().setText(
					list.get(position).get("weight").toString());
			holder.getUnitname().setText(
					list.get(position).get("unitname").toString());
			holder.getDetail().setText(
					list.get(position).get("detail").toString());
			holder.getAddtomyelecartmenu().setOnClickListener(
					new OnClickListener() {
						@Override
						public void onClick(View v) {
							JshopActivityNGoodsList jshopActivityNGoodsList = new JshopActivityNGoodsList();
							jshopActivityNGoodsList.showConfirmAddtoCart(list,
									position);
							
						}
					});
			return convertView;
		}

		@Override
		public void notifyDataSetChanged() {
			// TODO Auto-generated method stub
			super.notifyDataSetChanged();
		}
		
		
		
	}

	/**
	 * 商品listview的适配器
	 * @author "chenda"
	 *
	 */
	public class JshopMyElecartListViewAdapter extends BaseAdapter {
		private ArrayList<HashMap<String, Object>> electrocartgoodslists;
		private JshopMelectrocartAction jshopMelectrocartAction=new JshopMelectrocartAction();
		
		private final ArrayList<HashMap<String, Object>> list;
		private LayoutInflater myInflater;

		public JshopMyElecartListViewAdapter(
				ArrayList<HashMap<String, Object>> list, Context context) {
			this.list = list;
			electrocartgoodslists = new ArrayList<HashMap<String, Object>>();//elecart
			this.myInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			ElecartListViewHolder holder = null;
			if (convertView == null) {
				holder = new ElecartListViewHolder();
				convertView = myInflater.inflate(
						R.layout.jshop_m_detaillistview, null);
				holder.setGoodsname((TextView) convertView
						.findViewById(R.id.goodsname));
				holder.setMemberprice((TextView) convertView
						.findViewById(R.id.memberprice));
				holder.setNeedquantity((TextView) convertView.findViewById(R.id.needquantity));
				holder.setPlus((ImageView) convertView.findViewById(R.id.plus));
				holder.setMinus((ImageView) convertView.findViewById(R.id.minus));
				convertView.setTag(holder);
			} else {
				holder = (ElecartListViewHolder) convertView.getTag();
			}
			holder.getGoodsname().setText(
					list.get(position).get("goodsname").toString());
			holder.getMemberprice().setText(
					list.get(position).get("memberprice").toString());
			holder.getNeedquantity().setText(
					list.get(position).get("needquantity").toString());
			holder.getPlus().setOnClickListener(
					new OnClickListener() {
						@Override
						public void onClick(View v) {
							JshopMelectrocartAction jmelecart=new JshopMelectrocartAction();
							jmelecart.plusorMinusElecart(list, position, "plus", v.getContext());
							
						}
					});
			holder.getMinus().setOnClickListener(
					new OnClickListener() {
						@Override
						public void onClick(View v) {
							JshopMelectrocartAction jmelecart=new JshopMelectrocartAction();
							jmelecart.plusorMinusElecart(list, position, "minus", v.getContext());
							
							
						}
					});
			return convertView;
		}

		@Override
		public void notifyDataSetChanged() {
			// TODO Auto-generated method stub
			super.notifyDataSetChanged();
			//重新计算总价和elecart的显示
			//读取ele_cart缓存
			Cursor ec=dbhelper.query(DBHelper.ELE_CART_TM_NAME);
			electrocartgoodslists=jshopMelectrocartAction.getElecarttoSQLite(ec);
			ec.close();
			Double total=0.0;
			for(int i=0;i<electrocartgoodslists.size();i++){
				total=Arith.add(total, Arith.mul(Double.parseDouble(electrocartgoodslists.get(i).get("memberprice").toString()), Double.parseDouble(electrocartgoodslists.get(i).get("needquantity").toString())));
				
			}
			
		}
		
		
		
	}

}
