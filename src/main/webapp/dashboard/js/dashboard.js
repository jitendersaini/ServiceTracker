$(function() {
	$("#tabs").tabs();
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
				save('workenv/action?saveWork=', 'frm');
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

/*function search() {alert('ffff');
	ajaxCallsWithPaging('../workenv/action?search=', 'post', 'jtable', 'cattable',
			'Loading Details', 'Something Went Wrong');
}*/

function search() {
	ajaxCallsWithPaging('workenv/action?search=', 'post',
			'jtable', 'cattable', 'Loading Details', 'Something Went Wrong');
}