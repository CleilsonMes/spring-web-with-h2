// For a pie chart
// Mais informações: https://www.chartjs.org/docs/latest/getting-started/

// var chartData = "[[${projectStatusCnt}]]"
var chartDataStr = decodeHtml(chartData);
var chartDataJson = JSON.parse(chartDataStr);
var arrayLenght = chartDataJson.length;
var numericData = [];
var labelData = [];

for(var i=0; i < arrayLenght; i++){
	numericData[i] = chartDataJson[i].value;
	labelData[i] = chartDataJson[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    
	// The type of chart we want to create
	type: 'pie',

	// The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd","#ff4000","#ff8000"],  
            //borderColor: 'rgb(255, 99, 132)',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
		title: {
			display: true,
			text: 'Projeto Status'	
		}
	
	}

});


// [{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "COMPLETED"},{"value": 1, "label": "COMPLETED"}]
function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}


// Chart de exemplo
new Chart(document.getElementById("myPieChartEx"), {
    
	// The type of chart we want to create
	type: 'pie',

	// The data for our dataset
    data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd","#ff4000","#ff8000","#ffff00","#80ff00","#0040ff","#ff00ff"],  
            borderColor: 'rgb(255, 99, 132)',
            data: [15, 10, 8, 12, 20, 50, 20]
        }]
    },

    // Configuration options go here
    options: {
		title: {
			display: true,
			text: 'Exemplo title chart'	
		}
	
	}

});

