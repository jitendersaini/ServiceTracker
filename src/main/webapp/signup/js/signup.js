$(function() {
$("#button_save").button().click(function() {
	if (validateForm()) {				
		//saveAction("action?save=","frm","../beacons/action");
	}
});

$("#button_cancel").button().click(function() {
	location.href = "login";
});
});
function isRadioChecked(name) {
	if (!$("input[name='"+name+"']").is(':checked')) {
		   return false;
		}
		else {
		   return true;
		}
}
function validateForm() {
	var str = '';
	var flag = true;
	removeClassByElementId('frm');	
	if (isElementEmptyById('username')) {
		//str = concatErrMessage('User Name', str);
		$('#username').addClass('error');
		flag = false;
	}
	if (isElementEmptyById('password')) {
		//str = concatErrMessage('Password', str);
		$('#password').addClass('error');
		flag = false;
	}
	if (isElementEmptyById('confirmpassword')) {
		//str = concatErrMessage('Confirm Password', str);
		$('#confirmpassword').addClass('error');
		flag = false;
	}
	if (isElementEmptyById('email')) {
		//str = concatErrMessage('Email', str);
		$('#email').addClass('error');
		flag = false;
	}
	if (isElementEmptyById('firstName')) {
		//str = concatErrMessage('First Name', str);
		$('#firstName').addClass('error');
		flag = false;
	}
	if (isElementEmptyById('lastName')) {
		//str = concatErrMessage('Last Name', str);
		$('#lastName').addClass('error');
		flag = false;
	}
	if (!isRadioChecked('gender')) {
		//str = concatErrMessage('Last Name', str);
		$('#gender').addClass('error');
		flag = false;
	}
	
	if (!flag) {
		//$('#mainErrDiv').css('display', 'block');
		//$('#err').html($.trim(str));
	}
	return flag;
}