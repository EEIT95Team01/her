<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>

<div class='block'>
	<div class='block20 flex_right'>
		<div class='box400 border_bottom flex_spacebetween chi_12'>
			<a href='#'>
				<span class='bgc_white'>購物說明</span>
			</a>
			<a href='#'>
				<span class='bgc_white'>聯絡我們</span>
			</a>
			<a href='#'>
				<span class='bgc_white'>忘記密碼</span>
			</a>
			<a href='#'>
				<span class='bgc_white'>Facebook</span>
			</a>
			<a href='#'>
				<span class='bgc_white'>Instagram</span>
			</a>
		</div>
	</div>
	<div class='block100 flex_block'>
		<div class='box160 flex_center'>
			<div id='Logo'></div>
		</div>
		<div class='box500 flex_spacebetween chi_20'>
			<a href='${pageContext.request.contextPath}/home_page.jsp'>
				<span class='chi_20 bgc_white'>HOME</span>
			</a>
			<a href='${pageContext.request.contextPath}/card_page.jsp'>
				<span class='bgc_white'>CARD</span>
			</a>
			<a href='${pageContext.request.contextPath}/font_page.jsp'>
				<span class='bgc_white'>FONT</span>
			</a>
			<a href='${pageContext.request.contextPath}/gift_page.jsp'>
				<span class='bgc_white'>GIFT</span>
			</a>
			<a href='#'>
				<span class='bgc_white'>ABOUT</span>
			</a>
		</div>
		<div class='box200 flex_right'>
			<c:if test="${empty sessionScope.user}">
				<a href='${pageContext.request.contextPath}/views/front/member_page/login.jsp'>
					<span
						id='Login'
						class='bgc_white'>登入</span>
				</a>
			</c:if>
			<c:if test="${!empty sessionScope.user}">
				<a href='${pageContext.request.contextPath}/views/front/home_page.jsp'>
					<span
						id='Logout'
						class='bgc_white'>登出</span>
				</a>
			</c:if>
		</div>
		<div class='box200 flex_center'>
			<a href='#'
			   class='flex_center'>
				<span class='bgc_white'>郵寄箱</span>
				<img src='${pageContext.request.contextPath}/images/_for_views/_header/icon_mailbox.png'
					 width='40'
					 height='40'/>
			</a>
		</div>
	</div>
</div>
<div class='block20'></div>
