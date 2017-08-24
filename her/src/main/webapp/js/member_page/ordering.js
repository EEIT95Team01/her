$(function() {

	loadOrdering()

	$('#Packpage_return_button').on('click', returnToPackPage)

	$('#order_insert_button').on('click', insertOrder)

})

// 讀取郵寄箱內包裹
function loadOrdering() {
	const memberId = getCookie("memberId")

	const fetchUrl = serverUrl + '/api/user/pack?memberId=' + memberId + '&status=2'

	fetch(fetchUrl, {
		method: 'GET'
	})
	.then((response) => response.json())
	.then((result) => {
		const orderpacks = result.data
		
		const packContentArray = []
		
		orderpacks.map((orderpack, index) => {
			const packContent = `
				<div class='block flex_block'>
					<!-- title -->
					<div class='block40 flex_spacebetween'>
						<div class='rec_text_40'>${orderpack.name}｜${orderpack.dateMailed}</div>
						<div class='rec40 chi_20'>NT ${orderpack.sum}</div>
					</div>

					<div
						id='xxx${index}'
						class='block40 flex_left bgc_lightgray'>
						<div class='box550 text_align'>商品名稱</div>
						<div class='box90 text_align'>單價</div>
						<div class='box90 text_align'>數量</div>
						<div class='box90 text_align'>小計</div>
					</div>
	
					<!-- card 
					${getPackCardContent(orderpack.cardId)} -->
	
					<!-- font
					${getPackFontContent(orderpack.fontId)} -->
	
					<!-- gift
					${getPackGiftContent(orderpack.id)} -->
	
					<div class='block20'></div>
					<!-- recipient & sender -->
					<div class='box400'>
						<div class='block240'>
							<div class='block40 flex_left bgc_lightgray'>
								<div class='rec_lable'>收件人</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>姓名</div>
								<div class='rec40'>${orderpack.recipientName}</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>手機</div>
								<div class='rec40'>${orderpack.recipientPhone}</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>地址</div>
								<div class='rec40'>${orderpack.recipientCity}</div>
								<div class='rec_text_40'>${orderpack.recipientDistrict}</div>
							</div>
							<div class='block80 flex_left'>
								<div class='rec_lable'></div>
								<div class='rec_textarea286 chi_16_30'>${orderpack.recipientAddr}</div>
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
								<div class='rec40'>${orderpack.senderName}</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>手機</div>
								<div class='rec40'>${orderpack.senderPhone}</div>
							</div>
							<div class='block40 flex_left'>
								<div class='rec_lable'>地址</div>
								<div class='rec40'>${orderpack.senderCity}</div>
								<div class='rec_text_40'>${orderpack.senderDistrict}</div>
							</div>
							<div class='block80 flex_left'>
								<div class='rec_lable'></div>
								<div class='rec_textarea286 chi_16_30'>${orderpack.senderAddr}</div>
							</div>
						</div>
					</div>
					<!-- card content -->
					<div class='block'>
						<div class='block40 bgc_lightgray'>
							<div class='rec_lable'>卡片內容</div>
						</div>
						<div class='block100'>
							<div class='rec_textarea800 chi_16_30'>${orderpack.content}</div>
						</div>
					</div>
				</div>
				<div class='block20'></div>
			`

				$('#Ordering_box').append(packContent)
		})
		
			const mock = `
				<!-- card -->
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
				<!-- font -->
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
				<!-- gift -->
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
				`
				
			$('#xxx0').after(mock)
		
		
		
		
		/*
		orderpacks.map((orderpack, index) => {
			$('#xxx' + index).after(getPackCardContent(orderpack.cardId))
		})
		
		/*
		const orderingBoxView = renderOrderingBoxView(orderpacks)
		
		$('#Ordering_box').append(orderingBoxView)
		*/
	})
	
}

// 將郵寄箱內包裹資料，顯示於頁面中
function renderOrderingBoxView(orderpacks) {
	
	const getPackContent = (orderpack) => {

		return packContent = `
			<div class='block flex_block'>
				<!-- title -->
				<div class='block40 flex_spacebetween'>
					<div class='rec_text_40'>${orderpack.name}｜${orderpack.dateMailed}</div>
					<div class='rec40 chi_20'>NT ${orderpack.sum}</div>
				</div>
				<div class='block40 flex_left bgc_lightgray'>
					<div class='box550 text_align'>商品名稱</div>
					<div class='box90 text_align'>單價</div>
					<div class='box90 text_align'>數量</div>
					<div class='box90 text_align'>小計</div>
				</div>

				<!-- card -->
				${getPackCardContent(orderpack.cardId)}

				<!-- font -->
				${getPackFontContent(orderpack.fontId)}

				<!-- gift -->
				${getPackGiftContent(orderpack.id)}

				<div class='block20'></div>
				<!-- recipient & sender -->
				<div class='box400'>
					<div class='block240'>
						<div class='block40 flex_left bgc_lightgray'>
							<div class='rec_lable'>收件人</div>
						</div>
						<div class='block40 flex_left'>
							<div class='rec_lable'>姓名</div>
							<div class='rec40'>${orderpack.recipientName}</div>
						</div>
						<div class='block40 flex_left'>
							<div class='rec_lable'>手機</div>
							<div class='rec40'>${orderpack.recipientPhone}</div>
						</div>
						<div class='block40 flex_left'>
							<div class='rec_lable'>地址</div>
							<div class='rec40'>${orderpack.recipientCity}</div>
							<div class='rec_text_40'>${orderpack.recipientDistrict}</div>
						</div>
						<div class='block80 flex_left'>
							<div class='rec_lable'></div>
							<div class='rec_textarea286 chi_16_30'>${orderpack.recipientAddr}</div>
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
							<div class='rec40'>${orderpack.senderName}</div>
						</div>
						<div class='block40 flex_left'>
							<div class='rec_lable'>手機</div>
							<div class='rec40'>${orderpack.senderPhone}</div>
						</div>
						<div class='block40 flex_left'>
							<div class='rec_lable'>地址</div>
							<div class='rec40'>${orderpack.senderCity}</div>
							<div class='rec_text_40'>${orderpack.senderDistrict}</div>
						</div>
						<div class='block80 flex_left'>
							<div class='rec_lable'></div>
							<div class='rec_textarea286 chi_16_30'>${orderpack.senderAddr}</div>
						</div>
					</div>
				</div>
				<!-- card content -->
				<div class='block'>
					<div class='block40 bgc_lightgray'>
						<div class='rec_lable'>卡片內容</div>
					</div>
					<div class='block100'>
						<div class='rec_textarea800 chi_16_30'>${orderpack.content}</div>
					</div>
				</div>
			</div>
			<div class='block20'></div>
		`
	}
		
	return orderpacks.reduce((acc, orderpack) => {
		return acc += getPackContent(orderpack)
	}, '')

}



function getPackCardContent(cardId) {
	if(cardId !== null) {

		fetch(serverUrl + '/api/user/card?id=' + cardId, {
			method: 'GET'
		})
		.then((response) => response.json())
		.then((result) => {
			const cardData = result.data.card[0]
			
			return `
				<div class='block60 flex_left'>
					<div class='box550 flex_left'>
						<div class='square60 chi_32 text_align bgc_card'>C</div>
						<div class='square60'>
							<img
							 src='${cardData.cover}'
							 width=60
							 height=60 />
						</div>
						<div class='rec_text_60 chi_16_30'>${cardData.name}</div>
					</div>
					<div class='box90 flex_center'>$ ${cardData.price}</div>
					<div class='box90 flex_center'>x 1</div>
					<div class='box90 flex_center'>$ ${cardData.price}</div>
				</div>
			`
		})
	} else {
		return `
			<div class='block60 flex_left'>
				<div class='box550 flex_left'>
					<div class='square60 chi_32 text_align bgc_card'>C</div>
					<div class='square60'></div>
					<div class='rec_text_60 chi_16_30'></div>
				</div>
				<div class='box90 flex_center'></div>
				<div class='box90 flex_center'></div>
				<div class='box90 flex_center'></div>
			</div>
		`
	}
}

function getPackFontContent(fontId) {
	if(fontId !== null) {

		fetch(serverUrl + '/api/user/font?id=' + fontId, {
			method: 'GET'
		})
		.then((response) => response.json())
		.then((result) => {
			const fontData = result.data.font[0]

			return `
				<div class='block60 flex_left'>
					<div class='box550 flex_left'>
						<div class='square60 chi_32 text_align bgc_font'>C</div>
						<div class='square60'>
							<img
							 src='${fontData.cover}'
							 width=60
							 height=60 />
						</div>
						<div class='rec_text_60 chi_16_30'>${fontData.name}</div>
					</div>
					<div class='box90 flex_center'>$ ${fontData.price}</div>
					<div class='box90 flex_center'>x 1</div>
					<div class='box90 flex_center'>$ ${fontData.price}</div>
				</div>
			`
		})
	} else {
		return `
			<div class='block60 flex_left'>
				<div class='box550 flex_left'>
					<div class='square60 chi_32 text_align bgc_font'>F</div>
					<div class='square60'></div>
					<div class='rec_text_60 chi_16_30'></div>
				</div>
				<div class='box90 flex_center'></div>
				<div class='box90 flex_center'></div>
				<div class='box90 flex_center'></div>
			</div>
		`
	}
}

function getPackGiftContent(packId) {

	const fetchUrl = serverUrl + '/api/user/packgift?id=' + packId

	return fetch(fetchUrl, {
		method: 'GET'
	})
	.then((response) => response.json())
	.then((result) => {

		const packgifts = result.data
		if(packgifts.length > 0) {
			packgifts.reduce((acc, packgift) => {
				const giftId = packgift.giftId

				return fetch(serverUrl + '/api/user/gift?id=' + giftId, {
					method: 'GET'
				})
				.then((response) => response.json())
				.then((result) => {
					console.log(result.data)
					const giftData = result.data.gift[0]

					return acc += `
						<div class='block60 flex_left'>
							<div class='box550 flex_left'>
								<div class='square60 chi_32 text_align bgc_gift'>G</div>
								<div class='square60'>
									<img
									 src='${giftData.cover}'
									 width=60
									 height=60 />
								</div>
								<div class='rec_text_60 chi_16_30'>${giftData.name}</div>
							</div>
							<div class='box90 flex_center'>$ ${giftData.price}</div>
							<div class='box90 flex_center'>x 1</div>
							<div class='box90 flex_center'>$ ${giftData.price}</div>
						</div>
					`
				})

			}, '')
		} else {
			return `
				<div class='block'>
					<div class='block60 flex_left'>
						<div class='box550 flex_left'>
							<div class='square60 chi_32 text_align bgc_gift'>G</div>
							<div class='square60'>
								<div class='rec_text_60 chi_16_30'></div>
							</div>
						</div>
						<div class='box90 flex_center'></div>
						<div class='box90 flex_center'></div>
						<div class='box90 flex_center'></div>
					</div>
				</div>
			`
		}
	})
}

// 寄出包裹，新增訂單
function insertOrder() {
	
	const memberId = getCookie("memberId")

	const orderform = {
		memberId: memberId,
		paymentMethod: 1,
		paymentStatus: 2,
		note: ''
	}
	
	const fetchUrl = serverUrl + '/api/user/orderform'

	// insert order, update pack's status to 3
	fetch(fetchUrl, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(orderform)
	})
	.then((response) => response.json())
	.then((result) => {
		if(result.success === 'true') {

			alert('訂單成立')

			// 2 秒後跳轉回首頁
			setTimeout(function() {
				window.open(webapp + '/views/front/home_page.jsp', '_self')
			}, 2000)
		}
	})
}

function returnToPackPage() {
	window.open(webapp + '/views/front/member_page/pack_page.jsp', '_self')
}
