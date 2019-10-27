package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.CupomDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StValidaCupom implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Pedido) {
			return null;
		}
		StringBuilder mensagem = new StringBuilder();
		Carrinho carrinho = (Carrinho) entidade;
		Cupom cupom = carrinho.getCupons().get(0);
		if (cupom.getCodigo() != null && (!cupom.getCodigo().trim().equals(""))) {
			IDAO dao = new CupomDAO();
			Resultado resultado = dao.consultar(cupom);
			cupom = (Cupom) resultado.getEntidade();

			if (cupom.getId() == null) {
				mensagem.append("Nenhum cupom válido encontrado, confira o código e digite novamente.\n");
			}else {
				cupom.setIdCarrinho(carrinho.getId());
				resultado = dao.alterar(cupom);
			}
		}

		return mensagem.toString();
	}

	@Override
	public Resultado processar(Resultado resultado) {
		// TODO Auto-generated method stub
		return null;
	}

}
