package com.sales.model;

import java.sql.Date;

public class SalesVO implements java.io.Serializable {
	private Integer salesID;
	private String salesName;
	private String account;
	private String password;
	private String theaID;
	private Integer activation;
	
	public Integer getSalesID() {
		return salesID;
	}

	public void setSalesID(Integer salesID) {
		this.salesID = salesID;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTheaID() {
		return theaID;
	}

	public void setTheaID(String theaID) {
		this.theaID = theaID;
	}

	public Integer getActivation() {
		return activation;
	}

	public void setActivation(Integer activation) {
		this.activation = activation;
	}


}
