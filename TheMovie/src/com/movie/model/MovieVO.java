package com.movie.model;

import java.util.LinkedHashSet;
import java.util.Set;

import com.moviePIC.model.MoviePICVO;

public class MovieVO {
	private Integer mvID;
	private String mvNameC;
	private String mvNameE;
	private java.util.Date mvStartDate;
	private java.util.Date mvEndDate;
	private String mvDirector;
	private String mvCast;
	private String mvCom;
	private String mvURL;
	private String mvStory;
	private Integer mvRank;
	private String mvPreview;
	private Integer mvLevelID;
	private Integer mvTypeID;

	public Integer getMvTypeID() {
		return mvTypeID;
	}

	public void setMvTypeID(Integer mvTypeID) {
		this.mvTypeID = mvTypeID;
	}

	private Set<MoviePICVO> moviePICs = new LinkedHashSet<MoviePICVO>();

	public Set<MoviePICVO> getMoviePICs() {
		return moviePICs;
	}

	public void setMoviePICs(Set<MoviePICVO> moviePICs) {
		this.moviePICs = moviePICs;
	}

	public Integer getMvID() {
		return mvID;
	}

	public void setMvID(Integer mvID) {
		this.mvID = mvID;
	}

	public String getMvNameC() {
		return mvNameC;
	}

	public void setMvNameC(String mvNameC) {
		this.mvNameC = mvNameC;
	}

	public String getMvNameE() {
		return mvNameE;
	}

	public void setMvNameE(String mvNameE) {
		this.mvNameE = mvNameE;
	}

	public java.util.Date getMvStartDate() {
		return mvStartDate;
	}

	public void setMvStartDate(java.util.Date mvStartDate) {
		this.mvStartDate = mvStartDate;
	}

	public java.util.Date getMvEndDate() {
		return mvEndDate;
	}

	public void setMvEndDate(java.util.Date mvEndDate) {
		this.mvEndDate = mvEndDate;
	}

	public String getMvDirector() {
		return mvDirector;
	}

	public void setMvDirector(String mvDirector) {
		this.mvDirector = mvDirector;
	}

	public String getMvCast() {
		return mvCast;
	}

	public void setMvCast(String mvCast) {
		this.mvCast = mvCast;
	}

	public String getMvCom() {
		return mvCom;
	}

	public void setMvCom(String mvCom) {
		this.mvCom = mvCom;
	}

	public String getMvURL() {
		return mvURL;
	}

	public void setMvURL(String mvURL) {
		this.mvURL = mvURL;
	}

	public String getMvStory() {
		return mvStory;
	}

	public void setMvStory(String mvStory) {
		this.mvStory = mvStory;
	}

	public Integer getMvRank() {
		return mvRank;
	}

	public void setMvRank(Integer mvRank) {
		this.mvRank = mvRank;
	}

	public String getMvPreview() {
		return mvPreview;
	}

	public void setMvPreview(String mvPreview) {
		this.mvPreview = mvPreview;
	}

	public Integer getMvLevelID() {
		return mvLevelID;
	}

	public void setMvLevelID(Integer mvLevelID) {
		this.mvLevelID = mvLevelID;
	}

	@Override
	public String toString() {
		return "MovieVO [mvID=" + mvID + ", mvNameC=" + mvNameC + ", mvNameE="
				+ mvNameE + ", mvStartDate=" + mvStartDate + ", mvEndDate="
				+ mvEndDate + ", mvDirector=" + mvDirector + ", mvCast="
				+ mvCast + ", mvCom=" + mvCom + ", mvURL=" + mvURL
				+ ", mvStory=" + mvStory + ", mvRank=" + mvRank
				+ ", mvPreview=" + mvPreview + ", mvLevelID=" + mvLevelID
				+ ", mvTypeID=" + mvTypeID + ", moviePICs=" + moviePICs + "]";
	}

}
