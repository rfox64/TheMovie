package com.region.model;

/*
 Hibernate is providing a factory.getCurrentSession() method for retrieving the current session. A
 new session is opened for the first time of calling this method, and closed when the transaction is
 finished, no matter commit or rollback. But what does it mean by the “current session”? We need to
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

public class RegionDAO implements RegionDAO_interface {

	private static final String GET_ALL_STMT = "from RegionVO order by regionID";

	@Override
	public void insert(RegionVO regionVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(regionVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(RegionVO regionVO) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(regionVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer regionID) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete EmpVO where empno=?");
//			query.setParameter(0, empno);
//			System.out.println("刪除的筆數=" + query.executeUpdate());

//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			RegionVO regionVO = new RegionVO();
			regionVO.setRegionID(regionID);
			session.delete(regionVO);

//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方emp2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			EmpVO empVO = (EmpVO) session.get(EmpVO.class, empno);
//			session.delete(empVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public RegionVO findByPrimaryKey(Integer regionID) {
		RegionVO regionVO = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			regionVO = (RegionVO) session.get(RegionVO.class, regionID);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return regionVO;
	}

	@Override
	public List<RegionVO> getAll() {
		List<RegionVO> list = null;
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

		RegionDAO dao = new RegionDAO();

		//● 新增
//		com.dept.model.DeptVO deptVO = new com.dept.model.DeptVO(); // 部門POJO
//		deptVO.setDeptno(10);

//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptVO(deptVO);
//		dao.insert(empVO1);



		//● 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptVO(deptVO);
//		dao.update(empVO2);



		//● 刪除(小心cascade - 多方emp2.hbm.xml如果設為 cascade="all"或
		// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
		// 所以目前在上面65到67行，採用去除關聯關係後，再刪除的方式，這是比較安全的方式
//		dao.delete(7014);



		//● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		// 注意以下三行的寫法 (優!)
//		System.out.print(empVO3.getDeptVO().getDeptno() + ",");
//		System.out.print(empVO3.getDeptVO().getDname() + ",");
//		System.out.print(empVO3.getDeptVO().getLoc());
//		System.out.println("\n---------------------");



		//● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
		List<RegionVO> list = dao.getAll();
		for (RegionVO aRegion : list) {
			System.out.print(aRegion.getCityID() + ",");
			System.out.print(aRegion.getRegionID() + ",");
			System.out.print(aRegion.getRegionname() + ",");
			// 注意以下三行的寫法 (優!)
//			System.out.print(aRegion.getDeptVO().getDeptno() + ",");
//			System.out.print(aRegion.getDeptVO().getDname() + ",");
//			System.out.print(aRegion.getDeptVO().getLoc());
			System.out.println();
		}
	}
}
