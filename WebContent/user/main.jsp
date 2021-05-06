<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="model.member" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<script>
function search(){
	form.submit();
}
</script>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<title>Mod's Tour</title>
<script>
	function toggleImg(){
		document.getElementById("mainImg").src="<c:url value='/images/mainImg2.JPG'/>";
	}
	function toggleImg2(){
		document.getElementById("mainImg").src="<c:url value='/images/mainImg3.PNG'/>";
	}
</script>
</head>

<body>
	<nav class="modbar">
		<div class="mod_name">
			<h1><a href="<c:url value='/user/main'></c:url>">Mod's Tour</a></h1>
		</div>

		<ul class="mod_menu">
			<!-- 회원용 상단바 -->
			<% if(session.getAttribute("divGuide") == null){ %>
				<li><a href="<c:url value='/user/safeGrade'></c:url>">안전등급</a></li>
				<li><a href="<c:url value='/user/mypage'></c:url>">마이페이지</a></li>
				<li><a href="<c:url value='/user/myreservation'></c:url>">예약확인</a></li>
				<li>커뮤니티</li>
			<%} else{ %>  <!-- 가이드용 상단바 -->
				<li><a href="<c:url value='/guide/addreservation/form'></c:url>">상품추가</a></li>
				<li><a href="<c:url value='/guide/checkreservation'></c:url>">상품조회</a></li>
			<%} %>
		</ul>
		
		<ul class="mod_login">
			<% if(session.getAttribute("userId") == null){ %>
				<li><a href="<c:url value='/user/login/form'></c:url>">로그인</a></li>
			<%} else{ %>
				<li><a href="<c:url value='/user/logout'></c:url>">로그아웃( ${curUserId}님 )</a></li>
			<%} %>
			<li><a href="<c:url value='/user/register/form'></c:url>">회원가입</a></li>
		</ul>
	</nav>
	<hr>
	
	<div class="mod_img">
	<table>
		<tr>
		<td>													
			<button class="btn" onclick="toggleImg()"> <img src="<c:url value='/images/leftIcon.png'/>" width="100" height="100"> </button>
		</td>
		<td><img id="mainImg" src="<c:url value='/images/mainImg1.jpg'/>" width="900" height="600"></td>
		<td>
			<button class="btn" onclick="toggleImg2()"> <img src="<c:url value='/images/rightIcon.png'/>" width ="100" height="100"> </button>
		</td>
		</tr>
	</table>
	</div>
	<hr>
	<br><br><br>
	
	<div align = "center">
	<form name="mainSearch" action ="<c:url value='/item/searchView' /> " method="GET">
		<input type="text" name="searchView" placeholder="찾으시는 상품을 검색해주세요." size="100">
		<input type="image" src="<c:url value='/images/search.png'/>" alt="검색" width="15" height="15" onClick="search()">
	</form>
	</div>
	<br><br><br>
	
	<p align="center"> <font size="3" face="돋움">카테고리 별로 내가 원하는 상품을 지금 바로 한눈에 만나보세요!</font></p>
	<br><br><br>
	<div align="center">
		<button name="nationBtn" class="btn1" onClick="location.href='<c:url value='/item/country/form'></c:url>' "> 나라별 </button><tr>
		<button name="dayBtn" class="btn2" onClick="location.href='<c:url value='/item/season/form'></c:url>' "> 시기별 </button><tr>
		<button name="themaBtn" class="btn3" onClick="location.href='<c:url value='/item/theme/form'></c:url>' "> 테마별 </button><tr>
		<button name="priceBtn" class="btn4" onClick="location.href='<c:url value='/item/price/form'></c:url>' "> 가격별 </button><tr>
	</div>
	<br><br><br><br>
	<hr>
	
	<br><br>
	<p align="center"> <font size="2" font-weight="bold" face="돋움">현재 Mod의 인기 여행상품</font></p>
	<br>
	<div align="center">
		<button name="nationBtn" class="btn_item" onClick=""> 프랑스 </button><td>
		<button name="dayBtn" class="btn_item" onClick=""> 미국 </button><td>
		<button name="themaBtn" class="btn_item" onClick=""> 방콕 </button><td>
		<button name="priceBtn" class="btn_item" onClick=""> 제주도 </button><td>
	</div>
	<br><br><br>
	<hr>
	
	<div>
	<table align ="center">
	<tr>
		<td padding-left = "10" width ="500" align="center">
			<font size="4" font-weight="bold">NOTICE</font><br><br><br><br><br>
			<font size="4" font-weight="bold" align="left">[공지]</font><br>
			<p> <font size="2">현재 코로나로 인해 외국 여행에 제한이 있으니 양해 부탁드립니다. <br>
				또한, 국내선 탑승 시 발열이 있는 경우 탑승취소가 될 수 있으니 참고해 주시기 바랍니다.</font>
			</p> <br><br><br><br><br>
			<font size="4" font-weight="bold" align="left">[이벤트]</font><br>
			<p> <font size="2">현재 모든 국내 상품 패키지를 저렴한 가격으로 준비했습니다. <br>
				지금 예약하고 SNS를 통해 인증해주시면 추천을 통해 상품을 보내드립니다!</font>
			</p>
		</td>
		<td>
			 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<hr class="height_hr">
			 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		</td>
		<td padding-right = "10" align="center">
			<font size="4" font-weight="bold" >지금 떠나고 싶은 여행지를 적어주세요! </font><br><br><br>
			<textarea cols="80" rows="10"></textarea><br><br>
			<input type="submit" value="폼제출">
		</td>
	</tr>
	</table>
	</div>
	
	<hr>
	<p align="center"><font size="2">Mod's Tour</font></p>
</body>
</html>