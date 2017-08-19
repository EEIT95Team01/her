$(function() {
	const loginButton = $('#Member_login_button')
	
	const forgetButton = $('#Member_forget_button')
	
	loginButton.on('click', handleLogin)
	
	forgetButton.on('click', handleForget)
	
})

function handleLogin() {
	const email = $('#Email').val()
	const password = $('#Password').val()
	
	const jsonData = {
		email: email,
		password: password
	}
	
	console.log('email:' + email + ', password: ' + password)
	console.log(JSON.stringify(jsonData))
	
	const fetchUrl = serverUrl + '/api/member/login'
	
	/*
	fetch(fetchUrl, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(jsonData)
	})
	.then((response) => response.json())
	.then((result) => {
		const success = result.success*/
	
	const success = true
	
	const user = {
		memberId: 'm01708180001',
		emal: 'b00303037@gmail.com',
		name: 'abc'
	}
		if(success) {
			const herCookie = getHer()
			window.location.replace(webapp + '/views/front/home_page.jsp')
		} else {
			
		}
	/*
	})
	*/
}

function handleForget() {
	
}