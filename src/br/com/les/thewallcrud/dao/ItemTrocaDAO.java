package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemTroca;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class ItemTrocaDAO extends AbstractDao {

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
		
		ItemTroca item = (ItemTroca) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO ITEM_TROCA (QUANTIDADE, ID_INSTRUMENTO, ID_TROCA, ENTRADA_OK) VALUES (?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setInt(1, item.getQuantidade());
			stmt.setLong(2, item.getInstrumento().getId());
			stmt.setLong(3, item.getIdTroca());
			stmt.setBoolean(4, item.getEntradaOk());
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
		
		Troca troca = (Troca) entidade;
		Resultado resultado = new Resultado();
		List<EntidadeDominio> itens = new ArrayList<>();

		String sql = "SELECT * FROM ITEM_TROCA WHERE ID_TROCA = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, troca.getId());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ItemTroca item = new ItemTroca();
				Instrumento instrumento = new Instrumento();
				item.setInstrumento(instrumento);
				item.setId(rs.getLong("ID"));
				item.setQuantidade(rs.getInt("QUANTIDADE"));
				item.getInstrumento().setId(rs.getLong("ID_INSTRUMENTO"));
				item.setIdTroca(rs.getLong("ID_TROCA"));
				item.setEntradaOk(rs.getBoolean("ENTRADA_OK"));
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
