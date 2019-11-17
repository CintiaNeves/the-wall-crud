package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Catalogo;
import br.com.les.thewallcrud.dominio.Instrumento;
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
		// TODO Auto-generated method stub
		return null;
	}

}
