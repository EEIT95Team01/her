<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>her - SIGN IN</title>
	<c:import url='/views/common/_resources.jsp' />
	
	<script src="${pageContext.request.contextPath}/js/member_page/memberInsert.js" type="text/javascript" ></script>
	
</head>
<body style='width:100%; height:100vh' class='flex_center'>
	<div class='rec_login340 chi_16_40'>
		<div class='block40 flex_spacebetween'>
			<div class='rec_text40'>會員註冊</div>
			<div class='rec40 flex_center'>
				<button
					id='Member_join_button'
					type='button'
					class='button_roundcorner chi_16_30 bgc_pink'>註冊</button>
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
		</div><div class='block40 flex_left'>
			<label for='Confirm'
				   class='rec_lable'>確認密碼</label>
			<input
				id='Confirm'
				name='confirm'
				type='password'
				class='rec_input163 border chi_16_30' />
		</div>
		<div class='block40'></div>
	</div>
</body>
</html>