$(function() {
	$("#button_actions_users button:first").button({
		icons : {
			primary : "ui-icon-plusthick"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-pencil"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-locked"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-unlocked"
		}
	});
	$("#create_user").button().click(function() {
		
		//alert($('#tabs ul').find('.ui-tabs-active').index());		
		loadpopupform("admin/usrs/action?create=");
	});
	
	$("#edit_user").button().click(function() {
		edit("admin/usrs/action?edit=&id=");		
	});
	
	$("#disable_user").button().click(function() {
		remove('admin/usrs/action?disable=&id=');
	});
	
	$("#enable_user").button().click(function() {
		remove('admin/usrs/action?enable=&id=');
	});
	
	search();
});

function edit(action) {
	var id = $('input[name=rdo]:checked').val();
	if (id == undefined) {
		loadCommonMsgDailog("No entry selected");
		return;
	} else if($(".rdo:checked").length >1) {
		loadCommonMsgDailog("Only one record can be modified");
		return;
	} else {
		//var radioButtons = $("input:checkbox[name=rdo]");
		//var selectedIndex = radioButtons.index(radioButtons.filter(':checked'));				
		action += id;		
		loadpopupform(action);
	}
}

function populateResponse(formName,response) {
	$('#responseMsg').removeClass("errorMsgSave");
	$('#responseMsg').removeClass("succMsgSave");
	if(response == 'username') {
		$('#responseMsg').html("Duplicate Username");
		$('#responseMsg').addClass('errorMsgSave');
	} else if(response == 'email') {
		$('#responseMsg').html("Duplicate Email");
		$('#responseMsg').addClass('errorMsgSave');
	} else if(response == 'save' || response == 'saved_edited') {
		$("#dialog-form").dialog("close");
		search();
	}
}
function validateForm() {
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
	if (isElementEmptyById('projectSelect')) {
		//str = concatErrMessage('Last Name', str);
		$('#projectSelect').addClass('error');
		flag = false;
	}
	
	if (!flag) {
		//$('#mainErrDiv').css('display', 'block');
		//$('#err').html($.trim(str));
	}
	return flag;
}

function populateDialog() {
	// a workaround for a flaw in the demo system
	// (http://dev.jqueryui.com/ticket/4375), ignore!
	$("#dialog:ui-dialog").dialog("destroy");
	
	
	$("#dialog-form").dialog({
		autoOpen : false,
		height : 640,
		width : 840,
		show : "blind",
		hide : "fold",
		resizable : false,		
		modal : true,
		buttons : {
			"Save" : function() {
				if (validateForm()) {
					saveAction('admin/usrs/action?save=', 'frm');					
				}
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		},
		close : function() {					
			$("#dialog-form").remove();
		}
	});
}

function removeRecord(id, action) {
	$.ajax({
		type : 'post',
		url : action,
		success : function(response) {			
			if(response != "") {
				loadCommonMsgDailog("Enteries ("+response+") is/are used in further transactions");
				return;
			}
			search();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alertMessage("Something Went Wrong" + xhr.status + " "
					+ thrownError);
		}
	});
}

function loadDialog(id, action) {
	/*$("#dialog:ui-dialog").dialog("destroy");
	$("#dialog-confirm").dialog({
		resizable : false,
		height : 140,
		modal : true,
		show : "blind",
		hide : "fold",
		buttons : {
			"Proceed" : function() {
				removeRecord(id, action);
				$(this).dialog("close");
			},
			Cancel : function() {
				$(this).dialog("close");
			}
		}
	});*/
	removeRecord(id, action);
}

function search() {
	ajaxCallsWithPaging('admin/usrs/action?search=', 'post',
			'jtable', 'userstable', 'Loading Details', 'Something Went Wrong');
}
function loadPaging() {
	$(document).ready(function() {
		$('#userstable').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"aaSorting" : [ [ 5, "desc" ] ],
			"aoColumns" : [ {
				"bSortable" : false
			}, null, null, null, null,null,null]
		});
	});
}