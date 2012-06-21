package com.jshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jshop.dao.GroupCartDao;
import com.jshop.entity.GroupCartT;
import com.jshop.service.GroupCartService;
@Service("groupCartService")
public class GroupCartServiceImpl implements GroupCartService {
	private GroupCartDao groupCartDao;

	public GroupCartDao getGroupCartDao() {
		return groupCartDao;
	}

	public void setGroupCartDao(GroupCartDao groupCartDao) {
		this.groupCartDao = groupCartDao;
	}


	public List<GroupCartT> findGroupById(String cartid) {
		
		return this.getGroupCartDao().findGroupById(cartid);
	}
	public int addgroupcart(GroupCartT gc) {
		
		return this.getGroupCartDao().addgroupcart(gc);
	}

	public int delGroupCart(String cartid) {
		
		return this.getGroupCartDao().delGroupCart(cartid);
	}

	@Override
	public List<GroupCartT> findAllGroupCartByUserId(String userid) {
		
		return this.getGroupCartDao().findAllGroupCartByUserId(userid);
	}

}
