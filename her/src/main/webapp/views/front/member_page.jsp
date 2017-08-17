<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>her - MEMBER</title>
	<c:import url='/views/common/_resources.jsp' />

	<script src='${pageContext.request.contextPath}/js/member_page/member_page.js' type='text/babel'></script>
</head>
<body>
	<div class='all chi_16_40 flex_block'>
		<!--_____________ _header _____________-->
		<c:import url='/views/common/_header.jsp' />


		<div class='block flex_block'>
			<div class='block40'>
				<div class='rec_text_40'>會員｜MEMBER</div>
			</div>

			<!--_____________ _member_navbar _____________-->
			<div id='Member_nav_bar'>
				<c:import url='/views/front/_member_navbar.jsp' />
			</div>

			<!--_____________ Main box _____________-->
			<div id='Member_main_box' class='box820 flex_block'>

			</div>
		</div>
	</div>
</body>
</html>
