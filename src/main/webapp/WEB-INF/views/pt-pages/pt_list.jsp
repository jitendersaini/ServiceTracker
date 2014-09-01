<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${appContext}/pt/js/pt.js"></script>
<c:if test="${access ne '2'}">
<div id="button_actions_pt" align="right"
	style="margin-top: 8px; padding: 10px; border-bottom: 1px solid #f90">
	<button id="create_pt">CREATE NEW ENTRY</button>
	<button id="edit_pt">EDIT ENTRY</button>
	<button id="delete_pt">REMOVE ENTRY</button>
</div>
</c:if>