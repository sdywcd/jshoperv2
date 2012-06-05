package com.jshop.service;

import java.util.List;

import com.jshop.entity.GoodsGroupT;

public interface GoodsGroupTService {
	/**
	 * 增加团购商品
	 * @param group
	 * @return
	 */
	public int addGoodsGroupT(GoodsGroupT group);
	/**
	 * 修改团购商品参数
	 * @param group
	 * @return
	 */
	public int updateGoodsGroupT(GoodsGroupT group);
	/**
	 * 获取所有团购商品的信息
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public List<GoodsGroupT> findAllGoodsGroupT(final int currentPage,final int lineSize);
	/**
	 * 根据团购商品的ID删除团购商品
	 * @param list
	 * @return
	 */
	public int delGoodsGroupT(String []list);

}
