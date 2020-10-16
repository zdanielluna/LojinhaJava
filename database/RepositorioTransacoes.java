package database;

import java.util.ArrayList;
import java.util.List;
import model.TransacoesHistorico;

public class RepositorioTransacoes implements IRepositorioTransacoes {
    private List<TransacoesHistorico> listaTransacoes;
    private static RepositorioTransacoes instancia;

    private RepositorioTransacoes() {
        listaTransacoes = new ArrayList<TransacoesHistorico>();
    }

    public static RepositorioTransacoes getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioTransacoes();
        }
        return instancia;
    }

    public void cadastrarTransacao(TransacoesHistorico transacao) {
        listaTransacoes.add(transacao);
    }

    public List<TransacoesHistorico> listarTransacoes() {
        return listaTransacoes;
    }

}
