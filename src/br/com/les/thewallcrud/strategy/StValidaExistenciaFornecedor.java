package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Fornecedor;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaExistenciaFornecedor implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;
		
		Fornecedor fornecedor = (Fornecedor) resultado.getEntidade();
		
		if(fornecedor.getId() == null)
			resultado.setErro("Problema! Nenhum fornecedor encontrado com o CNPJ informado."); 
		return resultado;
		
	}

}
