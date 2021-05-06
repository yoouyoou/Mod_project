<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="utf-8"%>
<%@page import="model.member" %>
<%@page import="model.item" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String curUserId = (String)request.getAttribute("curUserId");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">
<!-- 외부 swiper link -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>

<!-- 내부 style link -->
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<link rel=stylesheet href="<c:url value='/css/category.css' />" type="text/css">
<link rel=stylesheet href="<c:url value='/css/swiper.css' />" type="text/css">

<title>국가별 상품</title>
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
				<li><a href="<c:url value='/user/logout'></c:url>">로그아웃(<%= curUserId %>님)</a></li>
			<%} %>
			<li><a href="<c:url value='/user/register/form'></c:url>">회원가입</a></li>
		</ul>
	</nav>
	<hr>
	
	<!-- 상품 나열 시작 -->
	<nav class="category_menu">
        <ul>
            <li style="text-decoration:underline;"><a href="<c:url value='/item/country/form'></c:url>">국가</a></li>  
            <li><a href="<c:url value='/item/season/form'></c:url>">시기</a></li>
            <li><a href="<c:url value='/item/theme/form'></c:url>">테마</a></li>
            <li><a href="<c:url value='/item/price/form'></c:url>">가격</a></li>
        </ul>
    </nav>
    
<!--swiper -->
<div style=" margin-top:10px;" align="center">국내</div>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<a href="<c:url value='/item/view'> <c:param name='viewId' value='1'/></c:url>">
				<img src="<c:url value='/images/jejuSpring.jpg'/>"></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='2'/>
					   </c:url>"><img src="<c:url value='/images/busan.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='4'/>
					   </c:url>"><img src="<c:url value='/images/gyeongju.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='5'/>
					   </c:url>"><img src="<c:url value='/images/winterJeju.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='3'/>
					   </c:url>"><img src="<c:url value='/images/jinhea.jpg'/> "></a></div>
		</div>
		
		<!-- 네비게이션 -->
		<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
		
		<!-- 페이징 -->
		<div class="swiper-pagination"></div>
	</div>
	
	<div style="margin-top:10px;" align="center">베트남</div>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='6'/>
					   </c:url>"><img src="<c:url value='/images/hanoi.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='8'/>
					   </c:url>"><img src="<c:url value='/images/danang.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='7'/>
					   </c:url>"><img src="<c:url value='/images/hochiminh.jpg'/> "></a></div>
		</div>

		<!-- 네비게이션 -->
		<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		<div class="swiper-button-prev"></div><!-- 이전 버튼 -->

		<!-- 페이징 -->
		<div class="swiper-pagination"></div>
	</div>
	
	<div style=" margin-top:10px;" align="center">말레이시아</div>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='10'/>
					   </c:url>"><img src="<c:url value='/images/kotakinabalu.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='9'/>
					   </c:url>"><img src="<c:url value='/images/kualaLumpur.jpg'/> "></a></div>
		</div>

		<!-- 네비게이션 -->
		<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		<div class="swiper-button-prev"></div><!-- 이전 버튼 -->

		<!-- 페이징 -->
		<div class="swiper-pagination"></div>
	</div>
    
    <div style="margin-top:10px;" align="center">이탈리아</div>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='14'/>
					   </c:url>"><img src="<c:url value='/images/colosseum.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='16'/>
					   </c:url>"><img src="<c:url value='/images/firenze.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='15'/>
					   </c:url>"><img src="<c:url value='/images/southernItaly.jpg'/> "></a></div>
		</div>
		<!-- 네비게이션 -->
		<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		<div class="swiper-button-prev"></div><!-- 이전 버튼 -->

		<!-- 페이징 -->
		<div class="swiper-pagination"></div>
	</div>
	
	<div style=" margin-top:10px;" align="center">미국</div>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='13'/>
					   </c:url>"><img src="<c:url value='/images/newYork.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='11'/>
					   </c:url>"><img src="<c:url value='/images/westUsa.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='12'/>
					   </c:url>"><img src="<c:url value='/images/hawai.jpg'/> "></a></div>
		</div>

		<!-- 네비게이션 -->
		<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		<div class="swiper-button-prev"></div><!-- 이전 버튼 -->

		<!-- 페이징 -->
		<div class="swiper-pagination"></div>
	</div>
	
<script>
new Swiper('.swiper-container', {

	slidesPerView : 3, // 동시에 보여줄 슬라이드 갯수
	spaceBetween : 30, // 슬라이드간 간격
	slidesPerGroup : 3, // 그룹으로 묶을 수, slidesPerView 와 같은 값을 지정하는게 좋음

	// 그룹수가 맞지 않을 경우 빈칸으로 메우기
	// 3개가 나와야 되는데 1개만 있다면 2개는 빈칸으로 채워서 3개를 만듬
	loopFillGroupWithBlank : true,

	loop : true, // 무한 반복

	pagination : { // 페이징
		el : '.swiper-pagination',
		clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
	},
	navigation : { // 네비게이션
		nextEl : '.swiper-button-next', // 다음 버튼 클래스명
		prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
	},	
});
</script>
	
</body>
</html>