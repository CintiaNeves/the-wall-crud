package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Categoria;
import br.com.les.thewallcrud.dominio.GrupoPrecificacao;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.Subcategoria;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class InstrumentoDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {

		Instrumento instrumento = (Instrumento) entidade;
		Resultado resultado = new Resultado();
		Boolean descricao = instrumento.getDescricao() != null ? true: false;
		Boolean modelo = instrumento.getModelo() != null ? true : false;
		Boolean cor = instrumento.getCor() != null ? true : false;
		Boolean especificacoes = instrumento.getEspecificacoes() != null ? true : false;
		Boolean marca = instrumento.getMarca() != null ? true : false;
		Boolean grupoPrecificacao = instrumento.getGrupoPrecificacao().getId() != null && instrumento.getGrupoPrecificacao().getId() > 0 ? true : false;
		Boolean categoria = instrumento.getCategoria().getId() != null && instrumento.getCategoria().getId() > 0 ? true : false;
		Boolean subcategoria = instrumento.getCategoria().getSubcategoria().getId() != null && instrumento.getCategoria().getSubcategoria().getId() > 0 ? true : false;
		Boolean valorCusto = instrumento.getValorCusto() != null ? true : false;
		Boolean valorVenda = instrumento.getValorVenda() != null ? true : false;
		Boolean serie = instrumento.getSerie() != null ? true : false;
		
		String sql = "UPDATE INSTRUMENTO SET ATIVO = ?, ";
		
		if(descricao) {
			sql += "DESCRICAO = ?, ";
		}
		if(modelo) {
			sql += "MODELO = ?, ";
		}
		if(cor) {
			sql += "COR = ?, ";
		}
		if(especificacoes) {
			sql += "ESPECIFICACOES = ?, ";
		}
		if(marca) {
			sql += "MARCA = ?, ";
		}
		if(grupoPrecificacao) {
			sql += "ID_GRUPO_PRECIFICACAO = ?, ";
		}
		if(categoria) {
			sql += "ID_CATEGORIA = ?, ";
		}
		
		if(subcategoria) {
			sql += "ID_SUBCATEGORIA = ?, ";
		}
		
		if(valorCusto) {
			sql += "VALOR_CUSTO = ?, ";
		}
		
		if(valorVenda) {
			sql += "VALOR_VENDA = ?, ";
		}
		
		if(serie) {
			sql += "SERIE = ?, ";
		}
		
		sql += "WHERE ID = ? ";
		sql = sql.replace(", WHERE", " WHERE");
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			int counter = 0;
			stmt.setInt(++counter, instrumento.isAtivo() == true ? 1 : 0);
			if(descricao) {
				stmt.setString(++counter, instrumento.getDescricao());				
			}
			if(modelo) {
				stmt.setString(++counter, instrumento.getModelo());
			}
			if(cor) {
				stmt.setString(++counter, instrumento.getCor());
			}
			if(especificacoes) {
				stmt.setString(++counter, instrumento.getEspecificacoes());
			}
			if(marca) {
				stmt.setString(++counter, instrumento.getMarca());
			}
			if(grupoPrecificacao) {
				stmt.setLong(++counter, instrumento.getGrupoPrecificacao().getId());
			}
			if(categoria) {
				stmt.setLong(++counter, instrumento.getCategoria().getId());
			}
			if(subcategoria) {
				stmt.setLong(++counter, instrumento.getCategoria().getSubcategoria().getId());
			}
			if(valorCusto) {
				stmt.setDouble(++counter, instrumento.getValorCusto());
			}
			if(valorVenda) {
				stmt.setDouble(++counter, instrumento.getValorVenda());
			}
			if(serie) {
				stmt.setString(++counter, instrumento.getSerie());
			}
			stmt.setLong(++counter, instrumento.getId());
			stmt.execute();

			resultado.setSucesso("Registro Alterado com sucesso!");
			resultado.setEntidade(instrumento);
		} catch (Exception e) {
			resultado.setErro("Alteração não realizada.\n");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Instrumento instrumento = (Instrumento) entidade;

		Resultado resultado = new Resultado();
		List<EntidadeDominio> instrumentos = new ArrayList<>();

		String sql = "SELECT * FROM INSTRUMENTO ";

		boolean contemDescricao = instrumento != null && instrumento.getDescricao() != null;
		boolean contemCodigo = instrumento != null && instrumento.getCodigo() != null;
		boolean contemSerie = instrumento.getSerie() != null ? true : false;
		boolean contemCadastro = instrumento.getCadastro() != null ? true : false;
		
		if(contemCadastro && contemSerie) {
			sql += "WHERE SERIE = ? ";
		}else if(contemCodigo) {
			sql+= "WHERE CODIGO = ? ";
		}else if (contemDescricao) {
			sql += "WHERE DESCRICAO LIKE ? ";
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(contemCadastro && contemSerie) {
				stmt.setString(1, instrumento.getSerie());
			}else if (contemCodigo) {
				stmt.setString(1, instrumento.getCodigo());
			}else if(contemDescricao) {
				stmt.setString(1, '%' + instrumento.getDescricao() + '%');
			}

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Instrumento i = new Instrumento();
				GrupoPrecificacao g = new GrupoPrecificacao();
				Categoria c = new Categoria();
				Subcategoria sc = new Subcategoria();
				i.setId(rs.getLong("ID"));
				i.setAtivo(rs.getBoolean("ATIVO"));
				i.setCodigo(rs.getString("CODIGO"));
				i.setDescricao(rs.getString("DESCRICAO"));
				i.setMarca(rs.getString("MARCA"));
				i.setModelo(rs.getString("MODELO"));
				i.setCor(rs.getString("COR"));
				i.setEspecificacoes(rs.getString("ESPECIFICACOES"));
				sc.setId(rs.getLong("ID_SUBCATEGORIA"));
				c.setSubcategoria(sc);
				c.setId(rs.getLong("ID_CATEGORIA"));
				g.setId(rs.getLong("ID_GRUPO_PRECIFICACAO"));
				i.setCategoria(c);
				i.setGrupoPrecificacao(g);
				i.setValorCusto(rs.getDouble("VALOR_CUSTO"));
				i.setValorVenda(rs.getDouble("VALOR_VENDA"));
				i.setSerie(rs.getString("SERIE"));
				instrumentos.add(i);
			}
			rs.close();
			resultado.setSucesso("");
			if(instrumentos.size() > 0) {
				resultado.setListEntidade(instrumentos);
			}else {
				resultado.setEntidade(instrumento);
			}
			
		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}
		return resultado;

	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {

		Instrumento instrumento = (Instrumento) entidade;
		Resultado resultado = new Resultado();

		String sql = "DELETE FROM INSTRUMENTO WHERE ID = ? ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, instrumento.getId());
			stmt.execute();

			stmt.close();
			resultado.setSucesso("Instrumento excluido com sucesso!");
			resultado.setEntidade(null);
		} catch (SQLException e) {
			resultado.setErro("O instrumento não pode ser excluído pois existem dados que fazem referência a ele.\n");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {

		Instrumento instrumento = (Instrumento) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO INSTRUMENTO (ATIVO, CODIGO, DESCRICAO, MARCA, MODELO, COR, ESPECIFICACOES, ID_GRUPO_PRECIFICACAO, ID_CATEGORIA, ID_SUBCATEGORIA, SERIE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setBoolean(1, instrumento.isAtivo());
			stmt.setString(2, instrumento.getCodigo());
			stmt.setString(3, instrumento.getDescricao());
			stmt.setString(4, instrumento.getMarca());
			stmt.setString(5, instrumento.getModelo());
			stmt.setString(6, instrumento.getCor());
			stmt.setString(7, instrumento.getEspecificacoes());
			stmt.setLong(8, instrumento.getGrupoPrecificacao().getId());
			stmt.setLong(9, instrumento.getCategoria().getId());
			stmt.setLong(10, instrumento.getCategoria().getSubcategoria().getId());
			stmt.setString(11, instrumento.getSerie());

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				instrumento.setId(rs.getLong(1));
			stmt.close();
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
		
		Long idInstrumento = null;
		
		if(entidade instanceof Instrumento) {
			Instrumento instrumento = (Instrumento) entidade;
			idInstrumento = instrumento.getId();
		}else if(entidade instanceof ItemCarrinho) {
			ItemCarrinho item = (ItemCarrinho) entidade;
			idInstrumento = item.getInstrumento().getId();
		}
		

		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM INSTRUMENTO WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, idInstrumento);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Instrumento i = new Instrumento();
				GrupoPrecificacao g = new GrupoPrecificacao();
				Categoria c = new Categoria();
				Subcategoria sc = new Subcategoria();
				i.setId(rs.getLong("ID"));
				i.setAtivo(rs.getBoolean("ATIVO"));
				i.setCodigo(rs.getString("CODIGO"));
				i.setDescricao(rs.getString("DESCRICAO"));
				i.setMarca(rs.getString("MARCA"));
				i.setModelo(rs.getString("MODELO"));
				i.setCor(rs.getString("COR"));
				i.setSerie(rs.getString("SERIE"));
				i.setValorCusto(rs.getDouble("VALOR_CUSTO"));
				i.setValorVenda(rs.getDouble("VALOR_VENDA"));
				i.setEspecificacoes(rs.getString("ESPECIFICACOES"));
				sc.setId(rs.getLong("ID_SUBCATEGORIA"));
				c.setSubcategoria(sc);
				c.setId(rs.getLong("ID_CATEGORIA"));
				g.setId(rs.getLong("ID_GRUPO_PRECIFICACAO"));
				i.setCategoria(c);
				i.setGrupoPrecificacao(g);
				resultado.setEntidade(i);
			}
			rs.close();
			resultado.setSucesso("");
		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}
		return resultado;

	}
}
