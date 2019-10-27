package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaSenhaForte implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Usuario usuario = (Usuario) entidade;
		StringBuilder mensagem = new StringBuilder();
		String senha = usuario.getSenha();
		boolean achouNumero = false;
	    boolean achouMaiuscula = false;
	    boolean achouMinuscula = false;
	    boolean achouSimbolo = false;
	    
	    for (char c : senha.toCharArray()) {
	         if (c >= '0' && c <= '9') {
	             achouNumero = true;
	         } else if (c >= 'A' && c <= 'Z') {
	             achouMaiuscula = true;
	         } else if (c >= 'a' && c <= 'z') {
	             achouMinuscula = true;
	         } else {
	             achouSimbolo = true;
	         }
	    }
	    if(!achouNumero) {
	    	mensagem.append("Senha deve conter pelo menos 1 caractere númerico.\n");
	    }
	    if(!achouMaiuscula) {
	    	mensagem.append("Senha deve conter pelo menos uma letra maiúscula.\n");
	    }
	    if(!achouMinuscula) {	
	    	mensagem.append("Senha deve conter pelo menos uma letra minúscula.\n");
	    }
	    if(!achouSimbolo) {
	    	mensagem.append("Senha deve conter pelo menos um caractere especial.\n");
	    }
		return mensagem.toString();
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
