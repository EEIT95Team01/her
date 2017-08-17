<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form id='Gift_manage_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>禮物管理</div>
		<div class='rec40'>
			<button id='Gift_insert_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_pink'>新增</button>
			<button id='Gift_update_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_green'>修改</button>
		</div>
	</div>
	<div class='box440'>
		<div class='square440'>
			<img id='Gift_cover_preview'
				 src='${pageContext.request.contextPath}/images/_for_views/cover_default.png'
				 width='440'
				 height='440' />
		</div>
		<div class='block40 flex_left'>
			<input id='Gift_cover'
				   name='gift_cover'
				   type=file />
		</div>
	</div>
	<div class='box360'>
		<div class='block40 flex_left'>
			<label for='Gift_manage_id'
				   class='rec_lable'>編號</label>
			<input id='Gift_manage_id'
				   name='gift_manage_id'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_manage_name'
				   class='rec_lable'>名稱</label>
			<input id='Gift_manage_name'
				   name='gift_manage_name'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_manage_price'
				   class='rec_lable'>價格</label>
			<input id='Gift_manage_price'
				   name='gift_manage_price'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_manage_manufacturer'
				   class='rec_lable'>作者</label>
			<input id='Gift_manage_manufacturer'
				   name='gift_manage_manufacturer'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_manage_cost'
				   class='rec_lable'>成本</label>
			<input id='Gift_manage_cost'
				   name='gift_manage_cost'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_manage_stock'
				   class='rec_lable'>庫存</label>
			<input id='Gift_manage_stock'
				   name='gift_manage_stock'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_manage_status'
				   class='rec_lable'>上下架</label>
			<select id='Gift_manage_status'
					name='gift_manage_status'
					class='rec_input220 chi_16_30'>
					<option value='1'>上架</option>
					<option value='0'>下架</option>
			</select>
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_manage_tagNames'
				  	 class='rec_lable'>標籤</label>
			<input id='Gift_manage_tagNames'
						 name='gift_manage_tagNames'
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

<form id='Gift_select_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢禮物</div>
		<div class='rec40'>
			<button id='Gift_select_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label for='Gift_select_id'
				   class='rec_lable'>編號</label>
			<input id='Gift_select_id'
				   name='gift_select_id'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_select_name'
				   class='rec_lable'>名稱</label>
			<input id='Gift_select_name'
				   name='gift_select_name'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_select_price_range'
				   class='rec_lable'>價格</label>
			<div class='rec_slider220'>
				<div id='Gift_select_price_slider'></div>
			</div>
			<input id='Gift_select_price_range'
				   name='gift_select_price_range'
				   class='rec40 chi_16_40 bgc_black'
				   readonly />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_select_cost_range'
				   class='rec_lable'>成本</label>
			<div class='rec_slider220'>
				<div id='Gift_select_cost_slider'></div>
			</div>
			<input id='Gift_select_cost_range'
				   name='gift_select_cost_range'
				   class='rec40 chi_16_40 bgc_black'
				   readonly />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_select_manufacturer'
				   class='rec_lable'>作者</label>
			<input id='Gift_select_manufacturer'
				   name='gift_select_manufacturer'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Gift_select_status'
				   class='rec_lable'>狀態</label>
			<select id='Gift_select_status'
					name='gift_select_status'
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
