<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test1</title>

</head>
<body>
<button id='setCookie'>Set Cookie</button>
<button id='getCookie'>Get Cookie</button>
<button id='clearCookie'>Clear Cookie</button>
</body>
<script>
	document.getElementById('setCookie').addEventListener('click', function() {
		document.cookie = "cookie=1234; expires=Thu, 17 Aug 2017 00:00:00 UTC;"
	})
	
	document.getElementById('getCookie').addEventListener('click', function() {
		console.log(document.cookie)
	})
	
	document.getElementById('clearCookie').addEventListener('click', function() {
		document.cookie = "cookie=; expires=Thu, 01 Jan 1970 00:00:00 UTC;"
	})
	
	function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

</script>
</html>