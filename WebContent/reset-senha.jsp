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
<body onload="validResetSenha()">
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
							<li class="nav-item"><a class="nav-link" href="login.jsp"></a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false"></a>
								<ul class="dropdown-menu">
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
					<div id="backend_menssagem" class="col-md-3">
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
						<div id="backend_menssagem" class="col-md-3">
							<a class="btn btn-primary" href="login.jsp" id="link"
								style="display: none; float: left;" >Voltar para o login</a>
						</div>
					</div>
					<!--============================= Message validation =============================-->
				</div>
				<div class="col-lg-3"></div>
				<div class="col-lg-6">
					<input type="hidden" value="${ok}" id="ok">
					<div class="login_form_inner">
						<h3 id="titulo">Redefinição de Senha</h3>
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
							<div class="col-md-12 form-group" id="div-confSenha">
								<input type="password" class="form-control" id="confSenha"
									name="confSenha" placeholder="Confirma Senha"
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Confirma Senha'">
							</div>
							<div class="col-md-12 form-group">
								<input type="hidden" id="cadastro" value="${cadastro}">
								<button type="submit" value="ALTERAR" class="btn btn-primary"
									id="btnOperacao" name="btnOperacao">Alterar</button>
							</div>
						</form>
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
	function validResetSenha() {
		let ok = $("#ok")[0].value;
		if (ok) {
			$("#nome").prop("disabled", true);
			$("#senha").prop("disabled", true);
			$("#confSenha").prop("disabled", true);
			$("#btnOperacao").prop("disabled", true);
			$("#link")[0].style.display = "";
		}
	};
</script>
</html>