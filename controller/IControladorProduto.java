package controller;

import java.util.List;

import model.Produto;

public interface IControladorProduto {
    public void cadastrarProduto(Produto produto);

    public List<Produto> listarProdutos();

    public Produto retornaProduto(String nome);
}
