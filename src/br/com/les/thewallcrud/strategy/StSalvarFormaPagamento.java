package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.FormaPagamentoDAO;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.FormaPagamento;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSalvarFormaPagamento implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Pedido pedido = (Pedido) resultado.getEntidade();
		FormaPagamentoDAO dao = new FormaPagamentoDAO();
		
		for(FormaPagamento f : pedido.getFormasPagamento()) {
			if(f.getCupons()!= null) {
				for(Cupom c : f.getCupons()) {
					FormaPagamento fmpgto = new FormaPagamento();
					List<Cupom> cupons = new ArrayList<>();
					cupons.add(c);
					fmpgto.setCupons(cupons);
					fmpgto.setIdPedido(pedido.getId());
					dao.salvar(fmpgto);	
				}
			}else {
				f.setIdPedido(pedido.getId());
				dao.salvar(f);
			}
			
		}
		
		return resultado;
	}

}
