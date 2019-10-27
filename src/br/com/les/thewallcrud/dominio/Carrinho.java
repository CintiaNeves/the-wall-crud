package br.com.les.thewallcrud.dominio;

import java.util.List;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Carrinho extends EntidadeDominio{
	
	private List<ItemCarrinho> itens;
	private Integer quantidadeItem;
	private Double valorTotal;
	private Long idCliente;
	private Boolean checkout;
	private Frete frete;
	private List<Cupom> cupons;
	private Double desconto;
	private Boolean retornoJson;
		
	public Frete getFrete() {
		return frete;
	}
	public void setFrete(Frete frete) {
		this.frete = frete;
	}
	public List<Cupom> getCupons() {
		return cupons;
	}
	public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Boolean getRetornoJson() {
		return retornoJson;
	}
	public void setRetornoJson(Boolean retornoJson) {
		this.retornoJson = retornoJson;
	}
	public Boolean getCheckout() {
		return checkout;
	}
	public void setCheckout(Boolean checkout) {
		this.checkout = checkout;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public List<ItemCarrinho> getItens() {
		return itens;
	}
	public void setItens(List<ItemCarrinho> itens) {
		this.itens = itens;
	}
	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}
	public void setQuantidadeItem(Integer quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
		
}
