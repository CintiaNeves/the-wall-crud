package br.com.les.thewallcrud.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dao.CartaoDAO;
import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.FormaPagamento;
import br.com.les.thewallcrud.dominio.Frete;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHPedido implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		
		if(request.getParameter("retornoJson") != null && Boolean.parseBoolean(request.getParameter("retornoJson"))) {
			if(request.getParameter("idCliente") != null) {
				cliente.setId(Long.parseLong(request.getParameter("idCliente")));
			}
			pedido.setCliente(cliente);
			if(request.getParameter("id") != null ) {
				pedido.setId(Long.parseLong(request.getParameter("id")));
			}
			return pedido;
		}
		String stIdcliente = request.getParameter("cliente-id");
				
		if (stIdcliente != null && (!stIdcliente.trim().equals(""))) {
			cliente.setId(Long.parseLong(stIdcliente));
		} else {
			String stIdPedido = request.getParameter("id-pedido");
			String stIdStatus = request.getParameter("status");
			if (stIdPedido != null && !stIdPedido.trim().equals("")) {
				pedido.setId(Long.parseLong(stIdPedido));
				if (stIdStatus != null && !stIdStatus.trim().equals("")) {
					StatusPedido status = new StatusPedido();
					status.setId(Long.parseLong(stIdStatus));
					pedido.setStatus(status);
				}
				return pedido;
			}
			return new Pedido();
		}

		IViewHelper viewHelper = new VHCarrinho();
		Carrinho carrinho = (Carrinho) viewHelper.getEntidade(request);
		cliente.setCarrinho(carrinho);
		pedido.setCliente(cliente);
		String stSalvarEndereco = request.getParameter("salvar-endereco");
		pedido.setObservacao(request.getParameter("observacao-entrega"));
		String stEnderecos = request.getParameter("radioEndereco");
		Frete frete = new Frete();
		String stValorFrete = request.getParameter("valorFrete");
		if (stValorFrete != null && (!stValorFrete.trim().equals(""))) {
			frete.setValorFrete(Double.parseDouble(stValorFrete));
		}
		List<FormaPagamento> pagamentosUtlizados = new ArrayList<>();
		if (stEnderecos != null && stEnderecos.equals("novo-endereco")) {

			Endereco endereco = new Endereco();
			Pais pais = new Pais();
			Estado estado = new Estado();
			Cidade cidade = new Cidade();
			String stIdCidade = request.getParameter("cidade");
			String stIdEstado = request.getParameter("estado");
			String stIdPais = request.getParameter("pais");
			endereco.setAlias(request.getParameter("apelido"));
			endereco.setTpResidencia(request.getParameter("tp-resid"));
			endereco.setTpLogradouro(request.getParameter("tp-logra"));
			endereco.setLogradouro(request.getParameter("logradouro"));
			endereco.setNumero(request.getParameter("numero"));
			endereco.setCep(request.getParameter("cep"));
			endereco.setBairro(request.getParameter("bairro"));

			if (stIdCidade != null && (!stIdCidade.trim().equals(""))) {
				cidade.setId(Long.parseLong(stIdCidade));
			}

			if (stIdEstado != null && (!stIdEstado.trim().equals(""))) {
				estado.setId(Long.parseLong(stIdEstado));
			}

			if (stIdPais != null && (!stIdPais.trim().equals(""))) {
				pais.setId(Long.parseLong(stIdPais));
			}
			estado.setCidade(cidade);
			pais.setEstado(estado);
			endereco.setPais(pais);
			endereco.setCobranca(false);
			pedido.setEndereco(endereco);

		} else {
			Endereco endereco = new Endereco();
			if (stEnderecos != null && !stEnderecos.trim().equals("")) {
				endereco.setId(Long.parseLong(stEnderecos));
				pedido.setEndereco(endereco);
			}
		}

		if (stSalvarEndereco != null && (!stSalvarEndereco.trim().equals(""))) {
			pedido.setSalvarEndereco(Boolean.parseBoolean(stSalvarEndereco));
		} else {
			pedido.setSalvarEndereco(false);
		}

		String stNovoCartao = request.getParameter("novo-cartao");
		Boolean novoCartao = false;

		if (stNovoCartao != null && !stNovoCartao.equals("false") && !stNovoCartao.trim().equals("")) {
			novoCartao = Boolean.parseBoolean(stNovoCartao);
		}

		if (novoCartao) {
			Cartao cartao = new Cartao();
			Bandeira bandeira = new Bandeira();
			String stIdBandeira = request.getParameter("bandeira");
			if (stIdBandeira != null && (!stIdBandeira.trim().equals(""))) {
				bandeira.setId(Long.parseLong(stIdBandeira));
			}
			cartao.setBandeira(bandeira);
			cartao.setNumero(request.getParameter("numero"));
			cartao.setNomeImpresso(request.getParameter("nome"));
			cartao.setCodSeguranca(request.getParameter("cod"));
			FormaPagamento nCartao = new FormaPagamento();
			nCartao.setCartao(cartao);
			nCartao.setValor(Double.parseDouble(request.getParameter("valor-novo-cartao")));
			pagamentosUtlizados.add(nCartao);
			nCartao.setNovoCartao(true);

		}
		CartaoDAO dao = new CartaoDAO();
		if (cliente.getId() != null) {

		}
		List<EntidadeDominio> entidades = dao.consultar(cliente).getListEntidade();
		List<Cartao> cartoesCliente = new ArrayList<>();
		for (EntidadeDominio e : entidades) {
			cartoesCliente.add((Cartao) e);
		}

		String parcelas = request.getParameter("radio_parcelas");
		for (Cartao c : cartoesCliente) {
			String cartaoSelecionado = request.getParameter("cartao_".concat(c.getId().toString()));
			String stValorCartaoSelecionado = request.getParameter("valor_cartao_".concat(c.getId().toString()));

			if (cartaoSelecionado != null) {
				FormaPagamento f = new FormaPagamento();
				if (parcelas != null) {
					f.setParcelas(Integer.parseInt(parcelas));
				}

				if (stValorCartaoSelecionado != null && !stValorCartaoSelecionado.trim().equals("")) {
					f.setValor(Double.parseDouble(stValorCartaoSelecionado));
				}
				f.setCartao(c);
				pagamentosUtlizados.add(f);
			}
		}
		Cupom cupom = new Cupom();
		cupom.setIdCarrinho(cliente.getCarrinho().getId());
		List<Cupom> cupons = new ArrayList<>();
		cupons.add(cupom);
		FormaPagamento forma = new FormaPagamento();
		forma.setCupons(cupons);
		pagamentosUtlizados.add(forma);
		pedido.setFormasPagamento(pagamentosUtlizados);
		pedido.setFrete(frete);

		return pedido;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		String operacao = request.getParameter("btnOperacao");
		try {
			RequestDispatcher rd;
			if (operacao.equals("SALVAR")) {

				if (request.getParameter("retornoJson") != null
						&& Boolean.parseBoolean(request.getParameter("retornoJson")) == true) {
					response.addHeader("Access-Control-Allow-Origin", "*");
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					ObjectMapper mapper = new ObjectMapper();
					try {
						String json = null;
						if (resultado.getErro()) {
							json = "{\"erro\":\"".concat(resultado.getMensagem().concat("\"}"));
						} else {
							json = mapper.writeValueAsString(resultado.getEntidade());
						}
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (resultado.getErro()) {
						request.setAttribute("pedido", resultado.getEntidade());
						rd = request.getRequestDispatcher("resumo.jsp");
					} else {

						request.setAttribute("pedido", resultado.getEntidade());
						rd = request.getRequestDispatcher("resumo.jsp");
					}
					rd.forward(request, response);
				}
			} else if (operacao.equals("CONSULTAR")) {
				if (resultado.getErro()) {
					request.setAttribute("pedido", resultado.getEntidade());
					rd = request.getRequestDispatcher("consulta-pedido.jsp");
				} else {

					request.setAttribute("pedidos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta-pedido.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("CONSULTARBYID")) {
				if(request.getParameter("retornoJson") != null && Boolean.parseBoolean(request.getParameter("retornoJson")) == true) {
					response.addHeader("Access-Control-Allow-Origin", "*");
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					ObjectMapper mapper = new ObjectMapper();
					try {
						String json = null;
						if(resultado.getErro()) {
							json = "{\"erro\":\"".concat(resultado.getMensagem().concat("\"}"));
						} else {
							json = mapper.writeValueAsString(resultado.getListEntidade());
						}
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}else {
					if (resultado.getErro()) {
						request.setAttribute("pedido", resultado.getEntidade());
						rd = request.getRequestDispatcher("gerenciar-pedido.jsp");
					} else {

						request.setAttribute("pedido", resultado.getEntidade());
						request.setAttribute("status", resultado.getMapEntidade().get("STATUS"));
						rd = request.getRequestDispatcher("gerenciar-pedido.jsp");
					}
					rd.forward(request, response);
				}

				
			} else if (operacao.equals("ALTERAR")) {
				if (resultado.getErro()) {
					request.setAttribute("pedido", resultado.getEntidade());
					rd = request.getRequestDispatcher("pedido.jsp");
				} else {
					request.setAttribute("pedidos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta-pedido.jsp");
				}
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
