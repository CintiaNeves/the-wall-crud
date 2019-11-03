package br.com.les.thewallcrud.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemPedidoDAO;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemPedido;
import br.com.les.thewallcrud.dominio.ItemTroca;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.StatusPedido;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHTroca implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		Pedido pedido = new Pedido();
		Troca troca = new Troca();
		String stId = request.getParameter("id");
		String idPedCompra = request.getParameter("idPedido");
		String stNumPedido = request.getParameter("numPedido");
		String stData = request.getParameter("dataPedido");
		String stObservacao = request.getParameter("observacao");
		StatusPedido status = new StatusPedido();
		troca.setStatus(status);
		troca.setObservacao(stObservacao);
		troca.setFlag(true);
		String stIdCliente = request.getParameter("idCliente");
		String stQuantidade = request.getParameter("quantidade");
		String stCodCupom = request.getParameter("codCupom");
		Cupom cupom = new Cupom();
		if(stCodCupom != null) {
			cupom.setCodigo(stCodCupom);
		}
		troca.setCupom(cupom);
		String stAdmin = request.getParameter("admin");
		String stAprova = request.getParameter("aprova");
		String stValor = request.getParameter("valor");
		if(stValor != null) {
			troca.setValor(Double.parseDouble(stValor));
		}
		if(stAprova != null) {
			troca.setAprova(Boolean.parseBoolean(stAprova));
		}
		if(stAdmin != null) {
			troca.setAdmin(Boolean.parseBoolean(stAdmin));
			troca.setFlag(false);
		}else {
			troca.setAdmin(false);
		}
		
		if(stId != null) {
			troca.setId(Long.parseLong(stId));
		}
		if(stIdCliente != null) {
			troca.setIdCliente(Long.parseLong(stIdCliente));
		}
		
		if(stNumPedido != null) {
			troca.setNumPedidoCompra(stNumPedido);
		}
		if(stData != null) {
			troca.setDataCompra(stData);
		}
		if(idPedCompra != null) {
			pedido.setId(Long.parseLong(idPedCompra));
			troca.setIdPedidoCompra(Long.parseLong(idPedCompra));
			IDAO dao = new ItemPedidoDAO();
			List<EntidadeDominio> entidades = dao.consultarById(pedido).getListEntidade();
			
			List<ItemPedido> itens = new ArrayList<>();
			dao = new InstrumentoDAO();
			for(EntidadeDominio e: entidades) {
				ItemPedido item = (ItemPedido) e;
				Instrumento i = (Instrumento) dao.consultarById(item.getInstrumento()).getEntidade();
				item.setInstrumento(i);
				itens.add(item);
			}
						
			List<ItemTroca> itensTroca = new ArrayList<>();
			for(ItemPedido ip : itens) {
				String stItemTroca = request.getParameter("item".concat(ip.getId().toString()));
				if(stItemTroca != null) {
					ItemTroca it = new ItemTroca();
					it.setInstrumento(ip.getInstrumento());
					it.setQuantidade(ip.getQuantidade());
					it.setEntradaOk(false);
					it.setValor(it.getQuantidade() * it.getInstrumento().getValorVenda());
					itensTroca.add(it);
				}else {
					String stInstrumento = request.getParameter("codInstrumento");
					ItemTroca it = new ItemTroca();
					Instrumento i = new Instrumento();
					if(stInstrumento != null) {
						i.setCodigo(stInstrumento);
						it.setInstrumento(i);
						if(stQuantidade != null) {
							it.setQuantidade(Integer.parseInt(stQuantidade));
						}
						it.setEntradaOk(false);
						itensTroca.add(it);
					}
					
				}
			}
			troca.setItens(itensTroca);
		}
		
		return troca;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		
		String operacao = request.getParameter("btnOperacao");
		try {
			RequestDispatcher rd;
			if (operacao.equals("SALVAR")) {

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
						request.setAttribute("pedido", resultado.getEntidade());
						rd = request.getRequestDispatcher("resumo.jsp");
					} else {
						rd = request.getRequestDispatcher("minhas-trocas.jsp");
					}
					rd.forward(request, response);
				}
			} else if (operacao.equals("CONSULTAR")) {
				if (resultado.getErro()) {
					request.setAttribute("troca", resultado.getEntidade());
					rd = request.getRequestDispatcher("troca.jsp");
				} else {
					Troca troca = (Troca) resultado.getEntidade();
					if(troca.getAdmin()) {
						request.setAttribute("trocas", resultado.getListEntidade());
						rd = request.getRequestDispatcher("consulta-troca.jsp");
					}else {
						request.setAttribute("troca", resultado.getEntidade());
						rd = request.getRequestDispatcher("troca.jsp");
					}
					
				}
				rd.forward(request, response);
			} else if (operacao.equals("CONSULTARBYID")) {
				if(request.getParameter("retornoJson") != null && Boolean.parseBoolean(request.getParameter("retornoJson")) == true) {
					response.addHeader("Access-Control-Allow-Origin", "*");
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					ObjectMapper mapper = new ObjectMapper();
					try {
						String json = null;
						if(resultado.getErro()) {
							json = "{\"erro\":\"".concat(resultado.getMensagem().concat("\"}"));
						} else {
							json = mapper.writeValueAsString(resultado.getListEntidade());
						}
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}else {
					Troca troca = (Troca) resultado.getEntidade();
					if (resultado.getErro()) {
						request.setAttribute("pedido", resultado.getEntidade());
						rd = request.getRequestDispatcher("gerenciar-pedido.jsp");
					} else {
						if(troca.getStatus().getId() == 6) {
							request.setAttribute("troca", resultado.getEntidade());
							rd = request.getRequestDispatcher("gerenciar-troca.jsp");
						}else {
							request.setAttribute("troca", resultado.getEntidade());
							request.setAttribute("status", resultado.getMapEntidade().get("STATUS"));
							rd = request.getRequestDispatcher("gerenciar-entrega.jsp");
						}
						
					}
					rd.forward(request, response);
				}

				
			} else if (operacao.equals("ALTERAR")) {
				if (resultado.getErro()) {
					request.setAttribute("trocas", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta-troca.jsp");
				} else {
					request.setAttribute("trocas", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta-troca.jsp");
				}
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
