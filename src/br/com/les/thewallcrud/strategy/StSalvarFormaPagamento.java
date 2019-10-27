package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.FormaPagamentoDAO;
import br.com.les.thewallcrud.dominio.FormaPagamento;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSalvarFormaPagamento implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Pedido pedido = (Pedido) resultado.getEntidade();
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		
		for(FormaPagamento f : pedido.getFormasPagamento()) {
			f.setIdPedido(pedido.getId());
			dao.salvar(f);
		}
		
		return resultado;
	}

}
