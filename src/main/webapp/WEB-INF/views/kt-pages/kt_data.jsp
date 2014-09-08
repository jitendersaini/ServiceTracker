<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table id="kttable" class="display">
	<thead>
		<tr class="even">
			<th><div style="margin-left: 9px;" title="Select All"><input type="checkbox" id="selectAll" class="selectAll"></div></th>
			<th>LEAD TIME</th>
			<th>REQUIREMENTS</th>
			<th>RESP. OPERATIONS</th>
			<th>PROJECTS</th>
			<th>START DATE</th>
			<th>END DATE</th>
			<th>PROGRESS</th>
			<th>STATUS</th>
			<th>PRIORITY</th>
			<th>DOCS</th>
			<th>%</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listData}" var="v" varStatus="status">
			<tr class="even">
				<td width="1%" align="center"><input type="checkbox" id="rdo" class="rdo" name="rdo"
					value="${v.id}"></td>
				<td>${v.leadTime}</td>
				<td>${v.requirements}</td>				
				<td>${v.operations.name}</td>
				<td>${v.projects.projectName}</td>
				<td><fmt:formatDate value="${v.startDate}"/></td>
				<td><fmt:formatDate value="${v.endDate}"/></td>
				<td>${v.progress}</td>
				<td>${v.status.status}</td>
				<td>${v.priorities.priority}</td>
				<td>${v.docs}</td>
				<td>${v.completion} %</td>				
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr class="even">
			<th></th>
			<th>LEAD TIME</th>
			<th>REQUIREMENTS</th>
			<th>RESP. OPERATIONS</th>
			<th>PROJECTS</th>
			<th>START DATE</th>
			<th>END DATE</th>
			<th>PROGRESS</th>
			<th>STATUS</th>
			<th>PRIORITY</th>
			<th>DOCS</th>
			<th>%</th>
		</tr>
	</tfoot>
</table>

<script>
global.functions.checkUncheckAll();
</script>