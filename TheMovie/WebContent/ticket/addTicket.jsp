<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料新增 - addTicket.jsp</title>
<s:head theme="xhtml" /><!-- 預設 -->
<sx:head debug="false" cache="false" parseContent="false"	compressed="false" extraLocales="zh-tw,en-us,ja,ko" />
</head>
<body bgcolor='white' onLoad="setValue()">

	<table border='1' cellpadding='5' cellspacing='0' width='500'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>員工資料新增 - addTicket.jsp</h3></td>
			<td><a href="select_page.jsp"><img src="images/tomcat.gif"	width="100" height="100" border="1"> 回首頁 </a></td></tr></table>

	<%-- 錯誤表列 --%>
	<%-- <s:fielderror cssStyle="color: blue" /> --%>
 
	<h3>員工資料:</h3>
	<s:form action="addTicket" namespace="/ticket">
		<s:bean name="com.rounds.model.RoundsService" id="roundsSvc" />
		<s:bean name="com.member.model.MemberService" id="memberSvc" />
		<s:bean name="com.sales.model.SalesService" id="salesSvc" />
		<s:bean name="com.ticketType.model.TicketTypeService" id="ticketTypeSvc" />
		<s:select name="ticketVO.roundsVO.roundsID" label="roundsID"  labelposition="center" list="#roundsSvc.all" listKey="roundsID" listValue="roundsID" value="%{#request.ticketVO.roundsVO.roundsID}"/>
		<s:textfield name="ticketVO.seatRow" label="seatRow" value="1"/>
		<s:textfield name="ticketVO.seatColumn" label="seatColumn" value="1"/>
		<s:textfield name="ticketVO.seatName" label="seatName" value="A99"/>
		<s:select name="ticketVO.memberVO.mbID" label="mbID" labelposition="center" list="#memberSvc.all" listKey="mbID" listValue="mbID" value="%{#request.ticketVO.memberVO.mbID}"/>
		<s:select name="ticketVO.salesVO.salesID" label="salesID" labelposition="center" list="#salesSvc.all" listKey="salesID" listValue="salesID" value="%{#request.ticketVO.salesVO.salesID}"/>
		<s:textfield name="ticketVO.soldDateTime" label="soldDateTime" value="1"/>
		<s:textfield name="ticketVO.orderedDateTime" label="orderedDateTime" value="1"/>
		<s:textfield name="ticketVO.price" label="price" value="199.9"/>
		<s:select name="ticketVO.ticketTypeVO.typeID" label="typeID" labelposition="center" list="#ticketTypeSvc.all" listKey="typeID" listValue="typeID" value="%{#request.ticketVO.ticketTypeVO.typeID}"/>
		
		
	
		
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

