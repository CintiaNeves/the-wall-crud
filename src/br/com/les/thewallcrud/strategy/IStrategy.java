package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public interface IStrategy {

	public String processar(EntidadeDominio entidade);
	public Resultado processar(Resultado resultado);
}
