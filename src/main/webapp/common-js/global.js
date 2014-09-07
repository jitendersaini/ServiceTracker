var global = window.global || {};

global={
	constants:{
		maxRecentlyViewedCount : 3		
	},
	functions:{		
		isElementEmptyById: function (id) {
			return $.trim($('#' + id).val()) == '' ? true : false;
		},
		saveAction:function (action, formName, responseAction) {
			$.ajax({
				type : 'post',
				url : action,
				method : 'post',
				data : $("#" + formName).serialize(),
				success : function(response) {
					local.functions.populateResponse(formName,response);
				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert(xhr.status + " " + thrownError);
				}
			});
		},
		isElementEmptyById: function(id) {
			if($('#'+id).length == 0) return false;
			return  $.trim($('#' + id).val()) == '' ? true : false;
		},
		isPasswordMatching: function(id1, id2) {
			if($('#'+id1).length == 0) return false;
			if($('#'+id2).length == 0) return false;
			return  ($.trim($('#' + id1).val()) != $.trim($('#' + id2).val())) ? true : false;
		},
		removeClassByElementId: function(id) {
			$('input').removeClass('error');
		},
		simpleAjaxCall:function(actionName, methodName, divName,
				loaderMessage, failureMessage) {
			//setupCSRF();
			$.ajax({		
				type : methodName,
				url : actionName,		
				onCreate : global.functions.showLoader(divName, loaderMessage),
				success : function(html) {
					$("#" + divName).html(html);			
				},
				error : function(xhr, ajaxOptions, thrownError) {
					global.functions.loadCommonMsgDailog(failureMessage + " " + xhr.status + " " + thrownError);
				}
			});			
		},
		ajaxCallsWithPaging:function(actionName, methodName, divName, tableid,
				loaderMessage, failureMessage) {
			//setupCSRF();
			$("#" + divName).html('');
			$.ajax({
				type : methodName,
				url : actionName,
				onCreate : global.functions.showLoader(divName, loaderMessage),
				success : function(response) {
					/*
					 * if (response.indexOf("j_username") != -1 &&
					 * response.indexOf("j_password") != -1 &&
					 * response.indexOf("j_spring_security_check") != -1) {
					 * location.replace(appContext + "/login/logout"); return; }
					 */
					$("#" + divName).html(response);
					local.functions.loadPaging();
				},
				error : function(xhr, ajaxOptions, thrownError) {
					global.functions.loadCommonMsgDailog(failureMessage + " " + xhr.status + " " + thrownError);
				}
			});
		},
		loadpopupform: function(actionName) {
			//setupCSRF();
			$.ajax({
				type : 'post',
				url : actionName,
				success : function(html) {
					// $(".demo_form").html('');			
					$(".data_container").html(html);
					local.functions.populateDialog();			
					$("#dialog-form").dialog("open");
				},
				error : function(xhr, ajaxOptions, thrownError) {
					// alert(xhr.status);
					// alert(thrownError);
					global.functions.loadCommonMsgDailog("failed");
				}
			});
		},
		save: function(actionName, formName) {
			$.ajax({
				type : 'post',
				url : actionName,
				method : 'post',
				// onCreate : showLoader(divId, 'Please wait...'),
				data : $("#" + formName).serialize(),
				success : function(html) {
					local.functions.search();
				},
				error : function(xhr, ajaxOptions, thrownError) {
					// alert(xhr.status);
					// alert(thrownError);
					// alert("failed: " + xhr.status + " " + thrownError);
					global.functions.loadCommonMsgDailog("failed: " + xhr.status + " " + thrownError);
				}
			});
		},
		showLoader: function(divName, msg) {
			if (!msg) {
				msg = "";
			}
			target = document.getElementById(divName);

			if (target) {
				target.innerHTML = "<img src=" + appContext
						+ "/images/ajax-loader.gif>&nbsp;" + msg
						+ "</img>&nbsp;<img src=" + appContext
						+ "/images/ajax-loader-progress.gif></img>";
			}
		},
		
		loadCommonMsgDailog: function(value) {
			$("#dialog:ui-dialog").dialog("destroy");
			$("#dialog-mesg-common").dialog({
				modal : true,
				resizable : false,
				show : "blind",
				hide : "fold",
				buttons : {
					Ok : function() {
						$(this).dialog("close");
					}
				}
			});
			var str = '<p><span class="ui-icon ui-icon-circle-check"style="float: left; margin: 0 7px 50px 0;"></span> '
					+ value + '</p>';
			// alert(str);
			$("#dialog-mesg-common").html(str);
		},
		checkUncheckAll: function () {
			global.functions.checkAllCheckboxes();

			$(".rdo").click(function(){		 	 
				if($(".rdo").length == $(".rdo:checked").length) {
					$("#selectAll").prop("checked", $(".rdo").prop("checked"));	
				}else {
			        $("#selectAll").removeAttr("checked");
			    }
				

			});
		},
		checkAllCheckboxes: function () {
			$("#selectAll").click(function() {
				$(".rdo").prop("checked", $("#selectAll").prop("checked"));
			});
		},
		remove: function(action) {
			var id = [];
		    $('#rdo:checked').each(function() {
		    	id.push($(this).val());
		    });
			if (id == undefined || id == '') {
				global.functions.loadCommonMsgDailog("No entry selected");
				return;
			} else {
				action += id;		
				local.functions.loadDialog(id, action);
			}
		},
		validateDates: function(date1,date2) {
				var dateDiff = global.functions.getDateDiff(date1.val(),date2.val(),'days');	
				if(dateDiff<0) {
				date2.addClass("ui-state-error");
				global.functions.loadCommonMsgDailog("End Date can not be less than Start Date");
				return false;
			} else {
				return true;
			}
		},
		getDateDiff: function (date1, date2, interval) {
			var second = 1000,
		    minute = second * 60,
		    hour = minute * 60,
		    day = hour * 24,
		    week = day * 7;
		    date1 = new Date(date1).getTime();
		    date2 = (date2 == 'now') ? new Date().getTime() : new Date(date2).getTime();
		    var timediff = date2 - date1;
		    if (isNaN(timediff)) return NaN;
		    switch (interval) {
		    case "years":
		        return date2.getFullYear() - date1.getFullYear();
		    case "months":
		        return ((date2.getFullYear() * 12 + date2.getMonth()) - (date1.getFullYear() * 12 + date1.getMonth()));
		    case "weeks":
		        return Math.floor(timediff / week);
		    case "days":
		        return Math.floor(timediff / day);
		    case "hours":
		        return Math.floor(timediff / hour);
		    case "minutes":
		        return Math.floor(timediff / minute);
		    case "seconds":
		        return Math.floor(timediff / second);
		    default:
		        return undefined;
		    }
		},
		changePassword: function() {
			global.functions.loadpopupformchangepassword('settings/password/action?change=');
		},
		loadpopupformchangepassword: function(actionName) {
			$.ajax({
				type : 'post',
				url : actionName,
				success : function(html) {
					// alert(html);
					// $(".demo_form").html('');
					$(".data_container").html(html);
					global.functions.populateDialogChangePass();
					$("#dialog-form").dialog("open");
				},
				error : function(xhr, ajaxOptions, thrownError) {
					// alert(xhr.status);
					// alert(thrownError);
					global.functions.loadCommonMsgDailog("failed");
				}
			});
		},
		populateDialogChangePass: function() {
			// a workaround for a flaw in the demo system
			// (http://dev.jqueryui.com/ticket/4375), ignore!
			$("#dialog:ui-dialog").dialog("destroy");
			
			
			$("#dialog-form").dialog({
				autoOpen : false,
				height : 380,
				width : 480,
				show : "blind",
				hide : "fold",
				resizable : false,		
				modal : true,
				buttons : {
					"Save" : function() {
						if (global.functions.validatePassChangeForm()) {
							global.functions.savepwdchaged('settings/password/action?save=','frm',
									$(this), $("#password"));
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
		savepwdchaged: function(actionName, formName, objName, currentpassword) {
			$.ajax({
				type : 'post',
				url : actionName,
				method : 'post',
				onCreate : global.functions.showLoader('loader', 'Please wait...'),
				data : $("#" + formName).serialize(),
				success : function(html) {
					//alert("html: "+html);
					if (html == '0') {
						$('#loader').html('');
						currentpassword.addClass("ui-state-error");
						global.functions.loadCommonMsgDailog("Bad credentials.... Please enter a valid password");					
					} else {
						objName.dialog("close");
						global.functions.loadCommonMsgDailog("Password Changed successfully. Please logout and login again.");
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					// alert(xhr.status);
					// alert(thrownError);
					// alert("failed: " + xhr.status + " " + thrownError);
					global.functions.loadCommonMsgDailog("failed: " + xhr.status + " "
							+ thrownError);
				}
			});
		},
		validatePassChangeForm: function() {
			var flag = true;
			global.functions.removeClassByElementId('frm');	
			if (global.functions.isElementEmptyById('password')) {
				//str = concatErrMessage('Password', str);
				$('#password').addClass('error');
				flag = false;
			}
			if (global.functions.isElementEmptyById('newpassword')) {
				//str = concatErrMessage('Password', str);
				$('#newpassword').addClass('error');
				flag = false;
			}
			if (global.functions.isElementEmptyById('retypenewpassword')) {
				//str = concatErrMessage('Password', str);
				$('#retypenewpassword').addClass('error');
				flag = false;
			}
			if (global.functions.isPasswordMatching('newpassword','retypenewpassword')) {
				//str = concatErrMessage('Confirm Password', str);		
				$('#retypenewpassword').addClass('error');
				global.functions.loadCommonMsgDailog("Retype Password does not match");
				flag = false;
			}					
			return flag;
		},
	}
};

$(document).ajaxStart(function(){	
    $.blockUI({
        css: {
            border: 'none',
            padding: '15px',
            backgroundColor: '#000',
            '-webkit-border-radius': '10px',
            'border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: .5,
            color: '#fff'
        }
    });
});   // <----- HERE


$(document).ajaxComplete(function(){
    $.unblockUI();
});