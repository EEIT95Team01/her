$(function() {

	getMemberPacks()

  $("#Date_mailed").datepicker({ minDate: +10 })
		.datepicker("option", "changeMonth", true)
		.datepicker("option", "changeYear", true)
		.datepicker("option", "dateFormat", "yy-mm-dd");

})

function getMemberPacks() {
	const memberId = getCookie('her').memberId
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
