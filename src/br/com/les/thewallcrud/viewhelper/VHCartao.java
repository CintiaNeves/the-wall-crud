package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHCartao implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stIdBandeira = request.getParameter("bandeira");
		String stNumero = request.getParameter("num-cartao");
		String stNome = request.getParameter("nome-cartao");
		String stCod = request.getParameter("cod");
		
		Cartao cartao = new Cartao();
		if(stIdBandeira != null && (!stIdBandeira.trim().equals(""))) {
			cartao.getBandeira().setId(Long.parseLong(stIdBandeira));
		}
		cartao.setNumero(stNumero);
		cartao.setNomeImpresso(stNome);
		cartao.setCodSeguranca(stCod);
		
		return cartao;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
