<script>	
	var referr = document.referrer;
	if(typeof(referr) != "undefined" && referr.indexOf("login") != -1) {
		window.location="login?invalidSession=true";
	} else {
		window.location="login";
	}
</script>