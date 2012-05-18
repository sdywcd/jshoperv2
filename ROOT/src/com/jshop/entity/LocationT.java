package com.jshop.entity;

/**
 * LocationT entity. @author MyEclipse Persistence Tools
 */

public class LocationT implements java.io.Serializable {

	// Fields    

	private String lid;
	private String userid;
	private String username;
	private double lat;
	private double lng;
	private Integer zoom;
	private Integer version;

	// Constructors

	/** default constructor */
	public LocationT() {
	}

	/** full constructor */
	public LocationT(String lid, String userid, String username, double lat, double lng, Integer zoom, Integer version) {
		this.lid = lid;
		this.userid = userid;
		this.username = username;
		this.lat = lat;
		this.lng = lng;
		this.zoom = zoom;
		this.version = version;
	}

	// Property accessors

	public String getLid() {
		return this.lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return this.lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public Integer getZoom() {
		return this.zoom;
	}

	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}

	public Integer getVersion() {
		return this.version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}