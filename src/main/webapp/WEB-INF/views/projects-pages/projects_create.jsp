<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="dialog-form" title="${title}">
<form:form modelAttribute="${attr}" id="frm" method="post">
   <div id="stylized" class="myformPopup forms" style="margin: 10px;">
		<h1>Projects</h1>
		<p>Projects Details</p>
		
		<form:label for="projectName" path="projectName">Projects* <span class="small">Add Project Name</span></form:label>		
		<form:input path="projectName"/>				
		
		<div class="divider"></div>
		
		<div class="spacer"></div>
</div>
</form:form>
</div>