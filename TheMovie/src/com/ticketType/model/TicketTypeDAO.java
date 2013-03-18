package com.ticketType.model;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class TicketTypeDAO implements TicketTypeDAO_interface {
	private static final String GET_ALL_STMT = "from TicketTypeVO order by typeID";
	@Override
	public void insert(TicketTypeVO ticketTypeVO) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ticketTypeVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(TicketTypeVO ticketTypeVO) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.update(ticketTypeVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public TicketTypeVO selectByPK(Integer typeID) {
		// TODO Auto-generated method stub
		TicketTypeVO ticketTypeVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			ticketTypeVO = (TicketTypeVO) session.get(TicketTypeVO.class, typeID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return ticketTypeVO;
	}

	@Override
	public List<TicketTypeVO> selectAll() {
		// TODO Auto-generated method stub
		List<TicketTypeVO> list = null;
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
	public void delete(Integer typeID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

			TicketTypeVO ticketTypeVO = new TicketTypeVO();
			ticketTypeVO.setTypeID(typeID);
			session.delete(ticketTypeVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TicketTypeDAO dao = new TicketTypeDAO();
		List<TicketTypeVO> list = dao.selectAll();
		for (TicketTypeVO aEmp : list) {
			System.out.print(aEmp.getTypeID() + ",");
			System.out.print(aEmp.getRoomType() + ",");
			System.out.print(aEmp.getTypeName() + ",");
			System.out.print(aEmp.getTypePrice() + ",");
			System.out.print(aEmp.getSummary() + ",");
		
			// 注意以下三行的寫法 (優!)
//			System.out.print(aEmp.getDeptVO().getDeptno() + ",");
//			System.out.print(aEmp.getDeptVO().getDname() + ",");
//			System.out.print(aEmp.getDeptVO().getLoc());
//			System.out.println();
		}

	}

	

}
