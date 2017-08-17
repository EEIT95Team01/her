<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form id='Orderform_select_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢訂單</div>
		<div class='rec_text'>
			<button type='button'
					class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label for='Orderform_select_id'
				   class='rec_lable'>編號</label>
			<input id='Orderform_select_id'
				   name='orderform_select_id'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Orderform_select_name'
				   class='rec_lable'>名稱</label>
			<input id='Orderform_select_name'
				   name='orderform_select_name'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Orderform_select_memberId'
				   class='rec_lable'>會員編號</label>
			<input id='Orderform_select_memberId'
				   name='orderform_select_memberId'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Orderform_select_beginDateCreated'
				  	 class='rec_lable'>建立日期</label>
			<input id='Orderform_select_beginDateCreated'
				  	 name='orderform_select_beginDateCreated'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Orderform_select_endDateCreated'
				  	 class='rec_lable'>建立日期</label>
			<input id='Orderform_select_endDateCreated'
				  	 name='orderform_select_endDateCreated'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Orderform_select_paymentStatus'
				   class='rec_lable'>付款狀態</label>
			<input id='Orderform_select_paymentStatus'
				   name='orderform_select_paymentStatus'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<div class='rec_lable'></div>
		</div>
	</div>
</form>
