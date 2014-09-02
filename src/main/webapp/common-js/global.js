function isElementEmptyById(id) {
	return $.trim($('#' + id).val()) == '' ? true : false;
}
function saveAction(action, formName, responseAction) {
	$.ajax({
		type : 'post',
		url : action,
		method : 'post',
		data : $("#" + formName).serialize(),
		success : function(response) {
			populateResponse(formName,response);
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alert(xhr.status + " " + thrownError);
		}
	});
}
function isElementEmptyById(id) {
	if($('#'+id).length == 0) return false;
	return  $.trim($('#' + id).val()) == '' ? true : false;
}
function removeClassByElementId(id) {
	//$("#"+id).children().removeClass("error");
	$('input').removeClass('error');
}

function simpleAjaxCall(actionName, methodName, divName,
		loaderMessage, failureMessage) {
	//setupCSRF();
	$.ajax({		
		type : methodName,
		url : actionName,		
		onCreate : showLoader(divName, loaderMessage),
		success : function(html) {
			$("#" + divName).html(html);			
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alert(failureMessage + " " + xhr.status + " " + thrownError);
		}
	});
}

function ajaxCallsWithPaging(actionName, methodName, divName, tableid,
		loaderMessage, failureMessage) {
	//setupCSRF();
	$("#" + divName).html('');
	$.ajax({
		type : methodName,
		url : actionName,
		onCreate : showLoader(divName, loaderMessage),
		success : function(response) {
			/*
			 * if (response.indexOf("j_username") != -1 &&
			 * response.indexOf("j_password") != -1 &&
			 * response.indexOf("j_spring_security_check") != -1) {
			 * location.replace(appContext + "/login/logout"); return; }
			 */
			$("#" + divName).html(response);
			loadPaging();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			alert(failureMessage + " " + xhr.status + " " + thrownError);
		}
	});
}

function loadpopupform(actionName) {
	//setupCSRF();
	$.ajax({
		type : 'post',
		url : actionName,
		success : function(html) {
			// $(".demo_form").html('');			
			$(".data_container").html(html);
			populateDialog();
			$("#dialog-form").dialog("open");
		},
		error : function(xhr, ajaxOptions, thrownError) {
			// alert(xhr.status);
			// alert(thrownError);
			alert("failed");
		}
	});
}

function save(actionName, formName) {
	$.ajax({
		type : 'post',
		url : actionName,
		method : 'post',
		// onCreate : showLoader(divId, 'Please wait...'),
		data : $("#" + formName).serialize(),
		success : function(html) {
			search();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			// alert(xhr.status);
			// alert(thrownError);
			// alert("failed: " + xhr.status + " " + thrownError);
			loadCommonMsgDailog("failed: " + xhr.status + " " + thrownError);
		}
	});
}

function showLoader(divName, msg) {
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
}

function loadCommonMsgDailog(value) {
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

}
function checkUncheckAll() {
	
	checkAllCheckboxes();

	$(".rdo").click(function(){		 	 
		if($(".rdo").length == $(".rdo:checked").length) {
			$("#selectAll").prop("checked", $(".rdo").prop("checked"));	
		}else {
	        $("#selectAll").removeAttr("checked");
	    }
		

	});
}

function checkAllCheckboxes() {
	$("#selectAll").click(function() {
		$(".rdo").prop("checked", $("#selectAll").prop("checked"));
	});
}

function remove(action) {
	//var id = $('input[name=rdo]:checked').val();	
	var id = [];
    $('#rdo:checked').each(function() {
    	id.push($(this).val());
    });
	if (id == undefined || id == '') {
		loadCommonMsgDailog("No entry selected");
		return;
	} else {
		action += id;		
		loadDialog(id, action);
	}
}

function validateDates(date1,date2) {
	var dateDiff = getDateDiff(date1.val(),date2.val(),'days');	
		if(dateDiff<0) {
		date2.addClass("ui-state-error");
		alert("End Date can not be less than Start Date");
		return false;
	} else {
		return true;
	}	
}

function getDateDiff(date1, date2, interval) {
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
}