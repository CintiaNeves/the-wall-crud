package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StRelatorioItensVendidos implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		InstrumentoDAO dao = new InstrumentoDAO();
		return dao.relatorio(resultado);
	}

}
