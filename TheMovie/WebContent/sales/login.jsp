<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登錄頁面</title>
<s:head theme="xhtml" /><!-- 預設 -->
</head>
<body bgcolor='white'>
	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>IBM Sales: Home</h3>
		</tr>
	</table>

	<p>唯影售票員修改登錄頁面</p>

	<h3>資料查詢:</h3>
	<%-- 錯誤表列 --%>
    <s:fielderror cssStyle="color: red" />

	<ul>
		<li>
            <s:form action="loginSales_stust" namespace="/sales" theme="simple"> 
               <b>輸入員工帳號 :</b> 
                <s:textfield name="account" /><br>
<!--                <b>輸入員工密碼 :</b>  -->
<%--                 <s:textfield passw="password" /><br> --%>
				<s:submit	 value="登入"  method="login_SalesIDAction" />
            </s:form>
		</li>
		
	</ul>


<!-- 	<h3>員工管理</h3> -->
<!-- 	<ul> -->
<!-- 		<li><a href='addSales.jsp'>Add</a> a new Emp.</li> -->
<!-- 	</ul> -->

</body>
</html>
