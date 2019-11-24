package br.com.les.thewallcrud.strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import br.com.les.thewallcrud.dao.CupomDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGeraCupomSaldo implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		String codigo = "SLDPC";
		Calendar calendar = GregorianCalendar.getInstance();
		Integer ano = calendar.get(Calendar.YEAR);
		Random random = new Random();
		Integer numero = random.nextInt() * 10000;
		codigo = codigo.concat(ano.toString().concat(numero.toString()));
		codigo = codigo.replace("-", "");
		
		IDAO dao = new CupomDAO();
		Cupom cupom = new Cupom();
		cupom.setCodigo(codigo);
		cupom.setValor(pedido.getSaldoTroca().toString());
		cupom.setTroca(true);
		cupom.setPromocional(false);
		cupom.setExpirado(false);
		cupom.setIdCliente(pedido.getCliente().getId());
		dao.salvar(cupom);
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
