package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Catalogo;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewCatalogo implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Catalogo catalogo = (Catalogo) resultado.getEntidade();
		IStrategy strategy = new StSetViewInstrumento();
		Resultado r = new Resultado();
		List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
		IDAO dao = new InstrumentoDAO();
		
		for(Instrumento i : catalogo.getInstumentos()) {
			r = dao.consultarById(i);
			entidades.add(r.getEntidade());
		}
		r.setListEntidade(entidades);
		strategy.processar(r);
		List<Instrumento> instrumentos = new ArrayList<>();
		for(EntidadeDominio e: r.getListEntidade()) {
			instrumentos.add((Instrumento) e);
		}
		catalogo.setInstumentos(instrumentos);
		
		return resultado;
	}

}
