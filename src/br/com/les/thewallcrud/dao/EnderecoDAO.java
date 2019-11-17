package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class EnderecoDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		Resultado resultado = new Resultado();
		List<EntidadeDominio> enderecos = new ArrayList<>();

		String sql = "SELECT * FROM ENDERECO WHERE ID_CLIENTE = ? ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setLong(1, cliente.getId());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Endereco endereco = new Endereco();
				Pais pais = new Pais();
				Estado estado = new Estado();
				Cidade cidade= new Cidade();
				estado.setCidade(cidade);
				pais.setEstado(estado);
				endereco.setPais(pais);
				endereco.setId(rs.getLong("ID"));
				endereco.setCobranca(rs.getBoolean("COBRANCA"));
				endereco.setAlias(rs.getString("ALIAS"));
				endereco.setTpResidencia(rs.getString("TP_RESIDENCIA"));
				endereco.setTpLogradouro(rs.getString("TP_LOGRADOURO"));
				endereco.setNumero(rs.getString("NUMERO"));
				endereco.setBairro(rs.getString("BAIRRO"));
				endereco.setCep(rs.getString("CEP"));
				endereco.setObservacoes(rs.getString("OBSERVACOES"));
				endereco.setLogradouro(rs.getString("LOGRADOURO"));
				endereco.getPais().setId(rs.getLong("ID_PAIS"));
				endereco.getPais().getEstado().setId(rs.getLong("ID_ESTADO"));
				endereco.getPais().getEstado().getCidade().setId(rs.getLong("ID_CIDADE"));
				enderecos.add(endereco);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(enderecos);
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
		
		Cliente cliente = (Cliente) entidade;
		Resultado resultado = new Resultado();
		List<Endereco> enderecos = cliente.getEnderecos();

		String sql = "INSERT INTO ENDERECO (COBRANCA, ALIAS, TP_RESIDENCIA, TP_LOGRADOURO, NUMERO, BAIRRO, CEP, OBSERVACOES, "
				+ " ID_CIDADE, ID_ESTADO, ID_PAIS, LOGRADOURO, ID_CLIENTE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			for(Endereco e : enderecos) {
				stmt.setBoolean(1, e.getCobranca());
				stmt.setString(2, e.getAlias());
				stmt.setString(3, e.getTpResidencia());
				stmt.setString(4, e.getTpLogradouro());
				stmt.setString(5, e.getNumero());
				stmt.setString(6, e.getBairro());
				stmt.setString(7, e.getCep());
				stmt.setString(8, e.getObservacoes());
				stmt.setLong(9, e.getPais().getEstado().getCidade().getId());
				stmt.setLong(10, e.getPais().getEstado().getId());
				stmt.setLong(11, e.getPais().getId());
				stmt.setString(12, e.getLogradouro());
				stmt.setLong(13, cliente.getId());
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
		
		Endereco endereco = (Endereco) entidade;
		Resultado resultado = new Resultado();
		
		String sql = "SELECT * FROM ENDERECO WHERE ID = ? ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			stmt.setLong(1, endereco.getId());
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pais pais = new Pais();
				Estado estado = new Estado();
				Cidade cidade= new Cidade();
				estado.setCidade(cidade);
				pais.setEstado(estado);
				endereco.setPais(pais);
				endereco.setId(rs.getLong("ID"));
				endereco.setCobranca(rs.getBoolean("COBRANCA"));
				endereco.setAlias(rs.getString("ALIAS"));
				endereco.setTpResidencia(rs.getString("TP_RESIDENCIA"));
				endereco.setTpLogradouro(rs.getString("TP_LOGRADOURO"));
				endereco.setNumero(rs.getString("NUMERO"));
				endereco.setBairro(rs.getString("BAIRRO"));
				endereco.setCep(rs.getString("CEP"));
				endereco.setObservacoes(rs.getString("OBSERVACOES"));
				endereco.setLogradouro(rs.getString("LOGRADOURO"));
				endereco.getPais().setId(rs.getLong("ID_PAIS"));
				endereco.getPais().getEstado().setId(rs.getLong("ID_ESTADO"));
				endereco.getPais().getEstado().getCidade().setId(rs.getLong("ID_CIDADE"));
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setEntidade(entidade);
		} catch (SQLException e) {
			resultado.setErro("Erro de consulta");
			e.printStackTrace();
		}
		return resultado;
	}

}
