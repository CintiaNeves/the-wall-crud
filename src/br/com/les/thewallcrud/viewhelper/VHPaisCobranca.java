package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHPaisCobranca implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stId = request.getParameter("pais-cbr");
		
		VHEstadoCobranca vhEstado = new VHEstadoCobranca();
		Estado estado = (Estado)vhEstado.getEntidade(request);
		Pais pais = new Pais();
		if(stId != null && (!stId.trim().equals(""))) {
			pais.setId(Long.parseLong(stId));
		}
		pais.setEstado(estado);
		
		return pais;
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
