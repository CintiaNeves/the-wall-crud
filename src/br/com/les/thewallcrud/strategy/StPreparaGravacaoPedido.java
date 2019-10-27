package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.ItemPedido;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StPreparaGravacaoPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		Carrinho carrinho = pedido.getCliente().getCarrinho();
		carrinho.getItens().clear();
		IDAO dao = new ItemCarrinhoDAO();
		Resultado resultado = dao.consultar(carrinho);
		List<ItemPedido> itens = new ArrayList<>();
		dao = new InstrumentoDAO();
		
		for(EntidadeDominio e : resultado.getListEntidade()) {
			ItemCarrinho item = (ItemCarrinho) e;
			resultado = dao.consultarById(item.getInstrumento());
			item.setInstrumento((Instrumento) resultado.getEntidade());
			carrinho.getItens().add(item);
			ItemPedido itemPedido = new ItemPedido();
			itemPedido.setQuantidade(item.getQuantidade());
			itemPedido.setInstrumento(item.getInstrumento());
			itens.add(itemPedido);
			
		}
		pedido.setItens(itens);
		StatusPedido status = new StatusPedido();
		status.setId((long) 1);
		pedido.setStatus(status);
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		return resultado;
	}

}
