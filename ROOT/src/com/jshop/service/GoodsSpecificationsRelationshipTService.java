package com.jshop.service;

import java.util.List;

import com.jshop.entity.GoodsSpecificationsRelationshipT;


public interface GoodsSpecificationsRelationshipTService {
	
	/**
	 * 增加商品规格
	 * @param gsrt
	 * @return
	 */
	public abstract int addGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt);
	
	/**
	 * 更新商品规格
	 * @param gsrt
	 * @return
	 */
	public abstract int updateGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt);
	
	/**
	 * 删除商品规格
	 * @param list
	 * @return
	 */
	public abstract int delGoodsAssociatedProductById(final String goodssetid);
	
	/**
	 * 通过goodssetid 查找规格
	 * @param goodssetid
	 * @return
	 */
	public abstract List<GoodsSpecificationsRelationshipT> checkSpecificationRelationshipBygoodssetid(String goodssetid);

}
