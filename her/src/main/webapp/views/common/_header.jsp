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
			<a href='${pageContext.request.contextPath}/views/front/home_page.jsp'>
				<span class='chi_20 bgc_white'>HOME</span>
			</a>
			<a href='${pageContext.request.contextPath}/views/front/card_page.jsp'>
				<span class='bgc_white'>CARD</span>
			</a>
			<a href='${pageContext.request.contextPath}/views/front/font_page.jsp'>
				<span class='bgc_white'>FONT</span>
			</a>
			<a href='${pageContext.request.contextPath}/views/front/gift_page.jsp'>
				<span class='bgc_white'>GIFT</span>
			</a>
			<a href='${pageContext.request.contextPath}/views/front/about_page/about_page.jsp'>
				<span class='bgc_white'>ABOUT</span>
			</a>
		</div>
		<div class='box200 flex_right'>
				<a href='${pageContext.request.contextPath}/views/front/member_page/login.jsp'>
					<span
						id='Login'
						class='bgc_white'>登入 </span>
				</a>
					<button
						id='Logout'
						class='bgc_white chi_16_40'
						style='display:none'>登出</button>
		</div>
		<div class='box200 flex_center'>
			<button 
			   id = "mailbox"
			   class='flex_center chi_16_40 bgc_white'
			   onclick = "findMemberId('pack')">
				<span class='bgc_white'>郵寄箱</span>
				<img src='${pageContext.request.contextPath}/images/_for_views/_header/icon_mailbox.png'
					 width='40'
					 height='40'/>
			</button>
		</div>
	</div>
</div>
<div class='block20'></div>
