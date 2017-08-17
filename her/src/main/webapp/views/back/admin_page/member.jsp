<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form id='Member_select_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢會員</div>
		<div class='rec_text'>
			<button type='button' 
					class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label for='Member_select_id'
				   class='rec_lable'>編號</label>
			<input id='Member_select_id' 
				   name='member_select_id' 
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Member_select_email'
				   class='rec_lable'>信箱</label>
			<input id='Member_select_email' 
				   name='member_select_email' 
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<div class='rec_lable'></div>
		</div>
	</div>
</form>