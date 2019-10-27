package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCarregaCartao implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {

		Pedido pedido = (Pedido) resultado.getEntidade();

		List<EntidadeDominio> cartoes = new ArrayList<>();
		List<EntidadeDominio> enderecos = new ArrayList<>();

		for (EntidadeDominio e : pedido.getCliente().getCartoes()) {
			cartoes.add((EntidadeDominio) e);
		}

		for (EntidadeDominio e : pedido.getCliente().getEnderecos()) {
			enderecos.add((EntidadeDominio) e);
		}
		resultado.setMapEntidade("CARTOES", cartoes);
		resultado.setMapEntidade("ENDERECOS", enderecos);

		return resultado;
	}

}
