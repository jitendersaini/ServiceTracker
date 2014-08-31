<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${appContext}/workenv/js/workenv.js"></script>
<c:if test="${access ne '2'}">
<div id="button_actions" align="right"
	style="margin-top: 8px; padding: 10px; border-bottom: 1px solid #f90">
	<button id="create">CREATE NEW ENTRY</button>
	<button id="edit">EDIT ENTRY</button>
	<button id="delete">REMOVE ENTRY</button>
</div>
</c:if>