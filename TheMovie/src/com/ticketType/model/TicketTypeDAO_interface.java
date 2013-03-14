package com.ticketType.model;
import java.util.*;


public interface TicketTypeDAO_interface {
	public void insert(TicketTypeVO ticketTypeVO);
	public void update(TicketTypeVO ticketTypeVO);
	public void delete(Integer typeID);
	public TicketTypeVO selectByPK(Integer typeID);
	public List<TicketTypeVO> selectAll();
}
