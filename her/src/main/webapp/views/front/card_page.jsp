<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>her - CARD</title>
	<c:import url='/views/common/_resources.jsp' />

<<<<<<< HEAD
</head>
<body>
	<div class='all chi_16_40 flex_block'>
		<!--_____________ _header _____________-->
		<c:import url='/views/common/_header.jsp' />
		
		<!--_____________ _package_basket _____________-->
		<c:import url='/views/common/_package_basket.jsp' />

		<div class='box820 flex_spacebetween'>
			<div class='block40'>
				<div class='rec_text_40'>卡片｜CARD</div>
			</div>
			<div class='block flex_left'>
				<div class='rec_category'>
					<div class="square190">
						<img src=''
							 width='190' 
							 height='190' />
                        <button type='button' 
								class='button_circle bgi_add_to_collection'></button>
						<button type='button' 
								class='button_circle bgi_add_to_basket'></button>
                    </div>
                    <div class='rec_text_60 chi_16_30'>而我喜歡這樣的你</div>
                    <div class='rec_text_40 flex_right'>$ 30</div>
				</div>
				<div class='rec_category'>
					
				</div>
				<div class='rec_category'>
					
				</div>
				<div class='rec_category'>
					
				</div>
				<div class='rec_category'>
					
				</div>
				<div class='rec_category'>
					
				</div>
			</div>
		</div>

		<div class='box220'>
			<div class='rec40 flex_left'>
				<input id='Search' 
					   name='search' 
					   placeholder='請輸入關鍵字' 
					   class='rec_input180 border chi_16_30' />
				<button type='button'
						class='square30 bgi_search'></button>
			</div>
		</div>
	</div>
</body>
</html>
=======
	<script src='${pageContext.request.contextPath}/js/card_page.js' type='text/javascript'></script>
	<script src='${pageContext.request.contextPath}/js/front_page_action.js' type='text/javascript'></script>
</head>
<body>
	<div class='all chi_16_40 flex_block'>
		<!--_____________ _header _____________-->
		<c:import url='/views/common/_header.jsp' />

		<!--_____________ _package_basket _____________-->
		<c:import url='/views/common/_package_basket.jsp' />

		<div class='box820 flex_spacebetween'>
			<div class='block40'>
				<div class='rec_text_40'>卡片｜CARD</div>
			</div>
			<div class='block flex_left'>
				<div class='rec_category'>
					<div class="square190">
						<img
							src=''
							width='190'
							height='190' />
						<input
	          	type='hidden'
	          	class='js_id'
	          	value='g00000000000' />
            <button
            	type='button'
							class='button_circle bgi_add_to_collection'></button>
						<button
							type='button'
							class='button_circle bgi_add_to_basket'></button>
          </div>
          <div class='js_name rec_text_60 chi_16_30'>而我喜歡這樣的你</div>
          <div class='js_price rec_text_40 flex_right'>$ 30</div>
				</div>
				<div class='rec_category'>

				</div>
				<div class='rec_category'>

				</div>
				<div class='rec_category'>

				</div>
				<div class='rec_category'>

				</div>
				<div class='rec_category'>

				</div>
			</div>
		</div>

		<div class='box220'>
			<div class='rec40 flex_left'>
				<input id='Search'
					   name='search'
					   placeholder='請輸入關鍵字'
					   class='rec_input180 border chi_16_30' />
				<button type='button'
						class='square30 bgi_search'></button>
			</div>
		</div>
	</div>
</body>
</html>
>>>>>>> branch 'master' of https://github.com/EEIT95Team01/her.git
