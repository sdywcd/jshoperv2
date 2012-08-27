package com.jshop.service.impl;

import com.jshop.dao.EcouponTDao;
import com.jshop.entity.EcouponT;
import com.jshop.service.EcouponTService;

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

}
