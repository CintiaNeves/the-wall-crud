package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHCupom implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		return new Cupom();
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
