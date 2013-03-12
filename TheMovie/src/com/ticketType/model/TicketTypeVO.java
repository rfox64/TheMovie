package com.ticketType.model;

public class TicketTypeVO implements java.io.Serializable{
	private Integer typeID;
	private Integer theaID;
	private Integer roomType;
	private String typeName;
	private Double typePrice;
	private String summary;


	
	public Integer getTheaID() {
		return theaID;
	}
	public void setTheaID(Integer theaID) {
		this.theaID = theaID;
	}
	public Integer getRoomType() {
		return roomType;
	}
	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
	}
	

	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}

	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Double getTypePrice() {
		return typePrice;
	}
	public void setTypePrice(Double typePrice) {
		this.typePrice = typePrice;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
  
}
