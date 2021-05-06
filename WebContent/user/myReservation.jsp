<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="model.reservation" %>
<%@page import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String curUserId = (String)request.getAttribute("curUserId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<title>����Ȯ��</title>
<script>
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
			<!-- ȸ���� ��ܹ� -->
			<% if(session.getAttribute("divGuide") == null){ %>
				<li><a href="<c:url value='/user/safeGrade'></c:url>">�������</a></li>
				<li><a href="<c:url value='/user/mypage'></c:url>">����������</a></li>
				<li><a href="<c:url value='/user/myreservation'></c:url>">����Ȯ��</a></li>
				<li>Ŀ�´�Ƽ</li>
			<%} else{ %>  <!-- ���̵�� ��ܹ� -->
				<li><a href="<c:url value='/guide/addreservation/form'></c:url>">��ǰ�߰�</a></li>
				<li><a href="<c:url value='/guide/checkreservation'></c:url>">��ǰ��ȸ</a></li>
			<%} %>
		</ul>
		
		<ul class="mod_login">
			<% if(session.getAttribute("userId") == null){ %>
				<li><a href="<c:url value='/user/login/form'></c:url>">�α���</a></li>
			<%} else{ %>
				<li><a href="<c:url value='/user/logout'></c:url>">�α׾ƿ�(<%= curUserId %>��)</a></li>
			<%} %>
			<li><a href="<c:url value='/user/register/form'></c:url>">ȸ������</a></li>
		</ul>
	</nav>
	<hr>
	
	<!-- ����Ȯ�� ���̺� -->
	<h1 align="center"> ���� ����Ȯ��</h1>
	<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">�����ȣ</th>
			<th> <font size="2px">��ǰ��</th>
			<th> <font size="2px">�ݾ�</th>
			<th> <font size="2px">��������</th>
			<th> <font size="2px">�������</th>
		</tr> 

		<c:forEach var="res" items="${reservationList}">
		<tr>
			<td align ="center"><font size="2px"> ${res.resId} </td>
			<td align ="center"><font size="2px"> ${res.itemName}</td>
			<td align ="center"><font size="2px"> ${res.itemPrice}</td>
			<td align ="center"><font size="2px"> ${res.payStatus}</td>
			<td align ="center"><font size="2px"> ${res.resStatus}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>