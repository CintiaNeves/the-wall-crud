package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.CupomDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.FormaPagamento;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StBaixaCupons implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Pedido pedido = (Pedido) resultado.getEntidade();
		IDAO dao = new CupomDAO();
		
		for(FormaPagamento f: pedido.getFormasPagamento()) {
			if(f.getCupons() != null) {
				for(Cupom c : f.getCupons()) {
					c.setExpirado(true);
					c.setIdPedido(pedido.getId());
					dao.alterar(c);
				}
			}
		}
		
		return resultado;
	}

}
