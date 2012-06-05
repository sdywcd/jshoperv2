package com.jshop.service;

import com.jshop.entity.GoodsSpecificationsRelationshipT;


public interface GoodsSpecificationsRelationshipTService {
	
	/**
	 * 增加商品关联
	 * @param gsrt
	 * @return
	 */
	public abstract int addGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt);
	
	/**
	 * 更新商品关联
	 * @param gsrt
	 * @return
	 */
	public abstract int updateGoodsAssociatedProductById(GoodsSpecificationsRelationshipT gsrt);
	
	/**
	 * 删除商品关联
	 * @param list
	 * @return
	 */
	public abstract int delGoodsAssociatedProductById(final String[] list);

}
