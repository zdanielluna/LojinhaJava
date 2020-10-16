package database;

import java.util.ArrayList;
import java.util.List;

import model.ItensDeCarrinho;

public class RepositorioItensDeCarrinho implements IRepositorioItensDeCarrinho {

    private List<ItensDeCarrinho> listaItensCarrinho;
    private static RepositorioItensDeCarrinho instancia;

    private RepositorioItensDeCarrinho() {
        listaItensCarrinho = new ArrayList<ItensDeCarrinho>();
    }

    public static RepositorioItensDeCarrinho getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioItensDeCarrinho();
        }
        return instancia;
    }

    public void inserirItem(ItensDeCarrinho itensCarrinho) {
        listaItensCarrinho.add(itensCarrinho);
    }

    public void removerItem(ItensDeCarrinho itensCarrinho) {
        listaItensCarrinho.remove(itensCarrinho);
    }

    public List<ItensDeCarrinho> listarItens() {
        return listaItensCarrinho;
    }

    public ItensDeCarrinho pesquisarItemCarrinho(int posicao) {
        return listaItensCarrinho.get(posicao);
    }

}
