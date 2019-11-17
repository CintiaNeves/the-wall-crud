package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class PaisDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		List<EntidadeDominio> paises = new ArrayList<>();

		String sql = "SELECT * FROM PAIS";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pais pais = new Pais();
				pais.setId(rs.getLong("ID"));
				pais.setNome(rs.getString("NOME"));
				paises.add(pais);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(paises);
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
		Pais pais = new Pais();
		

		String sql = "SELECT * FROM PAIS WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, endereco.getPais().getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pais.setId(rs.getLong("ID"));
				pais.setNome(rs.getString("NOME"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(pais);

		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

}
