package com.jshop.entity;

import java.util.Date;

/**
 * TableT entity. @author MyEclipse Persistence Tools
 */

public class TableT implements java.io.Serializable {

	// Fields    

	private String tableid;
	private String tableNumber;
	private String roomName;
	private Integer androidDevicesCount;
	private String note;
	private Date createtime;
	private String creatorid;
	private Integer nop;
	private String tablestate;
	private Integer floor;
	private Integer rnop;

	// Constructors

	/** default constructor */
	public TableT() {
	}

	/** minimal constructor */
	public TableT(String tableid, String tableNumber, String roomName, Date createtime, String creatorid, String tablestate, Integer floor) {
		this.tableid = tableid;
		this.tableNumber = tableNumber;
		this.roomName = roomName;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.tablestate = tablestate;
		this.floor = floor;
	}

	/** full constructor */
	public TableT(String tableid, String tableNumber, String roomName, Integer androidDevicesCount, String note, Date createtime, String creatorid, Integer nop, String tablestate, Integer floor, Integer rnop) {
		this.tableid = tableid;
		this.tableNumber = tableNumber;
		this.roomName = roomName;
		this.androidDevicesCount = androidDevicesCount;
		this.note = note;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.nop = nop;
		this.tablestate = tablestate;
		this.floor = floor;
		this.rnop = rnop;
	}

	// Property accessors

	public String getTableid() {
		return this.tableid;
	}

	public void setTableid(String tableid) {
		this.tableid = tableid;
	}

	public String getTableNumber() {
		return this.tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getAndroidDevicesCount() {
		return this.androidDevicesCount;
	}

	public void setAndroidDevicesCount(Integer androidDevicesCount) {
		this.androidDevicesCount = androidDevicesCount;
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

	public Integer getNop() {
		return this.nop;
	}

	public void setNop(Integer nop) {
		this.nop = nop;
	}

	public String getTablestate() {
		return this.tablestate;
	}

	public void setTablestate(String tablestate) {
		this.tablestate = tablestate;
	}

	public Integer getFloor() {
		return this.floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getRnop() {
		return this.rnop;
	}

	public void setRnop(Integer rnop) {
		this.rnop = rnop;
	}

}