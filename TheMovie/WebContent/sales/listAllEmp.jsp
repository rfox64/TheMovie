<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sales.model.*"%>
<%-- �����m�߱ĥ� EL ���g�k���� --%>

<%
    SalesService salesSvc = new SalesService();
    List<SalesVO> list = salesSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�Ҧ����u��� - listAllEmp.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>�����m�߱ĥ� EL ���g�k����:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>�Ҧ����u��� - ListAllEmp.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a>
		</td>
	</tr>
</table>

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

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>���u�s��</th>
		<th>���u�m�W</th>
		<th>�b��</th>
		<th>�K�X</th>
		<th>�q�v�|*�L</th>
		<th>���A</th>
	<!--<th>����</th> -->
		<th>�ק�</th>
<!-- 	<th>�R��</th> -->
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="salesVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		<tr align='center' valign='middle'>
			<td>${salesVO.salesID}</td>
			<td>${salesVO.salesName}</td>
			<td>${salesVO.account}</td>
			<td>${salesVO.password}</td>
			<td>${salesVO.theaID}</td>
			<td>${salesVO.activation}</td>
<%-- 		<td>
	          ${empVO.deptVO.deptno}�i<font color=orange>${empVO.deptVO.dname}</font> - ${empVO.deptVO.loc}�j               
			</td> --%>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/sales/sales.do">
			     <input type="submit" value="�ק�">
			     <input type="hidden" name=salesID value="${salesVO.salesID}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
<%-- 			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/sales/sales.do">
			    <input type="submit" value="�R��">
			    <input type="hidden" name="salesID" value="${salesVO.salesID}">
			    <input type="hidden" name="action"value="delete"></FORM>
			</td> --%>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
