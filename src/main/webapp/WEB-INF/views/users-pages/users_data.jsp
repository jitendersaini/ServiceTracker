<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table id="userstable" class="display">
	<thead>
		<tr class="even">
			<th><div style="margin-left: 9px;" title="Select All"><input type="checkbox" id="selectAll" class="selectAll"></div></th>
			<th>USERNAME</th>
			<th>EMAIL</th>
			<th>PROJECT</th>
			<th>CREATED DATE</th>
			<th>MODIF11IED DATE</th>			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listData}" var="v" varStatus="status">
			<tr class="even">
				<td width="1%" align="center"><input type="checkbox" id="rdo" class="rdo" name="rdo"
					value="${v.id}"></td>
				<td>${v.username}</td>
				<td>${v.email}</td>
				<td>${v.projects.projectName}</td>
				<td align="center"><fmt:formatDate value="${v.createdDate}" type="both"/></td>
				<td align="center"><fmt:formatDate value="${v.modifiedDate}" type="both"/></td>										
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr class="even">
			<th></th>
			<th>USERNAME</th>
			<th>EMAIL</th>
			<th>PROJECT</th>
			<th>CREATED DATE</th>
			<th>MODIF11IED DATE</th>
		</tr>
	</tfoot>
</table>

<script>
checkUncheckAll();
</script>