package com.room.model;

import java.util.List;

import org.hibernate.*;
import hibernate.util.HibernateUtil;

public class RoomDAO implements RoomDAO_interface {
	private static final String GET_ALL_STMT = "from RoomVO order by roomID";

	@Override
	public void insert(RoomVO roomVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(roomVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

	}

	@Override
	public void update(RoomVO roomVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(roomVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}

	}


	@Override
	public RoomVO findByPrimaryKey(Integer roomID) {
		RoomVO roomVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			roomVO = (RoomVO) session.get(RoomVO.class, roomID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return roomVO;
	}

	@Override
	public List<RoomVO> getAll() {
		List<RoomVO> list = null;
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
