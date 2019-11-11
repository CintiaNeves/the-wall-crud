package br.com.les.thewallcrud.dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Relatorio extends EntidadeDominio {

	private Set<String> datas;
	private Set<String> colunas;
	private Map<String, String> dados;
	private String fato;
	
	public String getFato() {
		return fato;
	}

	public void setFato(String fato) {
		this.fato = fato;
	}

	public Relatorio() {
		this.datas = new HashSet<>();
		this.colunas = new HashSet<>();
		this.dados = new HashMap<>();
	}
	
	public Set<String> getDatas() {
		return datas;
	}

	public void setDatas(Set<String> datas) {
		this.datas = datas;
	}

	public Set<String> getColunas() {
		return colunas;
	}

	public void setColunas(Set<String> colunas) {
		this.colunas = colunas;
	}

	public Map<String, String> getDados() {
		return dados;
	}

	public void setDados(Map<String, String> dados) {
		this.dados = dados;
	}
}
