<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sales.model.*"%>
<%
	SalesVO salesVO = (SalesVO) request.getAttribute("salesVO");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料新增 - addEmp.jsp</title>
</head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='500'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td>
				<h3>員工資料新增 - addEmp.jsp</h3>
			</td>
			<td><a href="select_page.jsp"><img src="images/tomcat.gif"
					width="100" height="100" border="1">回首頁</a></td>
		</tr>
	</table>

	<h3>資料員工:</h3>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font color='red'>請修正以下錯誤:
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li>${message}</li>
				</c:forEach>
			</ul>
		</font>
	</c:if>

	<FORM METHOD="post" ACTION="sales.do" name="form1">
		<table border="0">

			<tr>
				<td>員工姓名:</td>
				<td><input type="TEXT" name="salesName" size="45" value="" /></td>
			</tr>
			<tr>
				<td>帳號:</td>
				<td><input type="TEXT" name="account" size="45" value="" /></td>
			</tr>

			<tr>
				<td>密碼:</td>
				<td><input type="TEXT" name="password" size="45" value="" /></td>
			</tr>
			<tr>
				<td>電影院:</td>
				<td><input type="TEXT" name=theaID size="45" value="" /></td>
			</tr>


			<tr>
				<td>在職代碼:</td>
				<td><input type="TEXT" name="activation" size="45" value="" /></td>
			</tr>


			<%-- 
	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />
	<tr>
		<td>部門:<font color=red><b>*</b></font></td>
		<td><select size="1" name="deptno">
			<c:forEach var="deptVO" items="${deptSvc.all}">
				<option value="${deptVO.deptno}" ${(empVO.deptVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname}
			</c:forEach>
		</select></td>
	</tr> --%>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>

</html>
