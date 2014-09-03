<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="dialog-form" title="${title}">
<form:form modelAttribute="${attr}" id="frm" method="post">
   <div id="stylized" class="myformPopup forms" style="margin: 10px;">
		<h1>Change Password</h1>
		<p>Change Your Password</p>
		
		<form:label for="password" path="password">Old Password* <span class="small">Type Old Password</span></form:label>		
		<form:password path="password"/>
		
		<form:label for="newpassword" path="newpassword">New Password* <span class="small">Type New Password</span></form:label>		
		<form:password path="newpassword"/>
		
		<form:label for="retypenewpassword" path="retypenewpassword">Retype Password* <span class="small">Retype New Password</span></form:label>		
		<form:password path="retypenewpassword"/>
		
		<div class="spacer"></div>
</div>
</form:form>
</div>