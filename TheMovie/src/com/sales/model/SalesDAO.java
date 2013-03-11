package com.sales.model;

/*
 Hibernate is providing a factory.getCurrentSession() method for retrieving the current session. A
 new session is opened for the first time of calling this method, and closed when the transaction is
 finished, no matter commit or rollback. But what does it mean by the ��current session��? We need to
 tell Hibernate that it should be the session bound with the current thread.

 <hibernate-configuration>
 <session-factory>
 ...
 <property name="current_session_context_class">thread</property>
 ...
 </session-factory>
 </hibernate-configuration>

 */

import org.hibernate.*;
import hibernate.util.HibernateUtil;
import java.util.*;

public class SalesDAO implements SalesDAO_interface {

	private static final String GET_ALL_STMT = "from salesVO order by salesID";

	@Override
	public void insert(SalesVO salesVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(salesVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(SalesVO salesVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(salesVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}


	@Override
	public SalesVO findByPrimaryKey(Integer salesID) {
		SalesVO salesVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			salesVO = (SalesVO) session.get(SalesVO.class, salesID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return salesVO;
	}

	@Override
	public List<SalesVO> getAll() {
		List<SalesVO> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	
}
