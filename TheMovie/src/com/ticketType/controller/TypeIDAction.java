package com.ticketType.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ticketType.model.TicketTypeService;
import com.ticketType.model.TicketTypeVO;

public class TypeIDAction extends ActionSupport {
	private Integer typeID;

	public Integer getTypeID() {
		return typeID;
	}

	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
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
		TicketTypeService TicketTypeSvc = new TicketTypeService();
		TicketTypeVO ticketTypeVO = TicketTypeSvc.selectByPKTicketType(typeID);
		if (ticketTypeVO != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("TicketTypeVO", ticketTypeVO);
			return true;
		} else
			return false;
	}

	public String delete() {
		TicketTypeService TicketTypeSvc = new TicketTypeService();
		TicketTypeSvc.deleteTicketType(typeID);
		System.out.println(" 資料庫 delete 成功");
		return "success";
	}

}
