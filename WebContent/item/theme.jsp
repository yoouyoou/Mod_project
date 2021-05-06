<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="model.member" %>
<%@page import="model.item" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String curUserId = (String)request.getAttribute("curUserId");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width-device-width", initial-scale="1">

<!-- �ܺ� swiper link -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>

<!-- ���� style link -->
<link rel=stylesheet href="<c:url value='/css/main.css' />" type="text/css">
<link rel=stylesheet href="<c:url value='/css/category.css' />" type="text/css">
<link rel=stylesheet href="<c:url value='/css/swiper.css' />" type="text/css">

<title>�׸��� ��ǰ</title>
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
	
	<!-- ��ǰ ���� ���� -->
	<nav class="category_menu">
        <ul>
            <li><a href="<c:url value='/item/country/form'></c:url>">����</a></li>  
            <li><a href="<c:url value='/item/season/form'></c:url>">�ñ�</a></li>
            <li style="text-decoration:underline;"><a href="<c:url value='/item/theme/form'></c:url>">�׸�</a></li>
            <li><a href="<c:url value='/item/price/form'></c:url>">����</a></li>
        </ul>
    </nav>
    
	<!--swiper -->
	<div style= "margin-top:10px;" align="center">���� ����</div>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='1'/>
					   </c:url>"><img src="<c:url value='/images/jejuSpring.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='2'/>
					   </c:url>"><img src="<c:url value='/images/busan.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='4'/>
					   </c:url>"><img src="<c:url value='/images/gyeongju.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='5'/>
					   </c:url>"><img src="<c:url value='/images/winterJeju.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='3'/>
					   </c:url>"><img src="<c:url value='/images/jinhea.jpg'/> "></a></div>
		</div>

		<!-- �׺���̼� -->
		<div class="swiper-button-next"></div><!-- ���� ��ư (�����ʿ� �ִ� ��ư) -->
		<div class="swiper-button-prev"></div><!-- ���� ��ư -->

		<!-- ����¡ -->
		<div class="swiper-pagination"></div>
	</div>
	
	<div style=" margin-top:10px;" align="center">���� ����</div>
	<div class="swiper-container">
		<div class="swiper-wrapper">
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='8'/>
					   </c:url>"><img src="<c:url value='/images/danang.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='10'/>
					   </c:url>"><img src="<c:url value='/images/kotakinabalu.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='12'/>
					   </c:url>"><img src="<c:url value='/images/hawai.jpg'/> "></a></div>
			<div class="swiper-slide"><a href="<c:url value='/item/view'>
					   <c:param name='viewId' value='15'/>
					   </c:url>"><img src="<c:url value='/images/southernItaly.jpg'/> "></a></div>
		</div>

		<!-- �׺���̼� -->
		<div class="swiper-button-next"></div><!-- ���� ��ư (�����ʿ� �ִ� ��ư) -->
		<div class="swiper-button-prev"></div><!-- ���� ��ư -->

		<!-- ����¡ -->
		<div class="swiper-pagination"></div>
	</div>
	
	<script>
	new Swiper('.swiper-container', {

		slidesPerView : 3, // ���ÿ� ������ �����̵� ����
		spaceBetween : 30, // �����̵尣 ����
		slidesPerGroup : 3, // �׷����� ���� ��, slidesPerView �� ���� ���� �����ϴ°� ����

		// �׷���� ���� ���� ��� ��ĭ���� �޿��
		// 3���� ���;� �Ǵµ� 1���� �ִٸ� 2���� ��ĭ���� ä���� 3���� ����
		loopFillGroupWithBlank : true,

		loop : true, // ���� �ݺ�

		pagination : { // ����¡
			el : '.swiper-pagination',
			clickable : true, // ����¡�� Ŭ���ϸ� �ش� �������� �̵�, �ʿ�� ������ ��� ��� �۵�
		},
		navigation : { // �׺���̼�
			nextEl : '.swiper-button-next', // ���� ��ư Ŭ������
			prevEl : '.swiper-button-prev', // �̹� ��ư Ŭ������
		},	
	});
	</script>

</body>
</html>