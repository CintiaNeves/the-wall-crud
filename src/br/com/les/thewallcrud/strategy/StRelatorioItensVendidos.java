package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.RelatorioDAO;
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
		RelatorioDAO dao = new RelatorioDAO();
		return dao.consultar(resultado.getEntidade());
	}

}
