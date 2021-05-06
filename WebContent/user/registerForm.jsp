<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String curUserId = (String)request.getAttribute("curUserId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<script>
function userCreate(targetUri) {
	form.action = targetUri;
	form.submit();
}

function userCreate() {
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
	if (form.password.value != form.password2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		form.name.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("이름을 입력하십시오.");
		form.name.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("이메일 형식이 올바르지 않습니다.");
		form.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if(phoneExp.test(form.phone.value)==false) {
		alert("전화번호 형식이 올바르지 않습니다.");
		form.phone.focus();
		return false;
	}
	form.submit();
}
</script>
<title>회원가입 창</title>
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
	
<!-- registration form  -->
<form name="form" method="POST" action="<c:url value='/user/register' />">
	<h1 align="center">회원가입</h1>
		 
	    <!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->
        <c:if test="${registerFailed}">
	      <font color="red"><c:out value="${exception.getMessage()}" /></font>
	    </c:if>
	    <br>	  
	    
	    <table align="center">
	  	  <tr>
			<td align = "center"> <font size="2px">사용할 ID</td>
			<td> <input type="text" style="width: 300" name="userId"> </td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">비밀번호</td>
			<td> <input type="password" style="width: 300" name="password"> </td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">비밀번호 확인</td>
			<td> <input type="password" style="width: 300" name="password2"> </td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">이름</td>
			<td width="250">
				<input type="text" style="width: 300" name="name" 
				 	<c:if test="${registerFailed}">value="${member.name}"</c:if>>
			</td>
		  </tr>
		  
		  <tr>
			<td align = "center"> <font size="2px">이메일</td>
			<td>
				<input type="text" style="width: 300" name="email" 
					<c:if test="${registerFailed}">value="${member.email}"</c:if>>
			</td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">전화번호</td>
			<td>
				<input type="text" style="width: 300" name="phone" 
					<c:if test="${registerFailed}">value="${member.phone}"</c:if>>
			</td>
		  </tr>
		  
		  <tr>
			<td align = "center"> <font size="2px">생년월일</td>
			<td> <input type="text" style="width: 300" name="birth"> </td>
		  </tr>
		  
		  <tr>
			<td align = "center"> <font size="2px">여권 번호</td>
			<td> <input type="text" style="width: 300" name="passport"
				<c:if test="${registerFailed}">value="${user.passport}"</c:if>>
		  </tr>
		  	  
	    </table>
	    <br>
	    
	    <table align="center">
		  <tr>
			<td>
			<input type="button" value="회원 가입" onClick="userCreate()"> &nbsp;
			</td>
		  </tr>
	    </table>
</form>
</body>
</html>