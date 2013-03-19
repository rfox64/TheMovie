package com.sales.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sales.model.SalesService;
import com.sales.model.SalesVO;

public class SalesIDAction extends ActionSupport {
	private Integer salesID;

	public Integer getSalesID() {
		return salesID;
	}

	public void setSalesID(Integer salesID) {
		this.salesID = salesID;
	}

	public String getOne_For_Display() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Display 成功");
			return "success";
		} else {
			super.addFieldError("salesID", "查無資料");
			return "input";
		}
	}
	
	//登錄
//	public String login_SalesIDAction() {
//		if (getlogin()) {
//			System.out.println("資料庫讀取成功");
//			return "login";
//		} else {
//			super.addFieldError("account","帳號輸入錯誤");
//			return "input";
//		}
//	}
	


	public String getOne_For_Update() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Update 成功");
			return "success";
		} else {
			super.addFieldError("salesName", "查無資料");
			return "input";
		}
	}

	public boolean getOne() {
		SalesService salesSvc = new SalesService();
		SalesVO salesVO = salesSvc.getOneSales(salesID);
		if (salesVO != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("salesVO", salesVO);
			return true;
		} else
			return false;
	}
	 
	//登錄
//	public boolean getlogin() {
//		SalesService salesSvc = new SalesService();
//		SalesVO salesVO = salesSvc.getOneAccount(account);
//		if (salesVO != null) {
//			HttpServletRequest request = ServletActionContext.getRequest();
//			request.setAttribute("salesVO", salesVO);
//			return true;
//		} else
//			return false;
//	}
	
	
	
	
	public String delete() {
		SalesService salesSvc = new SalesService();
		salesSvc.deleteSales(salesID);
		System.out.println(" 資料庫 delete 成功");
		return "success";
	}
	

	
	
	
}
