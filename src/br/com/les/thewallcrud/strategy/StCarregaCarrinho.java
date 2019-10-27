package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.CarrinhoDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCarregaCarrinho implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if (resultado.getErro())
			return resultado;
		Cliente cliente = (Cliente) resultado.getEntidade();
		IDAO dao = new CarrinhoDAO();
		Resultado r = dao.consultar(cliente);
		Carrinho carrinho = (Carrinho) r.getEntidade();
		
		dao = new ItemCarrinhoDAO();
		r = dao.consultar(carrinho);
		List<ItemCarrinho> itens = new ArrayList<>();
		carrinho.setItens(itens);
		for(EntidadeDominio e : r.getListEntidade()) {
			carrinho.getItens().add((ItemCarrinho) e);
		}
		cliente.setCarrinho(carrinho);
		resultado.clear();
		resultado.setEntidade(cliente);
		
		return resultado;
	}

}
