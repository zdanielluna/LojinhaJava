package facade;

import java.util.List;
import controller.ControladorCarrinhoDeCompras;
import controller.ControladorCliente;
import controller.ControladorItensDeCarrinho;
import controller.ControladorProduto;
import controller.ControladorHistoricoTransacoes;
import controller.IControladorCarrinhoDeCompras;
import controller.IControladorCliente;
import controller.IControladorItensDeCarrinho;
import controller.IControladorProduto;
import controller.IControladorHistoricoTransacoes;
import model.CarrinhoDeCompras;
import model.Cliente;
import model.ItensDeCarrinho;
import model.Produto;
import model.HistoricoTransacoes;

public class Fachada implements IControladorProduto {
    private IControladorCliente controladorCliente;
    private IControladorProduto controladorProduto;
    private IControladorItensDeCarrinho controladorItensDeCarrinho;
    private IControladorCarrinhoDeCompras controladorCarrinhoCompras;
    private IControladorHistoricoTransacoes controladorTransacoesHistorico;
    private static Fachada instancia;

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private Fachada() {
        controladorCliente = ControladorCliente.getInstancia();
        controladorProduto = ControladorProduto.getInstancia();
        controladorItensDeCarrinho = ControladorItensDeCarrinho.getInstancia();
        controladorCarrinhoCompras = ControladorCarrinhoDeCompras.getInstancia();
        controladorTransacoesHistorico = ControladorHistoricoTransacoes.getInstancia();
    }

    // CLIENTE SERVIÇOS
    public void cadastrarCliente(Cliente cliente) {
        controladorCliente.cadastrarCliente(cliente);
    }

    public Cliente logarCliente(String login, String senha) {
        return controladorCliente.logarCliente(login, senha);
    }

    public int validarSenha(String senha) {
        return controladorCliente.validarSenha(senha);
    }

    public List<Cliente> listarClientes() {
        return controladorCliente.listarClientes();
    }

    // PRODUTO SERVIÇOS
    public void cadastrarProduto(Produto produto) {
        controladorProduto.cadastrarProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return controladorProduto.listarProdutos();
    }

    public Produto retornaProduto(String nome) {
        return controladorProduto.retornaProduto(nome);
    }

    // COMPRAS SERVIÇOS
    // CARRINHO
    public void inserirCompra(CarrinhoDeCompras carrinhoCompras) {
        controladorCarrinhoCompras.cadastrarCompra(carrinhoCompras);
    }

    public List<CarrinhoDeCompras> listaCarrinho() {
        return controladorCarrinhoCompras.listarCarrinhos();
    }

    public CarrinhoDeCompras retornarCarrinhoCliente(Cliente cliente) {
        return controladorCarrinhoCompras.retornarCarrinhoCliente(cliente);
    }

    public void resetarCarrinho(Cliente cliente) {
        controladorCarrinhoCompras.resetarCarrinho(cliente);
    }

    // public void atribuiPontuacaoBoleto(Cliente cliente) {
    //     controladorCarrinhoCompras.atribuiPontuacaoBoleto(cliente);
    // }

    // public void atribuiPontuacaoParcelado(Cliente cliente) {
    //     controladorCarrinhoCompras.atribuiPontuacaoParcelado(cliente);
    // }

    // ITENS DE CARRINHO
    public void cadastrarItensDeCarrinho(ItensDeCarrinho itensCarrinho) {
        controladorItensDeCarrinho.cadastrarItensDeCarrinho(itensCarrinho);
    }

    public List<ItensDeCarrinho> listarItensDeCarrinho() {
        return controladorItensDeCarrinho.listarItensDeCarrinho();
    }

    // HISTÓRICO TRANSAÇÕES SERVIÇOS
    public void cadastrarTransacao(HistoricoTransacoes transacoesHistorico) {
        controladorTransacoesHistorico.cadastrarTransacao(transacoesHistorico);
    }

    public List<HistoricoTransacoes> listarTransacoes() {
        return controladorTransacoesHistorico.listarTransacoes();
    }

    public HistoricoTransacoes retornarTransacaoCliente(Cliente cliente) {
        return controladorTransacoesHistorico.retornarTransacaoCliente(cliente);
    }

    public HistoricoTransacoes[] retornarTransacoes(Cliente cliente) {
        return controladorTransacoesHistorico.retornarTransacoes(cliente);
    }

    public HistoricoTransacoes clone(CarrinhoDeCompras carrinho) {
        return controladorTransacoesHistorico.clone(carrinho);
    }

}
