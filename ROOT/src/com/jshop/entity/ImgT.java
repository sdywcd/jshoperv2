package com.jshop.entity;

import java.util.Date;

/**
 * ImgT entity. @author MyEclipse Persistence Tools
 */

public class ImgT implements java.io.Serializable {

	// Fields    

	private String imgId;
	private String imgName;
	private String usedGoodsid;
	private String imgType;
	private String imgHref;
	private String des;
	private String imgTypeId;
	private String imgTypeName;
	private String usedPositionName;
	private String usedPositionId;
	private Integer version;
	private String usedGoodsname;
	private Date createtime;
	private String creatorid;
	private String state;

	// Constructors

	/** default constructor */
	public ImgT() {
	}

	/** minimal constructor */
	public ImgT(String imgId, String imgHref, Date createtime, String creatorid, String state) {
		this.imgId = imgId;
		this.imgHref = imgHref;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.state = state;
	}

	/** full constructor */
	public ImgT(String imgId, String imgName, String usedGoodsid, String imgType, String imgHref, String des, String imgTypeId, String imgTypeName, String usedPositionName, String usedPositionId, Integer version, String usedGoodsname, Date createtime, String creatorid, String state) {
		this.imgId = imgId;
		this.imgName = imgName;
		this.usedGoodsid = usedGoodsid;
		this.imgType = imgType;
		this.imgHref = imgHref;
		this.des = des;
		this.imgTypeId = imgTypeId;
		this.imgTypeName = imgTypeName;
		this.usedPositionName = usedPositionName;
		this.usedPositionId = usedPositionId;
		this.version = version;
		this.usedGoodsname = usedGoodsname;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.state = state;
	}

	// Property accessors

	public String getImgId() {
		return this.imgId;
	}

	public void setImgId(String imgId) {
		this.imgId = imgId;
	}

	public String getImgName() {
		return this.imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getUsedGoodsid() {
		return this.usedGoodsid;
	}

	public void setUsedGoodsid(String usedGoodsid) {
		this.usedGoodsid = usedGoodsid;
	}

	public String getImgType() {
		return this.imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getImgHref() {
		return this.imgHref;
	}

	public void setImgHref(String imgHref) {
		this.imgHref = imgHref;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

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

	public String getUsedPositionName() {
		return this.usedPositionName;
	}

	public void setUsedPositionName(String usedPositionName) {
		this.usedPositionName = usedPositionName;
	}

	public String getUsedPositionId() {
		return this.usedPositionId;
	}

	public void setUsedPositionId(String usedPositionId) {
		this.usedPositionId = usedPositionId;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getUsedGoodsname() {
		return this.usedGoodsname;
	}

	public void setUsedGoodsname(String usedGoodsname) {
		this.usedGoodsname = usedGoodsname;
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

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}