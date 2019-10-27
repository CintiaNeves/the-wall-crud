<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Entrada Nota Fiscal</title>
<link rel="icon" href="img/Fevicon.png" type="image/png">
<link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
<link rel="stylesheet" href="vendors/linericon/style.css">
<link rel="stylesheet"
	href="vendors/owl-carousel/owl.theme.default.min.css">
<link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet" href="vendors/nice-select/nice-select.css">
<link rel="stylesheet" href="vendors/nouislider/nouislider.min.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="vendors/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="vendors/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="vendors/jquery/mask.min.js"></script>

<!--Load the AJAX API-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	// Load the Visualization API and the corechart package.
	google.charts.load('current', {
		'packages' : [ 'corechart' ]
	});

	// Set a callback to run when the Google Visualization API is loaded.
	google.charts.setOnLoadCallback(drawChart);

	// Callback that creates and populates a data table,
	// instantiates the pie chart, passes in the data and
	// draws it.
	function graficoBarras() {
		let data = new google.visualization.DataTable();
		data.addColumn('string', 'Ano');
		data.addColumn('number', 'Produto');
		data.addColumn('number', 'Quantides vendidas');
		data.addColumn('number', 'Valor de Venda por Produto');
		data.addRows([ [ '2014', 1000, 400, 200 ], [ '2015', 1170, 460, 250 ],
				[ '2016', 660, 1120, 300 ], [ '2017', 1030, 540, 350 ] ]);
		let options = {
			'title' : 'Produtos vendidos no período',
			'width' : screen.width,
			'height' : (screen.width / 2) - (screen.width / 2 * 0.3)
		};
		var chart = new google.visualization.BarChart(document
				.getElementById('bar_chart_div'));
		chart.draw(data, options);
	}

	function drawChart() {
		graficoBarras();

		// Create the data table.
		var data = new google.visualization.DataTable();
		data.addColumn('string', 'Topping');
		data.addColumn('number', 'Slices');
		data.addRows([ [ 'Mushrooms', 3 ], [ 'Onions', 1 ], [ 'Olives', 1 ],
				[ 'Zucchini', 1 ], [ 'Pepperoni', 2 ] ]);

		// Set chart options
		var options = {
			'title' : 'How Much Pizza I Ate Last Night',
			'width' : screen.width,
			'height' : (screen.width / 2) - (screen.width / 2 * 0.3)
		};

		// Instantiate and draw our chart, passing in some options.
		var chart = new google.visualization.PieChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>
<style>
html {
	background: white;
}
</style>
</head>

<body>
	<div style="float: left">
		<div id="bar_chart_div"></div>
		<label>test</label> 
		<input class="form-control"/> 
		<label>test</label> 
		<input class="form-control"/>
		<!--Div that will hold the pie chart-->
		<div id="chart_div"></div>
	</div>
</body>
</html>