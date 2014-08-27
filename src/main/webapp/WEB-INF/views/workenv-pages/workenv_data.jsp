<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table id="cattable" class="display">
	<thead>
		<tr class="even">
			<th><div style="margin-left: 9px;" title="Select All"><input type="checkbox" id="selectAll" class="selectAll"></div></th>
			<th>LEAD TIME</th>
			<th>REQUIREMENTS</th>
			<th>RESPONSIBLE OPERATIONS</th>
			<th>PROJECTS</th>
			<th>START DATE</th>
			<th>END DATE</th>
			<th>PROGRESS</th>
			<th>STATUS</th>
			<th>DOCS</th>
			<th>% COMPLETION</th>
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
				<td>${v.startDate}</td>
				<td>${v.endDate}</td>
				<td>${v.progress}</td>
				<td>${v.status}</td>
				<td>${v.docs}</td>
				<td>${v.completion}</td>
				
											
				<%-- <td>${v.usersByCreatedBy.name}<input type="hidden" name="hidUserid" value="${v.usersByCreatedBy.id}"/></td>
				<td>${v.usersByModifiedBy.name}</td> 
				<td align="center"><fmt:formatDate value="${v.createdDate}" type="both"/></td>
				<td align="center"><fmt:formatDate value="${v.modifiedDate}" type="both"/></td>--%>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr class="even">
			<th></th>
			<th>LEAD TIME</th>
			<th>REQUIREMENTS</th>
			<th>RESPONSIBLE OPERATIONS</th>
			<th>PROJECTS</th>
			<th>START DATE</th>
			<th>END DATE</th>
			<th>PROGRESS</th>
			<th>STATUS</th>
			<th>DOCS</th>
			<th>% COMPLETION</th>
		</tr>
	</tfoot>
</table>

<script>
checkUncheckAll();
</script>