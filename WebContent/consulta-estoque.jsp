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
                            <li class="nav-item"><a class="nav-link" href="index.html">Site</a></li>
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                                    aria-haspopup="true" aria-expanded="false">Pedidos</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="consulta-pedido.html">Consulta</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                                    aria-haspopup="true" aria-expanded="false">Produtos</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link"
                                            href="cadastro-instrumento.html">Cadastro</a></li>
                                    <li class="nav-item"><a class="nav-link"
                                            href="consulta-instrumento.html">Consulta</a></li>
                                </ul>
                            </li>
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                                    aria-haspopup="true" aria-expanded="false">Estoque</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="entrada-estoque.html">Entrada</a>
                                    </li>
                                    <li class="nav-item"><a class="nav-link" href="consulta-estoque.html">Consulta</a>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item submenu dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button"
                                    aria-haspopup="true" aria-expanded="false">Relatórios</a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="grafico.html">Vendas</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <!--================ End Header Menu Area =================-->

    <!--================Login Box Area =================-->
    <section class="section-margin--small" style="margin-left: 15%;">
        <div class="">
            <div class="row">
                <div class="col-md-10">
                    <div class="col-md-12 form-group p_star">
                        <h3>Consulta de entradas</h3>
                    </div>
                    <div id="">
                        <a class="btn btn-secondary" href="/consultar">Listar todas as entradas</a> <br />
                        <br />

                        <form action="/pesquisar" method="post">
                            <div class="row">
                                <div class="col-small">
                                    <div class="input-group ml-3">
                                        <div class="input-group-prepend">
                                            <button class="btn btn-outline-secondary" type="submit"
                                                id="button-addon1">Buscar por NF</button>
                                        </div>
                                        <input type="text" class="form-control" name="titulo" />
                                    </div>
                                </div>
                            </div>
                        </form>
                        <br />
                        <hr />
                    </div>
                    <div id="">
                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Nº Nota</th>
                                    <th>Fornecedor</th>
                                    <th>Data</th>
                                    <th>Valor Total</th>
                                    <th>Ações</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td><a href="consulta-instrumento.html">Excluir</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
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
                    <p class="col-lg-12 footer-text text-center">
                    </p>
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
// remover linha da tabela de regitros
function remover(button) {
	$("#tbody_itens")[0].removeChild(button.parentElement.parentElement);
	$("#tbody_itens").change();
}

$("#cnpj").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
	let cnpj = this.value;
	let nota = $("#nota")[0].value;
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/fornecedor",
		dataType: "json",
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
			cnpj: cnpj,
		},
		success: function(response) {
			if(response.erro) {
				$("#backend_menssagem")[0].innerHTML = response.erro;
				$("#backend_menssagem").removeAttr("style");
				$("#backend_menssagem").addClass("alert alert-danger");
			} else {
				$("#data").val(response.data);
				$("#razaoSocial").val(response.razaoSocial);				
			}
		},
		error: function(error) {
			console.log(error);
		}
	});		
});

$("#tbody_itens").change(function(){
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
	let totalNota = 0;
	if(this.rows.length === 0) {
		$("#totalNota").val((0).toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' }));
		$("#linhas").val(tbody_itens.children.length);
	}
	erro = "";
	codigoArr = [];
	for(row of this.rows) {
		codigoArr.push(row.children[0].children[0].value);
	}
	for(c1 of codigoArr) {
		counter = 0;
		for(c2 of codigoArr) {
			if(c1 === c2 && c1 !== "") {
				counter++;
			}
		}
		if(counter > 1) {
			erro = "Código já informado.";			
		}
	}
	if(erro) {
		$("#mensagem").removeAttr("style");
		$("#mensagem").addClass("alert alert-danger");
		$("#mensagem")[0].innerText = erro;
		return;
	}
	for(row of this.rows) {
		if(row.children[0].children[0].value) {
			let codigo = row.children[0].children[0].value;
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/the-wall-crud/instrumento",
		        async: false,
				dataType: "json",
				data: {
					retornoJson: true,
					btnOperacao: "CONSULTAR",
					codigo: codigo
				},
				success: function(response) {
					if(response.erro) {
						$("#mensagem").removeAttr("style");
						$("#mensagem").addClass("alert alert-danger");
						$("#mensagem")[0].innerText = response.erro;
					} else {
						row.children[1].children[0].innerHTML = response.descricao;
					}
				},
				error: function(error) {
					console.log(error);
				}
			});		
		}
		let total = row.children[4].children[0].value;
		total = row.children[2].children[0].value * row.children[3].children[0].value;
		totalNota += total;
		totalFormatado = Number(total).toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' });
		row.children[4].children[0].innerHTML = totalFormatado;
		$("#totalNota").val(totalNota.toLocaleString("pt-BR", { style: 'currency', currency: 'BRL' }));
		$("#linhas").val(tbody_itens.children.length);
	}
});

$("#adicionar").click(function(){
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
	let rowCount = $("#tbody_itens")[0].childElementCount;
	let row = "" +
	"<tr>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<input class='form-control input-transparent' name='codigo" + rowCount + "' id='codigo" + rowCount + "'>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<label class='form-control input-transparent' id='descricao'></label>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<input class='form-control input-transparent' name='quantidade" + rowCount + "' id='quantidade" + rowCount + "'>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<input class='form-control input-transparent' name='custo" + rowCount + "' id='custo" + rowCount + "'>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<label class='form-control input-transparent' id='total'></label>" +
		"</td>" +
		"<td class='m-0 p-0 pt-1'>" +
			"<button type='button' onclick='remover(this)' class='btn btn-link'>Remover</button>" +
		"</td>" +
	"</tr>";
	$("#tbody_itens").append(row);
});

$("#nota").change(function() {
	$("#mensagem").html("");
	$("#mensagem").removeClass("alert");
	$("#mensagem").removeClass("alert-danger");
	$("#backend_menssagem").html("");
	$("#backend_menssagem").removeClass("alert-danger");
	let cnpj = $("#cnpj")[0].value;
	let nota = $("#nota")[0].value;
	$.ajax({
		type: "POST",
		url: "http://localhost:8080/the-wall-crud/entrada",
		dataType: "json",
		data: {
			retornoJson: true,
			btnOperacao: "CONSULTAR",
			nota: nota,
			cnpj: cnpj,
		},
		success: function(response) {
			if(response.erro) {
				$("#backend_menssagem")[0].innerHTML = response.erro;
				$("#backend_menssagem").removeAttr("style");
				$("#backend_menssagem").addClass("alert alert-danger");
			} else {				
			}
		},
		error: function(error) {
			console.log(error);
		}
	});		
});
</script>
</html>