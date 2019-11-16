package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.CidadeDAO;
import br.com.les.thewallcrud.dao.EnderecoDAO;
import br.com.les.thewallcrud.dao.EstadoDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.PaisDAO;
import br.com.les.thewallcrud.dao.StatusPedidoDAO;
import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemPedido;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewResumo implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Pedido pedido = (Pedido) resultado.getEntidade();
		IDAO dao;
		Cliente cliente = pedido.getCliente();
		cliente.setEnderecos(new ArrayList<Endereco>());
		dao = new EnderecoDAO();
		
		Resultado r = dao.consultar(cliente);
		List<Endereco> enderecos = new ArrayList<>();
		
		for(EntidadeDominio e : r.getListEntidade()) {
			enderecos.add((Endereco) e);
			if(pedido.getEndereco().getId() != null) {
				if(e.getId() == pedido.getEndereco().getId()) {
					pedido.setEndereco((Endereco)e);
				}
			}
		}
		
		for(Endereco e : enderecos) {
			if(e.getId() == pedido.getEndereco().getId()) {
				dao = new CidadeDAO();
				r = dao.consultarById(e);
				Cidade cidade = (Cidade) r.getEntidade();
				dao = new EstadoDAO();
				r = dao.consultarById(e);
				Estado estado = (Estado) r.getEntidade();
				dao = new PaisDAO();
				r = dao.consultarById(e);
				Pais pais = (Pais) r.getEntidade();
				estado.setCidade(cidade);
				pais.setEstado(estado);
				e.setPais(pais);
				cliente.getEnderecos().add(e);
			}
		}
		
		
		dao = new InstrumentoDAO();
		for(ItemPedido item : pedido.getItens()) {
			r = dao.consultarById(item.getInstrumento());
			item.setInstrumento((Instrumento) r.getEntidade());
			item.setTotalItem(item.getQuantidade() * item.getInstrumento().getValorVenda());
		}
		
		if(pedido.getSalvarEndereco()) {
			pedido.getEndereco().setId(enderecos.get(enderecos.size() - 1).getId());
			dao = new EnderecoDAO();
			r = dao.consultarById(pedido.getEndereco());
			Endereco e = (Endereco) r.getEntidade();
			dao = new CidadeDAO();
			r = dao.consultarById(e);
			Cidade cidade = (Cidade) r.getEntidade();
			dao = new EstadoDAO();
			r = dao.consultarById(e);
			Estado estado = (Estado) r.getEntidade();
			dao = new PaisDAO();
			r = dao.consultarById(e);
			Pais pais = (Pais) r.getEntidade();
			estado.setCidade(cidade);
			pais.setEstado(estado);
			e.setPais(pais);
			pedido.setEndereco(e);
		}
		
		
		dao = new StatusPedidoDAO();
		r = dao.consultarById(pedido.getStatus());
		pedido.setStatus((StatusPedido) r.getEntidade());
		pedido.setQtdCartoes(pedido.getFormasPagamento().size() - 1);
		return resultado;
	}

}
