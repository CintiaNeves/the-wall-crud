package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.UsuarioDAO;
import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaExistenciaUsuario implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Usuario usuario = (Usuario) entidade;
		IDAO dao = new UsuarioDAO();
		Usuario uWork = new Usuario();
		uWork.setNome(usuario.getNome());
		Resultado resultado = dao.consultar(uWork);
		uWork = (Usuario) resultado.getEntidade();
		if(uWork.getId() != null) {
			return "E-mail já cadastrado!\n";
		}
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
