package com.jshop.entity;

import java.util.Date;

/**
 * CouponT entity. @author MyEclipse Persistence Tools
 */

public class CouponT implements java.io.Serializable {

	// Fields    

	private String cid;
	private String ctitle;
	private String cimage;
	private Date endtime;
	private String details;
	private Date createtime;
	private Date modifytime;
	private Date begintime;
	private String creatorid;
	private double lat;
	private double lng;
	private Integer zoom;
	private Integer readcount;
	private Integer starsum;
	private Integer starusersum;
	private Integer replycount;
	private Integer gousersum;
	private String coupontypename;
	private String coupontypeid;

	// Constructors

	/** default constructor */
	public CouponT() {
	}

	/** full constructor */
	public CouponT(String cid, String ctitle, String cimage, Date endtime, String details, Date createtime, Date modifytime, Date begintime, String creatorid, double lat, double lng, Integer zoom, Integer readcount, Integer starsum, Integer starusersum, Integer replycount, Integer gousersum, String coupontypename, String coupontypeid) {
		this.cid = cid;
		this.ctitle = ctitle;
		this.cimage = cimage;
		this.endtime = endtime;
		this.details = details;
		this.createtime = createtime;
		this.modifytime = modifytime;
		this.begintime = begintime;
		this.creatorid = creatorid;
		this.lat = lat;
		this.lng = lng;
		this.zoom = zoom;
		this.readcount = readcount;
		this.starsum = starsum;
		this.starusersum = starusersum;
		this.replycount = replycount;
		this.gousersum = gousersum;
		this.coupontypename = coupontypename;
		this.coupontypeid = coupontypeid;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCtitle() {
		return this.ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCimage() {
		return this.cimage;
	}

	public void setCimage(String cimage) {
		this.cimage = cimage;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Date getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return this.lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Integer getZoom() {
		return this.zoom;
	}

	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}

	public Integer getReadcount() {
		return this.readcount;
	}

	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}

	public Integer getStarsum() {
		return this.starsum;
	}

	public void setStarsum(Integer starsum) {
		this.starsum = starsum;
	}

	public Integer getStarusersum() {
		return this.starusersum;
	}

	public void setStarusersum(Integer starusersum) {
		this.starusersum = starusersum;
	}

	public Integer getReplycount() {
		return this.replycount;
	}

	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}

	public Integer getGousersum() {
		return this.gousersum;
	}

	public void setGousersum(Integer gousersum) {
		this.gousersum = gousersum;
	}

	public String getCoupontypename() {
		return this.coupontypename;
	}

	public void setCoupontypename(String coupontypename) {
		this.coupontypename = coupontypename;
	}

	public String getCoupontypeid() {
		return this.coupontypeid;
	}

	public void setCoupontypeid(String coupontypeid) {
		this.coupontypeid = coupontypeid;
	}

}