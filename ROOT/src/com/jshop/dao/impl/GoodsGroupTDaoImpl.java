package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.GoodsGroupTDao;
import com.jshop.entity.GoodsGroupT;
@Repository("goodsGroupTDao")
public class GoodsGroupTDaoImpl extends HibernateDaoSupport implements GoodsGroupTDao {
	private static final Logger log = LoggerFactory.getLogger(GoodsGroupTDaoImpl.class);
	

	@Override
	public int addGoodsGroupT(GoodsGroupT group) {
		log.debug("add GoodsGroupT");
		try {
			this.getHibernateTemplate().save(group);
			log.debug("add GoodsGroupT success");
			return 0;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.debug("add failed");
			throw e;
		}		
		
	}

	@Override
	public int updateGoodsGroupT(final GoodsGroupT group) {
		log.debug("update goodsGroupT");
		final String queryString="update GoodsGroupT as ggt set ggt.cashstate=:cashstate,ggt.cashlimit=:cashlimit,ggt,limitbuy=:limitbuy,ggt.salequantity=:salequantity where ggt.goodsid=:goodsid";
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("goodsid", group.getGoodsid());
					query.setParameter("cashstate", group.getCashstate());
					query.setParameter("cashlimit", group.getCashlimit());
					query.setParameter("limitbuy", group.getLimitbuy());
					query.setParameter("salequantity", group.getSalequantity());
					i= query.executeUpdate();
					return i;
				}
			});
		} catch (DataAccessException e) {
			log.debug("update goodsgroupT failed");
			throw e;
		}
		
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GoodsGroupT> findAllGoodsGroupT(final int currentPage, final int lineSize) {
		log.debug("find all goodsGroupT");
		try {
			List<GoodsGroupT> list =this.getHibernateTemplate().executeFind(new HibernateCallback() {
				String queryString="from GoodsGroupT order by createtime";
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage-1)*lineSize);
					query.setMaxResults(lineSize);
					List list=query.list();
					
					return list;
				}
			});
			if(list.size()>0&&list!=null){
				log.debug("find all success");
				return list;
			}			
			return null;
		} catch (DataAccessException e) {
			log.debug("find all failed");
			throw e;
		}
	}

	@Override
	public int delGoodsGroupT(final String[] list) {	
		log.debug("del goodsgroupt");
		try {
			this.getHibernateTemplate().execute(new HibernateCallback() {
				String queryString="delete from GoodsGroupT as ggt where ggt.goodsid=:goodsid";
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					Query query =  session.createQuery(queryString);
					int i = 0;
					for(String s : list){
						query.setParameter("goodsid", s);
						i=query.executeUpdate();
						i++;
					}
					if(list.length==i){
						log.debug("del success");
						return i;
					}else{
						return 0;
					}					
				}
			});
		} catch (DataAccessException e) {
			log.debug("del failed");
			throw e;
		}		
		return 0;
	}

}
