<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Meus Pedidos</title>
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
										href="grafico.html">Vendas</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->



	<!--================Form Cadastro Area =================-->
	<section class="section-margin" style="margin-left: 15%;">
		<div class="billing_details">
			<div class="row">
				<div class="col-md-10">
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
					<form class="row contact_form" action="troca" method="POST">
						<div class="col-md-12 form-group p_star">
							<h3>Solicitação de troca</h3>
						</div>
						<div class="col-md-6 form-group p_star" id="pedido">
							<label for="first">Número do Pedido de Compra</label> <input
								type="text" class="form-control" id="first" name="numPedido"
								value="${troca.numPedidoCompra }" readonly>
						</div>
						<div class="col-md-6 form-group p_star" id="entrega">
							<label for="first">Data da Compra</label> <input type="text"
								class="form-control" id="first" name="dataPedido"
								value="${troca.dataCompra}" readonly>
								<input type="hidden" name="idPedido" value="${troca.idPedidoCompra}">
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
											<td style="padding-top: 19px;"><input class="form-control input-transparent" name="codInstrumento" type="text" value="${item.instrumento.codigo}"></input></td>
											<td style="padding-top: 19px;"><input class="form-control input-transparent" type="text" value="${item.instrumento.descricao}"></input></td>
											<td style="padding-top: 19px;"><input class="form-control input-transparent" type="text" value="${item.quantidade}" name="quantidade"></td>
											<td style="padding-top: 19px;"><input class="form-control input-transparent" type="text" value="${item.instrumento.valorVenda}"></td>
											<td style="padding-top: 19px;"><input class="form-control input-transparent" name="valor" type="text" value="${item.instrumento.valorVenda * item.quantidade}"></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="col-md-12 form-group p_star">
							<label for="observacao">Observações</label>
							<textarea id="observacao" name="observacao" class=form-control></textarea>
							<input type="hidden" value="" id="cliente-id" name="idCliente">
						</div>
						<div class="col-md-12 form-group">
							<div class="col-md-6 form-group">
								<button class="btn btn-primary" type="submit" name="btnOperacao" value="SALVAR">Solicitar</button>
							</div>
						</div>
					</form>
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
</script>
</html>