<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<title>로그인창</title>
<script>
function login() {
	if (form.userId.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.submit();
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
	
	<form name="form" method="POST" action="<c:url value='/user/login' /> ">
	<!-- UserMan 예제 부분 -->
	    <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${loginFailed}">
	  	  <br><font color="red"><c:out value="${exception.getMessage()}" /></font><br>
	    </c:if>
	    <br><br>
	    <h1 align="center">로그인</h1>
	    <table align="center">
	  	  	<tr>
	  	  		<td><font size="2">아이디</td>
				<td> <input type="text" width="300" name="userId"> </td>
		  	</tr> <br>
	  	  	<tr>
	  	  		<td><font size="2">비밀번호</td>
				<td><input type="password" width="300" name="password"> </td>
		  	</tr>
	    </table>
	     <p align="center"> <input type="button" value="로그인" onClick="login()"> &nbsp; </td>
	    <br>	  	
  <!-- 예제 부분 경계선 -->
	</form>
	
</body>
</html>