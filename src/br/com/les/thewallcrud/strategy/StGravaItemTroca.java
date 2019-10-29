package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemTrocaDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemTroca;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGravaItemTroca implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Troca troca = (Troca) resultado.getEntidade();
		IDAO dao = new InstrumentoDAO();
		
		for(ItemTroca i : troca.getItens()) {
			Resultado r = new Resultado();
			r = dao.consultar(i.getInstrumento());
			Instrumento instrumento = (Instrumento) r.getEntidade();
			i.setInstrumento(instrumento);
			i.setIdTroca(troca.getId());
			dao = new ItemTrocaDAO();
			dao.salvar(i);
		}
		
		return resultado;
	}

}
