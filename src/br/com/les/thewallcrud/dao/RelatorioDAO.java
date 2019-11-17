package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.les.thewallcrud.dominio.Relatorio;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class RelatorioDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Relatorio relatorio = (Relatorio) entidade; 
		Map<String, String> queryFato = new HashMap<String, String>();
		
		String fatoVendas = "SELECT YEAR(DATA) ANO, MONTH(DATA) MES, I.DESCRICAO, SUM(QUANTIDADE) QUANTIDADE "
				+ "FROM PEDIDO P " + "JOIN ITEM_PEDIDO IP ON P.ID = IP.ID_PEDIDO "
				+ "JOIN INSTRUMENTO I ON I.ID = IP.ID_INSTRUMENTO ";
		
		String fatoTrocas = "SELECT YEAR(DATA) ANO, MONTH(DATA) MES, I.DESCRICAO, SUM(QUANTIDADE) QUANTIDADE "
				+ "FROM TROCA T " + "JOIN ITEM_TROCA IT ON T.ID = IT.ID_TROCA "
				+ "JOIN INSTRUMENTO I ON I.ID = IT.ID_INSTRUMENTO ";
		
		queryFato.put("VENDAS", fatoVendas);
		queryFato.put("TROCAS", fatoTrocas);
		Resultado resultado = new Resultado();
		String where = "";
		String in = null;
		Map<String, String> dados = ((Relatorio) entidade).getDados();
		boolean and = false;
		for (Map.Entry<String, String> d : dados.entrySet()) {
			if (d.getValue() != null && !"".equals(d.getValue())) {
				if ("".equals(where))
					where = where.concat(" WHERE ");
				if (d.getKey().equals("dataInicio")) {
					if (and)
						where = where.concat(" AND ");
					where = where.concat(" DATA > '").concat(d.getValue()).concat("' ");
					and = true;
				} else if (d.getKey().equals("dataFim")) {
					if (and)
						where = where.concat(" AND ");
					where = where.concat(" DATA < '").concat(d.getValue()).concat("' ");
					and = true;
				} else {
					try {
						if (Integer.parseInt(d.getKey()) > 0) {
							if (in == null)
								in = " I.ID IN (";
							in = in.concat(d.getValue()).concat(", ");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		if (where != null && !where.equals("") && !where.equals(" WHERE ") && in != null)
			in = " AND ".concat(in);
		if (in != null) {
			where = where.concat(in.substring(0, in.length() - 2).concat(")"));
		}
		
		String sql = queryFato.get(relatorio.getFato()).concat(where)
				+ "GROUP BY YEAR(DATA), MONTH(DATA), I.DESCRICAO";
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			Relatorio r = new Relatorio();
			while (rs.next()) {
				String data = rs.getString("MES").concat("/").concat(rs.getString("ANO"));
				String descricao = rs.getString("DESCRICAO");
				String quantidade = rs.getString("QUANTIDADE");

				r.getDatas().add(data);
				r.getColunas().add(descricao);
				r.getDados().put(data.concat("|").concat(descricao), quantidade);
			}
			resultado.setEntidade(r);
			rs.close();
			resultado.setSucesso("");
		} catch (SQLException e) {
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
		// TODO Auto-generated method stub
		return null;
	}

}
