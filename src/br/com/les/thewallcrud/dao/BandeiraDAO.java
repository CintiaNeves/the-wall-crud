package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class BandeiraDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Resultado resultado = new Resultado();
		List<EntidadeDominio> bandeiras = new ArrayList<>();

		String sql = "SELECT * FROM BANDEIRA";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Bandeira b = new Bandeira();
				b.setId(rs.getLong("ID"));
				b.setDescricao(rs.getString("DESCRICAO"));
				bandeiras.add(b);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(bandeiras);
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

		Cartao cartao = (Cartao) entidade;
		Resultado resultado = new Resultado();
		Bandeira bandeira = new Bandeira();

		String sql = "SELECT * FROM BANDEIRA WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, cartao.getBandeira().getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bandeira.setId(rs.getLong("ID"));
				bandeira.setDescricao(rs.getString("DESCRICAO"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(bandeira);

		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

}
