package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GroupOrderTDao;
import com.jshop.entity.GroupOrderT;
import com.jshop.service.GroupOrderTService;
@Service("groupOrderTService")
@Scope("prototype")
public class GroupOrderTServiceImpl implements GroupOrderTService {
	private GroupOrderTDao groupOrderTDao;
	
	public GroupOrderTDao getGroupOrderTDao() {
		return groupOrderTDao;
	}

	public void setGroupOrderTDao(GroupOrderTDao groupOrderTDao) {
		this.groupOrderTDao = groupOrderTDao;
	}

	@Override
	public int addGroupOrder(GroupOrderT got) {
		
		return this.getGroupOrderTDao().addGroupOrder(got);
	}

}
