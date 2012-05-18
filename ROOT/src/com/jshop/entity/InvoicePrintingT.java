package com.jshop.entity;

import java.sql.Date;

/**
 * InvoicePrintingT entity. @author MyEclipse Persistence Tools
 */

public class InvoicePrintingT implements java.io.Serializable {

	// Fields

	private String invoicePrintingId;
	private String orderid;
	private String operatorname;
	private Date createPrintingTime;

	// Constructors

	/** default constructor */
	public InvoicePrintingT() {
	}

	/** full constructor */
	public InvoicePrintingT(String invoicePrintingId, String orderid,
			String operatorname, Date createPrintingTime) {
		this.invoicePrintingId = invoicePrintingId;
		this.orderid = orderid;
		this.operatorname = operatorname;
		this.createPrintingTime = createPrintingTime;
	}

	// Property accessors

	public String getInvoicePrintingId() {
		return this.invoicePrintingId;
	}

	public void setInvoicePrintingId(String invoicePrintingId) {
		this.invoicePrintingId = invoicePrintingId;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getOperatorname() {
		return this.operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public Date getCreatePrintingTime() {
		return this.createPrintingTime;
	}

	public void setCreatePrintingTime(Date createPrintingTime) {
		this.createPrintingTime = createPrintingTime;
	}

}