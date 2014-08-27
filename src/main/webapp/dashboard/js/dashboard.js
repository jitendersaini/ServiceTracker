$(function() {
	$("#tabs").tabs();
	$("#button_actions button:first").button({
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
	$("#create").button().click(function() {
		
		//alert($('#tabs ul').find('.ui-tabs-active').index());		
		loadpopupform("../workenv/action?create=");
	});

	$("#edit").button().click(function() {
		alert('2');
	});
	
	$("#delete").button().click(function() {
		alert('3');
	});
});

function saveFormData() {
	
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
				save('../workenv/action?save=', 'frm');
				$(this).dialog("close");
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

function search() {alert('ffff');
	ajaxCallsWithPaging('../workenv/action?search=', 'post', 'jtable', 'cattable',
			'Loading Details', 'Something Went Wrong');
}