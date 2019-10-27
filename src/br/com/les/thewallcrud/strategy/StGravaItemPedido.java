package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemPedidoDAO;
import br.com.les.thewallcrud.dominio.ItemPedido;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGravaItemPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
	
		Pedido pedido = (Pedido) resultado.getEntidade();
		IDAO dao = new ItemPedidoDAO();
		
		for(ItemPedido i : pedido.getItens()) {
			i.setIdPedido(pedido.getId());
			dao.salvar(i);
		}
		
		return resultado;
	}

}
