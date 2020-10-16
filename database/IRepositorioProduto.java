package database;

import java.util.List;
import model.Produto;

public interface IRepositorioProduto {

    public void cadastrarProduto(Produto produto);

    public List<Produto> listarProdutos();

}