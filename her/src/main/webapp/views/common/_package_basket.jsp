<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<div id='Package_Basket' class='block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>包裹組合籃｜PACKAGE BASKET</div>
		<div class='rec40 flex_center'>
			<div class='rec40'>將</div>
			<div class='rec40'>〈</div>
			<input name='packQuantity'
				   class='rec_digit chi_16_20 bgc_white'
				   value='1'
				   disabled />
			<div class='rec40'>〉</div>
			<div class='rec40'>個包裹</div>
			<button type='button' 
					class='button_roundcorner chi_16_30 bgc_pink'>加入郵寄箱</button>
		</div>
	</div>
	<div class='block320 flex_spacebetween'>
		<!--_____________ Basket card box _____________-->
		<div id='Basket_card_box' 
			 class='box220 bgc_card'>
			<div class='block220'>
<!-- cover empty -->
				<img src='${pageContext.request.contextPath}/images/_for_views/_package_basket/cover_card.png' 
					 width='220' 
					 height='220' />
<!-- cover
				<img src='#' 
					 width='220' 
					 height='220' />
				<button type='button' 
						class='button_circle bgi_remove_from_basket'></button>
-->
			</div>

<!-- name empty -->
			<div class='block60 flex_center bgc_white'>
				<a href='${pageContext.request.contextPath}/views/card'>
					<img src='${pageContext.request.contextPath}/images/_for_views/_package_basket/title_card.png' 
						 width='40' 
						 height='40' />
				</a>
<!-- name
			<div class='block60 flex_left bgc_white'>
				<div class='rec_text_60 chi_16_30'>一二三四五六七八九十一二三四五六七八</div>
-->
			</div>

<!-- price empty -->
			<div class='block40 flex_spacebetween'>
				<div class='rec_text_40 chi_20'>CARD</div>
<!-- price
				<div class='rec_text_40 chi_20'>$ 1,234</div>
-->
			</div>
		</div>
		<!--_____________ Basket font box _____________-->
		<div id='Basket_font_box' 
			 class='box220 bgc_font'>
			<div class='block220'>
				<img src='${pageContext.request.contextPath}/images/_for_views/_package_basket/cover_font.png' 
					 width='220' 
					 height='220' />
			</div>
			<div class='block60 flex_center bgc_white'>
				<a href='${pageContext.request.contextPath}/views/font'>
					<img src='${pageContext.request.contextPath}/images/_for_views/_package_basket/title_font.png' 
						 width='40' 
						 height='40' />
				</a>
			</div>
			<div class='block40 flex_spacebetween'>
				<div class='rec_text_40 chi_20'>FONT</div>
			</div>
		</div>
		<!--_____________ Basket gift box _____________-->
		<div id='Basket_gift_box' 
			 class='box580 bgc_gift'>
<!-- gift empty 
			<div class='block220'>
				<img src='${pageContext.request.contextPath}/images/_for_views/_package_basket/cover_gift.png' 
					 width='580' 
					 height='220' />
			</div>
			<div class='block60 flex_center bgc_white'>
				<a href='${pageContext.request.contextPath}/views/gift'>
					<img src='${pageContext.request.contextPath}/images/_for_views/_package_basket/title_gift.png' 
						 width='40' 
						 height='40' />
				</a>
			</div>
			<div class='block40 flex_spacebetween'>
				<div class='rec_text_40 chi_20'>GIFT</div>
			</div>
-->
<!-- gift -->
			<div class='block280'>
				<div class='block40 flex_left bgc_lightgray'>
					<div class='box280 text_align'>商品名稱</div>
					<div class='box90 text_align'>單價</div>
					<div class='box90 text_align'>數量</div>
					<div class='box90 text_align'>小計</div>
				</div>
				<div class='block240 flex_block overflow_y bgc_white'>
					<!-- A gift -->
					<div class='rec60 flex_left'>
						<div class='square60'>
							<img src='' 
								 width='60' 
								 height='60' />
							<button type='button'
									class='button_circle bgi_remove_from_basket'></button>
						</div>
						<div class='box220'>
							<div class='rec_text_60 chi_16_30'>一二三</div>
						</div>
						<div class='box90 flex_center'>
							<div class='rec_text_40'>$ 123</div>
						</div>
						<div class='box90 flex_center'>
							<button type='button'
									class='square20 border bgi_minus'></button>
							<input class='rec_digit border chi_16_20 bgc_white'
								   value='1' 
								   disabled />
							<button type='button' 
									class='square20 border bgi_plus'></button>
						</div>
						<div class='box90 flex_center'>
							<div class='rec_text_40'>$ 123</div>
						</div>
					</div>
				</div>
			</div>
			<div class='block40 flex_spacebetween'>
				<div class='rec_text_40 chi_20'>GIFT</div>
				<div class='rec_text_40 chi_20'>$ 4,321</div>
			</div>
<!-- -->
			
		</div>
	</div>
</div>
<div class='block20'></div>