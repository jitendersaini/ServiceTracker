<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../common-includes/common-include.jsp"></jsp:include>
<script type="text/javascript" src="${appContext}/dashboard/js/dashboard.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service Tracker</title>
</head>
<body>
	<jsp:include page="../common-includes/header.jsp"></jsp:include>
	<jsp:include page="../common-includes/tabs_admin.jsp"></jsp:include>
</body>
<jsp:include page="../common-includes/footer.jsp"></jsp:include>
<div class="data_container"></div>
</html>