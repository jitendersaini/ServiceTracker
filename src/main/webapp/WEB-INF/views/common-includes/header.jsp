<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div id="header">
	<div id="welcome">Welcome ${sessionScope.firstName}&nbsp;${sessionScope.lastName}</div>
	<div id="logout">		
		<a href="logout">Logout</a>		
	</div>
	<div class="clear"></div>
	<h2>SERVICE INTRODUCTION TRACKER</h2>
	<div class="clear"></div>
</div>