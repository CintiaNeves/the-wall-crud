package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class UsuarioDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Usuario usuario = (Usuario) entidade;
		Resultado resultado = new Resultado();
		Boolean possuiNome = usuario.getNome() != null ? true : false;
		Boolean possuiSenha = usuario.getSenha() != null ? true : false;
		
		String sql = null;
		if(possuiNome && possuiSenha) {
			sql = "SELECT * FROM USUARIO WHERE NOME = ? AND SENHA = ?";
		}else if(possuiNome) {
			sql = "SELECT * FROM USUARIO WHERE NOME = ?";
		}
		
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(possuiNome && possuiSenha) {
				stmt.setString(1, usuario.getNome());
				stmt.setString(2, usuario.getSenha());
			}else if(possuiNome) {
				stmt.setString(1, usuario.getNome());
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				usuario.setId(rs.getLong("ID"));
				usuario.setNome(rs.getString("NOME"));
				usuario.setSenha(rs.getString("SENHA"));
				usuario.setAdministrador(rs.getBoolean("ADMINISTRADOR"));
			}
			rs.close();
			resultado.setEntidade(usuario);
			resultado.setSucesso("");
		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Usuario usuario = (Usuario) entidade;
		Resultado resultado = new Resultado();
		String sql = "INSERT INTO USUARIO (NOME, SENHA, ADMINISTRADOR) VALUES (?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSenha());
			stmt.setBoolean(3, usuario.isAdministrador());
			
			stmt.execute();
			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(usuario);
		} catch (Exception e) {
			resultado.setErro("Inclusão não realizada.");
			e.printStackTrace();
		}
		return resultado;

	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
