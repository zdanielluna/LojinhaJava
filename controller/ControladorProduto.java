package controller;

import java.util.List;

import database.IRepositorioProduto;
import database.RepositorioProduto;
import model.Produto;

public class ControladorProduto implements IControladorProduto {
    private IRepositorioProduto repositorioProduto;
    private static ControladorProduto instancia;

    private ControladorProduto() {
        repositorioProduto = RepositorioProduto.getInstancia();
    }

    public static ControladorProduto getInstancia() {
        if (instancia == null) {
            instancia = new ControladorProduto();
        }
        return instancia;
    }

    public void cadastrarProduto(Produto produto) {
        repositorioProduto.cadastrarProduto(produto);
    }

    public List<Produto> listarProdutos() {
        return repositorioProduto.listarProdutos();
    }

    public Produto retornaProduto(String nome) {
        for (int i = 0; i < repositorioProduto.listarProdutos().size(); i++) {
            if (repositorioProduto.listarProdutos().get(i).getNome().equalsIgnoreCase(nome)) {
                return repositorioProduto.listarProdutos().get(i);
            }
        }
        return null;
    }
}
