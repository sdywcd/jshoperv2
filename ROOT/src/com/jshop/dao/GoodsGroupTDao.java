package com.jshop.dao;

import java.util.List;

import com.jshop.entity.GoodsGroupT;
import com.jshop.entity.GoodsT;

public interface GoodsGroupTDao {
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
	/**
	 * 统计所有团购商品的数量
	 * @param creatorid
	 * @return
	 */
	public int countAllGoodsGroupT();
	/**
	 *根据字段按照排序方式排序
	 * @param currentPage
	 * @param lineSize
	 * @param creatorid
	 * @param queryString
	 * @return
	 */
	public List<GoodsGroupT> sortAllGoodsGroup(final int currentPage, final int lineSize,  final String queryString);

}
