<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>

<%
	MemberService memberSvc = new MemberService();
	List<MemberVO> list = memberSvc.getAll();
	pageContext.setAttribute("list", list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>所有員工資料 - listAllMember.jsp</title>
<s:head theme="xhtml" />
<!-- 預設 -->
</head>
<body bgcolor='white'>
	<b><font color=red>此頁採用原來的 JSTL 與 EL 取值:</font></b>
	<table border='1' cellpadding='5' cellspacing='0' width='800'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>所有員工資料 - ListAllMember.jsp</h3> <a
				href="select_page.jsp"><img src="images/back1.gif" width="100"
					height="32" border="0">回首頁</a></td>
		</tr>
	</table>

	<table border='1' bordercolor='#CCCCFF' width='800'>
		<tr>
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
		<%@ include file="page1.file"%>
		<c:forEach var="memberVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">
			<tr align='center' valign='middle'>
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

				<%-- 				<td>${empVO.deptVO.deptno}【<font color=orange>${empVO.deptVO.dname}</font> --%>
				<%-- 					- ${empVO.deptVO.loc}】 --%>
				</td>
				<td><s:form action="getOne_For_UpdateMember" namespace="/member"
						method="getOne_For_Update">
						<s:submit value="修改" />
						<input type="hidden" name="mbID" value="${memberVO.mbID}">
					</s:form></td>
				<td><s:form action="deleteMember" namespace="/member" method="delete">
						<s:submit value="刪除" />
						<input type="hidden" name="mbID" value="${memberVO.mbID}">
					</s:form></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>
