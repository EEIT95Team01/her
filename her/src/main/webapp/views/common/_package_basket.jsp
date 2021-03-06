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

			<button
				type='button'
				class='button_roundcorner chi_16_30 bgc_pink'
				onclick='insertPack()'>加入郵寄箱</button>
		</div>
	</div>
	<div class='block320 flex_spacebetween'>
		<!--_____________ Basket card box _____________-->
		<div
			id='Basket_card_box'
			class='box220 bgc_card'>
		</div>
		<!--_____________ Basket font box _____________-->
		<div
			id='Basket_font_box'
			class='box220 bgc_font'>
		</div>
		<!--_____________ Basket gift box _____________-->
		<div
			id='Basket_gift_box'
			class='box580 bgc_gift'>
		</div>
	</div>
</div>
<div class='block20'></div>

