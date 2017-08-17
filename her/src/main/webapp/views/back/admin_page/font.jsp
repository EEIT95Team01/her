<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form id='Font_manage_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>手寫字管理</div>
		<div class='rec40'>
			<button id='Font_insert_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_pink'>新增</button>
			<button id='Font_update_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_green'>修改</button>
		</div>
	</div>
	<div class='box440'>
		<div class='square440'>
			<img id='Font_cover_preview'
				 src='${pageContext.request.contextPath}/images/_for_views/cover_default.png'
				 width='440'
				 height='440' />
		</div>
		<div class='block40 flex_left'>
			<input id='Font_cover'
				   name='font_cover'
				   type=file />
		</div>
	</div>
	<div class='box360'>
		<div class='block40 flex_left'>
			<label for='Font_manage_id'
				   class='rec_lable'>編號</label>
			<input id='Font_manage_id'
				   name='font_manage_id'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Font_manage_name'
				   class='rec_lable'>名稱</label>
			<input id='Font_manage_name'
				   name='font_manage_name'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Font_manage_price'
				   class='rec_lable'>價格</label>
			<input id='Font_manage_price'
				   name='font_manage_price'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Font_manage_writer'
				   class='rec_lable'>作者</label>
			<select id='Font_manage_writer'
					name='font_manage_writer'
					class='rec_input220 chi_16_30'>
					<option value='0'>請選擇</option>
					<option value='1'>潘柏霖</option>
					<option value='2'>黃色書刊</option>
			</select>
		</div>
		<div class='block40 flex_left'>
			<label for='Font_manage_status'
				   class='rec_lable'>上下架</label>
			<select id='Font_manage_status'
					name='font_manage_status'
					class='rec_input220 chi_16_30'>
					<option value='1'>上架</option>
					<option value='0'>下架</option>
			</select>
		</div>
		<div class='block40 flex_left'>
			<label for='Font_manage_tagNames'
				  	 class='rec_lable'>標籤</label>
			<input id='Font_manage_tagNames'
						 name='font_manage_tagNames'
						 class='js_autocomplete rec_input220 chi_16_30' />
		</div>
	</div>
	<div class='js_description_container block'>
		<div class='block40 flex_spacebetween'>
			<div class='rec_text_40'>圖文說明</div>
			<div class='rec40'>
				<button type='button'
						class='js_add_description button_roundcorner chi_16_30 bgc_green'>增加</button>
				<button type='button'
						class='js_remove_description button_roundcorner chi_16_30 bgc_gray'>刪減</button>
			</div>
		</div>
	</div>
</form>

<form id='Font_select_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢手寫字</div>
		<div class='rec40'>
			<button id='Font_select_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label for='Font_select_id'
				   class='rec_lable'>編號</label>
			<input id='Font_select_id'
				   name='font_select_id'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Font_select_name'
				   class='rec_lable'>名稱</label>
			<input id='Font_select_name'
				   name='font_select_name'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Font_select_price_range'
				   class='rec_lable'>價格</label>
			<div class='rec_slider220'>
				<div id='Font_select_price_slider'></div>
			</div>
			<input id='Font_select_price_range'
				   name='font_select_price_range'
				   class='rec40 chi_16_40 bgc_black'
				   readonly />
		</div>
		<div class='block40 flex_left'>
			<label for='Font_select_writer'
				   class='rec_lable'>作者</label>
			<select id='Font_select_writer'
					name='Font_select_writer'
					class='rec_input220 chi_16_30'>
				<option value='0'>請選擇</option>
				<option value='1'>潘柏霖</option>
				<option value='2'>黃色書刊</option>
			</select>
		</div>
		<div class='block40 flex_left'>
			<label for='Font_select_status'
				   class='rec_lable'>狀態</label>
			<select id='Font_select_status'
					name='font_select_status'
					class='rec_input220 chi_16_30'>
					<option value='1'>上架</option>
					<option value='0'>下架</option>
			</select>
		</div>
		<div class='block40 flex_left'>
			<div class='rec_lable'></div>
		</div>
	</div>
</form>
