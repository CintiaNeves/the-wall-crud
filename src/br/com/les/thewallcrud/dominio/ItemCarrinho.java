package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class ItemCarrinho extends EntidadeDominio{

	private Instrumento instrumento;
	private Integer quantidade;
	private Double total;
	private Boolean expirado;
	private Long idCarrinho;
	
	
	public Long getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public Boolean getExpirado() {
		return expirado;
	}
	public void setExpirado(Boolean expirado) {
		this.expirado = expirado;
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
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
