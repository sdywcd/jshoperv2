package com.jshop.entity;

import java.util.Date;

/**
 * GoodsstarCommentT entity. @author MyEclipse Persistence Tools
 */

public class GoodsstarCommentT implements java.io.Serializable {

	// Fields    

	private String starcommentid;
	private String goodsid;
	private Integer starnum;
	private String userid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public GoodsstarCommentT() {
	}

	/** full constructor */
	public GoodsstarCommentT(String starcommentid, String goodsid, Integer starnum, String userid, Date createtime) {
		this.starcommentid = starcommentid;
		this.goodsid = goodsid;
		this.starnum = starnum;
		this.userid = userid;
		this.createtime = createtime;
	}

	// Property accessors

	public String getStarcommentid() {
		return this.starcommentid;
	}

	public void setStarcommentid(String starcommentid) {
		this.starcommentid = starcommentid;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public Integer getStarnum() {
		return this.starnum;
	}

	public void setStarnum(Integer starnum) {
		this.starnum = starnum;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}