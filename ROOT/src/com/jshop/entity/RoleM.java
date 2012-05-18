package com.jshop.entity;

import java.util.Date;

/**
 * RoleM entity. @author MyEclipse Persistence Tools
 */

public class RoleM implements java.io.Serializable {

	// Fields    

	private String id;
	private String rolename;
	private String note;
	private Date createtime;

	// Constructors

	/** default constructor */
	public RoleM() {
	}

	/** minimal constructor */
	public RoleM(String id, String rolename, Date createtime) {
		this.id = id;
		this.rolename = rolename;
		this.createtime = createtime;
	}

	/** full constructor */
	public RoleM(String id, String rolename, String note, Date createtime) {
		this.id = id;
		this.rolename = rolename;
		this.note = note;
		this.createtime = createtime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

}