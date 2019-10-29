package br.com.les.thewallcrud.viewhelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Categoria;
import br.com.les.thewallcrud.dominio.GrupoPrecificacao;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHInstrumento implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		VHGrupoPrecificacao VHGrupoprecificacao = new VHGrupoPrecificacao();
		GrupoPrecificacao grupoPrecificacao = (GrupoPrecificacao) VHGrupoprecificacao.getEntidade(request);

		VHCategoria VHCategoria = new VHCategoria();
		Categoria categoria = (Categoria) VHCategoria.getEntidade(request);

		String stCogigo = request.getParameter("codigo");
		String stId = request.getParameter("id");
		String stDescricao = request.getParameter("descricao");
		String stMarca = request.getParameter("marca");
		String stModelo = request.getParameter("modelo");
		String stCor = request.getParameter("cor");
		String stEspecificacoes = request.getParameter("especificacoes");
		String stSerie = request.getParameter("serie");
		String stEntrada = request.getParameter("entrada");
		String stCadastro = request.getParameter("cadastro");
		String stValorVenda = request.getParameter("ValorVenda");
		Instrumento instrumento = new Instrumento();
		
		if(stValorVenda != null && (!stValorVenda.trim().equals(""))) {
			instrumento.setValorVenda(Double.parseDouble(stValorVenda));
		}
		
		if (stEntrada != null && (!stEntrada.trim().equals(""))) {
			instrumento.setEntrada(Boolean.parseBoolean(stEntrada));
		}else {
			instrumento.setEntrada(false);
		}
		
		if (stCadastro != null && (!stCadastro.trim().equals(""))) {
			instrumento.setCadastro(Boolean.parseBoolean(stCadastro));
		}else {
			instrumento.setCadastro(false);
		}
		
		if (stId != null) {
			if (!stId.equals("0") && !stId.trim().equals("")) {
				instrumento.setId(Long.parseLong(stId));
			}
		}

		if (stCogigo != null && !stCogigo.trim().equals("")) {
			instrumento.setCodigo(stCogigo);
		}
		instrumento.setAtivo(true);
		instrumento.setDescricao(stDescricao);
		instrumento.setSerie(stSerie);
		instrumento.setMarca(stMarca);
		instrumento.setModelo(stModelo);
		instrumento.setCor(stCor);
		instrumento.setEspecificacoes(stEspecificacoes);
		instrumento.setGrupoPrecificacao(grupoPrecificacao);
		instrumento.setCategoria(categoria);
		instrumento.setSerie(stSerie);
		return instrumento;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		Instrumento instrumento;
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

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

						e.printStackTrace();
					}
				} else {
					if (resultado.getErro()) {
						request.setAttribute("erro", mensagem);
						request.setAttribute("instrumento", resultado.getEntidade());
						rd = request.getRequestDispatcher("cadastro.jsp");
					} else {
						request.setAttribute("sucesso", mensagem);
						request.setAttribute("instrumentos", resultado.getListEntidade());
						rd = request.getRequestDispatcher("consulta.jsp");
					}
					rd.forward(request, response);

				}
			} else if (operacao.equals("CONSULTAR")) {
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
							if(resultado.getListEntidade().size() > 1) {
								json = mapper.writeValueAsString(resultado.getListEntidade());
							} else {
								json = mapper.writeValueAsString(resultado.getEntidade());								
							}
						}
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
				} else {
					if (resultado.getErro()) {
						request.setAttribute("erro", mensagem);
						request.setAttribute("instrumentos", resultado.getListEntidade());
						rd = request.getRequestDispatcher("consulta.jsp");
					} else {
						request.setAttribute("sucesso", mensagem);
						request.setAttribute("instrumentos", resultado.getListEntidade());
						rd = request.getRequestDispatcher("consulta.jsp");
					}
					rd.forward(request, response);
				}

			} else if (operacao.equals("ALTERAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("instrumentos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("instrumentos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("EXCLUIR")) {
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

						e.printStackTrace();
					}
				} else {
					if (resultado.getErro()) {
						request.setAttribute("erro", mensagem);
						request.setAttribute("instrumentos", resultado.getListEntidade());
						rd = request.getRequestDispatcher("consulta.jsp");
					} else {
						request.setAttribute("sucesso", mensagem);
						request.setAttribute("instrumentos", resultado.getListEntidade());
						rd = request.getRequestDispatcher("consulta.jsp");
					}
					rd.forward(request, response);
				}
			} else if (operacao.equals("CONSULTARBYID")) {
				instrumento = (Instrumento) resultado.getEntidade();
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("instrumento", instrumento);
					rd = request.getRequestDispatcher("cadastro.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("instrumento", instrumento);
					rd = request.getRequestDispatcher("cadastro.jsp");
				}
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
