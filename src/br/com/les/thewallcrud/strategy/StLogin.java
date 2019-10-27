package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StLogin implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;
		
		Usuario usuario = (Usuario) resultado.getEntidade();
		if(usuario.getId() == null){
			resultado.setErro("Problema! Usuário ou senha inválidos");
		}
		return resultado;
	}

}
