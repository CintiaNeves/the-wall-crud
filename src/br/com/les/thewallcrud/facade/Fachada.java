package br.com.les.thewallcrud.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.les.thewallcrud.dao.BandeiraDAO;
import br.com.les.thewallcrud.dao.CarrinhoDAO;
import br.com.les.thewallcrud.dao.CidadeDAO;
import br.com.les.thewallcrud.dao.ClienteDAO;
import br.com.les.thewallcrud.dao.EnderecoDAO;
import br.com.les.thewallcrud.dao.EntradaDAO;
import br.com.les.thewallcrud.dao.EstadoDAO;
import br.com.les.thewallcrud.dao.FornecedorDAO;
import br.com.les.thewallcrud.dao.GeneroDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemCarrinhoDAO;
import br.com.les.thewallcrud.dao.OcorrenciaDAO;
import br.com.les.thewallcrud.dao.PaisDAO;
import br.com.les.thewallcrud.dao.PedidoDAO;
import br.com.les.thewallcrud.dao.RelatorioDAO;
import br.com.les.thewallcrud.dao.TrocaDAO;
import br.com.les.thewallcrud.dao.UsuarioDAO;
import br.com.les.thewallcrud.dominio.Bandeira;
import br.com.les.thewallcrud.dominio.Carrinho;
import br.com.les.thewallcrud.dominio.Cidade;
import br.com.les.thewallcrud.dominio.Cliente;
import br.com.les.thewallcrud.dominio.Cupom;
import br.com.les.thewallcrud.dominio.Endereco;
import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.Estado;
import br.com.les.thewallcrud.dominio.Fornecedor;
import br.com.les.thewallcrud.dominio.Genero;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemCarrinho;
import br.com.les.thewallcrud.dominio.Ocorrencia;
import br.com.les.thewallcrud.dominio.Pais;
import br.com.les.thewallcrud.dominio.Pedido;
import br.com.les.thewallcrud.dominio.Relatorio;
import br.com.les.thewallcrud.dominio.Troca;
import br.com.les.thewallcrud.dominio.Usuario;
import br.com.les.thewallcrud.strategy.IStrategy;
import br.com.les.thewallcrud.strategy.StAdicionaItemEstoque;
import br.com.les.thewallcrud.strategy.StAlteraQuantidadeReserva;
import br.com.les.thewallcrud.strategy.StAlteraStatusProduto;
import br.com.les.thewallcrud.strategy.StAlterarStatusPedido;
import br.com.les.thewallcrud.strategy.StAtualizaCarrinho;
import br.com.les.thewallcrud.strategy.StAtualizaCarrinhoLogon;
import br.com.les.thewallcrud.strategy.StAtualizaCustoInstrumento;
import br.com.les.thewallcrud.strategy.StAtualizaEstoque;
import br.com.les.thewallcrud.strategy.StBaixaCupons;
import br.com.les.thewallcrud.strategy.StCalculaFrete;
import br.com.les.thewallcrud.strategy.StCarregaCarrinho;
import br.com.les.thewallcrud.strategy.StCarregaCombos;
import br.com.les.thewallcrud.strategy.StCarregaFornecedor;
import br.com.les.thewallcrud.strategy.StCarregaItens;
import br.com.les.thewallcrud.strategy.StCarregaStatus;
import br.com.les.thewallcrud.strategy.StCheckout;
import br.com.les.thewallcrud.strategy.StComplementaDataTroca;
import br.com.les.thewallcrud.strategy.StCriaCapaPedido;
import br.com.les.thewallcrud.strategy.StCriptografia;
import br.com.les.thewallcrud.strategy.StEsvaziaCarrinho;
import br.com.les.thewallcrud.strategy.StFiltraTrocasGerenciaveis;
import br.com.les.thewallcrud.strategy.StFormataDescontoCupom;
import br.com.les.thewallcrud.strategy.StGeraCodigoCliente;
import br.com.les.thewallcrud.strategy.StGeraCodigoInstrumento;
import br.com.les.thewallcrud.strategy.StGeraCodigoTroca;
import br.com.les.thewallcrud.strategy.StGeraCupomTroca;
import br.com.les.thewallcrud.strategy.StGravaDependenciasCliente;
import br.com.les.thewallcrud.strategy.StGravaItemPedido;
import br.com.les.thewallcrud.strategy.StGravaItemTroca;
import br.com.les.thewallcrud.strategy.StGravaItensEntrada;
import br.com.les.thewallcrud.strategy.StLogin;
import br.com.les.thewallcrud.strategy.StPreparaGravacaoPedido;
import br.com.les.thewallcrud.strategy.StProcessarPagamentos;
import br.com.les.thewallcrud.strategy.StRelatorioItensVendidos;
import br.com.les.thewallcrud.strategy.StRemoveReservaExclusaoItem;
import br.com.les.thewallcrud.strategy.StReservaItemEstoque;
import br.com.les.thewallcrud.strategy.StSalvaDependecias;
import br.com.les.thewallcrud.strategy.StSalvarFormaPagamento;
import br.com.les.thewallcrud.strategy.StSetViewAlterarPedido;
import br.com.les.thewallcrud.strategy.StSetViewCarrinho;
import br.com.les.thewallcrud.strategy.StSetViewCliente;
import br.com.les.thewallcrud.strategy.StSetViewInstrumento;
import br.com.les.thewallcrud.strategy.StSetViewOcorrencia;
import br.com.les.thewallcrud.strategy.StSetViewPedido;
import br.com.les.thewallcrud.strategy.StSetViewResumo;
import br.com.les.thewallcrud.strategy.StSetViewTroca;
import br.com.les.thewallcrud.strategy.StSetViewTrocasAdmin;
import br.com.les.thewallcrud.strategy.StSetViewUsuario;
import br.com.les.thewallcrud.strategy.StValidaAlteracaoQuantidadeItemCarrinho;
import br.com.les.thewallcrud.strategy.StValidaCamposCliente;
import br.com.les.thewallcrud.strategy.StValidaCamposEntrada;
import br.com.les.thewallcrud.strategy.StValidaCamposInstrumento;
import br.com.les.thewallcrud.strategy.StValidaCupom;
import br.com.les.thewallcrud.strategy.StValidaDadosUsuario;
import br.com.les.thewallcrud.strategy.StValidaEmail;
import br.com.les.thewallcrud.strategy.StValidaExclusaoItemCarrinho;
import br.com.les.thewallcrud.strategy.StValidaExistenciaFornecedor;
import br.com.les.thewallcrud.strategy.StValidaExistenciaInstrumento;
import br.com.les.thewallcrud.strategy.StValidaExistenciaNota;
import br.com.les.thewallcrud.strategy.StValidaExistenciaUsuario;
import br.com.les.thewallcrud.strategy.StValidaFormaPagamento;
import br.com.les.thewallcrud.strategy.StValidaInstrumentoUnico;
import br.com.les.thewallcrud.strategy.StValidaItemExistenteCarrinho;
import br.com.les.thewallcrud.strategy.StValidaOcorrencia;
import br.com.les.thewallcrud.strategy.StValidaSenhaForte;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class Fachada implements IFachada {

	private Map<String, IDAO> mapDAO;
	private Map<String, List<IStrategy>> mapInstrumentoStrategy;
	private Map<String, List<IStrategy>> mapOcorrenciaStrategy;
	private Map<String, List<IStrategy>> mapEntradaStrategy;
	private Map<String, List<IStrategy>> mapItemEstoqueStrategy;
	private Map<String, List<IStrategy>> mapUsuarioStrategy;
	private Map<String, List<IStrategy>> mapClienteStrategy;
	private Map<String, List<IStrategy>> mapPedidoStrategy;
	private Map<String, List<IStrategy>> mapTrocaStrategy;
	private Map<String, List<IStrategy>> mapItemCarrinhoStrategy;
	private Map<String, List<IStrategy>> mapCarrinhoStrategy;
	private Map<String, List<IStrategy>> mapRelatorioStrategy;
	private Map<String, List<IStrategy>> mapOcorrenciaPosProcessamento;
	private Map<String, List<IStrategy>> mapEntradaPosProcessamento;
	private Map<String, List<IStrategy>> mapFornecedorPosProcessamento;
	private Map<String, List<IStrategy>> mapInstrumentoPosProcessamento;
	private Map<String, List<IStrategy>> mapUsuarioPosProcessamento;
	private Map<String, List<IStrategy>> mapClientePosProcessamento;
	private Map<String, List<IStrategy>> mapItemCarrinhoPosProcessamento;
	private Map<String, List<IStrategy>> mapCupomPosProcessamento;
	private Map<String, List<IStrategy>> mapCarrinhoPosProcessamento;
	private Map<String, List<IStrategy>> mapPedidoPosProcessamento;
	private Map<String, List<IStrategy>> mapCarrinhoStrategyPosProcessamento;
	private Map<String, List<IStrategy>> mapTrocaStrategyPosProcessamento;
	private Map<String, List<IStrategy>> mapRelatorioPosProcessamento;
	private Map<String, Map<String, List<IStrategy>>> mapEntidadeCRUDStrategy;
	private Map<String, Map<String, List<IStrategy>>> mapEntidadeCRUDPosProcessamento;
	public Fachada() {
		mapDAO = new HashMap<String, IDAO>();
		mapInstrumentoStrategy = new HashMap<String, List<IStrategy>>();
		mapOcorrenciaStrategy = new HashMap<String, List<IStrategy>>();
		mapEntradaStrategy = new HashMap<String, List<IStrategy>>();
		mapItemEstoqueStrategy = new HashMap<String, List<IStrategy>>();
		mapUsuarioStrategy = new HashMap<String, List<IStrategy>>();
		mapClienteStrategy = new HashMap<String, List<IStrategy>>();
		mapPedidoStrategy = new HashMap<String, List<IStrategy>>();
		mapTrocaStrategy = new HashMap<String, List<IStrategy>>();
		mapEntidadeCRUDStrategy = new HashMap<String, Map<String, List<IStrategy>>>();
		mapEntidadeCRUDPosProcessamento = new HashMap<String, Map<String, List<IStrategy>>>();
		mapOcorrenciaPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapEntradaPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapFornecedorPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapInstrumentoPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapUsuarioPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapClientePosProcessamento = new HashMap<String, List<IStrategy>>();
		mapItemCarrinhoPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapCupomPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapCarrinhoPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapPedidoPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapItemCarrinhoStrategy = new HashMap<String, List<IStrategy>>();
		mapCarrinhoStrategyPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapTrocaStrategyPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapRelatorioPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapCarrinhoStrategy = new HashMap<String, List<IStrategy>>();
		mapRelatorioStrategy = new HashMap<String, List<IStrategy>>();
		// Lista Instrumento Salvar
		List<IStrategy> listStrategySalvarInstrumento = new ArrayList<>();
		listStrategySalvarInstrumento.add(new StValidaCamposInstrumento());
		listStrategySalvarInstrumento.add(new StGeraCodigoInstrumento());

		// Lista Ocorrencia Salvar
		List<IStrategy> listStrategySalvarOcorrencia = new ArrayList<>();
		listStrategySalvarOcorrencia.add(new StValidaOcorrencia());
		listStrategySalvarOcorrencia.add(new StAlteraStatusProduto());

		// Lista Entrada Consultar
		List<IStrategy> listStrategyConsultarEntrada = new ArrayList<>();
		listStrategyConsultarEntrada.add(new StCarregaFornecedor());

		// Lista Entrada Salvar
		List<IStrategy> listStrategySalvarEntrada = new ArrayList<>();
		listStrategySalvarEntrada.add(new StValidaCamposEntrada());
		listStrategySalvarEntrada.add(new StCarregaFornecedor());
		listStrategySalvarEntrada.add(new StValidaExistenciaNota());

		// Lista Item Estoque Salvar
		List<IStrategy> listStrategySalvarItemEstoque = new ArrayList<>();

		// Lista Item Estoque Alterar
		List<IStrategy> listStrategyAlterarItemEstoque = new ArrayList<>();

		// Lista Usuario Salvar
		List<IStrategy> listStrategySalvarUsuario = new ArrayList<>();
		listStrategySalvarUsuario.add(new StValidaDadosUsuario());
		listStrategySalvarUsuario.add(new StValidaEmail());
		listStrategySalvarUsuario.add(new StValidaExistenciaUsuario());
		listStrategySalvarUsuario.add(new StValidaSenhaForte());
		listStrategySalvarUsuario.add(new StCriptografia());

		// Lista Ocorrencia Pós Processamento
		List<IStrategy> listStrategySalvarOcorrenciaPos = new ArrayList<>();
		listStrategySalvarOcorrenciaPos.add(new StSetViewOcorrencia());

		// Lista Cliente Salvar
		List<IStrategy> listStrategySalvarCliente = new ArrayList<>();
		listStrategySalvarCliente.add(new StCarregaCombos());
		listStrategySalvarCliente.add(new StValidaCamposCliente());
		listStrategySalvarCliente.add(new StGeraCodigoCliente());

		// Lista Usuario consultar
		List<IStrategy> listStrategyConsultarUsuario = new ArrayList<>();
		listStrategyConsultarUsuario.add(new StCriptografia());
		
		//Lista Consultar Pedido
		List<IStrategy> listStrategyConsultarPedido = new ArrayList<>();
		listStrategyConsultarPedido.add(new StCalculaFrete());
		listStrategyConsultarPedido.add(new StValidaCupom());
		
		//Lista Salvar Pedido
		List<IStrategy> listStrategySalvarPedido = new ArrayList<>();
		listStrategySalvarPedido.add(new StPreparaGravacaoPedido());
		listStrategySalvarPedido.add(new StValidaFormaPagamento());
		listStrategySalvarPedido.add(new StCriaCapaPedido());
		
		//Lista Consultar Carrinho 
		List<IStrategy> listStrategyConsultarByIdCarrinhoPos = new ArrayList<>();
 		listStrategyConsultarByIdCarrinhoPos.add(new StCheckout());
 		List<IStrategy> listStrategyConsultarCarrinho = new ArrayList<>();
 		listStrategyConsultarCarrinho.add(new StCalculaFrete());
 		listStrategyConsultarCarrinho.add(new StValidaCupom());
 		
 		List<IStrategy> listStrategySalvarItemCarrinho = new ArrayList<>();
 		listStrategySalvarItemCarrinho.add(new StValidaItemExistenteCarrinho());
		// Lista Entrada Pós Processamento
		List<IStrategy> listStrategySalvarEntradaPos = new ArrayList<>();
		List<IStrategy> listStrategyConsultarEntradaPos = new ArrayList<>();
		listStrategySalvarEntradaPos.add(new StGravaItensEntrada());
		listStrategySalvarEntradaPos.add(new StAtualizaCustoInstrumento());
		listStrategySalvarEntradaPos.add(new StAtualizaEstoque());
		listStrategyConsultarEntradaPos.add(new StValidaExistenciaNota());

		// Lista Isntrumento Pós Processamento
		List<IStrategy> listStrategyConsultarInstrumentoPos = new ArrayList<>();
		List<IStrategy> listStrategyConsultarInstrumentoPosJson = new ArrayList<>();
		List<IStrategy> listStrategySalvarInstrumentoPos = new ArrayList<>();
		List<IStrategy> listStrategyAlterarInstrumentoPos = new ArrayList<>();
		listStrategyAlterarInstrumentoPos.add(new StSetViewInstrumento());
		listStrategyConsultarInstrumentoPosJson.add(new StValidaExistenciaInstrumento());
		listStrategyConsultarInstrumentoPosJson.add(new StValidaInstrumentoUnico());
		listStrategyConsultarInstrumentoPos.add(new StSetViewInstrumento());
		listStrategySalvarInstrumentoPos.add(new StAdicionaItemEstoque());
		listStrategySalvarInstrumentoPos.add(new StSetViewInstrumento());

		// Lista Fornecedor Pós Processamento
		List<IStrategy> listStrategyConsultarFornecedorPos = new ArrayList<>();
		listStrategyConsultarFornecedorPos.add(new StValidaExistenciaFornecedor());

		// Lista Usuario Pós Processamento
		List<IStrategy> listStrategyConsultarUsuarioPos = new ArrayList<>();
		List<IStrategy> listStrategySalvarUsuarioPos = new ArrayList<>();
		listStrategyConsultarUsuarioPos.add(new StLogin());
		listStrategyConsultarUsuarioPos.add(new StSetViewCliente());
		listStrategyConsultarUsuarioPos.add(new StCarregaCarrinho());
		listStrategyConsultarUsuarioPos.add(new StAtualizaCarrinhoLogon());
		listStrategySalvarUsuarioPos.add(new StSetViewUsuario());
		listStrategySalvarUsuarioPos.add(new StSetViewCliente());
		listStrategySalvarUsuarioPos.add(new StCarregaCombos());
		
		//Lista Cliente Pós Processamento
		List<IStrategy> listStrategySalvarClientePos = new ArrayList<>();
		listStrategySalvarClientePos.add(new StCarregaCombos());
		listStrategySalvarClientePos.add(new StGravaDependenciasCliente());

		//Lista ItemCarrinho Pós processamento
		List<IStrategy> listStrategySalvarItemCarrinhoPos = new ArrayList<>();
		listStrategySalvarItemCarrinhoPos.add(new StReservaItemEstoque());
		listStrategySalvarItemCarrinhoPos.add(new StAtualizaCarrinho());
		List<IStrategy> listStrategyConsultarItemCarrinhoPos = new ArrayList<>();
		listStrategyConsultarItemCarrinhoPos.add(new StCheckout());
		List<IStrategy> listStrategyExcluirItemCarrinhoPos = new ArrayList<>();
		listStrategyExcluirItemCarrinhoPos.add(new StRemoveReservaExclusaoItem());
		List<IStrategy> listStrategyExcluirItemCarrinho = new ArrayList<>();
		listStrategyExcluirItemCarrinho.add(new StValidaExclusaoItemCarrinho());
		List<IStrategy> listStrategyAlterarItemCarrinhoPos = new ArrayList<>();
		listStrategyAlterarItemCarrinhoPos.add(new StAlteraQuantidadeReserva());
		List<IStrategy> listStrategyAlterarItemCarrinho = new ArrayList<>();
		listStrategyAlterarItemCarrinho.add(new StValidaAlteracaoQuantidadeItemCarrinho());
		
		
		//Lista Cupom Pós processamento
		List<IStrategy> listStrategyConsultarCupomPos = new ArrayList<>();
		listStrategyConsultarCupomPos.add(new StFormataDescontoCupom());
		
		//Lista Carrinho Pós Processamento
		List<IStrategy> listStrategyConsultaByIDCarrinhoPos = new ArrayList<>();
		listStrategyConsultaByIDCarrinhoPos.add(new StSetViewCarrinho());
		
		//Lista Pedido Pós Processamento
		List<IStrategy> listStrategySalvarPedidoPos = new ArrayList<>();
		listStrategySalvarPedidoPos.add(new StGravaItemPedido());
		listStrategySalvarPedidoPos.add(new StSalvaDependecias());
		listStrategySalvarPedidoPos.add(new StBaixaCupons());
		listStrategySalvarPedidoPos.add(new StEsvaziaCarrinho());
		listStrategySalvarPedidoPos.add(new StSalvarFormaPagamento());
		listStrategySalvarPedidoPos.add(new StSetViewResumo());
		List<IStrategy> listStrategyAlterarPedidoPos = new ArrayList<>();
		listStrategyAlterarPedidoPos.add(new StSetViewAlterarPedido());
		List<IStrategy> listStrategyConsultarPedidoPos = new ArrayList<>();
		listStrategyConsultarPedidoPos.add(new StSetViewPedido());
		List<IStrategy> listStrategyConsultarByIdPedidoPos = new ArrayList<>();
		listStrategyConsultarByIdPedidoPos.add(new StSetViewPedido());
		listStrategyConsultarByIdPedidoPos.add(new StCarregaStatus());
		listStrategyConsultarByIdPedidoPos.add(new StCarregaItens());
		List<IStrategy> listStrategyAlterarPedido = new ArrayList<>();
		listStrategyAlterarPedido.add(new StAlterarStatusPedido());
		listStrategyAlterarPedido.add(new StProcessarPagamentos());
		// Lista troca
		List<IStrategy> listStrategySalvarTroca = new ArrayList<>();
		listStrategySalvarTroca.add(new StGeraCodigoTroca());
		listStrategySalvarTroca.add(new StComplementaDataTroca());
		
		List<IStrategy> listStrategyConsultarByIdTrocaPos = new ArrayList<>();
		listStrategyConsultarByIdTrocaPos.add(new StSetViewTroca());
		
		List<IStrategy> listStrategySalvarTrocaPos = new ArrayList<>();
		listStrategySalvarTrocaPos.add(new StGravaItemTroca());
		List<IStrategy> listStrategyConsultarTrocaPos = new ArrayList<>();
		listStrategyConsultarTrocaPos.add(new StSetViewTrocasAdmin());
		List<IStrategy> listStrategyAlterarTrocaPos = new ArrayList<>();
		listStrategyAlterarTrocaPos.add(new StFiltraTrocasGerenciaveis());
		
		List<IStrategy> listStrategyAlterarTroca = new ArrayList<>();
		listStrategyAlterarTroca.add(new StGeraCupomTroca());
		
		List<IStrategy> listStrategyConsultarRelatorio = new ArrayList<>();
		listStrategyConsultarRelatorio.add(new StRelatorioItensVendidos());
		List<IStrategy> listStrategyRelatorioPosProcessamento = new ArrayList<>();
		listStrategyRelatorioPosProcessamento.add(new StRelatorioItensVendidos());
		
		mapInstrumentoStrategy.put("SALVAR", listStrategySalvarInstrumento);
		mapOcorrenciaStrategy.put("SALVAR", listStrategySalvarOcorrencia);
		mapEntradaStrategy.put("SALVAR", listStrategySalvarEntrada);
		mapEntradaStrategy.put("CONSULTAR", listStrategyConsultarEntrada);
		mapItemEstoqueStrategy.put("SALVAR", listStrategySalvarItemEstoque);
		mapItemEstoqueStrategy.put("ALTERAR", listStrategyAlterarItemEstoque);
		mapUsuarioStrategy.put("SALVAR", listStrategySalvarUsuario);
		mapUsuarioStrategy.put("CONSULTAR", listStrategyConsultarUsuario);
		mapClienteStrategy.put("SALVAR", listStrategySalvarCliente);
		mapCarrinhoStrategy.put("CONSULTAR", listStrategyConsultarCarrinho);
		mapPedidoStrategy.put("CONSULTAR", listStrategyConsultarPedido);
		mapPedidoStrategy.put("SALVAR", listStrategySalvarPedido);
		mapPedidoStrategy.put("ALTERAR", listStrategyAlterarPedido);
		mapTrocaStrategy.put("SALVAR", listStrategySalvarTroca);
		mapTrocaStrategy.put("ALTERAR", listStrategyAlterarTroca);
		mapItemCarrinhoStrategy.put("SALVAR", listStrategySalvarItemCarrinho);
		mapItemCarrinhoStrategy.put("EXCLUIR", listStrategyExcluirItemCarrinho);
		mapItemCarrinhoStrategy.put("ALTERAR", listStrategyAlterarItemCarrinho);
		mapRelatorioStrategy.put("CONSULTAR", listStrategyConsultarRelatorio);
		mapOcorrenciaPosProcessamento.put("SALVAR", listStrategySalvarOcorrenciaPos);
		mapEntradaPosProcessamento.put("SALVAR", listStrategySalvarEntradaPos);
		mapEntradaPosProcessamento.put("CONSULTAR", listStrategyConsultarEntradaPos);
		mapFornecedorPosProcessamento.put("CONSULTAR", listStrategyConsultarFornecedorPos);
		mapInstrumentoPosProcessamento.put("CONSULTAR", listStrategyConsultarInstrumentoPos);
		mapInstrumentoPosProcessamento.put("CONSULTAR-JSON", listStrategyConsultarInstrumentoPosJson);
		mapInstrumentoPosProcessamento.put("SALVAR", listStrategySalvarInstrumentoPos);
		mapInstrumentoPosProcessamento.put("ALTERAR", listStrategyAlterarInstrumentoPos);
		mapUsuarioPosProcessamento.put("CONSULTAR", listStrategyConsultarUsuarioPos);
		mapUsuarioPosProcessamento.put("SALVAR", listStrategySalvarUsuarioPos);
		mapClientePosProcessamento.put("SALVAR", listStrategySalvarClientePos);
		mapItemCarrinhoPosProcessamento.put("SALVAR", listStrategySalvarItemCarrinhoPos);
		mapItemCarrinhoPosProcessamento.put("CONSULTAR", listStrategyConsultarItemCarrinhoPos);
		mapItemCarrinhoPosProcessamento.put("EXCLUIR", listStrategyExcluirItemCarrinhoPos);
		mapItemCarrinhoPosProcessamento.put("ALTERAR" , listStrategyAlterarItemCarrinhoPos);
		mapCupomPosProcessamento.put("CONSULTAR", listStrategyConsultarCupomPos);
		mapCarrinhoPosProcessamento.put("CONSULTARBYID", listStrategyConsultaByIDCarrinhoPos);
		mapPedidoPosProcessamento.put("SALVAR", listStrategySalvarPedidoPos);
		mapPedidoPosProcessamento.put("CONSULTAR", listStrategyConsultarPedidoPos);
		mapPedidoPosProcessamento.put("CONSULTARBYID", listStrategyConsultarByIdPedidoPos);
		mapPedidoPosProcessamento.put("ALTERAR", listStrategyAlterarPedidoPos);
		mapCarrinhoStrategyPosProcessamento.put("CONSULTARBYID", listStrategyConsultarByIdCarrinhoPos);
		mapTrocaStrategyPosProcessamento.put("CONSULTARBYID", listStrategyConsultarByIdTrocaPos);
		mapTrocaStrategyPosProcessamento.put("SALVAR", listStrategySalvarTrocaPos);
		mapTrocaStrategyPosProcessamento.put("CONSULTAR", listStrategyConsultarTrocaPos);
		mapTrocaStrategyPosProcessamento.put("ALTERAR", listStrategyConsultarTrocaPos);
		mapRelatorioPosProcessamento.put("CONSULTAR", listStrategyRelatorioPosProcessamento);
		mapTrocaStrategyPosProcessamento.put("ALTERAR", listStrategyAlterarTrocaPos);
		mapDAO.put(Instrumento.class.getSimpleName(), new InstrumentoDAO());
		mapDAO.put(Ocorrencia.class.getSimpleName(), new OcorrenciaDAO());
		mapDAO.put(Entrada.class.getSimpleName(), new EntradaDAO());
		mapDAO.put(Fornecedor.class.getSimpleName(), new FornecedorDAO());
		mapDAO.put(Usuario.class.getSimpleName(), new UsuarioDAO());
		mapDAO.put(Bandeira.class.getSimpleName(), new BandeiraDAO());
		mapDAO.put(Genero.class.getSimpleName(), new GeneroDAO());
		mapDAO.put(Pais.class.getSimpleName(), new PaisDAO());
		mapDAO.put(Estado.class.getSimpleName(), new EstadoDAO());
		mapDAO.put(Cidade.class.getSimpleName(), new CidadeDAO());
		mapDAO.put(Endereco.class.getSimpleName(), new EnderecoDAO());
		mapDAO.put(Cliente.class.getSimpleName(), new ClienteDAO());
		mapDAO.put(Carrinho.class.getSimpleName(), new CarrinhoDAO());
		mapDAO.put(ItemCarrinho.class.getSimpleName(), new ItemCarrinhoDAO());
		mapDAO.put(Pedido.class.getSimpleName(), new PedidoDAO());
		mapDAO.put(Troca.class.getSimpleName(), new TrocaDAO());
		mapDAO.put(Relatorio.class.getSimpleName(), new RelatorioDAO());
		mapEntidadeCRUDStrategy.put(Instrumento.class.getSimpleName(), mapInstrumentoStrategy);
		mapEntidadeCRUDStrategy.put(Ocorrencia.class.getSimpleName(), mapOcorrenciaStrategy);
		mapEntidadeCRUDStrategy.put(Entrada.class.getSimpleName(), mapEntradaStrategy);
		mapEntidadeCRUDStrategy.put(Usuario.class.getSimpleName(), mapUsuarioStrategy);
		mapEntidadeCRUDStrategy.put(Cliente.class.getSimpleName(), mapClienteStrategy);
		mapEntidadeCRUDStrategy.put(Pedido.class.getSimpleName(), mapPedidoStrategy);	
		mapEntidadeCRUDStrategy.put(ItemCarrinho.class.getSimpleName(), mapItemCarrinhoStrategy);
		mapEntidadeCRUDStrategy.put(Carrinho.class.getSimpleName(), mapCarrinhoStrategy);
		mapEntidadeCRUDStrategy.put(Troca.class.getSimpleName(), mapTrocaStrategy);
		mapEntidadeCRUDStrategy.put(Relatorio.class.getSimpleName(), mapRelatorioStrategy);
		mapEntidadeCRUDPosProcessamento.put(Ocorrencia.class.getSimpleName(), mapOcorrenciaPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Entrada.class.getSimpleName(), mapEntradaPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Fornecedor.class.getSimpleName(), mapFornecedorPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Instrumento.class.getSimpleName(), mapInstrumentoPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Usuario.class.getSimpleName(), mapUsuarioPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Cliente.class.getSimpleName(), mapClientePosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(ItemCarrinho.class.getSimpleName(), mapItemCarrinhoPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Cupom.class.getSimpleName(), mapCupomPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Carrinho.class.getSimpleName(), mapCarrinhoPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Pedido.class.getSimpleName(), mapPedidoPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Carrinho.class.getSimpleName(), mapCarrinhoStrategyPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Troca.class.getSimpleName(), mapTrocaStrategyPosProcessamento);
	}

	private Resultado validaStrategy(EntidadeDominio entidade, String operacao) {

		Resultado r = new Resultado();
		String mensagem = "";
		String mensagens = "";

		Map<String, List<IStrategy>> map = mapEntidadeCRUDStrategy.get(entidade.getClass().getSimpleName());
		if (map != null) {
			List<IStrategy> list = map.get(operacao);

			if (list != null) {
				for (IStrategy iStrategy : list) {
					mensagem = iStrategy.processar(entidade);
					if (mensagem != null) {
						mensagens += mensagem;
					}
					if (mensagens.length() > 0) {
						r.setErro(mensagens);
						break;

					} else {
						r.setSucesso("");
					}
				}

				r.setEntidade(entidade);
			}
		}
		return r;
	}

	private Resultado validaStrategyPosProcessamento(Resultado resultado, String operacao) {

		Resultado r = new Resultado();
		if (resultado.getListEntidade() != null && resultado.getListEntidade().size() > 0) {

			EntidadeDominio entidade = resultado.getEntidade();

			Map<String, List<IStrategy>> map = mapEntidadeCRUDPosProcessamento.get(entidade.getClass().getSimpleName());
			if (map != null) {
				List<IStrategy> list = map.get(operacao);
				if (list != null) {
					for (IStrategy iStrategy : list) {
						r = iStrategy.processar(resultado);
						if (r.getErro()) {
							return resultado;
						}
					}
				}
			}
		}
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {

		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "ALTERAR");

		if (!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.alterar(entidade);
		}
		if (!resultado.getErro()) {
			resultado = validaStrategyPosProcessamento(resultado, "ALTERAR");
		}
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {

		Resultado resultado = new Resultado();
		if (!resultado.getErro()) {
			resultado = validaStrategy(entidade, "CONSULTAR");
		}

		if (!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.consultar(entidade);
		}

		if (!resultado.getErro()) {
			resultado = validaStrategyPosProcessamento(resultado, "CONSULTAR-JSON");
		}

		if (!resultado.getErro()) {
			resultado = validaStrategyPosProcessamento(resultado, "CONSULTAR");
		}

		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {

		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "EXCLUIR");
		IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());

		if (!resultado.getErro()) {
			resultado = dao.excluir(entidade);
		}
		
		if (!resultado.getErro()) {
			resultado = validaStrategyPosProcessamento(resultado, "EXCLUIR");
		}
		
		return resultado;
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {

		String mensagem = null;
		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "SALVAR");

		if (!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.salvar(entidade);
			mensagem = resultado.getMensagem();
		}

		resultado = validaStrategyPosProcessamento(resultado, "SALVAR");
		if (!resultado.getErro())
			resultado.setSucesso(mensagem);

		return resultado;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {

		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "CONSULTARBYID");

		if (!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.consultarById(entidade);
		}
		
			
		resultado = validaStrategyPosProcessamento(resultado, "CONSULTARBYID");
		
		
		return resultado;
	}

}
