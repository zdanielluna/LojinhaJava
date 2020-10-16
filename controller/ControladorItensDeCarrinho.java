
package controller;

import java.util.List;

import model.ItensDeCarrinho;
import database.IRepositorioItensDeCarrinho;
import database.RepositorioItensDeCarrinho;

public class ControladorItensDeCarrinho implements IControladorItensDeCarrinho {

    private IRepositorioItensDeCarrinho repositorioItensCarrinho;
    private static ControladorItensDeCarrinho instancia;

    public static ControladorItensDeCarrinho getInstancia() {
        if (instancia == null) {
            instancia = new ControladorItensDeCarrinho();
        }
        return instancia;
    }

    private ControladorItensDeCarrinho() {
        repositorioItensCarrinho = RepositorioItensDeCarrinho.getInstancia();
    }

    public void cadastrarItensDeCarrinho(ItensDeCarrinho itensCarrinho) {

        repositorioItensCarrinho.inserirItem(itensCarrinho);

    }

    public void removerItensDeCarrinho(int codigo) {
        for (int i = 0; i < repositorioItensCarrinho.listarItens().size(); i++) {
            if (repositorioItensCarrinho.listarItens().get(i).getId() == codigo) {
                ItensDeCarrinho itensCarrinho = repositorioItensCarrinho.listarItens().get(i);
                repositorioItensCarrinho.removerItem(itensCarrinho);
            }
        }
    }

    public List<ItensDeCarrinho> listarItensDeCarrinho() {
        return repositorioItensCarrinho.listarItens();
    }

}
