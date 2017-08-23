$(function() {
	
	var memberId = getCookie("memberId")
	
	console.log(memberId)
	
	if(memberId){
		 $("#Login").css("display","none");
		 $("#Logout").css("display","block");
	}else{
		$("#Login").css("display","block");
		 $("#Logout").css("display","none");
	}
	
	
	const logoutButton = $('#Logout')
	
	logoutButton.on('click', handleLogout)
	
})

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
function findMemberId(name){
	const memberId = getCookie("memberId")

	if(memberId === "") {
		console.log('not login')
		window.open(webapp + '/views/front/member_page/login.jsp', '_self')
	}else if(name=="pack"){
	window.open(webapp + '/views/front/member_page/pack_page.jsp', '_self')
	}
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

function handleLogout(){
	eraseCookie("memberId")
	location.reload();
}