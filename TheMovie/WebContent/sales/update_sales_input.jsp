<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料修改 - update_sales_input.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
<sx:head debug="false" cache="false"  parseContent="false" compressed="false"  extraLocales="zh-tw,en-us,ja,ko"/>
</head>
<body bgcolor='white' >

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>員工資料修改 - update_sales_input.jsp</h3>
			          <a href="select_page.jsp"><img src="images/back1.gif"  width="100" height="32" border="0">回首頁 </a></td></tr></table>
	
	<h3>員工資料:</h3>
	<s:form action="updateSales" namespace="/sale" >
	    <s:textfield name="salesVO.salesID" label="員工編號" value="%{#request.salesVO.salesID}"  readonly="true" cssStyle="background:gray" />
		<s:textfield name="salesVO.salesName" label="員工姓名" value="%{#request.salesVO.salesName}"/> 
		<s:textfield name="salesVO.account"   label="帳號" value="%{#request.salesVO.account}"/>
		<s:textfield name="salesVO.password"   label="密碼" value="%{#request.salesVO.password}"/>		
		<s:textfield name="salesVO.theaID"  label="影院" value="%{#request.salesVO.theaID}"/>
		<s:textfield name="salesVO.activation" label="狀態" value="%{#request.salesVO.activation}"/>
<%-- 		<s:bean   name="com.dept.model.DeptService" id="deptSvc" /> --%>
<%-- 		<s:select name="salesVO.deptVO.deptno" label="員工部門" labelposition="center" list="#deptSvc.all" listKey="deptno" listValue="dname" value="%{#request.salesVO.deptVO.deptno}"/> --%>
		<s:submit value="送出" method="update"/>
		<s:reset  value="重新輸入" />
	</s:form>
	
</body>
</html>

