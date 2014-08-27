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
	return $.trim($('#' + id).val()) == '' ? true : false;
}
function removeClassByElementId(id) {
	//$("#"+id).children().removeClass("error");
	$('input').removeClass('error');
}

function simpleAjaxCall(actionName, methodName, divName,
		loaderMessage, failureMessage) {
	setupCSRF();
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

function loadpopupform(actionName) {
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