<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
#errmsgPercent {
color: red;
}
</style>
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
			
		<form:label for="priorities.id" path="priorities.id">Priority <span class="small">Add Priority</span></form:label>		
		<form:select path="priorities.id" cssClass="priority selectMedium" items="${listPriorities}" itemValue="id" itemLabel="priority"></form:select>
		
		<fmt:formatDate value="${walkthrough.startDate}" type="date" var="startDate"
		pattern="MM/dd/yyyy" />
		
		<form:label for="startDate" path="startDate">Start Date* <span class="small">Start Date</span></form:label>		
		<form:input path="startDate" placeholder="-----------Select Date-----------------" readonly="readonly" value="${startDate}"/>		
		
		<fmt:formatDate value="${walkthrough.endDate}" type="date" var="endDate"
		pattern="MM/dd/yyyy" />
		
		<form:label for="endDate" path="endDate">End Date* <span class="small">End Date</span></form:label>                        	
		<form:input path="endDate" placeholder="-----------Select Date-----------------" readonly="readonly" value="${endDate}"/>
		
		<form:label path="leadTime">Lead Time* <span class="small">Add Lead Time</span></form:label>		
		<form:input path="leadTime" id="leadTime" name="leadTime"/>
		
		<div class="divider"></div>
		
		<h1>Status Details</h1>
		<p>Status Details Section</p>
		
		<form:label path="docs" for="docs">Documents Received* <span class="small">Documents Received</span></form:label>		
		<form:input path="docs"/>
			
		<form:label for="completion" path="completion">Completion* <span class="small">Add % Completion</span></form:label>		
		<form:input path="completion"/>&nbsp;<span id="errmsgPercent"></span>
		
		<form:label path="status.id" for="status.id">Current Status* <span class="small">Add Status</span></form:label>		
		<form:select path="status.id" cssClass="status selectMedium" items="${listStatus}" itemValue="id" itemLabel="status"></form:select>
		
		
		<form:label path="progress" for="progressUpdates">Progress Updates* <span class="small">Add Progress Updates</span></form:label>		
		<form:textarea path="progress"/>				
					
		<div class="divider"></div>		
		<div class="spacer"></div>
		<form:hidden path="id" />
		<fmt:formatDate value='${walkthrough.createdDate}' type='both' var="dt" />
		<form:hidden path="createdDate" value="${dt}" />
</div>
</form:form>
</div>
<script>
$(function() {
	$( "#startDate" ).datepicker();
    $( "#startDate" ).datepicker( "option", "showAnim", "slideDown" );
    $( "#endDate" ).datepicker();         
    $( "#endDate" ).datepicker( "option", "showAnim", "slideDown" );
    
    $("#completion").keypress(function (e) {
        //if the letter is not digit then display error and don't type anything
        if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
           //display error message
           $("#errmsgPercent").html("Digits Only").show().fadeOut("slow");
                  return false;
       	}
        
        if(parseInt($(this).val()) > 100) {
        	$("#errmsgPercent").html("< than 100").show().fadeOut("slow");
            return false;
        }
      });
  });
</script>