package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Frete extends EntidadeDominio{
	
	private String cep;
	private String valor;
	private Double valorFrete;
	private Long idCarrinho;
		
	public Double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Long getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	
	
	
}
