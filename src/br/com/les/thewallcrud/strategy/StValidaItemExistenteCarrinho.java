package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaItemExistenteCarrinho implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		ItemCarrinho item = (ItemCarrinho) entidade;
		IDAO dao = new ItemCarrinhoDAO();
		Integer quantidade = 0;
		Resultado resultado = new Resultado();
		resultado = dao.consultar(item);
		
		if(resultado.getListEntidade().size() > 0 ) {
			for(EntidadeDominio e : resultado.getListEntidade()) {
				ItemCarrinho i = (ItemCarrinho) e;
				if(i.getInstrumento().getId().equals(item.getInstrumento().getId())) {
					quantidade = item.getQuantidade() + i.getQuantidade();
					i.setQuantidade(quantidade);
					dao.alterar(i);	
					item.setAlterado(true);
					return null;
				}
			}	
		}		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
