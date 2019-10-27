package br.com.les.thewallcrud.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Resultado {

	private List<EntidadeDominio> listEntidade;
	private boolean erro;
	private String mensagem;
	private Map<String, List<EntidadeDominio>> mapEntidade;
	
	
	
	public Map<String, List<EntidadeDominio>> getMapEntidade() {
		return mapEntidade;
	}

	public void setMapEntidade(String chave, List<EntidadeDominio> entidades) {
		
		if(mapEntidade == null) {
			mapEntidade = new HashMap<String, List<EntidadeDominio>>();
			this.mapEntidade.put(chave, entidades);
		}else {
			this.mapEntidade.put(chave, entidades);
		}
	}

	public void setErro(String mensagem) {
		erro = true;
		this.mensagem = mensagem;
	}

	public void setSucesso(String mensagem) {
		erro = false;
		this.mensagem = mensagem;
	}
	
	public boolean getErro() {
		return erro;
	}
	public String getMensagem() {
		return mensagem;
	}
	
	public List<EntidadeDominio> getListEntidade() {
		return listEntidade;
	}
	public void setListEntidade(List<EntidadeDominio> listEntidade) {
		this.listEntidade = listEntidade;
	}
	public EntidadeDominio getEntidade() {
		return listEntidade.get(0);
	}
	public void setEntidade(EntidadeDominio entidade) {
		if(listEntidade == null)
			listEntidade = new ArrayList<>();
		this.listEntidade.add(entidade);
	}
	public void clear() {
		if(listEntidade != null)
			listEntidade.clear();
	}
}
