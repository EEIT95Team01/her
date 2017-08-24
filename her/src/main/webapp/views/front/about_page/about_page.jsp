<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<title>her - ABOUT</title>
	

	<c:import url='/views/common/_resources.jsp' />
	<script src="${pageContext.request.contextPath}/js/member_page/loginOrNot.js" type="text/javascript"></script>
	<script src='${pageContext.request.contextPath}/js/category_page.js' type='text/javascript'></script>
	<script src='${pageContext.request.contextPath}/js/front_page_action.js' type='text/javascript'></script>
<!--  -->

	<script src='${pageContext.request.contextPath}/js/admin_page/admin_page.js' type='text/babel'></script>
	<script src='${pageContext.request.contextPath}/js/admin_page/admin_page_action.js' type='text/babel'></script>
	<script src='${pageContext.request.contextPath}/js/admin_page/admin_page_slider.js' type='text/babel'></script>
	<script src='${pageContext.request.contextPath}/js/admin_page/admin_page_autocomplete.js' type='text/babel'></script>


<!--  -->

<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
	

</head>
<body id='font'>
	<div class='all chi_16_40 flex_block'>
		<!--_____________ _header _____________-->
		<c:import url='/views/common/_header.jsp' />
<!--=======================================================  -->	
	
			<div class='block flex_block'>
			<div class='block40'>
				<div class='rec_text_40'>小組介紹｜Introduction </div>
			</div>

			<!--_____________ _admin_navbar _____________-->
			<div id='Admin_nav_bar'>
				<c:import url='/views/front/about_page/_about_navbar.jsp' />
			</div>

			<!--_____________ Main box _____________-->
			<div id='Admin_main_box' class='box820 flex_block'>
<!--關於我們-->		<c:import url='/views/front/about_page/intro.jsp'></c:import>
<!--網站介紹-->		<c:import url='/views/front/about_page/from.jsp'></c:import>
<!--成員介紹-->		<c:import url='/views/front/about_page/member_intro.jsp'></c:import>
<!--技術操作-->		<c:import url='/views/front/about_page/technique.jsp'></c:import>
<!--始●起程-->		<c:import url='/views/front/about_page/begin.jsp'></c:import>
<!--續●感謝-->		<c:import url='/views/front/about_page/special_thanks.jsp'></c:import>
<!--終●再會-->		<c:import url='/views/front/about_page/bye.jsp'></c:import>
			</div>
		</div>
		
	</div>
	
</body>
</html>
