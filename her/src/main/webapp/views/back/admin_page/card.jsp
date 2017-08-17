<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form id='Card_manage_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>卡片管理</div>
		<div class='rec40'>
			<button id='Card_insert_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_pink'>新增</button>
			<button id='Card_update_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_green'>修改</button>
		</div>
	</div>
	<div class='box440'>
		<div class='square440'>
			<img id='Card_cover_preview'
				 	 src='${pageContext.request.contextPath}/images/_for_views/cover_default.png'
				 	 width='440'
				 	 height='440' />
		</div>
		<div class='block40 flex_left'>
			<input id='Card_cover'
				   	 name='card_cover'
				   	 type=file />
		</div>
	</div>
	<div class='box360'>
		<div class='block40 flex_left'>
			<label for='Card_manage_id'
						 pattern='[cC]{1}[0-9]{11}'
				  	 class='rec_lable'>編號</label>
			<input id='Card_manage_id'
				   	 name='card_manage_id'
				   	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_manage_name'
				  	 class='rec_lable'>名稱</label>
			<input id='Card_manage_name'
				  	 name='card_manage_name'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_manage_price'
				  	 class='rec_lable'>價格</label>
			<input id='Card_manage_price'
				  	 name='card_manage_price'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_manage_manufacturer'
				  	 class='rec_lable'>作者</label>
			<input id='Card_manage_manufacturer'
				  	 name='card_manage_manufacturer'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_manage_cost'
				  	 class='rec_lable'>成本</label>
			<input id='Card_manage_cost'
				  	 name='card_manage_cost'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_manage_stock'
				  	 class='rec_lable'>庫存</label>
			<input id='Card_manage_stock'
				  	 name='card_manage_stock'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_manage_maxWordCount'
				  	 class='rec_lable'>字數上限</label>
			<input id='Card_manage_maxWordCount'
				  	 name='card_manage_maxWordCount'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_manage_status'
				  	 class='rec_lable'>上下架</label>
			<select id='Card_manage_status'
							name='card_manage_status'
							class='rec_input220 chi_16_30'>
					<option value='1'>上架</option>
					<option value='0'>下架</option>
			</select>
		</div>
		<div class='block40 flex_left'>
			<label for='Card_manage_tagNames'
				  	 class='rec_lable'>標籤</label>
			<input id='Card_manage_tagNames'
						 name='card_manage_tagNames'
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

<form id='Card_select_form'
			class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢卡片</div>
		<div class='rec40'>
			<button id='Card_select_button'
					type='button'
					class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label for='Card_select_id'
				  	 class='rec_lable'>編號</label>
			<input id='Card_select_id'
				  	 name='card_select_id'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_select_name'
				  	 class='rec_lable'>名稱</label>
			<input id='Card_select_name'
				  	 name='card_select_name'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_select_price_range'
				  	 class='rec_lable'>價格</label>
			<div class='rec_slider220'>
				<div id='Card_select_price_slider'></div>
			</div>
			<input id='Card_select_price_range'
				  	 name='card_select_price_range'
				  	 class='rec40 chi_16_40 bgc_black'
				  	 readonly />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_select_cost_range'
				  	 class='rec_lable'>成本</label>
			<div class='rec_slider220'>
				<div id='Card_select_cost_slider'></div>
			</div>
			<input id='Card_select_cost_range'
				  	 name='card_select_cost_range'
				  	 class='rec40 chi_16_40 bgc_black'
				  	 readonly />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_select_manufacturer'
				  	 class='rec_lable'>作者</label>
			<input id='Card_select_manufacturer'
				  	 name='card_select_manufacturer'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Card_select_status'
				  	 class='rec_lable'>狀態</label>
			<select id='Card_select_status'
							name='card_select_status'
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
