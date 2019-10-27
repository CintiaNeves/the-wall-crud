package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StEsvaziaCarrinho implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Pedido pedido = (Pedido) resultado.getEntidade();
		IDAO dao = new ItemCarrinhoDAO();
				
		for(ItemCarrinho i : pedido.getCliente().getCarrinho().getItens()) {
			i.setExpirado(true);
			dao.alterar(i);
		}
		return resultado;
	}

}
