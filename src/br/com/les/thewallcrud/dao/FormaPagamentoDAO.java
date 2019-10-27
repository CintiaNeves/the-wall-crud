package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;

import br.com.les.thewallcrud.dominio.FormaPagamento;
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
		// TODO Auto-generated method stub
		return null;
	}

}
