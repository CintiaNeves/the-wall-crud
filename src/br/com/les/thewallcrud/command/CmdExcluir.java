package br.com.les.thewallcrud.command;

import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class CmdExcluir extends AbstractCommand{

	@Override
	public Resultado executar(EntidadeDominio entidade) {
		
		return fachada.excluir(entidade);
	}

}
