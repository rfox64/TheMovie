<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>IBM Sales: Home</title>
<s:head theme="xhtml" /><!-- �w�] -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>IBM Sales: Home</h3>	<font color=red>( Struts2  MVC )</font></td>
		</tr></table>

	<h2>�߼v�Ⲽ���קﭶ��</h2>

	<h3>��Ƭd��:</h3>
	<%-- ���~��C --%>
    <s:fielderror cssStyle="color: red" />

	<ul>
		<li><a href='listAllSales.jsp'>List</a> all Sales.</li><br>

		<li>
            <s:form action="getOne_For_DisplaySales" namespace="/sales" theme="simple">  �i<font color=blue>theme="simple"</font>�j
               <b>��J���u�s�� :</b> 
                <s:textfield name="salesID" />
				<s:submit	 value="�e�X"  method="getOne_For_Display" />
            </s:form>
		</li>

        <s:bean name="com.sales.model.SalesService"  id="salesSvc" />   <%-- 	�۷�� <jsp:useBean id="empSvc" scope="request" class="com.emp.model.EmpService" /> --%>

		<li>
			<s:form action="getOne_For_DisplaySales" namespace="/sales" theme="simple">  �i<font color=blue>theme="simple"</font>�j
				<b>��ܭ��u�s��:</b>
				<s:select name="salesID" labelposition="center" list="#salesSvc.all" listKey="salesID" listValue="salesID" /> 
				<s:submit value="�e�X"  method="getOne_For_Display" />
			</s:form>
		</li>
		
		<li>
			<s:form action="getOne_For_DisplaySales" namespace="/sales" theme="simple">  �i<font color=blue>theme="simple"</font>�j
				<b>��ܭ��u�m�W:</b>
				<s:select name="salesID" labelposition="center" list="#salesSvc.all" listKey="salesID" listValue="salesName" /> 
				<s:submit value="�e�X"  method="getOne_For_Display" />
			</s:form>
		</li>
		
	</ul>


	<h3>���u�޲z</h3>
	<ul>
		<li><a href='addSales.jsp'>Add</a> a new Emp.</li>
	</ul>

</body>
</html>
