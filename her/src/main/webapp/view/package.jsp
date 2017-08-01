<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Handwriting Cards - PACKAGE</title>
<!-- google fonts-->
<link href='https://fonts.googleapis.com/css?family=Maven+Pro'
	rel='stylesheet' />
<link href='https://fonts.googleapis.com/earlyaccess/notosanstc.css'
	rel='stylesheet' />

<!--css-->
<!--<link href='bootstrap-3.3.7-dist/css/bootstrap.min.css' type='text/css' rel='stylesheet' />-->
<link href="/her/view/jQuery_UI/jquery-ui.css" rel="stylesheet" />

<link href='/her/view/index.css' type='text/css' rel='stylesheet' />

<!-- javascript -->
<script src='/her/view/js/jquery-3.2.1.js' type='text/javascript'></script>
<script src="/her/view/jQuery_UI/jquery-ui.js"></script>
<script src="/her/view/jQuery_UI/jquery-ui.min.js"></script>

<script src='/her/view/js/package.js' type='text/javascript'></script>
</head>
<body>
	<div id="All">
		<div id="HeaderBlock" class="block spacebetween">
			<div id="HeaderBar" class="flexend">
				<div id="BarNavBox" class="spacebetween">
					<div class="barNav chi_12">購物說明</div>
					<div class="barNav chi_12">聯絡我們</div>
					<div class="barNav chi_12">忘記密碼</div>
					<div class="barNav chi_12">Facebook</div>
					<div class="barNav chi_12">Instagram</div>
				</div>
			</div>
			<div id="LogoBox" class="center">
				<a href="index.html"><div id="Logo"></div></a>
			</div>
			<div id="MainNavBox" class="spacebetween">
				<a href="index.html"><div class="textRec eng_20">HOME</div></a> <a
					href=""><div class="textRec eng_20">CARD</div></a> <a href=""><div
						class="textRec eng_20">FONT</div></a> <a href=""><div
						class="textRec eng_20">GIFT</div></a> <a href=""><div
						class="textRec eng_20">ABOUT</div></a>
			</div>
			<div id="AccountNavBox" class="flexend">
				<a href=""><div id="Account" class="textRec chi_16_s">登入</div></a>
			</div>
			<div id="MailboxNavBox" class="center">
				<a href=""><div class="textRec chi_16_s">郵寄箱</div></a>
				<div class="textRec">
					<img src="/her/view/images/mailbox.png" width="40" height="40" />
				</div>
				<div id="MailboxBox"></div>
			</div>
		</div>
		<div class="br"></div>
		<div id="PackageBasketBlock" class="block spacebetween">
			<div class="titleBlock">
				<div class="singleLineRec chi_16_s">包裹組合籃｜PACKAGE BASKET</div>
			</div>
			<div class="smallBasketRec card spacebetween">
				<div class="largeSquare">
					<img src="/her/view/images_temp/C01707130001.png" height="220" />
					<div class="circleButton removeFromBasket"></div>
				</div>
				<div class="productNameRec">
					<div class="doubleLineRec chi_16_d">[ 而我喜歡這樣的你 ] 明信片</div>
				</div>
				<div class="singleLineRec eng_20 card">CARD</div>
				<div class="priceRec chi_20 card">NT $ 30</div>
			</div>
			<div class="smallBasketRec font">
				<div class="largeSquare">
					<img src="/her/view/images/font.png" width="220" height="220" />
				</div>
				<div class="productNameRec center">
					<img src="/her/view/images/font_go.png" width="40" height="40" />
				</div>
				<div class="singleLineRec eng_20 font">GIFT</div>
			</div>
			<div class="bigBasketRec gift">
				<div class="largeSquare">
					<img src="/her/view/images/gift.png" width="580" height="220" />
				</div>
				<div class="productNameRec center">
					<img src="/her/view/images/gift_go.png" width="40" height="40" />
				</div>
				<div class="singleLineRec eng_20 gift">GIFT</div>
			</div>
		</div>
		<div class="br"></div>
		<div id="PackageBlock" class="block spacebetween">
			<form id="PackageMainBox" class="spacebetween" action=""
				method="post">
				<div class="titleBlock">
					<div class="singleLineRec chi_16_s">包裹｜PACKAGE</div>
					<div class="buttonRec center">
						<div class="roundCornerButton chi_16_d delete">刪除包裹</div>
						<div class="tab"></div>
						<div class="roundCornerButton chi_16_d reset">移至暫存箱</div>
						<div class="tab"></div>
						<div class="roundCornerButton chi_16_d edit">儲存修改</div>
					</div>
				</div>
				<div class="halfRowRec title">
					<label for="PackageName" class="titleRec chi_16_s">包裹名稱</label> <input
						id="PackageName" class="middleInputRec chi_16_d"
						name="packageName" type="text" />
				</div>
				<div class="halfRowRec title">
					<label for="PackageDateMailed" class="titleRec chi_16_s">寄達日期</label>
					<input id="PackageDateMailed" class="middleInputRec chi_16_d"
						name="packageDateMailed" type="text" />
				</div>
				<div class="br"></div>
				<div class="halfRowsRec">
					<div class="halfRowRec title">
						<div class="titleRec">
							<label for="Recipient" class="chi_16_s">收件人</label>
						</div>
						<select id="Recipient" class="middleInputRec chi_16_d"
							name="recipient">
							<option>H</option>
							<option>L</option>
							<option>C</option>
						</select>
					</div>
					<div class="halfRowRec">
						<label for="RecipientName" class="titleRec chi_16_s">姓名</label> <input
							id="RecipientName" class="middleInputRec chi_16_d"
							name="recipientName" type="text" />
					</div>
					<div class="halfRowRec">
						<label for="RecipientPhone" class="titleRec chi_16_s">手機</label> <input
							id="RecipientPhone" class="middleInputRec chi_16_d"
							name="recipientPhone" type="text" />
					</div>
					<div class="halfRowRec">
						<label for="RecipientCity" class="titleRec chi_16_s">地址</label>
						<div id="" class="tinyInputRec chi_16_s">110</div>
						<select id="RecipientCity" class="smallInputRec chi_16_d"
							name="recipientCity">
							<option>請選擇</option>
							<option>台北市</option>
							<option>台中市</option>
							<option>高雄市</option>
						</select> <select id="RecipientDistrict" class="smallInputRec chi_16_d"
							name="recipientDistrict">
							<option>請選擇</option>
							<option>信義區</option>
							<option>大安區</option>
							<option>中正區</option>
						</select>
					</div>
					<div class="halfTRowRec spacebetween">
						<label for="RecipientAddr" class="titleRec chi_16_s">地址</label>
						<textarea id="RecipientAddr" class="largeInputRec chi_16_d"
							name="recipientAddr" form="PackageMainBox" maxlength="30">信義路五段</textarea>
					</div>
				</div>
				<div class="halfRowsRec">
					<div class="halfRowRec title">
						<div class="titleRec">
							<label for="Sender" class="chi_16_s">寄件人</label>
						</div>
						<select id="Sender" class="middleInputRec chi_16_d" name="sender">
							<option>我</option>
						</select>
					</div>
					<div class="halfRowRec">
						<label for="SenderName" class="titleRec chi_16_s">姓名</label> <input
							id="SenderName" class="middleInputRec chi_16_d" name="senderName"
							type="text" />
					</div>
					<div class="halfRowRec">
						<label for="SenderPhone" class="titleRec chi_16_s">手機</label> <input
							id="SenderPhone" class="middleInputRec chi_16_d"
							name="senderPhone" type="text" />
					</div>
					<div class="halfRowRec">
						<label for="SenderCity" class="titleRec chi_16_s">地址</label>
						<div id="" class="tinyInputRec chi_16_d">106</div>
						<select id="SenderCity" class="smallInputRec chi_16_d"
							name="senderCity">
							<option>台北市</option>
							<option>台中市</option>
							<option>高雄市</option>
						</select> <select id="SenderDistrict" class="smallInputRec chi_16_d"
							name="senderDistrict">
							<option>大安區</option>
							<option>中正區</option>
							<option>信義區</option>
						</select>
					</div>
					<div class="halfTRowRec spacebetween">
						<label for="SenderAddr" class="titleRec chi_16_s">地址</label>
						<textarea id="SenderAddr" class="largeInputRec chi_16_d"
							name="senderAddr" form="PackageMainBox" maxlength="30">羅斯福路三段283巷14弄6號五樓

</textarea>
					</div>
				</div>
				<div class="br"></div>
				<div class="fullRowsRec spacebetween">
					<div class="fullRowRec title">
						<label for="CardContent" class="titleRec chi_16_s">卡片內容</label>
						<div class="buttonRec">
							<div class="textRec chi_16_s">剩餘</div>
							<div class="textRec chi_16_s">145</div>
							<div class="textRec chi_16_s">字</div>
							<div class="tab"></div>
						</div>
					</div>
					<textarea id="CardContent" class="hugeInputRec chi_16_d"
						name="cardContent" form="PackageMainBox" maxlength="150"></textarea>
				</div>
			</form>
			<div id="PackageMenuBox">
				<div class="titleBlock">
					<div class="singleLineRec chi_16_s">郵寄箱</div>
					<div class="buttonRec center">
						<div class="roundCornerButton chi_16_d submit">寄出包裹</div>
					</div>
				</div>
				
				<c:forEach var="pack" items="${mailboxPackages}">
				<div class="titleBlock">
					<div class="singleLineRec chi_16_s onfocus"><a href="">${pack.name}</a></div>
					<div class="priceRec chi_16_s onfocu">$ ${pack.sum}</div>
				</div>
				</c:forEach>

<!-- 				<div class="titleBlock"> -->
<!-- 					<div class="singleLineRec chi_16_s onfocus">To 黃</div> -->
<!-- 					<div class="priceRec chi_16_s onfocu">$ 1,025</div> -->
<!-- 				</div> -->
<!-- 				<div class="titleBlock"> -->
<!-- 					<div class="singleLineRec chi_16_s onblur">包裹3</div> -->
<!-- 					<div class="priceRec chi_16_s onblur">$ 333</div> -->
<!-- 				</div> -->
<!-- 				<div class="titleBlock"> -->
<!-- 					<div class="singleLineRec chi_16_s onblur">包裹4</div> -->
<!-- 					<div class="priceRec chi_16_s onblur">$ 444</div> -->
<!-- 				</div> -->

				<div class="titleBlock">
					<div class="br"></div>
					<div class="titleBlock">
						<div class="singleLineRec chi_16_s">暫存箱</div>
					</div>
					<c:forEach var="pack" items="${repositoryPackages}">
					<div class="titleBlock">
						<div class="singleLineRec chi_16_s onfocus">${pack.name}</div>
						<div class="priceRec chi_16_s onfocu">$ ${pack.sum}</div>
					</div>
					</c:forEach>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>