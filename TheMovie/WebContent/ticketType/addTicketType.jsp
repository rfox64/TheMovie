<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料新增 - addTicketType.jsp</title>
<s:head theme="xhtml" /><!-- 預設 -->
<sx:head debug="false" cache="false" parseContent="false"	compressed="false" extraLocales="zh-tw,en-us,ja,ko" />
</head>
<body bgcolor='white' onLoad="setValue()">

	<table border='1' cellpadding='5' cellspacing='0' width='500'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>員工資料新增 - addTicketType.jsp</h3></td>
			<td><a href="select_page.jsp"><img src="images/tomcat.gif"	width="100" height="100" border="1"> 回首頁 </a></td></tr></table>

	<%-- 錯誤表列 --%>
	<%-- <s:fielderror cssStyle="color: blue" /> --%>
 
	<h3>員工資料:</h3>
	<s:form action="addTicketType" namespace="/ticketType">
	<%--	<s:textfield name="ticketTypeVO.theaterVO.theaID" label="theaID" value="1"/> --%>
		<s:bean name="com.theater.model.TheaterService" id="theaterSvc" />
	<s:select name="ticketTypeVO.theaterVO.theaID" label="theaName" labelposition="center" list="#theaterSvc.all" listKey="theaID" listValue="theaName" value="%{#request.ticketTypeVO.theaterVO.theaID}"/>
	
		<s:textfield name="ticketTypeVO.roomType" label="roomType" value="1"/>
		<s:textfield name="ticketTypeVO.typeName" label="typeName" value="GOGO"/>
		<s:textfield name="ticketTypeVO.typePrice" label="typePrice" value="10.2"/>
		<s:textarea name="ticketTypeVO.summary" label="summary" value="hhh"/>
		
		
	
		
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

