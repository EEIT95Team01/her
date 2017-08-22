$(function() {
	/* member_main_box */
	$('#Member_main_box').hide()

	$('#Member_nav_bar a').on('click', showMemberMainBox)

	$(window).on('hashchange', showMemberMainBox);
})

const baseUrl = serverUrl + '/api/member'

function getMemberContent() {
	// get memberId from session ? from cookie ?
	const memberId = 'm01701010001'

	// api ?
	const fetchUrl = baseUrl + '?id=' + memberId
	console.log(fetchUrl)

	/*
	const memberObject = fetch(fetchUrl, {
		method: 'GET'
	})
	.then((response) => response.json())
	*/


	const memberObject = {
		id: 'm01701010001',
		email: 'jenny@gamil.com',
		// password: '' -> DO NOT send password back
		name: 'Hana',
		phone: '0987654321',
		city: '台北市',
		district: '文山區',
		addr: '政大路',
		birthday: '1993-05-15',
	}

	const memberContent = `
		<form
			id='Member'
			class='js_container block flex_block'>
			<div class='block40 flex_spacebetween'>
				<div class='rec_text_40'>基本資料</div>
				<div class='rec40'>
					<button id='Member_update_button'
									type='button'
									class='button_roundcorner chi_16_30 bgc_green'>儲存修改</button>
				</div>
			</div>
			<div class='block40 flex_left'>
				<label
					for='Member_name'
					class='rec_lable'>姓名</label>
				<input
					id='Member_name'
					name='member_name'
					class='rec_input220 border chi_16_30'
					value=${memberObject.name}>
			</div>
			<div class='block40 flex_left'>
				<label
					for='Member_birthday'
					class='rec_lable'>生日</label>
				<input
					id='Member_birthday'
					name='member_birthday'
					class='rec_input220 border chi_16_30'
					value=${memberObject.birthday}>
			</div>
			<div class='block40 flex_left'>
				<label
					for='Member_phone'
					class='rec_lable'>手機</label>
				<input
					id='Member_phone'
					name='member_phone'
					class='rec_input220 border chi_16_30'
					value=${memberObject.phone}>
			</div>

			<div class='block40 flex_left'>
				<label for='Member_city'
					   class='rec_lable'>地址</label>
				<div id='Member_postal_code'
					 name='sender_postal_code'
					 class='rec_digit chi_16_20'></div>
				<input
					id='Member_city'
					name='sender_city'
					class='rec_input113 border chi_16_30'
					value=${memberObject.city} />
				<input
					id='Member_disrict'
					name='sender_disrict'
					class='rec_input113 border chi_16_30'
					value=${memberObject.district} />
			</div>

			<div class='block40 flex_left'>
				<div class='rec_lable'></div>
				<input
					id='Member_addr'
					name='member_addr'
					class='rec_input580 border chi_16_30'
					value=${memberObject.addr} />
			</div>
			<div class='block40 flex_left'>
				<label
					for='Member_email'
					class='rec_lable'>E-mail</label>
				<input
					id='Member_email'
					name='member_email'
					class='rec_input580 border chi_16_30'
					value=${memberObject.email}>
			</div>
			<div class='block20'></div>
			<div class='block40 flex_left'>
				<div class='rec_text_40'>變更密碼</div>
				<div class='rec40'>
				</div>
			</div>
			<div class='block40 flex_left'>
				<label
					for='Member_password'
					class='rec_lable'>目前密碼</label>
				<input
					id='Member_password'
					name='member_password'
					type='password'
					class='rec_input220 border chi_16_30'>
			</div>
			<div class='block40 flex_left'>
				<label
					for='Member_password_new'
					class='rec_lable'>新密碼</label>
				<input
					id='Member_password_new'
					name='member_password_new'
					type='password'
					class='rec_input220 border chi_16_30'>
			</div>
			<div class='block40 flex_left'>
				<label
					for='Member_password_confirm'
					class='rec_lable'>確認密碼</label>
				<input
					id='Member_password_confirm'
					name='member_password_confirm'
					type='password'
					class='rec_input220 border chi_16_30'>
			</div>
		</form>
	`

	return memberContent
}

function getCollectionContent() {

}

function getRecipientContent() {

}

function getOrderContent() {

}

function showMemberMainBox() {
	$('#Member_main_box').hide();

	let hash = window.location.hash;
	console.log(hash)

	let memberMainBoxContent

	switch(hash) {
		case '#member':
			console.log('#member')
			memberMainBoxContent = getMemberContent()
			break;
		case '#collection':
			console.log('#collection')
			memberMainBoxContent = getCollectionContent()
			break;
		case '#recipient':
			console.log('#recipient')
			memberMainBoxContent = getRecipientContent()
			break;
		case '#order':
			console.log('#order')
			memberMainBoxContent = getOrderContent()
			break;
	}

	$('#Member_main_box').html(memberMainBoxContent)

	$('#Member_main_box').fadeIn('slow');
}
