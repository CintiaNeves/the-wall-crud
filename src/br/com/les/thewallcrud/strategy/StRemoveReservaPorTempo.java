package br.com.les.thewallcrud.strategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.EstoqueDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StRemoveReservaPorTempo implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		LocalDateTime now = LocalDateTime.now();
		String data = now.toString();
		String dados[]= data.split("T");
		data = dados[0];
		Carrinho carrinho = (Carrinho) resultado.getEntidade();
		IDAO dao = new ItemCarrinhoDAO();
		Resultado r = new Resultado();
		r = dao.consultar(carrinho);
		List<ItemCarrinho> itens = new ArrayList<>();
		carrinho.setItens(itens);
		IDAO daoEstoque = new EstoqueDAO();
		Integer qtdRemover = 0;
		Integer qtdReservada = 0;
		for (EntidadeDominio e : r.getListEntidade()) {
			ItemCarrinho item = (ItemCarrinho) e;
			if(!item.getData().equals(data)) {
				item.setExpirado(true);
				ItemEstoque ie = new ItemEstoque();
				Instrumento instrumento = new Instrumento();
				instrumento.setId(item.getInstrumento().getId());
				ie.setInstrumento(instrumento);	
				Resultado res = daoEstoque.consultar(ie);
				ie = (ItemEstoque) res.getEntidade();
				qtdRemover = item.getQuantidade();
				qtdReservada = ie.getQuantidadeReservada();
				if(qtdReservada >= qtdRemover) {
					ie.setQuantidadeReservada(qtdReservada - qtdRemover);
					daoEstoque.alterar(ie);
				}
			}
			dao.alterar(item);
			
			carrinho.getItens().add((ItemCarrinho) e);
		}
		
		
		return resultado;
	}

}
