<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${appContext}/kt/js/kt.js"></script>
<c:if test="${access ne '2'}">

<div id="button_actions_kt" align="right"
	style="margin-top: 8px; padding: 10px; border-bottom: 1px solid #f90">
	<button id="export_xls">EXPORT TO EXCEL</button>
	<button id="chart_kt">GENERATE CHART</button>&emsp;&emsp;
	<button id="create_kt">CREATE NEW ENTRY</button>
	<button id="edit_kt">EDIT ENTRY</button>
	<button id="delete_kt">REMOVE ENTRY</button>	
</div>
</c:if>