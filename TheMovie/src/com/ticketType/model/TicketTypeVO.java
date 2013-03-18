package com.ticketType.model;

import com.theater.model.TheaterVO;

public class TicketTypeVO implements java.io.Serializable{
	private Integer typeID;
	private Integer roomType;
	private String typeName;
	private Double typePrice;
	private String summary;
	private TheaterVO theaterVO;
	
	
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public Integer getRoomType() {
		return roomType;
	}
	public void setRoomType(Integer roomType) {
		this.roomType = roomType;
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
	public TheaterVO getTheaterVO() {
		return theaterVO;
	}
	public void setTheaterVO(TheaterVO theaterVO) {
		this.theaterVO = theaterVO;
	}

	
  
}
