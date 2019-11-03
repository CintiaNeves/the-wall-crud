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
		List<ItemCarrinho> itens = new ArrayList<>();
		Carrinho carrinho = new Carrinho();
		carrinho.setId(item.getIdCarrinho());
		Double total = 0.0;
		IDAO dao = new ItemCarrinhoDAO();
		Resultado r = new Resultado();
		r = dao.consultar(carrinho);

		for (EntidadeDominio e : r.getListEntidade()) {
			ItemCarrinho i = (ItemCarrinho) e;
			Instrumento instrumento = new Instrumento();
			instrumento.setId(i.getInstrumento().getId());
			dao = new InstrumentoDAO();
			Resultado res = dao.consultarById(instrumento);
			i.setInstrumento((Instrumento) res.getEntidade());
			i.setTotal(i.getInstrumento().getValorVenda() * i.getQuantidade());
			total += i.getTotal();
			itens.add(i);
		}
		carrinho.setItens(itens);
		carrinho.setQuantidadeItem(carrinho.getItens().size());
		carrinho.setValorTotal(total);
		resultado.clear();
		resultado.setEntidade(carrinho);

		List<EntidadeDominio> entidades = new ArrayList<>();
		for (ItemCarrinho ic : itens) {
			entidades.add((EntidadeDominio) ic);
		}
		resultado.setMapEntidade("ITENS", entidades);

		return resultado;
	}

}
