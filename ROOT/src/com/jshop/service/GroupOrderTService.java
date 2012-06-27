package com.jshop.service;

import java.util.List;

import com.jshop.entity.GroupOrderT;

public interface GroupOrderTService {
	/**
	 * 添加团购订单
	 * 
	 * @param got
	 * @return
	 */
	public int addGroupOrder(GroupOrderT got);
	/**
	 * 查询所有订单（后台）
	 * @param currentPage
	 * @param lineSize
	 * @return
	 */
	public abstract List<GroupOrderT>findAllGroupOrderT(final int currentPage,final int lineSize); 
	/**
	 * 统计查询所有订单（后台）
	 * @return
	 */
	public abstract int countfindAllGroupOrderT();
	/**
	 * 根据排序方式查询所有
	 * @param currentPage
	 * @param lineSize
	 * @param queryString
	 * @return
	 */
	public abstract List<GroupOrderT>sortAllGroupOrderT(final int currentPage,final int lineSize,String queryString); 
	



}
