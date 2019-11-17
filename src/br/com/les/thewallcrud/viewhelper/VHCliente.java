package br.com.les.thewallcrud.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.dominio.Telefone;
import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHCliente implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stRetornoJson = request.getParameter("retornoJson");
		String stIdCliente = request.getParameter("idCliente");
		String stAlter = request.getParameter("alter");
		
		
		if(stRetornoJson != null && stRetornoJson.trim().equals("true") || stAlter != null && stAlter.trim().equals("true")) {
			Cliente cliente = new Cliente();
			if(stIdCliente != null && !stIdCliente.trim().equals("")) {
				cliente.setId(Long.parseLong(stIdCliente));
			}
			return cliente;
		}
		Integer endCount = 0;
		Integer cardCount = 0;
		String stEndCount = request.getParameter("endCount");
		String stCardCount = request.getParameter("cardCount");
		String stNome = request.getParameter("nome");
		String stCpf = request.getParameter("cpf");
		String stDataNascimento = request.getParameter("nascimento");
		String stCodigo = request.getParameter("codigo");
		String stUsuario = request.getParameter("usuario");
		String stEmail = request.getParameter("email");
		String stAlias = null;
		String stTpResidencia = null;
		String stTpLogradouro = null;
		String stLogradouro = null;
		String stNumero = null;
		String stCep = null;
		String stBairro = null;
		String stPais = null;
		String stEstado = null;
		String stCidade = null;
		String stObservacao = null;
		String stBandeira = null;
		String stNumCartao = null;
		String stNomeCartao = null;
		String stCod = null;

		IViewHelper vhGenero = new VHGenero();
		Genero genero = (Genero) vhGenero.getEntidade(request);
		Usuario usuario = new Usuario();
		if (stUsuario != null && (!stUsuario.trim().equals(""))) {
			usuario.setId(Long.parseLong(stUsuario));
		}
		IViewHelper vhTelefone = new VHTelefone();
		IViewHelper vhCelular = new VHCelular();
		List<Telefone> telefones = new ArrayList<Telefone>();
		Telefone telefone = (Telefone) vhTelefone.getEntidade(request);
		Telefone celular = (Telefone) vhCelular.getEntidade(request);
		telefones.add(telefone);
		telefones.add(celular);
		IViewHelper vhEndereco = new VHEnderecoCobranca();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		Endereco cobranca = (Endereco) vhEndereco.getEntidade(request);
		enderecos.add(cobranca);
		List<Cartao> cartoes = new ArrayList<Cartao>();
		IViewHelper vhCarrinho = new VHCarrinho();
		Carrinho carrinho = (Carrinho) vhCarrinho.getEntidade(request);

		if (stCardCount != null && (!stCardCount.trim().equals(""))) {
			cardCount = Integer.parseInt(stCardCount);
		}

		for (Integer i = 1; i <= cardCount; i++) {
			if (i == 1) {
				stBandeira = request.getParameter("bandeira");
				stNumCartao = request.getParameter("num-cartao");
				stNomeCartao = request.getParameter("nome-cartao");
				stCod = request.getParameter("cod");
			} else {
				stBandeira = request.getParameter("bandeira-".concat(i.toString()));
				stNumCartao = request.getParameter("num-cartao-".concat(i.toString()));
				stNomeCartao = request.getParameter("nome-cartao-".concat(i.toString()));
				stCod = request.getParameter("cod-".concat(i.toString()));
			}
			Bandeira bandeira = new Bandeira();
			if (stBandeira != null && (!stBandeira.trim().equals(""))) {
				bandeira.setId(Long.parseLong(stBandeira));
			}
			Cartao cartao = new Cartao();
			cartao.setBandeira(bandeira);
			cartao.setCodSeguranca(stCod);
			cartao.setNomeImpresso(stNomeCartao);
			cartao.setNumero(stNumCartao);
			cartoes.add(cartao);
		}

		if (stEndCount != null && (!stEndCount.trim().equals(""))) {
			endCount = Integer.parseInt(stEndCount);
		}
		for (Integer i = 1; i <= endCount; i++) {
			if (i == 1) {
				stAlias = request.getParameter("apelido-ent");
				stTpResidencia = request.getParameter("tp-resid-ent");
				stTpLogradouro = request.getParameter("tp-logra-ent");
				stLogradouro = request.getParameter("logradouro-ent");
				stNumero = request.getParameter("numero-ent");
				stCep = request.getParameter("cep-ent");
				stBairro = request.getParameter("bairro-ent");
				stPais = request.getParameter("pais-ent");
				stEstado = request.getParameter("estado-ent");
				stCidade = request.getParameter("cidade-ent");
				stObservacao = request.getParameter("observacao-ent");
			} else {
				stAlias = request.getParameter("apelido-ent-".concat(i.toString()));
				stTpResidencia = request.getParameter("tp-resid-ent-".concat(i.toString()));
				stTpLogradouro = request.getParameter("tp-logra-ent-".concat(i.toString()));
				stLogradouro = request.getParameter("logradouro-ent-".concat(i.toString()));
				stNumero = request.getParameter("numero-ent-".concat(i.toString()));
				stCep = request.getParameter("cep-ent-".concat(i.toString()));
				stBairro = request.getParameter("bairro-ent-".concat(i.toString()));
				stPais = request.getParameter("pais-ent-".concat(i.toString()));
				stEstado = request.getParameter("estado-ent-".concat(i.toString()));
				stCidade = request.getParameter("cidade-ent-".concat(i.toString()));
				stObservacao = request.getParameter("observacao-ent-".concat(i.toString()));
			}
			Cidade cidade = new Cidade();
			Estado estado = new Estado();
			Pais pais = new Pais();
			Endereco endereco = new Endereco();
			if (stCidade != null && (!stCidade.trim().equals(""))) {
				cidade.setId(Long.parseLong(stCidade));
			}
			if (stEstado != null && (!stEstado.trim().equals(""))) {
				estado.setId(Long.parseLong(stEstado));
			}
			estado.setCidade(cidade);
			if (stPais != null && (!stPais.trim().equals(""))) {
				pais.setId(Long.parseLong(stPais));
			}
			pais.setEstado(estado);
			endereco.setPais(pais);
			endereco.setAlias(stAlias);
			endereco.setBairro(stBairro);
			endereco.setCep(stCep);
			endereco.setCobranca(false);
			endereco.setLogradouro(stLogradouro);
			endereco.setNumero(stNumero);
			endereco.setObservacoes(stObservacao);
			endereco.setTpLogradouro(stTpLogradouro);
			endereco.setTpResidencia(stTpResidencia);
			enderecos.add(endereco);
		}

		Cliente cliente = new Cliente();
		cliente.setAtivo(true);
		cliente.setNome(stNome);
		cliente.setPontuacao(10);
		cliente.setCodigo(stCodigo);
		cliente.setCpf(stCpf);
		cliente.setEmail(stEmail);
		cliente.setDataNascimento(stDataNascimento);
		cliente.setGenero(genero);
		cliente.setUsuario(usuario);
		cliente.setTelefones(telefones);
		cliente.setCartoes(cartoes);
		cliente.setEnderecos(enderecos);
		cliente.setCarrinho(carrinho);

		return cliente;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		try {
			RequestDispatcher rd;
			if (operacao.equals("SALVAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("generos", resultado.getMapEntidade().get("GENEROS"));
					request.setAttribute("bandeiras", resultado.getMapEntidade().get("BANDEIRAS"));
					request.setAttribute("paises", resultado.getMapEntidade().get("PAISES"));
					request.setAttribute("cidades", resultado.getMapEntidade().get("CIDADES"));
					request.setAttribute("estados", resultado.getMapEntidade().get("ESTADOS"));
					request.setAttribute("cliente", resultado.getEntidade());
					rd = request.getRequestDispatcher("registro.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("cliente", resultado.getEntidade());
					rd = request.getRequestDispatcher("index.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("CONSULTAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("cliente", resultado.getEntidade());
					rd = request.getRequestDispatcher("registro.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("cliente", resultado.getEntidade());
					rd = request.getRequestDispatcher("index.jsp");
				}
				rd.forward(request, response);
			}else if (operacao.equals("CONSULTARBYID")) {
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
							json = mapper.writeValueAsString(resultado.getEntidade());
						}
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}else if(request.getParameter("alter") != null && Boolean.parseBoolean(request.getParameter("alter")) == true) {
					if (resultado.getErro()) {
						request.setAttribute("erro", mensagem);
						rd = request.getRequestDispatcher("index.jsp");
					} else {
						request.setAttribute("sucesso", mensagem);
						request.setAttribute("generos", resultado.getMapEntidade().get("GENEROS"));
						request.setAttribute("bandeiras", resultado.getMapEntidade().get("BANDEIRAS"));
						request.setAttribute("paises", resultado.getMapEntidade().get("PAISES"));
						request.setAttribute("cidades", resultado.getMapEntidade().get("CIDADES"));
						request.setAttribute("estados", resultado.getMapEntidade().get("ESTADOS"));
						request.setAttribute("cliente", resultado.getEntidade());
						rd = request.getRequestDispatcher("registro.jsp");
					}
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
