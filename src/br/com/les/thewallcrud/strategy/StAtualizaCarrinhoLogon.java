package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StAtualizaCarrinhoLogon implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		
		Cliente cliente = (Cliente) resultado.getEntidade();
		List<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();
		IDAO dao = new InstrumentoDAO();
		Double total = 0.0;

		if (cliente.getCarrinho().getItens() != null && cliente.getCarrinho().getItens().size() != 0) {
			for (ItemCarrinho i : cliente.getCarrinho().getItens()) {
				Resultado r = new Resultado();
				r = dao.consultarById(i.getInstrumento());
				Instrumento instrumento = (Instrumento) r.getEntidade();
				i.setInstrumento(instrumento);
				i.setTotal(i.getInstrumento().getValorVenda() * i.getQuantidade());
				total += i.getTotal();
				itens.add(i);

			}
		}

		cliente.getCarrinho().setItens(itens);
		if(cliente.getCarrinho().getItens().size() != 0)
			cliente.getCarrinho().setQuantidadeItem(itens.size());
		cliente.getCarrinho().setValorTotal(total);
		resultado.clear();
		resultado.setEntidade(cliente);

		return resultado;
	}

}
