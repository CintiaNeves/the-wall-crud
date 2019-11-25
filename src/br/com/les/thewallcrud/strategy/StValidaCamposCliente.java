package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaCamposCliente implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		StringBuilder mensagem = new StringBuilder();
		IStrategy strategy = new StValidaCamposCartao();
		if(cliente.getNome() == null || (cliente.getNome().trim().equals(""))) {
			mensagem.append("Nome é um campo obrigatório.\n");
		}
		if(cliente.getCpf() == null || (cliente.getCpf().trim().equals(""))) {
			mensagem.append("CPF é um campo obrigatório.\n");
		}else if(cliente.getCpf().trim().length() != 11) {
			mensagem.append("CPF inváido.\n");
		}
		if(cliente.getGenero().getId() == 0) {
			mensagem.append("Gênero é um campo obrigatório.\n");
		}
		if(cliente.getDataNascimento() == null || cliente.getDataNascimento().trim().equals("")) {
			mensagem.append("Data de nascimento é um campo obrigatório.\n");
		}
		if(cliente.getTelefones().get(0).getDdd() == "") {
			mensagem.append("Telefone é um campo obrigatório.\n");	
		}else if(cliente.getTelefones().get(0).getDdd().concat(cliente.getTelefones().get(0).getNumero()).length() != 10) {
			mensagem.append("Telefone inválido.\n");
		}
		if(cliente.getTelefones().get(1).getDdd() == "") {
			mensagem.append("Celular é um campo obrigatório.\n");
		}else if(cliente.getTelefones().get(1).getDdd().concat(cliente.getTelefones().get(1).getNumero()).length() != 11) {
			mensagem.append("Celular inválido.\n");
		}
		
		mensagem.append(strategy.processar(entidade));
		strategy = new StValidaCamposEndereco();
		mensagem.append(strategy.processar(entidade));
		
		return mensagem.toString();
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
