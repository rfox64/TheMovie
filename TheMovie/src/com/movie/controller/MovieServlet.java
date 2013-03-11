package com.movie.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.model.MovieService;
import com.movie.model.MovieVO;

import misc.ConvertUtil;

@WebServlet(name="Movie", urlPatterns={"/pages/movie.controller"})
public class MovieServlet extends HttpServlet {
	private static final long	serialVersionUID	= 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接收資料
		
		String prodaction = request.getParameter("prodaction");
		
		String mvID = request.getParameter("mvID");
		String mvNameC = request.getParameter("mvNameC");
		String mvNameE = request.getParameter("mvNameE");
		String mvStartDate = request.getParameter("mvStartDate");
		String mvEndDate = request.getParameter("mvEndDate");
		String mvDirector = request.getParameter("mvDirector");
		String mvCast = request.getParameter("mvCast");
		String mvCom = request.getParameter("mvCom");
		String mvURL = request.getParameter("mvURL");
		String mvStory = request.getParameter("mvStory");
		String mvRank = request.getParameter("mvRank");
		String mvPreview = request.getParameter("mvPreview");
		String mvLevelID = request.getParameter("mvLevelID");
		String mvTypeID = request.getParameter("mvTypeID");

		//驗證資料
		Map<String, String> errors = new HashMap<String, String>(); 
		request.setAttribute("errors", errors);

		if(prodaction!=null) {
			if(prodaction.equals("Update") || prodaction.equals("Delete")) {
				if(mvID==null || mvID.trim().length()==0) {
					errors.put("mvID", "Please Enter Id");
				}
			}
		}
		

		
		
		
		// 驗證資料
		

		
		int id = 0;
		if(mvID!=null && mvID.trim().length()!=0) {
			id = ConvertUtil.convertInt(mvID);
			if(id==-1000) {
				errors.put("mvID", "Id must be a integer");
			}
		}
		
		
		if(mvNameC == null || mvNameC.trim().length() ==0) {
			errors.put("mvNameC", "Please Enter mvNameC");
		}
		
		
		if(mvNameE == null || mvNameE.trim().length() ==0) {
			errors.put("mvNameE", "Please Enter mvNameE");
		}
		
		
		
		java.util.Date make2 = null;
		if (mvStartDate != null && mvStartDate.trim().length() != 0) {
			make2 = ConvertUtil.convertDate(mvStartDate);
			if (make2.equals(new java.util.Date(0))) {
				errors.put("mvStartDate","mvStartDate must be a Data of YYYY-MM-DD");
			}
		}
		
		java.util.Date make = null;
		if (mvEndDate != null && mvEndDate.trim().length() != 0) {
			make = ConvertUtil.convertDate(mvEndDate);
			if (make.equals(new java.util.Date(0))) {
				errors.put("mvEndDate","mvEndDate must be a Data of YYYY-MM-DD");
			}
		}
		
		int mvRank1 = 1;
		if(mvRank != null && mvRank.trim().length()!=0) {
			mvRank1 = ConvertUtil.convertInt(mvRank);
			if(mvRank1==-1000) {
				errors.put("mvRank", "Rank must be a integer");
			}
		}

		int mvLevelID1 = 0;
		if(mvLevelID != null && mvLevelID.trim().length()!=0) {
			mvLevelID1 = ConvertUtil.convertInt(mvLevelID);
			if(mvLevelID1==-1000) {
				errors.put("mvLevelID", "Level must be a integer");
			}
		}
		
		int mvTypeID1 = 1;
		if(mvTypeID != null && mvTypeID.trim().length()!=0) {
			mvTypeID1 = ConvertUtil.convertInt(mvTypeID);
			if(mvTypeID1==-1000) {
				errors.put("mvTypeID", "Type must be a integer");
			}
		}
		
		// 呼叫Model，根據Model執行結果導向View
		MovieVO bean = new MovieVO();
		
		bean.setMvID(id);
		bean.setMvNameC(mvNameC);
		bean.setMvNameE(mvNameE);
		bean.setMvStartDate(make2);
		bean.setMvEndDate(make);
		bean.setMvDirector(mvDirector);
		bean.setMvCast(mvCast);
		bean.setMvCom(mvCom);
		bean.setMvURL(mvURL);
		bean.setMvStory(mvStory);
		bean.setMvRank(mvRank1);
		bean.setMvPreview(mvPreview);
		bean.setMvLevelID(mvLevelID1);
		bean.setMvTypeID(mvTypeID1);		
		
		
		
		MovieService service = new MovieService();
		if (prodaction != null && prodaction.equals("Select")) {
			List<MovieVO> result = service.select(bean);
			request.setAttribute("select", result);
			request.getRequestDispatcher("/pages/display.jsp").forward(request, response);
		}
		else if (prodaction != null && prodaction.equals("Insert")) {
			// Send the use back to the form, if there were errors
			if (!errors.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/pages/movie.jsp");
				failureView.forward(request, response);
				return;//程式中斷
			}
			MovieVO result = service.insert(bean);
			if (result == null) {
				errors.put("action", "insert product table failed");
			}
			else {
				request.setAttribute("insert", result);
			}
			request.getRequestDispatcher("/pages/movie.jsp").forward(request, response);
		}
		else if (prodaction != null && prodaction.equals("Update")) {
			// Send the use back to the form, if there were errors
			if (!errors.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/pages/movie.jsp");
				failureView.forward(request, response);
				return;//程式中斷
			}
			MovieVO result = service.update(bean);
			if (result == null) {
				errors.put("action", "update product table failed");
			}
			else {
				request.setAttribute("update", result);
			}
			request.getRequestDispatcher("/pages/movie.jsp").forward(request, response);
		}
		else if (prodaction != null && prodaction.equals("Delete")) {
			boolean result = service.delete(bean);
			if (result == false) {
				errors.put("action", "Delete product table failed");
			}
			else {
				request.setAttribute("delete", result);
			}
			request.getRequestDispatcher("/pages/movie.jsp").forward(request, response);
		}
		else {
			errors.put("action", "unknown action : " + prodaction);
			request.getRequestDispatcher("/pages/movie.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
