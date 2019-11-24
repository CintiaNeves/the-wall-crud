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
			resultado.setErro("Alterção não realizada.\n");
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Cupom cupom = (Cupom) entidade;
		Resultado resultado = new Resultado();
		List<EntidadeDominio> cupons = new ArrayList<>();
		Boolean contemCodigo = cupom.getCodigo() != null ? true : false;
		String sql = "SELECT * FROM CUPOM WHERE ";
		
		if(contemCodigo) {
			sql += "CODIGO = ? AND ";	
		}
		sql += "EXPIRADO = 0";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(contemCodigo) {
				stmt.setString(1, cupom.getCodigo());
			}
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Cupom c = new Cupom();
				c.setExpirado(rs.getBoolean("EXPIRADO"));
				c.setCodigo(rs.getString("CODIGO"));
				c.setId(rs.getLong("ID"));
				c.setPromocional(rs.getBoolean("PROMOCIONAL"));
				c.setTroca(rs.getBoolean("TROCA"));
				c.setValor(rs.getString("VALOR"));
				c.setIdCliente(rs.getLong("ID_CLIENTE"));
				cupons.add(c);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(cupons);

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
		Boolean contemIdCliente = cupom.getIdCliente() != null ? true : false;
		Boolean contemIdCarrinho = cupom.getIdCarrinho() != null ? true : false;
		Boolean contemIdPedido = cupom.getIdCarrinho() != null ? true : false;
		
		String sql = "SELECT * FROM CUPOM WHERE ";
		if(cupom.getId() != null) {
			sql += "ID = ? AND EXPIRADO = 0";
		}else if (contemIdCarrinho){
			sql += "ID_CARRINHO = ? AND EXPIRADO = 0";
		}else if(contemIdCliente) {
			sql += "ID_CLIENTE = ? AND EXPIRADO = 0";
		}else if(contemIdPedido) {
			sql += "ID_PEDIDO = ? AND EXPIRADO = 0";
		}
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(cupom.getId() != null) {
				stmt.setLong(1, cupom.getId());
			}else if(contemIdCarrinho){
				stmt.setLong(1, cupom.getIdCarrinho());
			}else if(contemIdCliente) {
				stmt.setLong(1, cupom.getIdCliente());
			}else if(contemIdPedido) {
				stmt.setLong(1, cupom.getIdPedido());
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
				c.setIdCliente(rs.getLong("ID_CLIENTE"));
				c.setIdPedido(rs.getLong("ID_PEDIDO"));
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
