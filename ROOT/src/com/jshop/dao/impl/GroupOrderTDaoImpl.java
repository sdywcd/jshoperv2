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

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupOrderT> findAllGroupOrderT(final int currentPage, final int lineSize) {
		final String queryString ="from GroupOrderT order by createtime desc";
		try {
			List<GroupOrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					List list= query.list();
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
	public int countfindAllGroupOrderT() {
		try {
			String queryString ="select count(*) from GroupOrderT";
			List list=this.getHibernateTemplate().find(queryString);
			if(list.size()>0){
				Object o=list.get(0);
				long l = (Long) o;
				return (int) l;			
			}
			return 0;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupOrderT> sortAllGroupOrderT(final int currentPage,final int lineSize,
			final String queryString) {
		try {
			List<GroupOrderT> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					List list= query.list();
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
	}
