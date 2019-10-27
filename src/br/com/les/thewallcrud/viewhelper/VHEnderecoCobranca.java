package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHEnderecoCobranca implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stTpResidencia = request.getParameter("tp-resid-cbr");
		String stTpLogradouro = request.getParameter("tp-logra-cbr");
		String stLogradouro = request.getParameter("logradouro-cbr");
		String stNumero = request.getParameter("numero-cbr");
		String stCep = request.getParameter("cep-cbr");
		String stBairro = request.getParameter("bairro-cbr");
		String stObservacoes = request.getParameter("observacao-cbr");
		
		VHPaisCobranca vhPais = new VHPaisCobranca();
		Pais pais = (Pais) vhPais.getEntidade(request);
		
		Endereco endereco = new Endereco();
		endereco.setCobranca(true);
		endereco.setAlias("Cobrança");
		endereco.setTpResidencia(stTpResidencia);
		endereco.setTpLogradouro(stTpLogradouro);
		endereco.setLogradouro(stLogradouro);
		endereco.setNumero(stNumero);
		endereco.setCep(stCep);
		endereco.setBairro(stBairro);
		endereco.setObservacoes(stObservacoes);
		endereco.setPais(pais);
		
		return endereco;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
