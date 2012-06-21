package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GroupCartDao;
import com.jshop.entity.CartT;
import com.jshop.entity.GroupCartT;
@Repository("groupCartDao")
public class GroupCatTDaoImpl extends HibernateDaoSupport implements GroupCartDao {
	private static final Log log = LogFactory.getLog(CartTDaoImpl.class);
	@Override
	public List<GroupCartT> findGroupById(final String cartid) {
		try {
			String queryString ="from GroupCartT as gt where gt.cartid=:cartid";
			List<GroupCartT> list=this.getHibernateTemplate().findByNamedParam(queryString, "cartid", cartid);
			if(list!=null){
				return list;
			}
			return null;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	
	@Override
	public int addgroupcart(GroupCartT gc) {
		try {
			this.getHibernateTemplate().save(gc);
			return 1;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public int delGroupCart(final String cartid) {
		final String queryString="delete from GroupCartT as gt where gt.cartid=:cartid";
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i=0;
					Query query = session.createQuery(queryString);
					query.setParameter("cartid",cartid);
					i=query.executeUpdate();
					if(i>0){
						return i;
					}else{
						return 0;	
					}			
				}
			});
		} catch (DataAccessException e) {
			throw e;
		}
		return 0;
		
	}


	@Override
	public List<GroupCartT> findAllGroupCartByUserId(String userid) {
		log.debug("find all GroupCartT ");
		try {
			String queryString = "from GroupCartT as c where c.userid=:userid and c.state='1' order by addtime desc";
			List<GroupCartT> list = this.getHibernateTemplate().findByNamedParam(queryString, "userid", userid);
			if (list != null) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all GroupCartT  error", re);
			throw re;
		}
	}

}
