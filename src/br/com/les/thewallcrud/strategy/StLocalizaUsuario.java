package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.UsuarioDAO;
import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StLocalizaUsuario implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Usuario usuario = (Usuario) entidade;
		usuario.setReset(true);
		IDAO dao = new UsuarioDAO();
		Resultado r = dao.consultar(usuario);
		Usuario u = (Usuario) r.getEntidade();
		usuario.setId(u.getId());
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
