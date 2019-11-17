<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Home</title>
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
.prices {
	
}
</style>
</head>
<body onload="inicializaCookies()">
	<!--================ Start Header Menu Area =================-->
	<header class="header_area">
		<input type="hidden" value="${cliente.nome}" id="cliente-nome"
			name="cliente-nome"> <input type="hidden"
			value="${cliente.id}" id="cliente-id" name="cliente-id"> <input
			type="hidden" value="${cliente.carrinho.id}" id="carrinho-id"
			name="carrinho-id">
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
									<li class="nav-item"><a class="nav-link"
										href="${cliente.nome != null ? 'meus-pedidos.jsp' : 'login.jsp' }">
											${cliente.nome != null ? 'Meus Pedidos' : 'Logoff' }</a></li>
									<li class="nav-item"><a class="nav-link"
										href="${cliente.nome != null ? 'minhas-trocas.jsp' : 'login.jsp' }">
											${cliente.nome != null ? 'Minhas trocas' : 'Cadastro' }</a></li>
									<li class="nav-item"><a class="nav-link"
										href="meus-pedidos.jsp">Meus Pedidos</a></li>
									<li class="nav-item"><a class="nav-link"
										href="minhas-trocas.jsp">Minhas Trocas</a></li>

								</ul></li>
						</ul>
						<ul class="nav-shop">
							<li class="nav-item">
								<button>
									<i class="ti-search"></i>
								</button>
							</li>
							<li class="nav-item"><a href="carrinho.jsp"><button
										id="direcionaCarrinho">
										<i class="ti-shopping-cart"></i><span class="nav-shop__circle">${cliente.carrinho.quantidadeItem}</span>
									</button></a></li>
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

	<!--================ Hero banner start =================-->
	<section class="hero-banner">
		<div class="container">
			<div class="row no-gutters align-items-center pt-60px">
				<div class="col-5 d-none d-sm-block">
					<div class="hero-banner__img">
						<img class="img-fluid" src="img/home/cover2.jpg" alt="">
					</div>
				</div>
				<div class="col-sm-7 col-lg-6 offset-lg-1 pl-4 pl-md-5 pl-lg-0">
					<div class="hero-banner__content">
						<h4>Music Megastore</h4>
						<h1>The Wall</h1>
						<p>Please, don't stop the music!</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================ Hero banner start =================-->

	<!--================ Hero Carousel start =================-->
	<section class="section-margin mt-0">
		<div class="owl-carousel owl-theme hero-carousel">
			<div class="hero-carousel__slide">
				<img src="img/home/slide3.jpg" alt="" class="img-fluid"> <a
					href="corda.jsp" class="hero-carousel__slideOverlay">
					<h3>Guitarra Elétrica</h3>
					<p>Instrumento de corda</p>
				</a>
			</div>
			<div class="hero-carousel__slide">
				<img src="img/home/slide3.jpg" alt="" class="img-fluid"> <a
					href="corda.jsp" class="hero-carousel__slideOverlay">
					<h3>Guitarra Elétrica</h3>
					<p>Instrumento de corda</p>
				</a>
			</div>
			<div class="hero-carousel__slide">
				<img src="img/home/slide3.jpg" alt="" class="img-fluid"> <a
					href="corda.jsp" class="hero-carousel__slideOverlay">
					<h3>Guitarra Elétrica</h3>
					<p>Instrumento de corda</p>
				</a>
			</div>
		</div>
	</section>
	<!--================ Hero Carousel end =================-->

	<!-- ================ trending product section start ================= -->
	<section class="section-margin calc-60px">
		<div class="container">
			<div class="section-intro pb-60px">
				<p>Popular no mercado</p>
				<h2>
					Grandes <span class="section-intro__style">Marcas</span>
				</h2>
			</div>
			<div class="row" id="card">
				
			</div>
		</div>
	</section>
	<!-- ================ trending product section end ================= -->

	<!-- ================ Best Selling item  carousel ================= -->
	<section class="section-margin calc-60px">
		<div class="container">
			<div class="section-intro pb-60px">
				<p>Popular no mercado</p>
				<h2>
					Itens de <span class="section-intro__style">Coleção</span>
				</h2>
			</div>
			<div class="owl-carousel owl-theme" id="bestSellerCarousel">
				<div class="card text-center card-product">
					<div class="card-product__img">
						<img class="img-fluid" src="" alt="">
					</div>
					<div class="card-body">
						<p>Cordas</p>
						<h4 class="card-product__title">
							<a href="produto.jsp">Bateria Ludwig</a>
						</h4>
						<p class="card-product__price">R$ 2.500,00</p>
					</div>
				</div>
				<div class="card text-center card-product">
					<div class="card-product__img">
						<img class="img-fluid" src="" alt="">
					</div>
					<div class="card-body">
						<p>Cordas</p>
						<h4 class="card-product__title">
							<a href="produto.jsp">Bateria Ludwig</a>
						</h4>
						<p class="card-product__price">R$ 2.500,00</p>
					</div>
				</div>

				<div class="card text-center card-product">
					<div class="card-product__img">
						<img class="img-fluid" src="" alt="">
					</div>
					<div class="card-body">
						<p>Cordas</p>
						<h4 class="card-product__title">
							<a href="produto.jsp">Bateria Ludwig</a>
						</h4>
						<p class="card-product__price">R$ 2.500,00</p>
					</div>
				</div>

				<div class="card text-center card-product">
					<div class="card-product__img">
						<img class="img-fluid" src="" alt="">
					</div>
					<div class="card-body">
						<p>Cordas</p>
						<h4 class="card-product__title">
							<a href="produto.jsp">Bateria Ludwig</a>
						</h4>
						<p class="card-product__price">R$ 2.500,00</p>
					</div>
				</div>

				<div class="card text-center card-product">
					<div class="card-product__img">
						<img class="img-fluid" src="" alt="">
					</div>
					<div class="card-body">
						<p>Cordas</p>
						<h4 class="card-product__title">
							<a href="produto.jsp">Bateria Ludwig</a>
						</h4>
						<p class="card-product__price">R$ 2.500,00</p>
					</div>
				</div>

				<div class="card text-center card-product">
					<div class="card-product__img">
						<img class="img-fluid" src="" alt="">
					</div>
					<div class="card-body">
						<p>Cordas</p>
						<h4 class="card-product__title">
							<a href="produto.jsp">Bateria Ludwig</a>
						</h4>
						<p class="card-product__price">R$ 2.500,00</p>
					</div>
				</div>

				<div class="card text-center card-product">
					<div class="card-product__img">
						<img class="img-fluid" src="" alt="">
					</div>
					<div class="card-body">
						<p>Cordas</p>
						<h4 class="card-product__title">
							<a href="produto.jsp">Bateria Ludwig</a>
						</h4>
						<p class="card-product__price">R$ 2.500,00</p>
					</div>
				</div>

				<div class="card text-center card-product">
					<div class="card-product__img">
						<img class="img-fluid" src="" alt="">
					</div>
					<div class="card-body">
						<p>Cordas</p>
						<h4 class="card-product__title">
							<a href="produto.jsp">Bateria Ludwig</a>
						</h4>
						<p class="card-product__price">R$ 2.500,00</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ================ Best Selling item  carousel end ================= -->


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
	function criaCookie(nomeCookie, valorCookie) {
		var data = new Date();
		data.setTime(data.getTime() + 6000000);
		document.cookie = nomeCookie + "= " + valorCookie + "; expires= "
				+ data.toUTCString() + "; path=/";
	}

	function inicializaCookies() {

		if (document.cookie == "") {
			let nome = $("#cliente-nome")[0].value;
			let id = $("#cliente-id")[0].value;
			let carrinho = $("#carrinho-id")[0].value;

			criaCookie('nomeCliente', nome);
			criaCookie('idCliente', id);
			criaCookie('idCarrinho', carrinho);

		}

		$("#nome-cli")[0].textContent = getNomeCliente();
		carregaCatalogo();
	}

	function getNomeCliente() {
		let cookies = document.cookie.split(";");
		let nomeCliente = cookies[0].split("=");
		return nomeCliente[1];
	}

	function getIdCarrinho() {
		let cookies = document.cookie.split(";");
		let idCarrinho = cookies[2].split("=");
		return idCarrinho[1];
	}

	function getIdCliente() {
		let cookies = document.cookie.split(";");
		let idCliente = cookies[1].split("=");
		return idCliente[1];
	}

	function carregaCatalogo() {
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/the-wall-crud/catalogo",
			dataType : "json",
			data : {
				retornoJson : true,
				btnOperacao : "CONSULTAR",
				async: false,
			},
			success : function(response) {
				if (response.erro) {
					$("#backend_menssagem")[0].innerHTML = response.erro;
					$("#backend_menssagem").removeAttr("style");
					$("#backend_menssagem").addClass("alert alert-danger");
				} else {
					for (let i of response.instumentos) {
						let div = "<div class='col-md-6 col-lg-4 col-xl-3'>"+
										"<div class='card text-center card-product'>"+
											"<div class='card-product__img'>"+
											"<img width='330' height='250px' class='card-img' src='"+ i.imagem +"' alt=''>"+
										"</div>"+
										"<div class='card-body'>"+
											"<p>" + i.categoria.descricao + "</p>"+
											"<h4 class='card-product__title'>"+	
											"<a class='btn btn-link' href='produto.jsp?instrumento=" + i.id + "'>" + i.descricao+"</a>"+
										    "</h4>"+
										    "<label class='card-product__price prices'>"+ i.valorVenda+"</label>"+
										"</div>"+
									"</div>"+
			                    "</div>";
								
						$("#card").append(div);
                    }
					formataPrecos();
				}
			},
			error : function(error) {
				console.log(error);
			}
		});
	};
	function formataPrecos(){
		let precos = $(".prices");
		let total = precos.length;
		for(var i = 0; i < total; i++){
			let valor = precos[i].textContent;
			//precos[i].innerText = valor.toLocaleString("pt-BR", {style: "currency", currency: "BRL"});
		}
	};
</script>
</html>