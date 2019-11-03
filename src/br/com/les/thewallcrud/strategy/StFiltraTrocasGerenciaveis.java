package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.StatusPedidoDAO;
import br.com.les.thewallcrud.dao.TrocaDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StFiltraTrocasGerenciaveis implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Troca troca = (Troca) resultado.getEntidade();
		if(troca.getId() == null) {
			IDAO dao = new TrocaDAO();
			List<Troca> gerenciaveis = new ArrayList<>();
			Resultado r = dao.consultar(troca);
			
			for(EntidadeDominio e : r.getListEntidade()) {
				Troca t = (Troca) e;
				if(t.getStatus().getId() == 6 || t.getStatus().getId() == 7) {
					gerenciaveis.add(t);
				}
			}
			List<EntidadeDominio> entidades = new ArrayList<>();
			for(Troca t : gerenciaveis) {
				dao = new ClienteDAO();
				Cliente cliente = new Cliente();
				cliente.setId(t.getIdCliente());
				r = dao.consultarById(cliente);
				cliente = (Cliente) r.getEntidade();
				t.setCliente(cliente);
				dao = new StatusPedidoDAO();
				StatusPedido status = new StatusPedido();
				status.setId(t.getStatus().getId());
				r = dao.consultarById(status);
				status = (StatusPedido) r.getEntidade();
				t.setStatus(status);
				entidades.add(t);
			}
			resultado.clear();
			resultado.setListEntidade(entidades);
			return resultado;
		}else {
			
			return resultado;
		}
	}

}
