package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.SystemMailMDao;
import com.jshop.entity.SystemMailM;

/**
 * A data access object (DAO) providing persistence and search support for
 * SystemMailM entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.jshop.entity.SystemMailM
 * @author MyEclipse Persistence Tools
 */
@Repository("systemMailMDao")
public class SystemMailMDaoImpl extends HibernateDaoSupport implements SystemMailMDao {
	
	private static final Logger log = LoggerFactory.getLogger(SystemMailMDaoImpl.class);
	

	public int addSystemMail(SystemMailM sm) {
		log.debug("save SystemMailM");
		try {
			this.getHibernateTemplate().save(sm);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int updateSystemMail(final SystemMailM sm) {
		log.debug("update SystemMailM");
		try {

			final String queryString = "update SystemMailM as sm set sm.sysSendmail=:sysSendmail,sm.sysMailSmtp=:sysMailSmtp,sm.sysMailPort=:sysMailPort,sm.smtpusername=:smtpusername,sm.smtppwd=:smtppwd,sm.state=:state where sm.userid=:userid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					//					query.setParameter("smailid", sm.getSmailid());
					query.setParameter("userid", sm.getUserid());
					query.setParameter("sysSendmail", sm.getSysSendmail());
					query.setParameter("sysMailSmtp", sm.getSysMailSmtp());
					query.setParameter("sysMailPort", sm.getSysMailPort());
					query.setParameter("smtpusername", sm.getSmtpusername());
					query.setParameter("smtppwd", sm.getSmtppwd());
					query.setParameter("state", sm.getState());
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  SystemMailM error", re);
			throw re;
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public List<SystemMailM> findAllSystemMail(String taobaouserid) {
		log.debug("find all findAllSystemMail json");
		try {
			String queryString = "from SystemMailM as sy where sy.userid=:taobaouserid";
			List<SystemMailM> list = this.getHibernateTemplate().findByNamedParam(queryString, "taobaouserid", taobaouserid);
			if (list != null && list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all findAllSystemMail json error", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public SystemMailM findSysmailBysmailid(String smailid) {
		log.debug("find by userid SystemMailM");
		try {
			String queryString = "from SystemMailM as sy where sy.smailid=:smailid";
			List<SystemMailM> list = this.getHibernateTemplate().findByNamedParam(queryString, "smailid", smailid);
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id SystemMailM error", re);
			throw re;
		}
	}
}