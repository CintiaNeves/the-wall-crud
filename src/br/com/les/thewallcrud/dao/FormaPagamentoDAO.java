package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.FormaPagamento;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class FormaPagamentoDAO extends AbstractDao{

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
		
		FormaPagamento forma = (FormaPagamento) entidade;
		Resultado resultado = new Resultado();
		Boolean cupom = forma.getCupons() != null ? true : false;
		Boolean cartao = forma.getCartao() != null ? true : false; 
		
		String sql = "INSERT INTO FORMA_PAGAMENTO ";
		
		if(cupom) {
			sql += " (ID_CUPOM, ID_PEDIDO) VALUES ( ?, ?)";
		}else if(cartao) {
			sql += " (ID_CARTAO, ID_PEDIDO, VALOR_CARTAO, PARCELAS) VALUES ( ?, ?, ?, ?)";
		}
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(cartao) {
				stmt.setLong(1, forma.getCartao().getId());
				stmt.setLong(2, forma.getIdPedido());
				stmt.setDouble(3, forma.getValor());
				stmt.setInt(4, forma.getParcelas());
			}else if(cupom) {
				stmt.setLong(1, forma.getCupons().get(0).getId());
				stmt.setLong(2, forma.getIdPedido());
			}
			
			stmt.execute();
			resultado.setSucesso("Entrada Realizada com Sucesso.");
			resultado.setEntidade(forma);
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
		List<EntidadeDominio> formasPagamento = new ArrayList<>();
		List<Cupom> cupons = new ArrayList<>();
		
		String sql = "SELECT * FROM FORMA_PAGAMENTO WHERE ID_PEDIDO = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setLong(1, pedido.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				FormaPagamento forma = new FormaPagamento();
				Cartao cartao = new Cartao();
				Cupom cupom = new Cupom();
				forma.setId(rs.getLong("ID"));
				cupom.setId(rs.getLong("ID_CUPOM"));
				cartao.setId(rs.getLong("ID_CARTAO"));
				forma.setIdPedido(rs.getLong("ID_PEDIDO"));
				forma.setValor(rs.getDouble("VALOR_CARTAO"));
				forma.setParcelas(rs.getInt("PARCELAS"));
				forma.setCartao(cartao);
				if(cupom.getId() != null && cupom.getId() > 0) {
					cupons.add(cupom);
				}
				forma.setCupons(cupons);
				formasPagamento.add(forma);
			}
			resultado.setListEntidade(formasPagamento);
			resultado.setSucesso("Consulta realizada com sucesso");
		}catch (Exception e) {
			e.printStackTrace();
			resultado.setErro("Não foi possível realizar a consulta");
		}
		return resultado;
	}

}
