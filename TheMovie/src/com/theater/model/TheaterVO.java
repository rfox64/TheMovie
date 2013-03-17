package com.theater.model;

import com.city.model.CityVO;
import com.region.model.RegionVO;

public class TheaterVO implements java.io.Serializable{
	private Integer theaID;
	private String theaName;
	private Integer cityID;
	private Integer regionID;
	private String address;
	private String phone;
	private String summary;
	private String traffic;
	private CityVO cityVO;
	private RegionVO regionVO;
	
	
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	public RegionVO getRegionVO() {
		return regionVO;
	}
	public void setRegionVO(RegionVO regionVO) {
		this.regionVO = regionVO;
	}
	public Integer getTheaID() {
		return theaID;
	}
	public void setTheaID(Integer theaID) {
		this.theaID = theaID;
	}
	
	public String getTheaName() {
		return theaName;
	}
	public void setTheaName(String theaName) {
		this.theaName = theaName;
	}
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	
	
	
	
	
}
