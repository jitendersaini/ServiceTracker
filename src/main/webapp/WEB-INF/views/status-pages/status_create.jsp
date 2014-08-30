<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="dialog-form" title="${title}">
<form:form modelAttribute="${attr}" id="frm" method="post">
   <div id="stylized" class="myformPopup forms" style="margin: 10px;">
		<h1>Status</h1>
		<p>Status Details</p>
		
		<form:label for="status" path="status">Status* <span class="small">Add New Status</span></form:label>		
		<form:input path="status"/>				
		
		<div class="divider"></div>
		
		<div class="spacer"></div>
</div>
</form:form>
</div>