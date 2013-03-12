package com.theaterpic.model;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.theater.model.TheaterVO;

public class TheaterpicDAO implements TheaterpicDAO_interface{
	private static final String GET_ALL_STMT = "from TheaterVO order by theaID";
	@Override
	public void insert(TheaterpicVO theapicVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(theapicVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
	}

	@Override
	public void update(TheaterpicVO theapicVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(theapicVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
	}

	@Override
	public TheaterpicVO findByPrimaryKey(Integer theaPicID) {
		TheaterpicVO theapicVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			theapicVO = (TheaterpicVO) session.get(TheaterVO.class, theaPicID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return theapicVO;
	}

	@Override
	public List<TheaterpicVO> getAll() {
		List<TheaterpicVO> list = null;
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

	@Override
	public void delete(Integer theaPicID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			TheaterpicVO theapicVO2 = (TheaterpicVO) session.get(TheaterpicVO.class, theaPicID);
			session.delete(theapicVO2);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
	}

}
