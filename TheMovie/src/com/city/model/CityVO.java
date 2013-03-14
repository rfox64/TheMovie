package com.city.model;

import java.sql.Date;
//import com.dept.model.DeptVO;
public class CityVO implements java.io.Serializable{
	private	Integer	cityID	;
	private	String	cityname	;
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

}