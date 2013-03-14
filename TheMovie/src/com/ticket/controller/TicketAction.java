package com.ticket.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ticket.model.TicketService;
import com.ticket.model.TicketVO;


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
		TicketService ticketSvc = new TicketService();
		TicketVO ticketSvcVO2 = ticketSvc.updateTicket(ticketVO);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("ticketSvcVO", ticketSvcVO2);
		System.out.println("  資料庫 update 成功");
		return "success";
	}

}
