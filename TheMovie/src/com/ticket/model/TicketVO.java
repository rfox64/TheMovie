package com.ticket.model;

import java.sql.Timestamp;

public class TicketVO implements java.io.Serializable{
	private Integer ticketID;
	private Integer roundsID;
	private Integer seatRow;
	private Integer seatColumn;
	private String	seatName;
	private Integer mbID;
	private Integer salesID;
	private Timestamp soldDateTime;
	private Timestamp orderedDateTime;
	private Integer typeID;
	
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public Integer getTicket() {
		return ticketID;
	}
	public void setTicket(Integer ticket) {
		this.ticketID = ticket;
	}
	public Integer getRoundsID() {
		return roundsID;
	}
	public void setRoundsID(Integer roundsID) {
		this.roundsID = roundsID;
	}
	public Integer getSeatRow() {
		return seatRow;
	}
	public void setSeatRow(Integer seatRow) {
		this.seatRow = seatRow;
	}
	public Integer getSeatColumn() {
		return seatColumn;
	}
	public void setSeatColumn(Integer seatColumn) {
		this.seatColumn = seatColumn;
	}
	public Integer getMbID() {
		return mbID;
	}
	public void setMbID(Integer mbID) {
		this.mbID = mbID;
	}
	public Integer getSalesID() {
		return salesID;
	}
	public void setSalesID(Integer salesID) {
		this.salesID = salesID;
	}
	public Timestamp getSoldDateTime() {
		return soldDateTime;
	}
	public void setSoldDateTime(Timestamp soldDateTime) {
		this.soldDateTime = soldDateTime;
	}
	public Timestamp getOrderedDateTime() {
		return orderedDateTime;
	}
	public void setOrderedDateTime(Timestamp orderedDateTime) {
		this.orderedDateTime = orderedDateTime;
	}
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	
}
