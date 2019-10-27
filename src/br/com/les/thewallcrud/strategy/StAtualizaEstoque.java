package br.com.les.thewallcrud.strategy;

import java.util.List;

import br.com.les.thewallcrud.dao.EstoqueDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StAtualizaEstoque implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;

		Entrada entrada = (Entrada) resultado.getEntidade();
		List<ItemEstoque> itens = entrada.getItens();
		IDAO dao = new EstoqueDAO();
		Resultado r = new Resultado();
		Integer saldo = 0;
		
		for(ItemEstoque i : itens) {
			r = dao.consultar(i);
			ItemEstoque ie = (ItemEstoque) r.getEntidade();
			saldo = ie.getQuantidade();
			i.setQuantidade(saldo + i.getQuantidade()); 
			dao.alterar(i);
		}
		return resultado;
		
	}

}
