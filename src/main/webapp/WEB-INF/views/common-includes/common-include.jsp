<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="appContext" value="${pageContext.request.contextPath}" scope="application"/>
<script type="text/javascript">
	var appContext = "${appContext}";
</script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
if(typeof(jQuery) == "undefined") {	
	document.write("<script src='${appContext}/jquery-api/js/jquery.min.js'><\/script>");
	document.write("<script src='${appContext}/jquery-api/js/jquery-ui.min.js'><\/script>");
	document.write("<link rel='stylesheet' type='text/css' href='${appContext}/jquery-api/css/jquery-ui.css'><\/link>");
} else {	
	document.write("<script src='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js'><\/script>");
	document.write("<link rel='stylesheet' type='text/css' href='//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/smoothness/jquery-ui.css'><\/link>");	
}
</script>
<script src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery.blockUI/2.66.0-2013.10.09/jquery.blockUI.min.js"></script>	
<script src="//code.highcharts.com/highcharts.js"></script>
<script src="//code.highcharts.com/modules/exporting.js"></script>
<script type="text/javascript"
	src="${appContext}/common-js/global.js"></script>
<link rel="stylesheet" href="//cdn.datatables.net/plug-ins/725b2a2115b/integration/jqueryui/dataTables.jqueryui.css" />
<link rel="stylesheet" type="text/css" href="${appContext}/common-css/forms_popup.css">
<link rel="stylesheet" type="text/css" href="${appContext}/common-css/common.css">
<link rel="stylesheet" type="text/css" href="${appContext}/dropdown/css/style.css">
<link rel="stylesheet" type="text/css" href="${appContext}/dropdown/css/fontello.css">
<link rel="stylesheet" type="text/css" href="${appContext}/dropdown/css/dzyngiri.css">