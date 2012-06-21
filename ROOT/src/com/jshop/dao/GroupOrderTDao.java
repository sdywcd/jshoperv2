package com.jshop.dao;

import org.springframework.stereotype.Repository;

import com.jshop.entity.GroupOrderT;

public interface GroupOrderTDao {
	/**
	 * 添加团购订单
	 * 
	 * @param got
	 * @return
	 */
	
	public int addGroupOrder(GroupOrderT got);
	

}
