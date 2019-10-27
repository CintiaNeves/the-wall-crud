package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StatusPedidoDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		List<EntidadeDominio> status = new ArrayList<>();
		Resultado resultado = new Resultado();
		
		String sql = "SELECT * FROM STATUS_PEDIDO ";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				StatusPedido s = new StatusPedido();
				s.setId(rs.getLong("ID"));
				s.setDescricao(rs.getString("DESCRICAO"));
				status.add(s);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(status);
		}catch(SQLException e) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		
		StatusPedido status = (StatusPedido) entidade;
		Resultado resultado = new Resultado();
		
		String sql = "SELECT * FROM STATUS_PEDIDO WHERE ID = ?";
		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			
			stmt.setLong(1, status.getId());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				status.setId(rs.getLong("ID"));
				status.setDescricao(rs.getString("DESCRICAO"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(status);
		}catch(SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}
		
		return resultado;
	}

}
