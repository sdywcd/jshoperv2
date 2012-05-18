package com.jshop.entity;

import java.util.Date;

/**
 * TemplatethemeT entity. @author MyEclipse Persistence Tools
 */

public class TemplatethemeT implements java.io.Serializable {

	// Fields    

	private String ttid;
	private String note;
	private String themename;
	private Date createtime;
	private String creatorid;
	private String sign;
	private String status;

	// Constructors

	/** default constructor */
	public TemplatethemeT() {
	}

	/** full constructor */
	public TemplatethemeT(String ttid, String note, String themename, Date createtime, String creatorid, String sign, String status) {
		this.ttid = ttid;
		this.note = note;
		this.themename = themename;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.sign = sign;
		this.status = status;
	}

	// Property accessors

	public String getTtid() {
		return this.ttid;
	}

	public void setTtid(String ttid) {
		this.ttid = ttid;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getThemename() {
		return this.themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}