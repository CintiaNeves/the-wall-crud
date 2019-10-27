package br.com.les.thewallcrud.strategy;

import java.text.DecimalFormat;

import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StFormataDescontoCupom implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;
		
		if(resultado.getEntidade() instanceof Cupom) {
			Cupom cupom = (Cupom) resultado.getEntidade();
			DecimalFormat df = new DecimalFormat("#,###.00");
			if(cupom.getValor() != null && (!cupom.getValor().trim().equals(""))) {
				Double valor = Double.parseDouble(cupom.getValor());
				String stValor = "R$ ";
				stValor += df.format(valor);
				cupom.setValor(stValor);
			}
			
		}
		return resultado;
	}

}
