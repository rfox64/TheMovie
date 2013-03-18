<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料 - listOneTicketType.jsp</title>
<s:head theme="xhtml" /><!-- 預設 -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='1000'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>員工資料 - ListOneTicketType.jsp</h3>
		              <a href="select_page.jsp"> <img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td></tr></table>

	<table border='1' bordercolor='#CCCCFF' width='1000'>
		<tr>
			<th align="left">EL</th>
			<th>typeID</th>
			<th>theaID</th>
			<th>roomType</th>
			<th>typeName</th>
			<th>typePrice</th>
			<th>summary</th>
		</tr>
		<tr>
			<td ">EL</td>
			<td>${ticketTypeVO.typeID}</td>
			<td>${ticketTypeVO.theaterVO.theaName}</td>
			<td>${ticketTypeVO.roomType}</td>
			<td>${ticketTypeVO.typeName}</td>
			<td>${ticketTypeVO.typePrice}</td>
			<td>${ticketTypeVO.summary}</td>
			
		</tr>
		<tr align='center' valign='middle'>
		     <td >OGNL-  #request.ticketTypeVO.xxx</td>
			 <td><s:property value="#request.ticketTypeVO.typeID" /></td>
			 <td><s:property value="#request.ticketTypeVO.theaterVO.theaName" /></td>
             <td><s:property value="#request.ticketTypeVO.roomType" /></td>
             <td><s:property value="#request.ticketTypeVO.typeName" /></td>
             <td><s:property value="#request.ticketTypeVO.typePrice" /></td>
             <td><s:property value="#request.ticketTypeVO.summary" /></td>
        </tr>
	</table>

</body>
</html>
