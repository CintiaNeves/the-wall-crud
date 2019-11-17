package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemPedido;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class ItemPedidoDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {

		ItemPedido item = (ItemPedido) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO ITEM_PEDIDO (QUANTIDADE, ID_INSTRUMENTO, ID_PEDIDO) VALUES (?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setDouble(1, item.getQuantidade());
			stmt.setLong(2, item.getInstrumento().getId());
			stmt.setLong(3, item.getIdPedido());
			stmt.execute();
			resultado.setSucesso("Entrada Realizada com Sucesso.");
			resultado.setEntidade(item);
		} catch (Exception e) {
			resultado.setErro("Inclusão não realizada.");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {

		Pedido pedido = (Pedido) entidade;
		Resultado resultado = new Resultado();
		List<EntidadeDominio> itens = new ArrayList<>();

		String sql = "SELECT * FROM ITEM_PEDIDO WHERE ID_PEDIDO = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, pedido.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ItemPedido item = new ItemPedido();
				Instrumento instrumento = new Instrumento();
				item.setInstrumento(instrumento);
				item.setId(rs.getLong("ID"));
				item.setQuantidade(rs.getInt("QUANTIDADE"));
				item.getInstrumento().setId(rs.getLong("ID_INSTRUMENTO"));
				item.setIdPedido(rs.getLong("ID_PEDIDO"));
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

}
