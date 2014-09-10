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
				if (global.functions.isElementEmptyById('startDate')) {
					//str = concatErrMessage('User Name', str);
					$('#startDate').addClass('error');
					flag = false;
				}
				if (global.functions.isElementEmptyById('endDate')) {
					//str = concatErrMessage('Password', str);
					$('#endDate').addClass('error');
					flag = false;
				}
				if(!global.functions.validateDates($('#startDate'),$('#endDate'))) {
					$('#endDate').addClass('error');
					flag = false;
				}
				if (global.functions.isElementEmptyById('completion')) {
					//str = concatErrMessage('Confirm Password', str);
					$('#completion').addClass('error');
					flag = false;
				}
				
				if (global.functions.isElementEmptyById('requirements')) {
					//str = concatErrMessage('Confirm Password', str);
					$('#requirements').addClass('error');
					flag = false;
				}
				
				if (global.functions.isElementEmptyById('leadTime')) {
					//str = concatErrMessage('Confirm Password', str);
					$('#leadTime').addClass('error');
					flag = false;
				}
				
				if (global.functions.isElementEmptyById('docs')) {
					//str = concatErrMessage('Confirm Password', str);
					$('#docs').addClass('error');
					flag = false;
				}
				
				if (global.functions.isElementEmptyById('progress')) {
					//str = concatErrMessage('Confirm Password', str);
					$('#progress').addClass('error');
					flag = false;
				}
				
				if (!flag) {
					//$('#mainErrDiv').css('display', 'block');
					//$('#err').html($.trim(str));
				}
				return flag;
			},
			populateDialog: function() {
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
							if (local.functions.validateForm()) {
								global.functions.save('users/walkthrough/action?save=', 'frm');
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
				/*global.functions.ajaxCallsWithPaging('users/walkthrough/action?search=', 'post',
						'jtable', 'walktable', 'Loading Details', 'Something Went Wrong');*/
				$('#jtable').html(global.functions.tableTemplate());
				global.functions.checkUncheckAll();
				global.functions.loadPaging("users/walkthrough/action?search=");
			}/*,
			loadPaging:function() {
				$(document).ready(function() {
					$('#walktable').dataTable({
						"bJQueryUI" : true,
						"sPaginationType" : "full_numbers",
						"aaSorting" : [ [ 5, "desc" ] ],
						"aoColumns" : [ {
							"bSortable" : false
						}, null, null, null,null,null,null,null,null,null,null,null ]
					});
				});
			}*/
		}
};

$(function() {
	$("#button_actions_walkthrough button:first").button({
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
	$("#create_walkthrough").button().click(function() {
		
		//alert($('#tabs ul').find('.ui-tabs-active').index());		
		global.functions.loadpopupform("users/walkthrough/action?create=");
	});
	
	$("#edit_walkthrough").button().click(function() {
		local.functions.edit("users/walkthrough/action?edit=&id=");		
	});
	
	$("#delete_walkthrough").button().click(function() {
		global.functions.remove('users/walkthrough/action?remove=&id=');
	});
	
	local.functions.search();
});