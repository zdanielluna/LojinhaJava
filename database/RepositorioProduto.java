package database;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class RepositorioProduto implements IRepositorioProduto {
    private List<Produto> listaProdutos;
    private static RepositorioProduto instancia;

    private RepositorioProduto() {
        listaProdutos = new ArrayList<Produto>();
    }

    public static RepositorioProduto getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioProduto();
        }
        return instancia;
    }

    public void cadastrarProduto(Produto produto) {
        listaProdutos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return listaProdutos;
    }
}
