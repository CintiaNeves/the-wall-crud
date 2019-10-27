<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Carrinho</title>
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
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Cliente</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
									<li class="nav-item"><a class="nav-link"
										href="register.html">Cadastro</a></li>
									<li class="nav-item"><a class="nav-link"
										href="tracking-order.html">Pedidos</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link" href="contact.html">Administrador</a></li>
						</ul>
						<ul class="nav-shop">
							<li class="nav-item">
								<button>
									<i class="ti-search"></i>
								</button>
							</li>
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


	<!--================Cart Area =================-->
	<section class="cart_area">
		<form action="carrinho" method="POST">
			<input type="hidden" value="" id="cliente-id" name="cliente-id">
			<input type="hidden" value="" id="carrinho-id" name="carrinho-id">
			<input type="hidden" value="true" id="checkout" name="checkout">
			<div class="container">
				<div class="cart_inner">
					<div class="table-responsive">
						<fmt:setLocale value = "pt_BR"/>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Produto</th>
									<th scope="col">Preço</th>
									<th scope="col">Quantidade</th>
									<th scope="col">Total</th>
								</tr>
							</thead>
							<tbody id="itens">
								<c:forEach var="i" items="${itens}">
									<tr>
										<td>
											<div class="media">
												<div class="d-flex">
													<img src="img/product/product-sm-1.png" alt="">
												</div>
												<div class="media-body">
													<label>${i.instrumento.descricao}</label>
												</div>
											</div>
										</td>
										<td>
											<h5>
												<fmt:formatNumber value = "${i.instrumento.valorVenda}" type = "currency"/>
											</h5>
										</td>
										<td><input type="hidden" value="${carrinho.id}"
											id="carrinho-id" name="carrinho-id">
											<div class="product_count">
												<input type="number" name="quantidade" id="quantidade"
													value="${i.quantidade}" class="input-text qty">
											</div></td>
										<td>
											<h5 id="total-itens">
												<fmt:formatNumber value = "${i.total}" type = "currency"/>
											</h5>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="table-responsive">
						<table class="table">
							<thead>
							</thead>
							<tbody>
								<tr class="shipping_area">
									<td>
										<div class="cupon_text d-flex align-items-center">
											<h6>Frete</h6>
										</div>
									</td>
									<td>
										<div class="shipping_box">
											<input type="text" placeholder="CEP" id="cep" required>
											<label id="msg-cep" style="color: red; display: none;">Digite o CEP!</label>
											<button class="btn btn-primary" id="calcular-frete">Calcular</button>
										</div>
									</td>
									<td>
										<div class="shipping_box">
											<input type="hidden" id="frete" readonly> <input
												type="hidden" id="valorFrete" name="valorFrete" value="">
										</div>
									</td>
								</tr>
								<tr class="shipping_area">
									<td>
										<div class="cupon_text d-flex align-items-center">
											<h6>Tem um cupom?</h6>
										</div>
									</td>
									<td>
										<div class="shipping_box">
											<input type="text" id="cupom"
												placeholder="Cupom de troca ou promocional" name="cupom">
											<label id="msg-cupom" style="color: red; display: none;">Digite
												o código do cupom!</label>
										</div>
										<div class="shipping_box">
											<button class="btn btn-primary" id="aplicar-cupom">Aplicar</button>
										</div>
									</td>
									<td>
										<div class="shipping_box">
											<input type="hidden" id="desconto" value="" readonly>
										</div>
										<div class="shipping_box">
											<input type="hidden" id="desconto2" value="" readonly>
										</div>
									</td>
								</tr>
								<tr class="shipping_area">
									<td>
										<h5 id="total-pedido">Total
											<fmt:formatNumber value = "${carrinho.valorTotal}" type = "currency"/>
										</h5>
									</td>
									<td>
										<h5 id="totalCarrinho"></h5>
									</td>
								</tr>
								<tr class="shipping_area">
									<td>
										<div
											class="checkout_btn_inner d-flex align-items-center col-md-12">
											<div class="col-md-6">
												<a class="btn btn-primary"
													href="index.jsp?cliente=${cliente.nome}&carrinho=${cliente.carrinho.id}">Continuar
													Comprando</a>
											</div>
											<div class="col-md-6">
												<button class="btn btn-primary" type="submit"
													name="btnOperacao" value="CONSULTARBYID">Checkout</button>
											</div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</form>

	</section>
	<!--================End Cart Area =================-->


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

	function getIdCliente() {
		let cookies = document.cookie.split(";");
		let idCliente = cookies[1].split("=");
		return idCliente[1];
	}

	function getIdCarrinho() {
		let cookies = document.cookie.split(";");
		let idCarrinho = cookies[2].split("=");
		return idCarrinho[1];
	}

	$("#nome-cli")[0].textContent = getNomeCliente();
	$("#cliente-id")[0].value = getIdCliente();
	$("#carrinho-id")[0].value = getIdCarrinho();

	$("#calcular-frete").click(function() {
		event.preventDefault();
		let cep = $("#cep")[0].value;
		let idCarrinho = $("#carrinho-id")[0].value;
		if (cep.trim() === "") {
			$("#msg-cep")[0].style.display = "";
		} else {
			$("#msg-cep")[0].style.display = "none";
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/the-wall-crud/carrinho",
				dataType : "json",
				data : {
					retornoJson: true,
					btnOperacao: "CONSULTAR",
					cep,
					idCarrinho,
				},
				success : function(response) {
					if (response.erro) {
						$("#calcular-frete").removeAttr("disabled");
					} else {
						$("#calcular-frete").attr("disabled", "disabled");
						$("#frete").val(response.valor);
						$("#frete")[0].type = "text";
						$("#valorFrete").val(response.valorFrete);
					}
				},
				error : function(error) {
					$("#calcular-frete").removeAttr("disabled");
					console.log(error);
				}
			});
		}

	});

	$("#aplicar-cupom").click(function() {
		event.preventDefault();
		let cupom = $("#cupom")[0].value;

		if (cupom.trim() === "") {
			$("#msg-cupom")[0].style.display = "";
		} else {
			$("#msg-cupom")[0].style.display = "none";
			let idCarrinho = $("#carrinho-id")[0].value
			$.ajax({
				type : "POST",
				url : "http://localhost:8080/the-wall-crud/carrinho",
				dataType : "json",
				data : {
					retornoJson : true,
					btnOperacao : "CONSULTAR",
					cupom : cupom,
					idCarrinho : idCarrinho,
				},
				success : function(response) {
					if (response.erro) {
						$("#msg-cupom").text(response.erro);
						$("#msg-cupom")[0].style.display = "";
					} else {
						$("#desconto").val(response.valor);
						$("#desconto")[0].type = "text";
						$("#aplicar-cupom")[0].style.display = "none";
						calcularTotal();
					}
				},
				error : function(error) {
					console.log(error);
				}
			});
		}

	});
	
	function calcularTotal(){
		
		var itens = $("#total-itens")[0].textContent;
		itens = itens.replace("R$ " , "");
		var frete = $("#valorFrete")[0].value;
		var cupom = $("#desconto")[0].value;
		cupom = cupom.replace("R$ ", "");
		cupom = cupom.replace(",", ".");
		
		var total = new Number(itens) + new Number(frete) + new Number(cupom);
		
		$("#total-pedido")[0].textContent = "R$ " + total.toFixed(2);
		
	};
	
</script>
</html>