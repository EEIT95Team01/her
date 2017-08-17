<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form
	id='Tag_manage_form'
	class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>標籤管理</div>
		<div class='rec_text'>
			<button
				id='Tag_insert_button'
				type='button'
				class='button_roundcorner chi_16_30 bgc_pink'>新增</button>
			<button
				id='Tag_update_button'
				type='button'
				class='button_roundcorner chi_16_30 bgc_green'>修改</button>
			<button
				id='Tag_delete_button'
				type='button'
				class='button_roundcorner chi_16_30 bgc_darkgray'>刪除</button>
		</div>
	</div>
	<div class='box360'>
		<div class='block40 flex_left'>
			<label
				for='Tag_manage_id'
				class='rec_lable'>編號</label>
			<input
				id='Tag_manage_id'
				name='tag_manage_id'
				type='number'
				class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label
				for='Tag_manage_name'
				class='rec_lable'>名稱</label>
			<input
				id='Tag_manage_name'
				name='tag_manage_name'
				maxlength='9'
				class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label
				for='Tag_manage_discount'
				class='rec_lable'>折數</label>
			<input
				id='Tag_manage_discount'
				name='tag_manage_discount'
				type='number'
				class='rec_input220 chi_16_30' />
		</div>
	</div>
</form>

<form
	id='Tag_select_form'
	class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢標籤</div>
		<div class='rec_text'>
			<button
				id='Tag_select_button'
				type='button'
				class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label
				for='Tag_select_id'
				class='rec_lable'>編號</label>
			<input
				id='Tag_select_id'
				name='tag_select_id'
				type='number'
				class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label
				for='Tag_select_name'
				class='rec_lable'>名稱</label>
			<input
				id='Tag_select_name'
				name='tag_select_name'
				maxlength='9'
				class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label
				for='Tag_select_discount_range'
				class='rec_lable'>折數</label>
			<div class='rec_slider220'>
				<div id='Tag_select_discount_slider'></div>
			</div>
			<input
				id='Tag_select_discount_range'
				name='tag_select_discount_range'
				class='rec40 chi_16_40 bgc_black'
				readonly />
		</div>
		<div class='block40 flex_left'>
			<div class='rec_lable'></div>
		</div>
	</div>
</form>
