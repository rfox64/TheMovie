package com.rounds.model;

import hibernate.util.HibernateUtil;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class RoundsDAO implements RoundsDAO_interface{

	private static final String GET_ALL_STMT = "from RoundsVO order by roundsID";

	@Override
	public void insert(RoundsVO roundsVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(roundsVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(RoundsVO roundsVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(roundsVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer roundsID) {
		
	}

	@Override
	public RoundsVO findByPrimaryKey(Integer roundsID) {
		RoundsVO roundsVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			roundsVO = (RoundsVO) session.get(RoundsVO.class, roundsID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return roundsVO;
	}

	private static final String GET_BY_MVID_STMT = "from RoundsVO where mvID=";
	@Override
	public List<RoundsVO> findByMvID(Integer mvID) {
		List<RoundsVO> list = null;
		RoundsVO roundsVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Query query = session.createQuery(GET_BY_MVID_STMT+mvID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	private static final String GET_BY_ROOMID_STMT = "from RoundsVO where roomID=";
	@Override
	public List<RoundsVO> findByRoomID(Integer roomID) {
		List<RoundsVO> list = null;
		RoundsVO roundsVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Query query = session.createQuery(GET_BY_ROOMID_STMT+roomID);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<RoundsVO> findByDateTime(Timestamp startDateTime, Timestamp endDateTime) {
		List<RoundsVO> list = null;
		RoundsVO roundsVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Query query = session.createQuery("from RoundVO where " +
					"roundsDateTime>'"+startDateTime+
					"' roundsDateTime<'"+endDateTime+"'");
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<RoundsVO> getAll() {
		List<RoundsVO> list = null;
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
