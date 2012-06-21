package com.jshop.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GroupOrderTDao;
import com.jshop.entity.GroupOrderT;

@Repository("groupOrderTDao")
public class GroupOrderTDaoImpl extends HibernateDaoSupport implements GroupOrderTDao{

	@Override
	public int addGroupOrder(GroupOrderT got) {
		try {
			this.getHibernateTemplate().save(got);
			return 1;
		} catch (DataAccessException e) {
			throw e;
		}
	}
	

}
