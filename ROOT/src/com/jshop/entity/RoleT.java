package com.jshop.entity;

import java.util.Date;

/**
 * RoleT entity. @author MyEclipse Persistence Tools
 */

public class RoleT implements java.io.Serializable {

	// Fields    

	private String roleid;
	private String rolename;
	private String note;
	private Date createtime;
	private String creatorid;

	// Constructors

	/** default constructor */
	public RoleT() {
	}

	/** full constructor */
	public RoleT(String roleid, String rolename, String note, Date createtime, String creatorid) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.note = note;
		this.createtime = createtime;
		this.creatorid = creatorid;
	}

	// Property accessors

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

}