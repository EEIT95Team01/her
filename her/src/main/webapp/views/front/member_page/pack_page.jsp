<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>her - PACK</title>
	<c:import url='/views/common/_resources.jsp' />
	<script src="${pageContext.request.contextPath}/js/member_page/loginOrNot.js" type="text/javascript"></script>
	<script src='${pageContext.request.contextPath}/js/pack_page_action.js' type='text/javascript'></script>
	<script src='${pageContext.request.contextPath}/js/pack_page.js' type='text/javascript'></script>

</head>
<body>
	<div class='all flex_block chi_16_40'>
		<!--_____________ _header _____________-->
		<c:import url='/views/common/_header.jsp' />

		<!--_____________ _package_basket _____________-->
		<c:import url='/views/front/member_page/pack_basket_page.jsp' />

		<div class='block flex_block'>
			<div class='box820 flex_block'>
				<div class='block40 flex_spacebetween'>
					<div class='rec_text_40'>包裹｜PACK</div>
					<div class='rec40'>
						<button id=''
								type='button'
								class='button_roundcorner chi_16_30 bgc_darkgray'>刪除</button>
						<button id=''
								type='button'
								class='button_roundcorner chi_16_30 bgc_gray'>移至暫存箱</button>
						<button id=''
								type='button'
								class='button_roundcorner chi_16_30 bgc_green'>儲存修改</button>
					</div>
				</div>
				<div class='box400'>
					<div class='block40 flex_left bgc_lightgray'>
						<label for='Pack_name'
							   class='rec_lable'>包裹名稱</label>
						<input id='Pack_name'
							   name='pack_name'
							   class='rec_input163 border chi_16_30' />
					</div>
					<div class='block20'></div>
					<div class='block240'>
						<div class='block40 flex_left bgc_lightgray'>
							<label for='Recipient_id'
								   class='rec_lable'>收件人</label>
						</div>
						<div class='block40 flex_left'>
							<label for='Recipient_name'
								   class='rec_lable'>姓名</label>
							<input id='Recipient_name'
								   name='recipient_name'
								   class='rec_input163 border chi_16_30' />
						</div>
						<div class='block40 flex_left'>
							<label for='Recipient_phone'
								   class='rec_lable'>手機</label>
							<input id='Recipient_phone'
								   name='recipient_phone'
								   class='rec_input163 border chi_16_30' />
						</div>
						<div class='block40 flex_left'>
							<label for='Recipient_city'
								   class='rec_lable'>地址</label>
							<div id='Recipient_postal_code'
								 name='recipient_postal_code'
								 class='rec_digit chi_16_20'></div>
							<input
								id='Recipient_city'
								name='recipient_city'
								class='rec_input113 border chi_16_30'
								placeholder='臺北市' />
							<input
								id='Recipient_disrict'
								name='recipient_disrict'
								class='rec_input113 border chi_16_30'
								placeholder='中正區' />
						</div>
						<div class='block80 flex_left'>
							<div class='rec_lable'></div>
							<textarea id='Recipient_addr'
									  name='recipient_addr'
									  class='rec_textarea286 border chi_16_30'>信義路五段</textarea>
						</div>
					</div>
				</div>

				<div class='box400'>
					<div class='block40 flex_left bgc_lightgray'>
						<label for='Date_mailed'
							   class='rec_lable'>寄達日期</label>
						<input id='Date_mailed'
							   name='date_mailed'
							   class='rec_input163 border chi_16_30' />
					</div>
					<div class='block20'></div>
					<div class='block240'>
						<div class='block40 flex_left bgc_lightgray'>
							<label for='Member_id'
								   class='rec_lable'>寄件人</label>
						</div>
						<div class='block40 flex_left'>
							<label for='Sender_name'
								   class='rec_lable'>姓名</label>
							<input id='Sender_name'
								   name='sender_name'
								   class='rec_input163 border chi_16_30' />
						</div>
						<div class='block40 flex_left'>
							<label for='Sender_phone'
								   class='rec_lable'>手機</label>
							<input id='Sender_phone'
								   name='sender_phone'
								   class='rec_input163 border chi_16_30' />
						</div>
						<div class='block40 flex_left'>
							<label for='Sender_city'
								   class='rec_lable'>地址</label>
							<div id='Sender_postal_code'
								 name='sender_postal_code'
								 class='rec_digit chi_16_20'></div>
							<input
								id='Sender_city'
								name='sender_city'
								class='rec_input113 border chi_16_30' />
							<input
								id='Sender_disrict'
								name='sender_disrict'
								class='rec_input113 border chi_16_30' />
						</div>
						<div class='block80 flex_left'>
							<div class='rec_lable'></div>
							<textarea id='Sender_addr'
									  name='sender_addr'
									  class='rec_textarea286 border chi_16_30'></textarea>
						</div>
					</div>
				</div>
				<div class='block20'></div>
				<div class='block'>
					<div class='block40 flex_spacebetween bgc_lightgray'>
						<label for='Content'
							   class='rec_lable'>卡片內容</label>
						<div class='rec_text_40'>剩餘145字</div>
					</div>
					<div class='block100'>
						<textarea id= "content" class='rec_textarea800 border chi_16_30'></textarea>
					</div>
				</div>
			</div>
			<div class='box220'>
				<div class='block'>
					<div class='block40 flex_spacebetween'>
						<div class='rec_text_40'>郵寄箱</div>
					<div class='rec40 flex_center'>
						<button id=''
								type='button'
								class='button_roundcorner chi_16_30 bgc_pink'>寄出包裹</button>
					</div>
				</div>
					<div   id="status2">
						
					</div>
				</div>
				<div class='block20'></div>
				<div class='block'>
					<div class='block40'>
						<div class='rec_text_40'>暫存箱</div>
					</div>
					<div  id="status1">
					
					</div>
				</div>
			</div>
			<div class='block20'></div>
		</div>
	</div>
</body>
</html>
