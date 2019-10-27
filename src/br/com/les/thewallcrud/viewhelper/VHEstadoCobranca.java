package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHEstadoCobranca implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String stId = request.getParameter("estado-cbr");
		
		VHCidadeCobranca vhCidade = new VHCidadeCobranca();
		Cidade cidade = (Cidade) vhCidade.getEntidade(request);
		Estado estado = new Estado();
		if(stId != null && (!stId.trim().equals(""))) {
			estado.setId(Long.parseLong(stId));
		}
		
		estado.setCidade(cidade);
		return estado;
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
