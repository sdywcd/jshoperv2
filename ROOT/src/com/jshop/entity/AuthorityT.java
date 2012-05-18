package com.jshop.entity;

import java.util.Date;

/**
 * AuthorityT entity. @author MyEclipse Persistence Tools
 */

public class AuthorityT implements java.io.Serializable {

	// Fields    

	private String autid;
	private String chpagename;
	private String enpagename;
	private String operate;
	private Date createtime;
	private String roleid;

	// Constructors

	/** default constructor */
	public AuthorityT() {
	}

	/** minimal constructor */
	public AuthorityT(String autid, String chpagename, String enpagename, String operate, Date createtime) {
		this.autid = autid;
		this.chpagename = chpagename;
		this.enpagename = enpagename;
		this.operate = operate;
		this.createtime = createtime;
	}

	/** full constructor */
	public AuthorityT(String autid, String chpagename, String enpagename, String operate, Date createtime, String roleid) {
		this.autid = autid;
		this.chpagename = chpagename;
		this.enpagename = enpagename;
		this.operate = operate;
		this.createtime = createtime;
		this.roleid = roleid;
	}

	// Property accessors

	public String getAutid() {
		return this.autid;
	}

	public void setAutid(String autid) {
		this.autid = autid;
	}

	public String getChpagename() {
		return this.chpagename;
	}

	public void setChpagename(String chpagename) {
		this.chpagename = chpagename;
	}

	public String getEnpagename() {
		return this.enpagename;
	}

	public void setEnpagename(String enpagename) {
		this.enpagename = enpagename;
	}

	public String getOperate() {
		return this.operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}