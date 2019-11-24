package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.EstoqueDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemTrocaDAO;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.dominio.ItemTroca;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StDevolveItemTrocado implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Troca troca = (Troca) entidade;
		IDAO dao = new ItemTrocaDAO();
		Integer quantidade;
		Resultado resultado = dao.consultarById(troca);
		dao = new EstoqueDAO();
		for(EntidadeDominio e : resultado.getListEntidade()) {
			ItemTroca i = (ItemTroca) e;
			quantidade = i.getQuantidade();
			ItemEstoque itemEstoque = new ItemEstoque();
			itemEstoque.setInstrumento(i.getInstrumento());
			resultado = dao.consultar(itemEstoque);
			itemEstoque = (ItemEstoque) resultado.getEntidade();
			itemEstoque.setQuantidade(quantidade += itemEstoque.getQuantidade());
			dao.alterar(itemEstoque);
		}
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
