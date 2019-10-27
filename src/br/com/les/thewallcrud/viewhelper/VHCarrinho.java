package br.com.les.thewallcrud.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.Frete;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHCarrinho implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String stRetornoJson = request.getParameter("retornoJson");
		String stValorFrete = null;
		Carrinho carrinho = new Carrinho();
		String stId = request.getParameter("idCarrinho");
		if (stRetornoJson != null && (!stRetornoJson.equals(""))) {
			carrinho.setRetornoJson(Boolean.parseBoolean(stRetornoJson));
			if(stId != null && (!stId.trim().equals(""))) {
				carrinho.setId(Long.parseLong(stId));
			}
		} else {
			String stIdCarrinho = request.getParameter("carrinho-id");
			String stCheckout = request.getParameter("checkout");
			String stIdCliente = request.getParameter("cliente-id");
			stValorFrete = request.getParameter("valorFrete");
			IViewHelper vhItemCarrinho = new VHItemCarrinho();
			ItemCarrinho item = (ItemCarrinho) vhItemCarrinho.getEntidade(request);
			List<ItemCarrinho> itens = new ArrayList<ItemCarrinho>();
			itens.add(item);
	
			if (stIdCarrinho != null && (!stIdCarrinho.trim().equals(""))) {
				carrinho.setId(Long.parseLong(stIdCarrinho));
			}

			if (stCheckout != null && (!stCheckout.equals(""))) {
				carrinho.setCheckout(Boolean.parseBoolean(stCheckout));
			}

			if (stIdCliente != null && (!stIdCliente.equals(""))) {
				carrinho.setIdCliente(Long.parseLong(stIdCliente));
			}
			carrinho.setItens(itens);

		}
		String stCep = request.getParameter("cep");
		String stCupom = request.getParameter("cupom");
		Frete frete = new Frete();
		if(stValorFrete != null && (!stValorFrete.trim().equals(""))){
			frete.setValorFrete(Double.parseDouble(stValorFrete));
		}
		List<Cupom> cupons = new ArrayList<Cupom>();
		Cupom cupom = new Cupom();
		cupom.setCodigo(stCupom);
		cupons.add(cupom);
		frete.setCep(stCep);
		carrinho.setCupons(cupons);
		carrinho.setFrete(frete);

		return carrinho;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		String operacao = request.getParameter("btnOperacao");

		try {
			RequestDispatcher rd;
			if (operacao.equals("CONSULTARBYID")) {

				if (request.getParameter("retornoJson") != null
						&& Boolean.parseBoolean(request.getParameter("retornoJson")) == true) {
					response.addHeader("Access-Control-Allow-Origin", "*");
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					ObjectMapper mapper = new ObjectMapper();
					try {
						String json = null;
						if (resultado.getErro()) {
							json = "{\"erro\":\"".concat(resultado.getMensagem().concat("\"}"));
						} else {
							json = mapper.writeValueAsString(resultado.getEntidade());
						}
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (resultado.getErro()) {
						rd = request.getRequestDispatcher("carrinho.jsp");
					} else {
						request.setAttribute("cliente", resultado.getEntidade());
						request.setAttribute("cartoes", resultado.getMapEntidade().get("CARTOES"));
						request.setAttribute("enderecos", resultado.getMapEntidade().get("ENDERECOS"));
						rd = request.getRequestDispatcher("checkout.jsp");
					}
					rd.forward(request, response);
				}
			} else if (operacao.equals("CONSULTAR")) {
				if (request.getParameter("retornoJson") != null
						&& Boolean.parseBoolean(request.getParameter("retornoJson")) == true) {
					response.addHeader("Access-Control-Allow-Origin", "*");
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					ObjectMapper mapper = new ObjectMapper();
					try {
						String json = null;
						if (resultado.getErro()) {
							json = "{\"erro\":\"".concat(resultado.getMensagem().replace("\n", "").concat("\"}"));
						} else {
							json = mapper.writeValueAsString(resultado.getEntidade());
						}
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
