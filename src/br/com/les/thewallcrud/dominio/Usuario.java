package br.com.les.thewallcrud.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Usuario extends EntidadeDominio{
	
	private String nome;
	private String senha;
	private String confSenha;
	private Boolean administrador;
	private Boolean reset;
	
	public Usuario() {
		this.reset = false;
		this.administrador = false;
	}
	public Boolean getReset() {
		return reset;
	}
	public void setReset(Boolean reset) {
		this.reset = reset;
	}
	@JsonIgnore
	public Boolean getAdministrador() {
		return administrador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfSenha() {
		return confSenha;
	}
	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}
	public Boolean isAdministrador() {
		return administrador;
	}
	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}
	
	

}
