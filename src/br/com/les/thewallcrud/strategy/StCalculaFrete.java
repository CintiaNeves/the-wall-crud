package br.com.les.thewallcrud.strategy;

import java.text.DecimalFormat;
import java.util.Random;

import br.com.les.thewallcrud.dao.FreteDAO;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Frete;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCalculaFrete implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Pedido) {
			return null;
		}
		Carrinho carrinho = (Carrinho) entidade;
		Boolean comtemCep = carrinho.getFrete().getCep() != null && (!carrinho.getFrete().getCep().trim().equals("")) ? true : false;
		if (comtemCep) {
			Random random = new Random();
			Double frete = random.nextDouble() * 300;
			if (frete < 100)
				frete += 100;
			carrinho.getFrete().setValorFrete(frete);
			DecimalFormat df = new DecimalFormat("#,###.00");
			String stfrete = "R$ ";
			stfrete += df.format(frete);
			Frete f = new Frete();
			f.setValorFrete(frete);
			f.setValor(stfrete);
			f.setIdCarrinho(carrinho.getId());
			FreteDAO dao = new FreteDAO();
			carrinho.setFrete((Frete)dao.salvar(f).getEntidade());
		}

		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
