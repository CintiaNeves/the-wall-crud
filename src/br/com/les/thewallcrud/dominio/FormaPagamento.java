package br.com.les.thewallcrud.dominio;

import java.util.List;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class FormaPagamento extends EntidadeDominio{

	private Integer parcelas;
	private Cartao cartao;
	private List<Cupom> cupons;
	private Double valor;
	private Boolean novoCartao;
	private Long idPedido;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public FormaPagamento() {
		this.novoCartao = false;
	}
		
	public Boolean getNovoCartao() {
		return novoCartao;
	}
	public void setNovoCartao(Boolean novoCartao) {
		this.novoCartao = novoCartao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	public List<Cupom> getCupons() {
		return cupons;
	}
	public void setCupons(List<Cupom> cupons) {
		this.cupons = cupons;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	
	
}
