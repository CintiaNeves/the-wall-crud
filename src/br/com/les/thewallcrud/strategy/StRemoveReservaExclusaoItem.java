package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.EstoqueDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StRemoveReservaExclusaoItem implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		ItemCarrinho ic = (ItemCarrinho) resultado.getEntidade();
		IDAO dao = new EstoqueDAO();
		ItemEstoque ie = new ItemEstoque();
		Instrumento instrumento = new Instrumento();
		instrumento.setId(ic.getInstrumento().getId());
		ie.setInstrumento(instrumento);	
		Resultado res = dao.consultar(ie);
		ie = (ItemEstoque) res.getEntidade();
		Integer qtdRemover = ic.getQuantidade();
		Integer qtdReservada = ie.getQuantidadeReservada();
		if(qtdReservada >= qtdRemover) {
			ie.setQuantidadeReservada(qtdReservada - qtdRemover);
			dao.alterar(ie);
		}
		return resultado;
	}

}
