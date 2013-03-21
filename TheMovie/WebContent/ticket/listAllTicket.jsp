<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.ticket.model.*"%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>

<%
TicketService ticketSvc = new TicketService();
    List<TicketVO> list = ticketSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>所有員工資料 - listAllTicket.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
</head>
<body bgcolor='white'>
<b><font color=red>此頁採用原來的 JSTL 與 EL 取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td><h3>所有員工資料 - ListAllTicket.jsp</h3>
		          <a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td></tr></table>

<table border='1' bordercolor='#CCCCFF' >
	<tr>
		<th>ticketID</th>
		<th>roundsID</th>
		<th>seatRow</th>
		<th>seatColumn</th>
		<th>seatName</th>
		<th>mbID</th>
		<th>salesID</th>
		<th>soldDateTime</th>
		<th>orderedDateTime</th>
		<th>price</th>
		<th>typeID</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="ticketVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr>
			<td>${ticketVO.ticketID}</td>
			<td>${ticketVO.roundsVO.roundsDateTime}</td>
			<td>${ticketVO.seatRow}</td>
			<td>${ticketVO.seatColumn}</td>
			<td>${ticketVO.seatName}</td>
			<td>${ticketVO.memberVO.firstName}</td>
			<td>${ticketVO.salesVO.salesName}</td>
			<td>${ticketVO.soldDateTime}</td>
			<td>${ticketVO.orderedDateTime}</td>
			<td>${ticketVO.price}</td>
			<td>${ticketVO.ticketTypeVO.typeName}</td>
			<td>
			    <s:form action="getOne_For_UpdateTicket" namespace="/ticket"  method="getOne_For_Update">
			        <s:submit value="修改" />
			        <input type="text" name="ticketID" value="${ticketVO.ticketID}" />
			    </s:form>
			</td>
			<td>
			    <s:form action="deleteTicket" namespace="/ticket"  method="delete">
			        <s:submit value="刪除" />
			        <input type="text" name="ticketID" value="${ticketVO.ticketID}" />
			    </s:form>
			</td>
		</tr>
		
	</c:forEach>
</table>
<%@ include file="page2.file" %>

<a href="listAllTicketForDelete.jsp">ggggggggggg</a>

</body>
</html>
