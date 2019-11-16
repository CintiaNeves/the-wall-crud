package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaEmail implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Usuario usuario = (Usuario) entidade;
		String email = usuario.getNome();
		boolean achouArroba = false;
		boolean achouPonto = false;
		for (char c : email.toCharArray()) {
	         if (c == '@') {
	        	 achouArroba = true;
	         } else if (c == '.') {
	        	 achouPonto = true;
	         }
	    }
		if(!(achouArroba && achouPonto)) {
			return "Por favor, digite um e-mail no formato válido: exemplo@email.com\n";
		}
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
