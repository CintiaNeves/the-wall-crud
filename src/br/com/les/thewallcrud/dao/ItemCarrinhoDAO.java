package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class ItemCarrinhoDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {

		ItemCarrinho item = (ItemCarrinho) entidade;
		Resultado resultado = new Resultado();

		LocalDateTime now = LocalDateTime.now();
		String data = now.toString();

		String sql = "UPDATE ITEM_CARRINHO SET QUANTIDADE = ?, EXPIRADO = ?, DATA = ? WHERE ID = ? ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, item.getQuantidade());
			stmt.setBoolean(2, item.getExpirado());
			stmt.setString(3, data);
			stmt.setLong(4, item.getId());

			stmt.execute();

			resultado.setSucesso("Registro Alterado com sucesso!");
			resultado.setEntidade(item);
		} catch (Exception e) {
			resultado.setErro("Alteração não realizada.\n");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Carrinho carrinho = null;
		ItemCarrinho itemCarrinho = null;
		Long idCarrinho = null;

		if (entidade instanceof ItemCarrinho) {
			itemCarrinho = (ItemCarrinho) entidade;
			if (itemCarrinho.getIdCarrinho() != null)
				idCarrinho = itemCarrinho.getIdCarrinho();
		} else if (entidade instanceof Carrinho) {
			carrinho = (Carrinho) entidade;
			if (carrinho.getId() != null)
				idCarrinho = carrinho.getId();
		}

		Resultado resultado = new Resultado();
		List<EntidadeDominio> itens = new ArrayList<>();

		String sql = "SELECT * FROM ITEM_CARRINHO WHERE ";

		if (idCarrinho == null) {
			sql += "EXPIRADO = 0";
		} else {
			sql += "ID_CARRINHO = ? AND EXPIRADO = 0";
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			if (idCarrinho != null)
				stmt.setLong(1, idCarrinho);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				ItemCarrinho item = new ItemCarrinho();
				Instrumento i = new Instrumento();
				item.setInstrumento(i);
				item.setId(rs.getLong("ID"));
				item.setExpirado(rs.getBoolean("EXPIRADO"));
				item.getInstrumento().setId(rs.getLong("ID_INSTRUMENTO"));
				item.setQuantidade(rs.getInt("QUANTIDADE"));
				item.setIdCarrinho(rs.getLong("ID_CARRINHO"));
				item.setData(rs.getString("DATA"));
				itens.add(item);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(itens);

		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {

		ItemCarrinho item = (ItemCarrinho) entidade;
		Resultado resultado = new Resultado();

		String sql = "UPDATE ITEM_CARRINHO SET EXPIRADO = 1 WHERE ID = ? ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, item.getId());
			stmt.execute();
			resultado.setSucesso("Registro Alterado com sucesso!");
			resultado.setEntidade(item);
		} catch (Exception e) {
			resultado.setErro("Alteração não realizada.\n");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {

		ItemCarrinho item = (ItemCarrinho) entidade;
		Resultado resultado = new Resultado();

		if (item.getAlterado()) {
			resultado.setEntidade(item);
			resultado.setSucesso("");
			return resultado;
		}

		String sql = "INSERT INTO ITEM_CARRINHO (QUANTIDADE, EXPIRADO, ID_INSTRUMENTO, ID_CARRINHO, DATA) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setInt(1, item.getQuantidade());
			stmt.setBoolean(2, item.getExpirado());
			stmt.setLong(3, item.getInstrumento().getId());
			stmt.setLong(4, item.getIdCarrinho());
			stmt.setString(5, item.getData());

			stmt.execute();

			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(item);
		} catch (Exception e) {
			e.printStackTrace();
			resultado.setErro("Inclusão não realizada.");
		}

		return resultado;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {

		ItemCarrinho item = (ItemCarrinho) entidade;
		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM ITEM_CARRINHO WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, item.getId());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Instrumento i = new Instrumento();
				item.setInstrumento(i);
				item.setExpirado(rs.getBoolean("EXPIRADO"));
				item.getInstrumento().setId(rs.getLong("ID_INSTRUMENTO"));
				item.setQuantidade(rs.getInt("QUANTIDADE"));
				item.setIdCarrinho(rs.getLong("ID_CARRINHO"));
				item.setData(rs.getString("DATA"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(item);

		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

}
