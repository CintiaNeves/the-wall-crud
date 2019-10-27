package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.EstoqueDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StAdicionaItemEstoque implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if (resultado.getErro())
			return resultado;
		
		Instrumento instrumento = (Instrumento) resultado.getEntidade();
		if(instrumento.getId() != null) {
			IDAO dao = new EstoqueDAO();
			dao.salvar(instrumento);
		}
		
		
		return resultado;
	}

}
