<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>her - ORDER</title>
	<c:import url='/views/common/_resources.jsp' />

	<script src="${pageContext.request.contextPath}/js/member_page/loginOrNot.js" type="text/javascript"></script>
	<script src='${pageContext.request.contextPath}/js/pack_page.js' type='text/javascript'></script>
	<script src='${pageContext.request.contextPath}/js/member_page/ordering.js' type='text/javascript'></script>

</head>
<body>
	<div class='all flex_block chi_16_40'>
		<!--_____________ _header _____________-->
		<c:import url='/views/common/_header.jsp' />

		<div class='block flex_block'>
			<div
				id='Ordering_box'
				class='box820 flex_block'>
				<div class='block40 flex_spacebetween'>
					<div class='rec_text_40'>訂單｜ORDER</div>
					<div class='rec40 flex_center'>
						<button
							id='Packpage_return_button'
							type='button'
							class='button_roundcorner chi_16_30 bgc_gray'>返回郵寄箱</button>
					</div>
				</div>

				<!-- a pack 
				<div class='block flex_block'> -->
					<!-- title 
					<div class='block40 flex_spacebetween'>
						<div class='rec_text_40'>包裹名稱｜2018-02-19</div>
						<div class='rec40 chi_20'>NT 2109</div>
					</div> -->
					<!--  
					<div class='block40 flex_left bgc_lightgray'>
						<div class='box550 text_align'>商品名稱</div>
						<div class='box90 text_align'>單價</div>
						<div class='box90 text_align'>數量</div>
						<div class='box90 text_align'>小計</div>
					</div> -->
					<!-- card 
					<div class='block60 flex_left'>
						<div class='box550 flex_left'>
							<div class='square60 chi_32 text_align bgc_card'>C</div>
							<div class='square60'>
								<img
								 src='http://i.imgur.com/NjDeNOR.jpg'
								 width=60
								 height=60 />
							</div>
							<div class='rec_text_60 chi_16_30'>【畢業回憶盒卡】</div>
						</div>
						<div class='box90 flex_center'>$ 640</div>
						<div class='box90 flex_center'>x 1</div>
						<div class='box90 flex_center'>$ 640</div>
					</div>
					<!-- font 
					<div class='block60 flex_left'>
						<div class='box550 flex_left'>
							<div class='square60 chi_32 text_align bgc_font'>F</div>
							<div class='square60'>
								<img
								 src='http://i.imgur.com/2X1AQMM.jpg'
								 width=60
								 height=60 />
							</div>
							<div class='rec_text_60 chi_16_30'>粗黑體</div>
						</div>
						<div class='box90 flex_center'>$ 20</div>
						<div class='box90 flex_center'>1</div>
						<div class='box90 flex_center'>$ 20</div>
					</div>
					<!-- gift 
					<div class='block'>
						<div class='block60 flex_left'>
							<div class='box550 flex_left'>
								<div class='square60 chi_32 text_align bgc_gift'>G</div>
								<div class='square60'>
									<img
									 src='http://imgur.com/XYzKsWA.jpg'
									 width=60
									 height=60 />
								</div>
								<div class='rec_text_60 chi_16_30'>【快樂畢業熊】</div>
							</div>
							<div class='box90 flex_center'>$ 1150</div>
							<div class='box90 flex_center'>1</div>
							<div class='box90 flex_center'>$ 1150</div>
						</div>
						<div class='block60 flex_left'>
							<div class='box550 flex_left'>
								<div class='square60 chi_32 text_align bgc_gift'></div>
								<div class='square60'>
									<img
									 src='http://i.imgur.com/BnbOwvd.jpg'
									 width=60
									 height=60 />
								</div>
								<div class='rec_text_60 chi_16_30'>【獅子座塗鴉馬克杯】</div>
							</div>
							<div class='box90 flex_center'>$ 299</div>
							<div class='box90 flex_center'>1</div>
							<div class='box90 flex_center'>$ 299</div>
						</div>
					</div>
					<div class='block20'></div>
					<!-- recipient & sender
					<div class='box400'>
						<div class='block240'>
							<div class='block40 flex_left bgc_lightgray'>
								<div class='rec_lable'>收件人</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>姓名</div>
								<div class='rec40'>黃</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>手機</div>
								<div class='rec40'>0955373437</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>地址</div>
								<div class='rec40'>臺北市</div>
								<div class='rec_text_40'>信義區</div>
							</div>
							<div class='block80 flex_left'>
								<div class='rec_lable'></div>
								<div class='rec_textarea286 chi_16_30'>信義路五段</div>
							</div>
						</div>
					</div>
					<div class='box400'>
						<div class='block240'>
							<div class='block40 flex_left bgc_lightgray'>
								<div class='rec_lable'>寄件人</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>姓名</div>
								<div class='rec40'>廖</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>手機</div>
								<div class='rec40'>0963392568</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>地址</div>
								<div class='rec40'>臺北市</div>
								<div class='rec_text_40'>大安區</div>
							</div>
							<div class='block80 flex_left'>
								<div class='rec_lable'></div>
								<div class='rec_textarea286 chi_16_30'>羅斯福路三段</div>
							</div>
						</div>
					</div>
					<!-- card content
					<div class='block'>
						<div class='block40 bgc_lightgray'>
							<div class='rec_lable'>卡片內容</div>
						</div>
						<div class='block100'>
							<div class='rec_textarea800 chi_16_30'>生日快樂。</div>
						</div>
					</div>
				</div>
				<div class='block20'></div>
				<!-- a pack -->
			</div>
			<div class='box220'>
				<div class='block'>
					<div class='block40 flex_spacebetween'>
						<div class='rec_text_40'>付款方式</div>
						<div class='rec40 flex_center'>
							<button
								id='order_insert_button'
								type='button'
								class='button_roundcorner chi_16_30 bgc_pink'>結帳</button>
						</div>
					</div>
				</div>
			</div>
			<div class='block20'></div>
		</div>
	</div>
</body>
</html>
