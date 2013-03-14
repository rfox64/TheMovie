<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料修改 - update_member_input.jsp</title>
<s:head theme="xhtml" />
<!-- 預設 -->
<sx:head debug="false" cache="false" parseContent="false"
	compressed="false" extraLocales="zh-tw,en-us,ja,ko" />
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>會員資料修改 - update_member_input.jsp</h3> <a
				href="select_page.jsp"><img src="images/back1.gif" width="100"
					height="32" border="0">回首頁 </a></td>
		</tr>
	</table>

	<h3>員工資料:</h3>
	<s:form action="updateMember" namespace="/member">
	    <s:textfield name="memberVO.mbID" label="mbID"
 			value="%{#request.memberVO.mbID}" />
		<s:textfield name="memberVO.firstName" label="firstName"
			value="%{#request.memberVO.firstName}" />
		<s:textfield name="memberVO.lastName" label="lastName"
			value="%{#request.memberVO. lastName }" />
		<s:textfield name="memberVO.cityID" label="cityID"
			value="%{#request.memberVO. cityID }" />
		<s:textfield name="memberVO.regionID" label="regionID"
			value="%{#request.memberVO. regionID }" />
		<s:textfield name="memberVO.address" label="address"
			value="%{#request.memberVO. address }" />
		<s:textfield name="memberVO.mobile" label="mobile"
			value="%{#request.memberVO. mobile }" />
		<s:textfield name="memberVO.birthday" label="birthday"
			value="%{#request.memberVO. birthday }" />
		<s:textfield name="memberVO.gender" label="gender"
			value="%{#request.memberVO. gender }" />
		<s:textfield name="memberVO.proID" label="proID"
			value="%{#request.memberVO. proID }" />
		<s:textfield name="memberVO.eduID" label="eduID"
			value="%{#request.memberVO. eduID }" />
		<s:textfield name="memberVO.email" label="email"
			value="%{#request.memberVO. email }" />
		<s:textfield name="memberVO.password" label="password"
			value="%{#request.memberVO. password }" />
		<s:textfield name="memberVO.activation" label="activation"
			value="%{#request.memberVO. activation }" />
		<s:textfield name="memberVO.inactivationD" label="inactivationD"
			value="%{#request.memberVO. inactivationD }" />
		<s:submit value="送出" method="update" />
		<s:reset value="重新輸入" />
	</s:form>

</body>
</html>

