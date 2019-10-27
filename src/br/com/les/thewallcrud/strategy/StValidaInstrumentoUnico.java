package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaInstrumentoUnico implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {

		Instrumento instrumento = (Instrumento) resultado.getEntidade();
		if(instrumento.getCadastro() == null && instrumento.getEntrada() == null)
			return resultado;
		if (instrumento.getId() != null)
			resultado.setErro("Problema! Instrumento já cadastrado CÓDIGO: " + instrumento.getCodigo() + ".");

		return resultado;
	}

}
