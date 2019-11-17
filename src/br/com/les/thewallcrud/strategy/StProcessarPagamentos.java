package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.PedidoDAO;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StProcessarPagamentos implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Pedido pedido = (Pedido) entidade;
		IDAO dao = new PedidoDAO();
		Resultado resultado = dao.consultar(pedido);
		List<Pedido> listProcessando = new ArrayList<>();
		
		
		for(EntidadeDominio e : resultado.getListEntidade()) {
			Pedido p = (Pedido) e;
			if(p.getStatus().getId() == 1) {
				listProcessando.add(p);
			}
		}
		IStrategy  baixaEstoque = new StBaixaEstoque();
		
		for(Pedido p : listProcessando) {
			Random random = new Random();
			Integer aprovado = random.nextInt(8) + 1;
			if(aprovado < 8) {
				p.getStatus().setId((long) 2);
				
			}else {
				p.getStatus().setId((long) 3);
			}
			baixaEstoque.processar(p);
			dao.alterar(p);
			
		}
		return null;
		
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
