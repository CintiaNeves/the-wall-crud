package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewCarrinho implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Carrinho carrinho = (Carrinho) resultado.getEntidade();
		List<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();
		IDAO dao =  new InstrumentoDAO();
		Double total = 0.0;
		for(ItemCarrinho item : carrinho.getItens()) {
			Resultado r = new Resultado();
			r = dao.consultarById(item.getInstrumento());
			Instrumento instrumento = (Instrumento) r.getEntidade();
			ItemCarrinho i = new ItemCarrinho();
			i.setInstrumento(instrumento);
			i.setExpirado(false);
			i.setIdCarrinho(carrinho.getId());
			i.setQuantidade(item.getQuantidade());
			i.setTotal(instrumento.getValorVenda() * i.getQuantidade());
			i.setId(item.getId());
			itens.add(i);
			total += i.getTotal();

		}
		carrinho.getItens().clear();
		carrinho.setItens(itens);
		carrinho.setValorTotal(total);
		carrinho.setQuantidadeItem(itens.size());
		resultado.clear();
		resultado.setEntidade(carrinho);
		return resultado;
	}

}
