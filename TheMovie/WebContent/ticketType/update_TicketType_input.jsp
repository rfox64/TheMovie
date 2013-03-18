<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料修改 - update_TicketType_input.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
<sx:head debug="false" cache="false"  parseContent="false" compressed="false"  extraLocales="zh-tw,en-us,ja,ko"/>
</head>
<body bgcolor='white' >

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>員工資料修改 - update_ticketType_input.jsp</h3>
			          <a href="select_page.jsp"><img src="images/back1.gif"  width="100" height="32" border="0">回首頁 </a></td></tr></table>
	
	<h3>ticketType資料:</h3>
	<s:form action="updateTicketType" namespace="/ticketType" >
	<s:textfield name="ticketTypeVO.typeID" label="type編號" value="%{#request.ticketTypeVO.typeID}"  readonly="true" cssStyle="background:gray" />
	<s:bean name="com.theater.model.TheaterService" id="theaterSvc" />
	<s:select name="ticketTypeVO.theaterVO.theaID" label="theaName" labelposition="center" list="#theaterSvc.all" listKey="theaID" listValue="theaName" value="%{#request.ticketTypeVO.theaterVO.theaID}"/>
	<s:textfield name="ticketTypeVO.roomType" label="roomType" value="%{#request.ticketTypeVO.roomType}"/> 
	<s:textfield name="ticketTypeVO.typeName" label="typeName" value="%{#request.ticketTypeVO.typeName}"/> 
	<s:textfield name="ticketTypeVO.typePrice" label="typePrice" value="%{#request.ticketTypeVO.typePrice}"/> 
	<s:textarea name="ticketTypeVO.summary" label="summary" value="%{#request.ticketTypeVO.summary}"/> 
	<s:submit value="送出" method="update"/>
	<s:reset  value="重新輸入" />
	</s:form>
	
</body>
</html>

