package com.jshop.dao;

import java.util.List;

import com.jshop.entity.CartT;
import com.jshop.entity.GroupCartT;

public interface GroupCartDao {
	/**
	 * 根据ID查询团购商品
	 * @param groupid
	 * @return
	 */
	public List<GroupCartT> findGroupById(String groupid);
	/**
	 * 添加团购商品到购物车
	 * @param gc
	 * @return
	 */
	public int addgroupcart(GroupCartT gc);
	/**
	 * 根据ID删除商品
	 * @param groupid
	 * @return
	 * 
	 */
	public int delGroupCart(String cartid);
	/**
	 * 根据userid查询团购购物车内容 前台
	 * @param userid
	 * @return
	 */
	public abstract List<GroupCartT>findAllGroupCartByUserId(String userid);

}
