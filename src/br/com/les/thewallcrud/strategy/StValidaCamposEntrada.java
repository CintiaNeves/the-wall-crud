package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaCamposEntrada implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Entrada entrada = (Entrada) entidade;
		StringBuilder mensagem = new StringBuilder();

		if (entrada.getFornecedor().getCnpj() == null || entrada.getFornecedor().getCnpj().trim().equals(""))
			mensagem.append("CNPJ é um campo obrigatório!\n");
		if (entrada.getNota() == null || entrada.getNota().trim().equals(""))
			mensagem.append("Número da nota é um campo obrigatório!\n");
		
		if (entrada.getItens().size() == 0) {
			mensagem.append("Necessária a inclusão de pelo menos um item para entrada da nota.\n");
		}else {
			for (ItemEstoque item : entrada.getItens()) {
				if(item.getInstrumento().getCodigo() == null) {
					mensagem.append("Código é um campo obrigatório!\n");
				}
				if(item.getQuantidade() == null || item.getQuantidade() <= 0) {
					mensagem.append("Quantidade é um campo obrigatório e não pode ser menor ou igual a zero!\n");
				}
				if(item.getCusto() == null || item.getCusto() <= 0) {
					mensagem.append("Custo é um campo obrigatório e não pode ser menor ou igual a zero!\n");
				}	
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
