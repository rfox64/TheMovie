package com.ticket.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ticket.model.TicketService;
import com.ticket.model.TicketVO;
import com.ticketType.model.TicketTypeService;
import com.ticketType.model.TicketTypeVO;


public class TicketAction extends ActionSupport {
	private TicketVO ticketVO;

	public TicketVO getTicketVO() {
		return ticketVO;
	}

	public void setTicketVO(TicketVO ticketVO) {
		this.ticketVO = ticketVO;
	}

	public String add() {
		TicketService ticketSvc = new TicketService();
		ticketSvc.addTicket(ticketVO);
		System.out.println(" 資料庫 insert 成功");
		return "success";
	}
	
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();///原始
		
		TicketTypeService ticketTypeSvc = new TicketTypeService();
		String aa = request.getParameter("ticketVO.ticketTypeVO.typeID");
		Integer typeID = Integer.parseInt(aa);
		TicketTypeVO cc=ticketTypeSvc.selectByPKTicketType(typeID);
		System.out.println(cc.getTypePrice());
		ticketVO.setPrice(cc.getTypePrice());
		
		Timestamp now = new java.sql.Timestamp(System.currentTimeMillis());
		System.out.println("123");
		ticketVO.setSoldDateTime(now);
		
		Timestamp orderedDateTime = new java.sql.Timestamp(System.currentTimeMillis());
		ticketVO.setOrderedDateTime(orderedDateTime);

		TicketService ticketSvc = new TicketService();///原始
		TicketVO ticketSvcVO2 = ticketSvc.updateTicket(ticketVO);///原始
		
		

		
		request.setAttribute("ticketVO", ticketSvcVO2);///原始
		System.out.println("  資料庫 update 成功");
		return "success";
	}

}
