package br.com.les.thewallcrud.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.command.CmdAlterar;
import br.com.les.thewallcrud.command.CmdConsultar;
import br.com.les.thewallcrud.command.CmdConsultarById;
import br.com.les.thewallcrud.command.CmdExcluir;
import br.com.les.thewallcrud.command.CmdSalvar;
import br.com.les.thewallcrud.command.ICommand;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/relatorio"})
public class RelatorioController extends HttpServlet {

	private Map<String, ICommand> mapCommand;

	public RelatorioController() {

		mapCommand = new HashMap<String, ICommand>();
		mapCommand.put("SALVAR", new CmdSalvar());
		mapCommand.put("CONSULTAR", new CmdConsultar());
		mapCommand.put("ALTERAR", new CmdAlterar());
		mapCommand.put("EXCLUIR", new CmdExcluir());
		mapCommand.put("CONSULTARBYID", new CmdConsultarById());

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {

		//String operacao = request.getParameter("btnOperacao");
		//ICommand command = mapCommand.get(operacao);
		//IViewHelper vhCidade = new VHCidadeCobranca();
		//EntidadeDominio entidade = vhCidade.getEntidade(request);
        // Resultado resultado = command.executar(entidade);
		//vhCidade.setView(resultado, request, response);
		RequestDispatcher rd = request.getRequestDispatcher("relatorio.jsp");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
