$(function() {
	// get cookie
	herObject = getHer()

	loadBasketCookie()
})

const baseUrl = serverUrl + '/api/user'

/* functions for cookie */
let herObject = {
}

function setHer(herObject, exdays) {
	console.log('setHer(): ' + JSON.stringify(herObject))
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = "her=" + JSON.stringify(herObject) + ";" + expires + ";path=/";
}

function getHer() {
	console.log('getHer()')
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf('her=') == 0) {
            return JSON.parse(c.substring('her='.length, c.length));
        }
    }
    setHer(herObject)
    return {};
}


function addToBasket(id) {
	const prefix = id.slice(0, 1).toLowerCase()

	console.log('adToBasket('+ id +')' + ', prefix: '+ prefix)

	let type
	switch(prefix) {
		case 'c':
			type = 'card'
			break;
		case 'f':
			type = 'font'
			break;
		case 'g':
			type = 'gift'
			break;
	}

	if(type === 'card' || type === 'font') {
		herObject[type] = id
	} else if(type === 'gift') {
		if(herObject.hasOwnProperty('gifts')) {
			herObject.gifts[id] =  1
		} else {
			herObject.gifts = {}
			herObject.gifts[id] =  1
		}
	}

	setHer(herObject, 7)
	loadBasketCookie()
}

function removeFromBasket(id) {
	const prefix = id.slice(0, 1).toLowerCase()

	let type
	switch(prefix) {
		case 'c':
			type = 'card'
			break;
		case 'f':
			type = 'font'
			break;
		case 'g':
			type = 'gift'
			break;
	}
	
	console.log('removeFormBasket('+ id +')' + ', prefix: '+ prefix)

	if(type === 'card' || type === 'font') {
		delete herObject[type]
	} else if(type === 'gift') {
		delete herObject.gifts[id]
		
		if($.isEmptyObject(herObject.gifts)) {
			delete herObject.gifts
		}
	}

	setHer(herObject, 7)
	loadBasketCookie()
}

function adjustGiftQuantity(id, n) {
	console.log('adjustQuantity: '+ id +', n:' + n)

	if(n===1 && herObject.gifts[id] < 6) {
		herObject.gifts[id] += 1
	}

	if(n===-1 && herObject.gifts[id] > 1) {
		herObject.gifts[id] -= 1
	}

	console.log(herObject)

	setHer(herObject, 7)
	loadBasketCookie()
}

/*--------------------------------------------------*/
function loadMemberId() {
	let memberId = getHer('memberId')
	if(memberId !== null && memberId.length !== 0) {
		console.log(memberId)
		$('#Login').text(memberId)
	}
}

const cardBoxEmpty = `
<div class='block220'>
	<img
		src='${webapp}/images/_for_views/_package_basket/cover_card.png'
		width='220'
		height='220' 
		/>
</div>
<div class='block60 flex_center bgc_white'>
	<a href='${webapp}/views/front/card_page.jsp'>
		<img
			src='${webapp}/images/_for_views/_package_basket/title_card.png'
			width='40'
			height='40' />
	</a>
</div>
<div class='block40 flex_spacebetween'>
	<div class='rec_text_40 chi_20'>CARD</div>
</div>
`
	


const cardBoxContent = (data) => `
	<div class='square220'>
		<img src='${data.cover}'
			 width='220'
			 height='220' />
		<button
			type='button'
			class='button_circle bgi_remove_from_basket'
			onclick='removeFromBasket("${data.id}")'></button>
	</div>
	<div class='block60 flex_left bgc_white'>
		<div class='rec_text_60 chi_16_30'>${data.name}</div>
	</div>
	<div class='block40 flex_right'>
		<div
			id='Card_price'
			class='rec_text_40 chi_20'>$ ${data.price}</div>
	</div>
`

const fontBoxContent = (data) => `
<div class='square220'>
	<img src='${data.cover}'
		 width='220'
		 height='220' />
	<button
		type='button'
		class='button_circle bgi_remove_from_basket'
		onclick='removeFromBasket("${data.id}")'></button>
</div>
<div class='block60 flex_left bgc_white'>
	<div class='rec_text_60 chi_16_30'>${data.name}</div>
</div>
<div class='block40 flex_right'>
	<div
		id='Font_price'
		class='rec_text_40 chi_20'>$ ${data.price}</div>
</div>
`

const fontBoxEmpty = `
<div class='block220'>
	<img
		src='${webapp}/images/_for_views/_package_basket/cover_font.png'
		width='220'
		height='220' />
</div>
<div class='block60 flex_center bgc_white'>
	<a href='${webapp}/views/front/font_page.jsp'>
		<img
			src='${webapp}/images/_for_views/_package_basket/title_font.png'
			width='40'
			height='40' />
	</a>
</div>
<div class='block40 flex_spacebetween'>
	<div class='rec_text_40 chi_20'>FONT</div>
</div>
`

const giftBoxEmpty = `
<div class='block220'>
	<img src='${webapp}/images/_for_views/_package_basket/cover_gift.png'
		 width='580'
		 height='220' />
</div>
<div class='block60 flex_center bgc_white'>
	<a href='${webapp}/views/front/gift_page.jsp'>
		<img src='${webapp}/images/_for_views/_package_basket/title_gift.png'
			 width='40'
			 height='40' />
	</a>
</div>
<div class='block40 flex_spacebetween'>
	<div class='rec_text_40 chi_20'>GIFT</div>
</div>
`

const getGiftsDataHTML = (giftsData) => {
	return giftsData.reduce((acc, gift) => acc += `
		<div class='rec60 flex_left'>
			<div class='square60'>
				<img src='${gift.cover}'
					 width='60'
					 height='60' />
				<button
					type='button'
					class='button_circle bgi_remove_from_basket'
					onclick='removeFromBasket("${gift.id}")'></button>
			</div>
			<div class='box220'>
				<div class='rec_text_60 chi_16_30'>${gift.name}</div>
			</div>
			<div class='box90 flex_center'>
				<div class='rec_text_40'>$ ${gift.price}</div>
			</div>
			<div class='box90 flex_center'>
				<button
					type='button'
					class='square20 border bgi_minus'
					onclick='adjustGiftQuantity("${gift.id}", -1)'></button>
				<input class='rec_digit border chi_16_20 bgc_white'
					   value='${gift.quantity}'
					   disabled />
				<button
					type='button'
					class='square20 border bgi_plus'
					onclick='adjustGiftQuantity("${gift.id}", 1)'></button>
			</div>
			<div class='box90 flex_center'>
				<div class='rec_text_40'>$ ${gift.price * gift.quantity}</div>
			</div>
		</div>
	`, '')
}

const giftBoxContent = (giftsData) => `
<div class='block280'>
	<div class='block40 flex_left bgc_lightgray'>
		<div class='box280 text_align'>商品名稱</div>
		<div class='box90 text_align'>單價</div>
		<div class='box90 text_align'>數量</div>
		<div class='box90 text_align'>小計</div>
	</div>
	<div class='block240 flex_block overflow_y bgc_white'>

		${getGiftsDataHTML(giftsData)}

	</div>
</div>
<div class='block40 flex_spacebetween'>
	<div class='rec_text_40 chi_20'>GIFT</div>
	<div
		id='Gifts_sum'
		class='rec_text_40 chi_20'>$ ${calculateGiftsSum(giftsData)}</div>
</div>
`

function calculateGiftsSum(giftsData) {
	return giftsData.reduce((acc, gift) => {
		acc += gift.price * gift.quantity
		return acc
	}, 0)
}

function renderBasketCardBoxView(cardData) {
	const basket_card_box = $('#Basket_card_box')

	basket_card_box.empty()
	basket_card_box.append(cardBoxContent(cardData))
}

function renderBasketFontBoxView(fontData) {
	const basket_font_box = $('#Basket_font_box')

	basket_font_box.empty()
	basket_font_box.append(fontBoxContent(fontData))
}

function renderBasketGiftBoxView(giftsData) {
	const basket_gift_box = $('#Basket_gift_box')

	basket_gift_box.empty()
	basket_gift_box.append(giftBoxContent(giftsData))
}

function loadBasketCookie() {
	const basket_card_box = $('#Basket_card_box')
	const basket_font_box = $('#Basket_font_box')
	const basket_gift_box = $('#Basket_gift_box')
	
	console.log('loadBasketCookie()')

	if(herObject.hasOwnProperty('card')) {
		const cardId = herObject.card
		
		console.log('has card: ' + cardId)

		getProductDetail(cardId)
		.then((result) => {
			const cardData = result.data.card[0]
			renderBasketCardBoxView(cardData)
		})

	} else {
		basket_card_box.html(cardBoxEmpty)
	}

	if(herObject.hasOwnProperty('font')) {
		const fontId = herObject.font
		
		console.log('has font: ' + fontId)

		getProductDetail(fontId)
		.then((result) => {
			const fontData = result.data.font[0]
			renderBasketFontBoxView(fontData)
		})

	} else {
		basket_font_box.html(fontBoxEmpty)
	}

	if(herObject.hasOwnProperty('gifts')) {
		const gifts = herObject.gifts
		const giftsLength = Object.keys(gifts).length
		
		console.log('has gifts: ' + JSON.stringify(gifts))
		
		let giftsData = []
		
		Object.keys(gifts).map((giftId, index) => {
			getProductDetail(giftId)
			.then((result) => {
				return giftData = {
					quantity: gifts[giftId],
					...result.data.gift[0]
				}		
			})
			.then((giftData) => {
				console.log(giftId + ': ' + JSON.stringify(giftData))
				giftsData.push(giftData)

				renderBasketGiftBoxView(giftsData)
				
			})
		})
	} else {
		basket_gift_box.html(giftBoxEmpty)
	}
}

function viewSingleProduct(id){
	window.open(webapp + '/views/front/product_page.jsp#' + id, '_self')
}


function getProductDetail(id) {
	const prefix = id.slice(0, 1).toLowerCase()
	let type

	switch(prefix) {
		case 'c':
			type = 'card'
			break;
		case 'f':
			type = 'font'
			break;
		case 'g':
			type = 'gift'
			break;
	}

	let fetchUrl = baseUrl + '/' + type + '?id=' + id
	console.log(fetchUrl)

	return fetch(fetchUrl, {
		method: 'GET'
	})
	.then((response) => (response.json()))
}

function insertPack() {
	const memberId = getCookie("memberId")

	if(memberId === "") {
		console.log('not login')
		window.open(webapp + '/views/front/member_page/login.jsp', '_self')
	}
	
	const {
		card = "",
		font = "",
		gifts = {}
	} = herObject
	
	const requestBodyContent = {
		memberId: memberId
	}
	
	let cardPrice = 0
	if($('#Card_price').length !== 0) {
		cardPrice = parseInt($('#Card_price').text().substring(2))
		requestBodyContent.card = {
			id: card,
			price: cardPrice
		}
	} else {
		requestBodyContent.card = {}
	}
	
	let fontPrice = 0
	if($('#Font_price').length !== 0) {
		fontPrice = parseInt($('#Font_price').text().substring(2))
		requestBodyContent.font = {
			id: font,
			price: fontPrice
		}
	} else {
		requestBodyContent.font = {}
	}
	
	let giftsSum = 0
	if($('#Gifts_sum').length !== 0) {
		giftsSum = parseInt($('#Gifts_sum').text().substring(2))
		requestBodyContent.giftSum = giftsSum
	}
	
	requestBodyContent.gift = 
		Object.keys(gifts).reduce((acc, cur) => {
			acc.push({
				giftId: cur,
				giftQuantity: gifts[cur]
			})
			return acc
		}, [])
		
	requestBodyContent.sum = cardPrice + fontPrice + giftsSum

	const fetchUrl = serverUrl + '/api/user/pack'

	if(herObject !== {}) {
		console.log(requestBodyContent)

		fetch(fetchUrl, {
			method: 'POST',
			headers: {
						'Content-Type': 'application/json',
					},
			body: JSON.stringify(requestBodyContent)
		})
		.then(() => {
			herObject = {}
			setHer(herObject, 7)
			loadBasketCookie()
		})
	}
}
