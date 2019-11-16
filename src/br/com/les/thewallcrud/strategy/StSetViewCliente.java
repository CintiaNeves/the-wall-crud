package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.dominio.Telefone;
import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		Usuario usuario = (Usuario) resultado.getEntidade();
		
		if(resultado.getErro() || usuario.getReset())
			return resultado;
		
		IDAO dao = new ClienteDAO();
		Resultado r = new Resultado();
		Cliente cliente = new Cliente();
		cliente.setUsuario(usuario);
		r = dao.consultar(cliente);
		
		if (r.getEntidade() == null) {
			Genero genero = new Genero();
			Bandeira bandeira = new Bandeira();
			Cartao cartao = new Cartao();
			Carrinho carrinho = new Carrinho();
			cliente.setGenero(genero);
			cliente.setUsuario(usuario);
			cartao.setBandeira(bandeira);
			cliente.setCarrinho(carrinho);
			List<Cartao> cartoes = new ArrayList<Cartao>();
			cartoes.add(cartao);
			List<Telefone> telefones = new ArrayList<Telefone>();
			telefones.add(new Telefone());
			telefones.add(new Telefone());
			cliente.setCartoes(cartoes);
			cliente.setTelefones(telefones);
			resultado.clear();
			resultado.setEntidade(cliente);
			return resultado;
		}
		cliente = (Cliente) r.getEntidade();
		cliente.setUsuario(usuario);
		resultado.clear();
		resultado.setEntidade(r.getEntidade());
		return resultado;
	}

}
