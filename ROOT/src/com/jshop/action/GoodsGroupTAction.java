package com.jshop.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.stereotype.Controller;

import com.jshop.action.tools.BaseTools;
import com.jshop.action.tools.Serial;
import com.jshop.entity.GoodsGroupT;
import com.jshop.entity.GoodsT;
import com.jshop.service.impl.GoodsGroupTServiceImpl;
@ParentPackage("jshop")
@Controller("GoodsGroupTAction")
public class GoodsGroupTAction {
	public GoodsGroupTServiceImpl goodsgrouptserviceimpl;
	public Serial serial;
	private String groupid;
	private String goodsid;
	private String goodsname;
	private String state;
	private Date begintime;
	private Date endtime;
	private String creatorid;
	private Date createtime;
	private String cashstate;
	private Double cashlimit;
	private int limitbuy;
	private int salequantity;
	private int SOrderCount;
	private int totalOrderCount;
	private double sendpoint;
	private String priceladder;
	private String detail;
	@JSON(serialize=false)
	public GoodsGroupTServiceImpl getGoodsgrouptserviceimpl() {
		return goodsgrouptserviceimpl;
	}
	public void setGoodsgrouptserviceimpl(
			GoodsGroupTServiceImpl goodsgrouptserviceimpl) {
		this.goodsgrouptserviceimpl = goodsgrouptserviceimpl;
	}
	@JSON(serialize=false)
	public Serial getSerial() {
		return serial;
	}
	public void setSerial(Serial serial) {
		this.serial = serial;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
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
	public String getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCashstate() {
		return cashstate;
	}
	public void setCashstate(String cashstate) {
		this.cashstate = cashstate;
	}
	public Double getCashlimit() {
		return cashlimit;
	}
	public void setCashlimit(Double cashlimit) {
		this.cashlimit = cashlimit;
	}
	public int getLimitbuy() {
		return limitbuy;
	}
	public void setLimitbuy(int limitbuy) {
		this.limitbuy = limitbuy;
	}
	public int getSalequantity() {
		return salequantity;
	}
	public void setSalequantity(int salequantity) {
		this.salequantity = salequantity;
	}
	public int getSOrderCount() {
		return SOrderCount;
	}
	public void setSOrderCount(int sOrderCount) {
		SOrderCount = sOrderCount;
	}
	public int getTotalOrderCount() {
		return totalOrderCount;
	}
	public void setTotalOrderCount(int totalOrderCount) {
		this.totalOrderCount = totalOrderCount;
	}
	public double getSendpoint() {
		return sendpoint;
	}
	public void setSendpoint(double sendpoint) {
		this.sendpoint = sendpoint;
	}
	public String getPriceladder() {
		return priceladder;
	}
	public void setPriceladder(String priceladder) {
		this.priceladder = priceladder;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * 添加团购商品
	 * @return
	 */
	@Action(value="addGoodsGroupT",results={@Result(name="json",type="json")})
	public String addGoodsGroupT(){
		GoodsGroupT ggt = new GoodsGroupT();		
		ggt.setGroupid(this.getSerial().Serialid(Serial.GOODSGROUPT));
		ggt.setGoodsid(this.getGoodsid().trim());
		ggt.setCreatetime(BaseTools.systemtime());
		ggt.setGoodsname(this.getGoodsname().trim());
		ggt.setCreatorid(this.getCreatorid().trim());
		ggt.setState("0");
		ggt.setCashstate("0");
		ggt.setCashlimit(0.0);
		ggt.setLimitbuy(0);
		ggt.setSalequantity(0);
		ggt.setSOrderCount(0);
		ggt.setTotalOrderCount(0);
		ggt.setBegintime(BaseTools.systemtime());
		ggt.setEndtime(BaseTools.systemtime());
		ggt.setSendpoint(this.getSendpoint());
		ggt.setPriceladder(this.getPriceladder().trim());
		ggt.setDetail(this.getDetail().trim());
		if(this.getGoodsgrouptserviceimpl().addGoodsGroupT(ggt)>0){
			return "json";
		}	
		return "json";
	}

}
