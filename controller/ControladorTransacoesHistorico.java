package controller;

import java.util.List;
import database.IRepositorioTransacoes;
import database.RepositorioTransacoes;
import model.CarrinhoDeCompras;
import model.Cliente;
import model.TransacoesHistorico;

public class ControladorTransacoesHistorico implements IControladorTransacoesHistorico {
    private IRepositorioTransacoes repositorioTransacoes;
    private static ControladorTransacoesHistorico instancia;

    private ControladorTransacoesHistorico() {
        repositorioTransacoes = RepositorioTransacoes.getInstancia();
    }

    public static ControladorTransacoesHistorico getInstancia() {
        if (instancia == null) {
            instancia = new ControladorTransacoesHistorico();
        }
        return instancia;
    }

    public void cadastrarTransacao(TransacoesHistorico transacao) {
        repositorioTransacoes.cadastrarTransacao(transacao);
    }

    public List<TransacoesHistorico> listarTransacoes() {
        return repositorioTransacoes.listarTransacoes();
    }

    public TransacoesHistorico retornarTransacaoCliente(Cliente cliente) {
        for (int i = 0; i < listarTransacoes().size(); i++) {
            if (listarTransacoes().get(i).getCliente() == cliente) {
                return listarTransacoes().get(i);
            }
        }
        return null;
    }

    public TransacoesHistorico[] retornarTransacoes(Cliente cliente) {
        TransacoesHistorico transacoes[] = new TransacoesHistorico[listarTransacoes().size()];
        for (int i = 0; i < listarTransacoes().size(); i++) {
            if (listarTransacoes().get(i).getCliente() == cliente) {
                transacoes[i] = listarTransacoes().get(i);
            }
        }
        return transacoes;
    }

    public TransacoesHistorico clone(CarrinhoDeCompras carrinho) {
        TransacoesHistorico transacao = new TransacoesHistorico();
        transacao.setCliente(carrinho.getCliente());

        for (int i = 0; i < carrinho.getControladorItens().size(); i++) {
            transacao.getControladorItens().add(carrinho.getControladorItens().get(i));
        }
        transacao.setFormaPagamento(carrinho.getFormaPagamento());
        transacao.setDataCompra(carrinho.getDataCompra());
        transacao.setTotal(carrinho.getTotal());

        return transacao;
    }

}
