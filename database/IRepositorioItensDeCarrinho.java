package database;

import java.util.List;
import model.ItensDeCarrinho;

public interface IRepositorioItensDeCarrinho {

    public void inserirItem(ItensDeCarrinho itensCarrinho);

    public void removerItem(ItensDeCarrinho itensCarrinho);

    public List<ItensDeCarrinho> listarItens();

    public ItensDeCarrinho pesquisarItemCarrinho(int posicao);

}
