<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>���u��ƭק� - update_sales_input.jsp</title>
<s:head theme="xhtml"  /><!-- �w�] -->
<sx:head debug="false" cache="false"  parseContent="false" compressed="false"  extraLocales="zh-tw,en-us,ja,ko"/>
</head>
<body bgcolor='white' >

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>���u��ƭק� - update_sales_input.jsp</h3>
			          <a href="select_page.jsp"><img src="images/back1.gif"  width="100" height="32" border="0">�^���� </a></td></tr></table>
	
	<h3>���u���:</h3>
	<s:form action="updateSales" namespace="/sale" >
	    <s:textfield name="salesVO.salesID" label="���u�s��" value="%{#request.salesVO.salesID}"  readonly="true" cssStyle="background:gray" />
		<s:textfield name="salesVO.salesName" label="���u�m�W" value="%{#request.salesVO.salesName}"/> 
		<s:textfield name="salesVO.account"   label="�b��" value="%{#request.salesVO.account}"/>
		<s:textfield name="salesVO.password"   label="�K�X" value="%{#request.salesVO.password}"/>		
		<s:textfield name="salesVO.theaID"  label="�v�|" value="%{#request.salesVO.theaID}"/>
		<s:textfield name="salesVO.activation" label="���A" value="%{#request.salesVO.activation}"/>
<%-- 		<s:bean   name="com.dept.model.DeptService" id="deptSvc" /> --%>
<%-- 		<s:select name="salesVO.deptVO.deptno" label="���u����" labelposition="center" list="#deptSvc.all" listKey="deptno" listValue="dname" value="%{#request.salesVO.deptVO.deptno}"/> --%>
		<s:submit value="�e�X" method="update"/>
		<s:reset  value="���s��J" />
	</s:form>
	
</body>
</html>

