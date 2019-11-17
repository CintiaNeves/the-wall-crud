package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class EstoqueDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
			
		ItemEstoque itemEstoque = null;
		ItemCarrinho itemCarrinho = null;
		Boolean reserva = false;
		
		if(entidade instanceof ItemEstoque) { 
			itemEstoque = (ItemEstoque) entidade;
		}
		else if(entidade instanceof ItemCarrinho) {
			itemCarrinho = (ItemCarrinho) entidade;
		}
		Boolean estoque = itemEstoque != null ? true : false;
		Boolean carrinho = itemCarrinho != null ? true : false;
		if(estoque) {
			reserva = itemEstoque.getQuantidadeReservada() != null ? true : false;
		}
		Resultado resultado = new Resultado(); 

		String sql = "UPDATE ESTOQUE SET ";
		
		if(estoque) {
			if(reserva) {
				sql += "QUANTIDADE_RESERVADA = ? WHERE ID_INSTRUMENTO = ?";
			}else {
				sql += "QUANTIDADE = ? WHERE ID_INSTRUMENTO = ?";
			}
		}else if(carrinho) {
			sql += "QUANTIDADE_RESERVADA = ? WHERE ID_INSTRUMENTO = ?";
		}
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(estoque) {
				if(reserva) {
					stmt.setInt(1, itemEstoque.getQuantidadeReservada());
					stmt.setLong(2, itemEstoque.getInstrumento().getId());
					stmt.execute();
				}else {
					stmt.setInt(1, itemEstoque.getQuantidade());
					stmt.setLong(2, itemEstoque.getInstrumento().getId());
					stmt.execute();
				}				
			}else if(carrinho) {
				stmt.setInt(1, itemCarrinho.getQuantidade());
				stmt.setLong(2, itemCarrinho.getInstrumento().getId());
				stmt.execute();
			}

			resultado.setSucesso("Registro Alterado com sucesso!");
			if(estoque)
				resultado.setEntidade(itemEstoque);
			if(carrinho)
				resultado.setEntidade(itemCarrinho);
		} catch (Exception e) {
			resultado.setErro("Altera√ß√£o n√£o realizada.\n");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		ItemEstoque item = (ItemEstoque) entidade;
		Resultado resultado = new Resultado();
		ItemEstoque i = new ItemEstoque();

		String sql = "SELECT * FROM ESTOQUE WHERE ID_INSTRUMENTO = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setLong(1, item.getInstrumento().getId());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Instrumento instrumento  = new Instrumento();
				i.setInstrumento(instrumento);
				i.setId(rs.getLong("ID"));
				i.setQuantidade(rs.getInt("QUANTIDADE"));
				i.setQuantidadeReservada(rs.getInt("QUANTIDADE_RESERVADA"));
				i.getInstrumento().setId(rs.getLong("ID_INSTRUMENTO"));
				resultado.setEntidade(i);
			}
			rs.close();
			resultado.setSucesso("");
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
		
		ItemEstoque item = (ItemEstoque) entidade;
		item.setQuantidadeReservada(0);
		Resultado resultado = new Resultado();
		String sql = "INSERT INTO ESTOQUE (ID_INSTRUMENTO, QUANTIDADE, QUANTIDADE_RESERVADA) VALUES (?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, item.getInstrumento().getId());
			stmt.setInt(2, item.getQuantidade());
			stmt.setInt(3, item.getQuantidadeReservada());

			stmt.execute();
			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(item);
		} catch (Exception e) {
			resultado.setErro("Inclus„oo n„o realizada.");
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
