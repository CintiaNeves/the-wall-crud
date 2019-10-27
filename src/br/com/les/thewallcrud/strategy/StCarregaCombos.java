package br.com.les.thewallcrud.strategy;

import java.util.List;

import br.com.les.thewallcrud.dao.BandeiraDAO;
import br.com.les.thewallcrud.dao.CidadeDAO;
import br.com.les.thewallcrud.dao.EstadoDAO;
import br.com.les.thewallcrud.dao.GeneroDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.PaisDAO;
import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCarregaCombos implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Resultado r = new Resultado();
		IDAO dao = new GeneroDAO();
		r = dao.consultar(new Genero());
		List<EntidadeDominio> generos = r.getListEntidade();
		dao = new BandeiraDAO();
		r = dao.consultar(new Bandeira());
		List<EntidadeDominio> bandeiras = r.getListEntidade();
		dao = new PaisDAO();
		r = dao.consultar(new Pais());
		List<EntidadeDominio> paises = r.getListEntidade();
		dao = new EstadoDAO();
		r = dao.consultar(new Estado());
		List<EntidadeDominio> estados = r.getListEntidade();
		dao = new CidadeDAO();
		r = dao.consultar(new Cidade());
		List<EntidadeDominio> cidades = r.getListEntidade();
		
		resultado.setMapEntidade("GENEROS", generos);
		resultado.setMapEntidade("BANDEIRAS", bandeiras);
		resultado.setMapEntidade("PAISES", paises);
		resultado.setMapEntidade("ESTADOS", estados);
		resultado.setMapEntidade("CIDADES", cidades);
		return resultado;
	}

}
