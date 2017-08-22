$(function(){
	var memberId = getCookie("memberId")
	//郵寄箱

		
	//暫存箱
		getStatus1(memberId);
		getStatus2(memberId);
		
	
		
	})
	
function renderBasketCardBoxView(cardData) {
	const basket_card_box = $('#Basket_card_box')
		
		const cardOrFontBoxContent = (cardData) => `
		<div class='square220'>
			<img src='${cardData.cover}'
				 width='220'
				 height='220' />
			<button
				type='button'
				class='button_circle bgi_remove_from_basket'
				onclick='removeFromBasket("${cardData.id}")'></button>
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
			<button
				type='button'
				class='button_circle bgi_remove_from_basket'
				onclick='removeFromBasket("${fontData.id}")'></button>
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
	
//	
//	<div class='block40 flex_spacebetween'>
//	<div class='rec_text_40'>To 黃</div>
//	<div class='rec_text_40'>$ 219</div>
//</div>
	
function getStatus1(memberId){
	return fetch('/her/api/user/pack?memberId=' + memberId+"&status=2", {
		method: 'GET'
	})
	.then((response) => (response.json()))
	.then((result) => {
		const data = result.data;
		$.each(data,function(index,obj){
			console.log(obj.name)
			console.log(obj.sum)
				var pack_name = $("<div></div>").text(obj.name).attr("class",'button_roundcorner chi_16_30 bgc_blue rec_text_40');
				var pack_sum = $("<div></div>").text(obj.sum).attr("class",'rec_text_40');
				var a=$("<a />").attr("onclick","getPackId('"+obj.id+"')").append(pack_name)
				var div = $("<div></div>").append(a,pack_sum).attr("class",'block40 flex_spacebetween')
				$('#status2').append(div)
		})
		})
	
}	

function getStatus2(memberId){
	return fetch('/her/api/user/pack?memberId=' + memberId+"&status=1", {
		method: 'GET'
	})
	.then((response) => (response.json()))
	.then((result) => {
		const data = result.data;
		$.each(data,function(index,obj){
			console.log("status=1,obj.name = "+obj.sum);
			var pack_name = $("<div></div>").text(obj.name).attr("class",'button_roundcorner chi_16_30 bgc_Status1 rec_text_40');
			var pack_sum = $("<div></div>").text(obj.sum).attr("class",'rec_text_40');
			var a=$("<a />").attr("onclick","getPackId('"+obj.id+"')").append(pack_name)
			var div = $("<div></div>").append(a,pack_sum).attr("class",'block40 flex_spacebetween')
			$('#status1').append(div)
			})
		})
}
	
	
function getPackId(id){
	return fetch('/her/api/user/packId?id='+id, {
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
		
		cardToBasket(data[0].cardId);
		fontToBasket(data[0].fontId)
		})
}
	
function cardToBasket(id){
	return fetch('/her/api/admin/card?id='+id, {
		method: 'GET'
	})
	.then((response) => (response.json()))
	.then((result) => {
		const cardData = result.data.card[0];
		renderBasketCardBoxView(cardData);
	})
}
function fontToBasket(id){
	return fetch('/her/api/admin/font?id='+id, {
		method: 'GET'
	})
	.then((response) => (response.json()))
	.then((result) => {
		const fontData = result.data.font[0];
		renderBasketFontBoxView(fontData);
	})
}


function getCookie(cookieName) {
	 var name = cookieName + "=";
	 var ca = document.cookie.split(';');
	 	for(var i=0; i<ca.length; i++) {
	 		var c = ca[i]; //test=123
	 		//這個while是為了讓取出來的cookie前面不要有空格
	 		while (c.charAt(0)==' '){
	 			c = c.substring(1);
	 		}
	 		//c.indexOf(name) == -1 代表回傳第一個子字串 str 開始的的索引值
	 		if (c.indexOf(name) == 0){
	    	  return c.substring(name.length,c.length);
	    	}
	 	}
	  return "";
}