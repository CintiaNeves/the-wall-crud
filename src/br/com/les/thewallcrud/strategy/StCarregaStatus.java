package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.StatusPedidoDAO;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCarregaStatus implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		IDAO dao = new StatusPedidoDAO();
		Resultado r = new Resultado();
		r = dao.consultar(new StatusPedido());
		
		if(r.getListEntidade() != null) {
			resultado.setMapEntidade("STATUS", r.getListEntidade());
		}
	
		return resultado;
	}

}
