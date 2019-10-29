package br.com.les.thewallcrud.viewhelper;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Relatorio;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHRelatorio implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String dataInicio = request.getParameter("dataInicio");
		String dataFim = request.getParameter("dataFim");
		String idInstrumentos = request.getParameter("idInstrumentos");
		String[] ids = null;
		if(idInstrumentos != null && !idInstrumentos.equals("")) {
			ids = idInstrumentos.split("-");			
		}
		Relatorio r = new Relatorio();
		Map<String, String> dados = new HashMap<>();
		dados.put("dataInicio", dataInicio);
		dados.put("dataFim", dataFim);
		if(ids != null) {
			for (String id : ids) {
				dados.put(id, id);			
			}			
		}
		r.setDados(dados);
		return r;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		String operacao = request.getParameter("operacao");
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
						json = mapper.writeValueAsString(resultado.getListEntidade());
					}
					response.getWriter().write(json);
					response.getWriter().flush();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
			}
		}
	}
}
