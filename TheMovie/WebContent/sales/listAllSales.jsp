<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.sales.model.*"%>
<%-- �����ĥ� JSTL �P EL ���� --%>

<%
	SalesService salesSvc = new SalesService();
    List<SalesVO> list = salesSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�Ҧ����u��� - listAllSales.jsp</title>
<s:head theme="xhtml"  /><!-- �w�] -->
</head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td><h3>�Ҧ����u��� - ListAllSales.jsp</h3>
		          <a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></td></tr></table>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>���u�s��</th>
		<th>���u�m�W</th>
		<th>�b��</th>
		<th>�K�X</th>
		<th>�v�|</th>
		<th>���A</th>
		<th>�ק�</th>
		<th>�R��</th>
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
<%-- 			<td>
	          ${salesVO.deptVO.deptno}�i<font color=orange>${salesVO.deptVO.dname}</font> - ${salesVO.deptVO.loc}�j               
			</td> --%>
			<td>
			    <s:form action="getOne_For_UpdateSales" namespace="/sales"  method="getOne_For_Update">
			        <s:submit value="�ק�" />
			        <input type="hidden" name="salesID" value="${salesVO.salesID}">
			    </s:form>
			</td>
			<td>
			    <s:form action="deleteSales" namespace="/sales"  method="delete">
			        <s:submit value="�R��" />
			        <input type="hidden" name="salesID" value="${salesVO.salesID}">
			    </s:form>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
