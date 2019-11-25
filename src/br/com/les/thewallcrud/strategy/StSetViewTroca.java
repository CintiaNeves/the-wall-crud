package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.CupomDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemTrocaDAO;
import br.com.les.thewallcrud.dao.PedidoDAO;
import br.com.les.thewallcrud.dao.StatusPedidoDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemTroca;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewTroca implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {

		for (EntidadeDominio e : resultado.getListEntidade()) {
			Troca troca = (Troca) e;
			IDAO dao = new StatusPedidoDAO();
			Resultado r = new Resultado();
			r = dao.consultarById(troca.getStatus());
			StatusPedido s = (StatusPedido) r.getEntidade();
			troca.setStatus(s);
			dao = new ItemTrocaDAO();
			r = dao.consultarById(troca);

			List<ItemTroca> itens = new ArrayList<>();
			
			dao = new InstrumentoDAO();
			if (r.getListEntidade() != null) {
				for (EntidadeDominio ent : r.getListEntidade()) {
					itens.add((ItemTroca) ent);
				}
				for(ItemTroca item : itens) {
					Instrumento instrumento = item.getInstrumento();
					Resultado res = dao.consultarById(instrumento);
					item.setInstrumento((Instrumento) res.getEntidade());
				}
				troca.setItens(itens);
			}
			
			Cliente cliente = new Cliente();
			cliente.setId(troca.getIdCliente());
			dao = new ClienteDAO();
			r = dao.consultarById(cliente);
			cliente = (Cliente) r.getEntidade();
			troca.setCliente(cliente);
		}
		
		if(resultado.getListEntidade().size() == 1) {
			Troca t = (Troca) resultado.getEntidade();
			if (t.getAprova()) {
				Cupom cupom = new Cupom();
				cupom.setId(t.getCupom().getId());
				IDAO dao = new CupomDAO();
				Resultado r = dao.consultarById(cupom);
				if(r.getListEntidade() != null) {
					cupom = (Cupom) r.getEntidade();
					t.setCupom(cupom);
				}	
				if(r.getListEntidade() != null) {
					r.getListEntidade().clear();
				}
				r.setEntidade(t);
				dao = new StatusPedidoDAO();
				List<StatusPedido> aplicaveis = new ArrayList<>();
				Resultado res = dao.consultar(new StatusPedido());
				
				for(EntidadeDominio e : res.getListEntidade()) {
					StatusPedido s = (StatusPedido) e;
					if(s.getId() == 7 || s.getId() == 9) {
						aplicaveis.add(s);
					}
				}
				
				List<EntidadeDominio> entidades = new ArrayList<>();
				for(StatusPedido s : aplicaveis) {
					entidades.add((EntidadeDominio) s);
				}
				resultado.setMapEntidade("STATUS", entidades);
				
				return r;
			}else {
				Troca tr = (Troca) resultado.getEntidade();
				Pedido p = new Pedido();
				p.setId(tr.getIdPedidoCompra());
				IDAO pedDAO = new PedidoDAO();
				Resultado res = pedDAO.consultarById(p);
				p = (Pedido) res.getEntidade();
				tr.setNumPedidoCompra(p.getNumero());
			}
		}
		
		return resultado;
	}

}
