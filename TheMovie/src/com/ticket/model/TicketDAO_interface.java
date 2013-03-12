package com.ticket.model;
import java.util.*;

public interface TicketDAO_interface {
	public void insert(TicketVO ticketVO);
	public void update(TicketVO ticketVO);
	public TicketVO selectByPK(Integer ticketID);
	public List<TicketVO> selectAll();
}
