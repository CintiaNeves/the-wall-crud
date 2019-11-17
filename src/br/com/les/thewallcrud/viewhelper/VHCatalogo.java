package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Catalogo;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHCatalogo implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		Catalogo catalogo = new Catalogo();
		return catalogo;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		String operacao = request.getParameter("btnOperacao");

		try {
			if (operacao.equals("CONSULTAR")) {
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
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
