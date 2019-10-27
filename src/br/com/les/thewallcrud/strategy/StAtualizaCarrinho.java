package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StAtualizaCarrinho implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		ItemCarrinho item = (ItemCarrinho) resultado.getEntidade();
		Carrinho carrinho = new Carrinho();
		carrinho.setId(item.getIdCarrinho());
		IDAO dao = new ItemCarrinhoDAO();
		Resultado r = new Resultado();
		r = dao.consultar(carrinho);
		List<ItemCarrinho> itens = new ArrayList<>();
		carrinho.setItens(itens);
		for(EntidadeDominio e : r.getListEntidade()) {
			carrinho.getItens().add((ItemCarrinho) e);
		}
		
		dao = new InstrumentoDAO();
		Double total = 0.0;
		
		for(ItemCarrinho i : carrinho.getItens()) {
			r = dao.consultarById(item.getInstrumento());
			Instrumento instrumento = (Instrumento) r.getEntidade();
			i.setInstrumento(instrumento);
			i.setTotal(i.getInstrumento().getValorVenda() * i.getQuantidade());
			total += i.getTotal();
		}
		carrinho.setQuantidadeItem(carrinho.getItens().size());
		carrinho.setValorTotal(total);		
		resultado.clear();
		resultado.setEntidade(carrinho);
		
		List<EntidadeDominio> entidades = new ArrayList<>();
		for(ItemCarrinho ic : itens) {
			entidades.add((EntidadeDominio) ic);
		}
		resultado.setMapEntidade("ITENS", entidades);
		return resultado;
	}

}
