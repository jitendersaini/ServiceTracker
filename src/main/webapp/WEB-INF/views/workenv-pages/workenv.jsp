<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="dialog-form" title="Create New Work Env. Entry">
<form id="frm" action="/campaign/action?create" method="post">
   <div id="stylized" class="myformPopup forms" style="margin: 10px;">
		<h1>Requirements</h1>
		<p>Requirements Details</p>
		
		<label for="requirements">Requirements* <span class="small">Add Requirements</span></label>		
		<input id="requirements" name="requirements" type="text" value="">				
		
		<label for="operations">Operations* <span class="small">Add Operations</span></label>		
		<select id="operations" class="operations selectMedium">
				<option value="">--Responsible--</option>
				<option value="1">James</option>
				<option value="2">Albert</option>
		</select>
		
		<label for="project">Projects <span class="small">Add Project</span></label>		
		<select id="project" class="project selectMedium">
				<option value="">--Projects--</option>
				<option value="1">project1</option>
				<option value="2">project2</option>
		</select>
			
		<label for="priority">Priority <span class="small">Add Priority</span></label>		
		<select id="priority" class="priority selectMedium">
				<option value="">--Priority--</option>
				<option value="1">P1</option>
				<option value="2">P2</option>
		</select>
		
		<label for="startDate">Start Date* <span class="small">Start Date</span></label>		
		<input id="startDate" name="startDate" placeholder="---------------DatePicker-----------------" readonly="readonly" type="text" value="" class="hasDatepicker">		
		
		<label for="endDate">End Date* <span class="small">End Date</span></label>	
		<input id="endDate" name="endDate" placeholder="---------------DatePicker-----------------" readonly="readonly" type="text" value="" class="hasDatepicker">
		
		<label for="leadTime">Lead Time* <span class="small">Add Lead Time</span></label>		
		<input id="leadTime" name="leadTime" type="text" value="">
		
		<div class="divider"></div>
		
		<h1>Status Details</h1>
		<p>Status Details Section</p>
		
		<label for="documents">Documents Received <span class="small">Documents Received</span></label>		
		<input id="documents" name="documents" type="text" value="">
			
		<label for="completion">Completion* <span class="small">Add % Completion</span></label>		
		<input id="completion" name="completion" type="text" value="">
		
		<label for="status">Description* <span class="small">Add Status</span></label>		
		<select id="status" class="status selectMedium">
				<option value="">--Status--</option>
				<option value="1">Signed Off</option>
				<option value="2">Work In Progress</option>
		</select>
		
		<label for="progressUpdates">Progress Updates* <span class="small">Add Progress Updates</span></label>		
		<textarea id="progressUpdates" name="progressUpdates"></textarea>				
					
		<div class="divider"></div>		
		<div class="spacer"></div>
</div>
</form>
</div>
<script>
$(function() {
	$( "#startDate" ).datepicker();
    $( "#startDate" ).datepicker( "option", "showAnim", "slideDown" );
    $( "#endDate" ).datepicker();         
    $( "#endDate" ).datepicker( "option", "showAnim", "slideDown" );
  });
</script>