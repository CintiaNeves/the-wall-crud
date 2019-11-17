package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaCarrinhoLogado implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		ItemCarrinho item = (ItemCarrinho) entidade;
		StringBuilder mensagem = new StringBuilder();
		
		if(item.getIdCarrinho() == null) {
			mensagem.append("Você não está logado!Faça login para adicionar itens ao carrinho.\n");
		}
		return mensagem.toString();
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
