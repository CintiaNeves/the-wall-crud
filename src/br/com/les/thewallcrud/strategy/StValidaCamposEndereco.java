package br.com.les.thewallcrud.strategy;

import java.util.List;

import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaCamposEndereco implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		List<Endereco> enderecos = cliente.getEnderecos();
		StringBuilder mensagem = new StringBuilder();
		
		for(Endereco e : enderecos) {
			if(!e.getCobranca()) {
				if(e.getAlias() == null || e.getAlias().trim().equals("")) {
					mensagem.append("Endereço de Entrega: Campo apelido não pode ficar vazio.\n");
				}
			}
			if(e.getTpResidencia() == null || e.getTpResidencia().trim().equals("")) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Campo tipo residência não pode ficar vazio.\n");
				else 
					mensagem.append("Endereço de Entrega: Campo tipo residência não pode ficar vazio.\n");
			}
			if(e.getTpLogradouro() == null || e.getTpLogradouro().trim().equals("")) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Campo tipo logradouro não pode ficar vazio.\n");
				else 
					mensagem.append("Endereço de Entrega: Campo tipo logradouro não pode ficar vazio.\n");
			}
			if(e.getLogradouro() == null || e.getLogradouro().trim().equals("")) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Campo logradouro não pode ficar vazio.\n");
				else 
					mensagem.append("Endereço de Entrega: Campo logradouro não pode ficar vazio.\n");
			}
			if(e.getNumero() == null || e.getNumero().trim().equals("")) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Campo número não pode ficar vazio.\n");
				else 
					mensagem.append("Endereço de Entrega: Campo número não pode ficar vazio.\n");
			}
			if(e.getCep() == null || e.getCep().trim().equals("")) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Campo CEP não pode ficar vazio.\n");
				else 
					mensagem.append("Endereço de Entrega: Campo CEP não pode ficar vazio.\n");
			}else if(e.getCep().length() != 8) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: CEP inválido.\n");
				else 
					mensagem.append("Endereço de Entrega: CEP inválido.\n");
			}
			if(e.getBairro() == null || e.getBairro().trim().equals("")) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Campo bairro não pode ficar vazio.\n");
				else 
					mensagem.append("Endereço de Entrega: Campo bairro não pode ficar vazio.\n");
			}
			if(e.getPais().getId() == 0) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Necessário selecionar um país.\n");
				else 
					mensagem.append("Endereço de Entrega: Necessário selecionar um país.\n");
			}
			if(e.getPais().getEstado().getId() == 0) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Necessário selecionar um estado..\n");
				else 
					mensagem.append("Endereço de Entrega: Necessário selecionar um estado.\n");
			}
			if(e.getPais().getEstado().getCidade().getId() == 0) {
				if(e.getCobranca()) 
					mensagem.append("Endereço de Cobrança: Necessário selecionar uma cidade.\n");
				else 
					mensagem.append("Endereço de Entrega: Necessário selecionar uma cidade.\n");
			}
		}
		return mensagem.toString();
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
