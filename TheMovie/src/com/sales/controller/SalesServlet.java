package com.sales.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.sales.model.*;

public class SalesServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("salesID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入員工編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/sales/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer salesID = null;
				try {
					salesID = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("員工編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/sales/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				SalesService salesSvc = new SalesService();
				SalesVO salesVO = salesSvc.getOneSales(salesID);
				if (salesVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/sales/select_page.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("salesVO", salesVO); // 資料庫取出的empVO物件,存入req
				String url = "/sales/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/sales/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 靘listAllEmp.jsp��瘙�

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數****************************************/
				Integer salesID = new Integer(req.getParameter("salesID"));
				
				/***************************2.開始查詢資料****************************************/
				SalesService SalesSvc = new SalesService();
				SalesVO salesVO = SalesSvc.getOneSales(salesID);
								
				/***************************其他可能的錯誤處理*********************************/
				req.setAttribute("salesVO", salesVO);         // 資料庫取出的empVO物件,存入req
				String url = "/sales/update_emp_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理*********************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得要修改的資料:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/sales/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // 來自listAllEmp.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理*********************/
				Integer salesID = new Integer(req.getParameter("salesID").trim());
				String salesName = req.getParameter("salesName").trim();
				String account = req.getParameter("account").trim();			//job	
				String password = req.getParameter("password").trim();	
				String theaID = req.getParameter("theaID").trim();	
				Integer activation =  new Integer(req.getParameter("activation").trim());
				
/*				
				java.sql.Date hiredate = null;
				try {
					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
				} catch (IllegalArgumentException e) {
					hiredate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("隢撓�交��");
				}

				Double sal = null;
				try {
					sal = new Double(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					sal = 0.0;
					errorMsgs.add("薪水請填數字.");
				}

				Double comm = null;
				try {
					comm = new Double(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					comm = 0.0;
					errorMsgs.add("獎金請填數字.");
				}

				Integer deptno = new Integer(req.getParameter("deptno").trim());
*/
				SalesVO salesVO = new SalesVO();
				salesVO.setSalesID(salesID);
				salesVO.setSalesName(salesName);
				salesVO.setAccount(account);
				salesVO.setPassword(password);
				salesVO.setTheaID(theaID);
				salesVO.setActivation(activation);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("salesVO", salesVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/sales/update_emp_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				SalesService SalesSvc = new SalesService();
				salesVO = SalesSvc.updateSales(salesID, salesName, account, password, theaID,activation);
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("salesVO", salesVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/sales/listOneEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);

				/***************************其他可能的錯誤處理************************************/
			} catch (Exception e) {
				errorMsgs.add("修改資料失敗:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/sales/update_emp_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // 來自listAllEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.接收請求參數 - 輸入格式的錯誤處理************************/
				Integer salesID = new Integer(req.getParameter("salesID").trim());
				String salesName = req.getParameter("salesName").trim();
				String account = req.getParameter("account").trim();			//job	
				String password = req.getParameter("password").trim();	
				String theaID = req.getParameter("theaID").trim();	
				Integer activation =  new Integer(req.getParameter("activation").trim());
				
				
				
/*				java.sql.Date hiredate = null;
				try {
					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
				} catch (IllegalArgumentException e) {
					hiredate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("隢撓�交��");
				}
				
				Double sal = null;
				try {
					sal = new Double(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					sal = 0.0;
					errorMsgs.add("薪水請填數字.");
				}
				
				Double comm = null;
				try {
					comm = new Double(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					comm = 0.0;
					errorMsgs.add("獎金請填數字.");
				}
				
				Integer deptno = new Integer(req.getParameter("deptno").trim());
*/
				SalesVO salesVO = new SalesVO();
				salesVO.setSalesID(salesID);
				salesVO.setSalesName(salesName);
				salesVO.setAccount(account);
				salesVO.setPassword(password);
				salesVO.setTheaID(theaID);
				salesVO.setActivation(activation);


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("salesVO", salesVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/sales/addEmp.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				SalesService salesSvc = new SalesService();
				salesVO = salesSvc.addSales(salesID, salesName, account, password, theaID, activation);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/sales/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 含有輸入格式錯誤的empVO物件,也存入req
				successView.forward(req, res);				
				
				/***************************其他可能的錯誤處理*********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/sales/addEmp.jsp");
				failureView.forward(req, res);
			}
		}
        
        
        
        
        
/*								End
 * 
 * *************Detele***************
		
		if ("delete".equals(action)) { // 嚙諉佗蕭listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				*//***************************1.嚙踝蕭嚙踝蕭嚙請求嚙諸潘蕭***************************************//*
				Integer salesID = new Integer(req.getParameter("salesID"));
				
				*//***************************2.嚙罷嚙締嚙磋嚙踝蕭嚙踝蕭嚙�**************************************//*
				//SalesService empSvc = new SalesService();
				//empSvc.deleteEmp(salesID);
				
				*//***************************3.嚙磋嚙踝蕭嚙踝蕭嚙踝蕭,嚙褒喉蕭嚙踝蕭嚙�Send the Success view)***********//*								
				String url = "/sales/listAllEmp.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 嚙磋嚙踝蕭嚙踝蕭嚙穀嚙踝蕭,嚙踝蕭嚙稷嚙箴嚙碼嚙磋嚙踝蕭嚙踝蕭嚙諉瘀蕭嚙踝蕭嚙踝蕭
				successView.forward(req, res);
				
				*//***************************嚙踝蕭L嚙箠嚙賞的嚙踝蕭~嚙畿嚙緲**********************************//*
			} catch (Exception e) {
				errorMsgs.add("嚙磋嚙踝蕭嚙踝蕭嚙踝蕭嚙�"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/sales/listAllEmp.jsp");
				failureView.forward(req, res);
			}
		}*/
	}
}
