package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.EstoqueDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.ItemPedidoDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.dominio.ItemPedido;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StBaixaEstoque implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		Pedido pedido = (Pedido) entidade;
		IDAO dao = new ItemPedidoDAO();
		Resultado resultado = dao.consultarById(pedido);
		dao = new EstoqueDAO();
		
		for(EntidadeDominio e : resultado.getListEntidade()) {
			ItemPedido itemPedido = (ItemPedido) e;
			Instrumento instrumento = new Instrumento();
			instrumento.setId(itemPedido.getInstrumento().getId());
			ItemEstoque ie = new ItemEstoque();
			ie.setInstrumento(instrumento);
			resultado = dao.consultar(ie);
			ie = (ItemEstoque) resultado.getEntidade();
			Integer quantidade = ie.getQuantidade();
			Integer quantidadeReservada = ie.getQuantidadeReservada();
			
			if(pedido.getStatus().getId() == 2) {
				quantidade -= itemPedido.getQuantidade();
			}
			quantidadeReservada -= itemPedido.getQuantidade();
			ie.setQuantidade(quantidade);
			ie.setQuantidadeReservada(quantidadeReservada);
			dao.alterar(ie);
		}
		
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
