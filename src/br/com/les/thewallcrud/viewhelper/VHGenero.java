package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHGenero implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stId = request.getParameter("genero");
		Genero genero = new Genero();
		if(stId != null && (!stId.trim().equals(""))) {
			genero.setId(Long.parseLong(stId));
		}

		return genero;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = null;
			if (resultado.getErro()) {
				json = "{\"erro\":\"".concat(resultado.getMensagem().concat("\"}"));
			} else {
				json = mapper.writeValueAsString(resultado.getListEntidade());
			}
			response.getWriter().write(json);
			response.getWriter().flush();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
