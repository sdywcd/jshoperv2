package com.jshop.entity;

import java.util.Date;

/**
 * ProductT entity. @author MyEclipse Persistence Tools
 */

public class ProductT implements java.io.Serializable {

	// Fields    

	private String productid;
	private double price;
	private double memberprice;
	private double cost;
	private double saleprice;
	private Integer freezeStore;
	private Integer store;
	private String isDefault;
	private String isSalestate;
	private String productName;
	private String productSn;
	private String specificationsValue;
	private String warehouseLocation;
	private String placeStore;
	private String weight;
	private String goodsid;
	private String creatorid;
	private Date createtime;

	// Constructors

	/** default constructor */
	public ProductT() {
	}

	/** minimal constructor */
	public ProductT(String productid, String isDefault, String isSalestate, String productName, String specificationsValue, String goodsid, String creatorid, Date createtime) {
		this.productid = productid;
		this.isDefault = isDefault;
		this.isSalestate = isSalestate;
		this.productName = productName;
		this.specificationsValue = specificationsValue;
		this.goodsid = goodsid;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	/** full constructor */
	public ProductT(String productid, double price, double memberprice, double cost, double saleprice, Integer freezeStore, Integer store, String isDefault, String isSalestate, String productName, String productSn, String specificationsValue, String warehouseLocation, String placeStore, String weight, String goodsid, String creatorid, Date createtime) {
		this.productid = productid;
		this.price = price;
		this.memberprice = memberprice;
		this.cost = cost;
		this.saleprice = saleprice;
		this.freezeStore = freezeStore;
		this.store = store;
		this.isDefault = isDefault;
		this.isSalestate = isSalestate;
		this.productName = productName;
		this.productSn = productSn;
		this.specificationsValue = specificationsValue;
		this.warehouseLocation = warehouseLocation;
		this.placeStore = placeStore;
		this.weight = weight;
		this.goodsid = goodsid;
		this.creatorid = creatorid;
		this.createtime = createtime;
	}

	// Property accessors

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMemberprice() {
		return this.memberprice;
	}

	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}

	public Integer getFreezeStore() {
		return this.freezeStore;
	}

	public void setFreezeStore(Integer freezeStore) {
		this.freezeStore = freezeStore;
	}

	public Integer getStore() {
		return this.store;
	}

	public void setStore(Integer store) {
		this.store = store;
	}

	public String getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getIsSalestate() {
		return this.isSalestate;
	}

	public void setIsSalestate(String isSalestate) {
		this.isSalestate = isSalestate;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSn() {
		return this.productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}

	public String getSpecificationsValue() {
		return this.specificationsValue;
	}

	public void setSpecificationsValue(String specificationsValue) {
		this.specificationsValue = specificationsValue;
	}

	public String getWarehouseLocation() {
		return this.warehouseLocation;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public String getPlaceStore() {
		return this.placeStore;
	}

	public void setPlaceStore(String placeStore) {
		this.placeStore = placeStore;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getCreatorid() {
		return this.creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}