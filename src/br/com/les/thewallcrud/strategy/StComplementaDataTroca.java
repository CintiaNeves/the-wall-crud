package br.com.les.thewallcrud.strategy;

import java.time.LocalDateTime;

import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StComplementaDataTroca implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Troca troca = (Troca) entidade;
		LocalDateTime now = LocalDateTime.now();
		String data = now.toString();
		troca.setData(data);
		troca.getStatus().setId((long) 6);
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
