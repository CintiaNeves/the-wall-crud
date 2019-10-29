package br.com.les.thewallcrud.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.strategy.StRelatorioItensVendidos;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;
import br.com.les.thewallcrud.viewhelper.IViewHelper;
import br.com.les.thewallcrud.viewhelper.VHRelatorio;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/relatorio"})
public class RelatorioController extends HttpServlet {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {

		String relatorio = request.getParameter("relatorio");
		if(relatorio.equals("ITENS_VENDIDOS")) {
			itensPedido(request, response);
		}
	}
	
	private void itensPedido(HttpServletRequest request, HttpServletResponse response) {
				
		IViewHelper vhRelatorio = new VHRelatorio();
		EntidadeDominio entidade = vhRelatorio.getEntidade(request);
		
		Resultado resultado = new Resultado();
		resultado.setEntidade(entidade);
		StRelatorioItensVendidos stRelatorio = new StRelatorioItensVendidos();
		resultado = stRelatorio.processar(resultado);
		
		vhRelatorio.setView(resultado, request, response);
	}
}
