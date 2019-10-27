package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemEstoqueDAO;
import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGravaItensEntrada implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;
		
		Entrada entrada = (Entrada) resultado.getEntidade();
		InstrumentoDAO daoInstrumento = new InstrumentoDAO();
		ItemEstoqueDAO daoItemEstoque = new ItemEstoqueDAO();
		Instrumento instrumento = new Instrumento();
		Resultado r = new Resultado();
		
		if(entrada.getItens() != null) {
			for(ItemEstoque item : entrada.getItens()) {
				r = daoInstrumento.consultar(item.getInstrumento());
				instrumento = (Instrumento) r.getEntidade();
				if(!r.getErro())
					item.setInstrumento(instrumento);
				item.setIdEntrada(entrada.getId());
				
				r = daoItemEstoque.salvar(item);
			}
		}
		return resultado;
	}

}
