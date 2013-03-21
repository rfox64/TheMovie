package com.ticket.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ticket.model.TicketService;
import com.ticket.model.TicketVO;

public class TicketIDAction extends ActionSupport {
	private Integer ticketID;

	public Integer getTicketID() {
		return ticketID;
	}

	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}

	public String getOne_For_Display() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Display 成功");
			return "success";
		} else {
			super.addFieldError("ename", "查無資料");
			return "input";
		}
	}

	public String getOne_For_Update() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Update 成功");
			return "success";
		} else {
			super.addFieldError("ename", "查無資料");
			return "input";
		}
	}

	public boolean getOne() {
		TicketService TicketSvc = new TicketService();
		TicketVO ticketVO = TicketSvc.selectByPKTicket(ticketID);
		if (ticketVO != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("ticketVO", ticketVO);
			return true;
		} else
			return false;
	}

	public String delete() {
		TicketService TicketSvc = new TicketService();
		TicketSvc.deleteTicket(ticketID);
		System.out.println(" 資料庫 delete 成功");
		return "success";
	}
	
	public String deleteMultipleTicket() {
		

		HttpServletRequest request = ServletActionContext.getRequest();
		String[] ddf = request.getParameterValues("ticketVO.ticketID");
		for(int i=0;i<ddf.length;i++){
			TicketService TicketSvc = new TicketService();
			System.out.println(Integer.parseInt(ddf[i]));
			TicketSvc.deleteTicket(Integer.parseInt(ddf[i]));
		}		
		System.out.println(" 資料庫 deleteMultipleTicket 成功");
		return "success";
	}

}
