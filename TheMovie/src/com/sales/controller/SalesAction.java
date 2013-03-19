package com.sales.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sales.model.SalesDAO;
import com.sales.model.SalesService;
import com.sales.model.SalesVO;

public class SalesAction extends ActionSupport {
	private SalesVO salesVO;

	public SalesVO getSalesVO() {
		return salesVO;
	}

	public void setSalesVO(SalesVO salesVO) {
		this.salesVO = salesVO;
	}

	public String add() {
		SalesService salesSvc2 = new SalesService();
		salesSvc2.addSales(salesVO);
		System.out.println(" 資料庫 insert 成功");
		return "success";
	}
	
	public String update() {
		SalesService salesSvc3 = new SalesService();
		SalesVO salesVO2 = salesSvc3.updateSales(salesVO);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("salesVO", salesVO2);
		System.out.println("  資料庫 update 成功");
		return "success";
	}

}
