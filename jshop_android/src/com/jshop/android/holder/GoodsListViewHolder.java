package com.jshop.android.holder;

import android.widget.ImageView;
import android.widget.TextView;

public class GoodsListViewHolder {
	private ImageView pictureurl;
	private TextView memberprice;
	private TextView weight;
	private TextView unitname;
	private TextView goodsname;
	private ImageView addtomyelecartmenu;
	private TextView detail;

	public ImageView getPictureurl() {
		return pictureurl;
	}

	public void setPictureurl(ImageView pictureurl) {
		this.pictureurl = pictureurl;
	}

	public TextView getMemberprice() {
		return memberprice;
	}

	public void setMemberprice(TextView memberprice) {
		this.memberprice = memberprice;
	}

	public TextView getWeight() {
		return weight;
	}

	public void setWeight(TextView weight) {
		this.weight = weight;
	}

	public TextView getUnitname() {
		return unitname;
	}

	public void setUnitname(TextView unitname) {
		this.unitname = unitname;
	}

	public TextView getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(TextView goodsname) {
		this.goodsname = goodsname;
	}

	public ImageView getAddtomyelecartmenu() {
		return addtomyelecartmenu;
	}

	public void setAddtomyelecartmenu(ImageView addtomyelecartmenu) {
		this.addtomyelecartmenu = addtomyelecartmenu;
	}

	public TextView getDetail() {
		return detail;
	}

	public void setDetail(TextView detail) {
		this.detail = detail;
	}

}
