package com.jshop.entity;

import java.util.Date;

/**
 * GoodsTypeTN entity. @author MyEclipse Persistence Tools
 */

public class GoodsTypeTN implements java.io.Serializable {

	// Fields    

	private String goodsTypeId;
	private String name;
	private Date createtime;
	private String creatorid;
	private String goodsParameter;

	// Constructors

	/** default constructor */
	public GoodsTypeTN() {
	}

	/** minimal constructor */
	public GoodsTypeTN(String goodsTypeId, String name, Date createtime, String creatorid) {
		this.goodsTypeId = goodsTypeId;
		this.name = name;
		this.createtime = createtime;
		this.creatorid = creatorid;
	}

	/** full constructor */
	public GoodsTypeTN(String goodsTypeId, String name, Date createtime, String creatorid, String goodsParameter) {
		this.goodsTypeId = goodsTypeId;
		this.name = name;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.goodsParameter = goodsParameter;
	}

	// Property accessors

	public String getGoodsTypeId() {
		return this.goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGoodsParameter() {
		return this.goodsParameter;
	}

	public void setGoodsParameter(String goodsParameter) {
		this.goodsParameter = goodsParameter;
	}

}