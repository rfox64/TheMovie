<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value="/moviecss/jquery.mobile-1.3.0.css" />" />

<script type="text/javascript" src="<c:url value="/moviejs/jquery-1.9.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/moviejs/jquery.mobile-1.3.0.js"/>"></script>
<script type="text/javascript" src="<c:url value="/moviejs/myXMLHttp.js" />"></script>


<title>Display</title>
</head>
<body>



        <div data-role="page" id="display_all" >
            <div data-role="header" data-position="fixed" data-theme="b" data-content-theme="b" >
                <a data-role="button" data-rel="back"
                   data-icon="back" data-iconpos="left">
                                                電影資訊
                </a>
                <h2>電影介紹</h2>
            </div>
            
            
            <div data-role="content" data-theme="b" data-content-theme="b" >
            <ul data-role="listview" data-filter="true" data-inset="true">
            <c:forEach var="row" items="${select}">
            

                    <li>
                        <a href="#display_${row.mvID}">
                            <img alt="電影封面" hight="100%" src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />01.jpg">
                            <h3>${row.mvNameC}（${row.mvNameE}）</h3>
                            <p>上映日期:<fmt:formatDate value="${row.mvStartDate}" dateStyle="full"/></p>
                        </a>
                    </li>

           
            </c:forEach>
            </ul>
             </div>
            
            <div data-role="footer" data-position="fixed" data-theme="b" data-content-theme="b">
				<div data-role="navbar">
					<ul>
						<li><span class="ui-title" /></li>
						<li><a href="<c:url value="/indexMovie.jsp" />" class="ui-btn-active">The Movie &copy;</a></li>
						<li><span class="ui-title" /></li>
					</ul>
				</div><!-- /navbar -->
            </div>            
        </div>


<c:forEach var="row" items="${select}">
        <div data-role="page" id="display_${row.mvID}">
            <div data-role="header" data-position="fixed" data-theme="b" data-content-theme="b" >
                <a data-role="button" data-rel="back"
                   data-icon="back" data-iconpos="left">
                   電影資訊
                </a>
                <h2>電影介紹</h2>
            </div>
            
            
            <div data-role="content" >
            
                <div data-role="collapsible" data-collapsed="false" data-theme="b" data-content-theme="b">
                    <h3>${row.mvNameC}（${row.mvNameE}）</h3>
                    <p><img alt="電影分級" src="../MoviePIC/LevelID_icon/${row.mvLevelID}.gif"></p>
                    <p><img alt="電影封面圖1" height='220' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />01.jpg"></p>
                    <p>上映日期:<fmt:formatDate value="${row.mvStartDate}" dateStyle="full"/></p>
                </div>
                
                <div data-role="collapsible" data-collapsed="false" data-theme="b" data-content-theme="b">
                    <h3>演　　員</h3>
                    <p>${row.mvCast}</p>
                </div>

                <div data-role="collapsible" data-collapsed="false" data-theme="b" data-content-theme="b">
                    <h3>導　　演</h3>
                    <p>${row.mvDirector}</p>
                </div>
                
                <div data-role="collapsible" data-collapsed="false" data-theme="b" data-content-theme="b">
                    <h3>劇情簡介</h3>
                    <p>${row.mvStory}</p>
                </div>
                
                <div data-role="collapsible" data-collapsed="false" data-theme="b" data-content-theme="b">
                    <h3>劇　　照</h3>
                    <p><img alt="電影圖2" height='220' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />02.jpg"></p>
                    <p><img alt="電影圖3" height='220' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />03.jpg"></p>
                    <p><img alt="電影圖4" height='220' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />04.jpg"></p>
                    <p><img alt="電影圖5" height='220' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />05.jpg"></p>
                    <p><img alt="電影圖6" height='220' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />06.jpg"></p>
                    <p><img alt="電影圖7" height='220' src="../MoviePIC/<fmt:formatNumber minIntegerDigits='2' value='${row.mvID}' />07.jpg"></p>
                </div>
                                
             </div><!-- /content -->
            
            <div data-role="footer" data-position="fixed" data-theme="b" data-content-theme="b">
				<div data-role="navbar">
					<ul>
						<li><span class="ui-title" /></li>
						<li><a href="<c:url value="/indexMovie.jsp" />" class="ui-btn-active">The Movie &copy;</a></li>
						<li><span class="ui-title" /></li>
					</ul>
				</div><!-- /navbar -->
            </div>            
        </div>
</c:forEach>






</body>
</html>