$(function() {
	$("#button_actions_op button:first").button({
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
	$("#create_op").button().click(function() {		
		//alert($('#tabs ul').find('.ui-tabs-active').index());		
		loadpopupform("admin/operations/action?create=");
	});
	
	$("#edit_op").button().click(function() {
		edit("admin/operations/action?edit=&id=");		
	});
	
	$("#delete_op").button().click(function() {
		remove('admin/operations/action?remove=&id=');
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
function validateForm() {
	var flag = true;
	removeClassByElementId('frm');	
	if (isElementEmptyById('name')) {
		//str = concatErrMessage('User Name', str);
		$('#name').addClass('error');
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
		height : 440,
		width : 540,
		show : "blind",
		hide : "fold",
		resizable : false,		
		modal : true,
		buttons : {
			"Save" : function() {
				if (validateForm()) {
					save('admin/operations/action?save=', 'frm');
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
	ajaxCallsWithPaging('admin/operations/action?search=', 'post',
			'jtable', 'optable', 'Loading Details', 'Something Went Wrong');
}
function loadPaging() {
	$(document).ready(function() {
		$('#optable').dataTable({
			"bJQueryUI" : true,
			"sPaginationType" : "full_numbers",
			"aaSorting" : [ [ 3, "desc" ] ],
			"aoColumns" : [ {
				"bSortable" : false
			}, null, null, null]
		});
	});
}