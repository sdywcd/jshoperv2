package com.jshop.entity;

import java.util.Date;

/**
 * ImgTypeT entity. @author MyEclipse Persistence Tools
 */

public class ImgTypeT implements java.io.Serializable {

	// Fields    

	private String imgTypeId;
	private String imgTypeName;
	private Date createtime;
	private String creatorid;

	// Constructors

	/** default constructor */
	public ImgTypeT() {
	}

	/** full constructor */
	public ImgTypeT(String imgTypeId, String imgTypeName, Date createtime, String creatorid) {
		this.imgTypeId = imgTypeId;
		this.imgTypeName = imgTypeName;
		this.createtime = createtime;
		this.creatorid = creatorid;
	}

	// Property accessors

	public String getImgTypeId() {
		return this.imgTypeId;
	}

	public void setImgTypeId(String imgTypeId) {
		this.imgTypeId = imgTypeId;
	}

	public String getImgTypeName() {
		return this.imgTypeName;
	}

	public void setImgTypeName(String imgTypeName) {
		this.imgTypeName = imgTypeName;
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

}