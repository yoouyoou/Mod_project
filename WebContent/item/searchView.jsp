<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "model.SafeGrade" %>
<% 
	String curUserId = (String)request.getAttribute("curUserId"); 
%>

<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<meta charset="EUC-KR">
<title>상품 검색</title>
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
	
	<!-- 특정상품 검색 -->
	<h1 align="center"> ${searchString} (이)가 들어간 상품들</h1>
	<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">상품명</th>
			<th> <font size="2px">가격</th>
			<th> <font size="2px">출발일</th>
			<th> <font size="2px">도착일</th>
			<th> <font size="2px">카테고리</th>
		</tr> 
		<c:forEach var="si" items="${searchList}">
		<tr>
			<td align ="center"><font size="2px"> ${si.name} </td>
			<td align ="center"><font size="2px"> ${si.price}</td>
			<td align ="center"><font size="2px"> ${si.departTime}</td>
			<td align ="center"><font size="2px"> ${si.arrTime}</td>
			<td align ="center"><font size="2px"> ${si.category}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>