package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.UsuarioDAO;
import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewUsuario implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {

		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;
		
		Usuario usuario = (Usuario) resultado.getEntidade();
		IDAO dao = new UsuarioDAO();
		Resultado r = dao.consultar(usuario);
		return r;
	}
	

}
