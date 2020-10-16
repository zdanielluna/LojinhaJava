package controller;

import java.util.List;

import model.CarrinhoDeCompras;
import model.Cliente;
import model.TransacoesHistorico;

public interface IControladorTransacoesHistorico {
    public void cadastrarTransacao(TransacoesHistorico transacoesHistorico);

    public List<TransacoesHistorico> listarTransacoes();

    public TransacoesHistorico retornarTransacaoCliente(Cliente cliente);

    public TransacoesHistorico[] retornarTransacoes(Cliente cliente);

    public TransacoesHistorico clone(CarrinhoDeCompras carrinho);
}
