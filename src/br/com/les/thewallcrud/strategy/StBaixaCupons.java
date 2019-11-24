package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.CupomDAO;
import br.com.les.thewallcrud.dao.FormaPagamentoDAO;
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
		IDAO dao = new FormaPagamentoDAO();
		Resultado res = dao.consultarById(pedido);
		dao = new CupomDAO();

		for (EntidadeDominio e : res.getListEntidade()) {
			FormaPagamento f = (FormaPagamento) e;
			if (f.getCupons() != null) {
				for (Cupom c : f.getCupons()) {
					Resultado r = dao.consultarById(c);
					if(r.getListEntidade() != null) {
						Cupom cupom = (Cupom) r.getEntidade();
						cupom.setExpirado(true);
						cupom.setIdPedido(pedido.getId());
						dao.alterar(cupom);
					}
				}
			}
		}
		return resultado;
	}

}
