package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Catalogo;
import br.com.les.thewallcrud.dominio.Categoria;
import br.com.les.thewallcrud.dominio.GrupoPrecificacao;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.Subcategoria;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class CatalogoDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Catalogo catalogo = (Catalogo) entidade;
		Resultado resultado = new Resultado();
		List<Instrumento> instrumentos = new ArrayList<>();
		String sql = "SELECT *, QUANTIDADE - QUANTIDADE_RESERVADA SALDO FROM ESTOQUE WHERE QUANTIDADE - QUANTIDADE_RESERVADA > 0 ";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Instrumento i = new Instrumento();
				i.setId(rs.getLong("ID_INSTRUMENTO"));
				instrumentos.add(i);
			}
			rs.close();
			resultado.setSucesso("");
			catalogo.setInstumentos(instrumentos);
			resultado.setEntidade(catalogo);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		
		Catalogo catalogo = (Catalogo) entidade;
		Resultado resultado = new Resultado();
		Instrumento i = catalogo.getInstumentos().get(0);
		String sql = "SELECT * FROM INSTRUMENTO WHERE ID = ?";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setLong(1, i.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				GrupoPrecificacao g = new GrupoPrecificacao();
				Categoria c = new Categoria();
				Subcategoria sc = new Subcategoria();
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
				i.setImagem(rs.getString("IMAGEM"));
				sc.setId(rs.getLong("ID_SUBCATEGORIA"));
				c.setSubcategoria(sc);
				c.setId(rs.getLong("ID_CATEGORIA"));
				g.setId(rs.getLong("ID_GRUPO_PRECIFICACAO"));
				i.setCategoria(c);
				i.setGrupoPrecificacao(g);
								
			}
			rs.close();
			IDAO dao = new CategoriaDAO();
			Resultado r = dao.consultarById(i.getCategoria());
			Categoria categoria = (Categoria) r.getEntidade();
			i.setCategoria(categoria);
			resultado.setEntidade(i);
			resultado.setSucesso("");
		} catch (SQLException e) {
			resultado.setErro("Erro de consulta");
			e.printStackTrace();
		}
		return resultado;
		
	}

}
