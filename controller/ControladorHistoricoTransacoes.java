package controller;

import java.util.List;
import database.IRepositorioTransacoes;
import database.RepositorioTransacoes;
import model.CarrinhoDeCompras;
import model.Cliente;
import model.HistoricoTransacoes;

public class ControladorHistoricoTransacoes implements IControladorHistoricoTransacoes {
    private IRepositorioTransacoes repositorioTransacoes;
    private static ControladorHistoricoTransacoes instancia;

    private ControladorHistoricoTransacoes() {
        repositorioTransacoes = RepositorioTransacoes.getInstancia();
    }

    public static ControladorHistoricoTransacoes getInstancia() {
        if (instancia == null) {
            instancia = new ControladorHistoricoTransacoes();
        }
        return instancia;
    }

    public void cadastrarTransacao(HistoricoTransacoes transacao) {
        repositorioTransacoes.cadastrarTransacao(transacao);
    }

    public List<HistoricoTransacoes> listarTransacoes() {
        return repositorioTransacoes.listarTransacoes();
    }

    public HistoricoTransacoes retornarTransacaoCliente(Cliente cliente) {
        for (int i = 0; i < listarTransacoes().size(); i++) {
            if (listarTransacoes().get(i).getCliente() == cliente) {
                return listarTransacoes().get(i);
            }
        }
        return null;
    }

    public HistoricoTransacoes[] retornarTransacoes(Cliente cliente) {
        HistoricoTransacoes transacoes[] = new HistoricoTransacoes[listarTransacoes().size()];
        for (int i = 0; i < listarTransacoes().size(); i++) {
            if (listarTransacoes().get(i).getCliente() == cliente) {
                transacoes[i] = listarTransacoes().get(i);
            }
        }
        return transacoes;
    }

    public HistoricoTransacoes clone(CarrinhoDeCompras carrinho) {
        HistoricoTransacoes transacao = new HistoricoTransacoes();
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
