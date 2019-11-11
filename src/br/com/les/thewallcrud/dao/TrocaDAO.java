package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class TrocaDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		
		Troca troca = (Troca) entidade;
		Resultado resultado = new Resultado();
		if(troca.getId() == null) {
			resultado.setEntidade(troca);
			return resultado;
		}
		String sql = "UPDATE TROCA SET ";
		
		if(troca.getAprova()) {
			sql += "ID_STATUS = ?, TROCA_APROVADA = ?, ID_CUPOM = ? WHERE ID = ?";
		}else {
			sql += "ID_STATUS = ?, TROCA_APROVADA = ? WHERE ID = ?";
		}
		

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, troca.getStatus().getId());
			stmt.setBoolean(2, troca.getAprova());
			if(troca.getAprova()) {
				stmt.setLong(3, troca.getCupom().getId());
				stmt.setLong(4, troca.getId());
			}else {
				stmt.setLong(3, troca.getId());
			}
			stmt.execute();
			resultado.setSucesso("Status do pedido atualizado!");
			resultado.setEntidade(troca);
		} catch (Exception e) {
			resultado.setErro("Status não atualizao, refaça opração.");
			e.printStackTrace();
		}

		return resultado;

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Troca troca = (Troca) entidade;
		Resultado resultado = new Resultado();
		if (troca.getFlag()) {
			troca.setAdmin(false);
			resultado.setEntidade(troca);
			return resultado;
		}
		List<EntidadeDominio> entidades = new ArrayList<>();
		String sql = "SELECT * FROM TROCA ";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Troca t = new Troca();
				StatusPedido status = new StatusPedido();
				t.setStatus(status);
				t.setId(rs.getLong("ID"));
				t.setData(rs.getString("DATA"));
				t.setNumeroPedidoTroca(rs.getString("NUMERO"));
				t.setObservacao(rs.getString("OBSERVACAO"));
				t.getStatus().setId(rs.getLong("ID_STATUS"));
				t.setIdPedidoCompra(rs.getLong("ID_PEDIDO"));
				t.setIdCliente(rs.getLong("ID_CLIENTE"));
				t.setValor(rs.getDouble("VALOR"));
				if(troca.getAdmin() != null && troca.getAdmin()) {
					t.setAdmin(troca.getAdmin());
				}
				entidades.add(t);
				
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(entidades);

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
		
		Troca troca = (Troca) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO TROCA (DATA, NUMERO, OBSERVACAO, ID_STATUS, ID_PEDIDO, ID_CLIENTE, VALOR) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setString(1, troca.getData());
			stmt.setString(2, troca.getNumeroPedidoTroca());
			stmt.setString(3, troca.getObservacao());
			stmt.setLong(4, troca.getStatus().getId());
			stmt.setLong(5, troca.getIdPedidoCompra());
			stmt.setLong(6, troca.getIdCliente());
			stmt.setDouble(7, troca.getValor());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				troca.setId(rs.getLong(1));
			stmt.close();
			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(troca);
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
		List<EntidadeDominio> trocas = new ArrayList<>();
		String sql = "SELECT * FROM TROCA WHERE ";

		if (troca.getId() != null) {
			sql += "ID = ?";
		} else if (troca.getIdCliente() != null) {
			sql += "ID_CLIENTE = ?";
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			if (troca.getId() != null) {
				stmt.setLong(1, troca.getId());
			} else if ((troca.getIdCliente() != null)) {
				stmt.setLong(1, (troca.getIdCliente()));
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				StatusPedido status = new StatusPedido();
				Cupom cupom = new Cupom();
				troca = new Troca();
				troca.setStatus(status);
				troca.setCupom(cupom);
				troca.setId(rs.getLong("ID"));				
				troca.setData(rs.getString("DATA"));
				troca.setNumeroPedidoTroca(rs.getString("NUMERO"));
				troca.setObservacao(rs.getString("OBSERVACAO"));
				troca.getStatus().setId(rs.getLong("ID_STATUS"));
				troca.setIdPedidoCompra(rs.getLong("ID_PEDIDO"));
				troca.setIdCliente(rs.getLong("ID_CLIENTE"));
				troca.setValor(rs.getDouble("VALOR"));
				troca.getCupom().setId(rs.getLong("ID_CUPOM"));
				troca.setAprova(rs.getBoolean("TROCA_APROVADA"));
				trocas.add(troca);
			}
			resultado.setSucesso("");

			resultado.setListEntidade(trocas);

		} catch (Exception e) {
			resultado.setErro("Erro ao realizar a consulta.");
			e.printStackTrace();
		}

		return resultado;
	}

}
