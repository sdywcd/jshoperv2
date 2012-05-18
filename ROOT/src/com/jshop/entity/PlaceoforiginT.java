package com.jshop.entity;

import java.util.Date;

/**
 * PlaceoforiginT entity. @author MyEclipse Persistence Tools
 */

public class PlaceoforiginT implements java.io.Serializable {

	// Fields    

	private String placeid;
	private String placename;
	private String creatorid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public PlaceoforiginT() {
	}

	/** full constructor */
	public PlaceoforiginT(String placeid, String placename, String creatorid, Date createtime) {
		this.placeid = placeid;
		this.placename = placename;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	// Property accessors

	public String getPlaceid() {
		return this.placeid;
	}

	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}

	public String getPlacename() {
		return this.placename;
	}

	public void setPlacename(String placename) {
		this.placename = placename;
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