package com.movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernateEntityManagerImplementor.Options.ResultMetadataValidator;

import com.movie.model.MovieDAO;
import com.movie.model.MovieVO;


public class MovieDAOJdbc implements MovieDAO {
	private DataSource ds = null;

	public MovieDAOJdbc() {

		try {
			Context ctx = new InitialContext();
			this.ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/TheMovie");
		} catch (Exception e) {
		}

	}

	@Override
	public MovieVO select(int id) {
		MovieVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = this.ds.getConnection();
			stmt = conn.prepareStatement(MovieDAO.SELECT_BY_ID);
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new MovieVO();
				result.setMvID(rset.getInt("mvID"));
				result.setMvNameC(rset.getString("mvNameC"));
				result.setMvNameE(rset.getString("mvNameE"));
				result.setMvStartDate(rset.getDate("mvStartDate"));
				result.setMvEndDate(rset.getDate("mvEndDate"));
				result.setMvDirector(rset.getString("mvDirector"));
				result.setMvCast(rset.getString("mvCast"));
				result.setMvCom(rset.getString("mvCom"));
				result.setMvURL(rset.getString("mvURL"));
				result.setMvStory(rset.getString("mvStory"));
				result.setMvRank(rset.getInt("mvRank"));
				result.setMvPreview(rset.getString("mvPreview"));
				result.setMvLevelID(rset.getInt("mvLevelID"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public List<MovieVO> select() {
		List<MovieVO> result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			conn = this.ds.getConnection();
			stmt = conn.prepareStatement(MovieDAO.SELECT_ALL);
			rset = stmt.executeQuery();

			result = new ArrayList<MovieVO>();
			while (rset.next()) {
				MovieVO temp = new MovieVO();
				temp.setMvID(rset.getInt("mvID"));
				temp.setMvNameC(rset.getString("mvNameC"));
				temp.setMvNameE(rset.getString("mvNameE"));
				temp.setMvStartDate(rset.getDate("mvStartDate"));
				temp.setMvEndDate(rset.getDate("mvEndDate"));
				temp.setMvDirector(rset.getString("mvDirector"));
				temp.setMvCast(rset.getString("mvCast"));
				temp.setMvCom(rset.getString("mvCom"));
				temp.setMvURL(rset.getString("mvURL"));
				temp.setMvStory(rset.getString("mvStory"));
				temp.setMvRank(rset.getInt("mvRank"));
				temp.setMvPreview(rset.getString("mvPreview"));
				temp.setMvLevelID(rset.getInt("mvLevelID"));

				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public MovieVO insert(MovieVO bean) {
		MovieVO result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = this.ds.getConnection();
			stmt = conn.prepareStatement(MovieDAO.INSERT);

			stmt.setString(1, bean.getMvNameC());
			stmt.setString(2, bean.getMvNameE());
			
			java.util.Date make = bean.getMvStartDate();
			if (make != null) {
				long temp = make.getTime();
				stmt.setDate(3, new java.sql.Date(temp));
			} else {
				stmt.setDate(3, null);
			}
			
			
			java.util.Date make2 = bean.getMvEndDate();
			if (make2 != null) {
				long temp = make2.getTime();
				stmt.setDate(4, new java.sql.Date(temp));
			} else {
				stmt.setDate(4, null);
			}
			
			
			stmt.setString(5, bean.getMvDirector());
			stmt.setString(6, bean.getMvCast());
			stmt.setString(7, bean.getMvCom());
			stmt.setString(8, bean.getMvURL());
			stmt.setString(9, bean.getMvStory());
			stmt.setInt(10, bean.getMvRank());
			stmt.setString(11, bean.getMvPreview());
			stmt.setInt(12, bean.getMvLevelID());					




			int i = stmt.executeUpdate();
			if(i==1) {
				result = new MovieVO();
				result.setMvNameC(bean.getMvNameC());
				result.setMvNameE(bean.getMvNameE());
				result.setMvStartDate(bean.getMvStartDate());
				result.setMvEndDate(bean.getMvEndDate());
				result.setMvDirector(bean.getMvDirector());
				result.setMvCast(bean.getMvCast());
				result.setMvCom(bean.getMvCom());
				result.setMvURL(bean.getMvURL());
				result.setMvStory(bean.getMvStory());
				result.setMvRank(bean.getMvRank());
				result.setMvPreview(bean.getMvPreview());
				result.setMvLevelID(bean.getMvLevelID());
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	@Override
	public MovieVO update(MovieVO bean) {
		MovieVO result = null;

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			stmt = conn.prepareStatement(UPDATE);
			
			
			stmt.setString(1, bean.getMvNameC());
			stmt.setString(2, bean.getMvNameE());
			
			java.util.Date make = bean.getMvStartDate();
			if (make != null) {
				long temp = make.getTime();
				stmt.setDate(3, new java.sql.Date(temp));
			} else {
				stmt.setDate(3, null);
			}
			
			
			java.util.Date make2 = bean.getMvEndDate();
			if (make2 != null) {
				long temp = make2.getTime();
				stmt.setDate(4, new java.sql.Date(temp));
			} else {
				stmt.setDate(4, null);
			}
			
			
			stmt.setString(5, bean.getMvDirector());
			stmt.setString(6, bean.getMvCast());
			stmt.setString(7, bean.getMvCom());
			stmt.setString(8, bean.getMvURL());
			stmt.setString(9, bean.getMvStory());
			stmt.setInt(10, bean.getMvRank());
			stmt.setString(11, bean.getMvPreview());
			stmt.setInt(12, bean.getMvLevelID());
			
			stmt.setInt(13, bean.getMvID());
			
			int i = stmt.executeUpdate();
			if(i==1) {
				result = bean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

	@Override
	public boolean delete(int id) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = this.ds.getConnection();
			stmt = conn.prepareStatement(MovieDAO.DELETE);
			stmt.setInt(1, id);
			int i = stmt.executeUpdate();
			if (i == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
