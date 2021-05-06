<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String curUserId = (String)request.getAttribute("curUserId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<script>
function itemCreate() {
	if (form.name.value == "") {
		alert("상품의 제목을 입력하십시오.");
		form.name.focus();
		return false;
	}
	if (form.price.value == "") {
		alert("가격을 입력하십시오.");
		form.price.focus();
		return false;
	}
	var dateExp = /^\d{4}-\d{2}-\d{2}$/;
	if(dateExp.test(form.departTime.value)==false) {
		alert("출발일 형식이 올바르지 않습니다.");
		form.departTime.focus();
		return false;
	}
	if(dateExp.test(form.arrTime.value)==false) {
		alert("출발일 형식이 올바르지 않습니다.");
		form.arrTime.focus();
		return false;
	}
	form.submit();
}

</script>

<title>상품 추가</title>
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

<!-- register ItemForm -->
<form name="form" method ="POST" action="<c:url value='/guide/addreservation' />" >
	<h1 align="center">새로운 여행상품 등록</h1>
	
	<table align="center">
	  	  <!--<tr>
			<td align = "center"> <font size="2px">상품 ID</td>
			<td> <input type="text" style="width: 300" name="id"> </td>
		  </tr>-->
		  
	  	  <tr>
			<td align = "center"> <font size="2px">상품명</td>
			<td> <input type="text" style="width: 300" name="name"> </td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">가격</td>
			<td> <input type="text" style="width: 300" name="price"> </td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">출발일</td>
			<td width="250"> <input type="text" style="width: 300" name="departTime" placeholder="전체년도 - 월 - 일"></td>
		  </tr>
		  
		  <tr>
			<td align = "center"> <font size="2px">도착일</td>
			<td> <input type="text" style="width: 300" name="arrTime" placeholder="전체년도 - 월 - 일"> </td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">여행 종류</td>
			<td> 
				<input type="radio" style="width: 300" name="category" value="힐링"/><font size="2px">힐링</font>
				<input type="radio" style="width: 300" name="category" value="가족"/><font size="2px">가족</font>
				<input type="radio" style="width: 300" name="category" value="우정"/><font size="2px">우정</font>
				<input type="radio" style="width: 300" name="category" value="사랑"/><font size="2px">사랑</font>
			</td>
		  </tr>
	    </table>
	    <br>
	    
	    <table align="center">
		  <tr>
			<td>
			<input type="button" value="상품등록" onClick="itemCreate()"> &nbsp;
			</td>
		  </tr>
	    </table>
	</form>
</body>
</html>