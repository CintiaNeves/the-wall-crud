package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaAlteracaoQuantidadeItemCarrinho implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		ItemCarrinho item = (ItemCarrinho) entidade;
		Integer novaQuantidade = item.getQuantidade();
		IDAO dao = new ItemCarrinhoDAO();
		Resultado resultado = dao.consultarById(item);
		
		item = (ItemCarrinho) resultado.getEntidade();
		item.setDiferencaQtd(novaQuantidade - item.getQuantidade());
		item.setQuantidade(novaQuantidade);
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
