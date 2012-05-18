package com.jshop.entity;

/**
 * GlobalParamM entity. @author MyEclipse Persistence Tools
 */

public class GlobalParamM implements java.io.Serializable {

	// Fields    

	private String gkey;
	private String gvalue;

	// Constructors

	/** default constructor */
	public GlobalParamM() {
	}

	/** full constructor */
	public GlobalParamM(String gkey, String gvalue) {
		this.gkey = gkey;
		this.gvalue = gvalue;
	}

	// Property accessors

	public String getGkey() {
		return this.gkey;
	}

	public void setGkey(String gkey) {
		this.gkey = gkey;
	}

	public String getGvalue() {
		return this.gvalue;
	}

	public void setGvalue(String gvalue) {
		this.gvalue = gvalue;
	}

}