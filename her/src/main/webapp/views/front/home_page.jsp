<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
	<title>her - HOME</title>
	<c:import url='/views/common/_resources.jsp' />

</head>
<body>
	<div class='all chi_16_40 flex_block'>
		<!--_____________ _header _____________-->
		<c:import url='/views/common/_header.jsp' />

		<!--_____________ _package_basket _____________-->
		<c:import url='/views/common/_package_basket.jsp' />

		<!--_____________ Recommend _____________-->
		<div class='block'>
			<div class='block40'>
				<div class='rec_text_40'>人氣推薦｜RECOMMEND</div>
			</div>
			<div class='block400 flex_block'>
				<div class='box700 flex_block'>
<!-- top 2 viewed cards -->
					<div class='square220'>
<!-- card 1
						<img src='#'
							 width='220'
							 height='220'>
						<button type='button'
								class='button_circle bgi_add_to_collection'></button>
						<button type='button'
								class='button_circle bgi_add_to_basket'></button>
-->
					</div>
					<div class='square220'>
<!-- card 2
						<img src='#'
							 width='220'
							 height='220'>
						<button type='button'
								class='button_circle bgi_add_to_collection'></button>
						<button type='button'
								class='button_circle bgi_add_to_basket'></button>
-->
					</div>
<!-- top 1 viewed font -->
					<div class='square220'>
<!-- font 1
						<img src='#'
							 width='220'
							 height='220'>
						<button type='button'
								class='button_circle bgi_add_to_collection'></button>
						<button type='button'
								class='button_circle bgi_add_to_basket'></button>
-->
					</div>
					<div class='block20'></div>
<!-- top 4 viewed gifts -->
					<div class='square160'>
<!-- gift 1
						<img src='#'
							 width='160'
							 height='160'>
						<button type='button'
								class='button_circle bgi_add_to_collection'></button>
						<button type='button'
								class='button_circle bgi_add_to_basket'></button>
-->
					</div>
<!-- top 4 viewed gifts -->
					<div class='square160'>
<!-- gift 2
						<img src='#'
							 width='160'
							 height='160'>
						<button type='button'
								class='button_circle bgi_add_to_collection'></button>
						<button type='button'
								class='button_circle bgi_add_to_basket'></button>
-->
					</div>
<!-- top 4 viewed gifts -->
					<div class='square160'>
<!-- gift 3
						<img src='#'
							 width='160'
							 height='160'>
						<button type='button'
								class='button_circle bgi_add_to_collection'></button>
						<button type='button'
								class='button_circle bgi_add_to_basket'></button>
-->
					</div>
<!-- top 4 viewed gifts -->
					<div class='square160'>
<!-- gift 4
						<img src='#'
							 width='160'
							 height='160'>
						<button type='button'
								class='button_circle bgi_add_to_collection'></button>
						<button type='button'
								class='button_circle bgi_add_to_basket'></button>
-->
					</div>
				</div>
				<div class='box340'>

				</div>
			</div>
		</div>
		<div class='block20'></div>
		<!--_____________ Category _____________-->
		<div class='block'>
			<div class='block40'>
				<div class='rec_text_40'>商品分類｜CATEGORY</div>
			</div>
			<div class='block210 flex_block chi_60'>
				<a href='${pageContext.request.contextPath}/card'
				   class='box340 flex_center bgc_card'>
					<span>CARD</span>
				</a>
				<a href='${pageContext.request.contextPath}/font'
				   class='box340 flex_center bgc_font'>
					<span>FONT</span>
				</a>
				<a href='${pageContext.request.contextPath}/gift'
				   class='box340 flex_center bgc_gift'>
					<span>GIFT</span>
				</a>
			</div>
		</div>
		<div class='block20'></div>
		<!--_____________ Recent _____________-->
		<div class='block'>
			<div class='block40'>
				<div class='rec_text_40'>新品推薦｜RECENT</div>
			</div>
			<div class='block412 flex_block'>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='block20'></div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
				<div class='square196'>

					<button type='button'
							class='button_circle bgi_add_to_collection'></button>
					<button type='button'
							class='button_circle bgi_add_to_basket'></button>
				</div>
			</div>
		</div>
		<div class='block20'></div>
	</div>
</body>
</html>
