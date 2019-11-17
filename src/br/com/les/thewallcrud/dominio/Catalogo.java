package br.com.les.thewallcrud.dominio;

import java.util.List;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Catalogo extends EntidadeDominio{
	
	List<Instrumento> instumentos;

	public List<Instrumento> getInstumentos() {
		return instumentos;
	}

	public void setInstumentos(List<Instrumento> instumentos) {
		this.instumentos = instumentos;
	}
	
}
