<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org">
<head>

<meta charset="UTF-8">

<title>Login - Service Tracker</title>
<link rel="stylesheet" type="text/css" href="login-css/reset.css">
<link rel="stylesheet" type="text/css" href="login-css/style.css">
</head>

<body>
	<div id="login">
		<div style="color: #807b6e; font-size: 24px; margin-top: 80px;text-transform: capitalize;">service introduction tracker</div>
		<form id="login_form">
			<div class="field_container">
				<input type="text" placeholder="Username / Email" required="required" id="username" name="username" value="admin">				
			</div>

			<div class="field_container">
				<input type="password" placeholder="Password" required="required" id="password" name="password" value="admin">
				<button id="sign_in_button">
					<span class="button_text">Sign In</span>
				</button>
			</div>

			<div id="sign_in_options" class="field_container">
				<div id="sign_in_alternatives_container">
					<span id="password_sign_in_option">or you can <a href="#"
						id="password_sign_in" class="login_link">sign in using a
							password</a></span>
				</div>
				<div id="remember_me_container">
					<input name="user[remember_me]" type="hidden" value="0"><input
						id="user_remember_me" name="user[remember_me]" type="checkbox"
						value="1"> <label class="login_link"
						for="user_remember_me" id="remember_me_label">stay signed
						in</label>
				</div>
				<div class="clearfix"></div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
		<div id="dont_have_an_account">
			<h2>
				Need to <a href="signup" class="login_link">sign up</a> for an account or
				<a href="#" id="forgot_password_link" class="login_link">reset</a>
				your password?
			</h2>
		</div>
	</div>

</body>

</html>