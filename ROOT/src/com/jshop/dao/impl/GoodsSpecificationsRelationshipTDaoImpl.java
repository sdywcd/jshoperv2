package com.jshop.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.jshop.entity.GoodsSpecificationsRelationshipT;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoodsSpecificationsRelationshipT entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see com.jshop.entity.GoodsSpecificationsRelationshipT
 * @author MyEclipse Persistence Tools
 */
@Repository("goodsSpecificationsRelationshipTDao")
public class GoodsSpecificationsRelationshipTDaoImpl extends HibernateDaoSupport  {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsSpecificationsRelationshipTDaoImpl.class);
	// property constants
	public static final String SPECIDICATIONS_ID = "specidicationsId";

	public void save(GoodsSpecificationsRelationshipT transientInstance) {
		log.debug("saving GoodsSpecificationsRelationshipT instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GoodsSpecificationsRelationshipT persistentInstance) {
		log.debug("deleting GoodsSpecificationsRelationshipT instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GoodsSpecificationsRelationshipT findById(java.lang.String id) {
		log.debug("getting GoodsSpecificationsRelationshipT instance with id: " + id);
		try {
			GoodsSpecificationsRelationshipT instance = (GoodsSpecificationsRelationshipT) getSession().get("com.jshop.entity.GoodsSpecificationsRelationshipT", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GoodsSpecificationsRelationshipT instance) {
		log.debug("finding GoodsSpecificationsRelationshipT instance by example");
		try {
			List results = getSession().createCriteria("com.jshop.entity.GoodsSpecificationsRelationshipT").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding GoodsSpecificationsRelationshipT instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from GoodsSpecificationsRelationshipT as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySpecidicationsId(Object specidicationsId) {
		return findByProperty(SPECIDICATIONS_ID, specidicationsId);
	}

	public List findAll() {
		log.debug("finding all GoodsSpecificationsRelationshipT instances");
		try {
			String queryString = "from GoodsSpecificationsRelationshipT";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GoodsSpecificationsRelationshipT merge(GoodsSpecificationsRelationshipT detachedInstance) {
		log.debug("merging GoodsSpecificationsRelationshipT instance");
		try {
			GoodsSpecificationsRelationshipT result = (GoodsSpecificationsRelationshipT) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GoodsSpecificationsRelationshipT instance) {
		log.debug("attaching dirty GoodsSpecificationsRelationshipT instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GoodsSpecificationsRelationshipT instance) {
		log.debug("attaching clean GoodsSpecificationsRelationshipT instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}