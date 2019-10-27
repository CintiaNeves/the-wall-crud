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
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse offset" id="navbarSupportedContent">
            <ul class="nav navbar-nav menu_nav ml-auto mr-auto">
              <li class="nav-item"><a class="nav-link" href="index.html">Inicio</a></li>
              <li class="nav-item active submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">Categorias</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="bateria.html">Baterias</a></li>
                  <li class="nav-item"><a class="nav-link" href="piano.html">Piano</a></li>
                  <li class="nav-item"><a class="nav-link" href="sopro.html">Sopro</a></li>
                </ul>
							</li>
							<li class="nav-item submenu dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">Cliente</a>
                <ul class="dropdown-menu">
                  <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                  <li class="nav-item"><a class="nav-link" href="register.html">Cadastro</a></li>
                  <li class="nav-item"><a class="nav-link" href="tracking-order.html">Pedidos</a></li>
                </ul>
              </li>
              <li class="nav-item"><a class="nav-link" href="contact.html">Administrador</a></li>
            </ul>
            <ul class="nav-shop">
                <li class="nav-item"><button><i class="ti-search"></i></button></li>
                <li class="nav-item"><button><i class="ti-shopping-cart"></i><span
                class="nav-shop__circle"></span></button></li>
              </ul>
          </div>
        </div>
      </nav>
    </div>
  </header>
	<!--================ End Header Menu Area =================-->

	<!-- ================ category section start ================= -->		  
  <section class="section-margin--small mb-5">
    <div class="container">
      <div class="row">
        <div class="col-xl-3 col-lg-4 col-md-5">
          <div class="sidebar-categories">
            <div class="head">Sub Categorias</div>
            <ul class="main-categories">
              <li class="common-filter">
                <form action="#">
                  <ul>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="men" name="brand"><label for="men">Violão</label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="women" name="brand"><label for="women">Guitarra</label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="accessories" name="brand"><label for="accessories">Cavaco</label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="footwear" name="brand"><label for="footwear">Banjo</label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="bayItem" name="brand"><label for="bayItem">Bandolin</label></li>
                  </ul>
                </form>
              </li>
            </ul>
          </div>
          <div class="sidebar-filter">
            <div class="top-filter-head">Filtros do Produto</div>
            <div class="common-filter">
              <div class="head">Marca</div>
              <form action="#">
                <ul>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="apple" name="brand"><label for="apple">Primeiro</label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="asus" name="brand"><label for="asus">Segundo</label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="gionee" name="brand"><label for="gionee">Terceiro</label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="micromax" name="brand"><label for="micromax">Quarto</label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="samsung" name="brand"><label for="samsung">Quinto</label></li>
                </ul>
              </form>
            </div>
            <div class="common-filter">
                <div class="head">Modelo</div>
                <form action="#">
                  <ul>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="apple" name="brand"><label for="apple">Primeiro</label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="asus" name="brand"><label for="asus">Segundo</label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="gionee" name="brand"><label for="gionee">Terceiro</label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="micromax" name="brand"><label for="micromax">Quarto</label></li>
                    <li class="filter-list"><input class="pixel-radio" type="radio" id="samsung" name="brand"><label for="samsung">Quinto</label></li>
                  </ul>
                </form>
              </div>
              
            <div class="common-filter">
              <div class="head">Cor</div>
              <form action="#">
                <ul>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="black" name="color"><label for="black">Preto</label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="balckleather" name="color"><label for="balckleather">Vermelho</label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="blackred" name="color"><label for="blackred">Azul</label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="gold" name="color"><label for="gold">Dourado</label></li>
                  <li class="filter-list"><input class="pixel-radio" type="radio" id="spacegrey" name="color"><label for="spacegrey">Mogno</label></li>
                </ul>
              </form>
            </div>
            <div class="common-filter">
              <div class="head">Preço</div>
              <div class="price-range-area">
                <div id="price-range"></div>
                <div class="value-wrapper d-flex">
                  <div class="price">De:</div>
                  <span>$</span>
                  <div id="lower-value"></div>
                  <div class="to">até</div>
                  <span>$</span>
                  <div id="upper-value"></div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-xl-9 col-lg-8 col-md-7">
          <!-- Start Filter Bar -->
          <div class="filter-bar d-flex flex-wrap align-items-center">
            <div>
              <div class="input-group filter-bar-search">
                <input type="text" placeholder="Search">
                <div class="input-group-append">
                  <button type="button"><i class="ti-search"></i></button>
                </div>
              </div>
            </div>
          </div>
          <!-- End Filter Bar -->
          <!-- Start Best Seller -->
          <section class="lattest-product-area pb-40 category-list">
            <div class="row">
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarras</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarra</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarras</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarras</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarra</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarras</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarras</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div> 
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarras</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-lg-4">
                <div class="card text-center card-product">
                  <div class="card-product__img">
                    <img class="card-img" src="img/product/product2.jpg" alt="">
                    <ul class="card-product__imgOverlay">
                      <li><button><i class="ti-search"></i></button></li>
                      <li><button><i class="ti-shopping-cart"></i></button></li>
                    </ul>
                  </div>
                  <div class="card-body">
                    <p>Guitarras</p>
                    <h4 class="card-product__title"><a href="#">Guitarra Ludwig</a></h4>
                    <p class="card-product__price">$150.00</p>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <!-- End Best Seller -->
        </div>
      </div>
    </div>
  </section>
	<!-- ================ category section end ================= -->		  

	<!-- ================ top product area start ================= -->	
	<section class="related-product-area">
		<div class="container">
			<div class="section-intro pb-60px">
        <p>Popular no mercado</p>
        <h2>Mais <span class="section-intro__style">Vendidos</span></h2>
      </div>
			<div class="row mt-30">
        <div class="col-sm-6 col-xl-3 mb-4 mb-xl-0">
          <div class="single-search-product-wrapper">
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                  <a href="#" class="title">Guitarra Ludwig</a>
                  <div class="price">$170.00</div>
              </div>
            </div>
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                <a href="#" class="title">Guitarra Ludwig</a>
                <div class="price">$170.00</div>
              </div>
            </div>
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                <a href="#" class="title">Guitarra Ludwig</a>
                <div class="price">$170.00</div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-sm-6 col-xl-3 mb-4 mb-xl-0">
          <div class="single-search-product-wrapper">
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                  <a href="#" class="title">Guitarra Ludwig</a>
                  <div class="price">$170.00</div>
              </div>
            </div>
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                <a href="#" class="title">Guitarra Ludwig</a>
                <div class="price">$170.00</div>
              </div>
            </div>
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                <a href="#" class="title">Guitarra Ludwig</a>
                <div class="price">$170.00</div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-sm-6 col-xl-3 mb-4 mb-xl-0">
          <div class="single-search-product-wrapper">
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                  <a href="#" class="title">Guitarra Ludwig</a>
                  <div class="price">$170.00</div>
              </div>
            </div>
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                <a href="#" class="title">Guitarra Ludwig</a>
                <div class="price">$170.00</div>
              </div>
            </div>
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                <a href="#" class="title">Guitarra Ludwig</a>
                <div class="price">$170.00</div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-sm-6 col-xl-3 mb-4 mb-xl-0">
          <div class="single-search-product-wrapper">
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                  <a href="#" class="title">Guitarra Ludwig</a>
                  <div class="price">$170.00</div>
              </div>
            </div>
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                <a href="#" class="title">Guitarra Ludwig</a>
                <div class="price">$170.00</div>
              </div>
            </div>
            <div class="single-search-product d-flex">
              <a href="#"><img src="img/product/product2.jpg" alt=""></a>
              <div class="desc">
                <a href="#" class="title">Guitarra Ludwig</a>
                <div class="price">$170.00</div>
              </div>
            </div>
          </div>
        </div>
      </div>
		</div>
	</section>
	<!-- ================ top product area end ================= -->		
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
  <script src="vendors/nouislider/nouislider.min.js"></script>
  <script src="vendors/jquery.ajaxchimp.min.js"></script>
  <script src="vendors/mail-script.js"></script>
  <script src="js/main.js"></script>
</body>

<script>

</script>
</html>