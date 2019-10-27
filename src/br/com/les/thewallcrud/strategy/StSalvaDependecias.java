package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.CartaoDAO;
import br.com.les.thewallcrud.dao.EnderecoDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.FormaPagamento;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSalvaDependecias implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Pedido pedido = (Pedido) resultado.getEntidade();
		IDAO dao;
		if(pedido.getSalvarEndereco() == true) {
			dao = new EnderecoDAO();
			List<Endereco> enderecos = new ArrayList<>();
			enderecos.add(pedido.getEndereco());
			pedido.getCliente().setEnderecos(enderecos);
			dao.salvar(pedido.getCliente());
		}
		for(FormaPagamento f : pedido.getFormasPagamento()) {
			if(f.getNovoCartao()) {
				dao = new CartaoDAO();
				List<Cartao> cartoes = new ArrayList<>();
				cartoes.add(f.getCartao());
				pedido.getCliente().setCartoes(cartoes);
				dao.salvar(pedido.getCliente());
			}
		}
		return resultado;
	}

}
