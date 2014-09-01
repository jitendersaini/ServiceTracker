<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${appContext}/pgls/js/pgls.js"></script>
<c:if test="${access ne '2'}">
<div id="button_actions_pgls" align="right"
	style="margin-top: 8px; padding: 10px; border-bottom: 1px solid #f90">
	<button id="create_pgls">CREATE NEW ENTRY</button>
	<button id="edit_pgls">EDIT ENTRY</button>
	<button id="delete_pgls">REMOVE ENTRY</button>
</div>
</c:if>