package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.TrocaDAO;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StAlteraStatusTroca implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Troca troca = (Troca) entidade;
		StatusPedido novoStatus = troca.getStatus();
		IDAO dao = new TrocaDAO();
		Resultado resultado = new Resultado();
		resultado = dao.consultarById(troca);
		troca = (Troca) resultado.getEntidade();
		troca.setStatus(novoStatus);
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
