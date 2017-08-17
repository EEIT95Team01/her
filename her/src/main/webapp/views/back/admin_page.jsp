<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	<title>her - ADMIN</title>
	<c:import url='/views/common/_resources.jsp' />

	<script src='${pageContext.request.contextPath}/js/admin_page/admin_page.js' type='text/babel'></script>
	<script src='${pageContext.request.contextPath}/js/admin_page/admin_page_action.js' type='text/babel'></script>
	<script src='${pageContext.request.contextPath}/js/admin_page/admin_page_slider.js' type='text/babel'></script>
	<script src='${pageContext.request.contextPath}/js/admin_page/admin_page_autocomplete.js' type='text/babel'></script>

</head>
<body class='bgc_black'>
	<div class='all chi_16_40 flex_block'>
		<!--_____________ _admin_header _____________-->
		<c:import url='/views/back/_admin_header.jsp' />

		<div class='block flex_block'>
			<div class='block40'>
				<div class='rec_text_40'>管理員介面｜ADMIN</div>
			</div>

			<!--_____________ _admin_navbar _____________-->
			<div id='Admin_nav_bar'>
				<c:import url='/views/back/_admin_navbar.jsp' />
			</div>

			<!--_____________ Main box _____________-->
			<div id='Admin_main_box' class='box820 flex_block'>
				<c:import url='/views/back/admin_page/tag.jsp'></c:import>
				<c:import url='/views/back/admin_page/card.jsp'></c:import>
				<c:import url='/views/back/admin_page/writer.jsp'></c:import>
				<c:import url='/views/back/admin_page/font.jsp'></c:import>
				<c:import url='/views/back/admin_page/gift.jsp'></c:import>
				<c:import url='/views/back/admin_page/ad.jsp'></c:import>
				<c:import url='/views/back/admin_page/member.jsp'></c:import>
				<c:import url='/views/back/admin_page/pack.jsp'></c:import>
				<c:import url='/views/back/admin_page/orderform.jsp'></c:import>
				<c:import url='/views/back/admin_page/display.jsp'></c:import>
			</div>
		</div>
	</div>
</body>
</html>
