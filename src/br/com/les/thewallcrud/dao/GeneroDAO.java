package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class GeneroDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		List<EntidadeDominio> generos = new ArrayList<>();

		String sql = "SELECT * FROM GENERO";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Genero genero = new Genero();
				genero.setId(rs.getLong("ID"));
				genero.setDescricao(rs.getString("DESCRICAO"));
				generos.add(genero);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(generos);
		} catch (SQLException e) {
			resultado.setErro("Erro de consulta");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		
		Genero genero = (Genero) entidade;
		Resultado resultado = new Resultado();
		
		String sql = "SELECT * FROM GENERO WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, genero.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				genero.setId(rs.getLong("ID"));
				genero.setDescricao(rs.getString("DESCRICAO"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(genero);

		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

}
