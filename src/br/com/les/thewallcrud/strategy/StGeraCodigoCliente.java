package br.com.les.thewallcrud.strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGeraCodigoCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Cliente cliente = (Cliente) entidade;
		
		IDAO dao = new ClienteDAO();
		boolean possuiCodigo = cliente.getCodigo() != null && cliente.getCodigo().trim().length() > 0 ? true : false;
		
		Resultado r = dao.consultar(new Cliente());
		Integer index = r.getListEntidade().size();
		Long maxId = r.getListEntidade() != null 
				&& r.getListEntidade().size() > 0 
				? r.getListEntidade().get(index -1).getId() + 1 : 1;

		if (!possuiCodigo) {
			Calendar calendar = GregorianCalendar.getInstance();
			Integer ano = calendar.get(Calendar.YEAR);
			String codigo = ano.toString().concat("01").concat(maxId.toString());
			cliente.setCodigo(codigo);
		}
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
