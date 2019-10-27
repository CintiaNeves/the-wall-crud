package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class ClienteDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Cliente cliente = (Cliente) entidade;

		Resultado resultado = new Resultado();
		List<EntidadeDominio> clientes = new ArrayList<>();

		String sql = "SELECT * FROM CLIENTE ";

		boolean contemCodigo = cliente != null && cliente.getCodigo() != null ? true : false;
		boolean contemUsuario = cliente.getUsuario() != null && cliente.getUsuario().getId() != null ? true : false;

		if (contemCodigo)
			sql += "WHERE CODIGO = ? ";
		else if (contemUsuario)
			sql += "WHERE ID_USUARIO = ? ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			if (contemCodigo)
				stmt.setString(1, cliente.getCodigo());
			else if (contemUsuario)
				stmt.setLong(1, cliente.getUsuario().getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				Genero g = new Genero();
				Usuario u = new Usuario();
				c.setGenero(g);
				c.setUsuario(u);
				c.setId(rs.getLong("ID"));
				c.setAtivo(rs.getBoolean("ATIVO"));
				c.setNome(rs.getString("NOME"));
				c.setCpf(rs.getString("CPF"));
				c.setEmail(rs.getString("EMAIL"));
				c.setCodigo(rs.getString("CODIGO"));
				c.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
				c.setPontuacao(rs.getInt("PONTUACAO"));
				c.getUsuario().setId(rs.getLong("ID_USUARIO"));
				c.getGenero().setId(rs.getLong("ID_GENERO"));

				clientes.add(c);
			}
			rs.close();
			resultado.setSucesso("");
			if (clientes.size() > 0) {
				resultado.setListEntidade(clientes);
			} else {
				resultado.setEntidade(cliente);
			}

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

		Cliente cliente = (Cliente) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO CLIENTE (ATIVO, NOME, CPF, EMAIL, CODIGO, DATA_NASCIMENTO, PONTUACAO, ID_GENERO, ID_USUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setBoolean(1, cliente.getAtivo());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getCpf());
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getCodigo());
			stmt.setString(6, cliente.getDataNascimento());
			stmt.setInt(7, cliente.getPontuacao());
			stmt.setLong(8, cliente.getGenero().getId());
			stmt.setLong(9, cliente.getUsuario().getId());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				cliente.setId(rs.getLong(1));
			stmt.close();
			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(cliente);
		} catch (Exception e) {
			resultado.setErro("Inclusão não realizada.");
			e.printStackTrace();
		}
		return resultado;

	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {

		Cliente cliente = (Cliente) entidade;
		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM CLIENTE WHERE ID = ? ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, cliente.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Genero genero = new Genero();
				Usuario usuario = new Usuario();
				cliente.setGenero(genero);
				cliente.setUsuario(usuario);
				cliente.setId(rs.getLong("ID"));
				cliente.setAtivo(rs.getBoolean("ATIVO"));
				cliente.setNome(rs.getString("NOME"));
				cliente.setCpf(rs.getString("CPF"));
				cliente.setEmail(rs.getString("EMAIL"));
				cliente.setCodigo(rs.getString("CODIGO"));
				cliente.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
				cliente.setPontuacao(rs.getInt("PONTUACAO"));
				cliente.getGenero().setId(rs.getLong("ID_GENERO"));
				cliente.getUsuario().setId(rs.getLong("ID_USUARIO"));
			}

			rs.close();
			resultado.setEntidade(cliente);
			resultado.setSucesso("");
		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;

	}
}
