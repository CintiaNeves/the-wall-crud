package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Telefone;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHTelefone implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stTelefone = request.getParameter("telefone");
		String stDdd = stTelefone;
		String stNumero = "";
		if(stTelefone != null && (!(stTelefone.trim().length() < 10 ))) {
			stDdd = stTelefone.substring(0, 2);
			stNumero = stTelefone.substring(2);
		}

		Telefone telefone = new Telefone();
		telefone.setDdd(stDdd);
		telefone.setNumero(stNumero);
		telefone.setTipo("TELEFONE");
		
		return telefone;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
