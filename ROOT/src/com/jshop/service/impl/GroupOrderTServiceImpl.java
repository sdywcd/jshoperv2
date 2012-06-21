package com.jshop.service.impl;

import com.jshop.entity.GroupOrderT;
import com.jshop.service.GroupOrderTService;

public class GroupOrderTServiceImpl implements GroupOrderTService {
	private GroupOrderTService groupOrderTService;
	public GroupOrderTService getGroupOrderTService() {
		return groupOrderTService;
	}
	public void setGroupOrderTService(GroupOrderTService groupOrderTService) {
		this.groupOrderTService = groupOrderTService;
	}
	@Override
	public int addGroupOrder(GroupOrderT got) {
		
		return this.getGroupOrderTService().addGroupOrder(got);
	}

}
