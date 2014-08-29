$(function() {
	$("#button_actions_kt button:first").button({
		icons : {
			primary : "ui-icon-plusthick"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-pencil"
		}
	}).next().button({
		icons : {
			primary : "ui-icon-trash"
		}
	});
	$("#create_kt").button().click(function() {
		
		//alert($('#tabs ul').find('.ui-tabs-active').index());		
		loadpopupform("kt/action?create=");
	});
	
	$("#edit_kt").button().click(function() {
		edit("kt/action?edit=&id=");		
	});
	
	$("#delete_kt").button().click(function() {
		remove('kt/action?remove=&id=');
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
		var radioButtons = $("input:checkbox[name=rdo]");
		var selectedIndex = radioButtons.index(radioButtons.filter(':checked'));				
		action += id;		
		loadpopupform(action);
	}
}
function validateForm() {
	var str = '';
	var flag = true;
	removeClassByElementId('frm');	
	if (isElementEmptyById('startDate')) {
		//str = concatErrMessage('User Name', str);
		$('#startDate').addClass('error');
		flag = false;
	}
	if (isElementEmptyById('endDate')) {
		//str = concatErrMessage('Password', str);
		$('#endDate').addClass('error');
		flag = false;
	}
	if (isElementEmptyById('completion')) {
		//str = concatErrMessage('Confirm Password', str);
		$('#completion').addClass('error');
		flag = false;
	}
	
	if (isElementEmptyById('requirements')) {
		//str = concatErrMessage('Confirm Password', str);
		$('#requirements').addClass('error');
		flag = false;
	}
	
	if (isElementEmptyById('leadTime')) {
		//str = concatErrMessage('Confirm Password', str);
		$('#leadTime').addClass('error');
		flag = false;
	}
	
	if (isElementEmptyById('docs')) {
		//str = concatErrMessage('Confirm Password', str);
		$('#docs').addClass('error');
		flag = false;
	}
	
	if (isElementEmptyById('progress')) {
		//str = concatErrMessage('Confirm Password', str);
		$('#progress').addClass('error');
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
					save('kt/action?save=', 'frm');
					$(this).dialog("close");
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
	$("#dialog:ui-dialog").dialog("destroy");
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
	});
}

function search() {
	ajaxCallsWithPaging('kt/action?search=', 'post',
			'jtable', 'kttable', 'Loading Details', 'Something Went Wrong');
}