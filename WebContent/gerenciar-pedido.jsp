<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Gerenciar Pedido</title>
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
							<li class="nav-item"><a class="nav-link" href="index.html">Site</a></li>
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
								role="button" aria-haspopup="true" aria-expanded="false">Relat�rios</a>
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
					<form class="row contact_form" action="pedido" method="post"
						novalidate="novalidate">
						<div class="col-md-12 form-group p_star">
							<h3>Pedido</h3>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="numero">N�mero</label> <input type="text"
								class="form-control" id="numero" name="numero" readonly
								value="${pedido.numero}">
								<input type="hidden"
								class="form-control" id="id-pedido" name="id-pedido" value="${pedido.id}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label class="col-md-12" for="grp-precificacao">Status</label> <select
								class="form-control" id="status" name="status">
								<c:forEach var="s" items="${status}">
									<option value="${s.id}"
										${s.id == pedido.status.id ? "selected=selected" : ""}>${s.descricao}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="data">Data de Emiss�o</label> <input type="text"
								class="form-control" id="data" name="data" readonly
								value="${pedido.data}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="cod-cli">C�digo Cliente</label> <input type="text"
								class="form-control" id="cod-cli" name="cod-cli" readonly
								value="${pedido.cliente.codigo}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="cpf">CPF Cliente</label> <input type="text"
								class="form-control" id="cpf" name="cpf" readonly
								value="${pedido.cliente.cpf}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="nome-cli">Nome Cliente</label> <input type="text"
								class="form-control" id="nome-cli" name="nome-cli" readonly
								value="${pedido.cliente.nome}">
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
	
</script>
</html>