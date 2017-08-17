<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form
	id='Member'
	class='js_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>基本資料</div>
		<div class='rec40'>
			<button id='Member_update_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_green'>儲存修改</button>
		</div>
	</div>
	<div class='block40 flex_left'>
		<label
			for='Member_name'
			class='rec_lable'>姓名</label>
		<input
			id='Member_name'
			name='member_name'
			class='rec_input220 border chi_16_30'>
	</div>
	<div class='block40 flex_left'>
		<label
			for='Member_birthday'
			class='rec_lable'>生日</label>
		<input
			id='Member_birthday'
			name='member_birthday'
			class='rec_input220 border chi_16_30'>
	</div>
	<div class='block40 flex_left'>
		<label
			for='Member_phone'
			class='rec_lable'>手機</label>
		<input
			id='Member_phone'
			name='member_phone'
			class='rec_input220 border chi_16_30'>
	</div>
	<div class='block40 flex_left'>
		<label for='Member_city'
			   class='rec_lable'>地址</label>
		<div id='Member_postal_code'
			 name='sender_postal_code'
			 class='rec_digit chi_16_20'>110</div>
		<select id='Member_city'
				name='sender_city'
				class='rec_input113 border chi_16_30'>
				<option value=''>臺北市</option>
		</select>
		<select id='Member_disrict'
				name='sender_disrict'
				class='rec_input113 border chi_16_30'>
				<option value=''>中正區</option>
		</select>
	</div>
	<div class='block40 flex_left'>
		<div class='rec_lable'></div>
		<input
			id='Member_addr'
			name='member_addr'
			class='rec_input580 border chi_16_30'
			value='羅斯福路三段' />
	</div>
	<div class='block40 flex_left'>
		<label
			for='Member_email'
			class='rec_lable'>E-mail</label>
		<input
			id='Member_email'
			name='member_email'
			class='rec_input580 border chi_16_30'>
	</div>
	<div class='block20'></div>
	<div class='block40 flex_left'>
		<div class='rec_text_40'>變更密碼</div>
		<div class='rec40'>
		</div>
	</div>
	<div class='block40 flex_left'>
		<label
			for='Member_password'
			class='rec_lable'>目前密碼</label>
		<input
			id='Member_password'
			name='member_password'
			type='password'
			class='rec_input220 border chi_16_30'>
	</div>
	<div class='block40 flex_left'>
		<label
			for='Member_password_new'
			class='rec_lable'>新密碼</label>
		<input
			id='Member_password_new'
			name='member_password_new'
			type='password'
			class='rec_input220 border chi_16_30'>
	</div>
	<div class='block40 flex_left'>
		<label
			for='Member_password_confirm'
			class='rec_lable'>確認密碼</label>
		<input
			id='Member_password_confirm'
			name='member_password_confirm'
			type='password'
			class='rec_input220 border chi_16_30'>
	</div>
</form>
