package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Ocorrencia;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaOcorrencia implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		StringBuilder mensagem = new StringBuilder();
		Ocorrencia ocorrencia = (Ocorrencia) entidade;
		
		if(ocorrencia.getTipo().getId() == null) {
			mensagem.append("Obrigatório selecionar uma categoria!\n");
		}
		if(ocorrencia.getJustificativa() == null || ocorrencia.getJustificativa().trim().equals("")) {
			mensagem.append("Justificativa é um campo obrigatório!\n");
		}
		
		return mensagem.toString();
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
