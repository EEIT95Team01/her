$(function() {
	// print cookie
	console.log('0 cookie: ' + document.cookie)

	// get cookie
	herObject = getHer()
	console.log('1 cookie: ' + JSON.stringify(getHer()))

	loadBasketCookie()

	// change cookie -> attach this event when cards are loaded
	$('.bgi_add_to_basket').on('click', addToBasket)
})

const baseUrl = serverUrl + '/api/user'

/* functions for cookie */
let herObject = {
}

function setHer(herObject, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = "her=" + JSON.stringify(herObject) + ";" + expires + ";path=/";
}

function getHer() {
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
    console.log('setHer()')
    return "";
}


function addToBasket() {
	console.log('add to basket')
	const id = $(this).siblings('.js_id').val()
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

	if(type === 'card' || type === 'font') {
		herObject[type] = id
	} else if(type === 'gift') {
		if(herObject.hasOwnProperty('gifts')) {
			herObject.gifts[id] =  1
		} else {
			herObject = {
				gifts: {
					[id]: 1
				}
			}
		}
	}

	setHer(herObject, 7)
	loadBasketCookie()
}

function removeFromBasket() {
	console.log('remove form basket')
	const id = $(this).siblings('.js_id').val()
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
		height='220' />
</div>
<div class='block60 flex_center bgc_white'>
	<a href='${webapp}/card'>
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

const fontBoxEmpty = `
<div class='block220'>
	<img
		src='${webapp}/images/_for_views/_package_basket/cover_font.png'
		width='220'
		height='220' />
</div>
<div class='block60 flex_center bgc_white'>
	<a href='${webapp}/font'>
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
	<a href='${webapp}/gift'>
		<img src='${webapp}/images/_for_views/_package_basket/title_gift.png'
			 width='40'
			 height='40' />
	</a>
</div>
<div class='block40 flex_spacebetween'>
	<div class='rec_text_40 chi_20'>GIFT</div>
</div>
`

const giftBoxContent = `
<div class='block280'>
	<div class='block40 flex_left bgc_lightgray'>
		<div class='box280 text_align'>商品名稱</div>
		<div class='box90 text_align'>單價</div>
		<div class='box90 text_align'>數量</div>
		<div class='box90 text_align'>小計</div>
	</div>
	<div class='block240 flex_block overflow_y bgc_white'>

		<!-- A gift -->
		<div class='rec60 flex_left'>
			<div class='square60'>
				<img src=''
					 width='60'
					 height='60' />
				<input
					type='hidden'
					class='js_id'
					value='g00000000000' />
				<button type='button'
						class='button_circle bgi_remove_from_basket'></button>
			</div>
			<div class='box220'>
				<div class='rec_text_60 chi_16_30'>一二三</div>
			</div>
			<div class='box90 flex_center'>
				<div class='rec_text_40'>$ 123</div>
			</div>
			<div class='box90 flex_center'>
				<button type='button'
						class='square20 border bgi_minus'></button>
				<input class='rec_digit border chi_16_20 bgc_white'
					   value='1'
					   disabled />
				<button type='button'
						class='square20 border bgi_plus'></button>
			</div>
			<div class='box90 flex_center'>
				<div class='rec_text_40'>$ 123</div>
			</div>
		</div>


	</div>
</div>
<div class='block40 flex_spacebetween'>
	<div class='rec_text_40 chi_20'>GIFT</div>
	<div class='rec_text_40 chi_20'>$ </div>
</div>
`

function loadBasketCookie() {
	const basket_card_box = $('#Basket_card_box')
	const basket_font_box = $('#Basket_font_box')
	const basket_gift_box = $('#Basket_gift_box')

	if(herObject.hasOwnProperty('card')) {
		const cardId = herObject.card

		getProduct(cardId)
	} else {
		basket_card_box.html(cardBoxEmpty)
	}

	if(herObject.hasOwnProperty('font')) {
		const fontId = herObject.font

		getProduct(fontId)
	} else {
		basket_font_box.html(fontBoxEmpty)
	}

	if(herObject.hasOwnProperty('gifts')) {
		const gifts = herObject.gifts
		console.log('gifts: ' + JSON.stringify(gifts))

		Object.keys(gifts).reduce((acc, giftId) => {
			getProduct(giftId)
		}, '')

		basket_gift_box.html(giftBoxContent)

	} else {
		basket_gift_box.html(giftBoxEmpty)
	}

	$('.bgi_remove_from_basket').on('click', removeFromBasket)
}

function getProduct(id) {
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

	let fetchUrl = baseUrl + '/' + type + '/' + id
	console.log(fetchUrl)
	/*
	return fetch(baseUrl + '/'+ id, {
		method: 'GET'
	})
	.then((response) => (response.json()))
	*/
}
