package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Endereco extends EntidadeDominio{
	
	private Boolean cobranca;
	private String alias;
	private String tpResidencia;
	private String tpLogradouro;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private String observacoes;
	private Pais pais;
	
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public Boolean getCobranca() {
		return cobranca;
	}
	public void setCobranca(Boolean cobranca) {
		this.cobranca = cobranca;
	}
	public String getTpResidencia() {
		return tpResidencia;
	}
	public void setTpResidencia(String tpResidencia) {
		this.tpResidencia = tpResidencia;
	}
	public String getTpLogradouro() {
		return tpLogradouro;
	}
	public void setTpLogradouro(String tpLogradouro) {
		this.tpLogradouro = tpLogradouro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}	
	
	

}
