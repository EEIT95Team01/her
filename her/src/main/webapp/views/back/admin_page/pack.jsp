<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form id='Pack_select_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢包裹</div>
		<div class='rec_text'>
			<button id='Pack_select_button'
					type='button'
					class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label for='Pack_select_id'
				   class='rec_lable'>編號</label>
			<input id='Pack_select_id'
				   name='pack_select_id'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Pack_select_name'
				   class='rec_lable'>名稱</label>
			<input id='Pack_select_name'
				   name='pack_select_name'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Pack_select_memberId'
				   class='rec_lable'>會員編號</label>
			<input id='Pack_select_memberId'
				   name='pack_select_memberId'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Pack_select_sum_range'
				   class='rec_lable'>金額</label>
			<div class='rec_slider220'>
				<div id='Pack_select_sum_slider'></div>
			</div>
			<input id='Pack_select_sum_range'
				   name='pack_select_sum_range'
				   class='rec40 chi_16_40 bgc_black'
				   readonly />
		</div>
		<div class='block40 flex_left'>
			<label for='Pack_select_beginDateMailed'
				  	 class='rec_lable'>寄達日期</label>
			<input id='Pack_select_beginDateMailed'
				  	 name='pack_select_beginDateMailed'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Pack_select_endDateMailed'
				  	 class='rec_lable'>寄達日期</label>
			<input id='Pack_select_endDateMailed'
				  	 name='pack_select_endDateMailed'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Pack_select_status'
				   class='rec_lable'>狀態</label>
			<select id='Pack_select_status'
					name='pack_select_status'
					class='rec_input220 chi_16_30'>
				<option value='0'>全部</option>
				<option value='1'>暫存箱</option>
				<option value='2'>郵寄箱</option>
				<option value='3'>訂單</option>
			</select>
		</div>
	</div>
</form>
