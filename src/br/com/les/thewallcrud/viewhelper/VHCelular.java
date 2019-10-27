package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Telefone;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHCelular implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stCelular = request.getParameter("celular");
		String stDdd = stCelular;
		String stNumero = "";
		if(stCelular != null && (!(stCelular.trim().length() < 10 ))) {
			stDdd = stCelular.substring(0, 2);
			stNumero = stCelular.substring(2);
		}		
		Telefone celular = new Telefone();
		celular.setDdd(stDdd);
		celular.setNumero(stNumero);
		celular.setTipo("CELULAR");
		
		return celular;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
