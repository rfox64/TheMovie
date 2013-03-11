package com.movie.model;

import java.util.ArrayList;
import java.util.List;

import com.movie.model.dao.MovieDAOHibernate;
import com.movie.model.dao.MovieDAOJdbc;

public class MovieService {
	
	
//	private MovieDAO dao = new MovieDAOJdbc();
	private MovieDAO dao = new MovieDAOHibernate();
	
	
	
	public List<MovieVO> select(MovieVO bean) {
		List<MovieVO> result = null;
		if(bean!=null && bean.getMvID()!=0) {
			MovieVO temp = dao.select(bean.getMvID());
			if(temp!=null) {
				result = new ArrayList<MovieVO>();
				result.add(temp);
			}
		} else {
			result = dao.select();
		}
		return result;
	}
	
	
	public MovieVO insert(MovieVO bean) {
		MovieVO result = null;
		if(bean!=null) {
			result = dao.insert(bean);
		}
		return result;
	}
	
	
	public MovieVO update(MovieVO bean) {
		MovieVO result = null;
		if(bean!=null) {
			result = dao.update(bean);
		}
		return result;
	}
	
	public boolean delete(MovieVO bean) {
		boolean result = false;
		if(bean!=null) {
			result = dao.delete(bean.getMvID());
		}
		return result;
	}
	
	
	
	
/*	
	public static void main(String[] args) {
		MovieService service = new MovieService();
		List<MovieVO> beans = service.select(null);
		System.out.println("beans="+beans);
	}
	*/
}
