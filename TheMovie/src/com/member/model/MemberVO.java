package com.member.model;

import java.sql.Date;
//import com.dept.model.DeptVO;
public class MemberVO implements java.io.Serializable{
	private Integer mbID;
	private String firstName;   //not null
	private String lastName;   //not null
	private Integer cityID;
	private Integer regionID;
	private String address;
	private String mobile;   //not null
	private Date birthday;
	private Integer gender;
	private Integer proID;
	private Integer eduID;
	private String email;   //not null
	private String password;   //not null
	private Integer activation;
	private Date inactivationD;
	public Integer getMbID() {
		return mbID;
	}
	public void setMbID(Integer mbID) {
		this.mbID = mbID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getProID() {
		return proID;
	}
	public void setProID(Integer proID) {
		this.proID = proID;
	}
	public Integer getEduID() {
		return eduID;
	}
	public void setEduID(Integer eduID) {
		this.eduID = eduID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getActivation() {
		return activation;
	}
	public void setActivation(Integer activation) {
		this.activation = activation;
	}
	public Date getInactivationD() {
		return inactivationD;
	}
	public void setInactivationD(Date inactivationD) {
		this.inactivationD = inactivationD;
	}
}
