<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>login.jsp</title>
</head>
<body>
	<H2>讀取session中的資訊</H2><OL>
		
		<LI><h3> 歡迎: <s:property value="#session.account" />  (ONGL)</h3>
		<LI><h3> 歡迎: <s:property value="account" />     (ONGL)</h3>
		<LI><h3> 歡迎: ${account}   (EL)</h3>
		<LI><h3> 歡迎: ${sessionScope.account}   (EL)</h3>
		
</OL>
</body>
</html>
