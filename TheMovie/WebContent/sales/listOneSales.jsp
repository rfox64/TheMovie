<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���u��� - listOneSales.jsp</title>
<s:head theme="xhtml" /><!-- �w�] -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='1000'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>���u��� - ListOneEmp.jsp</h3>
		              <a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></td></tr></table>

	<table border='1' bordercolor='#CCCCFF' width='1000'>
		<tr>
<!-- 			<th align="left">EL �� OGNL(Object-Graph Navigation Language)</th> -->
			<th>���u�s��</th>
			<th>���u�m�W</th>
			<th>�b��</th>
			<th>�K�X</th>
			<th>�v�|</th>
			<th>���A</th>
		</tr>
		<tr align='center' valign='middle'>
<!-- 		     <td align="left">EL</td> -->
		     <td>${salesVO.salesID}</td>
			 <td>${salesVO.salesName}</td>
             <td>${salesVO.account}</td>
             <td>${salesVO.password}</td>
             <td>${salesVO.theaID}</td>
             <td>${salesVO.activation}</td>
            <%--  <td>${salesVO.deptVO.deptno}�i${salesVO.deptVO.dname} - ${salesVO.deptVO.loc}�j</td> --%>
		</tr>
<!-- 		<tr align='center' valign='middle'> -->
<!-- 		     <td align="left">OGNL-  #request.salesVO.xxx</td> -->
<%-- 			 <td><s:property value="#request.salesVO.salesID" /></td> --%>
<%-- 			 <td><s:property value="#request.salesVO.salesName" /></td> --%>
<%--              <td><s:property value="#request.salesVO.account" /></td> --%>
<%--              <td><s:property value="#request.salesVO.password" /></td> --%>
<%--              <td><s:property value="#request.salesVO.theaID" /></td> --%>
<%--              <td><s:property value="#request.salesVO.activation" /></td> --%>
<%-- <%--              <td><s:property value="#request.salesVO.deptVO.deptno" />�i<s:property value="#request.salesVO.deptVO.dname" /> - <s:property value="#request.salesVO.deptVO.loc" />�j</td> --%>
<!-- 		</tr> -->
	</table>

</body>
</html>
