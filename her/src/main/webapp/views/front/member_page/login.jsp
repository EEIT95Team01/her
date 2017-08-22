<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>her - LOG IN</title>
	<c:import url='/views/common/_resources.jsp' />
	
	<script src="${pageContext.request.contextPath}/js/member_page/loginOrNot.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/front_page_action.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/member_page/loginAndSignin.js" type="text/javascript"></script>
	
</head>
<body style='width:100%; height:100vh' class='flex_center'>
	<div class='rec_login340 chi_16_40'>
		<div class='block40 flex_spacebetween'>
			<div class='rec_text40'>會員登入</div>
			
			<div class='rec40'>
				<button
					id='Member_forget_button'
					type='button'
					class='button_roundcorner chi_16_30 bgc_gray'>忘記密碼</button>	
				</div>
				<div class='rec40'>
				<button
					id='Member_login_button'
					type='button'
					class='button_roundcorner chi_16_30 bgc_pink'>登入</button>
			</div>
		</div>
		<div class='block20'></div>
		<div class='block40 flex_left'>
			<label for='Email'
				   class='rec_lable'>信箱</label>
			<input
				id='Email'
				name='email'
				class='rec_input163 border chi_16_30' />
				</div>
				<div class='block40 flex_left'>
			<label for='Password'
				   class='rec_lable'>密碼</label>
			<input
				id='Password'
				name='password'
				type='password'
				class='rec_input163 border chi_16_30' />
		</div>
		<div class='block40'></div>
		<div class='block40 flex_right'>
			<div class='rec_text40'>還不是會員嗎？</div>
			<div class='rec40 flex_center'>
				<button
					type='button'
					class='button_roundcorner bgc_green'>
					<a href='${pageContext.request.contextPath}/views/front/member_page/signin.jsp'><span class='chi_16_30 bgc_green'>註冊</span></a></button>
			</div>
		</div>
	</div>
</body>
</html>