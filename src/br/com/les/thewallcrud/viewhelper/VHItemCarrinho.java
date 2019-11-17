package br.com.les.thewallcrud.viewhelper;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHItemCarrinho implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stIdInstrumento = request.getParameter("instrumento");
		String stQuantidade = request.getParameter("quantidade");
		String stIdCarrinho = request.getParameter("carrinho");
		String stIdItem = request.getParameter("id");
		ItemCarrinho item = new ItemCarrinho();
		
		if(stIdItem != null) {
			item.setId(Long.parseLong(stIdItem));
		}
		LocalDateTime now = LocalDateTime.now();
		String data = now.toString();
		Instrumento instrumento = new Instrumento();
		item.setData(data);
		
		if(stIdInstrumento != null && (!stIdInstrumento.trim().equals(""))) {
			instrumento.setId(Long.parseLong(stIdInstrumento));
		}
		
		if(stIdCarrinho != null && (!stIdCarrinho.trim().equals(""))) {
			item.setIdCarrinho(Long.parseLong(stIdCarrinho));
		}
		
		if(stQuantidade != null && (!stQuantidade.trim().equals(""))) {
			item.setQuantidade(Integer.parseInt(stQuantidade));
			item.setExpirado(false);
			item.setInstrumento(instrumento);
		}
		return item;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		try {
			RequestDispatcher rd;
			if (operacao.equals("CONSULTAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("usuario", resultado.getEntidade());
					rd = request.getRequestDispatcher("login.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("cliente", resultado.getEntidade());
					rd = request.getRequestDispatcher("index.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("SALVAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					rd = request.getRequestDispatcher("login.jsp");
				} else {
					request.setAttribute("carrinho", resultado.getEntidade());
					request.setAttribute("itens", resultado.getMapEntidade().get("ITENS"));
					rd = request.getRequestDispatcher("carrinho.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("ALTERAR")) {
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
				}
			} else if (operacao.equals("EXCLUIR")) {
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
				}
				
			} else if (operacao.equals("CONSULTARBYID")) {
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
