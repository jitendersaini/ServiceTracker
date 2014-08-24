<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/smoothness/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
</head>
<link rel="stylesheet" type="text/css" href="common-css/forms.css">
<body style="border-top: 8px solid #f90;margin: 0 auto;padding: 80px 0 0;width: 100%;">
<div>
	<div id="stylized" class="myform forms">
	<form id="frm" action="/beacons/action?create" method="post">	
	
		<h1>User Registration</h1>
		<p>User Registration Section</p>		
		<div>				
			<label for="username">Username* <span class="small">Type Username</span></label>		
			<input id="username" name="username" class="inputlarge" type="text" value="">			
		</div>
		<div>
			<label for="password">Password* <span class="small">Type Password</span></label>			
			<input id="password" name="password" class="inputlarge" type="password">
		</div>
		<div>
			<label for="confirmpassword">Confirm Password* <span class="small">Confirm Password</span></label>
			<input id="confirmpassword" name="confirmpassword" class="inputlarge" type="password">				
		</div>			
		<div class="divider"></div>		
		
		<h1>Personal Information</h1>
		<p>Personal Information Section</p>
		
		<label for="email">Email* <span class="small">Type your Email</span></label>		
		<input id="email" name="email" type="text">				
		
		<label for="gender">Gender*<span class="small">Select your Gender</span></label>		
		<input class="rdo" type="radio" id="male" name="radio" checked="checked"><label for="male" class="rdo_label">Male</label>
		<input class="rdo" type="radio" id="female" name="radio"><label for="female" class="rdo_label">Female</label>			  					
		<div class="divider"></div>
				
		<p></p>		
		<div style="float: right;">
			<button type="button" id="button_cancel" class="button_cancel ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span class="ui-button-text">Cancel</span></button>
			<button type="button" id="button_save" class="button_save ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span class="ui-button-text">Register</span></button>		
		</div>		
		<div class="spacer"></div>
	</form>
</div>
</div>
<script>
$("#button_cancel").button().click(function() {
	location.href = "${pageContext.request.contextPath}"+"/";
});
</script>
</body>
</html>