<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Wall - Checkout</title>
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
span {
	float: right;
}

.creditoCupom {
	
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



	<!--================Checkout Area =================-->
	<section class="checkout_area section-margin--small">
		<div class="container">
			<div class="billing_details">

				<div class="row">
					<form action="pedido" method="POST" class="row contact_form">
						<input type="hidden" value="" id="cliente-id" name="cliente-id">
						<input type="hidden" value="" id="carrinho-id" name="carrinho-id">
						<input type="hidden" value="${cliente.carrinho.frete.valorFrete}"
							name="valorFrete" id="valorFrete">
						<div class="col-lg-8" id="faturamento">
							<h3>Detalhes do faturamento</h3>
							<div class="row contact_form">
								<div class="col-md-6 form-group p_star">
									<label for="first">Nome</label> <input disabled type="text"
										class="form-control" id="first" name="name"
										value="${cliente.nome}"> <span class="placeholder"
										data-placeholder="First name"></span>
								</div>
								<div class="col-md-6 form-group p_star">
									<label for="last">CPF</label> <input disabled type="text"
										class="form-control" id="last" name="name"
										value="${cliente.cpf}"> <span class="placeholder"
										data-placeholder="Last name"></span>
								</div>
								<div class="col-md-6 form-group p_star" id="selecao-endereco">
									<label>Entregar em: </label>
									<c:forEach var="e" items="${enderecos}">
										<div class="form-check">
											<input required class="form-check-input" name="radioEndereco"
												type="radio" value="${e.id}" id="${e.id}"> <label
												class="form-check-label" for="${e.id}">${e.alias}</label>
										</div>
									</c:forEach>
									<div class="form-check">
										<input class="form-check-input" name="radioEndereco"
											id="select-novo-endereco" type="radio" value="novo-endereco">
										<label class="form-check-label" for="select-novo-endereco">Novo
											endereço</label>
									</div>
								</div>
								<div class="row contact_form" id="novo-endereco"
									style="display: none">
									<div class="col-md-12 form-group">
										<h3>Novo Endereço</h3>
									</div>
									<div class="col-md-6 form-group p_star">
										<label for="tipo-residencia">Apelido - (Nome ou frase
											para identificar o endereço)</label> <input type="text"
											class="form-control" id="apelido-ent" name="apelido">
									</div>
									<div class="col-md-6 form-group p_star">
										<label for="tipo-residencia">Tipo Residencia</label> <input
											type="text" class="form-control" id="tp-resid-ent"
											name="tp-resid">
									</div>
									<div class="col-md-6 form-group p_star">
										<label for="tipo-logradouro">Tipo Logradouro</label> <input
											type="text" class="form-control" id="tp-logra-ent"
											name="tp-logra">

									</div>
									<div class="col-md-6 form-group p_star">
										<label for="logradouro">Logradouro</label> <input type="text"
											class="form-control" id="logradouro-ent" name="logradouro">
									</div>

									<div class="col-md-6 form-group p_star">
										<label for="numero">Número</label> <input type="text"
											class="form-control" id="numero-ent" name="numero">
									</div>
									<div class="col-md-6 form-group p_star">
										<label for="cep">CEP</label> <input type="text"
											class="form-control" id="cep-ent" name="cep">
									</div>
									<div class="col-md-6 form-group p_star">
										<label for="bairro">Bairro</label> <input type="text"
											class="form-control" id="bairro-ent" name="bairro">
									</div>
									<div class="col-md-6 form-group p_star">
										<label class="col-md-12" for="pais-ent">Cidade</label> <select
											class="form-control" id="cidades" name="cidade" required>
											<option value="0">Selecione...</option>
										</select>
									</div>
									<div class="col-md-6 form-group p_star">
										<label class="col-md-12" for="pais-ent">Estado</label> <select
											class="form-control" id="estados" name="estado" required>
											<option value="0">Selecione...</option>
										</select>
									</div>
									<div class="col-md-6 form-group p_star">
										<label class="col-md-12" for="pais-ent">País</label> <select
											class="form-control" id="paises" name="pais" required>
											<option value="0">Selecione...</option>
										</select>
									</div>
									<div class="col-md-6 form-group p_star">
										<label for="salvar-endereco">Salvar Endereço</label>
									</div>
									<div class="col-md-3 form-group p_star">
										<input class="form-check-input" type="radio"
											name="salvar-endereco" value="true"> <label
											class="form-check-label" for="exampleRadios2">Sim</label>
									</div>
									<div class="col-md-3 form-group p_star">
										<input class="form-check-input" type="radio"
											name="salvar-endereco" value="false"> <label
											class="form-check-label" for="exampleRadios2">Não</label>
									</div>
								</div>
								<div id="alert" class="alert alert-warning" role="alert"
									style="display: none">
									<p>Alerta! Valor do desconto supera valor da compra, será
										gerado um novo cupom com a diferença de saldo.</p>
								</div>
								<div class="col-md-12 form-group mb-0">
									<div class="creat_account">
										<h3>Observações de entrega</h3>
									</div>
									<textarea class="form-control" name="observacao-entrega"
										id="observacao-ent" rows="1"></textarea>
								</div>
							</div>
						</div>
						<div class="col-lg-4">
							<div class="order_box">
								<h2>Seu Pedido</h2>
								<h4>Produtos</h4>
								<fmt:setLocale value="pt_BR" />
								<ul class="list">
									<c:forEach var="item" items="${cliente.carrinho.itens}">
										<li><label>${item.quantidade} x
												${item.instrumento.descricao}</label> <span> <fmt:formatNumber
													value="${item.total}" type="currency" /></span></li>
									</c:forEach>
								</ul>
								<ul class="list list_2">
									<li><label>Subtotal</label> <span> <fmt:formatNumber
												value="${cliente.carrinho.valorTotal}" type="currency" />
									</span></li>
									<li><label>Frete</label> <span> <fmt:formatNumber
												value="${cliente.carrinho.frete.valorFrete}" type="currency" />
									</span></li>
									<li><label>Total sem Desconto</label> <span id="total-sem-desconto"> <fmt:formatNumber
												value="${cliente.carrinho.valorTotal
                                            + cliente.carrinho.frete.valorFrete}" type="currency" />
									</span></li>
									<li style="color: red"><label>Desconto</label> <span id="desconto"> <fmt:formatNumber
												value="${cliente.carrinho.desconto}" type="currency" />
									</span></li>
									<li id="li-total"><label>Total</label> <span id="total"> <fmt:formatNumber
												value="${cliente.carrinho.valorTotal
                                            + cliente.carrinho.frete.valorFrete
                                            - cliente.carrinho.desconto}"
												type="currency" />
									</span>
									</li>
									<li id="li-saldo" style="display: none; color: blue"><label>Saldo</label> <span id="saldo"> <fmt:formatNumber
												value="0"
												type="currency" />
									</span></li>
									<li id="total-saldo" style="display: none"><label>Total</label> <span> <fmt:formatNumber
												value="0"
												type="currency" />
									</span>
									</li>
								</ul>

								<div class="parcelas active">
									<div class="radion_btn">
										<label for="f-option6">Parcelamento</label>
									</div>
									<input id="a_vista" type="radio" value="1"
										name="radio_parcelas" required /> <label
										style="margin-right: 10px;" for="a_vista">Á Vista</label> <input
										id="p_uma" type="radio" value="2" name="radio_parcelas" /> <label
										style="margin-right: 10px;" for="p_uma">2x</label> <input
										id="p_cinco" type="radio" value="3" name="radio_parcelas" />
									<label style="margin-right: 10px;" for="p_cinco">3x</label> <input
										id="p_cinco" type="radio" value="4" name="radio_parcelas" />
									<label style="margin-right: 10px;" for="p_cinco">4x</label> <input
										id="p_cinco" type="radio" value="5" name="radio_parcelas" />
									<label style="margin-right: 10px;" for="p_cinco">5x</label>
								</div>

								<div class="payment_item active">
									<div class="radion_btn">
										<label for="f-option6">Cartão de Crédito</label> <img
											src="img/product/card.jpg" alt="">
									</div>
									<small id="info-msg" hidden style="color: red;">Defina
										os valores para cada cartão selecionado ou deixe em branco
										para que o sistema realize a distribuição. OK</small>
									<c:forEach var="c" items="${cartoes}">
										<div class="form-check">
											<input type="checkbox" value="${c.id}" name="cartao_${c.id}"
												id="${c.id}" /> <label for="${c.id}">${c.bandeira.descricao}
												COD ${c.codSeguranca}</label>
										</div>
									</c:forEach>
									<label for="f-option6">Crédito de Cupons</label>
									<c:forEach var="c" items="${cupons}">
										<div class="form-check">
											<input type="checkbox" value="${c.id}" name="cupom_${c.id}"
												id="${c.valor}" onchange="getCupomValue(this)" /> <label
												for="cupom_${c.id}">${c.codigo} <fmt:formatNumber
													value="${c.valor}" type="currency" /></label>
										</div>
									</c:forEach>
									<div class="form-check">
										<button type="button" class="btn btn-link" id="novo-cartao">Adicionar
											novo cartão</button>
										<input type="hidden" name="novo-cartao" id="cartao-novo"
											value="">
									</div>
									<div id="cartao" style="display: none">
										<div class="form-group col-md-12">
											<label class="col-md-12" for="bandeira">Bandeira</label> <select
												class="form-control" id="bandeiras" name="bandeira">
												<option value="0">Selecione...</option>
											</select>
										</div>
										<div class="col-md-12 form-group p_star">
											<label for="num-cartao">Numero do cartão</label> <input
												type="text" class="form-control" id="num-cartao"
												name="numero">
										</div>
										<div class="col-md-12 form-group p_star">
											<label for="nome-cartao">Nome impresso no cartão</label> <input
												type="text" class="form-control" id="nome-cartao"
												name="nome">
										</div>
										<div class="col-md-12 form-group p_star">
											<label for="cod">Código de segurança</label> <input
												type="text" class="form-control" id="cod" name="cod">
										</div>
									</div>
									<div class="radion_btn"></div>
									<div style="display: none">
										<c:forEach var="c" items="${cartoes}">
											<div class="form-check">
												<label class="form-check-label">Valor para
													${c.bandeira.descricao} COD ${c.codSeguranca }</label> <input
													name="novo-cartao" id="novo-cartao">
											</div>
										</c:forEach>
									</div>

									<br>
									<div class="text-center">
										<button class="btn btn-primary" type="submit"
											name="btnOperacao" value="SALVAR">Finalizar Compra</button>
									</div>
								</div>
							</div>
						</div>
					</form>
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
</body>

<script>

	$("input[cartoes]").change(function () {
		let cartoes = $("input[cartoes]");
		cartoes.each(index => {
			if(this.id == cartoes[index].id 
					&& cartoes[index].checked
					&& cartoes[index].parentElement.childElementCount == 2) {
				
				$("#info-msg").removeAttr("hidden");
				
				let div = document.createElement("div");
				div.classList.add("input-group");
				div.id = "dados_cartao_" + cartoes[index].id;
				
				let input = document.createElement("input");
				input.classList.add("form-control");
				input.placeholder = "Valor";
				input.setAttribute("input_cartao", "input_cartao");
				input.name = "valor_cartao_" + cartoes[index].id;
				input.type = "number";
				input.addEventListener("change", calculaValores);
				div.append(input);
				
				cartoes[index].parentElement.append(div);
			} else if(this.id == cartoes[index].id 
					&& !cartoes[index].checked
					&& cartoes[index].parentElement.childElementCount > 2) {
				cartoes[index].parentElement.removeChild($("#dados_cartao_" + cartoes[index].id)[0]);
			}
		});
	});

	function calculaValores() {
		if(!isNaN(new Number(this.value))) {
			if(this.name.include("valor_cartao")) {
				
			} else if(this.name.include("parcelas_cartao")) {
				
			}
		}
	};
	
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
    
    function getNomeCliente() {
    	let cookies = document.cookie.split(";");
    	let nomeCliente = cookies[0].split("=");
    	return nomeCliente[1];
    }

    $("#nome-cli")[0].textContent = getNomeCliente();
    $("#cliente-id")[0].value = getIdCliente();
    $("#carrinho-id")[0].value = getIdCarrinho();

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
            success: function (response) {
                if (response.erro) {
                    $("#backend_menssagem")[0].innerHTML = response.erro;
                    $("#backend_menssagem").removeAttr("style");
                    $("#backend_menssagem").addClass("alert alert-danger");
                } else {
                    for (let el of response) {
                        options += "<option value='" + el.id + "'>" + el.descricao + "</option>";
                    }
                }
            },
            error: function (error) {
                console.log(error);
            }
        });
        return options;

    };

    $("#select-novo-endereco")[0].addEventListener('click', function () {
        $("#novo-endereco")[0].style.display = "";
        carregaPais();
		carregaEstado();
        carregaCidade();
    });

    $("#novo-cartao")[0].addEventListener('click', function () {
        let optionsBandeira = carregaBandeira();
        $("#bandeiras").append(optionsBandeira);
        $("#cartao")[0].style.display = "";
        $("#div-novo-cartao")[0].style.display = "";
        $("#cartao-novo")[0].value = "true";
        console.log(optionsBandeira);
    });

    function carregaPais() {
        let options = "";
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/the-wall-crud/pais",
            dataType: "json",
            data: {
                retornoJson: true,
                btnOperacao: "CONSULTAR",
            },
            success: function (response) {
                if (response.erro) {
                    $("#backend_menssagem")[0].innerHTML = response.erro;
                    $("#backend_menssagem").removeAttr("style");
                    $("#backend_menssagem").addClass("alert alert-danger");
                } else {
                    for (let el of response) {
                        options += "<option value='" + el.id + "'>" + el.nome + "</option>";
                    }
                    $("#paises").append(options);
                }
            },
            error: function (error) {
                console.log(error);
            }
        });

    };

    function carregaEstado() {
        let options = "";
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/the-wall-crud/estado",
            dataType: "json",
            data: {
                retornoJson: true,
                btnOperacao: "CONSULTAR",
            },
            success: function (response) {
                if (response.erro) {
                    $("#backend_menssagem")[0].innerHTML = response.erro;
                    $("#backend_menssagem").removeAttr("style");
                    $("#backend_menssagem").addClass("alert alert-danger");
                } else {
                    for (let el of response) {
                        options += "<option value='" + el.id + "'>" + el.nome + "</option>";
                    }
                    $("#estados").append(options);
                }
            },
            error: function (error) {
                console.log(error);
            }
        });

    };

    function carregaCidade() {
        let options = "";
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/the-wall-crud/cidade",
            dataType: "json",
            data: {
                retornoJson: true,
                btnOperacao: "CONSULTAR",
            },
            success: function (response) {
                if (response.erro) {
                    $("#backend_menssagem")[0].innerHTML = response.erro;
                    $("#backend_menssagem").removeAttr("style");
                    $("#backend_menssagem").addClass("alert alert-danger");
                } else {
                    for (let el of response) {
                        options += "<option value='" + el.id + "'>" + el.nome + "</option>";
                    }
                    $("#cidades").append(options);
                }
            },
            error: function (error) {
                console.log(error);
            }
        });

    };
    
    function calculaDesconto(valorCupom){
    	
    	let totalDesconto = Number($("#desconto")[0].innerText.replace(/[^0-9,-]+/g,"").replace(/[^0-9-]+/g, "."));
    	let total = Number($("#total")[0].innerText.replace(/[^0-9,-]+/g,"").replace(/[^0-9-]+/g, "."));
    	let saldo = Number($("#saldo")[0].innerText.replace(/[^0-9,-]+/g,"").replace(/[^0-9-]+/g, "."));
    	let totalSemDesconto = Number($("#total-sem-desconto")[0].innerText.replace(/[^0-9,-]+/g,"").replace(/[^0-9-]+/g, "."));
    		
    	 
    	totalDesconto += valorCupom;
    	saldo =  totalDesconto - totalSemDesconto;
    	
    	if(saldo > 0){
    		$("#li-saldo")[0].style.display = "";
    		$("#alert")[0].style.display = "";
    		$("#li-total")[0].style.display = "none";
    		$("#total-saldo")[0].style.display = "";
    		$("#a_vista").removeAttr("required");
    		
    	}else{
    		saldo *= -1;
    		total = saldo;
    		saldo = 0;
    		$("#alert")[0].style.display = "none";
    		$("#li-saldo")[0].style.display = "none";
    		$("#total-saldo")[0].style.display = "none";
    		$("#li-total")[0].style.display = "";
    		$("#a_vista").attr("required", "required");
    	}
    	if(totalDesconto == 0){
    		$("#total-saldo")[0].style.display = "none";
    		$("#li-total")[0].style.display = "";
    		total = totalSemDesconto;
    	}

    	$("#total")[0].innerText = total.toLocaleString("pt-BR", {style: "currency", currency: "BRL"});
    	$("#desconto")[0].innerText = totalDesconto.toLocaleString("pt-BR", {style: "currency", currency: "BRL"});
    	$("#saldo")[0].innerText = saldo.toLocaleString("pt-BR", {style: "currency", currency: "BRL"});
    };
    
    function getCupomValue(cupom){
    	let valorCupom = new Number (cupom.id);	
    	    	
    	if(!cupom.checked){
    		valorCupom *= -1;
    		
    	}
    	calculaDesconto(valorCupom);
    };
</script>
</html>