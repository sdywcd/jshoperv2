package com.jshop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.EcouponTDao;
import com.jshop.entity.EcouponT;
import com.jshop.service.EcouponTService;
@Service("ecouponTService")
@Scope("prototype")
public class EcouponTServiceImpl implements EcouponTService {
	private EcouponTDao ecouponTDao;
	
	public EcouponTDao getEcouponTDao() {
		return ecouponTDao;
	}

	public void setEcouponTDao(EcouponTDao ecouponTDao) {
		this.ecouponTDao = ecouponTDao;
	}

	@Override
	public int addEcoupon(EcouponT et) {		
		return this.getEcouponTDao().addEcoupon(et);
	}

	@Override
	public List<EcouponT> findAllEcoupon(int currentPage, int lineSize) {
		
		return this.getEcouponTDao().findAllEcoupon(currentPage, lineSize);
	}

	@Override
	public int countAllEcoupon() {
		// TODO Auto-generated method stub
		return this.getEcouponTDao().countAllEcoupon();
	}

}
