<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Ticket修改 - update_Ticket_input.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->

<sx:head debug="false" cache="false"  parseContent="false" compressed="false"  extraLocales="zh-tw,en-us,ja,ko"/>
<style type="text/css">

#updateTicket_ticketVO_roundsVO_roundsID {background-color:#333}

</style>
</head>
<body bgcolor='white' >

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>電影票修改 - update_ticket_input.jsp</h3>
			          <a href="select_page.jsp"><img src="images/back1.gif"  width="100" height="32" border="0">回首頁 </a></td></tr></table>
	
	<h3>ticketType資料:</h3>
	<s:form action="updateTicket" namespace="/ticket" >
	<s:bean name="com.ticketType.model.TicketTypeService" id="ticketTypeSvc" />
	<s:bean name="com.rounds.model.RoundsService" id="roundsSvc" />
	<s:bean name="com.member.model.MemberService" id="memberSvc" />
	<s:bean name="com.sales.model.SalesService" id="salesSvc" />
	
	
	<s:textfield  name="ticketVO.ticketID" label="ticket編號" value="%{#request.ticketVO.ticketID}"  readonly="true" cssStyle="background:gray" />
	<s:select  name="ticketVO.roundsVO.roundsID" list="#roundsSvc" label="roundsDateTime"  listKey="%{#request.ticketVO.roundsVO.roundsID}" listValue="%{#request.ticketVO.roundsVO.roundsDateTime}" value="%{#request.ticketVO.roundsVO.roundsID}"/>
	<s:textfield name="ticketVO.seatRow" label="seatRow" value="%{#request.ticketVO.seatRow}" readonly="true" /> 
	<s:textfield name="ticketVO.seatColumn" label="seatColumn" value="%{#request.ticketVO.seatColumn}" readonly="true" /> 
	<s:textfield name="ticketVO.seatName" label="seatName" value="%{#request.ticketVO.seatName}" readonly="true" /> 
	
	
	<s:select name="ticketVO.memberVO.mbID" label="memberID" labelposition="center" list="#memberSvc.all" listKey="mbID" listValue="mbID+' '+lastName+' '+firstName" value="%{#request.ticketVO.memberVO.mbID}"/>
	
	
	<s:select name="ticketVO.salesVO.salesID" label="salesID" labelposition="center" list="#salesSvc.all" listKey="salesID" listValue="salesID+'  '+salesName" value="%{#request.ticketVO.salesVO.salesID}"/>
	
	
	
	<s:select name="ticketVO.ticketTypeVO.typeID" label="typeID"  labelposition="center" list="#ticketTypeSvc.all" listKey="typeID" listValue="typeID+'  '+typeName+'  '+typePrice+'元'" value="%{#request.ticketVO.ticketTypeVO.typeID}" />

	 

	<s:submit value="送出" method="update"/>
	<s:reset  value="重新輸入" />
	</s:form>
	
</body>
</html>

