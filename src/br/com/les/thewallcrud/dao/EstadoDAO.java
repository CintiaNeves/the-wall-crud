package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class EstadoDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		List<EntidadeDominio> estados = new ArrayList<>();

		String sql = "SELECT * FROM ESTADO";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Estado estado = new Estado();
				estado.setId(rs.getLong("ID"));
				estado.setNome(rs.getString("NOME"));
				estados.add(estado);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(estados);
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
		
		Endereco endereco = (Endereco) entidade;
		Resultado resultado = new Resultado();
		Estado estado = new Estado();

		String sql = "SELECT * FROM ESTADO WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, endereco.getPais().getEstado().getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				estado.setId(rs.getLong("ID"));
				estado.setNome(rs.getString("NOME"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(estado);

		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

}
