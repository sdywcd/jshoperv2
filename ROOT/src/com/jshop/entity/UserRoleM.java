package com.jshop.entity;

/**
 * UserRoleM entity. @author MyEclipse Persistence Tools
 */

public class UserRoleM implements java.io.Serializable {

	// Fields    

	private String id;
	private String userid;
	private String roleid;

	// Constructors

	/** default constructor */
	public UserRoleM() {
	}

	/** full constructor */
	public UserRoleM(String id, String userid, String roleid) {
		this.id = id;
		this.userid = userid;
		this.roleid = roleid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

}