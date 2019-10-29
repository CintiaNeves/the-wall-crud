package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemPedidoDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemPedido;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCarregaItens implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {

		Pedido pedido = (Pedido) resultado.getEntidade();
		IDAO dao = new ItemPedidoDAO();
		Resultado r = new Resultado();
		r = dao.consultarById(pedido);
		List<ItemPedido> itens = new ArrayList<>();
		
		dao = new InstrumentoDAO();
		for(EntidadeDominio e : r.getListEntidade()) {
			ItemPedido item = (ItemPedido) e;
			Instrumento i = item.getInstrumento();
			r = dao.consultarById(i);
			item.setInstrumento((Instrumento) r.getEntidade());
			item.setTotalItem(item.getInstrumento().getValorVenda() * item.getQuantidade());
			itens.add(item);	
		}

		pedido.setItens(itens);
				
		return resultado;
	}

}
