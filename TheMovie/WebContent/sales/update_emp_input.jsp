<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sales.model.*"%>
<%
	SalesVO salesVO = (SalesVO) request.getAttribute("salesVO"); //EmpServlet.java (Concroller), �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���u��ƭק� - update_emp_input.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>���u��ƭק� - update_emp_input.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></td>
	</tr>
</table>

<h3>��ƭק�:</h3>
<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
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
		<td>���u�s��:<font color=red><b>*</b></font></td>
		<td><%=salesVO.getSalesID()%></td>
	</tr>
	<tr>
		<td>���u�m�W:</td>
		<td><input type="TEXT" name="salesName" size="45" value="<%=salesVO.getSalesName()%>" /></td>
	</tr>
	<tr>
		<td>�b��:</td>
		<td><input type="TEXT" name="account" size="45"	value="<%=salesVO.getAccount()%>" /></td>
	</tr>
<%-- 	<tr>
		<td>���Τ��:</td>
		<td bgcolor="#CCCCFF">
		    <input class="cal-TextBox"
			onFocus="this.blur()" size="9" readonly type="text" name="hiredate" value="<%=empVO.getHiredate()%>">
			<a class="so-BtnLink"
			href="javascript:calClick();return false;"
			onmouseover="calSwapImg('BTN_date', 'img_Date_OVER',true);"
			onmouseout="calSwapImg('BTN_date', 'img_Date_UP',true);"
			onclick="calSwapImg('BTN_date', 'img_Date_DOWN');showCalendar('form1','hiredate','BTN_date');return false;">
		    <img align="middle" border="0" name="BTN_date"	src="images/btn_date_up.gif" width="22" height="17" alt="�}�l���"></a>
		</td>
	</tr> --%>
	<tr>
		<td>�K�X:</td>
		<td><input type="TEXT" name="sal" size="45"	value="<%=salesVO.getPassword()%>" /></td>
	</tr>
	<tr>
		<td>�q�v�|*�L:</td>
		<td><input type="TEXT" name="comm" size="45" value="<%=salesVO.getTheaID()%>" /></td>
	</tr>
	<tr>
		<td>����:</td>
		<td><input type="TEXT" name="comm" size="45" value="<%=salesVO.getActivation()%>" /></td>
	</tr>

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
<%-- 	<tr>
		<td>����:<font color=red><b>*</b></font></td>
		<td><select size="1" name="deptno">
			<c:forEach var="deptVO" items="${deptSvc.all}">
				<option value="${deptVO.deptno}" ${(empVO.deptVO.deptno==deptVO.deptno)?'selected':'' } >${deptVO.dname}
			</c:forEach>
		</select></td>
	</tr> --%>

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="salesno" value="<%=salesVO.getSalesID()%>">
<input type="submit" value="�e�X�ק�"></FORM>

</body>
</html>
