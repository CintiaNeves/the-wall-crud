package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.StatusPedidoDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewTrocasAdmin implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		List<Troca> trocas = new ArrayList<>();
		IDAO dao;
		
		for(EntidadeDominio e : resultado.getListEntidade()){
			Troca troca = (Troca) e;
			if(troca.getFlag()) {
				
				return resultado;
			}
			Resultado r = new Resultado();
			Cliente cliente = new Cliente();
			cliente.setId(troca.getIdCliente());
			dao = new ClienteDAO();
			r = dao.consultarById(cliente);
			cliente = (Cliente) r.getEntidade();
			StatusPedido status = new StatusPedido();
			dao = new StatusPedidoDAO();
			r = dao.consultarById(troca.getStatus());
			status = (StatusPedido) r.getEntidade();
			troca.setStatus(status);
			troca.setCliente(cliente);
			trocas.add(troca);
		}
		
		resultado.getListEntidade().clear();
		
		List<EntidadeDominio> entidades = new ArrayList<>();
		
		for(Troca t : trocas) {
			entidades.add((EntidadeDominio) t);
		}
		
		resultado.setListEntidade(entidades);
		return resultado;
	}

}
