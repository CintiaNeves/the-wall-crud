package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.PedidoDAO;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StAlterarStatusPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		if(pedido.getId() == null)
			return null;
		StatusPedido novoStatus = pedido.getStatus();
		IDAO dao = new PedidoDAO();
		Resultado resultado = new Resultado();
		resultado = dao.consultarById(pedido);
		pedido = (Pedido) resultado.getEntidade();
		pedido.setStatus(novoStatus);
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
