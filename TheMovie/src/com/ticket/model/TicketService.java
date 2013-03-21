package com.ticket.model;

import java.sql.Timestamp;
import java.util.List;

import com.member.model.MemberVO;
import com.rounds.model.RoundsVO;
import com.sales.model.SalesVO;
import com.ticketType.model.TicketTypeVO;



public class TicketService {

	private TicketDAO_interface dao;
	
	public TicketService(){
		dao = new TicketDAO();
	}
	
//	public TicketVO addTicket(Integer roundsID, Integer seatRow, Integer seatColumn,
//		String	seatName, Integer mbID, Integer salesID, Timestamp soldDateTime, Timestamp orderedDateTime, Integer typeID){
//		TicketVO ticketVO = new TicketVO();
//		
//		
//		ticketVO.setSeatRow(seatRow);
//		ticketVO.setSeatColumn(seatColumn);
//		ticketVO.setSeatName(seatName);
//		ticketVO.setSoldDateTime(soldDateTime);
//		ticketVO.setOrderedDateTime(orderedDateTime);
//		
//		SalesVO salesVO = new SalesVO();
//		salesVO.setSalesID(salesID);
//		ticketVO.setSalesVO(salesVO);
//		
//		MemberVO memberVO=new MemberVO();
//		memberVO.setMbID(mbID);
//		ticketVO.setMemberVO(memberVO);
//		
//		TicketTypeVO ticketTypeVO = new TicketTypeVO(); 
//		ticketTypeVO.setTypeID(typeID);
//		ticketVO.setTicketTypeVO(ticketTypeVO);
//		
//		RoundsVO roundsVO = new RoundsVO();
//		roundsVO.setRoundsID(roundsID);
//		ticketVO.setRoundsVO(roundsVO);
//		
//		dao.insert(ticketVO);
//		return ticketVO;
//	}
	
	public void addTicket(TicketVO ticketVO) {
		dao.insert(ticketVO);
	}
	
//	public TicketVO updateTicket(Integer ticketID,Integer roundsID, Integer seatRow, Integer seatColumn,
//			String	seatName, Integer mbID, Integer salesID, Timestamp soldDateTime, Timestamp orderedDateTime, Integer typeID) {
//		TicketVO ticketVO = new TicketVO();
//	
//		
//		ticketVO.setSeatRow(seatRow);
//		ticketVO.setSeatColumn(seatColumn);
//		ticketVO.setSeatName(seatName);
//		ticketVO.setSoldDateTime(soldDateTime);
//		ticketVO.setOrderedDateTime(orderedDateTime);
//		
//		SalesVO salesVO = new SalesVO();
//		salesVO.setSalesID(salesID);
//		ticketVO.setSalesVO(salesVO);
//		
//		MemberVO memberVO=new MemberVO();
//		memberVO.setMbID(mbID);
//		ticketVO.setMemberVO(memberVO);
//		
//		TicketTypeVO ticketTypeVO = new TicketTypeVO(); 
//		ticketTypeVO.setTypeID(typeID);
//		ticketVO.setTicketTypeVO(ticketTypeVO);
//		
//		RoundsVO roundsVO = new RoundsVO();
//		roundsVO.setRoundsID(roundsID);
//		ticketVO.setRoundsVO(roundsVO);
//		
//		dao.update(ticketVO);
//		return dao.selectByPK(ticketID);
//	}
	
	public TicketVO updateTicket(TicketVO ticketVO) {
		dao.update(ticketVO);
		return dao.selectByPK(ticketVO.getTicketID());
	}
	
	public void deleteTicket(Integer ticketID) {
		dao.delete(ticketID);
	}
	
	public TicketVO selectByPKTicket(Integer ticketID){
		return dao.selectByPK(ticketID);
	}
	
	public List<TicketVO> getAll() {
		return dao.selectAll();
	}
}
