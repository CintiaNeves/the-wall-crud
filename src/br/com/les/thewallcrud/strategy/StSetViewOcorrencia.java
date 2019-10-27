package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.Ocorrencia;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewOcorrencia implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		return null;
		
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Ocorrencia ocorrencia = (Ocorrencia) resultado.getEntidade();
		StSetViewInstrumento stViewInstrumento = new StSetViewInstrumento();
		Instrumento instrumento = ocorrencia.getInstrumento();
		InstrumentoDAO dao = new InstrumentoDAO();
		Resultado r = dao.consultarById(instrumento);
		r = stViewInstrumento.processar(r);
		
		if(!r.getErro()) {
			ocorrencia.setInstrumento((Instrumento) r.getEntidade());
		}
		
		return resultado;
	}

}
