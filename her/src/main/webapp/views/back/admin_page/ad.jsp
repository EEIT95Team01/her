<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form id='Ad_manage_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>廣告管理</div>
		<div class='rec40'>
			<button id='Ad_insert_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_pink'>新增</button>
			<button id='Ad_update_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_green'>修改</button>
			<button id='Ad_delete_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_darkgray'>刪除</button>
		</div>
	</div>
	<div class='box340'>
		<div class='block400'>
			<img id='Ad_image_preview'
				 	 src='${pageContext.request.contextPath}/images/_for_views/cover_default.png'
				 	 width='340'
				 	 height='400' />
		</div>
		<div class='block40 flex_left'>
			<input id='Ad_image'
				   	 name='ad_image'
				   	 type=file />
		</div>
	</div>
	<div class='box460'>
		<div class='block40 flex_left'>
			<label for='Ad_manage_id'
				  	 class='rec_lable'>編號</label>
			<input id='Ad_manage_id'
				   	 name='ad_manage_id'
				   	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Ad_manage_name'
				  	 class='rec_lable'>名稱</label>
			<input id='Ad_manage_name'
				  	 name='ad_manage_name'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Ad_manage_beginDate'
				  	 class='rec_lable'>起始日期</label>
			<input id='Ad_manage_beginDate'
				  	 name='ad_manage_beginDate'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Ad_manage_endDate'
				  	 class='rec_lable'>結束日期</label>
			<input id='Ad_manage_endDate'
				  	 name='ad_manage_endDate'
				  	 class='rec_input220 chi_16_30' />
		</div>
	</div>
</form>

<form id='Ad_select_form'
			class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢廣告</div>
		<div class='rec40'>
			<button id='Ad_select_button'
					type='button'
					class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label for='Ad_select_id'
				  	 class='rec_lable'>編號</label>
			<input id='Ad_select_id'
				   	 name='ad_select_id'
				   	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Ad_select_name'
				  	 class='rec_lable'>名稱</label>
			<input id='Ad_select_name'
				  	 name='ad_select_name'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Ad_select_beginDate'
				  	 class='rec_lable'>起始日期</label>
			<input id='Ad_select_beginDate'
				  	 name='ad_select_beginDate'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Ad_select_endDate'
				  	 class='rec_lable'>結束日期</label>
			<input id='Ad_select_endDate'
				  	 name='ad_select_endDate'
				  	 class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<div class='rec_lable'></div>
		</div>
	</div>
</form>
