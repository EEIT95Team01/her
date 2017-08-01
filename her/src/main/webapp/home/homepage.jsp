<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>her - HOME</title>
    <!-- google fonts-->
    <link href='https://fonts.googleapis.com/css?family=Maven+Pro' rel='stylesheet' />
    <link href='https://fonts.googleapis.com/earlyaccess/notosanstc.css' rel='stylesheet' />

    <!--css-->
    <!--<link href='bootstrap-3.3.7-dist/css/bootstrap.min.css' type='text/css' rel='stylesheet' />-->
    <link href="jQuery_UI/jquery-ui.css" rel="stylesheet" />
    <link href="jQuery_UI/jquery-ui.min.css" rel="stylesheet" />
    <link href="jQuery_UI/jquery-ui.structure.css" rel="stylesheet" />
    <link href="jQuery_UI/jquery-ui.structure.min.css" rel="stylesheet" />
    <link href="jQuery_UI/jquery-ui.theme.css" rel="stylesheet" />
    <link href="jQuery_UI/jquery-ui.theme.min.css" rel="stylesheet" />

    <link href='css/index.css' type='text/css' rel='stylesheet' />
    <link href='css/id.css' type='text/css' rel='stylesheet' />

    <!-- javascript -->
    <script src='js/jquery-3.2.1.js' type='text/javascript'></script>
    <script src="jQuery_UI/jquery-ui.js"></script>
    <script src="jQuery_UI/jquery-ui.min.js"></script>

    <script src='js/home.js' type='text/javascript'></script>
</head>
<body>
	<div id="All" class="chi_16_s">
		<!--_____________ Header _____________-->
		<div id="HeaderBlock" class="flexbox text">
			<div id="HeaderBar" class="block flexend">
				<div id="BarNavBox" class="spacebetween chi_12">
					<a href="#"><div class="barNav text">購物說明</div></a>
                    <a href="#"><div class="barNav text">聯絡我們</div></a>
                    <a href="#"><div class="barNav text">忘記密碼</div></a>
                    <a href="#"><div class="barNav text">Facebook</div></a>
                    <a href="#"><div class="barNav text">Instagram</div></a>
				</div>
			</div>
			<div id="LogoBox" class="center">
				<div id="Logo"></div>
			</div>
			<div id="HeaderMainNavBox" class="spacebetween eng_20">
				<a href="home"><div class="textRec_s  text">HOME</div></a>
                <a href="card"><div class="textRec_s text">CARD</div></a>
                <a href="font"><div class="textRec_s text">FONT</div></a>
                <a href="gift"><div class="textRec_s text">GIFT</div></a>
                <a href="#"><div class="textRec_s text">ABOUT</div></a>
			</div>
			<div id="HeaderMemberNavBox" class="flexend">
				<a href="#"><div class="textRec_s text">登入</div></a>
			</div>
			<div id="HeaderMailboxNavBox" class="center">
				<div id="HeaderMailboxNav" class="spacebetween">
					<a href="package/package.html"><div class="textRec text">郵寄箱</div></a>
					<img src="images/mailbox.png" width="40" height="40" />
					<!--_____________ Mailbox _____________-->
					<div id="Mailbox">
						
					</div>
				</div>
			</div>
		</div>
		<div class="br"></div>
		<!--_____________ PackageBasket _____________-->
        <div id="PackageBasketBlock" class="flexbox">
            <div class="block40">
                <div class="textRec_s">包裹組合籃｜PACKAGE BASKET</div>
<!--_____________ form _____________-->
                <form id="HomeForm" class="buttonRec center" action="#" method="post">
                	<div class="textRec">將</div>
                	<div class="textRec cursor">〈</div>
<!--_____________ input _____________-->
                	<input name="quantity" class="quantityRec textAlign chi_16_q" value="1" disabled="disabled" />
                	<div class="textRec cursor">〉</div>
                	<div class="textRec">個包裹</div>
<!--_____________ button _____________-->
                	<button name="action" type="submit" class="button submit chi_16_d" value="INSERT_PACKAGE">加入郵寄箱</button>
                </form>
            </div>
            <div id="BasketCardBox" class="card">
                <!--_____________ PackageBasket Card _____________-->
                <div class="square220">
<!--_____________ input _____________-->
                	<input name="cardId" form="HomeForm" hidden="hidden" value="c01707130001" />
                	<img src="images_temp/c01707130001.png" width="220" height="220" />
                	<div class="circle removeFromBasket"></div>
                </div>
                <div class="block60 text">
                    <div class="textRec_d chi_16_d">[ 而我喜歡這樣的你 ] 明信片</div>
                </div>
                <div class="block40">
                    <div class="textRec_s eng_20">CARD</div>
                    <div class="priceRec chi_20">$ 30</div>
                </div>
            </div>
            <div id="BasketFontBox" class="font">
                <!--_____________ PackageBasket Font _____________-->
                <div class="square220">
                	<a href="#"><img src="images/font.png" width="220" height="220"/></a>
                </div>
                <div class="block60 center text">
                    <a href="#" class="a40"><img src="images/font_go.png" width="40" height="40"/></a>
                </div>
                <div class="block40">
                    <div class="textRec_s eng_20">FONT</div>
                </div>
            </div>
            <div id="BasketGiftBox" class="flexbox gift">
                <!--_____________ PackageBasket Gift _____________-->
                <div id="BasketGiftTitleBox" class="flexstart title">
                    <div class="giftNameTitleRec textAlign">商品名稱</div>
                    <div class="gfitPAndQRec textAlign">單價</div>
                    <div class="gfitPAndQRec textAlign">數量</div>
                    <div class="gfitPAndQRec textAlign">小計</div>
                </div>
                <div id="BasketGiftContentBox" class="flexbox text">
                    <div class="block60 flexstart">
                        <div class="square60">
<!--_____________ input _____________-->
                        	<input form="HomeForm" name="giftId" value="g01707130001" hidden="hidden" />

                        	<div class="circle removeFromBasket"></div>
                        </div>
                        <div class="giftNameRec textAlign">
                            <div class="textRec_d chi_16_d">TreAsia Round 筆筒</div>
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 522</div>
                        </div>
                        <div class="gfitPAndQRec center">
                            <img src="images/minus.png" width="20" height="20" class="border cursor" />
<!--_____________ input _____________-->
                            <input form="HomeForm" name="g01707130001" class="quantityRec border textAlign chi_16_q" value="1" readonly="readonly" />
                            <img src="images/plus.png" width="20" height="20" class="border cursor" />
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 522</div>
                        </div>
                    </div>
                    <div class="block60 flexstart">
                        <div class="square60">
<!--_____________ input _____________-->
                        	<input form="HomeForm" name="giftId" value="g01707130002" hidden="hidden" />

                        	<div class="circle removeFromBasket"></div>
                        </div>
                        <div class="giftNameRec textAlign">
                            <div class="textRec_d chi_16_d">Fresco LED迷你植物燈</div>
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 441</div>
                        </div>
                        <div class="gfitPAndQRec center">
                            <img src="images/minus.png" width="20" height="20" class="border cursor" />
<!--_____________ input _____________-->
                            <input form="HomeForm" name="g01706130002" class="quantityRec border textAlign chi_16_q" value="1" readonly="readonly" />
                            <img src="images/plus.png" width="20" height="20" class="border cursor" />
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 441</div>
                        </div>
                    </div>
                    <div class="block60 flexstart">
                        <div class="square60">
<!--_____________ input _____________-->
                        	<input form="HomeForm" name="giftId" value="g01707130002" hidden="hidden" />

                        	<div class="circle removeFromBasket"></div>
                        </div>
                        <div class="giftNameRec textAlign">
                            <div class="textRec_d chi_16_d">Fresco LED迷你植物燈</div>
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 441</div>
                        </div>
                        <div class="gfitPAndQRec center">
                            <img src="images/minus.png" width="20" height="20" class="border cursor" />
<!--_____________ input _____________-->
                            <input form="HomeForm" name="g01706130002" class="quantityRec border textAlign chi_16_q" value="1" readonly="readonly" />
                            <img src="images/plus.png" width="20" height="20" class="border cursor" />
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 441</div>
                        </div>
                    </div>
                    <div class="block60 flexstart">
                        <div class="square60">
<!--_____________ input _____________-->
                        	<input form="HomeForm" name="giftId" value="g01707130002" hidden="hidden" />

                        	<div class="circle removeFromBasket"></div>
                        </div>
                        <div class="giftNameRec textAlign">
                            <div class="textRec_d chi_16_d">Fresco LED迷你植物燈</div>
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 441</div>
                        </div>
                        <div class="gfitPAndQRec center">
                            <img src="images/minus.png" width="20" height="20" class="border cursor" />
<!--_____________ input _____________-->
                            <input form="HomeForm" name="g01706130002" class="quantityRec border textAlign chi_16_q" value="1" readonly="readonly" />
                            <img src="images/plus.png" width="20" height="20" class="border cursor" />
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 441</div>
                        </div>
                    </div>
                    <div class="block60 flexstart">
                        <div class="square60">
<!--_____________ input _____________-->
                        	<input form="HomeForm" name="giftId" value="g01707130002" hidden="hidden" />

                        	<div class="circle removeFromBasket"></div>
                        </div>
                        <div class="giftNameRec textAlign">
                            <div class="textRec_d chi_16_d">Fresco LED迷你植物燈</div>
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 441</div>
                        </div>
                        <div class="gfitPAndQRec center">
                            <img src="images/minus.png" width="20" height="20" class="border cursor" />
<!--_____________ input _____________-->
                            <input form="HomeForm" name="g01706130002" class="quantityRec border textAlign chi_16_q" value="1" readonly="readonly" />
                            <img src="images/plus.png" width="20" height="20" class="border cursor" />
                        </div>
                        <div class="gfitPAndQRec flexend">
                            <div class="priceRec">$ 441</div>
                        </div>
                    </div>
                </div>
                <div class="block40">
                    <div class="textRec_s eng_20">GIFT</div>
                    <div class="priceRec chi_20">$ 963</div>
                </div>
            </div>
        </div>
        <div class="br"></div>
		<!--_____________ Recommend _____________-->
		<div id="RecommendBlock" class="flexbox">
			<div class="block40">
				<div class="textRec_s">人氣推薦｜RECOMMEND</div>
			</div>
			<div id="RecommendProductBox" class="flexbox">
				<div class="square220">
					<a href="#"><img src="images_temp/c01707130001.png" width="220" height="220" /></a>
					<div class="circle insertCollection"></div>
					<div class="circle addToBasket"></div>
				</div>
				<div class="square220">
					<div class="circle insertCollection"></div>
					<div class="circle addToBasket"></div>
				</div>
				<div class="square220">
					<div class="circle insertCollection"></div>
					<div class="circle addToBasket"></div>
				</div>
				<div class="br"></div>
				<div class="square160">
					<div class="circle insertCollection"></div>
					<div class="circle addToBasket"></div>
				</div>
				<div class="square160">
					<div class="circle insertCollection"></div>
					<div class="circle addToBasket"></div>
				</div>
				<div class="square160">
					<div class="circle insertCollection"></div>
					<div class="circle addToBasket"></div>
				</div>
				<div class="square160">
					<div class="circle insertCollection"></div>
					<div class="circle addToBasket"></div>
				</div>
			</div>
			<div id="RecommendAdBox">

			</div>
		</div>
		<div class="br"></div>
		<!--_____________ Category _____________-->
		<div id="CategoryBlock" class="spacebetween">
			<div class="block40">
				<div class="textRec_s">商品分類｜CATEGORY</div>
			</div>
			<a href="card/card.html"><div class="categoryBox center card">
				<div class="eng_60">CARD</div>
			</div></a>
			<a href="font/font.html"><div class="categoryBox center font">
				<div class="eng_60">FONT</div>
			</div></a>
			<a href="gift/gift.html"><div class="categoryBox center gift">
				<div class="eng_60">GIFT</div>
			</div></a>
		</div>
		<div class="br"></div>
		<!--_____________ Recent _____________-->
		<div id="RecentBlock" class="flexbox">
			<div class="block40">
				<div class="textRec_s">新品推薦｜RECENT</div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="br"></div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
			<div class="square196">
				<div class="circle insertCollection"></div>
				<div class="circle addToBasket"></div>
			</div>
		</div>
		<div class="br"></div>
	</div>
</body>
</html>