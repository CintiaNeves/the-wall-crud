package br.com.les.thewallcrud.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Frete;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class FreteDAO extends AbstractDao {

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
		Resultado r = new Resultado();
		if(entidade instanceof Frete) {
			Frete f = (Frete) entidade;
			String sql = "INSERT INTO FRETE (VALOR, VALOR_FRETE, ID_CARRINHO) VALUES (?, ?, ?)";
			try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setString(1, f.getValor());
				stmt.setDouble(2, f.getValorFrete());
				stmt.setLong(3, f.getIdCarrinho());
				stmt.executeUpdate();
				ResultSet rs = stmt.getGeneratedKeys();
				if(rs.next())
					f.setId(rs.getLong(1));
				stmt.close();
				r.setEntidade(f);
				r.setSucesso("");
			} catch (Exception e) {
				r.setErro("Erro ao consultar frete");
				e.printStackTrace();
			}
		}
		return r;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Resultado consutarByIdCarrinho(EntidadeDominio entidade) {
		Resultado r = new Resultado();
		if(entidade instanceof Carrinho) {
			Carrinho c = (Carrinho) entidade;
			String sql = "SELECT * FROM FRETE WHERE ID_CARRINHO = ?";
			
			try(PreparedStatement stmt = connection.prepareStatement(sql)) {
				stmt.setLong(1, c.getId());
				ResultSet rs = stmt.executeQuery();
				Frete f = new Frete();
				while(rs.next()) {
					f.setId(rs.getLong("ID"));
					f.setCep(rs.getString("CEP"));
					f.setValor(rs.getString("VALOR"));
					f.setValorFrete(rs.getDouble("VALOR_FRETE"));
				}
				rs.close();
				r.setEntidade(f);
				r.setSucesso("");
			} catch(Exception e) {
				r.setErro("Erro ao consultar frete.");
				e.printStackTrace();
				// @FIXME
			}
		}
		return r;
	}
}
