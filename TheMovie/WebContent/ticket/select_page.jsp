<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>IBM ticket: Home</title>
<s:head theme="xhtml" /><!-- 預設 -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>IBM ticket: Home</h3>	<font color=red>( Struts2  MVC )</font></td></tr></table>

	<p>This is the Home page for IBM ticket: Home</p>

	<h3>資料查詢:</h3>
	<%-- 錯誤表列 --%>
    <s:fielderror cssStyle="color: red" />

	<ul>
		<li><a href='listAllTicket.jsp'>List</a> all ticket.</li> <br>

		<li>
            <s:form action="getOne_For_DisplayTicket" namespace="/ticket" theme="css_xhtml">  【<font color=blue>theme="simple"</font>】
               <b>輸入員工編號 (如7001):</b> 
                <s:textfield name="typeID" />
				<s:submit	 value="送出"  method="getOne_For_Display" />
            </s:form>
		</li>

        <s:bean name="com.ticket.model.TicketService"  id="ticketSvc" />   <%-- 	相當於 <jsp:useBean id="empSvc" scope="request" class="com.emp.model.EmpService" /> --%>

		<li>
			<s:form action="getOne_For_DisplayTicket" namespace="/ticket" theme="simple">  【<font color=blue>theme="simple"</font>】
				<b>選擇ticketID:</b>
			<s:select name="ticketID" labelposition="center" list="#ticketSvc.all" listKey="ticketID" listValue="ticketID" />  
				<s:submit value="送出"  method="getOne_For_Display" />
			</s:form>
		</li>
		
		<li>
			<s:form action="getOne_For_DisplayTicket" namespace="/ticket" theme="simple">  【<font color=blue>theme="simple"</font>】
				<b>選擇seatName:</b>
			<s:select name="ticketID" labelposition="center"  list="#ticketSvc.all" listKey="ticketID" listValue="seatName" />   
				<s:submit value="送出"  method="getOne_For_Display" />
			</s:form>
		</li>
		
	</ul>


	<h3>員工管理</h3>
	<ul>
		<li><a href='addTicket.jsp'>Add</a> a new ticket.</li>
	</ul>

</body>
</html>
