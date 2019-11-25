package br.com.les.thewallcrud.strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.TrocaDAO;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGeraCodigoTroca implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Troca troca = (Troca) entidade;
		Troca t = new Troca();
		t.setId((long) 1);
		t.setAdmin(false);
		boolean possuiNumero = t.getNumeroPedidoTroca() != null && t.getNumeroPedidoTroca().trim().length() > 0 ? true : false;
		IDAO dao = new TrocaDAO();
		Resultado r = dao.consultar(t);
		Integer index = r.getListEntidade().size();
		Long maxId = r.getListEntidade() != null && r.getListEntidade().size() > 0
				? r.getListEntidade().get(index - 1).getId() + 1
				: 1;

		if (!possuiNumero) {
			Calendar calendar = GregorianCalendar.getInstance();
			Integer ano = calendar.get(Calendar.YEAR);
			String numero = ano.toString().concat("04").concat(maxId.toString());
			troca.setNumeroPedidoTroca(numero);
		}
		
		IStrategy st = new StRegistraPedidoTrocado();
			st.processar(troca);
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
