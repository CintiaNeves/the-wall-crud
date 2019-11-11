package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.CupomDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.TrocaDAO;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGeraCupomTroca implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Troca troca = (Troca) entidade;
		if(troca.getId() == null)
			return null;
		if(troca.getStatus() !=null) {
			if(troca.getStatus().getId() == 9) {
				troca.setAprova(true);
				StatusPedido s = troca.getStatus();
				IDAO d = new TrocaDAO();
				Resultado re = d.consultarById(troca);
				Troca t = (Troca) re.getEntidade();
				troca.setStatus(s);
				troca.setCupom(t.getCupom());
				return null;
			}
		}
		IDAO dao = new CupomDAO();
		StatusPedido status = new StatusPedido();
		troca.setStatus(status);
		if(troca.getAprova()) {
			Cupom cupom = troca.getCupom();
			cupom.setValor(troca.getValor().toString());
			cupom.setTroca(true);
			cupom.setPromocional(false);
			cupom.setExpirado(false);
			Resultado r = dao.salvar(cupom);
			troca.setCupom((Cupom) r.getEntidade());
			troca.getStatus().setId((long) 7);
		}else {
			troca.getStatus().setId((long) 8);
		}
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
