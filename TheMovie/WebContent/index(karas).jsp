<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Welcome.jsp</title>
</head>

<body>
<h3>Welcome.jsp</h3>
<ul>
    <li><a href="<%=request.getContextPath()%>/login.jsp" >登入(login.jsp) </a></li>
    <li><a href="<%=request.getContextPath()%>/member/listAllMember.jsp" >查詢列表(listAllMember.jsp) </a></li>


<!--     <li><a href="<s:url action="member/myAction1"/>">員工專區1(emp/myAction1.action --  emp/select_page1.jsp)</a></li> -->
<!--     <li><a href="<s:url action="member/myAction2"/>">員工專區2(emp/myAction2.action  -- emp/select_page2.jsp")</a></li> -->
<!--     <li><a href="<s:url action="free/HelloWorld"/>">一般頁面1(free/HelloWorld.action --   free/HelloWorld.jsp")</a></li> -->
</ul>

</body>
</html>
