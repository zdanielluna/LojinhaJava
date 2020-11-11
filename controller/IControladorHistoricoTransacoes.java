package controller;

import java.util.List;

import model.CarrinhoDeCompras;
import model.Cliente;
import model.HistoricoTransacoes;

public interface IControladorHistoricoTransacoes {
    public void cadastrarTransacao(HistoricoTransacoes transacoesHistorico);

    public List<HistoricoTransacoes> listarTransacoes();

    public HistoricoTransacoes retornarTransacaoCliente(Cliente cliente);

    public HistoricoTransacoes[] retornarTransacoes(Cliente cliente);

    public HistoricoTransacoes clone(CarrinhoDeCompras carrinho);
}
