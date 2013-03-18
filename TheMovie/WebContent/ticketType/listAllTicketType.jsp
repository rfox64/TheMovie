<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ticketType.model.*"%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>

<%
TicketTypeService ticketTypeSvc = new TicketTypeService();
    List<TicketTypeVO> list = ticketTypeSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>所有員工資料 - listAllTicketType.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
</head>
<body bgcolor='white'>
<b><font color=red>此頁採用原來的 JSTL 與 EL 取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td><h3>所有員工資料 - ListAllTicketType.jsp</h3>
		          <a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td></tr></table>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>typeID</th>
		<th>theaName</th>
		<th>roomType</th>
		<th>typeName</th>
		<th>typePrice</th>
		<th>summary</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="ticketTypeVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr>
			<td>${ticketTypeVO.typeID}</td>
			<td>${ticketTypeVO.theaterVO.theaName}</td>
			<td>${ticketTypeVO.roomType}</td>
			<td>${ticketTypeVO.typeName}</td>
			<td>${ticketTypeVO.typePrice}</td>
			<td>${ticketTypeVO.summary}</td>
			<td>
			    <s:form action="getOne_For_UpdateTicketType" namespace="/ticketType"  method="getOne_For_Update">
			        <s:submit value="修改" />
			        <input type="text" name="typeID" value="${ticketTypeVO.typeID}" />
			    </s:form>
			</td>
			<td>
			    <s:form action="deleteTicketType" namespace="/ticketType"  method="delete">
			        <s:submit value="刪除" />
			        <input type="text" name="typeID" value="${ticketTypeVO.typeID}" />
			    </s:form>
			</td>
		</tr>
		
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
