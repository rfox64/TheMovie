package com.rounds.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "round")
public class RoundsVO implements java.io.Serializable{
	private Integer roundsID;
	private Integer roomID;
	private Integer mvID;
	private Timestamp roundsDateTime;
	private String seat;

	@Id
	@Column(name = "roundsID")
	public Integer getRoundsID() {
		return roundsID;
	}
	public void setRoundsID(Integer roundsID) {
		this.roundsID = roundsID;
	}

	@Column(name = "roomID")
	public Integer getRoomID() {
		return roomID;
	}
	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	@Column(name = "mvID")
	public Integer getMvID() {
		return mvID;
	}
	public void setMvID(Integer mvID) {
		this.mvID = mvID;
	}
	

	@Column(name = "roundsDateTime")
	public Timestamp getRoundsDateTime() {
		return roundsDateTime;
	}
	public void setRoundsDateTime(Timestamp roundsDateTime) {
		this.roundsDateTime = roundsDateTime;
	}
	
	@Column(name = "seat")
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
}
