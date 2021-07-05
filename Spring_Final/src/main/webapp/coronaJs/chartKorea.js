/**
 * 
 */
var plugin = {
	afterDatasetsDraw: function(chart) {
		var ctx = chart.ctx;
		chart.data.datasets.forEach(function(dataset, i) {
			var meta = chart.getDatasetMeta(i);
			if (!meta.hidden && i == 0) {
				meta.data.forEach(function(element, index) {
					// Draw the text in black, with the specified font
					ctx.fillStyle = 'rgb(255, 0, 0)';
					var fontSize = 15;
					var fontStyle = 'normal';
					var fontFamily = 'Helvetica Neue';
					ctx.font = Chart.helpers.fontString(fontSize, fontStyle, fontFamily);
					// Just naively convert to string for now
					var dataString = dataset.data[index].toString();
					// Make sure alignment settings are correct
					ctx.textAlign = 'center';
					ctx.textBaseline = 'middle';
					var padding = 5;
					var position = element.tooltipPosition();
					ctx.fillText(dataString, position.x, position.y - (fontSize / 2) - padding);
				});
			}
		});
	}
};


drawChart1 = function(kJson) { 
	var arrDate = [];
	var arrTodayDecide = [];
	var arrDecide = [];
	for (var i = 0; i < 7; i++) {
		var j = 6 - i;
		arrTodayDecide[j] = kJson[i].todayDecide;
		arrDecide[j] = kJson[i].decideCnt;
		var day = kJson[i].stdDay
		arrDate[j] = day.substring(0, 4) + "." + day.substring(4, 6) + "." + day.substring(6, 8);
	}
	console.log(arrDecide);

	new Chart(document.getElementById("bar-infection"), {
		type: 'bar',
		data: {
			labels: arrDate,
			datasets: [
				{
					type: 'line',
					yAxisID: 'TodayDecide',
					label: "Population (millions)",
					borderColor: "#3e95cd",
					data: arrTodayDecide,
					fill: false
				},
				{
					label: "Population (millions)",
					yAxisID: 'Decide',
					backgroundColor: "#e8c3b9",
					data: arrDecide
				}
			]

		},
		options: {
			responsive: false,
			legend: { display: false },
			scales: {
				xAxes: [{
					barThickness: 60,
					gridLines: {
						display: false
					}
				}],
				yAxes: [{
					id: 'Decide',
					position: 'left',
					ticks: {
						min: 0,
						max: 180000,
						fontSize: 14,
						userCallback: function(value, index, values) {
							value = value.toString();
							value = value.split(/(?=(?:...)*$)/);
							value = value.join(',');

							return value;
						}

					}
				}, {
					gridLines: {
						display: false
					},
					id: 'TodayDecide',
					position: 'right',
					ticks: {
						min: 0,
						max: 1100,
						fontSize: 14,
						userCallback: function(value, index, values) {
							value = value.toString();
							value = value.split(/(?=(?:...)*$)/);
							value = value.join(',');

							return value;
						}
					}
				}]
			}
		},
		plugins: plugin
	});
}

drawChart2 = function(kJson) {
	var arrDate = [];
	var arrTodayClear = [];
	var arrClear = [];
	for (var i = 0; i < 7; i++) {
		var j = 6 - i;
		arrTodayClear[j] = kJson[i].todayClear;
		arrClear[j] = kJson[i].clearCnt;
		var day = kJson[i].stdDay
		arrDate[j] = day.substring(0, 4) + "." + day.substring(4, 6) + "." + day.substring(6, 8);
	}
	console.log(arrClear);



	new Chart(document.getElementById("bar-release"), {
		type: 'bar',
		data: {
			labels: arrDate,
			datasets: [
				{
					type: 'line',
					yAxisID: 'TodayDecide',
					label: "Population (millions)",
					borderColor: "#3e95cd",
					data: arrTodayClear,
					fill: false
				},
				{
					label: "Population (millions)",
					yAxisID: 'Decide',
					backgroundColor: "#e8c3b9",
					data: arrClear,
				}
			]

		},
		options: {
			responsive: false,
			legend: { display: false },
			scales: {
				xAxes: [{
					barThickness: 60,
					gridLines: {
						display: false
					}
				}],
				yAxes: [{
					id: 'Decide',
					position: 'left',
					ticks: {
						min: 0,
						max: 160000,
						fontSize: 14,
						userCallback: function(value, index, values) {
							value = value.toString();
							value = value.split(/(?=(?:...)*$)/);
							value = value.join(',');

							return value;
						}

					}
				}, {
					gridLines: {
						display: false
					},
					id: 'TodayDecide',
					position: 'right',
					ticks: {
						min: 0,
						max: 900,
						fontSize: 14,
						userCallback: function(value, index, values) {
							value = value.toString();
							value = value.split(/(?=(?:...)*$)/);
							value = value.join(',');

							return value;
						}
					}
				}]
			}
		},
		plugins: plugin
	});
}