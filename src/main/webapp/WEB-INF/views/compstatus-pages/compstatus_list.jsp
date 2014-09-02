<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript" src="${appContext}/compstatus/js/highcharts.js"></script>
<script type="text/javascript" src="${appContext}/compstatus/js/exporting.js"></script>
<script type="text/javascript" src="${appContext}/compstatus/js/compstatus.js"></script>

<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

<script>
var mainArr = new Array();
var arr = new Array();
</script>

<c:forEach items="${map}" var="v" varStatus="status">
	<script>	
		arr = new Array();
		arr.push("${v.key}");
		arr.push(Number("${v.value}"));
		mainArr.push(arr);
	</script>
</c:forEach>

<script>
generatePieChart('container',mainArr);
</script>