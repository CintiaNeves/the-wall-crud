package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.CarrinhoDAO;
import br.com.les.thewallcrud.dao.CartaoDAO;
import br.com.les.thewallcrud.dao.EnderecoDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.TelefoneDAO;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGravaDependenciasCliente implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		if(resultado.getErro())
			return resultado;
		
		Cliente cliente = (Cliente) resultado.getEntidade();
		IDAO dao = new TelefoneDAO();
		dao.salvar(cliente);
		dao = new CartaoDAO();
		dao.salvar(cliente);
		dao = new EnderecoDAO();
		dao.salvar(cliente);
		dao = new CarrinhoDAO();
		dao.salvar(cliente);
		
		return resultado;
	}

}
