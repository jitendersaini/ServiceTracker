<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div id="tabs">
	<ul>		
		<%-- <li><a href="${appContext}/admin/projects/action">Create Projects</a></li>
		<li><a href="${appContext}/admin/status/action">Create Status</a></li>
		<li><a href="${appContext}/admin/options/action">Create Options</a></li>
		<li><a href="${appContext}/admin/users/action">Create Users</a></li> --%>
		<c:forEach items="${tabs}" var="v">
			<li><a href="${appContext}/${v.tabURL}">${v.tabTitle}</a></li>
		</c:forEach>		
	</ul>
	<div style="margin-left: 10px; margin-right: 10px; margin-bottom: 8px;" id="jtable"></div>
	<div style="clear: both;"></div>
</div>
