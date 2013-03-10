package com.room.model;

public class RoomVO {
	private Integer roomID;
	private Integer theaID;
	private String roomName;
	private Integer seatTotalRow;
	private Integer seatTotalColumn;
	
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}
	public Integer getTheaID() {
		return theaID;
	}
	public void setTheaID(Integer theaID) {
		this.theaID = theaID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public Integer getSeatTotalRow() {
		return seatTotalRow;
	}
	public void setSeatTotalRow(Integer seatTotalRow) {
		this.seatTotalRow = seatTotalRow;
	}
	public Integer getSeatTotalColumn() {
		return seatTotalColumn;
	}
	public void setSeatTotalColumn(Integer seatTotalColumn) {
		this.seatTotalColumn = seatTotalColumn;
	}
}
