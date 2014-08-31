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