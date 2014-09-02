<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="dialog-form" title="${title}">
	<form:form modelAttribute="${attr}" id="frm" method="post">
		<div id="stylized" class="myformPopup forms" style="margin: 10px;">
			<h1>Operations</h1>
			<p>Operations Details</p>

			<form:label for="name" path="name">Operation Name* <span
					class="small">Add Operation Name</span>
			</form:label>
			<form:input path="name" />

			<div class="divider"></div>

			<div class="spacer"></div>
		</div>
		<form:hidden path="id" />		
		<fmt:formatDate value='${op.createdDate}' type='both' var="dt" />
		<form:hidden path="createdDate" value="${dt}" />
	</form:form>
</div>