<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="model.item" %>
<%@page import="java.util.ArrayList" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<title>예약자 확인</title>
</head>
<body>
	<nav class="modbar">
		<div class="mod_name">
			<h1><a href="<c:url value='/user/main'></c:url>">Mod's Tour</a></h1>
		</div>

		<ul class="mod_menu">
			<!-- 회원용 상단바 -->
			<% if(session.getAttribute("divGuide") == null){ %>
				<li><a href="<c:url value='/user/safeGrade'></c:url>">안전등급</a></li></li>
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
	
	<!-- 고객의 여행상품 조회 -->
	<h1 align="center">내가 맡은 상품 조회</h1>
	<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">여행 상품 ID</th>
			<th> <font size="2px">여행 상품명</th>
			<th> <font size="2px">가격</th>
			<th> <font size="2px">출발일</th>
			<th> <font size="2px">도착일</th>
			<th> <font size="2px">카테고리</th>
		</tr> 
		  
		<c:forEach var="item" items="${itemList}">
		<tr>
			<td align ="center"><font size="2px"> ${item.itemId} </td>
			<td align ="center"><font size="2px"> 
				<a href = "<c:url value='/guide/checkschedule'>
					<c:param name='clickName' value='${item.name}'/>
					<c:param name='clickId' value='${item.itemId}'/> </c:url>">
				${item.name}</a>
			</td>
			<td align ="center"><font size="2px"> ${item.price}</td>
			<td align ="center"><font size="2px"> ${item.departTime}</td>
			<td align ="center"><font size="2px"> ${item.arrTime}</td>
			<td align ="center"><font size="2px"> ${item.category}</td>
		</tr>
		</c:forEach>
	</table>	
	
</body>
</html>