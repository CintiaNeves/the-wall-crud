package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StRemoveReserva implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		IDAO dao = new ItemCarrinhoDAO();
		Resultado r = new Resultado();
		List<ItemCarrinho> itensAtivos = new ArrayList<>();
		r = dao.consultar(new ItemCarrinho());
		//LocalDateTime now = LocalDateTime.now();
		
		
		if(r.getListEntidade().size() > 0) {
			for(EntidadeDominio e : resultado.getListEntidade()) {
				itensAtivos.add((ItemCarrinho) e);
			}
		}
		//for(ItemCarrinho i : itensAtivos) {
			
		//}
		return null;
	}

}
