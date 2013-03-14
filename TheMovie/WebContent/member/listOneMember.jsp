<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>
<s:head theme="xhtml" />
<!-- 預設 -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='1000'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>員工資料 - ListOneMember.jsp</h3> <a href="select_page.jsp"><img
					src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td>
		</tr>
	</table>

	<table border='1' bordercolor='#CCCCFF' width='1000'>
		<tr>
			<th align="left">EL 或 OGNL(Object-Graph Navigation Language)</th>
			<th>mbID</th>
			<th>firstName</th>
			<th>lastName</th>
			<th>cityID</th>
			<th>regionID</th>
			<th>address</th>
			<th>mobile</th>
			<th>birthday</th>
			<th>gender</th>
			<th>proID</th>
			<th>eduID</th>
			<th>email</th>
			<th>password</th>
			<th>activation</th>
			<th>inactivationD</th>
		</tr>
		<tr align='center' valign='middle'>
			<td align="left">EL</td>
			<td>${memberVO.mbID}</td>
			<td>${memberVO.firstName}</td>
			<td>${memberVO.lastName}</td>
			<td>${memberVO.cityID}</td>
			<td>${memberVO.regionID}</td>
			<td>${memberVO.address}</td>
			<td>${memberVO.mobile}</td>
			<td>${memberVO.birthday}</td>
			<td>${memberVO.gender}</td>
			<td>${memberVO.proID}</td>
			<td>${memberVO.eduID}</td>
			<td>${memberVO.email}</td>
			<td>${memberVO.password}</td>
			<td>${memberVO.activation}</td>
			<td>${memberVO.inactivationD}</td>
		</tr>
		<tr align='center' valign='middle'>
			<td align="left">OGNL- #request.empVO.xxx</td>
			<td><s:property value="#request.memberVO.mbID" /></td>
			<td><s:property value="#request.memberVO.firstName" /></td>
			<td><s:property value="#request.memberVO.lastName" /></td>
			<td><s:property value="#request.memberVO.cityID" /></td>
			<td><s:property value="#request.memberVO.regionID" /></td>
			<td><s:property value="#request.memberVO.address" /></td>
			<td><s:property value="#request.memberVO.mobile" /></td>
			<td><s:property value="#request.memberVO.birthday" /></td>
			<td><s:property value="#request.memberVO.gender" /></td>
			<td><s:property value="#request.memberVO.proID" /></td>
			<td><s:property value="#request.memberVO.eduID" /></td>
			<td><s:property value="#request.memberVO.email" /></td>
			<td><s:property value="#request.memberVO.password" /></td>
			<td><s:property value="#request.memberVO.activation" /></td>
			<td><s:property value="#request.memberVO.inactivationD" /></td>

		</tr>
	</table>

</body>
</html>
