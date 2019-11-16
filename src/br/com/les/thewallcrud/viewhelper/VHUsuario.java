package br.com.les.thewallcrud.viewhelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHUsuario implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String stNome = request.getParameter("nome");
		String stSenha = request.getParameter("senha");
		String stConSenha = request.getParameter("confSenha");
		String stReset = request.getParameter("reset");

		Usuario usuario = new Usuario();
		usuario.setNome(stNome);
		usuario.setSenha(stSenha);
		usuario.setConfSenha(stConSenha);
		if(stReset != null) {
			usuario.setReset(Boolean.parseBoolean(stReset));
		}
		
		return usuario;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		try {
			RequestDispatcher rd = null;
			if (operacao.equals("CONSULTAR")) {
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
							json = mapper.writeValueAsString(resultado);
						}
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}else if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("usuario", resultado.getEntidade());
					rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("cliente", resultado.getEntidade());
					rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				
			} else if (operacao.equals("SALVAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("cadastro", 1);
					request.setAttribute("usuario", resultado.getEntidade());
					rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("cliente", resultado.getEntidade());
					request.setAttribute("generos", resultado.getMapEntidade().get("GENEROS"));
					request.setAttribute("bandeiras", resultado.getMapEntidade().get("BANDEIRAS"));
					request.setAttribute("paises", resultado.getMapEntidade().get("PAISES"));
					request.setAttribute("cidades", resultado.getMapEntidade().get("CIDADES"));
					request.setAttribute("estados", resultado.getMapEntidade().get("ESTADOS"));
					rd = request.getRequestDispatcher("registro.jsp");
					rd.forward(request, response);
				}	
			} else if (operacao.equals("ALTERAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("usuario", resultado.getEntidade());
					rd = request.getRequestDispatcher("reset-senha.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("ok", true);
					rd = request.getRequestDispatcher("reset-senha.jsp");
					rd.forward(request, response);
				}	
			} else if (operacao.equals("EXCLUIR")) {
				
			} else if (operacao.equals("CONSULTARBYID")) {
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
