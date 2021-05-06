<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "model.item" %>
<%
	String curUserId = (String)request.getAttribute("curUserId");
	item viewItem = (item)request.getAttribute("viewItem");
%>
<!DOCTYPE html>
<html>
<head>
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<meta charset="EUC-KR">
<title>여행상품 상세페이지</title>
<script>
function itemReservation() {
	return confirm("정말 예약하시겠습니까? ");
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
				<li><a href="<c:url value='/user/logout'></c:url>">로그아웃(<%= curUserId %>님)</a></li>
			<%} %>
			<li><a href="<c:url value='/user/register/form'></c:url>">회원가입</a></li>
		</ul>
	</nav>
	<hr>
	
	<!-- 여행 정보 -->
	<h1 align="center">상품 상세정보</h1>
	<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">상품명</th>
			<th> <font size="2px">가격</th>
			<th> <font size="2px">출발일</th>
			<th> <font size="2px">도착일</th>
			<th> <font size="2px">카테고리</th>
		</tr> 
		<tr>
			<td align ="center"><font size="2px"> ${viewItem.name} </td>
			<td align ="center"><font size="2px"> ${viewItem.price}</td>
			<td align ="center"><font size="2px"> ${viewItem.departTime}</td>
			<td align ="center"><font size="2px"> ${viewItem.arrTime}</td>
			<td align ="center"><font size="2px"> ${viewItem.category}</td>
		</tr>
	</table>
	
	<!-- 세부 정보 -->
	<br><br><br><br>
	<h1 align="center">세부 일정표</h1>
	<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">일정번호</th>
			<th> <font size="2px">일정명</th>
			<th> <font size="2px">시간</th>
			<th> <font size="2px">위치</th>
			<th> <font size="2px">상세설명</th>
		</tr> 
		
		<c:forEach var="sche" items="${scheList}">
		<tr>
			<td align ="center"><font size="2px"> ${sche.scheId}</td>
			<td align ="center"><font size="2px"> ${sche.name}</td>
			<td align ="center"><font size="2px"> ${sche.time}</td>
			<td align ="center"><font size="2px"> ${sche.location}</td>
			<td align ="center"><font size="2px"> ${sche.description}</td>
		</tr>
		</c:forEach>
	</table>
	
	<br><br><br>
	<p align="center">
	<a href="<c:url value='/item/reservation'>
	<c:param name='itemReservation' value='${viewItem.itemId}'/></c:url>"
	 onclick="itemReservation();"><font size="2">예약하기</font></a> &nbsp;
	 </p>
	
</body>
</html>