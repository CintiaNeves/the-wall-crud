package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;

import br.com.les.thewallcrud.dominio.ItemPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class ItemPedidoDAO extends AbstractDao{

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
		// TODO Auto-generated method stub
		return null;
	}

}
