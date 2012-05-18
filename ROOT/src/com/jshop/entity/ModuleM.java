package com.jshop.entity;

import java.util.Date;

/**
 * ModuleM entity. @author MyEclipse Persistence Tools
 */

public class ModuleM implements java.io.Serializable {

	// Fields    

	private String id;
	private String modulename;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ModuleM() {
	}

	/** full constructor */
	public ModuleM(String id, String modulename, Date createtime) {
		this.id = id;
		this.modulename = modulename;
		this.createtime = createtime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModulename() {
		return this.modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}