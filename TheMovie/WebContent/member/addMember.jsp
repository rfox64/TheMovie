<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>會員資料新增 - addMember.jsp</title>
<s:head theme="xhtml" />
<!-- 預設 -->
<sx:head debug="false" cache="false" parseContent="false"
 	compressed="false" extraLocales="zh-tw,en-us,ja,ko" />
</head>
<body bgcolor='white' onLoad="setValue()">

	<table border='1' cellpadding='5' cellspacing='0' width='500'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>會員資料新增 - addMember.jsp</h3></td>
			<td><a href="select_page.jsp"><img src="images/tomcat.gif"
					width="100" height="100" border="1"> 回首頁 </a></td>
		</tr>
	</table>

	<%-- 錯誤表列 --%>
	<%-- <s:fielderror cssStyle="color: blue" /> --%>

	<h3>員工資料:</h3>
	<%-- 	<s:form action="addEmp" namespace="/emp"> --%>
	<%-- 		<s:textfield name="empVO.ename" label="員工姓名" /> --%>
	<%-- 		<s:textfield name="empVO.job"   label="員工職位" /> --%>
	<%-- 		<sx:datetimepicker name="empVO.hiredate" label="雇用日期"	type="date" displayFormat="yyyy-MM-dd " id="picker1" language="zh-tw" cssStyle="background:cyan ; font-size:13.5px" />捨棄原來的 value="%{'today'}" , 改用javascript的setValue() --%>
	<%-- 		<s:textfield name="empVO.sal"  label="員工薪水" /> --%>
	<%-- 		<s:textfield name="empVO.comm" label="員工獎金" /> --%>
	<%-- 		<s:bean name="com.dept.model.DeptService" id="deptSvc" /> --%>
	<%-- 		<s:select name="empVO.deptVO.deptno" label="員工部門" labelposition="center" list="#deptSvc.all" listKey="deptno" listValue="dname" /> --%>
	<%-- 	    <s:submit value="送出新增" method="add" /> --%>
	<%-- 	</s:form> --%>
	<s:form action="addMember" namespace="/member">
<%-- 		<s:textfield name="memberVO.mbID" label="mbID" /> --%>
		<s:textfield name="memberVO.firstName" label="firstName" />
		<s:textfield name="memberVO.lastName" label="lastName" />
		<s:textfield name="memberVO.cityID" label="cityID" />
		<s:textfield name="memberVO.regionID" label="regionID" />
		<s:textfield name="memberVO.address" label="address" />
		<s:textfield name="memberVO.mobile" label="mobile" />
		<s:textfield name="memberVO.birthday" label="birthday" />
		<s:textfield name="memberVO.gender" label="gender" />
		<s:textfield name="memberVO.proID" label="proID" />
		<s:textfield name="memberVO.eduID" label="eduID" />
		<s:textfield name="memberVO.email" label="email" />
		<s:textfield name="memberVO.password" label="password" />
		<s:textfield name="memberVO.activation" label="activation" />
		<s:textfield name="memberVO.inactivationD" label="inactivationD" />
		<s:submit value="送出新增" method="add" />
	</s:form>

	<script type="text/javascript">
		function setValue() {
			var picker1 = dojo.widget.byId("picker1");
			if (picker1.getValue() == "")
				picker1.setValue(new Date()); //Date value  //picker.setValue('2007-01-01');  //string value
		}
	</script>

</body>
</html>

