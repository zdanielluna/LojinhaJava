package database;

import java.util.ArrayList;
import java.util.List;
import model.HistoricoTransacoes;

public class RepositorioTransacoes implements IRepositorioTransacoes {
    private List<HistoricoTransacoes> listaTransacoes;
    private static RepositorioTransacoes instancia;

    private RepositorioTransacoes() {
        listaTransacoes = new ArrayList<HistoricoTransacoes>();
    }

    public static RepositorioTransacoes getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioTransacoes();
        }
        return instancia;
    }

    public void cadastrarTransacao(HistoricoTransacoes transacao) {
        listaTransacoes.add(transacao);
    }

    public List<HistoricoTransacoes> listarTransacoes() {
        return listaTransacoes;
    }

}
