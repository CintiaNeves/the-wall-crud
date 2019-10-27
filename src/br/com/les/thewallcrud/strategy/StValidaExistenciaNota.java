package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.EntradaDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaExistenciaNota implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;
		
		Entrada entrada = (Entrada) resultado.getEntidade();
		IDAO dao = new EntradaDAO(); 
		Resultado r = dao.consultar(entrada);
		Entrada e = (Entrada) r.getEntidade();
		
		if(e.getId() != null) {
			StFormataData st = new StFormataData();
			st.processar(entrada);
			resultado.setErro("Problema! Nota fiscal " +  e.getNota() 
			+ " do fornecedor "+ e.getFornecedor().getRazaoSocial() 
			+" já deu entrada em " + e.getData() + ".");
		}
		
		return resultado;
	}

}
