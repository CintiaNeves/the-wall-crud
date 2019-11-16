package br.com.les.thewallcrud.strategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		Date dataFormatada = null;
		try {
			dataFormatada = formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		formato.applyPattern("dd/MM/yyyy");
		pedido.setData(formato.format(dataFormatada));
		
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
