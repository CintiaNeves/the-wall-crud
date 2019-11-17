package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class CarrinhoDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		if(entidade instanceof Carrinho) {
			Carrinho carrinho = (Carrinho) entidade;
			Resultado r = new Resultado();
			if (carrinho.getRetornoJson() && carrinho.getFrete().getValor() != null) {
				r.setEntidade(carrinho.getFrete());
				return r;
			} else if (carrinho.getRetornoJson() && carrinho.getCupons().get(0).getCodigo() != null) {
				r.setEntidade(carrinho.getCupons().get(0));
				return r;
			}
		}
		
		Cliente cliente = (Cliente) entidade;
		Carrinho carrinho = new Carrinho();
		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM CARRINHO WHERE ID_CLIENTE = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, cliente.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				carrinho.setId(rs.getLong("ID"));	
			}
			rs.close();
			resultado.setEntidade(carrinho);
			resultado.setSucesso("");
		} catch (SQLException e) {
			resultado.setErro("Consulta n�o realizada.\n");
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

		Cliente cliente = (Cliente) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO CARRINHO (ID_CLIENTE) VALUES (?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setLong(1, cliente.getId());
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				cliente.getCarrinho().setId(rs.getLong(1));
			stmt.close();
			resultado.setSucesso("Cadastro Realizado com Sucesso.");
			resultado.setEntidade(cliente);
		} catch (Exception e) {
			resultado.setErro("Inclusão não realizada.");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		
		Carrinho carrinho = (Carrinho) entidade;
		Resultado resultado = new Resultado();
		List<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();
		
		String sql = "SELECT * FROM ITEM_CARRINHO WHERE ID_CARRINHO = ? AND EXPIRADO = 0";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, carrinho.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ItemCarrinho item = new ItemCarrinho();
				Instrumento instrumento = new Instrumento();
				item.setInstrumento(instrumento);
				item.setId(rs.getLong("ID"));
				item.setQuantidade(rs.getInt("QUANTIDADE"));
				item.setExpirado(rs.getBoolean("EXPIRADO"));
				item.getInstrumento().setId(rs.getLong("ID_INSTRUMENTO"));
				itens.add(item);
			}
			carrinho.setItens(itens);
			rs.close();
			resultado.setEntidade(carrinho);
			resultado.setSucesso("");
		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}

		return resultado;
		
	}

}
