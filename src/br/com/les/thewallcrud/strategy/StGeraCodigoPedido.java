package br.com.les.thewallcrud.strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.PedidoDAO;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGeraCodigoPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		Pedido p = new Pedido();
		p.setId((long) 1);
		boolean possuiNumero = pedido.getNumero() != null && pedido.getNumero().trim().length() > 0 ? true : false;
		IDAO dao = new PedidoDAO();
		Resultado r = dao.consultar(p);
		Integer index = r.getListEntidade().size();
		Long maxId = r.getListEntidade() != null && r.getListEntidade().size() > 0
				? r.getListEntidade().get(index - 1).getId() + 1
				: 1;

		if (!possuiNumero) {
			Calendar calendar = GregorianCalendar.getInstance();
			Integer ano = calendar.get(Calendar.YEAR);
			String numero = ano.toString().concat("02").concat(maxId.toString());
			pedido.setNumero(numero);
		}
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
