package com.movie.model;

import java.util.List;


public interface MovieDAO {
	public static final String SELECT_BY_ID = 
			"select * from Movie where mvID = ?";
	public abstract MovieVO select(int mvID);

	public static final String SELECT_ALL = 
			"select * from Movie";
	public abstract List<MovieVO> select();

	public static final String INSERT = 
			"insert into Movie (mvNameC, mvNameE, mvStartDate, mvEndDate, mvDirector, mvCast, mvCom, mvURL, mvStory, mvRank, mvPreview, mvLevelID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public abstract MovieVO insert(MovieVO bean);

	public static final String UPDATE = 
			"update Movie set mvNameC=?, mvNameE=?, mvStartDate=?, mvEndDate=?, mvDirector=?, mvCast=?, mvCom=?, mvURL=?, mvStory=?, mvRank=?, mvPreview=?, mvLevelID=? where mvID=?";
	public abstract MovieVO update(MovieVO bean);

	public static final String DELETE = 
			"delete from Movie where mvID = ?";
	public abstract boolean delete(int mvID);
}