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
<title>�����ǰ ��������</title>
<script>
function itemReservation() {
	return confirm("���� �����Ͻðڽ��ϱ�? ");
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
	
	<!-- ���� ���� -->
	<h1 align="center">��ǰ ������</h1>
	<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">��ǰ��</th>
			<th> <font size="2px">����</th>
			<th> <font size="2px">�����</th>
			<th> <font size="2px">������</th>
			<th> <font size="2px">ī�װ�</th>
		</tr> 
		<tr>
			<td align ="center"><font size="2px"> ${viewItem.name} </td>
			<td align ="center"><font size="2px"> ${viewItem.price}</td>
			<td align ="center"><font size="2px"> ${viewItem.departTime}</td>
			<td align ="center"><font size="2px"> ${viewItem.arrTime}</td>
			<td align ="center"><font size="2px"> ${viewItem.category}</td>
		</tr>
	</table>
	
	<!-- ���� ���� -->
	<br><br><br><br>
	<h1 align="center">���� ����ǥ</h1>
	<table align="center" width="500" height="40" style="border:1px solid" style="border-collapse:collapse" >
		<tr>
			<th> <font size="2px">������ȣ</th>
			<th> <font size="2px">������</th>
			<th> <font size="2px">�ð�</th>
			<th> <font size="2px">��ġ</th>
			<th> <font size="2px">�󼼼���</th>
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
	 onclick="itemReservation();"><font size="2">�����ϱ�</font></a> &nbsp;
	 </p>
	
</body>
</html>