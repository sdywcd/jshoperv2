package com.jshop.entity;

// Generated 2012-7-27 14:17:45 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * GoodsunitT generated by hbm2java
 */
public class GoodsunitT implements java.io.Serializable {

	private String unitid;
	private String unitname;
	private String engunitname;
	private String creatorid;
	private Date createtime;

	public GoodsunitT() {
	}

	public GoodsunitT(String unitid, String unitname, String creatorid,
			Date createtime) {
		this.unitid = unitid;
		this.unitname = unitname;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	public GoodsunitT(String unitid, String unitname, String engunitname,
			String creatorid, Date createtime) {
		this.unitid = unitid;
		this.unitname = unitname;
		this.engunitname = engunitname;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	public String getUnitid() {
		return this.unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}

	public String getUnitname() {
		return this.unitname;
	}

	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}

	public String getEngunitname() {
		return this.engunitname;
	}

	public void setEngunitname(String engunitname) {
		this.engunitname = engunitname;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
