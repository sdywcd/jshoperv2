package com.jshop.entity;

/**
 * RoleFunctionM entity. @author MyEclipse Persistence Tools
 */

public class RoleFunctionM implements java.io.Serializable {

	// Fields    

	private String id;
	private String roleid;
	private String functionid;

	// Constructors

	/** default constructor */
	public RoleFunctionM() {
	}

	/** full constructor */
	public RoleFunctionM(String id, String roleid, String functionid) {
		this.id = id;
		this.roleid = roleid;
		this.functionid = functionid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getFunctionid() {
		return this.functionid;
	}

	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

}