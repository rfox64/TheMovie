<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet" type="text/css" href="<c:url value="/moviecss/movie.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/moviecss/jquery.ui.all.css" />" />

<script type="text/javascript" src="<c:url value="/moviejs/jquery-1.9.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/moviejs/myXMLHttp.js" />"></script>
<script type="text/javascript" src="<c:url value="/moviejs/jquery.ui.core.js"/>"></script>
<script type="text/javascript" src="<c:url value="/moviejs/jquery.ui.widget.js" />"></script>
<script type="text/javascript" src="<c:url value="/moviejs/jquery.ui.datepicker.js"/>"></script>





<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>


	<script>
	$(function() {
		$( "#mvStartDate" ).datepicker({
			dateFormat: "yy-mm-dd",
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 3,
			onClose: function( selectedDate ) {
				$( "#mvEndDate" ).datepicker( "option", "minDate", selectedDate );
			}
		});
		$( "#mvEndDate" ).datepicker({
			dateFormat: "yy-mm-dd",
			defaultDate: "+1w",
			changeMonth: true,
			numberOfMonths: 3,
			onClose: function( selectedDate ) {
				$( "#mvStartDate" ).datepicker( "option", "maxDate", selectedDate );
			}
		});
	});
	</script>


<title>電影 Movie Table</title>


</head>
<body>
<form action="<c:url value='/pages/movie.controller'/>" method="post">
<fieldset ><legend>電影 Movie Table</legend>
<table id="movieTable">
	<tr>
		<td>mvID : </td>
		<td><input type="text" name="mvID" value="${param.mvID}" ></td>
		<td><c:if test="${not empty select}"><span class="error">${errors.id}</span></c:if></td>
	</tr>
	<tr>
		<td>片名（中文） : </td>
		<td><input type="text" name="mvNameC" value="${param.mvNameC}"></td>
		<td><span class="error">${errors.mvNameC}</span></td>
	</tr>
	<tr>
		<td>片名（外文） : </td>
		<td><input type="text" name="mvNameE" value="${param.mvNameE}"></td>
		<td><span class="error">${errors.mvNameE}</span></td>
	</tr>
	<tr>
		<td>上映日期 : </td>
		<td><input type="text" id="mvStartDate" name="mvStartDate" value="${param.mvStartDate}"></td>
		<td><span class="error">${errors.mvStartDate}</span></td>
	</tr>
	<tr>
		<td>下映日期 : </td>
		<td><input type="text" id="mvEndDate" name="mvEndDate" value="${param.mvEndDate}"></td>
		<td><span class="error">${errors.mvEndDate}</span></td>
	</tr>
	<tr>
		<td>導　　演 : </td>
		<td><input type="text" name="mvDirector" value="${param.mvDirector}"></td>
	</tr>
	<tr>
		<td>演　　員 : </td>
		<td><input type="text" name="mvCast" value="${param.mvCast}"></td>
	</tr>
	<tr>
		<td>發行公司 : </td>
		<td><input type="text" name="mvCom" value="${param.mvCom}"></td>
	</tr>
	<tr>
		<td>官方網站 : </td>
		<td><input type="text" name="mvURL" value="${param.mvURL}"></td>
	</tr>
	<tr>
		<td>劇情簡介 : </td>
		<td><input type="text" name="mvStory" value="${param.mvStory}"></td>
	</tr>
	<tr>
		<td>評分星星 : </td>
		<td><input type="text" name="mvRank" value="${param.mvRank}"></td>
	</tr>
	<tr>
		<td>預告片: </td>
		<td><input type="text" name="mvPreview" value="${param.mvPreview}"></td>
	</tr>
	<tr>
		<td>分級級別: </td>
		<td>
		<input type="radio" name="mvLevelID" value="0" ${param.mvLevelID == '0' ? 'checked' : ''}>普通
		<input type="radio" name="mvLevelID" value="1" ${param.mvLevelID == '1' ? 'checked' : ''}>保護
		<input type="radio" name="mvLevelID" value="2" ${param.mvLevelID == '2' ? 'checked' : ''}>輔導
		<input type="radio" name="mvLevelID" value="3" ${param.mvLevelID == '3' ? 'checked' : ''}>限制
		</td>
	</tr>
		<tr>
		<td>IMAX數位3D: </td>
		<td>
		<input type="radio" name="mvTypeID" value="1" ${param.mvTypeID == '1' ? 'checked' : ''}>數位
		<input type="radio" name="mvTypeID" value="2" ${param.mvTypeID == '2' ? 'checked' : ''}>３Ｄ
		<input type="radio" name="mvTypeID" value="3" ${param.mvTypeID == '3' ? 'checked' : ''}>IMAX
		<input type="radio" name="mvTypeID" value="4" ${param.mvTypeID == '4' ? 'checked' : ''}>IMAX 3D
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="prodaction" value="Insert">
			<input type="submit" name="prodaction" value="Update">
		</td>
		<td>
			<input type="submit" name="prodaction" value="Delete">
			<input type="submit" name="prodaction" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>
</fieldset>
</form>


<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>Delete Movie Table Success : ${delete} row(s) deleted.</h3>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert Movie Table Success</h3>
<table border="1">
	<thead>
		<tr>
			<th>Column Name</th><th>Column Value</th>
		</tr>	
	</thead>
	<tbody>
		<td>片名（外文） : </td>
			<td>${insert.mvNameE}</td>
		</tr>
		<tr>
			<td>片名（中文） : </td>
			<td>${insert.mvNameC}</td>
		</tr>
		<tr>
			<td>上映日期 : </td>
			<td>${insert.mvStartDate}</td>
		</tr>
		<tr>
			<td>下映日期 : </td>
			<td>${insert.mvEndDate}</td>
		</tr>
		<tr>
			<td>導　　演: </td>
			<td>${insert.mvDirector}</td>
		</tr>
		<tr>
			<td>演　　員: </td>
			<td>${insert.mvCast}</td>
		</tr>
		<tr>
			<td>發行公司: </td>
			<td>${insert.mvCom}</td>
		</tr>
		<tr>
			<td>官方網站: </td>
			<td>${insert.mvURL}</td>
		</tr>
		<tr>
			<td>劇情簡介: </td>
			<td>${insert.mvStory}</td>
		</tr>
		<tr>
			<td>評分星星: </td>
			<td>${insert.mvRank}</td>
		</tr>
		<tr>
			<td>預告片: </td>
			<td>${insert.mvPreview}</td>
		</tr>
		<tr>
			<td>分級級別: </td>
			<td>${insert.mvLevelID}</td>
		</tr>
		<tr>
			<td>IMAX數位3D: </td>
			<td>${insert.mvTypeID}</td>
		</tr>
	</tbody>
</table>
</c:if>

<c:if test="${not empty update}">
<h3>Update Movie Table Success</h3>
<table border="1">
	<thead>
		<tr>
			<th>Column Name</th><th>Column Value</th>
		</tr>	
	</thead>
	<tbody>
		<tr>
			<td>mvID : </td>
			<td>${update.mvID}</td>
		</tr>
		<tr>
			<td>片名（外文） : </td>
			<td>${update.mvNameE}</td>
		</tr>
		<tr>
			<td>片名（中文） : </td>
			<td>${update.mvNameC}</td>
		</tr>
		<tr>
			<td>上映日期 : </td>
			<td>${update.mvStartDate}</td>
		</tr>
		<tr>
			<td>下映日期 : </td>
			<td>${update.mvEndDate}</td>
		</tr>
		<tr>
			<td>導　　演: </td>
			<td>${update.mvDirector}</td>
		</tr>
		<tr>
			<td>演　　員: </td>
			<td>${update.mvCast}</td>
		</tr>
		<tr>
			<td>發行公司: </td>
			<td>${update.mvCom}</td>
		</tr>
		<tr>
			<td>官方網站: </td>
			<td>${update.mvURL}</td>
		</tr>
		<tr>
			<td>劇情簡介: </td>
			<td>${update.mvStory}</td>
		</tr>
		<tr>
			<td>評分星星: </td>
			<td>${update.mvRank}</td>
		</tr>
		<tr>
			<td>預告片: </td>
			<td>${update.mvPreview}</td>
		</tr>
		<tr>
			<td>分級級別: </td>
			<td>${update.mvLevelID}</td>
		</tr>
		<tr>
			<td>IMAX數位3D: </td>
			<td>${update.mvTypeID}</td>
		</tr>
	</tbody>
</table>
</c:if>



</body>
</html>