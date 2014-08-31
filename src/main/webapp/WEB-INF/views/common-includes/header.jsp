<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="access" value="${sessionScope.access}"/>
<div id="header">
	<div id="welcome">Welcome ${sessionScope.firstName}&nbsp;${sessionScope.lastName}</div>
	<div id="logout">		
		<a href="${appContext}/logout">Logout</a>		
	</div>
	<div class="clear"></div>
	<h2>GLOBAL E-COMMERCE ROLLOUT- SERVICE INTRODUCTION</h2>
	<div class="clear"></div>
</div>
<div id="dialog-mesg-common" title="Message" style="display: none;"></div>
<div id="dialog-confirm" title="Delete the record?"
		style="display: none;">
	<p>
		<span class="ui-icon ui-icon-alert"
			style="float: left; margin: 0 7px 20px 0;"></span>These entries will be
		permanently deleted and cannot be recovered. Are you sure?
	</p>
</div>