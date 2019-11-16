package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.JavaMail;
import br.com.les.thewallcrud.util.Resultado;

public class StEnviaEmail implements IStrategy {

	JavaMail javaMail = new JavaMail();

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		Usuario usuario = (Usuario) resultado.getEntidade();
		if (usuario.getReset()) {
			if (usuario.getId() != null) {
				javaMail.enviaEmail(resultado);
			} else {
				resultado.setErro("Nenhuma conta econtrada, verifique o e-mail informado ou selecione criar conta.");
			}
		}
		return resultado;
	}

}
