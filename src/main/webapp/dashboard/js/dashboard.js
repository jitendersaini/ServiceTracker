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

	$('#cattable').dataTable({
		"bJQueryUI" : true,
		"sPaginationType" : "full_numbers",
		"aaSorting" : [ [ 5, "desc" ] ],
		"aoColumns" : [ {
			"bSortable" : false
		}, null, null, null, null, null, null ]
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
		height : 750,
		width : 1200,
		show : "blind",
		hide : "fold",
		resizable : false,		
		modal : true,
		buttons : {
			"Save" : function() {
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