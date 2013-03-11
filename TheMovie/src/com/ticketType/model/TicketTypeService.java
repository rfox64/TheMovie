package com.ticketType.model;

import java.util.List;

import com.ticketType.model.TicketTypeDAO;
import com.ticketType.model.TicketTypeDAO_interface;

public class TicketTypeService {
	
	private TicketTypeDAO_interface dao;
	
	public TicketTypeService(){
		dao = new TicketTypeDAO();
	}
	
	public TicketTypeVO addTicketType(Integer typeID,Integer theaID,
			Integer roomType, String typeName, Double typePrice, String summary){
		TicketTypeVO ticketTypeVO = new TicketTypeVO();
		ticketTypeVO.setTypeID(typeID);
		ticketTypeVO.setTheaID(theaID);
		ticketTypeVO.setRoomType(roomType);
		ticketTypeVO.setTypeName(typeName);
		ticketTypeVO.setTypePrice(typePrice);
		ticketTypeVO.setSummary(summary);
		return ticketTypeVO;
	} 
	
	public void addTicketType(TicketTypeVO ticketTypeVO) {
		dao.insert(ticketTypeVO);
	}
	
	public TicketTypeVO updateTicketType(Integer typeID,Integer theaID,
			Integer roomType, String typeName, Double typePrice, String summary) {
		TicketTypeVO ticketTypeVO = new TicketTypeVO();
		ticketTypeVO.setTypeID(typeID);
		ticketTypeVO.setTheaID(theaID);
		ticketTypeVO.setRoomType(roomType);
		ticketTypeVO.setTypeName(typeName);
		ticketTypeVO.setTypePrice(typePrice);
		ticketTypeVO.setSummary(summary);
		return dao.selectByPK(typeID);
	}
	
	public TicketTypeVO updateTicketType(TicketTypeVO ticketTypeVO) {
		dao.update(ticketTypeVO);
		return dao.selectByPK(ticketTypeVO.getTypeID());
	}
	
	public TicketTypeVO selectByPKTicketType(Integer typeID){
		return dao.selectByPK(typeID);
	}
	
	public List<TicketTypeVO> getAll() {
		return dao.selectAll();
	}
}
