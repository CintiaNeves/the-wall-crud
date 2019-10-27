package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Telefone;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class TelefoneDAO extends AbstractDao{

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
		
		Cliente cliente = (Cliente) entidade;
		Resultado resultado = new Resultado();
		List<Telefone> telefones = cliente.getTelefones();

		String sql = "INSERT INTO TELEFONE (TIPO, DDD, NUMERO, ID_CLIENTE) VALUES (?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			for(Telefone t : telefones) {
				stmt.setString(1, t.getTipo());
				stmt.setString(2, t.getDdd());
				stmt.setString(3, t.getNumero());
				stmt.setDouble(4, cliente.getId());
				stmt.execute();
			}
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
		// TODO Auto-generated method stub
		return null;
	}

}
