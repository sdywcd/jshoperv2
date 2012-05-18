package com.jshop.entity;

import java.util.Date;

/**
 * BrandT entity. @author MyEclipse Persistence Tools
 */

public class BrandT implements java.io.Serializable {

	// Fields    

	private String brandid;
	private String brandname;
	private String creatorid;
	private String username;
	private Date createtime;
	private String intro;
	private String logoPath;
	private Integer sort;
	private String url;

	// Constructors

	/** default constructor */
	public BrandT() {
	}

	/** minimal constructor */
	public BrandT(String brandid, String brandname, String creatorid, Date createtime) {
		this.brandid = brandid;
		this.brandname = brandname;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	/** full constructor */
	public BrandT(String brandid, String brandname, String creatorid, String username, Date createtime, String intro, String logoPath, Integer sort, String url) {
		this.brandid = brandid;
		this.brandname = brandname;
		this.creatorid = creatorid;
		this.username = username;
		this.createtime = createtime;
		this.intro = intro;
		this.logoPath = logoPath;
		this.sort = sort;
		this.url = url;
	}

	// Property accessors

	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getLogoPath() {
		return this.logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}