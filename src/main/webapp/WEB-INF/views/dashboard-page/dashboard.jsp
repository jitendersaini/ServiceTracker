<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<jsp:include page="../common-includes/common-include.jsp"></jsp:include>
<script type="text/javascript" src="dashboard/js/dashboard.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Service Tracker</title>
</head>
<body>
	<jsp:include page="../common-includes/header.jsp"></jsp:include>
	<jsp:include page="../common-includes/tabs.jsp"></jsp:include>
</body>
<jsp:include page="../common-includes/footer.jsp"></jsp:include>
</html>

<div id="dialog-form" title="Create new user" style="display: none;">
<form id="frm" action="/campaign/action?create" method="post">
   <div id="stylized" class="myform forms" style="margin-left: 0px; margin-top: 5px; margin-bottom: 5px;">
		<h1>Notification</h1>
		<p>Notification Sections</p>
		
		<label for="notificationMessage">Message* <span class="small">Add your Message</span></label>		
		<input id="notificationMessage" name="notificationMessage" type="text" value="">
				
		<div class="divider"></div>
		
		<h1>Campaign details</h1>
		<p>Campaign details section</p>
		
		<label for="campaignTitle">Title* <span class="small">Add Title</span></label>		
		<input id="campaignTitle" name="campaignTitle" type="text" value="">				
		
		<label for="campaignDescription">Description* <span class="small">Add Description</span></label>		
		<textarea id="campaignDescription" name="campaignDescription"></textarea>
		
		<label for="campaignTermsConditions">Terms &amp; Conditions <span class="small">Add Terms &amp; Conditions</span></label>		
		<textarea id="campaignTermsConditions" name="campaignTermsConditions"></textarea>
			
		<label for="campaignButtonTitle">Button Title* <span class="small">Add Button title</span></label>		
		<input id="campaignButtonTitle" name="campaignButtonTitle" type="text" value="">				
		
		<label for="campaignButtonUrl">Button URL* <span class="small">What is this?</span></label>		
		<input id="campaignButtonUrl" name="campaignButtonUrl" type="text" value="">						 								
		
		<div class="divider"></div>
		
		<h1>Scheduling</h1>
		<p>Scheduling Sections</p>
		
		<label for="schedulingStartDate">Start Date* <span class="small">Start Date</span></label>		
		<input id="schedulingStartDate" name="schedulingStartDate" placeholder="---------------DatePicker-----------------" readonly="readonly" type="text" value="" class="hasDatepicker">		
		
		<label for="schedulingEndDate">End Date* <span class="small">End Date</span></label>	
		<input id="schedulingEndDate" name="schedulingEndDate" placeholder="---------------DatePicker-----------------" readonly="readonly" type="text" value="" class="hasDatepicker">
		
		<label for="schedulingLocalTime">Use Local Time <span class="small">local time</span></label>		
		<input id="schedulingLocalTime1" name="schedulingLocalTime" type="checkbox" value="true"><input type="hidden" name="_schedulingLocalTime" value="on">
		
		<div class="divider"></div>
		
		<h1>Beacons</h1>
		<p>Beacons Sections</p>
		<label>Activation Beacons* <span class="small">beacons</span></label>			
		<div id="main_container" style="float: left;">			
			<div id="beacons" class="div_content">			
				<select id="countries" class="countries selectSmall">
					<option value="">--Countries--</option>
					
							<option value="1">Afghanistan</option>		
					
							<option value="2">Albania</option>		
					
				</select>				
				<select id="beaconState" class="beaconState selectSmall"></select>
				<select id="location" class="location selectSmall"></select>
				<select id="beaconZone" name="beaconZone" class="beaconZone selectSmall">
					
						<option value="0">All Zones</option>
					
						<option value="1">Changing Rooms</option>
					
						<option value="2">Entrance</option>
					
						<option value="3">Cashier</option>
					
				</select>										
			</div>			
		</div>
		<div style="float: right;">			
			<button type="button" id="addrows" class="button_add ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false"><span class="ui-button-text">Add</span></button>
			<!-- <button type="button" id="removerows" class="button_remove">Remove</button> -->			
		</div>	
		<div class="divider"></div>		
		<div class="spacer"></div>
</div>
  </form>
</div>