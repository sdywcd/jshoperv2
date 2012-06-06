package com.jshop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.GoodsGroupTDao;
import com.jshop.entity.GoodsGroupT;
import com.jshop.service.GoodsGroupTService;
@Service("goodsGroupTService")
@Scope("prototype")
public class GoodsGroupTServiceImpl implements GoodsGroupTService {
	public GoodsGroupTDao goodsgrouptDao;
	

	public GoodsGroupTDao getGoodsgrouptDao() {
		return goodsgrouptDao;
	}

	public void setGoodsgrouptDao(GoodsGroupTDao goodsgrouptDao) {
		this.goodsgrouptDao = goodsgrouptDao;
	}

	@Override
	public int addGoodsGroupT(GoodsGroupT group) {
		
		return this.getGoodsgrouptDao().addGoodsGroupT(group);
	}

	@Override
	public int updateGoodsGroupT(GoodsGroupT group) {
		
		return this.getGoodsgrouptDao().updateGoodsGroupT(group);
	}

	@Override
	public List<GoodsGroupT> findAllGoodsGroupT(int currentPage, int lineSize) {
		
		return this.getGoodsgrouptDao().findAllGoodsGroupT(currentPage, lineSize);
	}

	@Override
	public int delGoodsGroupT(String[] list) {
		
		return this.getGoodsgrouptDao().delGoodsGroupT(list);
	}

}
