package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class CartaoDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Cliente cliente = (Cliente) entidade;

		Resultado resultado = new Resultado();
		List<EntidadeDominio> cartoes = new ArrayList<>();

		String sql = "SELECT * FROM CARTAO WHERE ID_CLIENTE = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, cliente.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cartao c = new Cartao();
				Bandeira bandeira = new Bandeira();
				c.setBandeira(bandeira);
				c.setId(rs.getLong("ID"));
				c.setNumero(rs.getString("NUMERO"));
				c.setNomeImpresso(rs.getString("NOME"));
				c.setCodSeguranca(rs.getString("COD_SEGURANCA"));
				c.getBandeira().setId(rs.getLong("ID_BANDEIRA"));
				cartoes.add(c);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(cartoes);

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
		List<Cartao> cartoes = cliente.getCartoes();

		String sql = "INSERT INTO CARTAO (NUMERO, NOME, COD_SEGURANCA, ID_BANDEIRA, ID_CLIENTE) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			for (Cartao c : cartoes) {
				stmt.setString(1, c.getNumero());
				stmt.setString(2, c.getNomeImpresso());
				stmt.setString(3, c.getCodSeguranca());
				stmt.setLong(4, c.getBandeira().getId());
				stmt.setLong(5, cliente.getId());
				stmt.execute();
			}

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
		// TODO Auto-generated method stub
		return null;
	}

}
