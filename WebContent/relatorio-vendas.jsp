<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>The Wall - Relatório de Vendas</title>
	<link rel="icon" href="img/Fevicon.png" type="image/png">
	<link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
	<link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
	<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
	<link rel="stylesheet" href="vendors/linericon/style.css">
	<link rel="stylesheet" href="vendors/owl-carousel/owl.theme.default.min.css">
	<link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
	<link rel="stylesheet" href="vendors/nice-select/nice-select.css">
	<link rel="stylesheet" href="vendors/nouislider/nouislider.min.css">
	<link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="vendors/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="vendors/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="vendors/jquery/mask.min.js"></script>

	<!--Load the AJAX API-->
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

	<script type="text/javascript">
		// Load the Visualization API and the corechart package.
		google.charts.load('current', { 'packages': ['corechart', 'line', 'bar'] });

		// Set a callback to run when the Google Visualization API is loaded.
		google.charts.setOnLoadCallback(drawCharts);

		function drawCharts() {
			graficoColunas("Instrumentos vendidos no período", "line_chart_div", { operacao: "CONSULTAR", relatorio: "VENDAS", retornoJson: true });
		}

		// graficos de colunas
		function graficoColunas(title, chartElement, data) {
			document.getElementById("modal").removeAttribute("hidden");
			document.getElementById('modal').style.display = 'block';
			document.getElementById('fade').style.display = 'block';
			$.ajax({
				url: "http://localhost:8080/the-wall-crud/relatorio",
				data,
				success: relatorio => {
					// objeto de dados do grï¿½fico do google
					let data = new google.visualization.DataTable();

					// obtem os dados
					let datas = relatorio[0].datas;
					let colunas = relatorio[0].colunas;
					let dados = relatorio[0].dados;

					// adiciona colunas
					datas.some(d => d) && data.addColumn('string', 'Data');
					colunas.forEach(coluna => data.addColumn('number', coluna));

					// define os dados de cada coluna com arrays representando cada coluna
					let dataRows = [];
					let itensData = [];
					datas.forEach(data => {
						for (coluna of colunas) {
							itensData.push(Number(dados[data + "|" + coluna] || 0));
						}
						dataRows.push([data, ...itensData]);
						itensData = [];
					});
					dataRows.sort((a, b) => {
						let d1 = new Date(a[0].split("/")[1], a[0].split("/")[0]).getTime();
						let d2 = new Date(b[0].split("/")[1], b[0].split("/")[0]).getTime();
						return +(d1 > d2) || +(d1 === d2) - 1;
					});
					data.addRows(dataRows);
					let options = {
						'title': title,
						'width': screen.width,
						'height': screen.height - screen.height * 0.3,
						backgroundColor: '#f5f5f5',
						is3D: true
					};
					let chart = null;
					let option = {};
					if(chartElement === "bar_chart_div") {
						chart = new google.charts.Bar(document.getElementById(chartElement));
						option = google.charts.Bar.convertOptions(options);						
					} else if(chartElement === "line_chart_div") {
						chart = new google.charts.Line(document.getElementById(chartElement));
						option = google.charts.Line.convertOptions(options);						
					}
					chart.draw(data, option);
				},
				error: err => console.log(err),
				complete: () => {
					[...document.getElementsByClassName("row")].forEach(row => row.removeAttribute("hidden"));
					document.getElementById("loader").removeAttribute("hidden");
					document.getElementById('modal').style.display = 'none';
					document.getElementById('fade').style.display = 'none';
				}
			});
		}

		window.addEventListener('DOMContentLoaded', (event) => {
			document.getElementById("consultar").addEventListener("click", event => {
				let erro = false;
				let inicio = document.getElementById("inicio");
				let fim = document.getElementById("fim");
				let produtos = document.getElementById("selectProduto");
				let mensagem = document.getElementById("mensagemErro");
				mensagem.innerText = "";
				mensagem.hidden = true;
				if (inicio.value && fim.value) {
					if (new Date(inicio.value).getTime() > new Date(fim.value).getTime()) {
						erro = true;
						mensagem.innerText = "Data fim não poder ser maior que a data início!";
						mensagem.hidden = false;
					}
				}
				if (mensagem.innerText === "" && ![...produtos].some(p => p.selected) && !inicio.value && !fim.value) {
					erro = true;
					mensagem.innerText = "Para realizar a consulta ao menos um dos campos deve ser preenchido!";
					mensagem.hidden = false;
				}
				if (!erro) { // realiza consulta
					idInstrumentos = "";
					[...produtos].forEach(p => (p.selected && p.value) && (idInstrumentos += p.value + "-"));
					idInstrumentos = idInstrumentos.substring(0, idInstrumentos.length - 1);
					dataInicio = inicio.value;
					dataFim = fim.value;
					graficoColunas("Produtos vendidos no período", "line_chart_div",
						{ operacao: "CONSULTAR", relatorio: "ITENS_VENDIDOS", retornoJson: true, idInstrumentos, dataInicio, dataFim });
				}
			});
		});

		// adiciona instrumentos em select
		$.ajax({
			url: "http://localhost:8080/the-wall-crud/instrumento",
			data: { btnOperacao: "CONSULTAR", retornoJson: true },
			success: instrumentos => {
				let selects = "<option value=''></option>";
				instrumentos.forEach(instrumento => {
					selects += "<option value='" + instrumento.id + "'>" + instrumento.descricao + "</option>";
				});
				$("#selectProduto").append(selects);
			},
			error: err => console.log(err)
		});
	</script>

	<style>
		@keyframes spin {
			0% {
				transform: rotate(0deg);
			}

			100% {
				transform: rotate(360deg);
			}
		}

		.loader {
			z-index: 9999999999;
			position: fixed;
			top: 50%;
			left: 50%;
			text-align: center;
			border: 8px solid #fff;
			border-radius: 50%;
			border-top: 8px solid #3498db;
			width: 100px;
			height: 100px;
			-webkit-animation: spin 2s linear infinite;
			/* Safari */
			animation: spin 2s linear infinite;
		}

		#fade {
			display: none;
			position: absolute;
			top: 0%;
			left: 0%;
			width: 100%;
			height: 100%;
			background-color: #ababab;
			z-index: 1001;
			-moz-opacity: 0.8;
			opacity: .70;
			filter: alpha(opacity=80);
		}
	</style>

</head>

<body id="body">
	<!--================ Start Header Menu Area =================-->
	<header class="header_area">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container">
					<h1>The Wall</h1>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<div class="collapse navbar-collapse offset"
						id="navbarSupportedContent">
						<ul class="nav navbar-nav menu_nav ml-auto mr-auto">
							<li class="nav-item"><a class="nav-link" href="index.jsp">Site</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Consultas</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="consulta-pedido.jsp">Pedidos</a></li>
									<li class="nav-item"><a class="nav-link"
										href="consulta-troca.jsp">Trocas</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Produtos</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="cadastro.jsp">Cadastro</a></li>
									<li class="nav-item"><a class="nav-link"
										href="consulta.jsp">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Estoque</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="entrada.jsp">Entrada</a></li>
									<li class="nav-item"><a class="nav-link"
										href="consulta-estoque.jsp">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Relatórios</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="relatorio-vendas.jsp">Vendas</a></li>
									<li class="nav-item"><a class="nav-link"
										href="relatorio-trocas.jsp">Trocas</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->
	<div id="fade"></div>
	<div hidden id="modal">
		<div class="loader" id="loader"></div>
	</div>
	<div id="line_chart_div"></div>
	<div id="bar_chart_div"></div>
	<div hidden style="margin: 0% 10%;" class="alert alert-danger" id="mensagemErro" role="alert"></div>
	<div hidden style="margin: 0% 2%;" class="row">
		<div class="form-group col-xs-4 col-md-4">
			<label for="inicio" class="control-label">Período Inicial</label>
			<input type="date" class="form-control" id="inicio" name="inicio">
		</div>
		<div class="form-group col-xs-4 col-md-4">
			<label for="fim" class="control-label">Período Final</label>
			<input type="date" class="form-control" id="fim" name="fim">
		</div>
	</div>
	<div hidden style="margin: 0% 2%;" class="row">
		<div class="form-group col-xs-4 col-md-4">
			<label for="produto" class="control-label">Instrumento</label>
			<select class="form-control" name="produto" id="selectProduto" multiple></select>
		</div>
	</div>
	<div hidden style="margin: 0% 2%;" class="row">
		<div class="form-group col-xs-4 col-md-4" style="align-self: flex-end;">
			<button class="btn btn-primary" name="consultar" id="consultar" type="button">Consultar</button>
		</div>
	</div>
		<!--================ Start footer Area  =================-->
	<footer class="footer">
		<div class="footer-bottom">
			<div class="container">
				<div class="row d-flex">
					<p class="col-lg-12 footer-text text-center">By Cinty</p>
				</div>
			</div>
		</div>
	</footer>
	<!--================ End footer Area  =================-->
</body>

</html>