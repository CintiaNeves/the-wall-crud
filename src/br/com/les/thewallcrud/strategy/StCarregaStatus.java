package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.StatusPedidoDAO;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCarregaStatus implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Pedido pedido = (Pedido) resultado.getEntidade();
		IDAO dao = new StatusPedidoDAO();
		List<StatusPedido> aplicaveis = new ArrayList<>();
		aplicaveis.add(pedido.getStatus());
		
		if(pedido.getStatus().getId() == 2) {
			StatusPedido s =  new StatusPedido();
			s.setId((long) 4);
			Resultado r = dao.consultarById(s);
			s = (StatusPedido) r.getEntidade();
			aplicaveis.add(s);
		}else if(pedido.getStatus().getId() == 4) {
			StatusPedido s =  new StatusPedido();
			s.setId((long) 5);
			Resultado r = dao.consultarById(s);
			s = (StatusPedido) r.getEntidade();
			aplicaveis.add(s);
		}
		List<EntidadeDominio> entidades = new ArrayList<>();
		for(StatusPedido s : aplicaveis) {
			entidades.add((EntidadeDominio) s);
		}
		resultado.setMapEntidade("STATUS", entidades);
		return resultado;
	}

}
