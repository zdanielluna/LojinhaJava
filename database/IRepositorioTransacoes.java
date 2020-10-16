package database;

import java.util.List;
import model.TransacoesHistorico;

public interface IRepositorioTransacoes {

    public List<TransacoesHistorico> listarTransacoes();

    public void cadastrarTransacao(TransacoesHistorico transacao);

}
