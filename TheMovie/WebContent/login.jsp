<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>login.jsp</title>
</head>
<body>
	<center> <br> <b>
	    
	    使用者登入</b><br>

		
		<s:form action="loginHandler" namespace="/login" method="post">
			<s:textfield name="account" label="帳號" size="15" />
			<s:password name="password" label="密碼" size="15" />
			<s:submit value="登入"  align="right"/>
		</s:form>
		
		 <!-- 【登入失敗】 或【尚未登入】 時的提示警告 -->
	     <br><font color="red"><b><s:property value="prompt" /></b></font>
	
	</center>
</body>
</html>
