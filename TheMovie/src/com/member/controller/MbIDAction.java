package com.member.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.member.model.MemberService;
import com.member.model.MemberVO;

public class MbIDAction extends ActionSupport {
	private Integer mbID;

	public Integer getMbID() {
		return getMbID();
	}

	public void setMbID(Integer mbID) {
		this.mbID = mbID;
	}

	public String getOne_For_Display() {
		if (getOne()) {
			System.out.println("getOne_For_Display");
			return "success";
		} else {
			super.addFieldError("mbID", "mbID");
			return "input";
		}
	}

	public String getOne_For_Update() {
		if (getOne()) {
			System.out.println("getOne_For_Update");
			return "success";
		} else {
			super.addFieldError("mbID", "mbID");
			return "input";
		}
	}

	public boolean getOne() {
		MemberService memberSvc = new MemberService();
		MemberVO memberVO = memberSvc.getOneMember(mbID);

		if (memberVO != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("memberVO", memberVO);
			return true;
		} else
			return false;
	}

	public String delete() {
		MemberService memberSvc = new MemberService();
		memberSvc.deleteMember(mbID);
		System.out.println("delete");
		return "success";
	}

}
