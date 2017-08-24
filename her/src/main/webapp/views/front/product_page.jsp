<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>her - PRODUCT</title>
	<c:import url='/views/common/_resources.jsp' />
	
	<script src="${pageContext.request.contextPath}/js/member_page/loginOrNot.js" type="text/javascript"></script>
	<script src='${pageContext.request.contextPath}/js/front_page_action.js' type='text/javascript'></script>
	<script src='${pageContext.request.contextPath}/js/product_page.js' type='text/javascript'></script>
	
</head>
<body>
	<div class='all chi_16_40 flex_block'>
		<!--_____________ _header _____________-->
		<c:import url='/views/common/_header.jsp' />

		<!--_____________ _package_basket _____________-->
		<c:import url='/views/common/_package_basket.jsp' />

		<div class='block40'>
			<div class='rec_text_40'>商品｜PRODUCT</div>
		</div>
		<div class='block320 flex_block'>
			<div class='square320'>
				<img id = "cover"
				width='320'
				height='320'/>
			</div>
			<div class='box720'>
				<div class='block40 flex_left'>
					<img 
						src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_tag.png'
						width='40'
						height='40' />
					<div class='box680 nowrap' id= "taghere">
					</div>
				</div>
				<div class='block20'></div>
				<div class='block60' id="mw">
					<div class='rec_text_60 chi_24'><span id="pName" ></span></div>
				</div>
				<div class='block60 flex_right' >
					<div class='rec_text_60 chi_24'>$ <span id="price" ></span></div>
				</div>
				<div class='block20'></div>
				<div class='block60 flex_spacebetween'>
					<button class='box220 chi_24 bgc_pink'>加入收藏</button>
					<button class='box220 chi_24 bgc_green' id= "addBasket">加入包裹組合籃</button>
					<div class='box220 flex_spacebetween'>
					
						<img
							src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_facebook.png'
							width='40'
							height='40'
							class='cursor' />
						<img
							src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_googleplus.png'
							width='40'
							height='40'
							class='cursor' />
						<img
							src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_instagram.png'
							width='40'
							height='40'
							class='cursor' />
						<img
							src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_plurk.png'
							width='40'
							height='40'
							class='cursor' />
						<img
							src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_twitter.png'
							width='40'
							height='40'
							class='cursor' />
						
					</div>
				</div>
				<div class='block20'></div>
				<div class='block40 flex_spacearound'>
					<div class='box220 flex_center'>
						<img
							src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_viewcount.png'
							width='40'
							height='40' />
						<div class='sub_rec40'>瀏覽 <span id='vc'></span>次</div>
					</div>
					<!--  
					<div class='box220 flex_center'>
						<img
							src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_collection.png'
							width='40'
							height='40' />
						<div class='sub_rec40'>1,234 人收藏</div>
					</div> -->
					<div class='box220 flex_center'>
						<img
							src='${pageContext.request.contextPath}/images/_for_views/product_page/icon_salescount.png'
							width='40'
							height='40' />
						<div class='sub_rec40'>銷售 <span id='sc'></span> 件</div>
					</div>
				</div>
			</div>
		</div>

		<div class='block20'></div>
		<div
			id='descriptionBox' 
			class='block flex_block chi_16_30'>
<!-- 			<div class='box640'> -->
<!-- 				<div class='rec_description640'>-<br />你不愛說浪漫的話，<br />卻給了我滿滿的安全感。<br /><br />（而我喜歡這樣的你！）</div> -->
<!-- 			</div> -->
<!-- 			<img src='' -->
<!-- 				 width='640'> -->
<!-- 			<div class='box640 '> -->
<!-- 				<div class='rec_description640'>-<br />謝謝你，好多好多！<br /><br />（最平凡的告白）</div> -->
<!-- 			</div> -->
<!-- 			<img src='' -->
<!-- 				 width='640'> -->
		

		</div>
	</div>
</body>
</html>

