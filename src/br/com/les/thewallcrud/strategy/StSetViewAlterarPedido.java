package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.PedidoDAO;
import br.com.les.thewallcrud.dao.StatusPedidoDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewAlterarPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		Pedido pedido = (Pedido) resultado.getEntidade();
		IDAO dao = new PedidoDAO();
		Resultado r = new Resultado();
		r = dao.consultarById(pedido);
		Pedido p = (Pedido) r.getEntidade();
		dao = new ClienteDAO();
		r = dao.consultarById(p.getCliente());
		Cliente c = (Cliente) r.getEntidade();
		dao = new StatusPedidoDAO();
		r = dao.consultarById(p.getStatus());
		StatusPedido s = (StatusPedido) r.getEntidade();
		p.setCliente(c);
		p.setStatus(s);
		resultado.getListEntidade().clear();
		resultado.setEntidade(p);
		
		return resultado;
	}

}
