$(function() {
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
	$("#create").button().click(function() {
		
		//alert($('#tabs ul').find('.ui-tabs-active').index());		
		loadpopupform("workenv/action?create=");
	});
	
	$("#edit").button().click(function() {
		alert('2');
	});
	
	$("#delete").button().click(function() {
		alert('3');
	});
	
	search();
});