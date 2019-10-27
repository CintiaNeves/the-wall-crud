<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Cadastro</title>
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
.label {
	color: black;
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
							<li class="nav-item"><a class="nav-link" href="index.html">Site</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Pedidos</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="consulta-pedido.html">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Produtos</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="consulta.jsp">Consulta</a></li>
								</ul></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Estoque</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="entrada.jsp">Entrada</a></li>
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
	<section class="section-margin--small" style="margin-left: 15%;">
		<div class="billing_details">
			<div class="row">
				<div class="col-md-11">
					<!--============================= Message validation =============================-->
					<div id="backend_menssagem" >
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
				<div class="col-md-10">
					<form class="row contact_form" action="instrumento" method="POST">
						<div class="col-md-12 form-group p_star">
							<h3>Cadastro de Instrumento</h3>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="codigo">Código</label> 
							<input type="text" class="form-control" id="codigo" name="codigo" value="${instrumento.codigo}" readonly>
							<input type="hidden" name="id" id="id" value="${instrumento.id}">
							<input type="hidden" name=entrada id="entrada" value="">
							<input type="hidden" name="cadastro" id="entrada" value="">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="codigo">Número de Série</label> 
							<input type="text" class="form-control" id="serie" name="serie" value="${instrumento.serie}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="descricao">Descrição</label> <input type="text" 
								class="form-control" id="descricao" name="descricao" value="${instrumento.descricao}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="marca">Marca</label> <input type="text" 
								class="form-control" id="marca" name="marca" value="${instrumento.marca}">
						</div>
						
						<div class="col-md-6 form-group p_star">
							<label for="modelo">Modelo</label> <input type="text" 
								class="form-control" id="modelo" name="modelo" value="${instrumento.modelo}">
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="cor">Cor</label> <input type="text" 
								class="form-control" id="cor" name="cor" value="${instrumento.cor}">
						</div>
						<div class="form-group col-md-6">
                            <label class="col-md-12" for="grp-precificacao">Grupo Precificação</label>
                            <select class="form-control" id="grp-precificacao" name="grp-precificacao" >
                                <option value="">Selecione...</option>
                                <option value="4" ${instrumento.grupoPrecificacao.id == 4 ? 'selected="selected"' : ''}>Classe A - Margem 20 %</option>
                                <option value="3" ${instrumento.grupoPrecificacao.id == 3 ? 'selected="selected"' : ''}>Classe B - Margem 15 %</option>
                                <option value="2" ${instrumento.grupoPrecificacao.id == 2 ? 'selected="selected"' : ''}>Classe C - Margem 10 %</option>
                                <option value="1" ${instrumento.grupoPrecificacao.id == 1 ? 'selected="selected"' : ''}>Classe D - Margem 5 %</option>
                            </select>
                        </div>
						<div class="form-group col-md-6">
                            <label class="col-md-12" for="categoria">Categoria</label>
                            <select class="form-control" id="categoria" name="categoria" >
                                <option value="">Selecione...</option>
                                <option value="1" ${instrumento.categoria.id == 1 ? 'selected="selected"' : ''}>Bateria</option>
                                <option value="2" ${instrumento.categoria.id == 2 ? 'selected="selected"' : ''}>Cordas</option>
                                <option value="3" ${instrumento.categoria.id == 3 ? 'selected="selected"' : ''}>Piano</option>
                                <option value="4" ${instrumento.categoria.id == 4 ? 'selected="selected"' : ''}>Sopro</option>
                            </select>
                        </div>
						<div class="form-group col-md-6">
                            <label class="col-md-12" for="subcategoria">Subcategoria</label>
                            <select class="form-control" id="subcategoria" name="subcategoria" >
                                <option value="">Selecione...</option>
                                <option value="1" ${instrumento.categoria.subcategoria.id == 1 ? 'selected="selected"' : ''}>Bateria Acústica</option>
                                <option value="2" ${instrumento.categoria.subcategoria.id == 2 ? 'selected="selected"' : ''}>Bateria Eletronica</option>
                                <option value="3" ${instrumento.categoria.subcategoria.id == 3 ? 'selected="selected"' : ''}>Ferragens</option>
                                <option value="4" ${instrumento.categoria.subcategoria.id == 4 ? 'selected="selected"' : ''}>Violão</option>
                                <option value="5" ${instrumento.categoria.subcategoria.id == 5 ? 'selected="selected"' : ''}>Guitarra</option>
                                <option value="6" ${instrumento.categoria.subcategoria.id == 6 ? 'selected="selected"' : ''}>Cavaco</option>
                                <option value="7" ${instrumento.categoria.subcategoria.id == 7 ? 'selected="selected"' : ''}>Banjo</option>
                                <option value="8" ${instrumento.categoria.subcategoria.id == 8 ? 'selected="selected"' : ''}>Bandolin</option>
                                <option value="9" ${instrumento.categoria.subcategoria.id == 9 ? 'selected="selected"' : ''}>Acordeons</option>
                                <option value="10" ${instrumento.categoria.subcategoria.id == 10 ? 'selected="selected"' : ''}>Piano Digital</option>
                                <option value="11" ${instrumento.categoria.subcategoria.id == 11 ? 'selected="selected"' : ''}>Teclados</option>
                                <option value="12" ${instrumento.categoria.subcategoria.id == 12 ? 'selected="selected"' : ''}>Clarinetas</option>
                                <option value="13" ${instrumento.categoria.subcategoria.id == 13 ? 'selected="selected"' : ''}>Flautas</option>
                                <option value="14" ${instrumento.categoria.subcategoria.id == 14 ? 'selected="selected"' : ''}>Gaitas</option>
                                <option value="15" ${instrumento.categoria.subcategoria.id == 15 ? 'selected="selected"' : ''}>Sax</option>
                                <option value="16" ${instrumento.categoria.subcategoria.id == 16? 'selected="selected"' : ''}>Trompete</option>
                            </select>
                        </div>
                         <div class="col-md-6 form-group p_star">
							
						</div>
                        <div class="col-md-6 form-group p_star">
							<label for="valor-custo">Valor Custo</label> <input type="text" readonly
								class="form-control" id="valor-custo" name="valor-custo" value="${instrumento.valorCusto}">
						</div>
						
						<div class="col-md-6 form-group p_star">
							<label for="valor-venda">Valor Venda </label> <input type="text" readonly
								class="form-control" id="valor-venda" name="valor-venda" value="${instrumento.valorVenda}">
						</div>
						<div class="col-md-12 form-group p_star">
							<label for="detalhes">Detalhes</label> <input type="text" 
								class="form-control" id="detalhes" name="especificacoes" value="${instrumento.especificacoes}">
						</div>
						<div class="col-md-6 form-group">
							<div class="col-md-6 form-group">
								<button class="btn btn-primary" type="submit" name="btnOperacao" value="${instrumento.id != null ? 'ALTERAR' : 'SALVAR'}">${instrumento.id != null ? 'ALTERAR' : 'SALVAR'}</button>
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
</body>
<script>
$("#serie").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
});

$("#descricao").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
		
});

$("#marca").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
		
});

$("#modelo").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
		
});

$("#cor").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
		
});

$("#grp-precificacao").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
		
});

$("#categoria").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
		
});

$("#subcategoria").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
		
});

$("#detalhes").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
		
});

$("#serie").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
	let serie = this.value;
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/instrumento",
		dataType: "json",
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
			serie: serie,
			cadastro: true,
		},
		success: function(response) {
			if(response.erro) {
				$("#backend_menssagem")[0].innerHTML = response.erro;
				$("#backend_menssagem").removeAttr("style");
				$("#backend_menssagem").addClass("alert alert-danger");
			} 
		},
		error: function(error) {
		}
	});		
});


let varCusto = $("#valor-custo")[0].value;
let varVenda = $("#valor-venda")[0].value;
$("#valor-custo").val(varCusto.toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' }));
$("#valor-venda").val(varVenda.toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' }));
</script>
</html>