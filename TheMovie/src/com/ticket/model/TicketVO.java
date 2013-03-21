package com.ticket.model;

import java.sql.Timestamp;

import com.member.model.MemberVO;
import com.rounds.model.RoundsVO;
import com.sales.model.SalesVO;
import com.ticketType.model.TicketTypeVO;

public class TicketVO implements java.io.Serializable{
	private Integer ticketID;
	private Integer seatRow;
	private Integer seatColumn;
	private String	seatName;
	private Timestamp soldDateTime;
	private Timestamp orderedDateTime;
	private Double price;
	private RoundsVO roundsVO;
	private MemberVO memberVO;
	private SalesVO salesVO;
	private TicketTypeVO ticketTypeVO;
	
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public Integer getTicketID() {
		return ticketID;
	}
	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public RoundsVO getRoundsVO() {
		return roundsVO;
	}
	public void setRoundsVO(RoundsVO roundsVO) {
		this.roundsVO = roundsVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public SalesVO getSalesVO() {
		return salesVO;
	}
	public void setSalesVO(SalesVO salesVO) {
		this.salesVO = salesVO;
	}
	public TicketTypeVO getTicketTypeVO() {
		return ticketTypeVO;
	}
	public void setTicketTypeVO(TicketTypeVO ticketTypeVO) {
		this.ticketTypeVO = ticketTypeVO;
	}

	
}
