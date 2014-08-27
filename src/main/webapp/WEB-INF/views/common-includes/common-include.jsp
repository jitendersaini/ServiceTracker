<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="appContext" value="${pageContext.request.contextPath}" scope="application"/>
<script type="text/javascript">
	var appContext = "<%=request.getContextPath()%>";
</script><script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- <script src="//cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script> -->
<script type="text/javascript"
	src="${appContext}/jquery-table/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="${appContext}/common-js/global.js"></script>
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/themes/smoothness/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.1/jquery-ui.min.js"></script>
<!-- <link rel="stylesheet" href="//cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css" /> -->
<link rel="STYLESHEET" type="text/css"
	href="${appContext}/jquery-table/css/demo_page.css" media="screen" />
<link rel="STYLESHEET" type="text/css"
	href="${appContext}/jquery-table/css/demo_table_jui.css" media="screen" />

<link rel="stylesheet" type="text/css" href="${appContext}/common-css/forms_popup.css">
<link rel="stylesheet" type="text/css" href="${appContext}/common-css/common.css">