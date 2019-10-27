package br.com.les.thewallcrud.viewhelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHItemCarrinho implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stIdInstrumento = request.getParameter("instrumento");
		String stQuantidade = request.getParameter("quantidade");
		String stIdCarrinho = request.getParameter("carrinho");
		ItemCarrinho item = new ItemCarrinho();
		Instrumento instrumento = new Instrumento();
		
		if(stIdInstrumento != null && (!stIdInstrumento.trim().equals(""))) {
			instrumento.setId(Long.parseLong(stIdInstrumento));
		}
		
		if(stIdCarrinho != null && (!stIdCarrinho.trim().equals(""))) {
			item.setIdCarrinho(Long.parseLong(stIdCarrinho));
		}
		
		if(stQuantidade != null && (!stQuantidade.trim().equals(""))) {
			item.setQuantidade(Integer.parseInt(stQuantidade));
			item.setExpirado(false);
			item.setInstrumento(instrumento);
		}
		return item;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		try {
			RequestDispatcher rd;
			if (operacao.equals("CONSULTAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("usuario", resultado.getEntidade());
					rd = request.getRequestDispatcher("login.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("cliente", resultado.getEntidade());
					rd = request.getRequestDispatcher("index.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("SALVAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("usuario", resultado.getEntidade());
					rd = request.getRequestDispatcher("login.jsp");
				} else {
					request.setAttribute("carrinho", resultado.getEntidade());
					request.setAttribute("itens", resultado.getMapEntidade().get("ITENS"));
					rd = request.getRequestDispatcher("carrinho.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("ALTERAR")) {

			} else if (operacao.equals("EXCLUIR")) {
				
			} else if (operacao.equals("CONSULTARBYID")) {
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
