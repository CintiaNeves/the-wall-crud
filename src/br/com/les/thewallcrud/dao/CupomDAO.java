package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class CupomDAO extends AbstractDao {

	@Override 
	public Resultado alterar(EntidadeDominio entidade) {
		
		Cupom cupom = (Cupom) entidade;
		Resultado resultado = new Resultado();
		
		String sql;
		
		if(cupom.getIdPedido() != null) {
			sql = "UPDATE CUPOM SET ID_PEDIDO = ?, EXPIRADO = ? WHERE ID = ? ";
		}else {
			sql = "UPDATE CUPOM SET ID_CARRINHO = ? WHERE ID = ? ";
		}
		
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			if(cupom.getIdPedido() != null) {
				stmt.setLong(1, cupom.getIdPedido());
				stmt.setBoolean(2, cupom.getExpirado());
				stmt.setLong(3, cupom.getId());
			}else {
				stmt.setLong(1, cupom.getIdCarrinho());
				stmt.setLong(2, cupom.getId());
			}
			
			stmt.execute();

			resultado.setSucesso("Registro Alterado com sucesso!");
			resultado.setEntidade(cupom);
		} catch (Exception e) {
			resultado.setErro("Alteração não realizada.\n");
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Cupom cupom = (Cupom) entidade;
		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM CUPOM WHERE CODIGO = ? AND EXPIRADO = 0";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, cupom.getCodigo());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cupom.setExpirado(rs.getBoolean("EXPIRADO"));
				cupom.setId(rs.getLong("ID"));
				cupom.setPromocional(rs.getBoolean("PROMOCIONAL"));
				cupom.setTroca(rs.getBoolean("TROCA"));
				cupom.setValor(rs.getString("VALOR"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(cupom);

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
		
		Cupom cupom = (Cupom) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO CUPOM (CODIGO, TROCA, PROMOCIONAL, EXPIRADO, VALOR, ID_CLIENTE) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			stmt.setString(1, cupom.getCodigo());
			stmt.setBoolean(2, cupom.getTroca());
			stmt.setBoolean(3, cupom.getPromocional());
			stmt.setBoolean(4, cupom.getExpirado());
			stmt.setString(5, cupom.getValor());
			stmt.setLong(6,  cupom.getIdCliente());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				cupom.setId(rs.getLong(1));
			stmt.close();
			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(cupom);
		} catch (Exception e) {
			resultado.setErro("Inclusão não realizada.");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		
		Cupom cupom = (Cupom) entidade;
		Resultado resultado = new Resultado();
		List<EntidadeDominio> cupons = new ArrayList<>();

		String sql = "SELECT * FROM CUPOM WHERE ";
		if(cupom.getId() != null) {
			sql += "ID = ? AND EXPIRADO = 0";
		}else {
			sql += "ID_CARRINHO = ? AND EXPIRADO = 0";
		}
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(cupom.getId() != null) {
				stmt.setLong(1, cupom.getId());
			}else {
				stmt.setLong(1, cupom.getIdCarrinho());
			}
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cupom c = new Cupom();
				c.setExpirado(rs.getBoolean("EXPIRADO"));
				c.setId(rs.getLong("ID"));
				c.setCodigo(rs.getString("CODIGO"));
				c.setPromocional(rs.getBoolean("PROMOCIONAL"));
				c.setTroca(rs.getBoolean("TROCA"));
				c.setValor(rs.getString("VALOR"));
				cupons.add(c);
			}
			rs.close();
			resultado.setSucesso("");
			if(cupons.size() > 1) {
				resultado.setListEntidade(cupons);
			}else if(cupons.size() == 1){
				resultado.setEntidade(cupons.get(0));
			}
			

		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
	}

}
