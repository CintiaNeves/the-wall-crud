package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class EntradaDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Entrada entrada = (Entrada) entidade;

		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM ENTRADA  ";

		boolean contemNota = entrada != null && entrada.getNota() != null;
		boolean contemFornecedor = entrada != null && entrada.getFornecedor().getId() != null;

		if (contemNota && contemFornecedor) {
			sql += "WHERE NOTA = ? AND ID_FORNECEDOR = ? ";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {

				stmt.setString(1, entrada.getNota());
				stmt.setLong(2, entrada.getFornecedor().getId());

				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					entrada.setId(rs.getLong("ID"));
					entrada.getFornecedor().setId(rs.getLong("ID_FORNECEDOR"));
					entrada.setNota(rs.getString("NOTA"));
					entrada.setData(rs.getString("DATA"));
				}
				rs.close();
				resultado.setSucesso("");
				resultado.setEntidade(entrada);
			} catch (SQLException e) {
				resultado.setErro("Consulta não realizada.\n");
				e.printStackTrace();
			}

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

		Entrada entrada = (Entrada) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO ENTRADA (ID_FORNECEDOR, NOTA, DATA) VALUES (?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setLong(1, entrada.getFornecedor().getId());
			stmt.setString(2, entrada.getNota());
			stmt.setString(3, entrada.getData());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				entrada.setId(rs.getLong(1));

			stmt.close();

			resultado.setSucesso("Entrada da nota gravada com sucesso.");
			resultado.setEntidade(entrada);
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
