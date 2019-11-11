package br.com.les.thewallcrud.strategy;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dao.BandeiraDAO;
import br.com.les.thewallcrud.dao.CartaoDAO;
import br.com.les.thewallcrud.dao.CidadeDAO;
import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.CupomDAO;
import br.com.les.thewallcrud.dao.EnderecoDAO;
import br.com.les.thewallcrud.dao.EstadoDAO;
import br.com.les.thewallcrud.dao.FreteDAO;
import br.com.les.thewallcrud.dao.GeneroDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.PaisDAO;
import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cartao;
import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.Frete;
import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCheckout implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {

		return null;
	}

	@Override
	public Resultado processar(Resultado resultado) {
		
		Carrinho carrinho = (Carrinho) resultado.getEntidade();
		Integer qtdItem = 0;
		if (carrinho.getCheckout()) {			
			IDAO dao = new InstrumentoDAO();
			Resultado r = new Resultado();
			
			Double totalCarrinho = 0d;
			for(ItemCarrinho item : carrinho.getItens()) {
				r = dao.consultarById(item);
				item.setInstrumento((Instrumento) r.getEntidade());
				item.setTotal(item.getInstrumento().getValorVenda() * item.getQuantidade());
				totalCarrinho += item.getTotal();
				carrinho.setQuantidadeItem(qtdItem += 1);
			}
			carrinho.setValorTotal(totalCarrinho); 
			
			Double desconto = 0.0;
			if(carrinho.getCupons() != null) {
				for(Cupom cupom : carrinho.getCupons()) {
					if(cupom.getCodigo() != null && (!cupom.getCodigo().trim().equals(""))) {
						dao = new CupomDAO();
						r = dao.consultar(cupom);
						cupom = (Cupom) r.getEntidade();
						desconto += Double.parseDouble(cupom.getValor());
					}
				}
			}
			carrinho.setDesconto(desconto);
			Cliente cliente = new Cliente();
			cliente.setId(carrinho.getIdCliente());
			dao = new ClienteDAO();
			r = dao.consultarById(cliente);
			cliente = (Cliente) r.getEntidade();
			dao = new GeneroDAO();
			r = dao.consultarById(cliente.getGenero());
			cliente.setGenero((Genero) r.getEntidade());
			List<Cartao> cartoes = new ArrayList<Cartao>();
			dao = new CartaoDAO();
			r = dao.consultar(cliente);

			for (EntidadeDominio e : r.getListEntidade()) {
				cartoes.add((Cartao) e);
			}
			dao = new BandeiraDAO();
			for (Cartao c : cartoes) {
				r = dao.consultarById(c);
				c.setBandeira((Bandeira) r.getEntidade());
			}
			
			List<Endereco> enderecos = new ArrayList<Endereco>();
			dao = new EnderecoDAO();
			r = dao.consultar(cliente);

			for (EntidadeDominio e : r.getListEntidade()) {
				Endereco endereco = (Endereco) e;
				dao = new PaisDAO();
				r = dao.consultarById(endereco);
				Pais pais = (Pais) r.getEntidade();
				dao = new EstadoDAO();
				r = dao.consultarById(endereco);
				Estado estado = (Estado) r.getEntidade();
				dao = new CidadeDAO();
				r = dao.consultarById(endereco);
				Cidade cidade = (Cidade) r.getEntidade();
				Endereco end = endereco;
				estado.setCidade(cidade);
				pais.setEstado(estado);
				end.setPais(pais);
				enderecos.add(end);
			}
			dao = new CupomDAO();
			r = dao.consultar(new Cupom());
			List<Cupom> listCupons = new ArrayList<>();
			for(EntidadeDominio e : r.getListEntidade()) {
				Cupom c = (Cupom) e;
				if(c.getIdCliente().equals(cliente.getId())) {
					listCupons.add(c);
				}
				
			}
			cliente.setCarrinho(carrinho);
			resultado.clear();
			
			resultado.setEntidade(cliente);
			List<EntidadeDominio> cartoesEntidade = new ArrayList<>();
			List<EntidadeDominio> enderecosEntidade = new ArrayList<>();
			List<EntidadeDominio> cuponsEntidade = new ArrayList<>();
			
			for(Cartao c : cartoes) {
				cartoesEntidade.add((EntidadeDominio) c);
			}
			
			for(Endereco e : enderecos) {
				enderecosEntidade.add((EntidadeDominio) e);
			}
			for(Cupom c : listCupons) {
				cuponsEntidade.add((EntidadeDominio) c);
			}
			if(carrinho.getId() != null) {
				dao = new FreteDAO();
				Resultado rFrete = ((FreteDAO)dao).consutarByIdCarrinho(carrinho);
				carrinho.setFrete((Frete) rFrete.getEntidade());
			}
			resultado.setMapEntidade("CARTOES", cartoesEntidade);
			resultado.setMapEntidade("ENDERECOS", enderecosEntidade);
			resultado.setMapEntidade("CUPONS", cuponsEntidade);
		}
		return resultado;
	}

}
