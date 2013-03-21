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
		</tr>
		<tr>
			<td >EL</td>
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
		</tr>
		<tr align='center' valign='middle'>
		     <td >OGNL-  #request.ticketTypeVO.xxx</td>
			 <td><s:property value="#request.ticketVO.ticketID" /></td>
			 <td><s:property value="#request.ticketVO.roundsVO.roundsID" /></td>
             <td><s:property value="#request.ticketVO.seatRow" /></td>
             <td><s:property value="#request.ticketVO.seatColumn" /></td>
             <td><s:property value="#request.ticketVO.seatName" /></td>
             <td><s:property value="#request.ticketVO.memberVO.mbID" /></td>
             <td><s:property value="#request.ticketVO.salesVO.salesID" /></td>
			 <td><s:property value="#request.ticketVO.soldDateTime" /></td>
             <td><s:property value="#request.ticketVO.orderedDateTime" /></td>
             <td><s:property value="#request.ticketVO.price" /></td>
             <td><s:property value="#request.ticketVO.ticketTypeVO.typeID" /></td>
        </tr>
	</table>

</body>
</html>
