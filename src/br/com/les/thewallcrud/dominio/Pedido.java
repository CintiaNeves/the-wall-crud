package br.com.les.thewallcrud.dominio;

import java.util.List;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Pedido extends EntidadeDominio{
	
	private String numero;
	private List<ItemPedido> itens;
	private Frete frete;
	private Cliente cliente;
	private String data;
	private Double total;
	private Double desconto;
	private String observacao;
	private List<FormaPagamento> formasPagamento;
	private Endereco endereco;
	private Boolean salvarEndereco = false;
	private StatusPedido status;
	private String pagamento;
	private Double subtotal;
	
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Boolean getSalvarEndereco() {
		return salvarEndereco;
	}
	public void setSalvarEndereco(Boolean salvarEndereco) {
		this.salvarEndereco = salvarEndereco;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}
	public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double valor) {
		this.total = valor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	public Frete getFrete() {
		return frete;
	}
	public void setFrete(Frete frete) {
		this.frete = frete;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
