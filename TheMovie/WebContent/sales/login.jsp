<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>�n������</title>
<s:head theme="xhtml" /><!-- �w�] -->
</head>
<body bgcolor='white'>
	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>IBM Sales: Home</h3>
		</tr>
	</table>

	<p>�߼v�Ⲽ���ק�n������</p>

	<h3>��Ƭd��:</h3>
	<%-- ���~��C --%>
    <s:fielderror cssStyle="color: red" />

	<ul>
		<li>
            <s:form action="loginSales_stust" namespace="/sales" theme="simple"> 
               <b>��J���u�b�� :</b> 
                <s:textfield name="account" /><br>
<!--                <b>��J���u�K�X :</b>  -->
<%--                 <s:textfield passw="password" /><br> --%>
				<s:submit	 value="�n�J"  method="login_SalesIDAction" />
            </s:form>
		</li>
		
	</ul>


<!-- 	<h3>���u�޲z</h3> -->
<!-- 	<ul> -->
<!-- 		<li><a href='addSales.jsp'>Add</a> a new Emp.</li> -->
<!-- 	</ul> -->

</body>
</html>
