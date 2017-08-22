$(function() {
	const join= $('#Member_join_button');

	join.on('click', joinMember);

})

function joinMember() {
	const fetchUrl = serverUrl + '/api/member/member'
	
	const email = $('#Email').val();
	const password = $('#Password').val();
	const confirm = $('#Confirm').val();
	
	if(password!=confirm){
		alert("密碼不相符!");
		return;
	}
	
	const jsonData = {
			email: email,
			password: password
		}
	
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
			const memberId = result.data[0].id;
			creatCookie("memberId",memberId,10);
			alert("新增成功!");
			window.location.replace(webapp + '/views/front/home_page.jsp');
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
