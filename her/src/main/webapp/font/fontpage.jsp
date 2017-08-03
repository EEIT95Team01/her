<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>her - FONT</title>
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

    <script src='js/font.js' type='text/javascript'></script>
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
        <div id="PackageBasketBlock" class="spacebetween">
            <div class="block40">
                <div class="textRec_s">包裹組合籃｜PACKAGE BASKET</div>
<!--_____________ form _____________-->
                <form id="CardForm" class="buttonRec center" action="#" method="get">
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
                <div class="square220">
                    <a href="#"><img src="images/card.png" width="220" height="220"/></a>
                </div>
                <div class="block60 center text">
                    <a href="#" class="a40"><img src="images/card_go.png" width="40" height="40"/></a>
                </div>
                <div class="block40">
                    <div class="textRec_s eng_20">CARD</div>
                </div>
            </div>
            <div id="BasketFontBox" class="font">
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
            <div id="BasketGiftBox" class="gift">
                <div class="block220">
                    <a href="#"><img src="images/gift.png" width="580" height="220"/></a>
                </div>
                <div class="block60 center text">
                    <a href="#" class="a40"><img src="images/gift_go.png" width="40" height="40"/></a>
                </div>
                <div class="block40">
                    <div class="textRec_s eng_20">GIFT</div>
                </div>
            </div>
        </div>
        <div class="br"></div>
        <!--_____________ CARD / FONT / GIFT _____________-->
        <div class="spacebetween">
            <div id="CategoryMainBox" class="flexstart">
                <div class="block40">
                    <div class="textRec_s">手寫字｜FONT</div>
                    <div class="buttonRec center">
                        <div class="textRec">7</div>
                        <div class="textRecTab">筆中的</div>
                        <div class="textRecTab">1</div>
                        <div class="textRecTab">-</div>
                        <div class="textRecTab">?</div>
                        <div class="textRecTab">筆</div>
                        <div class="tab"></div>
                        <select class="inputNormal border chi_16_d">
                            <option value="id">依上架時間</option>
                            <option value="salesCount">依熱銷度</option>
                            <option value="price">依價格：低至高</option>
                            <option value="priceDesc">依價格：高至低</option>
                        </select>
                    </div>
                </div>
                <!--_____________ cardBeans *Create Four Boxes & br At a Time_____________-->
                <c:forEach var="fontBean" items="${fontBeans}">
					<div class="categoryProductBox">
	                    <div class="square190">
	                    	<img src="" width="190" height="190" />
	                        <div class="circle insertCollection"></div>
	                        <div class="circle addToBasket"></div>
	                    </div>
	                    <div class="block60">
		                    <div class="textRec_d chi_16_d text">${fontBean.name}</div>
		                </div>
	                    <div class="block40">
	                    	<div class="priceRec chi_16_d">NT $ ${fontBean.price}</div>
	                    </div>
                	</div>
                </c:forEach>
            </div>
            <div id="CategoryNavBox">
                
            </div>
        </div>
    </div>
</body>
</html>