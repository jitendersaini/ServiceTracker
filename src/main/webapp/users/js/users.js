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
				if (global.functions.isElementEmptyById('username')) {
					//str = concatErrMessage('User Name', str);
					$('#username').addClass('error');
					flag = false;
				}	
				if (global.functions.isElementEmptyById('password')) {
					//str = concatErrMessage('Password', str);
					$('#password').addClass('error');
					flag = false;
				}
				if (global.functions.isElementEmptyById('confirmpassword')) {
					//str = concatErrMessage('Confirm Password', str);
					$('#confirmpassword').addClass('error');
					flag = false;
				}
				if (global.functions.isElementEmptyById('email')) {
					//str = concatErrMessage('Email', str);
					$('#email').addClass('error');
					flag = false;
				}
				if (global.functions.isElementEmptyById('firstName')) {
					//str = concatErrMessage('First Name', str);
					$('#firstName').addClass('error');
					flag = false;
				}
				if (global.functions.isElementEmptyById('lastName')) {
					//str = concatErrMessage('Last Name', str);
					$('#lastName').addClass('error');
					flag = false;
				}	
				if (global.functions.isElementEmptyById('projectSelect')) {
					//str = concatErrMessage('Last Name', str);
					$('#projectSelect').addClass('error');
					flag = false;
				}
				
				if (global.functions.isPasswordMatching('password','confirmpassword')) {
					//str = concatErrMessage('Confirm Password', str);		
					$('#confirmpassword').addClass('error');
					flag = false;
					global.functions.loadCommonMsgDailog("Retype Password does not match");					
				}
				
				if(!global.functions.validateEmail($('#email').val())) {
					flag = false;
					global.functions.loadCommonMsgDailog("Invalid Email!");
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
								global.functions.save('admin/usrs/action?save=', 'frm');
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
				local.functions.removeRecord(id, action);
			},
			search: function() {
				/*global.functions.ajaxCallsWithPaging('admin/usrs/action?search=', 'post',
						'jtable', 'userstable', 'Loading Details', 'Something Went Wrong');*/
				$('#jtable').html(global.functions.tableTemplate2());
				global.functions.checkUncheckAll();
				global.functions.loadPaging2("admin/usrs/action?search=");
			}/*,
			loadPaging:function() {
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
			}*/
		}
};

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
		global.functions.loadpopupform("admin/usrs/action?create=");
	});
	
	$("#edit_user").button().click(function() {
		local.functions.edit("admin/usrs/action?edit=&id=");		
	});
	
	$("#disable_user").button().click(function() {
		global.functions.remove('admin/usrs/action?disable=&id=');
	});
	
	$("#enable_user").button().click(function() {
		global.functions.remove('admin/usrs/action?enable=&id=');
	});	
	
	local.functions.search();
});