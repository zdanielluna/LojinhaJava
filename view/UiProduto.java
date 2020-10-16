package view;

import facade.Fachada;

public class UiProduto {
    private Fachada fachada = Fachada.getInstancia();

    public void menuProduto() {
        listarProdutos();
    }

    private void listarProdutos() {
        System.out.println("\n|************** COMPRAR FÁRMACOS **************|");
        for (int i = 0; i < fachada.listarProdutos().size(); i++) {
            System.out.println(fachada.listarProdutos().get(i).exibeProduto());
        }
    }
}
