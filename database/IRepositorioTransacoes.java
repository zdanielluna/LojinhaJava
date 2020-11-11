package database;

import java.util.List;
import model.HistoricoTransacoes;

public interface IRepositorioTransacoes {

    public List<HistoricoTransacoes> listarTransacoes();

    public void cadastrarTransacao(HistoricoTransacoes transacao);

}
