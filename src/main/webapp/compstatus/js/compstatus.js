function generateBarChart(elementId, dataList) {	
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
	            /*data: [
	                ['Shanghai', 23.7],
	                ['Lagos', 16.1],
	                ['Instanbul', 14.2],
	                ['Karachi', 14.0],
	                ['Mumbai', 12.5],
	                ['Moscow', 12.1],
	                ['São Paulo', 11.8],
	                ['Beijing', 11.7],
	                ['Guangzhou', 11.1],
	                ['Delhi', 11.1],
	                ['Shenzhen', 10.5],
	                ['Seoul', 10.4],
	                ['Jakarta', 10.0],
	                ['Kinshasa', 9.3],
	                ['Tianjin', 9.3],
	                ['Tokyo', 9.0],
	                ['Cairo', 8.9],
	                ['Dhaka', 8.9],
	                ['Mexico City', 8.9],
	                ['Lima', 8.9]
	            ],*/
	            
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
function generatePieChart(elementId, dataList) {
	$('#'+elementId).highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: 1,//null,
            plotShadow: false
        },
        title: {
            text: 'Browser market shares at a specific website, 2014'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                    style: {
                        color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                    }
                },
                showInLegend: true
            }
        },
        series: [{
            type: 'pie',
            name: 'Browser share',
            data: dataList
            /*data: [
                ['Firefox',   45.0],
                ['IE',       26.8],
                {
                    name: 'Chrome',
                    y: 12.8,
                    sliced: true,
                    selected: true
                },
                ['Safari',    8.5],
                ['Opera',     6.2],
                ['Others',   0.7]
            ]*/
        }]
    });
}

$(function () {
	$('#jtable').html('');
    
});