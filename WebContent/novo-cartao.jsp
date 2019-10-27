<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Entrada Nota Fiscal</title>
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
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
                        <ul class="nav navbar-nav menu_nav ml-auto mr-auto">
                            <li class="nav-item"><a class="nav-link" href="index.html">Inicio</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                                    aria-haspopup="true" aria-expanded="false">Categorias</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="bateria.html">Baterias</a></li>
                                    <li class="nav-item"><a class="nav-link" href="corda.html">Cordas</a></li>
                                    <li class="nav-item"><a class="nav-link" href="piano.html">Piano</a></li>
                                    <li class="nav-item"><a class="nav-link" href="sopro.html">Sopro</a></li>
                                </ul>
                            </li>
                            <li class="nav-item active submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                                    aria-haspopup="true" aria-expanded="false">Cliente</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                                    <li class="nav-item"><a class="nav-link" href="tracking-order.html">Pedidos</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav-shop">
                            <li class="nav-item"><button><i class="ti-search"></i></button></li>
                            <li class="nav-item"><button>
                            <i class="ti-shopping-cart"></i>
                            <span class="nav-shop__circle"></span></button></li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <!--================ End Header Menu Area =================-->

    <!--================Login Box Area =================-->
    <section class="section-margin" style="margin-left: 15%;">
        <div class="billing_details">
            <div class="row col-md-12" >
                <div class="col-md-10">
                	<form action="">
                		<div class="col-md-12 form-group p_star">
                            <h3>Cartão de Crédito</h3>
                        </div>
                         <div class="form-group col-md-6">
                            <label class="col-md-12" for="bandeira">Bandeira</label>
                            <select class="form-control" id="bandeira">
                                <option>Selecione...</option>
                                <option>Visa</option>
                                <option>Mastercard</option>
                                <option>Elo</option>
                                <option>Amex</option>
                            </select>
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <label for="num-cartao"></label>
                           
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <label for="num-cartao">Numero do cartão</label>
                            <input type="text" class="form-control" id="num-cartao" name="num-cartao">
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <label for="nome-cartao">Nome impresso no cartão</label>
                            <input type="text" class="form-control" id="nome-cartao" name="nome-cartao">
                        </div>
                        <div class="col-md-6 form-group p_star">
                            <label for="cod">Código de segurança</label>
                            <input type="text" class="form-control" id="cod" name="cod">
                        </div>
                        <div class="col-md-3 form-group">
                        	<a href="checkout-2.jsp" class="btn btn-primary">Adicionar</a>
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
</html>