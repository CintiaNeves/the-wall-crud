package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class ItemTroca extends EntidadeDominio{
	
	private Instrumento instrumento;
	private Integer quantidade;
	private Double valor;
	private Boolean entradaOk;
	private Long idTroca;

	public Long getIdTroca() {
		return idTroca;
	}
	public void setIdTroca(Long idTroca) {
		this.idTroca = idTroca;
	}
	public Boolean getEntradaOk() {
		return entradaOk;
	}
	public void setEntradaOk(Boolean entradaOk) {
		this.entradaOk = entradaOk;
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
