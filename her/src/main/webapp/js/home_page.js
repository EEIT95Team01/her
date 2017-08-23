$(function() {
	setHomePage()
})

const frontBaseUrl = serverUrl + '/api/front'
const recommendApis = ['/card?id=T2', '/font?id=T1', '/gift?id=T4']
const recommendSizes = ['220', '220', '160']

const adApi = '/ad'

const newApi = ['/card?id=T3', '/font?id=T2', '/gift?id=T5']
const newSize = '196'

function setRecommend() {
	recommendApis.map((api, index) => {
		fetch(frontBaseUrl + api, {
			method: "GET"
		})
		.then((response) => response.json())
		.then((result) => {
			const type = api.slice(1,5)
			const size = recommendSizes[index]
			const recommendBoxContent =
				result.data[type].reduce((acc, cur, index) => {
					const id = cur.id
					const cover = cur.cover

					let product = `
						<div class='square${size}'>
							<input
								type='hidden'
								value='${id}' />
							<img src='${cover}'
								 width='${size}'
								 height='${size}'
								 class='cursor'
								 onclick='viewSingleProduct("${id}")'>
							
							<button type='button'
									class='button_circle bgi_add_to_collection'></button>
							
							<button type='button'
									class='button_circle bgi_add_to_basket'
									onclick='addToBasket("${id}")'></button>
						</div>
					`
					return acc.concat(product)
				}, '')

			$('#js_recommend').append(recommendBoxContent)
		})
	})
}

function setAd() {
	console.log('setAd() is not ready')
	/*
	fetch(frontBaseUrl + adApi, {
		method: "GET"
	})
	.then((response) => response.json())
	.then((result) => {
		const adUrls =
			result.data.reduce((acc, cur, index) => {
				acc.push(cur.image)
				return acc
			}, [])

		console.log(adUrls)

		$('#js_ad').append("<img src='"+ adUrls[0] +"' width='340' height='400' />")

		let i = 0
		setInterval(function() {
			console.log(adUrls.length)
			const length = adUrls.length

			$('#js_ad img').attr('src', adUrls[i % length])

			i++
		}, 2000)
	})
	*/
}


function setNew() {
	newApi.map((api) => {
		fetch(frontBaseUrl + api, {
			method: "GET"
		})
		.then((response) => response.json())
		.then((result) => {
			const type = api.slice(1,5)
			const newBoxContent =
				result.data[type].reduce((acc, cur, index) => {
					const id = cur.id
					const cover = cur.cover

					const size = newSize

					let product = `
						<div class='square196'>
							<img src='${cover}'
								 width='${size}'
								 height='${size}'
								 onclick='viewSingleProduct("${id}")'>
							<button type='button'
									class='button_circle bgi_add_to_collection'></button>
							<button type='button'
									class='button_circle bgi_add_to_basket'></button>
						</div>
					`
					return acc.concat(product)
				}, '')

			$('#js_new').append(newBoxContent)
		})
	})
}

function setHomePage() {
	setRecommend()
	setAd()
	setNew()
}