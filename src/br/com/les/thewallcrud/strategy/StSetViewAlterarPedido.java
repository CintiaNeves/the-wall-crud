package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

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
		if(pedido.getId() == null) {
			IDAO dao = new PedidoDAO();
			Resultado res = dao.consultar(pedido);
			List<Pedido> gerenciaveis = new ArrayList<>();
			
			for(EntidadeDominio e : res.getListEntidade()) {
				Pedido p = (Pedido) e;
				if(p.getStatus().getId() == 2 || p.getStatus().getId() == 4) {
					gerenciaveis.add(p);
				}
			}
			List<EntidadeDominio> entidades = new ArrayList<>();
			for(Pedido p : gerenciaveis) {
				entidades.add(p);
			}
			resultado.clear();
			resultado.setListEntidade(entidades);
			IStrategy st = new StSetViewPedido();
			st.processar(resultado);
			return resultado;
		}
			
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
