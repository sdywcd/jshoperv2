package com.jshop.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.jshop.dao.EcouponTDao;
import com.jshop.entity.EcouponT;

public class EcouponTDaoImpl extends HibernateDaoSupport implements EcouponTDao {

	
	public int addEcoupon(EcouponT et) {
		try {
			this.getHibernateTemplate().save(et);
			return 1;
		} catch (RuntimeException e) {			
			throw e;
		}
	}

}
