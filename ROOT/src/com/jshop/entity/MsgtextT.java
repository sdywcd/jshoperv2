package com.jshop.entity;

import java.util.Date;

/**
 * MsgtextT entity. @author MyEclipse Persistence Tools
 */

public class MsgtextT implements java.io.Serializable {

	// Fields    

	private String msgtextid;
	private String text;
	private Date sendtime;

	// Constructors

	/** default constructor */
	public MsgtextT() {
	}

	/** full constructor */
	public MsgtextT(String msgtextid, String text, Date sendtime) {
		this.msgtextid = msgtextid;
		this.text = text;
		this.sendtime = sendtime;
	}

	// Property accessors

	public String getMsgtextid() {
		return this.msgtextid;
	}

	public void setMsgtextid(String msgtextid) {
		this.msgtextid = msgtextid;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

}