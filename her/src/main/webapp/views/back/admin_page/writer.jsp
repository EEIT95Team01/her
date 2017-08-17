<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>

<form id='Writer_manage_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>作者管理</div>
		<div class='rec_text'>
			<button id='Writer_insert_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_pink'>新增</button>
			<button id='Writer_update_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_green'>修改</button>
			<button id='Writer_delete_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_darkgray'>刪除</button>
		</div>
	</div>
	<div class='box440'>
		<div class='square440'>
			<img id='Writer_cover_preview'
				 src='${pageContext.request.contextPath}/images/_for_views/cover_default.png'
				 width='440'
				 height='440' />
		</div>
		<div class='block40 flex_left'>
			<input id='Writer_cover'
				   name='writer_cover'
				   type=file />
		</div>
	</div>
	<div class='box360'>
		<div class='block40 flex_left'>
			<label for='Writer_manage_id'
				   class='rec_lable'>編號</label>
			<input id='Writer_manage_id'
				   name='writer_manage_id'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Writer_manage_name'
				   class='rec_lable'>名稱</label>
			<input id='Writer_manage_name'
				   name='writer_manage_name'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block120 flex_left'>
			<label for='Writer_manage_description'
				   class='rec_lable'>說明</label>
			<textarea id='Writer_manage_description'
				   name='writer_manage_description'
				   class='rec_textarea220 chi_16_30' /></textarea>
		</div>

	</div>
</form>

<form id='Writer_select_form'
	  class='js_form_container block flex_block'>
	<div class='block40 flex_spacebetween'>
		<div class='rec_text_40'>查詢作者</div>
		<div class='rec_text'>
			<button id='Writer_select_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_pink'>查詢</button>
		</div>
	</div>
	<div class='block'>
		<div class='block40 flex_left'>
			<label for='Writer_select_id'
				   class='rec_lable'>編號</label>
			<input id='Writer_select_id'
				   name='writer_select_id'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<label for='Writer_select_name'
				   class='rec_lable'>名稱</label>
			<input id='Writer_select_name'
				   name='writer_select_name'
				   class='rec_input220 chi_16_30' />
		</div>
		<div class='block40 flex_left'>
			<div class='rec_lable'></div>
		</div>
	</div>
</form>
