package com.movie.model.dao;

import hibernate.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.movie.model.MovieDAO;
import com.movie.model.MovieVO;

public class MovieDAOHibernate implements MovieDAO {

	private Session session = null;

	public Session getSession() {
		return session;
	}

	public MovieDAOHibernate() {
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	@Override
	public MovieVO select(int mvID) {
		return (MovieVO) this.getSession().get(MovieVO.class, mvID);
	}

	public static final String GET_ALL_STMT = "from MovieVO order by mvID";

	@Override
	public List<MovieVO> select() {
		
		List<MovieVO> list = null;
		try {
			Query query = this.getSession().createQuery(GET_ALL_STMT);
			list = query.list();
		} catch (RuntimeException ex) {
			throw ex;
		}
		return list;
		
	}

	@Override
	public MovieVO insert(MovieVO bean1) {
		MovieVO bean = this.select(bean1.getMvID());
		if(bean==null) {
			bean = new MovieVO();
			
			bean.setMvNameC(bean1.getMvNameC());
			bean.setMvNameE(bean1.getMvNameE());
			bean.setMvStartDate(bean1.getMvStartDate());
			bean.setMvEndDate(bean1.getMvEndDate());
			bean.setMvDirector(bean1.getMvDirector());
			bean.setMvCast(bean1.getMvCast());
			bean.setMvCom(bean1.getMvCom());
			bean.setMvURL(bean1.getMvURL());
			bean.setMvStory(bean1.getMvStory());
			bean.setMvRank(bean1.getMvRank());
			bean.setMvPreview(bean1.getMvPreview());
			bean.setMvLevelID(bean1.getMvLevelID());
			bean.setMvTypeID(bean1.getMvTypeID());
			
			
			this.getSession().save(bean);
			return bean;
		} else {
			return null;
		}
	}

	@Override
	public MovieVO update(MovieVO bean1) {
		MovieVO bean = this.select(bean1.getMvID());
		if(bean!=null) {
			
			bean.setMvNameC(bean1.getMvNameC());
			bean.setMvNameE(bean1.getMvNameE());
			bean.setMvStartDate(bean1.getMvStartDate());
			bean.setMvEndDate(bean1.getMvEndDate());
			bean.setMvDirector(bean1.getMvDirector());
			bean.setMvCast(bean1.getMvCast());
			bean.setMvCom(bean1.getMvCom());
			bean.setMvURL(bean1.getMvURL());
			bean.setMvStory(bean1.getMvStory());
			bean.setMvRank(bean1.getMvRank());
			bean.setMvPreview(bean1.getMvPreview());
			bean.setMvLevelID(bean1.getMvLevelID());
			bean.setMvTypeID(bean1.getMvTypeID());
			
			
			this.getSession().saveOrUpdate(bean);
			return bean;
		} else {
			return null;
		}
	}

	@Override
	public boolean delete(int mvID) {
		MovieVO bean = this.select(mvID);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		} else {
			return false;
		}
	}

}
