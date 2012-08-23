package com.jshop.android.holder;

import android.widget.ImageView;
import android.widget.TextView;

public class ElecartListViewHolder {

	private TextView memberprice;
	
	private TextView goodsname;
	
	private TextView needquantity;
	
	private ImageView plus;
	
	private ImageView minus;

	public TextView getMemberprice() {
		return memberprice;
	}

	public void setMemberprice(TextView memberprice) {
		this.memberprice = memberprice;
	}

	public TextView getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(TextView goodsname) {
		this.goodsname = goodsname;
	}

	public TextView getNeedquantity() {
		return needquantity;
	}

	public void setNeedquantity(TextView needquantity) {
		this.needquantity = needquantity;
	}

	public ImageView getPlus() {
		return plus;
	}

	public void setPlus(ImageView plus) {
		this.plus = plus;
	}

	public ImageView getMinus() {
		return minus;
	}

	public void setMinus(ImageView minus) {
		this.minus = minus;
	}
	
	
	
}
