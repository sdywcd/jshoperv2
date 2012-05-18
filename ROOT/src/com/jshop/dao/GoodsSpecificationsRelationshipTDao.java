package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsSpecificationsRelationshipT;

public interface GoodsSpecificationsRelationshipTDao {

	
	/**
	 * 检测商品和商品规格关系
	 * @return
	 */
	public List<GoodsSpecificationsRelationshipT>checkSpecificationRelationshipByspecificationsid(String specificationsid );
	
	
	/**
	 * 检测商品规格和商品关系
	 * @return
	 */
	public List<GoodsSpecificationsRelationshipT>checkSpecificationRelationshipBygoodssetid(String goodssetid);
	
	
	
	
	
	
}
