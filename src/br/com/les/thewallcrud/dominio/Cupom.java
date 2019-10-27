package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Cupom extends EntidadeDominio{
	
	private String codigo;
	private Boolean troca;
	private Boolean promocional;
	private Boolean expirado;
	private String valor;
	private Long idCarrinho;
	private Long idPedido;
		
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Long getIdCarrinho() {
		return idCarrinho;
	}
	public void setIdCarrinho(Long idCarrinho) {
		this.idCarrinho = idCarrinho;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Boolean getTroca() {
		return troca;
	}
	public void setTroca(Boolean troca) {
		this.troca = troca;
	}
	public Boolean getPromocional() {
		return promocional;
	}
	public void setPromocional(Boolean promocional) {
		this.promocional = promocional;
	}
	public Boolean getExpirado() {
		return expirado;
	}
	public void setExpirado(Boolean expirado) {
		this.expirado = expirado;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
}
