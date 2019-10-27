package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaExistenciaInstrumento implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		IDAO dao = new InstrumentoDAO();
		Instrumento i = (Instrumento) entidade;
		Resultado r = dao.consultar(i);
		Instrumento instrumento = (Instrumento) r.getEntidade();
		instrumento.setDescricao(i.getDescricao());
		
		if(instrumento.getId() == null) {
			return "Problema! Nenhum instrumento cadastrado com o código informado.";
		}
				

		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;
	 
		Instrumento instrumento = (Instrumento) resultado.getEntidade();
		if(instrumento.getCadastro() == null && instrumento.getEntrada() == null)
			return resultado;
		if(!instrumento.getCadastro()) {
			if(instrumento.getId() == null) {
				resultado.setErro("Problema! Nenhum instrumento cadastrado com o código informado.");
			}
		}
		
		return resultado;
	}

}
