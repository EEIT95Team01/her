$(function() {
	setHomePage()
})



const baseUrl = serverUrl + '/api/front'
const recommendApis = ['/card/T2', '/font/T1', '/gift/T4']
const sizes = [220, 220, 220, 160, 160, 160, 160]
const recommendBoxes = $('#js_recommend')

const newApi = ['/card/T3', '/font/T2', '/gift/T5']

function setHomePage() {
	setRecommend()
	setAd()
	setNew()
}

	function setRecommend() {
		recommendApis.map((api, index) => {
			fetch(baseUrl + api, {
				method: "GET"
			})
			.then((response) => response.json())
			.then((result) => {
				result.data.reduce((acc, cur, index) => {
					const id = cur.id
					const cover = cur.cover

					const size = sizes[index]

					let product = `
						<div class='square${size}'>
							<input
								type='hidden'
								value='${id}' />
							<img src='${cover}'
								 width='${size}'
								 height='${size}'>
							<button type='button'
									class='button_circle bgi_add_to_collection'></button>
							<button type='button'
									class='button_circle bgi_add_to_basket'></button>
						</div>
					`
					return recommendBoxes.append(product)
				}, recommendBoxes)
			})
		})

	}
