package com.jshop.entity;

/**
 * GoodsSpecificationsRelationshipT entity. @author MyEclipse Persistence Tools
 */

public class GoodsSpecificationsRelationshipT implements java.io.Serializable {

	// Fields    

	private String goodsSetId;
	private String specidicationsId;

	// Constructors

	/** default constructor */
	public GoodsSpecificationsRelationshipT() {
	}

	/** full constructor */
	public GoodsSpecificationsRelationshipT(String goodsSetId, String specidicationsId) {
		this.goodsSetId = goodsSetId;
		this.specidicationsId = specidicationsId;
	}

	// Property accessors

	public String getGoodsSetId() {
		return this.goodsSetId;
	}

	public void setGoodsSetId(String goodsSetId) {
		this.goodsSetId = goodsSetId;
	}

	public String getSpecidicationsId() {
		return this.specidicationsId;
	}

	public void setSpecidicationsId(String specidicationsId) {
		this.specidicationsId = specidicationsId;
	}

}