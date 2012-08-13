package com.jshop.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.jshop.dao.PaymentMDao;
import com.jshop.entity.PaymentM;

/**
 * A data access object (DAO) providing persistence and search support for
 * PaymentM entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.jshop.entity.PaymentM
 * @author MyEclipse Persistence Tools
 */

@Repository("paymentMDao")
public class PaymentMDaoImpl extends HibernateDaoSupport implements PaymentMDao {
	

	private static final Log log = LogFactory.getLog(PaymentMDaoImpl.class);
	
	public int addPayment(PaymentM pm) {
		log.debug("save PaymentM");
		try {
			this.getHibernateTemplate().save(pm);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int countfindAllPayment() {
		log.debug("count all PaymentM");
		try {
			String queryString = "select count(*) from PaymentM";
			List list = this.getHibernateTemplate().find(queryString);
			if (list.size() > 0) {
				Object o = list.get(0);
				long l = (Long) o;
				return (int) l;
			}
			return 0;
		} catch (RuntimeException re) {
			log.error("count all PaymentM error", re);
			throw re;
		}
	}

	public int openPayment(final String[] list) {
		log.debug("del PaymentM");
		try {

			final String queryString = "Update PaymentM as pm set pm.state='1' where pm.paymentid=:paymentid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("paymentid", s);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del PaymentM failed", re);
			throw re;
		}
		return 0;
	}

	public int closePayment(final String[] list) {
		log.debug("del PaymentM");
		try {

			final String queryString = "Update PaymentM as pm set pm.state='0' where pm.paymentid=:paymentid";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					int i = 0;
					for (String s : list) {
						query.setParameter("paymentid", s);
						i = query.executeUpdate();
						i++;
					}
					if (list.length == i) {
						return i;
					} else {
						return 0;
					}
				}
			});
		} catch (RuntimeException re) {
			log.error("del PaymentM failed", re);
			throw re;
		}
		return 0;
	}

	public List<PaymentM> findAllPayment(final int currentPage, final int lineSize) {
		log.debug("find all PaymentM");
		try {
			List<PaymentM> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

				String queryString = "from PaymentM";

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(queryString);
					query.setFirstResult((currentPage - 1) * lineSize);
					query.setMaxResults(lineSize);
					List list = query.list();
					return list;
				}
			});
			if (list.size() > 0) {
				return list;
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find all PaymentM error", re);
			throw re;
		}
	}

	public PaymentM findPaymentbyId(String paymentid) {
		log.debug("find by id PaymentM");
		try {
			String queryString = "from PaymentM as pm where pm.paymentid=:paymentid";
			List<PaymentM> list = this.getHibernateTemplate().findByNamedParam(queryString, "paymentid", paymentid);
			if (list != null) {
				return list.get(0);
			}
			return null;
		} catch (RuntimeException re) {
			log.error("find by id PaymentM error", re);
			throw re;
		}
	}

	public int updatePayment(final PaymentM pm) {
		log.debug("update PaymentM");
		try {
			final String queryString = "update PaymentM as pm set pm.paymentname=:paymentname,pm.paymentCode=:paymentCode,pm.paymentFree=:paymentFree,pm.paymentInterface=:paymentInterface,pm.account=:account,pm.safecode=:safecode,pm.partnerid=:partnerid,pm.des=:des,pm.isCod=:isCod,pm.isOnline=:isOnline,pm.state=:state where bt.paymentid=:paymentid ";
			this.getHibernateTemplate().execute(new HibernateCallback() {

				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					int i = 0;
					Query query = session.createQuery(queryString);
					query.setParameter("paymentid", pm.getPaymentid());
					query.setParameter("paymentname", pm.getPaymentname());
					query.setParameter("paymentCode", pm.getPaymentCode());
					query.setParameter("paymentFree", pm.getPaymentFree());
					query.setParameter("paymentInterface", pm.getPaymentInterface());
					query.setParameter("account", pm.getAccount());
					query.setParameter("safecode", pm.getSafecode());
					query.setParameter("partnerid", pm.getPartnerid());
					query.setParameter("des", pm.getDes());
					query.setParameter("isCod", pm.getIsCod());
					query.setParameter("isOnline", pm.getIsOnline());
					query.setParameter("state", pm.getState());
					i = query.executeUpdate();
					++i;
					return i;
				}
			});
		} catch (RuntimeException re) {
			log.error("update  BrandT error", re);
			throw re;
		}
		return 0;
	}

	public List<PaymentM> findAllPaymentWithoutPage() {
		log.debug("find PaymentM");
		try {
			String queryString = "from PaymentM as pm where pm.state='1'";
			List<PaymentM> list = this.getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			log.error("find  PaymentM error", re);
			throw re;
		}
	}
}