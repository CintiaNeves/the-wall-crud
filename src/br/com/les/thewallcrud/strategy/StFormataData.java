package br.com.les.thewallcrud.strategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StFormataData implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Entrada entrada = (Entrada) entidade;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date data = null;
		try {
			data = formato.parse(entrada.getData());
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		formato.applyPattern("dd/MM/yyyy");
		entrada.setData(formato.format(data));
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
