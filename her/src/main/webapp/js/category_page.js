$(function() {
	const type = $('body')[0].id

	setPage(type)
	$('#js_option').change(() => changeProducts(type))
	$('#js_name_button').click(() => changeProducts(type))
})

const userBaseUrl = serverUrl + '/api/user'
let currentTag = '0'

function setPage(type) {
	setTags()
	changeProducts(type)
}

function setTags() {
	console.log('setTags()')

	const userApi = '/tag'
	const fetchUrl = userBaseUrl + userApi
	console.log('fetchUrl: ' + fetchUrl)

	fetch(fetchUrl, {
		method: 'GET'
	})
	.then((response) => response.json())
	.then((result) => {
		const tagBoxContent =
			result.data.reduce((acc, cur) => {
				let tag = `
					<div class='block40'>
						<button
							class='js_tagId_button rec_text_40 chi_16_40 bgc_white'
							onclick='handleTagButtonClick(${cur.id})'>${cur.name}</button>
					</div>
				`
				return acc.concat(tag)
			}, '')

		$('#js_tagBox').append(tagBoxContent)
	})
}

function handleTagButtonClick(tagId) {
	currentTag = tagId
	changeProducts($('body')[0].id)
}

function changeProducts(type) {
	console.log('changeProducts(' + type + ')')

	let userApi = '/' + type

	const option = $('#js_option').val()
	const name = $('#js_name').val()
	const tagId = currentTag

	console.log('option: ' + option + ', name: ' + name + ',tagId: ' + tagId)

	userApi += ('?option=' + option)
	if(name.trim().length !== 0)
		userApi += ('&name=' + name)
	if(tagId !== '0')
		userApi += ('&tagId=' + tagId)

	const fetchUrl = userBaseUrl + userApi
	console.log('fetchUrl: ' + fetchUrl)

	fetch(fetchUrl, {
		method: 'GET'
	})
	.then((response) => response.json())
	.then((result) => {
		renderProductView(result.data[type])
	})
}

function renderProductView(arrayOfData) {

	const box = $('#js_productBox')
	box.empty()

	const productBoxContent = arrayOfData.reduce((acc, cur) => {

		const rec_category = `
			<div class='rec_category'>
					<div class="square190">
						<img
							src='${cur.cover}'
							width='190'
							height='190' 
							class='cursor'
							onclick='viewSingleProduct("${cur.id}")' />
            <button
            	type='button'
							class='button_circle bgi_add_to_collection'></button>
						<button
							type='button'
							class='button_circle bgi_add_to_basket'
							onclick='addToBasket("${cur.id}")'></button>
          </div>
          <div class='js_name rec_text_60 chi_16_30'>${cur.name}</div>
          <div class='js_price rec_text_40 flex_right'>$ ${cur.price}</div>
				</div>
		`
		return acc.concat(rec_category)
	}, '')

	box.append(productBoxContent)
}
