package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.FormaPagamento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaFormaPagamento implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		
		List<ItemCarrinho> itens = pedido.getCliente().getCarrinho().getItens();
		Double totalCarrinho = 0.0;
		Double desconto = 0.0;
		Integer numCartoes = 0;
		
		for (ItemCarrinho i : itens) {
			i.setTotal(i.getInstrumento().getValorVenda() * i.getQuantidade());
			totalCarrinho += i.getTotal();
		}
		pedido.getCliente().getCarrinho().setQuantidadeItem(itens.size());
		pedido.getCliente().getCarrinho().setValorTotal(totalCarrinho);
		
		
		for(FormaPagamento f : pedido.getFormasPagamento()) {
			if(f.getCupons() != null) {
				for(Cupom cp : f.getCupons()) {
					desconto += Double.parseDouble(cp.getValor());
				}
			}else {
				numCartoes +=1;
			}
			
		}
		pedido.setDesconto(desconto);
		pedido.setSubtotal(pedido.getCliente().getCarrinho().getValorTotal());
		pedido.setTotal(pedido.getSubtotal() + pedido.getFrete().getValorFrete() - pedido.getDesconto());
		Double valorDevido = pedido.getTotal();
		List<FormaPagamento> pgtoValoresFixos = new ArrayList<>();
		List<FormaPagamento> pgtoAutomatico = new ArrayList<>();
		
		for(FormaPagamento f : pedido.getFormasPagamento()) {
			if(f.getCartao() != null) {
				if(f.getValor() == null || f.getValor() == 0) {
					pgtoAutomatico.add(f);
					
				}else if(f.getValor() != 0 && f.getValor() != null) {
					pgtoValoresFixos.add(f);
					numCartoes -=1; 
				}
			}			
		}
		
		List<FormaPagamento> pagamentosValidos = new ArrayList<>();
		
		for(FormaPagamento f : pgtoValoresFixos) {
			valorDevido -= f.getValor();
			pagamentosValidos.add(f);
		}
		
		for(FormaPagamento f : pgtoAutomatico) {
			f.setValor(valorDevido / numCartoes);
			pagamentosValidos.add(f);
		}
		
		for(FormaPagamento f : pedido.getFormasPagamento()) {
			if(f.getCupons() != null) {
				pagamentosValidos.add(f);
			}
		}
		pedido.setFormasPagamento(pagamentosValidos);
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
