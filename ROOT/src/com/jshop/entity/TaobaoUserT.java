package com.jshop.entity;

/**
 * TaobaoUserT entity. @author MyEclipse Persistence Tools
 */

public class TaobaoUserT implements java.io.Serializable {

	// Fields    

	private String taobaoUserid;
	private String taobaoNick;

	// Constructors

	/** default constructor */
	public TaobaoUserT() {
	}

	/** full constructor */
	public TaobaoUserT(String taobaoUserid, String taobaoNick) {
		this.taobaoUserid = taobaoUserid;
		this.taobaoNick = taobaoNick;
	}

	// Property accessors

	public String getTaobaoUserid() {
		return this.taobaoUserid;
	}

	public void setTaobaoUserid(String taobaoUserid) {
		this.taobaoUserid = taobaoUserid;
	}

	public String getTaobaoNick() {
		return this.taobaoNick;
	}

	public void setTaobaoNick(String taobaoNick) {
		this.taobaoNick = taobaoNick;
	}

}