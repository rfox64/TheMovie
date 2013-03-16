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
	width: 1050px;
	border-collapse: collapse;
	position: relative;
}


div{
	overflow: auto;
}



fieldset {
	border:0;
	padding:15px;
	margin-bottom:10px;
	background:#EEE;

	border-radius: 8px;
	-moz-border-radius: 8px;
	-webkit-border-radius: 8px;

	background:-webkit-liner-gradient(top,#EEEEEE,#FFFFFF);
	background:linear-gradient(top,#EFEFEF,#FFFFFF);

	box-shadow:3px 3px 10px #666;
	-moz-box-shadow:3px 3px 10px #666;
	-webkit-box-shadow:3px 3px 10px #666;

	position:relative;
	top:10px;
	
	font-size: 14px;
	
	}

legend {
	padding:5px 5px;
	background-color:#4F709F;
	color:#FFF;

	border-radius:3px;
	-moz-border-radius:3px;
	-webkit-border-radius:3px;

	box-shadow:2px 2px 4px #666;
	-moz-box-shadow:2px 2px 4px #666;
	-webkit-box-shadow:2px 2px 4px #666;

	position:absolute;
	left:10px;top:-10px;
	}








li{
	list-style: none;	
}








.container{
	width: 1050px;
	float: left;
	margin: 50px 10px 10px;
	padding: 5px;
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

<%-- <h3>Select Movie Table Result : ${fn:length(select)} row(s) selected</h3> --%>




<c:if test="${not empty select}">

	    <div id="pajinate" class="container">
	    	<div class="page_navigation"></div>

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
		
		<fieldset><legend>${row.mvNameC}</legend>
		<br>
<a href="${link}">${row.mvNameE}</a><br>
<a href="${link}"><img alt="電影封面" height='220' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />01.jpg"></a><br>
上映日期:<fmt:formatDate value="${row.mvStartDate}" dateStyle="full"/><br>
<br>
導　　演：${row.mvDirector}<br>
演　　員：${row.mvCast}<br>
<textarea rows="5" cols="118">劇情簡介：${row.mvStory}</textarea>

<hr>
		</fieldset>

		
		
<input type="hidden" value="${row.mvID}">
<input type="hidden" value="${row.mvCom}">
<input type="hidden" value="${row.mvURL}">
<input type="hidden" value="${row.mvRank}">
<input type="hidden" value="${row.mvPreview}">
<input type="hidden" value="${row.mvLevelID}">
<input type="hidden" value="${row.mvTypeID}">

	</li>
	</c:forEach>
	
	
	</ul>

<div class="page_navigation"></div>

</div>
</c:if>



<h3><a href="<c:url value='/pages/movie.jsp'/>">Movie Table</a></h3>
</body>
</html>