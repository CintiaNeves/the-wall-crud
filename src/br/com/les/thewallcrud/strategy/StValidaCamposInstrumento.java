package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaCamposInstrumento implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Instrumento instrumento = (Instrumento) entidade;

			StringBuilder mensagem = new StringBuilder();
			if (instrumento.getDescricao() == null || instrumento.getDescricao().trim().equals(""))
				mensagem.append("Descrição é um campo obrigatório!\n");
			if (instrumento.getMarca() == null || instrumento.getMarca().trim().equals(""))
				mensagem.append("Marca é um campo obrigatório!\n");
			if (instrumento.getModelo() == null || instrumento.getModelo().trim().equals(""))
				mensagem.append("Modelo é um campo obrigatório!\n");
			if (instrumento.getCor() == null || instrumento.getCor().trim().equals(""))
				mensagem.append("Cor é um campo obrigatório!\n");
			if (instrumento.getGrupoPrecificacao().getId() == null)
				mensagem.append("Grupo de precificação é um campo obrigatório!\n");
			if (instrumento.getCategoria().getId() == null)
				mensagem.append("Categoria é um campo obrigatório!\n");
			if (instrumento.getCategoria().getSubcategoria().getId() == null)
				mensagem.append("Subcategoria é um campo obrigatório!\n");
			if (instrumento.getEspecificacoes() == null || instrumento.getEspecificacoes().trim().equals(""))
				mensagem.append("Obrigatório preenchimento dos detalhes do produto!\n");
			return mensagem.toString();

	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
