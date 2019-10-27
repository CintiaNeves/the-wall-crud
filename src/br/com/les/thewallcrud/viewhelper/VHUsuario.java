package br.com.les.thewallcrud.viewhelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHUsuario implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String stNome = request.getParameter("nome");
		String stSenha = request.getParameter("senha");
		String stConSenha = request.getParameter("confSenha");

		Usuario usuario = new Usuario();
		usuario.setNome(stNome);
		usuario.setSenha(stSenha);
		usuario.setConfSenha(stConSenha);
		usuario.setAdministrador(false);

		return usuario;
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
					request.setAttribute("cadastro", 1);
					request.setAttribute("usuario", resultado.getEntidade());
					rd = request.getRequestDispatcher("login.jsp");
				} else {
					request.setAttribute("cliente", resultado.getEntidade());
					request.setAttribute("generos", resultado.getMapEntidade().get("GENEROS"));
					request.setAttribute("bandeiras", resultado.getMapEntidade().get("BANDEIRAS"));
					request.setAttribute("paises", resultado.getMapEntidade().get("PAISES"));
					request.setAttribute("cidades", resultado.getMapEntidade().get("CIDADES"));
					request.setAttribute("estados", resultado.getMapEntidade().get("ESTADOS"));
					rd = request.getRequestDispatcher("registro.jsp");
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
