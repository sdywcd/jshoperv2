package com.jshop.entity;

/**
 * LogisticsbusinessareaT entity. @author MyEclipse Persistence Tools
 */

public class LogisticsbusinessareaT implements java.io.Serializable {

	// Fields    

	private String logbusareaid;
	private String logisticsid;
	private String logisticsname;
	private String areaname;
	private String costway;
	private double normalcost;
	private double overcost;
	private double freecount;
	private String sendarea;
	private String state;
	private double overvalue;
	private double needcostmin;
	private double needcostmax;

	// Constructors

	/** default constructor */
	public LogisticsbusinessareaT() {
	}

	/** minimal constructor */
	public LogisticsbusinessareaT(String logbusareaid, String logisticsid, String areaname, String state) {
		this.logbusareaid = logbusareaid;
		this.logisticsid = logisticsid;
		this.areaname = areaname;
		this.state = state;
	}

	/** full constructor */
	public LogisticsbusinessareaT(String logbusareaid, String logisticsid, String logisticsname, String areaname, String costway, double normalcost, double overcost, double freecount, String sendarea, String state, double overvalue, double needcostmin, double needcostmax) {
		this.logbusareaid = logbusareaid;
		this.logisticsid = logisticsid;
		this.logisticsname = logisticsname;
		this.areaname = areaname;
		this.costway = costway;
		this.normalcost = normalcost;
		this.overcost = overcost;
		this.freecount = freecount;
		this.sendarea = sendarea;
		this.state = state;
		this.overvalue = overvalue;
		this.needcostmin = needcostmin;
		this.needcostmax = needcostmax;
	}

	// Property accessors

	public String getLogbusareaid() {
		return this.logbusareaid;
	}

	public void setLogbusareaid(String logbusareaid) {
		this.logbusareaid = logbusareaid;
	}

	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public String getLogisticsname() {
		return this.logisticsname;
	}

	public void setLogisticsname(String logisticsname) {
		this.logisticsname = logisticsname;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getCostway() {
		return this.costway;
	}

	public void setCostway(String costway) {
		this.costway = costway;
	}

	public double getNormalcost() {
		return this.normalcost;
	}

	public void setNormalcost(double normalcost) {
		this.normalcost = normalcost;
	}

	public double getOvercost() {
		return this.overcost;
	}

	public void setOvercost(double overcost) {
		this.overcost = overcost;
	}

	public double getFreecount() {
		return this.freecount;
	}

	public void setFreecount(double freecount) {
		this.freecount = freecount;
	}

	public String getSendarea() {
		return this.sendarea;
	}

	public void setSendarea(String sendarea) {
		this.sendarea = sendarea;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public double getOvervalue() {
		return this.overvalue;
	}

	public void setOvervalue(double overvalue) {
		this.overvalue = overvalue;
	}

	public double getNeedcostmin() {
		return this.needcostmin;
	}

	public void setNeedcostmin(double needcostmin) {
		this.needcostmin = needcostmin;
	}

	public double getNeedcostmax() {
		return this.needcostmax;
	}

	public void setNeedcostmax(double needcostmax) {
		this.needcostmax = needcostmax;
	}

}