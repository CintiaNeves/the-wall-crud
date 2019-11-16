<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Resumo</title>
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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">
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
							<li class="nav-item active"><a class="nav-link"
								href="index.jsp">Início</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Categorias</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="bateria.html">Baterias</a></li>
									<li class="nav-item"><a class="nav-link" href="corda.html">Cordas</a></li>
									<li class="nav-item"><a class="nav-link" href="piano.html">Pianos</a></li>
									<li class="nav-item"><a class="nav-link" href="sopro.html">Sopro</a></li>
								</ul></li>
						</ul>
						<ul class="nav-shop">
							<li class="nav-item"><button>
									<i class="ti-shopping-cart"></i><span class="nav-shop__circle"></span>
								</button></li>
							<li class="nav-item"><span> <i
									class="material-icons size"> account_circle </i> <label
									id="nome-cli"></label>
							</span></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->

	<!--================Order Details Area =================-->
	<section class="order_details section-margin--small">
		<div class="container">
			<p class="text-center billing-alert">Obrigado. Seu pedido foi
				enviado para processamento.</p>
			<div class="row mb-5">
				<div class="col-md-4 col-xl-4 mb-4 mb-xl-0">
					<div class="confirmation-card">
						<h3 class="billing-title">Dados do Pedido</h3>
						<table class="order-rable">
							<tr>
								<td>Número:</td>
								<td>${pedido.numero}</td>
							</tr>
							<tr>
								<td>Data:</td>
								<td>${pedido.data}</td>
							</tr>
							<tr>
								<td>Total:</td>
								<td><fmt:formatNumber value="${pedido.total}" type="currency" /></td>
							</tr>
							<tr>
								<td>Status:</td>
								<td>${pedido.status.descricao}</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="col-md-4 ">
					<div class="confirmation-card">
						<h3 class="billing-title">Dados do Pagamento</h3>
						<table class="order-rable">
							<tr>
								<td>Nº Cartões:</td>
								<td>${pedido.qtdCartoes}</td>
							</tr>
							<tr>
								<td>Nº de Parcelas:</td>
								<td>${pedido.formasPagamento[0].parcelas}</td>
							</tr>
							<tr>
								<td>Valor Parcela:</td>
								<td><fmt:formatNumber value="${pedido.formasPagamento[0].valor / pedido.formasPagamento[0].parcelas}" type="currency" /></td>
							</tr>
							<tr>
								<td>Cupons:</td>
								<td><fmt:formatNumber value="${pedido.desconto}" type="currency" /></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="col-md-4 ">
					<div class="confirmation-card">
						<h3 class="billing-title">Dados da entrega</h3>
						<table class="order-rable">
							<tr>
								<td>${pedido.endereco.tpLogradouro}:</td>
								<td>${pedido.endereco.logradouro},
									${pedido.endereco.numero}</td>
							</tr>
							<tr>
								<td>Cidade:</td>
								<td>${pedido.endereco.pais.estado.cidade.nome}</td>
							</tr>
							<tr>
								<td>País:</td>
								<td>${pedido.endereco.pais.nome}</td>
							</tr>
							<tr>
								<td>CEP:</td>
								<td>${pedido.endereco.cep}</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="order_details_table">
				<h2>Detalhes do pedido</h2>
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Produto</th>
								<th scope="col">Valor Unitário</th>
								<th scope="col">Quantidade</th>
								<th scope="col">Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${pedido.itens}">
								<tr>
									<td>
										<p>${i.instrumento.descricao}</p>
									</td>
									<td>
										<p><fmt:formatNumber value="${i.instrumento.valorVenda}" type="currency" /></p>
									</td>
									<td>
										<h5>${i.quantidade}</h5>
									</td>
									<td>
										<p><fmt:formatNumber value="${i.totalItem}" type="currency" /></p>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td>
									<h4>Subtotal</h4>
								</td>
								<td>
									<h5></h5>
								</td>
								<td>
									<h5></h5>
								</td>
								<td>
									<p><fmt:formatNumber value="${pedido.subtotal}" type="currency" /></p>
								</td>
							</tr>
							<tr>
								<td>
									<h4>Descontos</h4>
								</td>
								<td>
									<h5></h5>
								</td>
								<td>
									<p><fmt:formatNumber value="${pedido.desconto}" type="currency" /></p>
								</td>
							</tr>
							<tr>
								<td>
									<h4>Frete</h4>
								</td>
								<td>
									<h5></h5>
								</td>
								<td>
									<p><fmt:formatNumber value="${pedido.frete.valorFrete}" type="currency" /></p>
								</td>
							</tr>
							<tr>
								<td>
									<h4>Total</h4>
								</td>
								<td>
									<h5></h5>
								</td>
								<td>
									<h4><fmt:formatNumber value="${pedido.total}" type="currency" /></h4>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!--================End Order Details Area =================-->

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
function getNomeCliente() {
	let cookies = document.cookie.split(";");
	let nomeCliente = cookies[0].split("=");
	return nomeCliente[1];
}

$("#nome-cli")[0].textContent = getNomeCliente();
</script>
</html>