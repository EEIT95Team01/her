$(function() {
	const id = window.location.hash.slice(1, 13)
	console.log(id)
	const prefix = id.charAt( 0 )
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



	return fetch('/her/api/admin/'+ type + '?id=' + id, {
		method: 'GET'
	})
	.then((response) => (response.json()))
	.then((result) => {
		const data = result.data;
		console.log( data);
		switch(prefix) {
		case 'c':
			$('#pName').html(data.card[0].name)
			$('#price').html(data.card[0].price)
			$('#addBasket').attr("onclick","addToBasket('"+data.card[0].id+"')")
			const price = data.card[0].price
			console.log(data.card[0].maxWordCount)
			const mw = $("<div></div>").text("最大容納字數   "+data.card[0].maxWordCount+"字").attr("class",'rec_text_60 chi_24')
			$('#mw').append(mw)
			$('#vc').html(data.card[0].viewCount)
			$('#sc').html(data.card[0].salesCount)
			$('#cover').attr("src",data.card[0].cover)
			$.each(data.tagIds,function(index,obj){
				console.log(obj);
				return fetch('/her/api/admin/tag?id='+obj, {
					method: 'GET'
				})
				.then((response) => (response.json()))
				.then((result) => {
//					console.log(result.data[0].name)
					var tag = $("<div></div>").text(result.data[0].name).attr("class",'sub_rec40');
					$('#taghere').append(tag)
//					if(result.data[0].discount<1){
//						var discont =$("<div></div>").text("特價 "+ price*result.data[0].discount+"元").css('color','red');
//						$('#onsale').append(discont)
//					}
				})
			})
			$.each(data.descriptions,function(index,obj){
				var word = $("<div class='rec_description640'></div>").text(obj.text)
				var text = $('<div></div>').append(word).attr('class',"box640")
				var img  = $("<img />").attr("src",obj.image).attr("width",'640')
				
				$('#descriptionBox').append(text,img)
			})
			
			break;
		case 'f':
			$('#pName').html(data.font[0].name)
			$('#price').html(data.font[0].price)
			console.log(data.font[0].maxWordCount)
			$('#mw').html(data.font[0].maxWordCount)
			$('#addBasket').attr("onclick","addToBasket('"+data.font[0].id+"')")
			$('#vc').html(data.font[0].viewCount)
			$('#sc').html(data.font[0].salesCount)
			$('#cover').attr("src",data.font[0].cover)
			$.each(data.tagIds,function(index,obj){
				console.log(obj);
				return fetch('/her/api/admin/tag?id='+obj, {
					method: 'GET'
				})
				.then((response) => (response.json()))
				.then((result) => {
//					console.log(result.data[0].name)
					var tag = $("<div></div>").text(result.data[0].name).attr("class",'sub_rec40');
					$('#taghere').append(tag)
				
				})
			})
			$.each(data.descriptions,function(index,obj){
				var word = $("<div class='rec_description640'></div>").text(obj.text)
				var text = $('<div></div>').append(word).attr('class',"box640")
				var img  = $("<img />").attr("src",obj.image).attr("width",'640')
				
				$('#descriptionBox').append(text,img)
			})
			break;
		case 'g':
			type = 'gift'
				$('#pName').html(data.gift[0].name)
				$('#price').html(data.gift[0].price)
				console.log(data.gift[0].maxWordCount)
				$('#mw').html(data.gift[0].maxWordCount)
				$('#addBasket').attr("onclick","addToBasket('"+data.gift[0].id+"')")
				$('#vc').html(data.gift[0].viewCount)
				$('#sc').html(data.gift[0].salesCount)
				$('#cover').attr("src",data.gift[0].cover)
				$.each(data.tagIds,function(index,obj){
					console.log(obj);
					return fetch('/her/api/admin/tag?id='+obj, {
						method: 'GET'
					})
					.then((response) => (response.json()))
					.then((result) => {
						console.log(result.data[0].name)
						var tag = $("<div></div>").text(result.data[0].name).attr("class",'sub_rec40');
						$('#taghere').append(tag)
						
					})
				})
				$.each(data.descriptions,function(index,obj){
					var word = $("<div ></div>").text(obj.text).attr('class','rec_description640');
					var text = $('<div></div>').append(word).attr('class',"box640");
					var img  = $("<img />").attr("src",obj.image).attr("width",'640');
					
					$('#descriptionBox').append(text,img)
				})
			break;
	}
	})
		
})

/*function renderProductView(result, type) {
	
	const data = result.data
	const type = type
	
	switch( type ) {
	  case 'card':
		  const {
			tagIds,
			descriptions,
			card
		} = data
	    break
	  case 'font':
		  const {
			tagIds,
			descriptions,
			font
		} = data
	    break
	  case 'gift':
		  const {
			tagIds,
			descriptions,
			font
		} = data
	    break
	}
	
	console.log(data)
	
	// 
	
	// get html container tag
}*/