<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="dialog-form" title="${title}">
<form:form modelAttribute="${attr}" id="frm" method="post">
   <div id="stylized" class="myformPopup forms" style="margin: 10px;">
		<h1>Requirements</h1>
		<p>Requirements Details</p>
		
		<form:label for="requirements" path="requirements">Requirements* <span class="small">Add Requirements</span></form:label>		
		<form:input path="requirements"/>				
		
		<form:label for="operations.id" path="operations.id">Operations* <span class="small">Add Operations</span></form:label>		
		<form:select path="operations.id" cssClass="operations selectMedium" items="${listOperations}" itemValue="id" itemLabel="name"></form:select>
		
		<form:label for="projects.id" path="projects.id">Projects <span class="small">Add Project</span></form:label>		
		<form:select path="projects.id" cssClass="projects selectMedium" items="${listProjects}" itemValue="id" itemLabel="projectName"></form:select>
			
		<form:label for="priority" path="priority">Priority <span class="small">Add Priority</span></form:label>		
		<form:select path="priority" cssClass="priority selectMedium" items="${listPriorities}"></form:select>
		
		<form:label for="startDate" path="startDate">Start Date* <span class="small">Start Date</span></form:label>		
		<form:input path="startDate" placeholder="-----------Select Date-----------------" readonly="readonly"/>		
		
		<form:label for="endDate" path="endDate">End Date* <span class="small">End Date</span></form:label>	
		<form:input path="endDate" placeholder="-----------Select Date-----------------" readonly="readonly"/>
		
		<form:label path="leadTime">Lead Time* <span class="small">Add Lead Time</span></form:label>		
		<form:input path="leadTime" id="leadTime" name="leadTime"/>
		
		<div class="divider"></div>
		
		<h1>Status Details</h1>
		<p>Status Details Section</p>
		
		<form:label path="docs" for="docs">Documents Received <span class="small">Documents Received</span></form:label>		
		<form:input path="docs"/>
			
		<form:label for="completion" path="completion">Completion* <span class="small">Add % Completion</span></form:label>		
		<form:input path="completion"/>
		
		<form:label path="status" for="status">Current Status* <span class="small">Add Status</span></form:label>		
		<form:select path="status" cssClass="status selectMedium" items="${listStatus}"></form:select>
		
		
		<form:label path="progress" for="progressUpdates">Progress Updates* <span class="small">Add Progress Updates</span></form:label>		
		<form:textarea path="progress"/>				
					
		<div class="divider"></div>		
		<div class="spacer"></div>
</div>
</form:form>
</div>
<script>
$(function() {
	$( "#startDate" ).datepicker();
    $( "#startDate" ).datepicker( "option", "showAnim", "slideDown" );
    $( "#endDate" ).datepicker();         
    $( "#endDate" ).datepicker( "option", "showAnim", "slideDown" );
  });
</script>