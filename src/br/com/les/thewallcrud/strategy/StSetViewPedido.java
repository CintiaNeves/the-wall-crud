package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.StatusPedidoDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if (!resultado.getErro()) {
			IDAO dao;
			Resultado r = new Resultado();
			if (resultado.getListEntidade() != null) {

				for (EntidadeDominio e : resultado.getListEntidade()) {
					Pedido pedido = (Pedido) e;
					dao = new ClienteDAO();
					r = dao.consultarById(pedido.getCliente());
					Cliente c = (Cliente) r.getEntidade();
					pedido.setCliente(c);

					dao = new StatusPedidoDAO();
					r = dao.consultarById(pedido.getStatus());
					StatusPedido s = (StatusPedido) r.getEntidade();

					pedido.setStatus(s);
				}
			}

		}
		return resultado;
	}

}
