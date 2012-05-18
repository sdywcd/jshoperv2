package com.jshop.entity;

import java.util.Date;

/**
 * PageT entity. @author MyEclipse Persistence Tools
 */

public class PageT implements java.io.Serializable {

	// Fields    

	private String pageid;
	private String enpagename;
	private String cnpagename;
	private String url;
	private String rangearea;
	private String creatorid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public PageT() {
	}

	/** minimal constructor */
	public PageT(String pageid, String rangearea, String creatorid, Date createtime) {
		this.pageid = pageid;
		this.rangearea = rangearea;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	/** full constructor */
	public PageT(String pageid, String enpagename, String cnpagename, String url, String rangearea, String creatorid, Date createtime) {
		this.pageid = pageid;
		this.enpagename = enpagename;
		this.cnpagename = cnpagename;
		this.url = url;
		this.rangearea = rangearea;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	// Property accessors

	public String getPageid() {
		return this.pageid;
	}

	public void setPageid(String pageid) {
		this.pageid = pageid;
	}

	public String getEnpagename() {
		return this.enpagename;
	}

	public void setEnpagename(String enpagename) {
		this.enpagename = enpagename;
	}

	public String getCnpagename() {
		return this.cnpagename;
	}

	public void setCnpagename(String cnpagename) {
		this.cnpagename = cnpagename;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRangearea() {
		return this.rangearea;
	}

	public void setRangearea(String rangearea) {
		this.rangearea = rangearea;
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