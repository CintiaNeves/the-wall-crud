<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Produto</title>
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
<body onload="carregaCookies()">
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
										href="bateria.jsp">Baterias</a></li>
									<li class="nav-item"><a class="nav-link" href="corda.jsp">Cordas</a></li>
									<li class="nav-item"><a class="nav-link" href="piano.jsp">Pianos</a></li>
									<li class="nav-item"><a class="nav-link" href="sopro.jsp">Sopro</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Cliente</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.jsp">
											${cliente.nome != null ? 'Meus Pedidos' : 'Login' }</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link" href="admin.jsp">Administrador</a></li>
						</ul>
						<ul class="nav-shop">
							<li class="nav-item"><button>
									<i class="ti-search"></i>
								</button></li>
							<li class="nav-item"><button>
									<i class="ti-shopping-cart"></i><span class="nav-shop__circle">${param['qtd'] != null ? param['qtd'] : ''}</span>
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

	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-5">
					<div class="">
						<div class="single-prd-item" id="img">
							
						</div>
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<form action="itemCarrinho" method="POST">
						<input type="hidden" name="carrinho" id="carrinho" value=""> 
						<div class="s_product_text">
							<h3 id="descricao"></h3>
							<input type="hidden" name="instrumento" id="instrumento"
								value="${param['instrumento']}">
							<h2 id="valor"></h2>
							<ul class="list">
								<li><a class="active" href="bateria.html"><span>Categoria</span>
										: Baterias</a></li>
							</ul>
							<p id="detalhes"></p>
							<div class="product_count">
								<label for="qty">Quantidade:</label> <input type="number"
									name="quantidade" id="quantidade" min="0" size="2"
									maxlength="12" value="1" title="Quantity:"
									class="input-text qty">
							</div>
							<div>
								<button class="btn btn-primary" type="submit" name="btnOperacao"
									value="SALVAR">Adicionar ao carrinho</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->

	<!--================Product Description Area =================-->
	<section class="product_description_area">
		<div class="container">
			<ul class="nav nav-tabs" id="myTab" role="tablist">
				<li class="nav-item"><a class="nav-link" id="home-tab"
					data-toggle="tab" href="#home" role="tab" aria-controls="home"
					aria-selected="true">Detalhes</a></li>
				<li class="nav-item"><a class="nav-link" id="profile-tab"
					data-toggle="tab" href="#profile" role="tab"
					aria-controls="profile" aria-selected="false">Especificações</a></li>
			</ul>
			<div class="tab-content" id="myTabContent">
				<div class="tab-pane fade show active" id="home" role="tabpanel"
					aria-labelledby="home-tab">
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="tab-pane fade" id="profile" role="tabpanel"
					aria-labelledby="profile-tab">
					<div class="table-responsive">
						<table class="table">
							<tbody>
								<tr>
									<td>
										<h5>Categoria</h5>
									</td>
									<td>
										<h5>Baterias</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Marca</h5>
									</td>
									<td>
										<h5>Ludwig</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Modelo</h5>
									</td>
									<td>
										<h5>Neon</h5>
									</td>
								</tr>
								<tr>
									<td>
										<h5>Cor</h5>
									</td>
									<td>
										<h5>Preta</h5>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Product Description Area =================-->

	<!--================ Start related Product area =================-->
	<section class="related-product-area section-margin--small mt-0">
		<div class="container">
			<div class="section-intro pb-60px">
				<p>Popular no mercado</p>
				<h2>
					Produtos <span class="section-intro__style">Semelhantes</span>
				</h2>
			</div>
			<div class="row mt-30">
				<div class="col-sm-6 col-xl-3 mb-4 mb-xl-0">
					<div class="single-search-product-wrapper">
						<div class="single-search-product d-flex">
							<a href="#"><img src="img/product/product-sm-1.png" alt=""></a>
							<div class="desc">
								<a href="#" class="title">Bateria Acústica Premium</a>
								<div class="price">R$ 1.700,00</div>
							</div>
						</div>
						<div class="single-search-product d-flex">
							<a href="#"><img src="img/product/product-sm-1.png" alt=""></a>
							<div class="desc">
								<a href="#" class="title">Bateria Acústica Premium</a>
								<div class="price">R$ 1.700,00</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-xl-3 mb-4 mb-xl-0">
					<div class="single-search-product-wrapper">
						<div class="single-search-product d-flex">
							<a href="#"><img src="img/product/product-sm-1.png" alt=""></a>
							<div class="desc">
								<a href="#" class="title">Bateria Acústica Premium</a>
								<div class="price">R$ 1.700,00</div>
							</div>
						</div>
						<div class="single-search-product d-flex">
							<a href="#"><img src="img/product/product-sm-1.png" alt=""></a>
							<div class="desc">
								<a href="#" class="title">Bateria Acústica Premium</a>
								<div class="price">R$ 1.700,00</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-xl-3 mb-4 mb-xl-0">
					<div class="single-search-product-wrapper">
						<div class="single-search-product d-flex">
							<a href="#"><img src="img/product/product-sm-1.png" alt=""></a>
							<div class="desc">
								<a href="#" class="title">Bateria Acústica Premium</a>
								<div class="price">R$ 1.700,00</div>
							</div>
						</div>
						<div class="single-search-product d-flex">
							<a href="#"><img src="img/product/product-sm-1.png" alt=""></a>
							<div class="desc">
								<a href="#" class="title">Bateria Acústica Premium</a>
								<div class="price">R$ 1.700,00</div>
							</div>
						</div>
					</div>
				</div>

				<div class="col-sm-6 col-xl-3 mb-4 mb-xl-0">
					<div class="single-search-product-wrapper">
						<div class="single-search-product d-flex">
							<a href="#"><img src="img/product/product-sm-1.png" alt=""></a>
							<div class="desc">
								<a href="#" class="title">Bateria Acústica Premium</a>
								<div class="price">R$ 1.700,00</div>
							</div>
						</div>
						<div class="single-search-product d-flex">
							<a href="#"><img src="img/product/product-sm-1.png" alt=""></a>
							<div class="desc">
								<a href="#" class="title">Bateria Acústica Premium</a>
								<div class="price">R$ 1.700,00</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================ end related Product area =================-->

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
	function carregaCookies() {
		$("#nome-cli")[0].textContent = getNomeCliente();
		$("#carrinho")[0].value = getIdCarrinho();
	};

	function getNomeCliente() {
		let cookies = document.cookie.split(";");
		let nomeCliente = cookies[0].split("=");
		return nomeCliente[1];
	}
	
	function getIdCarrinho(){
		let cookies = document.cookie.split(";");
		let idCarrinho = cookies[2].split("=");
		return idCarrinho[1];
	}
	
	function getIdCliente(){
		let cookies = document.cookie.split(";");
		let idCliente = cookies[1].split("=");
		return idCliente[1];
	}
	
	$(document).ready(function() {
		let id = $("#instrumento")[0].value;
		$.ajax({
			type: "POST",
			url: "http://localhost:8080/the-wall-crud/catalogo",
			dataType: "json",
			data: {
				retornoJson: true,
				btnOperacao: "CONSULTARBYID",
				id: id,
			},
			success: function(response) {
				if(response.erro) {
					$("#backend_menssagem")[0].innerHTML = response.erro;
					$("#backend_menssagem").removeAttr("style");
					$("#backend_menssagem").addClass("alert alert-danger");
				} else {
					$("#descricao").text(response.descricao);
					$("#valor").text(response.valorVenda);
					$("#detalhes").text(response.especificacoes);
					let src = response.imagem;
					let tag = "<img class='img-fluid' src='" + src + "'>";
					$("#img").append(tag);
					
				}
			},
			error: function(error) {
				console.log(error);
			}
		});		
		
	})
	
</script>
</html>