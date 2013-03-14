package com.region.model;

import java.sql.Date;
//import com.dept.model.DeptVO;
public class RegionVO implements java.io.Serializable{
	private	Integer	cityID	;
	private	Integer	regionID	;
	private	String	regionname	;
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public Integer getRegionID() {
		return regionID;
	}
	public void setRegionID(Integer regionID) {
		this.regionID = regionID;
	}
	public String getRegionname() {
		return regionname;
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
}