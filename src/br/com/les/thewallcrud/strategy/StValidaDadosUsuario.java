package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaDadosUsuario implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Usuario usuario = (Usuario) entidade;
		StringBuilder mensagem = new StringBuilder();
		if(usuario.getNome().trim().length() == 0) {
			mensagem.append("O campo e-mail nãoo pode estar vazio.\n");
		}
		if(usuario.getSenha().trim().length() == 0) {
			mensagem.append("O campo senha não pode estar vazio.\n");
		}
		if(usuario.getConfSenha().trim().length() == 0) {
			mensagem.append("o campo de confirmação de senha não pode estar vazio.\n");
		}else if(!usuario.getSenha().equals(usuario.getConfSenha())){
			mensagem.append("As senhas nãoo conferem.\n");
		}
		if(usuario.getSenha().trim().length() < 8) {
			mensagem.append("A senha deve conter pelo menos 8 caracteres.\n");
		}
		usuario.setConfSenha("");
		return mensagem.toString();
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
