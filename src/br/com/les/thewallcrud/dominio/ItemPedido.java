package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class ItemPedido extends EntidadeDominio{
	
	private Instrumento instrumento;
	private Integer quantidade;
	private Long idPedido;
	private Double totalItem;
			
	public Double getTotalItem() {
		return totalItem;
	}
	public void setTotalItem(Double totalItem) {
		this.totalItem = totalItem;
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Instrumento getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
