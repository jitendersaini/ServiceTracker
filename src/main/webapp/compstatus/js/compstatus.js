$(function () {
	$('#jtable').html('');
    
});
var local = window.local || {};
local={		
		functions:{
			generateBarChart: function(elementId, dataList) {
				$('#'+elementId).highcharts({
			        chart: {
			            type: 'column'
			        },
			        title: {
			            text: 'Complete Status'
			        },
			        subtitle: {
			            text: 'Status in Percentage'
			        },
			        xAxis: {
			            type: 'category',
			            labels: {
			                rotation: -45,
			                style: {
			                    fontSize: '13px',
			                    fontFamily: 'Verdana, sans-serif'
			                }
			            }
			        },
			        yAxis: {
			            min: 0,
			            title: {
			                text: 'Total Percentage'
			            }
			        },
			        legend: {
			            enabled: false
			        },
			        tooltip: {
			            pointFormat: 'Percentage: <b>{point.y:.1f} %</b>'
			        },	    
			        series: [{
			            name: 'Percentage',
			            colorByPoint: true,
			            data: dataList,			            
			            dataLabels: {
		                    enabled: true,
		                    format: '{point.y:.1f}%',	                
			                style: {
			                    fontSize: '10px',
			                    fontFamily: 'Verdana, sans-serif'
			                }
		                }	      
			        }]
			    });
			}	
		}
};