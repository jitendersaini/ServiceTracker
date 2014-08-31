<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="dialog-form" title="${title}">
<form:form modelAttribute="${attr}" id="frm" method="post">
   <div id="stylized" class="myformPopup forms" style="margin: 10px;">
		<h1>Edit Users</h1>
		<p>Edit Users Section <span class="mandatory"></span></p>	
		<div>				
			<form:label for="username" path="username">Username* <span class="small">Type Username</span></form:label>		
			<form:input path="username" readonly="true"/>			
		</div>
		<div>				
			<form:label for="access" path="access">Access Type* <span class="small">Select Access</span></form:label>		
			<form:select path="access" items="${mapAccess}" cssClass="selectMedium"></form:select>			
		</div>					
		<div class="divider"></div>		
		
		<h1>Personal Information</h1>
		<p>Personal Information Section <span class="mandatory"></span></p>
		
		<form:label for="email" path="email">Email* <span class="small">Type your Email</span></form:label>		
		<form:input path="email" readonly="true"/>				
		
		<form:label for="firstName" path="firstName">First Name* <span class="small">Type your First Name</span></form:label>		
		<form:input path="firstName"/>
		
		<form:label path="lastName" for="lastName">Last Name* <span class="small">Type your Last Name</span></form:label>		
		<form:input path="lastName"/>
		
		<form:label path="gender" for="gender">Gender*<span class="small">Select your Gender</span></form:label>
		<form:select path="gender" items="${rdoValues}" cssClass="selectMedium"></form:select>
		
		<div class="divider"></div>		
		
		<h1>Assign Project</h1>
		<p>Project Section <span class="mandatory"></span></p>
		
		<form:label path="projects.id" for="projects.id">Project*<span class="small">Select Project To Assign</span></form:label>
		<form:select path="projects.id" items="${projectsList}" id="projectSelect" itemLabel="projectName" itemValue="id" cssClass="selectMedium"></form:select>
		
		<div class="spacer"></div>
		<span id="responseMsg"></span>
		
</div>
	<form:hidden path="id"/>
</form:form>
</div>