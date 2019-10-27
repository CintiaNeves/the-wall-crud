package br.com.les.thewallcrud.strategy;

import java.time.LocalDateTime;

import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCriaCapaPedido implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Pedido pedido = (Pedido) entidade;
		IStrategy st = new StGeraCodigoPedido();
		st.processar(entidade);
		LocalDateTime now = LocalDateTime.now();
		String data = now.toString();
		pedido.setData(data);
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
