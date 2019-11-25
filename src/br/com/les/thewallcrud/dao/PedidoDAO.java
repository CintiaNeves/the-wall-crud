package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.FormaPagamento;
import br.com.les.thewallcrud.dominio.Frete;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class PedidoDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {

		Pedido pedido = (Pedido) entidade;
		Resultado resultado = new Resultado();
		
		if(pedido.getId() == null) {
			resultado.setEntidade(pedido);
			return resultado;
		}
		
		String sql = "UPDATE PEDIDO SET ID_STATUS = ? WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, pedido.getStatus().getId());
			stmt.setLong(2, pedido.getId());
			stmt.execute();
			resultado.setSucesso("Status do pedido atualizado!");
			resultado.setEntidade(pedido);
		} catch (Exception e) {
			resultado.setErro("Status não atualizao, refaça operacao.");
			e.printStackTrace();
		}

		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Pedido pedido = (Pedido) entidade;
		Resultado resultado = new Resultado();

		List<EntidadeDominio> pedidos = new ArrayList<>();

		String sql = "SELECT * FROM PEDIDO";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pedido p = new Pedido();
				Frete frete = new Frete();
				Cliente cliente = new Cliente();
				StatusPedido status = new StatusPedido();
				List<FormaPagamento> pagamentos = new ArrayList<>();
				FormaPagamento f = new FormaPagamento();
				pagamentos.add(f);
				p.setFormasPagamento(pagamentos);
				p.setFrete(frete);
				p.setCliente(cliente);
				p.setStatus(status);
				p.setId(rs.getLong("ID"));
				p.getFrete().setValorFrete(rs.getDouble("FRETE"));
				p.getCliente().setId(rs.getLong("ID_CLIENTE"));
				p.setData(rs.getString("DATA"));
				p.setTotal(rs.getDouble("VALOR"));
				p.setDesconto(rs.getDouble("DESCONTO"));
				p.setNumero(rs.getString("NUMERO"));
				p.setObservacao(rs.getString("OBSERVACAO"));
				p.getStatus().setId(rs.getLong("ID_STATUS"));
				pedidos.add(p);
			}
			rs.close();
			resultado.setSucesso("");
			if (pedidos.size() > 0) {
				resultado.setListEntidade(pedidos);
			} else {
				resultado.setEntidade(pedido);
			}

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

		Pedido pedido = (Pedido) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO PEDIDO (FRETE, ID_CLIENTE, DATA, VALOR, DESCONTO, OBSERVACAO, NUMERO, ID_STATUS) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setDouble(1, pedido.getFrete().getValorFrete());
			stmt.setLong(2, pedido.getCliente().getId());
			stmt.setString(3, pedido.getData());
			stmt.setDouble(4, pedido.getTotal());
			stmt.setDouble(5, pedido.getDesconto());
			stmt.setString(6, pedido.getObservacao());
			stmt.setString(7, pedido.getNumero());
			stmt.setLong(8, pedido.getStatus().getId());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				pedido.setId(rs.getLong(1));
			stmt.close();
			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(pedido);
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
		List<EntidadeDominio> pedidos = new ArrayList<>();
		String sql = "SELECT * FROM PEDIDO WHERE ";

		if (pedido.getId() != null) {
			sql += "ID = ?";
		} else if (pedido.getCliente().getId() != null) {
			sql += "ID_CLIENTE = ?";
		}else if(pedido.getNumero() != null) {
			sql += "NUMERO = ?";
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			if (pedido.getId() != null) {
				stmt.setLong(1, pedido.getId());
			} else if (pedido.getCliente().getId() != null) {
				stmt.setLong(1, pedido.getCliente().getId());
			}else if(pedido.getNumero() != null) {
				stmt.setString(1, pedido.getNumero());
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Frete frete = new Frete();
				Cliente cliente = new Cliente();
				StatusPedido status = new StatusPedido();
				pedido = new Pedido();
				pedido.setId(rs.getLong("ID"));
				pedido.setFrete(frete);
				pedido.setCliente(cliente);
				pedido.setStatus(status);
				pedido.getFrete().setValorFrete(rs.getDouble("FRETE"));
				pedido.getCliente().setId(rs.getLong("ID_CLIENTE"));
				pedido.setData(rs.getString("DATA"));
				pedido.setTotal(rs.getDouble("VALOR"));
				pedido.setDesconto(rs.getDouble("DESCONTO"));
				pedido.setNumero(rs.getString("NUMERO"));
				pedido.setObservacao(rs.getString("OBSERVACAO"));
				pedido.getStatus().setId(rs.getLong("ID_STATUS"));
				pedidos.add(pedido);
			}
			resultado.setSucesso("");

			resultado.setListEntidade(pedidos);

		} catch (Exception e) {
			resultado.setErro("Erro ao realizar a consulta.");
			e.printStackTrace();
		}

		return resultado;
	}

}
