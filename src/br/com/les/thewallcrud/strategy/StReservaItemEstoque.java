package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.EstoqueDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StReservaItemEstoque implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {

		if (resultado.getErro())
			return resultado;
		ItemCarrinho item = (ItemCarrinho) resultado.getEntidade();
		IDAO dao = new EstoqueDAO();
		ItemEstoque ie = new ItemEstoque();
		Instrumento instrumento = new Instrumento();
		instrumento.setId(item.getInstrumento().getId());
		ie.setInstrumento(instrumento);
		Resultado r = dao.consultar(ie);
		ie = (ItemEstoque) r.getEntidade();
		Integer qtdReservada = ie.getQuantidadeReservada();
		Integer reserva = item.getQuantidade();
		ie.setQuantidadeReservada(qtdReservada + reserva);
		dao.alterar(ie);
		return resultado;
	}

}
