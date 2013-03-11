package com.moviePIC.model;

import com.movie.model.MovieVO;

public class MoviePICVO {

	private Integer mvPicID;
	private MovieVO movieVO;
	private String mvPic;

	public Integer getMvPicID() {
		return mvPicID;
	}

	public void setMvPicID(Integer mvPicID) {
		this.mvPicID = mvPicID;
	}

	public MovieVO getMovieVO() {
		return movieVO;
	}

	public void setMovieVO(MovieVO movieVO) {
		this.movieVO = movieVO;
	}

	public String getMvPic() {
		return mvPic;
	}

	public void setMvPic(String mvPic) {
		this.mvPic = mvPic;
	}

	@Override
	public String toString() {
		return "MoviePICVO [mvPicID=" + mvPicID + ", movieVO=" + movieVO
				+ ", mvPic=" + mvPic + "]";
	}

}
