package br.com.les.thewallcrud.dominio;

import java.util.List;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Troca extends EntidadeDominio{

	private String numeroPedidoTroca;
	private Long idPedidoCompra;
	private List<ItemTroca> itens;
	private String data;
	private String numPedidoCompra;
	private String observacao;
	private String dataCompra;	
	private StatusPedido status;
	private Boolean flag;
	private Long idCliente;
	private Cupom cupom;
	private Cliente cliente;
	private Boolean admin;
	private Boolean aprova;
	private Double valor;
		
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Boolean getAprova() {
		return aprova;
	}
	public void setAprova(Boolean aprova) {
		this.aprova = aprova;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cupom getCupom() {
		return cupom;
	}
	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public Troca() {
		this.flag = false;
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getNumPedidoCompra() {
		return numPedidoCompra;
	}
	public void setNumPedidoCompra(String numPedidoCompra) {
		this.numPedidoCompra = numPedidoCompra;
	}
	public String getNumeroPedidoTroca() {
		return numeroPedidoTroca;
	}
	public void setNumeroPedidoTroca(String numeroPedidoTroca) {
		this.numeroPedidoTroca = numeroPedidoTroca;
	}
	
	public Long getIdPedidoCompra() {
		return idPedidoCompra;
	}
	public void setIdPedidoCompra(Long idPedidoCompra) {
		this.idPedidoCompra = idPedidoCompra;
	}
	public List<ItemTroca> getItens() {
		return itens;
	}
	public void setItens(List<ItemTroca> itens) {
		this.itens = itens;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	

}
