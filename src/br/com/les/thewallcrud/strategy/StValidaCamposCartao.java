package br.com.les.thewallcrud.strategy;

import java.util.List;

import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaCamposCartao implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		List<Cartao> cartoes = cliente.getCartoes();
		StringBuilder mensagem = new StringBuilder();
		
		for(Cartao c : cartoes) {
			if(c.getBandeira().getId() == 0) {
				mensagem.append("Necessário selecionar uma bandeira para o cartão.\n");
			}
			if(c.getNumero().trim().equals("")) {
				mensagem.append("Campo número do cartão não pode ser vazio.\n");
			}else if(c.getNumero().trim().length() != 16) {
				mensagem.append("Número do cartão inválido.\n");
			}
			if(c.getNomeImpresso().trim().equals("")) {
				mensagem.append("Campo nome do cartão não pode ser vazio.\n");
			}
			if(c.getCodSeguranca().trim().equals("")) {
				mensagem.append("Campo código de segurança não pode ser vazio.\n");
			}else if(c.getCodSeguranca().trim().length() != 3) {
				mensagem.append("Código de segurança inválido.\n");
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
