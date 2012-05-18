package com.jshop.entity;

/**
 * GoodsTypeBrandT entity. @author MyEclipse Persistence Tools
 */

public class GoodsTypeBrandT implements java.io.Serializable {

	// Fields    

	private String goodsTypeBrandTid;
	private String goodsTypeId;
	private String name;
	private String brandname;
	private String brandid;

	// Constructors

	/** default constructor */
	public GoodsTypeBrandT() {
	}

	/** minimal constructor */
	public GoodsTypeBrandT(String goodsTypeBrandTid) {
		this.goodsTypeBrandTid = goodsTypeBrandTid;
	}

	/** full constructor */
	public GoodsTypeBrandT(String goodsTypeBrandTid, String goodsTypeId, String name, String brandname, String brandid) {
		this.goodsTypeBrandTid = goodsTypeBrandTid;
		this.goodsTypeId = goodsTypeId;
		this.name = name;
		this.brandname = brandname;
		this.brandid = brandid;
	}

	// Property accessors

	public String getGoodsTypeBrandTid() {
		return this.goodsTypeBrandTid;
	}

	public void setGoodsTypeBrandTid(String goodsTypeBrandTid) {
		this.goodsTypeBrandTid = goodsTypeBrandTid;
	}

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

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBrandid() {
		return this.brandid;
	}

	public void setBrandid(String brandid) {
		this.brandid = brandid;
	}

}