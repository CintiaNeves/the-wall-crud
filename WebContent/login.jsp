<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Login</title>
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
							<li class="nav-item"><a class="nav-link" href="index.jsp">Inicio</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Categorias</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="bateria.jsp">Baterias</a></li>
									<li class="nav-item"><a class="nav-link" href="corda.jsp">Cordas</a></li>
									<li class="nav-item"><a class="nav-link" href="piano.jsp">Piano</a></li>
									<li class="nav-item"><a class="nav-link" href="sopro.jsp">Sopro</a></li>
								</ul></li>
							<li class="nav-item active submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Área
									do Cliente</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="meus-pedidos.jsp">Meus Pedidos</a></li>
								</ul></li>
						</ul>
						<ul class="nav-shop">
							<li class="nav-item"><button>
									<i class="ti-search"></i>
								</button></li>
							<li class="nav-item"><button>
									<i class="ti-shopping-cart"></i><span class="nav-shop__circle"></span>
								</button></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->

	<!--================Login Box Area =================-->
	<section class="login_box_area section-margin--small">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
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
				<div class="col-lg-6">
					<div class="login_box_img">
						<div class="hover">
							<h4 id="titulo-h4">Novo por aqui?</h4>
							<p>Existem muitas vantagens em ser cliente The Wall,
								aproveite!</p>
							<button class="btn btn-primary" id="btn-criar-conta"
								style="display:">Criar Conta</button>
							<button class="btn btn-primary" id="reload-login"
								style="display: none">Login</button>
						</div>
					</div>
				</div>
				<div class="col-lg-6" id="reset" style="display: none">
					<div class="login_form_inner">
						<h3 id="titulo">Recuperação de senha</h3>
							<div class="col-md-12 form-group" >
								<input type="email" class="form-control" id="user-name" name="nome"
									placeholder="E-mail" value="${usuario.nome}"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'E-mail'" required>
							</div>
							<div class="col-md-12 form-group">
								<button type="button" id="reset-senha" class="btn btn-primary">Recuperar</button><br/>
								<button type="button" id="reset-login" class="btn btn-link">Entrar na minha conta</button>
								
							</div>
							
					</div>
				</div>
				<div class="col-lg-6" id="logar" style="display: ">
					<div class="login_form_inner">
						<h3 id="titulo">Entrar na sua Conta</h3>
						<form id="form-login" class="row login_form" action="login"
							method="POST">
							<div class="col-md-12 form-group">
								<input type="text" class="form-control" id="nome" name="nome"
									placeholder="E-mail" value="${usuario.nome}"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'E-mail'" required>
							</div>
							<div class="col-md-12 form-group">
								<input type="password" class="form-control" id="senha"
									name="senha" placeholder="Senha"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Senha'" required>
							</div>
							<div class="col-md-12 form-group" id="div-confSenha"
								style="display: none">
								<input type="password" class="form-control" id="confSenha"
									name="confSenha" placeholder="Confirma Senha"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Confirma Senha'">
							</div>
							<div class="col-md-12 form-group">
								<input type="hidden" id="cadastro" value="${cadastro}">
								<button type="submit" value="CONSULTAR" class="btn btn-primary"
									id="btnOperacao" name="btnOperacao">Entrar</button>
							</div>
						</form>
						<button type="button" class="btn btn-link" id="btn-reset">Esqueci minha senha</button>
					</div>
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
	var cadastro = document.querySelector("#cadastro");

	if (cadastro.value == 1) {
		$("#div-confSenha")[0].style.display = "";
		$("#btnOperacao")[0].value = "SALVAR";
		$("#btnOperacao")[0].textContent = "Criar Conta";
		$("#btn-criar-conta")[0].style.display = "none";
		$("#reload-login")[0].style.display = "";
		$("#titulo")[0].textContent = "Criar conta";
		document.querySelector("#cadastro").value = 0;
	}

	$("#nome").change(function() {
		$("#backend_menssagem").html("");
		$("#backend_menssagem").removeClass("alert-danger");
	});

	$("#senha").change(function() {
		$("#backend_menssagem").html("");
		$("#backend_menssagem").removeClass("alert-danger");
	});

	$("#btn-criar-conta").click(function() {
		event.preventDefault();
		$("#div-confSenha")[0].style.display = "";
		$("#btnOperacao")[0].value = "SALVAR";
		$("#btnOperacao")[0].textContent = "Criar Conta";
		$("#titulo")[0].textContent = "Criar conta";
		$("#reload-login")[0].style.display = "";
		$("#titulo-h4")[0].textContent = "Entrar na sua conta";
		this.style.display = "none";
	});

	$("#reload-login").click(function() {
		location.href = "http://127.0.1.1:8080/the-wall-crud/login.jsp";
	})

	$("#btnOperacao")
			.click(
					function() {
						document.cookie = "nomeCliente=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
						document.cookie = "idCliente=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
						document.cookie = "idCarrinho=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
					});
	
	$("#btn-reset").click(function(){
		$("#logar")[0].style.display = "none";
		$("#reset")[0].style.display = "";
	});
	
	$("#reset-login").click(function (){
		$("#logar")[0].style.display = "";
		$("#reset")[0].style.display = "none";
	});
	
	$("#reset-senha").click(function() {
		let nome = $("#user-name")[0].value;
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/the-wall-crud/login",
			dataType : "json",
			data : {
				retornoJson : true,
				btnOperacao : "CONSULTAR",
				nome : nome,
				reset : true,
			},
			success : function(response) {
				if (response.erro) {
					$("#backend_menssagem")[0].innerHTML = response.erro;
					$("#backend_menssagem").removeAttr("style");
					$("#backend_menssagem").addClass("alert alert-danger");
				} else {
					$("#backend_menssagem")[0].innerHTML = response.mensagem;
					$("#backend_menssagem").removeAttr("style");
					$("#backend_menssagem").addClass("alert alert-success");
				}
			},
			error : function(error) {
				console.log(error);
			}
		});
	});
</script>
</html>