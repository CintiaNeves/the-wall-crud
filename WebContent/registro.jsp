<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Registro</title>
<link rel="icon" href="img/Fevicon.png" type="image/png">
<link rel="stylesheet" href="vendors/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
<link rel="stylesheet" href="vendors/themify-icons/themify-icons.css">
<link rel="stylesheet" href="vendors/linericon/style.css">
<link rel="stylesheet"
	href="vendors/owl-carousel/owl.theme.default.min.css">
<link rel="stylesheet" href="vendors/owl-carousel/owl.carousel.min.css">
<link rel="stylesheet" href="vendors/nouislider/nouislider.min.css">

<link rel="stylesheet" href="css/style.css">

<script type="text/javascript" src="vendors/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="vendors/bootstrap/bootstrap.min.js"></script>
<script type="text/javascript" src="vendors/jquery/mask.min.js"></script>

<script src="vendors/jquery/jquery-3.2.1.min.js"></script>
<script src="vendors/bootstrap/bootstrap.bundle.min.js"></script>
<script src="vendors/skrollr.min.js"></script>
<script src="vendors/owl-carousel/owl.carousel.min.js"></script>
<script src="vendors/jquery.ajaxchimp.min.js"></script>
<script src="vendors/mail-script.js"></script>
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
							<li class="nav-item"><a class="nav-link" href="index.html">Inicio</a></li>
							<li class="nav-item submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Categorias</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link"
										href="bateria.html">Baterias</a></li>
									<li class="nav-item"><a class="nav-link" href="corda.html">Cordas</a></li>
									<li class="nav-item"><a class="nav-link" href="piano.html">Piano</a></li>
									<li class="nav-item"><a class="nav-link" href="sopro.html">Sopro</a></li>
								</ul></li>
							<li class="nav-item active submenu dropdown"><a href="#"
								class="nav-link dropdown-toggle" data-toggle="dropdown"
								role="button" aria-haspopup="true" aria-expanded="false">Cliente</a>
								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
									<li class="nav-item"><a class="nav-link"
										href="tracking-order.html">Pedidos</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================ End Header Menu Area =================-->

	<!--================Login Box Area =================-->
	<section class="section-margin--small" style="margin-left: 15%;">
		<div class="billing_details">
			<div class="col-md-11">
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
			<div class="col-md-10">
				<form class="row contact_form" action="registro" method="post"
					novalidate="novalidate">
					<div id="dados-pessoais" class="col-md-12 row contact_form">
						<div class="col-md-12 form-group p_star">
							<h3>Dados Pessoais</h3>
						</div>
						<input class="form-control" type="hidden" name="usuario"
							id="usuario" value="${cliente.usuario.id}" /> <input
							class="form-control" type="hidden" name="email" id="email"
							value="${cliente.usuario.nome}" />
						<div class="col-md-6 form-group p_star">
							<label for="nome">Nome completo</label> <input type="text"
								class="form-control" id="nome" name="nome"
								value="${cliente.nome}" required>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="cpf">CPF</label> <input type="text"
								class="form-control" id="cpf" name="cpf" value="${cliente.cpf}"
								required>
						</div>
						<div class="form-group col-md-6">
							<label class="col-md-12" for="genero">Gênero</label> <select
								class="form-control" id="genero" name="genero" required>
								<option value="0">Selecione...</option>
								<c:forEach var="g" items="${generos}">
									<option value="${g.id}"
										${g.id == cliente.genero.id ? "selected=selected" : ""}>${g.descricao}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="data-nascimento">Data de Nascimento</label> <input
								type="date" class="form-control" id="nascimento"
								name="nascimento" value="${cliente.dataNascimento}" required>
						</div>
						<div class="col-md-6 form-group p_stBandeiraar">
							<label for="telefone">Telefone</label> <input type="text"
								class="form-control" id="telefone" name="telefone"
								value="${cliente.telefones[0].ddd}${cliente.telefones[0].numero}"
								required>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="celular">Celular</label> <input type="text"
								class="form-control" id="celuar" name="celular"
								value="${cliente.telefones[1].ddd}${cliente.telefones[1].numero}"
								required>
						</div>
					</div>
					<div id="cartoes">
						<input class="form-control" type="hidden" name="cardCount"
							id="cardCount" value="1" />
						<div class="col-md-12 row contact_form">
							<div class="col-md-12 form-group p_star">
								<h3>Cartão de Crédito</h3>
							</div>
							<div class="form-group col-md-6 ">
								<label class="col-md-12" for="bandeira">Bandeira</label> <select
									class="form-control" id="bandeira" name="bandeira" required>
									<option value="0">Selecione...</option>
									<c:forEach var="b" items="${bandeiras}">
										<option value="${b.id}"
											${b.id == cliente.cartoes[0].bandeira.id ? "selected=selected" : ""}>${b.descricao}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="num-cartao">Numero do cartão</label> <input
									type="text" class="form-control" id="num-cartao"
									name="num-cartao" value="${cliente.cartoes[0].numero}" required>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="nome-cartao">Nome impresso no cartão</label> <input
									type="text" class="form-control" id="nome-cartao"
									name="nome-cartao" value="${cliente.cartoes[0].nomeImpresso}"
									required>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="cod">Código de segurança</label> <input type="text"
									class="form-control" id="cod" name="cod"
									value="${cliente.cartoes[0].codSeguranca}" required>
							</div>
						</div>
					</div>
					<div>
						<div class="col-md-6 form-group p_star">
							<button class="btn btn-link adiciona-cartao" id="adiciona-cartao">Deseja
								adicionar outro cartão?</button>
						</div>
					</div>
					<div id="endereco-cobranca" class="col-md-12 row contact_form">
						<div class="col-md-12 form-group p_star">
							<h3>Endereço de Cobrança</h3>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="tipo-residencia">Tipo Residência</label> <input
								type="text" class="form-control" id="tp-resid-cbr"
								name="tp-resid-cbr" placeholder="Casa, Apartamento, etc..."
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Casa, Apartamento, etc...'"
								value="${cliente.enderecos[0].tpResidencia}" required>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="tipo-logradouro">Tipo Logradouro</label> <input
								type="text" value="${cliente.enderecos[0].tpLogradouro}"
								class="form-control" id="tp-logra-cbr" name="tp-logra-cbr"
								placeholder="Avenida, Estrada, Rua, etc..."
								onfocus="this.placeholder = ''"
								onblur="this.placeholder = 'Avenida, Estrada, Rua, etc...'"
								required>

						</div>
						<div class="col-md-6 form-group p_star">
							<label for="logradouro">Logradouro</label> <input type="text"
								class="form-control" value="${cliente.enderecos[0].logradouro}"
								id="logradouro-cbr" name="logradouro-cbr" required>
						</div>

						<div class="col-md-6 form-group p_star">
							<label for="numero">Número</label> <input type="text"
								class="form-control" value="${cliente.enderecos[0].numero}"
								id="numero-cbr" name="numero-cbr" required>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="cep">CEP</label> <input type="text"
								class="form-control" value="${cliente.enderecos[0].cep}"
								id="cep-cbr" name="cep-cbr" required>
						</div>
						<div class="col-md-6 form-group p_star">
							<label for="bairro">Bairro</label> <input type="text"
								class="form-control" value="${cliente.enderecos[0].bairro}"
								id="bairro-cbr" name="bairro-cbr" required>
						</div>
						<div class="form-group col-md-6">
							<label class="col-md-12" for="pais-cbr">País</label> <select
								class="form-control" id="pais-cbr" name="pais-cbr" required>
								<option value="0">Selecione...</option>
								<c:forEach var="p" items="${paises}">
									<option value="${p.id}"
										${p.id == cliente.enderecos[0].pais.id ? "selected=selected" : ""}>${p.nome}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-6">
							<label class="col-md-12" for="estado-cbr">Estado</label> <select
								class="form-control" id="estado-cbr" name="estado-cbr" required>
								<option value="0">Selecione...</option>
								<c:forEach var="e" items="${estados}">
									<option value="${e.id}"
										${e.id == cliente.enderecos[0].pais.estado.id ? "selected=selected" : ""}>${e.nome}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-md-6">
							<label class="col-md-12" for="cidade-cbr">Cidade</label> <select
								class="form-control" id="cidade-cbr" name="cidade-cbr" required>
								<option value="0">Selecione...</option>
								<c:forEach var="c" items="${cidades}">
									<option value="${c.id}"
										${c.id == cliente.enderecos[0].pais.estado.cidade.id ? "selected=selected" : ""}>${c.nome}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-12 form-group p_star">
							<label for="observacao">Observação</label> <input type="text"
								class="form-control" id="observacao-cbr"
								value="${cliente.enderecos[0].observacoes}"
								name="observacao-cbr">
						</div>
					</div>
					<div id="enderecos">
						<input class="form-control" type="hidden" name="endCount"
							id="endCount" value="1" />
						<div class="col-md-12 row contact_form">
							<div class="col-md-12 form-group p_star">
								<h3>Endereço de Entrega</h3>
							</div>
							<div
								class="col-md-12 form-group p_star custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input"
									id="customCheck1"> <label class="custom-control-label"
									for="customCheck1">O mesmo de cobrança</label>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="tipo-residencia">Apelido - (Nome ou frase
									para identificar o endereço)</label> <input type="text"
									class="form-control" value="${cliente.enderecos[1].alias}"
									id="apelido-ent" name="apelido-ent"
									placeholder="Minha casa, Casa da mãe, etc..."
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Minha casa, Casa da mãe, etc...'"
									value="${cliente.enderecos[1].tpLogradouro}" required>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="tipo-residencia">Tipo Residência</label> <input
									type="text" class="form-control" id="tp-resid-ent"
									name="tp-resid-ent" placeholder="Casa, Apartamento, etc..."
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Casa, Apartamento, etc...'"
									value="${cliente.enderecos[1].tpResidencia}" required>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="tipo-logradouro">Tipo Logradouro</label> <input
									type="text" class="form-control" id="tp-logra-ent"
									name="tp-logra-ent" placeholder="Avenida, Estrada, Rua, etc..."
									onfocus="this.placeholder = ''"
									onblur="this.placeholder = 'Avenida, Estrada, Rua, etc...'"
									value="${cliente.enderecos[1].tpLogradouro}" required>

							</div>
							<div class="col-md-6 form-group p_star">
								<label for="logradouro">Logradouro</label> <input type="text"
									class="form-control" value="${cliente.enderecos[1].logradouro}"
									id="logradouro-ent" name="logradouro-ent" required>
							</div>

							<div class="col-md-6 form-group p_star">
								<label for="numero">Número</label> <input type="text"
									class="form-control" value="${cliente.enderecos[1].numero}"
									id="numero-ent" name="numero-ent" required>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="cep">CEP</label> <input type="text"
									class="form-control" value="${cliente.enderecos[1].cep}"
									id="cep-ent" name="cep-ent" required>
							</div>
							<div class="col-md-6 form-group p_star">
								<label for="bairro">Bairro</label> <input type="text"
									class="form-control" value="${cliente.enderecos[1].bairro}"
									id="bairro-ent" name="bairro-ent" required>
							</div>
							<div class="form-group col-md-6">
								<label class="col-md-12" for="pais-ent">País</label> <select
									class="form-control" id="pais-ent" name="pais-ent" required>
									<option value="0">Selecione...</option>
									<c:forEach var="e" items="${estados}">
										<option value="${e.id}"
											${e.id == cliente.enderecos[1].pais.estado.id ? "selected=selected" : ""}>${e.nome}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-6">
								<label class="col-md-12" for="estado-ent">Estado</label> <select
									class="form-control" id="estado-ent" name="estado-ent" required>
									<option value="0">Selecione...</option>
									<c:forEach var="e" items="${estados}">
										<option value="${e.id}"
											${e.id == cliente.enderecos[1].pais.estado.id ? "selected=selected" : ""}>${e.nome}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group col-md-6">
								<label class="col-md-12" for="cidade-ent">Cidade</label> <select
									class="form-control" id="cidade-ent" name="cidade-ent" required>
									<option value="0">Selecione...</option>
									<c:forEach var="c" items="${cidades}">
										<option value="${c.id}"
											${c.id == cliente.enderecos[1].pais.estado.cidade.id ? "selected=selected" : ""}>${c.nome}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-12 form-group p_star">
								<label for="observacao">Observação</label> <input type="text"
									class="form-control"
									value="${cliente.enderecos[1].observacoes}" id="observacao-ent"
									name="observacao-ent">
							</div>
						</div>
					</div>
					<div class="col-md-6 form-group p_star">
						<button class="btn btn-link adiciona-cartao"
							id="adiciona-endereco">Deseja adicionar outro endereço
							de entrega?</button>
					</div>
					<div class="col-md-6 form-group">
						<button type="submit" name="btnOperacao" class="btn btn-primary"
							value="SALVAR">Cadastrar</button>
					</div>
				</form>
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


</body>
<script>	

function carregaBandeira() {	
	let options = "";
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/bandeira",
		dataType: "json",
		async: false,
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
		},
		success: function(response) {
			if(response.erro) {
				$("#backend_menssagem")[0].innerHTML = response.erro;
				$("#backend_menssagem").removeAttr("style");
				$("#backend_menssagem").addClass("alert alert-danger");
			} else {
				for(let el of response) {
					options += "<option value='" + el.id + "'>" + el.descricao + "</option>";
				}		
			}
		},
		error: function(error) {
			console.log(error);
		}
	});	
	return options;
	
};

function carregaGenero() {	
	let options = "";
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/genero",
		dataType: "json",
		async: false,
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
		},
		success: function(response) {
			if(response.erro) {
				$("#backend_menssagem")[0].innerHTML = response.erro;
				$("#backend_menssagem").removeAttr("style");
				$("#backend_menssagem").addClass("alert alert-danger");
			} else {
				for(let el of response) {
					options += "<option value='" + el.id + "'>" + el.descricao + "</option>";
				}		
			}
		},
		error: function(error) {
			console.log(error);
		}
	});	
	return options;
	
};

function carregaPais() {	
	let options = "";
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/pais",
		dataType: "json",
		async: false,
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
		},
		success: function(response) {
			if(response.erro) {
				$("#backend_menssagem")[0].innerHTML = response.erro;
				$("#backend_menssagem").removeAttr("style");
				$("#backend_menssagem").addClass("alert alert-danger");
			} else {
				for(let el of response) {
					options += "<option value='" + el.id + "'>" + el.nome + "</option>";
				}		
			}
		},
		error: function(error) {
			console.log(error);
		}
	});	
	return options;
	
};

function carregaEstado() {	
	let options = "";
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/estado",
		dataType: "json",
		async: false,
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
		},
		success: function(response) {
			if(response.erro) {
				$("#backend_menssagem")[0].innerHTML = response.erro;
				$("#backend_menssagem").removeAttr("style");
				$("#backend_menssagem").addClass("alert alert-danger");
			} else {
				for(let el of response) {
					options += "<option value='" + el.id + "'>" + el.nome + "</option>";
				}		
			}
		},
		error: function(error) {
			console.log(error);
		}
	});	
	return options;
	
};

function carregaCidade() {	
	let options = "";
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/cidade",
		dataType: "json",
		async: false,
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
		},
		success: function(response) {
			if(response.erro) {
				$("#backend_menssagem")[0].innerHTML = response.erro;
				$("#backend_menssagem").removeAttr("style");
				$("#backend_menssagem").addClass("alert alert-danger");
			} else {
				for(let el of response) {
					options += "<option value='" + el.id + "'>" + el.nome + "</option>";
				}		
			}
		},
		error: function(error) {
			console.log(error);
		}
	});	
	return options;
	
};
	
	$("#customCheck1").change(function() {
		$("#tp-resid-ent")[0].value = $("#tp-resid-cbr")[0].value;
		$("#tp-logra-ent")[0].value = $("#tp-logra-cbr")[0].value;
		$("#logradouro-ent")[0].value = $("#logradouro-cbr")[0].value;
		$("#numero-ent")[0].value = $("#numero-cbr")[0].value;
		$("#cep-ent")[0].value = $("#cep-cbr")[0].value;
		$("#bairro-ent")[0].value = $("#bairro-cbr")[0].value;
		$("#cidade-ent")[0].value = $("#cidade-cbr")[0].value;
		$("#estado-ent")[0].value = $("#estado-cbr")[0].value;
		$("#pais-ent")[0].value = $("#pais-cbr")[0].value;
		$("#observacao-ent")[0].value = $("#observacao-cbr")[0].value;
	});


	$("#adiciona-cartao")
			.click(
					function() {
						event.preventDefault();
						let cartaoCount = $("#cartoes")[0].childElementCount;
						let divCartao = ""
								+ "<div class='col-md-12 row contact_form' id='div-cartao-"+cartaoCount+"'>"
								+ "<div class='col-md-12 form-group p_star'>"
								+ "<h3>Cartão de Crédito</h3>"
								+ "</div>"
								+ "<div class='form-group col-md-6'>"
								+ "<label class='col-md-12' for='bandeira-" + cartaoCount +"'>Bandeira</label>"
								+ "<select class='form-control' id='bandeira-" + cartaoCount +"' name='bandeira-"+ cartaoCount + "' required>"
								+ "<option value='0'>Selecione...</option>"
								+ "</select>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label class='col-md-12' for='num-cartao-" + cartaoCount +"'>Número do cartão"
								+ "</label>"
								+ "<input type='text' class='form-control' id='num-cartao-" + cartaoCount + "' name='num-cartao-"+ cartaoCount +"' required>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label class='col-md-12' for='nome-cartao-" + cartaoCount +"'>Nome impresso no cartão"
								+ "</label>"
								+ "<input type='text' class='form-control' id='nome-cartao-" + cartaoCount + "' name='nome-cartao-"+ cartaoCount +"' required>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label class='col-md-12' for='cod-" + cartaoCount +"'>Codigo de segurança"
								+ "</label>"
								+ "<input type='text' class='form-control' id='cod-" + cartaoCount + "' name ='cod-"+ cartaoCount +"' required>"
								+ "</div>";
						
						$("#cartoes").append(divCartao);
						$("#cardCount")[0].value = cartaoCount;
						let optionsBandeira = carregaBandeira();
						$('#bandeira-' + cartaoCount).append(optionsBandeira);
						
					});

	$("#adiciona-endereco")
			.click(
					function() {
						event.preventDefault();
						let enderecoCount = $("#enderecos")[0].childElementCount;
						let divEndereco = ""
								+ "<div class='col-md-12 row contact_form'>"
								+ "<div class='col-md-12 form-group p_star'>"
								+ "<h3>Endereço de Entrega</h3>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label for='tipo-residencia-"+ enderecoCount +"'>Apelido - (Nome ou frasepara identificar o endereço)</label>"
								+ "<input type='text' class='form-control' id='apelido-ent-" + enderecoCount + "' name='apelido-ent-" + enderecoCount + "' required>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label for='tp-resid-ent-"+ enderecoCount +"'>Tipo Residência</label>"
								+ "<input type='text' class='form-control' id='tp-resid-ent-" + enderecoCount + "' name='tp-resid-ent-" + enderecoCount + "' required>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label for='tp-logra-ent-"+ enderecoCount +"'>Tipo Logradouro</label>"
								+ "<input type='text' class='form-control' id='tp-logra-ent-" + enderecoCount + "' name='tp-logra-ent-" + enderecoCount + "' required>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label for='logradouro-ent-"+ enderecoCount +"'>Logradouro</label>"
								+ "<input type='text' class='form-control' id='logradouro-ent-" + enderecoCount + "' name='logradouro-ent-" + enderecoCount + "' required>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label for='numero-ent-"+ enderecoCount +"'>Número</label>"
								+ "<input type='text' class='form-control' id='numero-ent-" + enderecoCount + "'numero-ent-" + enderecoCount + "' required>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label for='cep-ent-"+ enderecoCount +"'>CEP</label>"
								+ "<input type='text' class='form-control' id='cep-ent-" + enderecoCount + "'cep-ent-" + enderecoCount + "' required>"
								+ "</div>"
								+ "<div class='col-md-6 form-group p_star'>"
								+ "<label for='bairro-ent-"+ enderecoCount +"'>Bairro</label>"
								+ "<input type='text' class='form-control' id='bairro-ent-" + enderecoCount + "'bairro-ent-" + enderecoCount + "' required>"
								+ "</div>"
								+ "<div class='col-md-6'>"
								+ "<label class='col-md-12' for='pais-ent-"+ enderecoCount +"'>Pais</label>"
								+ "<select class='form-control' id='pais-ent-" + enderecoCount + "'pais-ent-" + enderecoCount + "' required>"
								+ "<option value='0'>Selecione...</option>"
								+ "</select>"
								+ "</div>"
								+ "<div class='col-md-6'>"
								+ "<label class='col-md-12' for='estado-ent-"+ enderecoCount +"'>Estado</label>"
								+ "<select class='form-control' id='estado-ent-" + enderecoCount + "'estado-ent-" + enderecoCount + "' required>"
								+ "<option value='0'>Selecione...</option>"
								+ "</select>"
								+ "</div>"
								+ "<div class='col-md-6'>"
								+ "<label class='col-md-6' for='cidade-ent-"+ enderecoCount +"'>Cidade</label>"
								+ "<select class='form-control' id='cidade-ent-" + enderecoCount + "'cidade-ent-" + enderecoCount + "' required>"
								+ "<option value='0'>Selecione...</option>"
								+ "</select>"
								+ "</div>"
								+ "<div class='col-md-12 form-group p_star'>"
								+ "<label for='observacao-ent-"+ enderecoCount +"'>Observação</label>"
								+ "<input type='text' class='form-control' id='observacao-ent-" + enderecoCount + "'observacao-ent-" + enderecoCount + "'>"
								+ "</div>"
						$("#enderecos").append(divEndereco);
						$("#endCount")[0].value = enderecoCount;
						let optionsPais = carregaPais();
						$('#pais-ent-' + enderecoCount).append(optionsPais);
						let optionsEstado = carregaEstado();
						$('#estado-ent-' + enderecoCount).append(optionsEstado);
						let optionsCidade = carregaCidade();
						$('#cidade-ent-' + enderecoCount).append(optionsCidade);
					});
	
	
</script>
</html>