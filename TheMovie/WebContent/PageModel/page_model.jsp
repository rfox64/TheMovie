<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>0000defult</title>
<link rel="stylesheet" href="css/page.css">

<style>
#page p {
	font-family: verdana;
	font-size:16px;
	color:#FEFFAF;	
	}
#page h2 {
	color: #FFFF33;
	text-shadow: 2px 2px 2px #BCBE00;
}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script> 
<script type="text/javascript" src="js/jquery.bubbleup.js"></script>
<script type="text/javascript">
$(function(){

    $("div#demo ul#menu li img").bubbleup({tooltip: true, scale:96});
    
});
</script>

</head>
<body id="body">
	<div id="allpage">
		<div id="header">
				<div id="logo">
					<img src="images/logo6.jpg"><br><br>
				</div>
				<!--end logo-->

		</div>
		<!--end header-->
		<div id="demo">
			<ul id="menu">
				<li><a href="https://www.google.com.tw/"><img
						src="images/demo01.png" alt="會員專區" /></a></li>
				<li><a href="https://www.google.com.tw/"> <img
						src="images/demo02.png" alt="電影介紹" /></a></li>
				<li><a href="https://www.google.com.tw/"> <img
						src="images/demo03.png" alt="廳院介紹" /></a></li>
				<li><a href="https://www.google.com.tw/"> <img
						src="images/demo04.png" alt="影城介紹" /></a></li>
				<li><a href="https://www.google.com.tw/"> <img
						src="images/demo06.png" alt="最新消息" /></a></li>
				<li><a href="https://www.google.com.tw/"
					onClick="window.open('https://www.google.com.tw/', 'delicious','toolbar=no,width=800,height=600'); return false;">
						<img src="images/demo05.png" alt="自己Google" /></a></li>
			</ul>
		</div>
		<!-- end demo -->
		<div style="clear: both;"></div>
		<div id="article">
			<div id="page">
				<h2>WBC經典賽∕日本連霸夢碎</h2><br>
				<p>
					WBC經典賽四強準決賽正式展開，日本隊對決波多黎各，雖然8局下日本隊追回1分，但最後還是不敵波國，以3:1落敗提前出局，確定無緣３連霸。
					日本隊先發投手前田健太首局就遭遇亂流，遭狀況超好的Mike Aviles擊出中外野落地安打失分。 但7局上Alex
					Rios在壘上有人的局面敲出左外野大號2分彈，中繼的能見篤史遭一棒擊沉退場。
					8局下鳥谷敬打出左中外野的三壘安打，老將井端弘和敲出適時安打，日本隊終於追回1分。
					不過內川聖一上壘後，似乎是看錯暗號，讓自己被夾殺在一、二壘之間，接下來隊長阿部慎之助也沒能打出安打，日本隊本有機會追平，卻毀於一旦。
					最後日本隊全場僅擊出6支安打，想要3連霸的美夢也正式心碎，波國有望挑戰隊史首次經典賽總冠軍。</p>
			</div>
			<!-- end page -->

		</div>
		<!--end page-->
		<div style="clear: both"></div><br>
		<!--end article-->	
		<div id="footer">
			<p>Copyright &copy; 2013 EEIT66 唯影電影</p>
		</div>
		<!--end footer-->
	</div>
	<!--end allpage-->
</body>
</html>

