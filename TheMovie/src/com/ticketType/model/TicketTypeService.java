package com.ticketType.model;

import java.util.List;

import com.ticketType.model.TicketTypeDAO;
import com.ticketType.model.TicketTypeDAO_interface;
import com.theater.model.TheaterVO;

public class TicketTypeService {
	
	private TicketTypeDAO_interface dao;
	
	public TicketTypeService(){
		dao = new TicketTypeDAO();
	}
	
	public TicketTypeVO addTicketType(Integer theaID,
			Integer roomType, String typeName, Double typePrice, String summary){
		TicketTypeVO ticketTypeVO = new TicketTypeVO();;
		ticketTypeVO.setRoomType(roomType);
		ticketTypeVO.setTypeName(typeName);
		ticketTypeVO.setTypePrice(typePrice);
		ticketTypeVO.setSummary(summary);
		TheaterVO theaterVO =new TheaterVO();
		theaterVO.setTheaID(theaID);
		ticketTypeVO.setTheaterVO(theaterVO);
		dao.insert(ticketTypeVO);
		return ticketTypeVO;
	} 
	
	public void addTicketType(TicketTypeVO ticketTypeVO) {
		dao.insert(ticketTypeVO);
	}
	
	public TicketTypeVO updateTicketType(Integer typeID,Integer theaID,
			Integer roomType, String typeName, Double typePrice, String summary) {
		TicketTypeVO ticketTypeVO = new TicketTypeVO();
		ticketTypeVO.setTypeID(typeID);
		ticketTypeVO.setRoomType(roomType);
		ticketTypeVO.setTypeName(typeName);
		ticketTypeVO.setTypePrice(typePrice);
		ticketTypeVO.setSummary(summary);
		TheaterVO theaterVO =new TheaterVO();
		theaterVO.setTheaID(theaID);
		ticketTypeVO.setTheaterVO(theaterVO);
		dao.update(ticketTypeVO);
		return dao.selectByPK(typeID);
	}
	
	public TicketTypeVO updateTicketType(TicketTypeVO ticketTypeVO) {
		dao.update(ticketTypeVO);
		return dao.selectByPK(ticketTypeVO.getTypeID());
	}
	
	public TicketTypeVO selectByPKTicketType(Integer typeID){
		return dao.selectByPK(typeID);
	}
	
	public void deleteTicketType(Integer typeID) {
		dao.delete(typeID);
	}
	
	public List<TicketTypeVO> getAll() {
		return dao.selectAll();
	}
}
