package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.PedidoDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StRegistraPedidoTrocado implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Troca troca = (Troca) entidade;
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		pedido.setNumero(troca.getNumPedidoCompra());
		pedido.setCliente(cliente);
		IDAO dao = new PedidoDAO();
		Resultado resultado = dao.consultarById(pedido);
		pedido = (Pedido) resultado.getEntidade();
		pedido.getStatus().setId((long) 6);
		dao.alterar(pedido);
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
