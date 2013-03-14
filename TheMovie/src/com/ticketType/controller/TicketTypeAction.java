package com.ticketType.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ticketType.model.TicketTypeService;
import com.ticketType.model.TicketTypeVO;

public class TicketTypeAction extends ActionSupport {
	private TicketTypeVO ticketTypeVO;

	public TicketTypeVO getTicketTypeVO() {
		return ticketTypeVO;
	}

	public void setTicketTypeVO(TicketTypeVO ticketTypeVO) {
		this.ticketTypeVO = ticketTypeVO;
	}

	public String add() {
		TicketTypeService ticketTypeSvc = new TicketTypeService();
		ticketTypeSvc.addTicketType(ticketTypeVO);
		System.out.println(" 資料庫 insert 成功");
		return "success";
	}
	
	public String update() {
		TicketTypeService ticketTypeSvc = new TicketTypeService();
		TicketTypeVO ticketTypeSvcVO2 = ticketTypeSvc.updateTicketType(ticketTypeVO);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("ticketTypeSvcVO", ticketTypeSvcVO2);
		System.out.println("  資料庫 update 成功");
		return "success";
	}

}
