package com.ticketType.model;
import java.util.*;

import com.ticket.model.TicketVO;


public interface TicketTypeDAO_interface {
	public void insert(TicketTypeVO ticketTypeVO);
	public void update(TicketTypeVO ticketTypeVO);
	public void delete(Integer typeID);
	public TicketTypeVO selectByPK(Integer typeID);
	public List<TicketTypeVO> selectAll();
	public Set<TicketVO> getTicketByTypeID(Integer typeID);//湟 修改處
}
