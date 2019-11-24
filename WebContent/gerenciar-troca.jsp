<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Gerenciar Troca</title>
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
<style>
.input-transparent {
	margin-bottom: 5px;
	border: 0;
	background-color: rgba(0, 0, 0, 0);
}

.table-striped tbody tr:nth-of-type(even) {
	background-color: #c1c1c1;
}
</style>
</head>
<body>
	<!--================ Start Header Menu Area =================-->
	<header class="header_area">
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container">
					<a class="navbar-brand logo_h" href="index.html">
						<h1>The Wall</h1>
					</a>
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
								role="button" aria-haspopup="true" aria-expanded="false">Pedidos</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="category.html">Consulta</a></li>
									<li class="nav-item"><a class="nav-link"
										href="single-product.html">Gerenciar</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Produtos</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="consulta-instrumento.html">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Estoque</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.html">Entrada</a></li>
									<li class="nav-item"><a class="nav-link"
										href="register.html">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Relatórios</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="grafico.html">Vendas</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->

	<!--================Login Box Area =================-->
	<section class="section-margin" style="margin-left: 30%;">
		<div class="billing_details">
			<div class="row">
				<div class="col-md-8">
					<form class="row contact_form" action="troca" method="post"
						novalidate="novalidate">
						<div class="col-md-12 form-group p_star">
							<h3>Pedido</h3>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="numero">Número</label> <input type="text"
								class="form-control" id="numero" name="numero" readonly
								value="${troca.numeroPedidoTroca}"> <input type="hidden"
								class="form-control" id="id" name="id" value="${troca.id}">
							<input type="hidden" class="form-control" id="valor" name="valor"
								value="${troca.valor}"> <input type="hidden"
								class="form-control" id="cliente-id" name="idCliente" value="">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="data">Status</label> <input type="text"
								class="form-control" id="status" name="status-desc" readonly
								value="${troca.status.descricao}"> <input type="hidden"
								class="form-control" id="status" name="status" readonly
								value="${troca.status.id}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="data">Data de Emissão</label> <input type="text"
								class="form-control" id="data" name="data" readonly
								value="${troca.data}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="cpf">CPF Cliente</label> <input type="text"
								class="form-control" id="cpf" name="cpf" readonly
								value="${troca.cliente.cpf}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="nome-cli">Nome Cliente</label> <input type="text"
								class="form-control" id="nome-cli" name="nome-cli" readonly
								value="${troca.cliente.nome}">
						</div>
						<div
							class="form-check form-check-inline col-md-2 form-group p_star">
							<input class="form-check-input" type="radio" name="aprova"
								id="aprova" value="true"> <label
								class="form-check-label" for="exampleRadios2"> Aprova </label>
						</div>
						<div
							class="form-check form-check-inline col-md-2 form-group p_star">
							<input class="form-check-input" type="radio" name="aprova"
								id="reprova" value="false"> <label
								class="form-check-label" for="exampleRadios2"> Reprova </label>
						</div>
						<div class="col-md-6 form-group p_star" id="cupom"
							style="display: none">
							<label for="nome-cli">Código do Cupom</label> <input type="text"
								class="form-control" id="codCupom" name="codCupom" readonly
								value="">
						</div>
						<div class="col-md-12 form-group p_star">
							<table class="table table-striped">
								<thead class="thead-dark">
									<tr style="text-align: center;">
										<th>Código</th>
										<th>Produto</th>
										<th>Quantidade</th>
										<th>Valor Unitário</th>
										<th>Valor Total</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${troca.itens}">
										<tr style="text-align: center;">
											<td style="padding-top: 19px;"><input
												class="form-control input-transparent" name="codInstrumento"
												type="text" value="${item.instrumento.codigo}" readonly></input></td>
											<td style="padding-top: 19px;"><input
												class="form-control input-transparent" type="text"
												value="${item.instrumento.descricao}" readonly></input></td>
											<td style="padding-top: 19px;"><input
												class="form-control input-transparent" type="number"
												value="${item.quantidade}" name="quantidade" min="1"
												max="${item.quantidade}" id="qtd-${item.instrumento.id}"
												readonly></td>
											<td style="padding-top: 19px;"><input
												class="form-control input-transparent" type="text"
												value="${item.instrumento.valorVenda}" readonly
												id="valor-${item.instrumento.id}"></td>
											<td style="padding-top: 19px;"><input
												class="form-control input-transparent" name="valor"
												type="text"
												value="${item.instrumento.valorVenda * item.quantidade}"
												id="total-${item.instrumento.id}" readonly></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="col-md-12 form-group">
							<div class="col-md-6 form-group">
								<button class="btn btn-primary" type="submit" name="btnOperacao"
									value="ALTERAR">Atualizar</button>
							</div>
						</div>
					</form>
				</div>

			</div>
		</div>
	</section>
	<!--================End Login Box Area =================-->

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


	<script src="vendors/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
	<script src="vendors/skrollr.min.js"></script>
	<script src="vendors/owl-carousel/owl.carousel.min.js"></script>
	<script src="vendors/nice-select/jquery.nice-select.min.js"></script>
	<script src="vendors/jquery.ajaxchimp.min.js"></script>
	<script src="vendors/mail-script.js"></script>
	<script src="js/main.js"></script>
</body>
<script>
	function getIdCliente() {
		let cookies = document.cookie.split(";");
		let idCliente = cookies[1].split("=");
		return idCliente[1];
	}

	function getNomeCliente() {
		let cookies = document.cookie.split(";");
		let nomeCliente = cookies[0].split("=");
		return nomeCliente[1];
	}

	$("#cliente-id")[0].value = getIdCliente();
	$("#nome-cli")[0].textContent = getNomeCliente();

	$("#aprova").click(function() {

		$("#cupom")[0].style = "display: ''";
		let cod = "TRCPC";
		var valor = $("#valor")[0].value;
		var result = valor.split(".");
		valor = result[0];
		let ano = new Date().getFullYear();
		let random = Math.floor(Math.random() * 10000);
		cod = cod.concat(ano.toString()).concat(valor).concat(random);

		$("#codCupom")[0].value = cod;
	});

	$("#reprova").click(function() {
		$("#cupom")[0].style = "display: none";
		$("#codCupom")[0].value = "";
	});
</script>
</html>