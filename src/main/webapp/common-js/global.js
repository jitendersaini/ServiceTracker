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
	function addUser() {
		
	}
	$("#create").button().click(function() {
		dialog = $( "#dialog-form" ).dialog({
		      autoOpen: false,
		      height: 600,
		      width: 900,
		      modal: true,
		      buttons: {
		        "Create an account": addUser,
		        Cancel: function() {
		          dialog.dialog( "close" );
		        }
		      },
		      close: function() {
		    	 //alert($('#frm'));
		    	  $('#frm')[0].reset();
		        //allFields.removeClass( "ui-state-error" );
		      }
		    });
		 
		dialog.dialog( "open" );
		//alert($('#tabs ul').find('.ui-tabs-active').index());
	});

	$("#edit").button().click(function() {
		alert('2');
	});
	
	$("#delete").button().click(function() {
		alert('3');
	});
});