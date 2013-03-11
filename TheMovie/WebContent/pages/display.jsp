<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/moviecss/table.css" />" />

<script type="text/javascript" src="<c:url value="/moviejs/jquery-1.9.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/moviejs/myXMLHttp.js" />"></script>
<script type="text/javascript" src="<c:url value="/moviejs/jquery.pajinate.js"/>"></script>


<script type="text/javascript">
   $(function(){
	   
	   $(document).ready(function(){
			$('#pajinate').pajinate({
				start_page : 0,
				items_per_page : 3
			});
		});	

	   
   });
</script>

<style type="text/css">


body{
	height: 100%;
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	margin: 45px;
	width: 1920px;
	border-collapse: collapse;
	position: relative;
}


div{
	overflow: auto;
}


li{
	list-style: none;	
}


.container{
	width: 1920px;
	float: left;
	margin: 50px 10px 10px;
	padding: 20px;
	background-colorr: rgb(128, 128, 128);
}

.page_navigation , .alt_page_navigation{
	padding-bottom: 10px;
	border-radius: 5px 5px 5px 5px;
}

.page_navigation a, .alt_page_navigation a{
	padding:7px 15px;
	margin:2px;
	color:white;
	text-decoration:none;
	float: left;
	font-family: Tahoma;
	font-size: 12px;
	background-color: rgb(65, 183, 216);
	border-radius: 5px 5px 5px 5px;
}


.active_page{
	background-color:white !important;
	color:black !important;
}	

.content, .alt_content{
	color: black;
}

.content li, .alt_content li, .content > p{
	padding: 5px
}


</style>

<title>Display</title>
</head>
<body>

<h3>Select Movie Table Result : ${fn:length(select)} row(s) selected</h3>




<c:if test="${not empty select}">

	    <div id="pajinate" class="container">
	    	<div class="page_navigation"></div>

<table>

	<thead>
	<tr>
		<th>mvID</th>
		<th>片名（中文）</th>
		<th>片名（外文）</th>
		<th>電影劇照</th>
		<th>上映日期</th>
		<th>下映日期</th>
		<th>導　　演</th>
		<th>演　　員</th>
		<th>發行公司</th>
		<th>官方網站</th>
		<th>劇情簡介</th>
		<th>評分星星</th>
		<th>預 告 片</th>
		<th>分　　級</th>
		<th>IMAX數位3D</th>
	</tr>
	</thead>
</table>
	<ul class="content">
	
	
	<c:forEach var="row" items="${select}">
	<li>
	
		<c:url value="/pages/movie.jsp" var="link" scope="page">
			<c:param name="mvID" value="${row.mvID}" />
			<c:param name="mvNameC" value="${row.mvNameC}" />
			<c:param name="mvNameE" value="${row.mvNameE}" />
			<c:param name="mvStartDate" value="${row.mvStartDate}" />
			<c:param name="mvEndDate" value="${row.mvEndDate}" />
			<c:param name="mvDirector" value="${row.mvDirector}" />
			<c:param name="mvCast" value="${row.mvCast}" />
			<c:param name="mvCom" value="${row.mvCom}" />
			<c:param name="mvURL" value="${row.mvURL}" />
			<c:param name="mvStory" value="${row.mvStory}" />
			<c:param name="mvRank" value="${row.mvRank}" />
			<c:param name="mvPreview" value="${row.mvPreview}" />
			<c:param name="mvLevelID" value="${row.mvLevelID}" />
			<c:param name="mvTypeID" value="${row.mvTypeID}" />
		</c:url>
<table>
	<tr>
		<td><a href="${link}">${row.mvID}</a></td>
		<td><a href="${link}">${row.mvNameC}</a></td>
		<td><a href="${link}">${row.mvNameE}</a></td>
		<td><a href="${link}"><img alt="電影封面" height='180' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />01.jpg"></a></td>
		<td>${row.mvStartDate}</td>
		<td>${row.mvEndDate}</td>
		<td>${row.mvDirector}</td>
		<td>${row.mvCast}</td>
		<td>${row.mvCom}</td>
		<td>${row.mvURL}</td>
		<td>${row.mvStory}</td>
		<td>${row.mvRank}</td>
		<td>${row.mvPreview}</td>
		<td>${row.mvLevelID}</td>
		<td>${row.mvTypeID}</td>
	</tr>
	</table>
	</li>
	</c:forEach>
	
	
	</ul>

<div class="page_navigation"></div>

</div>
</c:if>



<h3><a href="<c:url value='/pages/movie.jsp'/>">Movie Table</a></h3>
</body>
</html>