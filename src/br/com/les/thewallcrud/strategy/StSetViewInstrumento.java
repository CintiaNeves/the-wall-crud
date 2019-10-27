package br.com.les.thewallcrud.strategy;

import java.util.List;

import br.com.les.thewallcrud.dao.CategoriaDAO;
import br.com.les.thewallcrud.dao.GrupoPrecificacaoDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.SubcategoriaDAO;
import br.com.les.thewallcrud.dominio.Categoria;
import br.com.les.thewallcrud.dominio.GrupoPrecificacao;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.Subcategoria;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewInstrumento implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {

		if (resultado.getErro())
			return resultado;

		List<EntidadeDominio> instrumentos = resultado.getListEntidade();
		for (EntidadeDominio e : instrumentos) {
			Instrumento instrumento = (Instrumento) e;

			IDAO daoGrpPrecificacao = new GrupoPrecificacaoDAO();
			IDAO daoCategoria = new CategoriaDAO();
			IDAO daoSubcategoria = new SubcategoriaDAO();
			Categoria c = new Categoria();
			Subcategoria s = new Subcategoria();
			GrupoPrecificacao g = new GrupoPrecificacao();

			Resultado r = daoGrpPrecificacao.consultarById(instrumento.getGrupoPrecificacao());
			if (r.getEntidade() != null) {
				g = (GrupoPrecificacao) r.getEntidade();
				instrumento.setGrupoPrecificacao(g);
			}

			r = daoSubcategoria.consultarById(instrumento.getCategoria().getSubcategoria());
			if (r.getEntidade() != null) {
				s = (Subcategoria) r.getEntidade();
			}

			r = daoCategoria.consultarById(instrumento.getCategoria());
			if (r.getEntidade() != null) {
				c = (Categoria) r.getEntidade();
				c.setSubcategoria(s);
				instrumento.setCategoria(c);
			}

		}

		return resultado;
	}

}
