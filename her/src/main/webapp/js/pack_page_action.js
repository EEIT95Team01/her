$(function() {
	var memberId = getCookie("memberId")

	// 暫存箱
	getStatus1(memberId);

	// 郵寄箱
	getStatus2(memberId);

	// 商品組合籃
	setEmptyBasket()

	$('#ordering_redirect_button').on('click', redirectOrdering)

	//
})

// 目前瀏覽 packId
let currentPackId

// 儲存修改
function updatePack(currentPackId) {
	console.log('updatePack(' + currentPackId + ')')

	// 以 packId 查詢包裹
	const fetchUrl = serverUrl + '/api/user/packId?id=' + currentPackId

	fetch(fetchUrl, {
			method: 'GET'
		})
		.then((response) => response.json())
		.then((result) => {
			let resultData = result.data[0]

			// 修改資料
			resultData.name = $('#Pack_name').val()
			resultData.recipientName = $('#Recipient_name').val()
			resultData.recipientPhone = $('#Recipient_phone').val()
			resultData.recipientCity = $('#Recipient_city').val()
			resultData.recipientDistrict = $('#Recipient_disrict').val()
			resultData.recipientAddr = $('#Recipient_addr').val()
			resultData.dateMailed = $('#Date_mailed').val()
			resultData.senderName = $('#Sender_name').val()
			resultData.senderPhone = $('#Sender_phone').val()
			resultData.senderCity = $('#Sender_city').val()
			resultData.senderDistrict = $('#Sender_disrict').val()
			resultData.senderAddr = $('#Sender_addr').val()
			resultData.content = $('#content').val()

			console.log('修改後資料: ' + resultData)

			fetch(serverUrl + '/api/user/pack', {
				method: 'PUT',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify(resultData)
			})
			.then((response) => response.json())
			.then((result) => {
				if(result.success === 'true') {
					alert('修改成功')
				}
			})
		})
}

// 移至暫存箱 / 郵寄箱
function movePack(currentPackId) {
	console.log('movePack(' + currentPackId + ')')

	// 以 packId 查詢包裹
	const fetchUrl = serverUrl + '/api/user/packId?id=' + currentPackId

	fetch(fetchUrl, {
			method: 'GET'
		})
		.then((response) => response.json())
		.then((result) => {
			let resultData = result.data[0]

			resultData.name = $('#Pack_name').val()
			resultData.recipientName = $('#Recipient_name').val()
			resultData.recipientPhone = $('#Recipient_phone').val()
			resultData.recipientCity = $('#Recipient_city').val()
			resultData.recipientDistrict = $('#Recipient_disrict').val()
			resultData.recipientAddr = $('#Recipient_addr').val()
			resultData.dateMailed = $('#Date_mailed').val()
			resultData.senderName = $('#Sender_name').val()
			resultData.senderPhone = $('#Sender_phone').val()
			resultData.senderCity = $('#Sender_city').val()
			resultData.senderDistrict = $('#Sender_disrict').val()
			resultData.senderAddr = $('#Sender_addr').val()
			resultData.content = $('#content').val()
			if ($('#Pack_move_button').text() === '移至暫存箱') {
				resultData.status = 1
				$('#Pack_move_button').text() === '移至郵寄箱'
			} else if ($('#Pack_move_button').text() === '移至郵寄箱') {
				resultData.status = 2
				$('#Pack_move_button').text() === '移至暫存箱'
			}

			console.log(resultData)

			fetch(serverUrl + '/api/user/pack', {
				method: 'PUT',
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify(resultData)
			})
			.then((response) => response.json())
			.then((result) => {
				var memberId = getCookie("memberId")

				getStatus1(memberId);
				getStatus2(memberId);
			})
		})
}

function setCardBoxEmpty() {
	// set basket_card_box
	const basket_card_box = $('#Basket_card_box')

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

	basket_card_box.empty()
	basket_card_box.append(cardBoxEmpty)
}

function setFontBoxEmpty() {
	// set basket_font_box
	const basket_font_box = $('#Basket_font_box')

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
	basket_font_box.empty()
	basket_font_box.append(fontBoxEmpty)
}

function setGiftBoxEmpty() {
	// set basket_gift_box
	const basket_gift_box = $('#Basket_gift_box')

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
	basket_gift_box.empty()
	basket_gift_box.append(giftBoxEmpty)
}

function setEmptyBasket() {
	setCardBoxEmpty()
	setFontBoxEmpty()
	setGiftBoxEmpty()
}

function renderBasketCardBoxView(cardData) {
	const basket_card_box = $('#Basket_card_box')

	const cardOrFontBoxContent = (cardData) => `
		<div class='square220'>
			<img src='${cardData.cover}'
				 width='220'
				 height='220' />
		</div>
		<div class='block60 flex_left bgc_white'>
			<div class='rec_text_60 chi_16_30'>${cardData.name}</div>
		</div>
		<div class='block40 flex_right'>
			<div class='rec_text_40 chi_20'>$ ${cardData.price}</div>
		</div>
		`

	basket_card_box.empty()
	basket_card_box.append(cardOrFontBoxContent(cardData))
}

function renderBasketFontBoxView(fontData) {
	const basket_font_box = $('#Basket_font_box')

	const cardOrFontBoxContent = (fontData) => `
		<div class='square220'>
			<img src='${fontData.cover}'
				 width='220'
				 height='220' />
		</div>
		<div class='block60 flex_left bgc_white'>
			<div class='rec_text_60 chi_16_30'>${fontData.name}</div>
		</div>
		<div class='block40 flex_right'>
			<div class='rec_text_40 chi_20'>$ ${fontData.price}</div>
		</div>
		`

	basket_font_box.empty()
	basket_font_box.append(cardOrFontBoxContent(fontData))
}

function renderBasketGiftBoxView(giftsData) {
	const basket_gift_box = $('#Basket_gift_box')

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

	basket_gift_box.empty()
	basket_gift_box.append(giftBoxContent(giftsData))
}

function calculateGiftsSum(giftsData) {
	return giftsData.reduce((acc, gift) => {
		acc += gift.price * gift.quantity
		return acc
	}, 0)
}


const getGiftsDataHTML = (giftsData) => {
	return giftsData.reduce((acc, gift) => acc += `
		<div class='rec60 flex_left'>
			<div class='square60'>
				<img src='${gift.cover}'
					 width='60'
					 height='60' />
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
					class='square20 bgc_white'></button>
				<input class='rec_digit chi_16_20 bgc_white'
					   value='${gift.quantity}'
					   disabled />
				<button
					type='button'
					class='square20 bgc_white'></button>
			</div>
			<div class='box90 flex_center'>
				<div class='rec_text_40'>$ ${gift.price * gift.quantity}</div>
			</div>
		</div>
	`, '')
}

function getStatus1(memberId) {
	$('#status2').empty()

	fetch('/her/api/user/pack?memberId=' + memberId + "&status=2", {
			method: 'GET'
		})
		.then((response) => (response.json()))
		.then((result) => {
			const data = result.data;
			$.each(data, function(index, obj) {
				currentPackId = obj.id

				console.log(obj.name)
				console.log(obj.sum)
				var pack_name = $("<button></button>").text(obj.name).attr("class", 'button_roundcorner border bgc_white chi_16_30');
				var pack_sum = $("<div></div>").text('$ ' + obj.sum).attr("class", 'rec40');
				var a = $("<a />").attr("onclick", "getPackId('" + obj.id + "')").append(pack_name)
				var div = $("<div></div>").append(a, pack_sum).attr("class", 'block40 flex_spacebetween')
				$('#status2').append(div)
			})
		})
}
// -> 建議取資料 (fetch) 與 處理畫面 寫為 2 function，以方便維護及共用

function getStatus2(memberId) {
	$('#status1').empty()

	fetch('/her/api/user/pack?memberId=' + memberId + "&status=1", {
			method: 'GET'
		})
		.then((response) => (response.json()))
		.then((result) => {
			const data = result.data;
			$.each(data, function(index, obj) {
				console.log("status=1,obj.name = " + obj.sum);
				var pack_name = $("<button></button>").text(obj.name).attr("class", 'button_roundcorner border bgc_white chi_16_30');
				var pack_sum = $("<div></div>").text('$ ' + obj.sum).attr("class", 'rec40');
				var a = $("<a />").attr("onclick", "getPackId('" + obj.id + "')").append(pack_name)
				var div = $("<div></div>").append(a, pack_sum).attr("class", 'block40 flex_spacebetween')
				$('#status1').append(div)
			})
		})
}


function getPackId(id) {
	setEmptyBasket()

	fetch('/her/api/user/packId?id=' + id, {
			method: 'GET'
		})
		.then((response) => (response.json()))
		.then((result) => {
			const data = result.data;
			document.getElementById("Pack_name").value = data[0].name;
			document.getElementById("Recipient_name").value = data[0].recipientName;
			document.getElementById("Recipient_phone").value = data[0].recipientPhone;
			document.getElementById("Recipient_city").value = data[0].recipientCity;
			document.getElementById("Recipient_disrict").value = data[0].recipientDistrict;
			document.getElementById("Recipient_addr").value = data[0].recipientAddr;
			document.getElementById("Date_mailed").value = data[0].dateMailed;
			document.getElementById("Sender_name").value = data[0].senderName;
			document.getElementById("Sender_phone").value = data[0].senderPhone;
			document.getElementById("Sender_city").value = data[0].senderCity;
			document.getElementById("Sender_disrict").value = data[0].senderDistrict;
			document.getElementById("Sender_addr").value = data[0].senderAddr;
			document.getElementById("content").value = data[0].content;

			if (data[0].status === 1) {
				$('#Pack_move_button').text('移至郵寄箱')
			} else if (data[0].status === 2) {
				$('#Pack_move_button').text('移至暫存箱')
			}

			if (data[0].cardId !== null)
				cardToBasket(data[0].cardId)

			if (data[0].fontId !== null)
				fontToBasket(data[0].fontId)

			giftsToBasket(id)
		})

	$('#Pack_move_button').off('click')
	$('#Pack_move_button').on('click', function() {
		movePack(id)
//		window.location.reload() 
	})

	$('#Pack_update_button').off('click')
	$('#Pack_update_button').on('click', function() {
		updatePack(id)
//		window.location.reload() 
	})

}

function cardToBasket(id) {
	fetch('/her/api/admin/card?id=' + id, {
			method: 'GET'
		})
		.then((response) => (response.json()))
		.then((result) => {
			const cardData = result.data.card[0];
			renderBasketCardBoxView(cardData);
		})
}

function fontToBasket(id) {
	fetch('/her/api/admin/font?id=' + id, {
			method: 'GET'
		})
		.then((response) => (response.json()))
		.then((result) => {
			const fontData = result.data.font[0];
			renderBasketFontBoxView(fontData);
		})
}

function giftsToBasket(packId) {

	fetch('/her/api/user/packgift?id=' + packId, {
			method: 'GET'
		})
		.then((response) => response.json())
		.then((result) => {
			const packgifts = result.data
			console.log(packgifts)

			let giftsData = []

			packgifts.map((packgift) => {
				fetch(serverUrl + '/api/user/gift?id=' + packgift.giftId, {
						method: 'GET'
					})
					.then((response) => response.json())
					.then((result) => {
						return giftData = {
							quantity: packgift.giftQuantity,
							...result.data.gift[0]
						}
					})
					.then((giftData) => {
						giftsData.push(giftData)

						renderBasketGiftBoxView(giftsData)
					})
			})
		})
}

function redirectOrdering() {
	window.open(webapp + '/views/front/member_page/ordering.jsp', '_self')
}

function getCookie(cookieName) {
	var name = cookieName + "=";
	var ca = document.cookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i]; //test=123
		//這個while是為了讓取出來的cookie前面不要有空格
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		//c.indexOf(name) == -1 代表回傳第一個子字串 str 開始的的索引值
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}
