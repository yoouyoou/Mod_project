<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<script>
function scheduleCreate(){
	if (form.scheId.value == "") {
		alert("일정 번호를 입력하십시오.");
		form.scheId.focus();
		return false;
	} 
	if (form.scheName.value == "") {
		alert("일정명을 입력하십시오.");
		form.scheName.focus();
		return false;
	}
	if (form.scheLocation.value == "") {
		alert("위치를 입력하십시오.");
		form.scheLocation.focus();
		return false;
	}
	if (form.scheDescription.value == "") {
		alert("상세설명을 입력하십시오.");
		form.scheDescription.focus();
		return false;
	}
	var dateExp = /^\d{4}-\d{2}-\d{2}$/;
	if(dateExp.test(form.scheTime.value)==false) {
		alert("날짜 형식이 올바르지 않습니다.");
		form.scheTime.focus();
		return false;
	}
	form.submit();
}
</script>
<title>상품 관리</title>
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
				<li><a href="<c:url value='/user/logout'></c:url>">로그아웃( ${curUserId}님  )</a></li>
			<%} %>
			<li><a href="<c:url value='/user/register/form'></c:url>">회원가입</a></li>
		</ul>
	</nav>
	<hr>
	
<!-- 상품 schedule 확인 -->
<h1 align="center"> 세부일정 조회 </h1>
	<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">일정번호</th>
			<th> <font size="2px">일정명</th>
			<th> <font size="2px">시간</th>
			<th> <font size="2px">위치</th>
			<th> <font size="2px">상세설명</th>
		</tr> 
		
		<c:forEach var="check" items="${checkItemList}">
		<tr>
			<td align ="center"><font size="2px"> ${check.scheId}</td>
			<td align ="center"><font size="2px"> ${check.name}</td>
			<td align ="center"><font size="2px"> ${check.time}</td>
			<td align ="center"><font size="2px"> ${check.location}</td>
			<td align ="center"><font size="2px"> ${check.description}</td>
		</tr>
		</c:forEach>
	</table>
	
<!-- register ScheduleForm -->
<br><br><br>
<hr color = "skyblue"><br><br><br> 
<form name="form" method ="POST" action="<c:url value='/guide/addschedule'> <c:param name='clickId' value='${clickId}'/> </c:url>" >
<h1 align="center"> 새로운 일정 추가</h1>
	<table align="center">
		<tr>
			<td align = "center"> <font size="2px">일정 번호</td>
			<td> <input type="text" style="width: 300" name="scheId"> </td>
		</tr>
		<tr>
			<td align = "center"> <font size="2px">일정명</td>
			<td> <input type="text" style="width: 300" name="scheName"> </td>
		</tr>
		<tr>
			<td align = "center"> <font size="2px">시간</td>
			<td> <input type="text" style="width: 300" name="scheTime" placeholder="전체년도 - 월 - 일"> </td>
		</tr>
		<tr>
			<td align = "center"> <font size="2px">위치</td>
			<td> <input type="text" style="width: 300" name="scheLocation"> </td>
		</tr>
		<tr>
			<td align = "center"> <font size="2px">상세설명</td>
			<td> <input type="text" style="width: 300" name="scheDescription"> </td>
		</tr>
	</table>
	    <br>
	    
	<table align="center">
		<tr>
			<td>
			<input type="button" value="일정 추가" onClick="scheduleCreate()"> &nbsp;
			</td>
		</tr>
	</table>
</form>
	

</body>
</html>