<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="model.member" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String curUserId = (String)request.getAttribute("curUserId");
	member member = (member)request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<title>마이페이지</title>
<script>
function userDelete(targetUri) {
	userRemove();
	form.action = targetUri;
	form.submit();
}

function userRemove(){
	return confirm("정말 삭제하시겠습니까?");
}

function userModify() {
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
	
	<h1 align="center">마이 페이지</h1>
	<!-- myPage 입력폼 -->
	<form name="form" method="POST" action="<c:url value='/user/update' />">
	    <table align="center">
	      <tr>
			<td align = "center"> <font size="2px">ID</td>
			<td> <font size="2px"><%= member.getUserId() %></font> </td>
		  </tr>
		  
		  <tr>
			<td align = "center"> <font size="2px">비밀번호</td>
			<td> <input type="password" style="width: 300" name="password" value="<%= member.getPassword() %>"> </td>
		  </tr>
		  
		  <tr>
			<td align = "center"> <font size="2px">비밀번호 확인</td>
			<td> <input type="password" style="width: 300" name="password2" value="<%= member.getPassword() %>"> </td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">이름</td>
			<td> <input type="text" style="width: 300" name="name" value="<%= member.getName() %>"> </td>
		  </tr>
		  
	  	  <tr>
			<td align = "center"> <font size="2px">이메일</td>
			<td> <input type="text" style="width: 300" name="email" value="<%= member.getEmail() %>"> </td>
		  </tr>	
		  
	  	  <tr>
			<td align = "center"> <font size="2px">전화번호</td>
			<td> <input type="text" style="width: 300" name="phone" value="<%= member.getTel() %>"> </td>
		  </tr>
		  
		  <tr>
			<td align = "center"> <font size="2px">생년월일</td>
			<td> <input type="text" style="width: 300" name="birth" value="<%= member.getBirth() %>"> </td>
		  </tr>
		  
		  <tr>
		  	<td align = "center"> <font size="2px">여권번호</td>
		  	<td><input type="text" style= "width: 300" name="passport" value="<%= member.getPassport() %>"> </td>
		  </tr>
		  </table>
		  <table align="center">
		  <tr>
		  	<td> 
		  		<input type="button" value="수정" onClick="userModify()"> &nbsp;
		  		<input type="button" value="삭제" onClick="userDelete('<c:url value='/user/delete'>
					   <c:param name='userId' value='<%=member.getUserId()%>'/>
						 	 </c:url>')">
				<!--
		  		<a href="<c:url value='/user/delete'>
				   <c:param name='userId' value='<%=member.getUserId()%>'/>
			 	 </c:url>" onclick="return userRemove();"><font size="2px">삭제</a>&nbsp; 
			 	 -->
		  	</td>
		  </tr>
	    </table>
	    <br>
	    </form>

</body>
</html>