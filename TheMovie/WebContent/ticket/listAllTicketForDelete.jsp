<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %> 
<%@ page import="java.util.*"%>
<%@ page import="com.ticket.model.*"%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>刪除多張電影票.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
<sx:head debug="false" cache="false"  parseContent="false" compressed="false"  extraLocales="zh-tw,en-us,ja,ko"/>
<style type="text/css">
#div1{background-color:orange;width:700px}
.checkboxLabel {width:20px;height:50px}
TABLE.wwFormTable>tbody>tr>td>*{width:20px;height:50px}
</style>
</head>
<body bgcolor='white'>
<b><font color=red>此頁採用原來的 JSTL 與 EL 取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td><h3>所有員工資料 - ListAllTicket.jsp</h3>
		          <a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td></tr></table>
<div id="div1">
<s:form action="deleteMultipleTicket" namespace="/ticket"  >
<s:bean name="com.ticket.model.TicketService" id="ticketSvc" />
<s:checkboxlist name="ticketVO.ticketID"  list="#ticketSvc.all" listKey="ticketID" listValue="seatName" value="%{#request.ticketVO.ticketID}" />

<s:submit value="送出刪除" method="deleteMultipleTicket" />
<s:reset />
</s:form>
</div>
</body>
</html>
