package com.jshop.entity;

/**
 * InvoicetempleteT entity. @author MyEclipse Persistence Tools
 */

public class InvoicetempleteT implements java.io.Serializable {

	// Fields    

	private String invoicetempleteid;
	private String logisticsid;
	private String state;
	private String kindeditorCode;

	// Constructors

	/** default constructor */
	public InvoicetempleteT() {
	}

	/** minimal constructor */
	public InvoicetempleteT(String invoicetempleteid, String state, String kindeditorCode) {
		this.invoicetempleteid = invoicetempleteid;
		this.state = state;
		this.kindeditorCode = kindeditorCode;
	}

	/** full constructor */
	public InvoicetempleteT(String invoicetempleteid, String logisticsid, String state, String kindeditorCode) {
		this.invoicetempleteid = invoicetempleteid;
		this.logisticsid = logisticsid;
		this.state = state;
		this.kindeditorCode = kindeditorCode;
	}

	// Property accessors

	public String getInvoicetempleteid() {
		return this.invoicetempleteid;
	}

	public void setInvoicetempleteid(String invoicetempleteid) {
		this.invoicetempleteid = invoicetempleteid;
	}

	public String getLogisticsid() {
		return this.logisticsid;
	}

	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getKindeditorCode() {
		return this.kindeditorCode;
	}

	public void setKindeditorCode(String kindeditorCode) {
		this.kindeditorCode = kindeditorCode;
	}

}