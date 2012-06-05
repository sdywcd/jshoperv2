package com.jshop.service.impl;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsSpecificationsRelationshipTDao;
import com.jshop.entity.GoodsSpecificationsRelationshipT;
import com.jshop.service.GoodsSpecificationsRelationshipTService;
@Service("goodsSpecificationsRelationshipTService")
@Scope("prototype")
public class GoodsSpecificationsRelationshipTServiceImpl implements GoodsSpecificationsRelationshipTService  {
	
	private GoodsSpecificationsRelationshipTDao goodsSpecificationsRelationshipTDao;

	public GoodsSpecificationsRelationshipTDao getGoodsSpecificationsRelationshipTDao() {
		return goodsSpecificationsRelationshipTDao;
	}

	public void setGoodsSpecificationsRelationshipTDao(
			GoodsSpecificationsRelationshipTDao goodsSpecificationsRelationshipTDao) {
		this.goodsSpecificationsRelationshipTDao = goodsSpecificationsRelationshipTDao;
	}

	@Override
	public int addGoodsAssociatedProductById(
			GoodsSpecificationsRelationshipT gsrt) {
		
		return this.getGoodsSpecificationsRelationshipTDao().addGoodsAssociatedProductById(gsrt);
	}

	@Override
	public int updateGoodsAssociatedProductById(
			GoodsSpecificationsRelationshipT gsrt) {
		
		return this.getGoodsSpecificationsRelationshipTDao().updateGoodsAssociatedProductById(gsrt);
		
	}

	@Override
	public int delGoodsAssociatedProductById(String[] list) {
		
		return this.getGoodsSpecificationsRelationshipTDao().delGoodsAssociatedProductById(list);
	}
	
	
	
}
