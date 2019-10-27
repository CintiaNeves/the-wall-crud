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

span {
	float: right;
}
</style>

</head>
<body onload="carregaCliente()">
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
							<li class="nav-item active"><a class="nav-link"
								href="index.jsp">Início</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Categorias</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="bateria.jsp">Baterias</a></li>
									<li class="nav-item"><a class="nav-link" href="corda.jsp">Cordas</a></li>
									<li class="nav-item"><a class="nav-link" href="piano.jsp">Pianos</a></li>
									<li class="nav-item"><a class="nav-link" href="sopro.jsp">Sopro</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Cliente</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.jsp">Meus
											Dados</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><span> <i
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



	<!--================Checkout Area =================-->
	<section class="checkout_area section-margin--small">
		<div class="container">
			<div class="billing_details">
				<div class="row">
					<div class="col-lg-4">
						<table class="table table-striped">
							<thead>
								<tr>
									<th colspan="2"><h2>Meus Pedidos</h2></th>
								</tr>
								<tr>
									<th>Número</th>
									<th>Status</th>
									<th>Detalhes</th>
								</tr>
							</thead>
							<tbody id="bodyPedidos">
							</tbody>
							<tfoot>
							</tfoot>
						</table>
						<div class="order_box">
							<h2>Meus Pedidos</h2>
							
							<ul class="list">
								<li>
									<h4 style="float: left;">Número</h4>
									<h4 style="float: right;">Status</h4>
								</li>
								<li>
									<div style="float: left;">Número</div>
									<div style="float: right;">Status</div>
								</li>
								<li>
									<div style="float: left;">Número</div>
									<div style="float: right;">Status</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-8" id="faturamento">
						<h3>Detalhes do pedido</h3>
						<form class="row contact_form" action="pedido" method="post"
							novalidate="novalidate">
							<input type="hidden" value="" id="cliente-id" name="cliente-id">
							<input type="hidden" value="true" id="consulta" name="consulta">
							<div class="col-md-6 form-group p_star">
								<label for="first">Nome</label> <input type="text"
									class="form-control" id="nome" value="${cliente.nome}"
									readonly>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="last">CPF</label> <input type="text"
									class="form-control" id="cpf" value="${cliente.cpf}" readonly>
							</div>
							<div class="col-md-6 form-group p_star" id="pedido">
								<label for="first">Número do Pedido</label> <input type="text"
									class="form-control" id="numero" value="${pedido.numero}"
									readonly>
							</div>
							<div class="col-md-6 form-group p_star" id="data">
								<label for="first">Data </label> <input type="text"
									class="form-control" id="data" value="${pedido.data}" readonly>
							</div>
							<div id="tabela-pedidos">
								<h3>Itens</h3>
								<h6>Atenção! Solicitação de troca apenas até 30 dias após a
									compra.</h6>
								<table class="table table-striped">
									<thead>
										<tr>
											<th>Produto</th>
											<th>Quantidade</th>
											<th>Preço</th>
											<th>Ações</th>
										</tr>
									</thead>
									<tbody id="tbody_itens">
										<tr>
											<c:forEach var="item" items="${pedido.itens}">
												<td class="m-0 p-0 pt-1"><label
													class="form-control input-transparent" id="descricao">${item.instrumento.descricao}</label>
												</td>
												<td class="m-0 p-0 pt-1"><label
													class="form-control input-transparent" id="quantidade">${item.quantidade}</label>
												</td>
												<td class="m-0 p-0 pt-1"><label
													class="form-control input-transparent" id="descricao">R$
														${item.instrumento.valorVenda }</label></td>
												<td class="m-0 p-0 pt-1">
													<div class="form-check">
														<input type="checkbox" value="${item.id}"
															name="item_${item.id}" id="${item.id}" /> <label
															for="${item.id}">Solicitar Troca</label>
													</div>
												</td>
											</c:forEach>
									</tbody>
								</table>
								<div class="col-md-12 form-group">
									<div class="col-md-6 form-group">
										<button class="btn btn-primary" type="submit"
											name="btnOperacao" value="SALVAR">Solicitar Troca</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!--================End Checkout Area =================-->

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

	function carregaCliente() {
		
		let idCliente = getIdCliente();
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/the-wall-crud/registro",
			dataType: "json",
			data: {
				retornoJson: true,
				btnOperacao: "CONSULTARBYID",
				idCliente: idCliente,
			},
			success: function(response) {
				if(response.erro) {
					
				} else {
					$("#nome").val(response.nome);
					$("#cpf").val(response.cpf);
					carregaPedidos();
				}
			},
			error: function(error) {
				console.log(error);
			}
		});		
	};
	
function carregaPedidos() {
		
		let idCliente = getIdCliente();
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/the-wall-crud/pedido",
			dataType: "json",
			data: {
				retornoJson: true,
				btnOperacao: "CONSULTARBYID",
				idCliente: idCliente,
			},
			success: function(response) {
				if(response.erro) {
					
				} else {
					for(let pedido of response) {
						let linha = "<tr><td>" + pedido.numero + "</td><td>" +
							pedido.status.descricao + "</td><td>" +
							"<button onclick='carregarItens(" + pedido.id + ")' type='button' id='" + pedido.id + "' class='btn btn-link'>Visualizar</button></td></tr>";
						$("#bodyPedidos").append(linha);
					}
				}
			},
			error: function(error) {
				console.log(error);
			}
		});		
	};
	function carregarItens(id) {
		console.log(id);
	};
</script>
</html>