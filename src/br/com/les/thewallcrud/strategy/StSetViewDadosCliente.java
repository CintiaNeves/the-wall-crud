package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.BandeiraDAO;
import br.com.les.thewallcrud.dao.CartaoDAO;
import br.com.les.thewallcrud.dao.CidadeDAO;
import br.com.les.thewallcrud.dao.EnderecoDAO;
import br.com.les.thewallcrud.dao.EstadoDAO;
import br.com.les.thewallcrud.dao.GeneroDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.PaisDAO;
import br.com.les.thewallcrud.dao.TelefoneDAO;
import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.dominio.Telefone;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewDadosCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		Cliente cliente = (Cliente) resultado.getEntidade();
		
		IDAO dao = new GeneroDAO();
		Resultado r = dao.consultarById(cliente.getGenero());
		Genero genero = (Genero) r.getEntidade();
		dao = new CartaoDAO();
		r = dao.consultar(cliente);
		List<EntidadeDominio> entidadeCartoes = r.getListEntidade();
		List<Cartao> cartoes = new ArrayList<>();
		dao = new TelefoneDAO();
		r = dao.consultarById(cliente);
		List<EntidadeDominio> entidadeTelefones = r.getListEntidade();
		List<Telefone> telefones = new ArrayList<>();
		dao = new EnderecoDAO();
		r = dao.consultar(cliente);
		List<EntidadeDominio> entidadeEnderecos = r.getListEntidade();
		List<Endereco> enderecos = new ArrayList<>();
		
		for(EntidadeDominio e : entidadeCartoes) {
			Cartao c = (Cartao) e;
			dao = new BandeiraDAO();
			r = dao.consultarById(c);
			Bandeira bandeira = (Bandeira) r.getEntidade();
			c.setBandeira(bandeira);
			cartoes.add(c);
		}
		
		for(EntidadeDominio e : entidadeEnderecos) {
			Endereco end = (Endereco) e;
			dao = new PaisDAO();
			r = dao.consultarById(end);
			Pais pais = (Pais) r.getEntidade();
			dao = new EstadoDAO();
			r = dao.consultarById(end);
			Estado estado = (Estado) r.getEntidade();
			dao = new CidadeDAO();
			r = dao.consultarById(end);
			Cidade cidade = (Cidade) r.getEntidade();
			estado.setCidade(cidade);
			pais.setEstado(estado);
			end.setPais(pais);
			enderecos.add(end);
		}
		
	
		
		for(EntidadeDominio e : entidadeTelefones) {
			Telefone t = (Telefone) e;
			telefones.add(t);
		}
		cliente.setGenero(genero);
		cliente.setCartoes(cartoes);
		cliente.setTelefones(telefones);
		cliente.setEnderecos(enderecos);
		
		IStrategy combos = new StCarregaCombos();
		combos.processar(resultado);
		
		return resultado;
	}

}
