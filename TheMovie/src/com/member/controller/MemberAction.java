package com.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.member.model.MemberService;
import com.member.model.MemberVO;
import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport {
	private MemberVO memberVO;

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	public String add() {
		MemberService memberSvc = new MemberService();
		memberSvc.addMember(memberVO);
		System.out.println("insert");
		return "success";
	}
	
	public String update() {
		MemberService memberSvc = new MemberService();
		MemberVO memberVO2 = memberSvc.updateMember(memberVO);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("mbID", memberVO2);
		System.out.println("update");
		return "success";
	}

}
