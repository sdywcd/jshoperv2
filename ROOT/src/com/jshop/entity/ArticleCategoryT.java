package com.jshop.entity;

import java.util.Date;

/**
 * ArticleCategoryT entity. @author MyEclipse Persistence Tools
 */

public class ArticleCategoryT implements java.io.Serializable {

	// Fields    

	private String articleCategoryTid;
	private String grade;
	private String metaKeywords;
	private String metaDes;
	private String name;
	private String status;
	private Date createtime;
	private String creatorid;
	private String path;
	private Integer sort;
	private String parentId;
	private String sign;
	private String parentName;
	private String position;

	// Constructors

	/** default constructor */
	public ArticleCategoryT() {
	}

	/** minimal constructor */
	public ArticleCategoryT(String articleCategoryTid, String grade, String name, String status, Date createtime, String creatorid, String path, Integer sort, String sign, String position) {
		this.articleCategoryTid = articleCategoryTid;
		this.grade = grade;
		this.name = name;
		this.status = status;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.path = path;
		this.sort = sort;
		this.sign = sign;
		this.position = position;
	}

	/** full constructor */
	public ArticleCategoryT(String articleCategoryTid, String grade, String metaKeywords, String metaDes, String name, String status, Date createtime, String creatorid, String path, Integer sort, String parentId, String sign, String parentName, String position) {
		this.articleCategoryTid = articleCategoryTid;
		this.grade = grade;
		this.metaKeywords = metaKeywords;
		this.metaDes = metaDes;
		this.name = name;
		this.status = status;
		this.createtime = createtime;
		this.creatorid = creatorid;
		this.path = path;
		this.sort = sort;
		this.parentId = parentId;
		this.sign = sign;
		this.parentName = parentName;
		this.position = position;
	}

	// Property accessors

	public String getArticleCategoryTid() {
		return this.articleCategoryTid;
	}

	public void setArticleCategoryTid(String articleCategoryTid) {
		this.articleCategoryTid = articleCategoryTid;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMetaKeywords() {
		return this.metaKeywords;
	}

	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}

	public String getMetaDes() {
		return this.metaDes;
	}

	public void setMetaDes(String metaDes) {
		this.metaDes = metaDes;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}