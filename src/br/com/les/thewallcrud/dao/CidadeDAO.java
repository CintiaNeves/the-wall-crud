package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class CidadeDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		List<EntidadeDominio> cidades = new ArrayList<>();

		String sql = "SELECT * FROM CIDADE";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cidade cidade = new Cidade();
				cidade.setId(rs.getLong("ID"));
				cidade.setNome(rs.getString("NOME"));
				cidades.add(cidade);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(cidades);
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
		Cidade cidade = new Cidade();
		String sql = "SELECT * FROM CIDADE WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, endereco.getPais().getEstado().getCidade().getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cidade.setId(rs.getLong("ID"));
				cidade.setNome(rs.getString("NOME"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(cidade);

		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

}
