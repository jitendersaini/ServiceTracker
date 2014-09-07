var local = window.local || {};
local={		
		functions:{
			edit: function(action) {
				var id = $('input[name=rdo]:checked').val();
				if (id == undefined) {
					global.functions.loadCommonMsgDailog("No entry selected");
					return;
				} else if($(".rdo:checked").length >1) {
					global.functions.loadCommonMsgDailog("Only one record can be modified");
					return;
				} else {
					action += id;		
					global.functions.loadpopupform(action);
				}
			},
			validateForm: function() {
				var flag = true;
				global.functions.removeClassByElementId('frm');	
				if (global.functions.isElementEmptyById('status')) {
					//str = concatErrMessage('User Name', str);
					$('#status').addClass('error');
					flag = false;
				}
				return flag;				
			},
			populateDialog: function() {
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
							if (local.functions.validateForm()) {
								global.functions.save('admin/status/action?save=', 'frm');
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
			},
			removeRecord: function(id, action) {
				$.ajax({
					type : 'post',
					url : action,
					success : function(response) {			
						if(response != "") {
							global.functions.loadCommonMsgDailog("Enteries ("+response+") is/are used in further transactions");
							return;
						}
						local.functions.search();
					},
					error : function(xhr, ajaxOptions, thrownError) {
						alertMessage("Something Went Wrong" + xhr.status + " "
								+ thrownError);
					}
				});
			},
			loadDialog: function(id, action) {
				$("#dialog:ui-dialog").dialog("destroy");
				$("#dialog-confirm").dialog({
					resizable : false,
					height : 140,
					modal : true,
					show : "blind",
					hide : "fold",
					buttons : {
						"Proceed" : function() {
							local.functions.removeRecord(id, action);
							$(this).dialog("close");
						},
						Cancel : function() {
							$(this).dialog("close");
						}
					}
				});
			},
			search: function() {
				global.functions.ajaxCallsWithPaging('admin/status/action?search=', 'post',
						'jtable', 'statustable', 'Loading Details', 'Something Went Wrong');
			},
			loadPaging:function() {
				$(document).ready(function() {
					$('#statustable').dataTable({
						"bJQueryUI" : true,
						"sPaginationType" : "full_numbers",
						"aaSorting" : [ [ 3, "desc" ] ],
						"aoColumns" : [ {
							"bSortable" : false
						}, null, null, null]
					});
				});
			}
		}
};

$(function() {
	$("#button_actions_status button:first").button({
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
	$("#create_status").button().click(function() {
		
		//alert($('#tabs ul').find('.ui-tabs-active').index());		
		global.functions.loadpopupform("admin/status/action?create=");
	});
	
	$("#edit_status").button().click(function() {
		local.functions.edit("admin/status/action?edit=&id=");		
	});
	
	$("#delete_status").button().click(function() {
		global.functions.remove('admin/status/action?remove=&id=');
	});
	
	local.functions.search();
});