package com.jshop.entity;

import java.util.Date;

/**
 * SerialT entity. @author MyEclipse Persistence Tools
 */

public class SerialT implements java.io.Serializable {

	// Fields    

	private String biz;
	private String head;
	private String lastid;
	private Integer increment;
	private Date updatetime;

	// Constructors

	/** default constructor */
	public SerialT() {
	}

	/** minimal constructor */
	public SerialT(String biz, String lastid, Integer increment, Date updatetime) {
		this.biz = biz;
		this.lastid = lastid;
		this.increment = increment;
		this.updatetime = updatetime;
	}

	/** full constructor */
	public SerialT(String biz, String head, String lastid, Integer increment, Date updatetime) {
		this.biz = biz;
		this.head = head;
		this.lastid = lastid;
		this.increment = increment;
		this.updatetime = updatetime;
	}

	// Property accessors

	public String getBiz() {
		return this.biz;
	}

	public void setBiz(String biz) {
		this.biz = biz;
	}

	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getLastid() {
		return this.lastid;
	}

	public void setLastid(String lastid) {
		this.lastid = lastid;
	}

	public Integer getIncrement() {
		return this.increment;
	}

	public void setIncrement(Integer increment) {
		this.increment = increment;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

}