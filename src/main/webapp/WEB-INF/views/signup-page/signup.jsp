<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/smoothness/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="common-js/global.js"></script>
<script type="text/javascript" src="signup/js/signup.js"></script>
<title>${title}</title>
</head>
<link rel="stylesheet" type="text/css" href="common-css/forms.css">
<body style="border-top: 8px solid #f90;margin: 0 auto;padding: 80px 0 0;width: 100%;">
<div>
	<div id="stylized" class="myform forms">
	<form:form id="frm" modelAttribute="user">
		<h1>User Registration</h1>
		<p>User Registration Section <span class="mandatory"></span></p>	
		<div>				
			<form:label for="username" path="username">Username* <span class="small">Type Username</span></form:label>		
			<form:input path="username" cssClass="inputlarge"/>			
		</div>
		<div>
			<form:label for="password" path="password">Password* <span class="small">Type Password</span></form:label>			
			<form:password path="password" cssClass="inputlarge"/>
		</div>
		<div>
			<label for="confirmpassword">Confirm Password* <span class="small">Confirm Password</span></label>
			<input id="confirmpassword" name="confirmpassword" class="inputlarge" type="password">				
		</div>			
		<div class="divider"></div>		
		
		<h1>Personal Information</h1>
		<p>Personal Information Section <span class="mandatory"></span></p>
		
		<form:label for="email" path="email">Email* <span class="small">Type your Email</span></form:label>		
		<form:input path="email"/>				
		
		<form:label for="firstName" path="firstName">First Name* <span class="small">Type your First Name</span></form:label>		
		<form:input path="firstName"/>
		
		<form:label path="lastName" for="lastName">Last Name* <span class="small">Type your Last Name</span></form:label>		
		<form:input path="lastName"/>
		
		<form:label path="gender" for="gender">Gender*<span class="small">Select your Gender</span></form:label>
		<form:radiobuttons path="gender" class="rdo" items="${rdoValues}"/>
		<%-- <form:radiobutton class="rdo" type="radio" id="male" name="radio" checked="checked"><label for="male" class="rdo_label">Male</label>
		<input class="rdo" type="radio" id="female" name="radio"><label for="female" class="rdo_label">Female</label> --%>
				  					
		<div class="divider"></div>
				
		<p></p>		
		<div style="float: right;">
			<button type="button" id="button_cancel" class="button_cancel ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span class="ui-button-text">Cancel</span></button>
			<button type="button" id="button_save" class="button_save ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"><span class="ui-button-text">Register</span></button>		
		</div>		
		<div class="spacer"></div>
	</form:form>
</div>
</div>
</body>
</html>