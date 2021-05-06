<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "model.SafeGrade" %>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<meta charset="EUC-KR">
<title>국가별 안전등급</title>
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
				<li><a href="<c:url value='/user/logout'></c:url>">로그아웃( ${curUserId} 님)</a></li>
			<%} %>
			<li><a href="<c:url value='/user/register/form'></c:url>">회원가입</a></li>
		</ul>
	</nav>
	<hr>
	
	<!-- 국가 안전 등급 전체 리스트 -->
	<h1 align="center">국가별 안전등급 정보</h1>
		<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">국가</th>
			<th> <font size="2px">전염병</th>
			<th> <font size="2px">자연재해</th>
			<th> <font size="2px">테러</th>
			<th> <font size="2px">전쟁</th>
		</tr> 
		<c:forEach var="safeGrade" items="${safeGradeList}">
		<tr>
			<td align ="center"><font size="2px"> ${safeGrade.nation}</td>
			<td align ="center"><font size="2px"> ${safeGrade.disease}</td>
			<td align ="center"><font size="2px"> ${safeGrade.naturalAccident}</td>
			<td align ="center"><font size="2px"> ${safeGrade.terror}</td>
			<td align ="center"><font size="2px"> ${safeGrade.war}</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>