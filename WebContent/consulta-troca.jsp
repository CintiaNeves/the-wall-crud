<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Consulta de Trocas</title>
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
							<li class="nav-item"><a class="nav-link" href="index.html">Site</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Consulta</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="consulta-pedido.jsp">Pedidos</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Produtos</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="cadastro-instrumento.html">Cadastro</a></li>
									<li class="nav-item"><a class="nav-link"
										href="consulta-instrumento.html">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Estoque</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="entrada-estoque.html">Entrada</a></li>
									<li class="nav-item"><a class="nav-link"
										href="consulta-estoque.html">Consulta</a></li>
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
	<!--================Form Cadastro Area =================-->
	<section class="section-margin--small" style="margin-left: 15%;">
		<div class="billing_details">
			<div class="row">
				<div class="col-md-11">
					<!--============================= Message validation =============================-->
					<div id="backend_menssagem">
						<div
							style="${(sucesso == null || (fn:length(sucesso) == 1 && sucesso[0] == '')) 
	                   			   && (erro == null || fn:length(erro) == 1 && erro[0] == '') ? 'display:none;' : ''}"
							class="${sucesso != null ? 'alert alert-primary' : erro != null ? 'alert alert-danger' : ''}"
							role="alert">
							<c:forEach var="sucesso" items="${sucesso}">
						  		${sucesso}<br />
							</c:forEach>
							<c:forEach var="erro" items="${erro}">
						  		${erro}<br />
							</c:forEach>
						</div>
					</div>
					<!--============================= Message validation =============================-->

				</div>
				<div class="col-md-10">
					<div class="col-md-12 form-group p_star">
						<h3>Consulta de Trocas</h3>
					</div>
					<div>
						<form action="troca" method="post">
							<input type="hidden" name="admin" value="true">
							<div class="row">
								<div class="col-md-6 form-group p_star">
									<div class="col-md-3 form-group p_star">
										<button id="listar" class="btn btn-secondary" type="submit"
											name="btnOperacao" id="btnOperacao" value="CONSULTAR">Listar
											todas</button>
									</div>
								</div>
								<div class="col-md-6 form-group p_star">
									<div class="col-md-3 form-group p_star">
										<button class="btn btn-secondary" type="submit"
												name="btnOperacao" value="ALTERAR">Gerenciar Trocas</button>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-small">
									<div class="input-group ml-3">
										<div class="input-group-prepend">
											<button class="btn btn-outline-secondary" type="submit"
												name="btnOperacao" value="CONSULTAR">Filtrar por
												Status</button>
										</div>
										<select class="form-control col-md-12" id="status"
											name="status">
											<c:forEach var="s" items="${status}">
													<option value="${s.id}"
														${s.id == troca.status.id ? "selected=selected" : ""}>${s.descricao}</option>
												</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<hr />
						</form>
						<div id="">
							<table class="table table-striped">
								<thead class="thead-dark">
									<tr style="text-align: center;">
										<th>Número</th>
										<th>Cliente</th>
										<th>Data</th>
										<th>Status</th>
										<th>Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="troca" items="${trocas}">
										<tr style="text-align: center;">
											<td style="padding-top: 19px;">${troca.numeroPedidoTroca}</td>
											<td style="padding-top: 19px;">${troca.cliente.nome}</td>
											<td style="padding-top: 19px;">${troca.data}</td>
											<td style="padding-top: 19px;">${troca.status.descricao}</td>
											<td style="padding-top: 19px;">
												<form action="troca" method="post">
													<input type="hidden" name="id" value="${troca.id}" />
													<button class="btn btn-link" type="submit"
														name="btnOperacao" value="CONSULTARBYID">Gerenciar</button>
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Form Cadastro Area =================-->



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
	
</script>
</html>