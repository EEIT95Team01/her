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
	
	
	fetch(fetchUrl, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(jsonData)
	})
	.then((response) => response.json())
	.then((result) => {
		const success = result.success;
		console.log(typeof success);
		if(success==='true') {
//			const user = {
//					memberId: result.data[0].id
//				}
			const memberId = result.data[0].id;
			creatCookie("memberId",memberId,10);
			
//			const herCookie = getHer()
			window.history.go(-1);
//			return false;
		} else {
			alert(result.message);
		}
	
	})
	
}

function creatCookie(name,value,day){
	if(day){
		var date = new Date();
		date.setTime(date.getTime()+ (day*60*24*60*1000));
		var expires = "; expires="+ date.toGMTString();
			
	}else{
		var expires ="";
	}
	document.cookie =  name + "=" + value + expires + ";path=/";
}

function eraseCookie(name){
	creatCookie(name,"",-1)
}

function handleForget() {
	const email = $('#Email').val()
	
	const jsonData = {
		email: email
	}
	
	if(email===""){
		alert("請輸入Email");
		return;
	}
	console.log('email:' + email)
	console.log(JSON.stringify(jsonData))
	
	const fetchUrl = serverUrl + '/api/member/getPassword'

	fetch(fetchUrl, {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(jsonData)
	})
	.then((response) => response.json())
	.then((result) => {
		const success = result.success;
		console.log(typeof success);
		if(success==='true') {
			alert("密碼信已成功寄出，請至信箱收信！");			
			location.reload();
		} else {
			alert(result.message);
		}
	})
}


function handleLogout(){
	eraseCookie("memberId")
	window.location=webapp + '/views/front/home_page.jsp'
}