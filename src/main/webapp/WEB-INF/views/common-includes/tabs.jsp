<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div id="tabs">	
	<ul>
		<c:forEach items="${tabs}" var="v">
			<li><a href="${appContext}/${v.tabURL}">${v.tabTitle}</a></li>
		</c:forEach>
		<%-- <li><a href="${appContext}/workenv/action">Work Env</a></li>
		<li><a href="${appContext}/kt/action">Knowledge Transition</a></li>
		<li><a href="#">Walkthrough</a></li>
		<li><a href="#">Release</a></li>
		<li><a href="#">Code Freeze</a></li>
		<li><a href="#">Testing</a></li>
		<li><a href="#">Support Scope</a></li>
		<li><a href="#">PGLS</a></li>
		<li><a href="#">Third Parties</a></li>
		<li><a href="#">Rehearsal</a></li>
		<li><a href="#">Access for AO</a></li>
		<li><a href="#">Process and Tools</a></li>
		<li><a href="#">Complete Status</a></li> --%>
	</ul>
	<div style="margin-left: 10px; margin-right: 10px; margin-bottom: 8px;" id="jtable"></div>
	<div style="clear: both;"></div>
</div>
