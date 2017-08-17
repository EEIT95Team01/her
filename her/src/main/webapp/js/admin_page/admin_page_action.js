$(function() {
	setApiButtons()
	setImageApiButtons()
	setProductApis()
})
window.$ = $

const apis = {
	"#Tag_insert_button": {
		apiPath: '/api/admin/tag',
		method: 'POST',
		getData: {
			name: () => $('#Tag_manage_name').val(),
			discount: () => $('#Tag_manage_discount').val()
		}
	}, "#Tag_update_button": {
		apiPath: '/api/admin/tag',
		method: 'PUT',
		getData: {
			id: () => $('#Tag_manage_id').val(),
			name: () => $('#Tag_manage_name').val(),
			discount: () => $('#Tag_manage_discount').val(),
		}
	}, "#Tag_delete_button": {
		apiPath: '/api/admin/tag',
		method: 'DELETE',
		getData: {
			id: () => $('#Tag_manage_id').val()
		}
	}, "#Tag_select_button": {
		apiPath: '/api/admin/tag',
		method: 'GET',
		getData: {
			id: () => $('#Tag_select_id').val(),
			name: () => $('#Tag_select_name').val(),
			lowDiscount: () => $('#Tag_select_discount_slider').slider('values', 0)/100,
			highDiscount: () => $('#Tag_select_discount_slider').slider('values', 1)/100
		}
	}, "#Member_select_button": {
		apiPath: '/api/admin/member',
		method: 'GET',
		getData: {
			id: () => $("#Member_select_id").val(),
			email: () => $('#Member_select_email').val()
		}
	}, "#Pack_select_button": {
		apiPath: '/api/admin/pack',
		method: 'GET',
		getData: {
			id: () => $('#Pack_select_id').val(),
			name: () => $('#Pack_select_nanme').val(),
			memberId: () => $('#Pack_select_memberId').val(),
			lowSum: () => $('#Pack_select_sum_slider').slider('values', 0),
			highSum: () => $('#Pack_select_sum_slider').slider('values', 1),
			beginDateMailed: () => $('#Pack_select_beginDateMailed').val(),
			endDateMailed: () => $('#Pack_select_endDateMailed').val(),
			status: () => $('#Pack_select_').val()
		}
	}, "#Orderform_select_button": {
		apiPath: '/api/admin/orderform',
		method: 'GET',
		getData: {
			id: () => $('#Orderform_select_id').val(),
			memberId: () => $('#Orderform_select_memberId').val(),
			beginDateCreated: () => $('#Orderform_select_beginDateCreated').val(),
			endDateCreated: () => $('#Orderform_select_endDateCreated').val(),
			paymentStatus: () => $('#Orderform_select_paymentStatus').val()
		}
	}, "#Ad_delete_button": {
		apiPath: '/api/admin/ad',
		method: 'DELETE',
		getData: {
			id: () => $('#Ad_manage_id').val()
		}
	}, "#Ad_select_button": {
		apiPath: '/api/admin/ad',
		method: 'GET',
		getData: {
			id: () => $('#Ad_select_id').val(),
			name: () => $('#Ad_select_name').val(),
			beginDate: () => ('#Ad_select_beginDate'),
			endDate: () => ('#Ad_select_endDate'),
		}
	}, "#Writer_delete_button": {
		apiPath: '/api/admin/writer',
		method: 'DELETE',
		getData: {
			id: () => $('#Writer_manage_id').val()
		}
	}, "#Writer_select_button": {
		apiPath: '/api/admin/writer',
		method: 'GET',
		getData: {
			id: () => $('#Writer_select_id').val(),
			name: () => $('#Writer_select_name').val()
		}
	}, "#Card_select_button": {
		apiPath: '/api/admin/card',
		method: 'GET',
		getData: {
			id: () => $('#Card_select_id').val(),
			name: () => $('#Card_select_name').val(),
			lowPrice: () => $('#Card_select_price_slider').slider('values', 0),
			highPrice: () => $('#Card_select_price_slider').slider('values', 1),
			lowCost: () => $('#Card_select_cost_slider').slider('values', 0),
			highCost: () => $('#Card_select_cost_slider').slider('values', 1),
			manufacturer: () => $('#Card_select_manufacturer').val(),
			status: () => $('#Card_select_status').val()
		}
	}, "#Font_select_button": {
		apiPath: '/api/admin/font',
		method: 'GET',
		getData: {
			id: () => $('#Font_select_id').val(),
			name: () => $('#Font_select_name').val(),
			lowPrice: () => $('#Font_select_price_slider').slider('values', 0),
			highPrice: () => $('#Font_select_price_slider').slider('values', 1),
			writerId: () => $('#Font_select_writer').val(),
			status: () => $('#Font_select_status').val()
		}
	}, "#Gift_select_button": {
		apiPath: '/api/admin/gift',
		method: 'GET',
		getData: {
			id: () => $('#Gift_select_id').val(),
			name: () => $('#Gift_select_name').val(),
			lowPrice: () => $('#Gift_select_price_slider').slider('values', 0),
			highPrice: () => $('#Gift_select_price_slider').slider('values', 1),
			lowCost: () => $('#Gift_select_cost_slider').slider('values', 0),
			highCost: () => $('#Gift_select_cost_slider').slider('values', 1),
			manufacturer: () => $('#Gift_select_manufacturer').val(),
			status: () => $('#Gift_select_status').val()
		}
	}
}

const imageApis = {
	"#Writer_insert_button": {
		apiPath: '/api/admin/writer',
		method: 'POST',
		image: () => $('#Writer_cover').prop('files')[0],
		getData: {
			name: () => $('#Writer_manage_name').val(),
			description: () => $('#Writer_manage_description').val()
		}
	}, "#Writer_update_button": {
		apiPath: '/api/admin/writer',
		method: 'PUT',
		image: () => $('#Writer_cover').prop('files')[0],
		getData: {
			id: () => $('#Writer_manage_id').val(),
			name: () => $('#Writer_manage_name').val(),
			description: () => $('#Writer_manage_description').val()
		}
	}, "#Ad_insert_button": {
		apiPath: '/api/admin/ad',
		method: 'POST',
		image: () => $('#Ad_image').prop('files')[0],
		getData: {
			name: () => $('#Ad_manage_name').val(),
			beginDate: () => $('#Ad_manage_beginDate').val(),
			endDate: () => $('#Ad_manage_endDate').val()
		}
	}, "#Ad_update_button": {
		apiPath: '/api/admin/ad',
		method: 'PUT',
		image: () => $('#Ad_image').prop('files')[0],
		getData: {
			id: () => $('#Ad_manage_id').val(),
			name: () => $('#Ad_manage_name').val(),
			beginDate: () => $('#Ad_manage_beginDate').val(),
			endDate: () => $('#Ad_manage_endDate').val()
		}
	}
}

const productApis = {
	'#Card_insert_button': {
		apiPath: '/api/admin/card',
		method: 'POST',
		image: () => $('#Card_cover').prop('files')[0],
		getData: {
			card: () => ({
				name: $('#Card_manage_name').val(),
				price: $('#Card_manage_price').val(),
				manufacturer: $('#Card_manage_manufacturer').val(),
				cost: $('#Card_manage_cost').val(),
				stock: $('#Card_manage_stock').val(),
				maxWordCount: $('#Card_manage_maxWordCount').val(),
				status: $('#Card_manage_status').val()
			}),
			tagIds: () => $('#Card_manage_tagNames_id').val(),
			descriptions: () => {
				const descriptionBoxes = $('#Card_manage_form').find('.js_description_box').toArray();
				return descriptionBoxes.reduce((acc, cur, currentIndex) => {
					const image = cur.getElementsByTagName('input')[0].files[0]
					const text = cur.getElementsByTagName('textarea')[0].value

					acc.push({
						cardId: ('#Card_manage_id').val(),
						orderNo: currentIndex + 1,
						image: image,
						text: text
					})
					return acc
				}, [])
			}
		}
	}, '#Card_update_button': {
		apiPath: '/api/admin/card',
		method: 'PUT',
		image: () => $('#Card_cover').prop('files')[0],
		getData: {
			card: () => ({
				id: $('#Card_manage_id').val(),
				name: $('#Card_manage_name').val(),
				price: $('#Card_manage_price').val(),
				manufacturer: $('#Card_manage_manufacturer').val(),
				cost: $('#Card_manage_cost').val(),
				stock: $('#Card_manage_stock').val(),
				maxWordCount: $('#Card_manage_maxWordCount').val(),
				status: $('#Card_manage_status').val()
			}),
			tagIds: () => $('#Card_manage_tagNames_id').val(),
			descriptions: () => {
				const descriptionBoxes = $('#Card_manage_form').find('.js_description_box').toArray();
				return descriptionBoxes.reduce((acc, cur, currentIndex) => {
					const image = cur.getElementsByTagName('input')[0].files[0]
					const text = cur.getElementsByTagName('textarea')[0].value

					acc.push({
						cardId: ('#Card_manage_id').val(),
						orderNo: currentIndex + 1,
						image: image,
						text: text
					})
					return acc
				}, [])
			}
		}
	}, '#Font_insert_button': {
		apiPath: '/api/admin/font',
		method: 'POST',
		image: () => $('#Font_cover').prop('files')[0],
		getData: {
			font: () => ({
				name: $('#Font_manage_name').val(),
				price: $('#Font_manage_price').val(),
				writerId: $('#Font_manage_writer').val(),
				status: $('#Font_manage_status').val()
			}),
			tagIds: () => $('#Font_manage_tagNames_id').val(),
			descriptions: () => {
				const descriptionBoxes = $('#Font_manage_form').find('.js_description_box').toArray();
				return descriptionBoxes.reduce((acc, cur, currentIndex) => {
					const image = cur.getElementsByTagName('input')[0].files[0]
					const text = cur.getElementsByTagName('textarea')[0].value

					acc.push({
						fontId: ('#Font_manage_id').val(),
						orderNo: currentIndex + 1,
						image: image,
						text: text
					})
					return acc
				}, [])
			}
		}
	}, '#Font_update_button': {
		apiPath: '/api/admin/font',
		method: 'PUT',
		image: () => $('#Font_cover').prop('files')[0],
		getData: {
			font: () => ({
				id: $('#Font_manage_id').val(),
				name: $('#Font_manage_name').val(),
				price: $('#Font_manage_price').val(),
				writerId: $('#Font_manage_writer').val(),
				status: $('#Font_manage_status').val()
			}),
			tagIds: () => $('#Font_manage_tagNames_id').val(),
			descriptions: () => {
				const descriptionBoxes = $('#Font_manage_form').find('.js_description_box').toArray();
				return descriptionBoxes.reduce((acc, cur, currentIndex) => {
					const image = cur.getElementsByTagName('input')[0].files[0]
					const text = cur.getElementsByTagName('textarea')[0].value

					acc.push({
						fontId: ('#Font_manage_id').val(),
						orderNo: currentIndex + 1,
						image: image,
						text: text
					})
					return acc
				}, [])
			}
		}
	}, '#Gift_insert_button': {
		apiPath: '/api/admin/gift',
		method: 'POST',
		image: () => $('#Gift_cover').prop('files')[0],
		getData: {
			gift: () => ({
				name: $('#Gift_manage_name').val(),
				price: $('#Gift_manage_price').val(),
				manufacturer: $('#Gift_manage_manufacturer').val(),
				cost: $('#Gift_manage_cost').val(),
				stock: $('#Gift_manage_stock').val(),
				status: $('#Gift_manage_status').val()
			}),
			tagIds: () => $('#Gift_manage_tagNames_id').val(),
			descriptions: () => {
				const descriptionBoxes = $('#Gift_manage_form').find('.js_description_box').toArray();
				return descriptionBoxes.reduce((acc, cur, currentIndex) => {
					const image = cur.getElementsByTagName('input')[0].files[0]
					const text = cur.getElementsByTagName('textarea')[0].value

					acc.push({
						giftId: ('#Gift_manage_id').val(),
						orderNo: currentIndex + 1,
						image: image,
						text: text
					})
					return acc
				}, [])
			}
		}
	}, '#Gift_update_button': {
		apiPath: '/api/admin/gift',
		method: 'PUT',
		image: () => $('#Gift_cover').prop('files')[0],
		getData: {
			gift: () => ({
				id: $('#Gift_manage_id').val(),
				name: $('#Gift_manage_name').val(),
				price: $('#Gift_manage_price').val(),
				manufacturer: $('#Gift_manage_manufacturer').val(),
				cost: $('#Gift_manage_cost').val(),
				stock: $('#Gift_manage_stock').val(),
				status: $('#Gift_manage_status').val()
			}),
			tagIds: () => $('#Gift_manage_tagNames_id').val(),
			descriptions: () => {
				const descriptionBoxes = $('#Gift_manage_form').find('.js_description_box').toArray();
				return descriptionBoxes.reduce((acc, cur, currentIndex) => {
					const image = cur.getElementsByTagName('input')[0].files[0]
					const text = cur.getElementsByTagName('textarea')[0].value

					acc.push({
						giftId: ('#Gift_manage_id').val(),
						orderNo: currentIndex + 1,
						image: image,
						text: text
					})
					return acc
				}, [])
			}
		}
	}
}

function setApiButtons() {
	Object.keys(apis).map(function(buttonKey) {
		const {
			apiPath,
			method,
			getData
		} = apis[buttonKey]

		$(buttonKey).click(function(e) {
			e.preventDefault()
			const jsonData = Object.keys(getData).reduce(function(acc, apiKey) {
				acc[apiKey] = getData[apiKey]()
				return acc
			}, {})

			if(method === "GET") {
				const baseUrl = serverUrl + apiPath + '?'
				const fetchUrl = Object.keys(jsonData).reduce(function(acc, data) {
					acc += data  + '=' + jsonData[data] + '&'
					return acc
				}, baseUrl)
				.slice(0, -1)
				console.log(fetchUrl)
				fetch(fetchUrl , {
					method: method
				})
				.then((response) => response.json())
				.then((result) => {
					let type = apiPath.substring(apiPath.lastIndexOf('/') + 1)

					let arrayOfData = result.data
					if(type === "card" || type === "font" || type === "gift") {
						arrayOfData = arrayOfData[type]
					}

					if(result.success && arrayOfData.length > 0) {
						$('.js_form_container').hide()
						const displayTable = $('#Display_table')

						displayTable.empty()
						displayTable.fadeIn('slow')

						const tableObjects = arrayOfData.reduce((acc, cur) => {
							acc.titles = Object.keys(cur)
							acc.content.push(Object.values(cur))
							return acc
						}, {titles: [], content: []})

						const getTheadContent = (titles) =>
							titles.reduce((acc, cur, index) => {
								if(index === 0)
									return (acc + '<th class="sorted ascending">' + cur + '</th>')
								else
									return (acc + '<th>' + cur + '</th>')
							}, '')

						const getTbodyContent = (content) =>
							content.reduce((acc, cur) => {

								const x = cur.reduce((acc, cur, index) => {
									if(index === 0 && (type === 'tag' || type === 'card' || type === 'writer' || type === 'font' || type === 'gift' || type === 'ad')) {
										return (acc + '<td><button class="js_action">' + cur + '</button></td>')
									} else
										return (acc + '<td>' + cur + '</td>')
								}
								, '')
								return (acc + '<tr>' + x + '</tr>')

							}, '')

						const tableContent = `
							<thead>
								<tr>${getTheadContent(tableObjects.titles)}</tr>
							</thead>
							<tbody>
								${getTbodyContent(tableObjects.content)}
							</tbody>
						`

						displayTable.append($(tableContent)).tablesort()
						
						$('.js_action').on('click', function() {
							type = type[0].toUpperCase() + type.substring(1)
							
							console.log(baseUrl + 'id=' + $(this).text())
							
							fetch(baseUrl + 'id=' + $(this).text(), {
								method: 'GET'
							})
							.then((response) => response.json())
							.then((result) => {
								window.location.replace(serverUrl + '/views/back/admin_page.jsp#' + type + '_manage_form')
								const arrayOfData = result.data[0]
								switch(type) {
								case 'Tag':
									$('#Tag_manage_id').val(arrayOfData.id)
									$('#Tag_manage_name').val(arrayOfData.name)
									$('#Tag_manage_discount').val(arrayOfData.discount)
									break;
								case 'Card':
									/*
									$('#Card_cover_preview').attr('src', arrayOrData.cover)
									$('#Card_manage_id').attr('src', arrayOrData.id)
									$('#Card_manage_name').attr('src', arrayOrData.name)
									$('#Card_manage_price').attr('src', arrayOrData.price)
									$('#Card_manage_manufacturer').attr('src', arrayOrData.manufacturer)
									$('#Card_manage_cost').attr('src', arrayOrData.cost)
									$('#Card_manage_stock').attr('src', arrayOrData.stock)
									$('#Card_manage_maxWordCount').attr('src', arrayOrData.maxWordCount)
									*/
								}
							})
						})

					} else {
						alert('查無結果')
					}
				})
			} else if(method === "DELETE") {
				const baseUrl = serverUrl + apiPath + '?'
				const fetchUrl = Object.keys(jsonData).reduce(function(acc, data) {
					acc += data  + '=' + jsonData[data] + '&'
					return acc
				}, baseUrl)
				.slice(0, -1)
				console.log(fetchUrl)
				fetch(fetchUrl , {
					method: method
				})
				.then((response) => response.json())
				.then((result) => {
					if(result.success) {
						alert('刪除成功')
					} else {
						alert('刪除失敗')
					}
				})
			} else {
				const fetchUrl = serverUrl + apiPath
				fetch(fetchUrl, {
					method: method,
					headers: {
						'Content-Type': 'application/json',
					},
					body: JSON.stringify(jsonData)
				})
				.then((response) => response.json())
				.then((result) => console.log(result))
			}
		})
	})
}

function setImageApiButtons() {
	Object.keys(imageApis).map(function(buttonKey) {
		const {
			apiPath,
			method,
			image: getImage,
			getData
		} = imageApis[buttonKey]

		$(buttonKey).click(function(e) {
			e.preventDefault()
			const jsonData = Object.keys(getData).reduce(function(acc, apiKey) {
				acc[apiKey] = getData[apiKey]()
				return acc
			}, {})

			let formData = new FormData()
			let cover_url

			formData.append('image', getImage())

			fetch(imgurUrl, {
				method: 'POST',
				body: formData,
				headers: {
					'Authorization': 'Client-ID 5ca1bdf91c78c80'
				}
			})
			.then((response) => response.json())
	    .then((result) => result.data.link)
	    .then((link) => {
	    	jsonData['cover'] = link

		    const fetchUrl = serverUrl + apiPath
				fetch(fetchUrl, {
					method: method,
					headers: {
						'Content-Type': 'application/json',
					},
					body: JSON.stringify(jsonData)
				})
				.then((response) => response.json())
				.then((result) => console.log(result))
	    })
		})
	})
}

function getImageUrl(imageFile) {
	const formData = new FormData()

	formData.append('image', imageFile)

	return fetch(imgurUrl, {
		method: 'POST',
		body: formData,
		headers: {
			'Authorization': 'Client-ID 5ca1bdf91c78c80'
		}
	})
	.then((response) => response.json())
  .then((result) => result.data.link)
}

function setProductApis() {
	Object.keys(productApis).map(function(buttonKey) {
		const {
			apiPath,
			method,
			image: getImage,
			getData
		} = productApis[buttonKey]

		$(buttonKey).click(function(e) {
			e.preventDefault()
			const jsonData = Object.keys(getData).reduce(function(acc, apiKey) {
				acc[apiKey] = getData[apiKey]()
				return acc
			}, {})

			const imageUrlArray = jsonData.descriptions.reduce((acc, cur) => {
				acc.push(getImageUrl(cur.image))
				return acc
			}, [])

			let coverUrl
			if(getImage() !== undefined)
				coverUrl = getImageUrl(getImage())

			Promise.all(imageUrlArray.concat(coverUrl))
			.then((listOfImageUrl) => {
				const {
					tagIds,
					descriptions,
					...productObject
				} = jsonData

				const productKey = Object.keys(productObject)[0]
				return {
					[productKey]: {
						cover: listOfImageUrl.pop(),
						...jsonData[productKey]
					},
					tagIds: tagIds.split(', ').filter((x) => (x != "")),
					description: descriptions.map((description, index) => {
						description.image = listOfImageUrl[index]
						return description
					}),
				}
			}).then((jsonDataWithUrls) => {
				const fetchUrl = serverUrl + apiPath
				fetch(fetchUrl, {
					method: method,
					headers: {
						'Content-Type': 'application/json',
					},
					body: JSON.stringify(jsonDataWithUrls)
				})
				.then((response) => response.json())
				.then((result) => console.log(result))
			})
		})
	})
}

/*
function handleResponse(method, response) {
	const success = response.success
	console.log(success)
	switch(method) {
		case "POST":
			if(success) {

			} else {
				alert('新增失敗')
			}
			break
		case "PUT":
		case "DELETE":
		case "GET"
	}
}
*/
