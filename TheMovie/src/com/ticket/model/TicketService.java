package com.ticket.model;

import java.sql.Timestamp;
import java.util.List;



public class TicketService {

	private TicketDAO_interface dao;
	
	public TicketService(){
		dao = new TicketDAO();
	}
	
	public TicketVO addTicket(Integer ticketID, Integer roundsID, Integer seatRow, Integer seatColumn,
		String	seatName, Integer mbID, Integer salesID, Timestamp soldDateTime, Timestamp orderedDateTime, Integer typeID){
		TicketVO ticketVO = new TicketVO();
		ticketVO.setTicket(ticketID);
		ticketVO.setRoundsID(roundsID);
		ticketVO.setSeatRow(seatRow);
		ticketVO.setSeatColumn(seatColumn);
		ticketVO.setSeatName(seatName);
		ticketVO.setMbID(mbID);
		ticketVO.setSalesID(salesID);
		ticketVO.setSoldDateTime(soldDateTime);
		ticketVO.setOrderedDateTime(orderedDateTime);
		ticketVO.setTypeID(typeID);
		return ticketVO;
	}
	
	public void addTicket(TicketVO ticketVO) {
		dao.insert(ticketVO);
	}
	
	public TicketVO updateTicket(Integer ticketID, Integer roundsID, Integer seatRow, Integer seatColumn,
			String	seatName, Integer mbID, Integer salesID, Timestamp soldDateTime, Timestamp orderedDateTime, Integer typeID) {
		TicketVO ticketVO = new TicketVO();
		ticketVO.setTicket(ticketID);
		ticketVO.setRoundsID(roundsID);
		ticketVO.setSeatRow(seatRow);
		ticketVO.setSeatColumn(seatColumn);
		ticketVO.setSeatName(seatName);
		ticketVO.setMbID(mbID);
		ticketVO.setSalesID(salesID);
		ticketVO.setSoldDateTime(soldDateTime);
		ticketVO.setOrderedDateTime(orderedDateTime);
		ticketVO.setTypeID(typeID);
		return dao.selectByPK(ticketID);
	}
	
	public TicketVO updateTicket(TicketVO ticketVO) {
		dao.update(ticketVO);
		return dao.selectByPK(ticketVO.getTicket());
	}
	
	public TicketVO selectByPKTicket(Integer ticketID){
		return dao.selectByPK(ticketID);
	}
	
	public List<TicketVO> getAll() {
		return dao.selectAll();
	}
}
