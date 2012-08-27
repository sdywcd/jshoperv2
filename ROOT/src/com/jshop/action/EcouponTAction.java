package com.jshop.action;

import java.util.Date;

import com.jshop.entity.EcouponT;
import com.jshop.service.EcouponTService;

public class EcouponTAction {
	private EcouponTService ecouponTService;
	private String eid;
	private String goodsname;
	private double favourableprices;
	private double pricededuction;
	private String goodsid;
	private Date begintime;
	private Date endtime;
	private String ecouponstate;
	private String state;
	private String note;
	
	public EcouponTService getEcouponTService() {
		return ecouponTService;
	}
	public void setEcouponTService(EcouponTService ecouponTService) {
		this.ecouponTService = ecouponTService;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public double getFavourableprices() {
		return favourableprices;
	}
	public void setFavourableprices(double favourableprices) {
		this.favourableprices = favourableprices;
	}
	public double getPricededuction() {
		return pricededuction;
	}
	public void setPricededuction(double pricededuction) {
		this.pricededuction = pricededuction;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getEcouponstate() {
		return ecouponstate;
	}
	public void setEcouponstate(String ecouponstate) {
		this.ecouponstate = ecouponstate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * 添加电子订单优惠券
	 * @return
	 */
	public String addEcouponT(){
		EcouponT et = new EcouponT();
		//当ECOUPONSTATE=3的时候，现金抵扣模式
		if(this.getEcouponstate()=="3"){
		et.setEcouponstate(this.getEcouponstate());
		et.setFavourableprices(this.getFavourableprices());
		et.setPricededuction(this.getPricededuction());
		et.setBegintime(this.getBegintime());
		et.setEndtime(this.getEndtime());
		et.setState(this.getState());
		et.setNote(this.getNote());
		if(this.getEcouponTService().addEcoupon(et)>0){
			return "json";
		}
		}
		return "json";
	}

}
