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
		
		if(entidade instanceof ItemEstoque) { 
			itemEstoque = (ItemEstoque) entidade;
		}
		else if(entidade instanceof ItemCarrinho) {
			itemCarrinho = (ItemCarrinho) entidade;
		}
		Boolean estoque = itemEstoque != null ? true : false;
		Boolean carrinho = itemCarrinho != null ? true : false;
		
		Resultado resultado = new Resultado(); 

		String sql = "UPDATE ESTOQUE SET ";
		
		if(estoque)
			sql += "QUANTIDADE = ? WHERE ID_INSTRUMENTO = ?";
		else if(carrinho)
			sql += "QUANTIDADE_RESERVADA = ? WHERE ID_INSTRUMENTO = ?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(estoque) {
				stmt.setInt(1, itemEstoque.getQuantidade());
				stmt.setLong(2, itemEstoque.getInstrumento().getId());
				stmt.execute();
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
			resultado.setErro("Alteração não realizada.\n");
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
				i.setQuantidade(rs.getInt("QUANTIDADE"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(i);
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

		Instrumento instrumento = (Instrumento) entidade;
		Resultado resultado = new Resultado();
		String sql = "INSERT INTO ESTOQUE (ID_INSTRUMENTO) VALUES (?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, instrumento.getId());

			stmt.execute();
			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(instrumento);
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
