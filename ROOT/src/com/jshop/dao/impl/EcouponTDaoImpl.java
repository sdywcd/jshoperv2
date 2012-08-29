package com.jshop.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.EcouponTDao;
import com.jshop.entity.EcouponT;
@Repository("ecouponTDao")
public class EcouponTDaoImpl extends HibernateDaoSupport implements EcouponTDao {
	
	public int addEcoupon(EcouponT et) {
		try {
			this.getHibernateTemplate().save(et);
			return 1;
		} catch (RuntimeException e) {			
			throw e;
		}
	}

	@Override
	public List<EcouponT> findAllEcoupon(final int currentPage, final int lineSize) {
		final String queryString="from EcouponT ";
		try {
			@SuppressWarnings("unchecked")
			List<EcouponT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					List list =query.list();
					return list;
				}
			});
			if(list.size()>0){
				return list;
			}
			return null;
		} catch (DataAccessException e) {			
			throw e;
		}
	}

	@Override
	public int countAllEcoupon() {
		String queryString ="select count(*) from EcouponT";
		try {
			List list = this.getHibernateTemplate().find(queryString);
			if(list.size()>0){
				Object o= list.get(0);
				long l = (Long) o;
				return (int)l;
			}
			return 0;
		} catch (DataAccessException e) {
			throw e;
			
		}
	}

}
