package com.city.model;

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

public class CityDAO implements CityDAO_interface {

	private static final String GET_ALL_STMT = "from CityVO order by cityID";

	@Override
	public void insert(CityVO cityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(cityVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(CityVO cityVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(cityVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer cityID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

//        �i���ɦh��(�y)�i�ĥ�HQL�R���j
//			Query query = session.createQuery("delete EmpVO where empno=?");
//			query.setParameter(0, empno);
//			System.out.println("�R��������=" + query.executeUpdate());

//        �i�Φ��ɦh��(�])�i�ĥΥh�����p���Y��A�A�R�����覡�j
			CityVO cityVO = new CityVO();
			cityVO.setCityID(cityID);
			session.delete(cityVO);

//        �i���ɦh�褣�i(���y)�ĥ�cascade�p�ŧR���j
//        �i�h��emp2.hbm.xml�p�G�]�� cascade="all"�� cascade="delete"�N�|�R���Ҧ��������-�]�A���ݳ����P�P�������䥦���u�N�|�@�ֳQ�R���j
//			EmpVO empVO = (EmpVO) session.get(EmpVO.class, empno);
//			session.delete(empVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public CityVO findByPrimaryKey(Integer cityID) {
		CityVO cityVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			cityVO = (CityVO) session.get(CityVO.class, cityID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return cityVO;
	}

	@Override
	public List<CityVO> getAll() {
		List<CityVO> list = null;
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

	public static void main(String[] args) {

		CityDAO dao = new CityDAO();

		//�� �s�W
//		com.dept.model.DeptVO deptVO = new com.dept.model.DeptVO(); // ����POJO
//		deptVO.setDeptno(10);

//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("�d�ç�1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptVO(deptVO);
//		dao.insert(empVO1);



		//�� �ק�
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("�d�ç�2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptVO(deptVO);
//		dao.update(empVO2);



		//�� �R��(�p��cascade - �h��emp2.hbm.xml�p�G�]�� cascade="all"��
		// cascade="delete"�N�|�R���Ҧ��������-�]�A���ݳ����P�P�������䥦���u�N�|�@�ֳQ�R��)
		// �ҥH�ثe�b�W��65��67��A�ĥΥh�����p���Y��A�A�R�����覡�A�o�O����w�����覡
//		dao.delete(7014);



		//�� �d��-findByPrimaryKey (�h��emp2.hbm.xml�����]��lazy="false")(�u!)
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		// �`�N�H�U�T�檺�g�k (�u!)
//		System.out.print(empVO3.getDeptVO().getDeptno() + ",");
//		System.out.print(empVO3.getDeptVO().getDname() + ",");
//		System.out.print(empVO3.getDeptVO().getLoc());
//		System.out.println("\n---------------------");



		//�� �d��-getAll (�h��emp2.hbm.xml�����]��lazy="false")(�u!)
		List<CityVO> list = dao.getAll();
		for (CityVO aCity : list) {
			System.out.print(aCity.getCityID() + ",");
			System.out.print(aCity.getCityname() + ",");
			// �`�N�H�U�T�檺�g�k (�u!)
//			System.out.print(aMember.getDeptVO().getDeptno() + ",");
//			System.out.print(aMember.getDeptVO().getDname() + ",");
//			System.out.print(aMember.getDeptVO().getLoc());
			System.out.println();
		}
	}
}