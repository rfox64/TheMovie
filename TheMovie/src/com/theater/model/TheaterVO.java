package com.theater.model;

public class TheaterVO implements java.io.Serializable{
	private int theaID;
	private String theadName;
	private int cityID;
	private int regionID;
	private String address;
	private int phone;
	private String summary;
	
	public int getTheaID() {
		return theaID;
	}
	public void setTheaID(int theaID) {
		this.theaID = theaID;
	}
	public String getTheadName() {
		return theadName;
	}
	public void setTheadName(String theadName) {
		this.theadName = theadName;
	}
	public int getCityID() {
		return cityID;
	}
	public void setCityID(int cityID) {
		this.cityID = cityID;
	}
	public int getRegionID() {
		return regionID;
	}
	public void setRegionID(int regionID) {
		this.regionID = regionID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
}
