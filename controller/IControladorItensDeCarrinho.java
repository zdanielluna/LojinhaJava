package controller;

import java.util.List;
import model.ItensDeCarrinho;

public interface IControladorItensDeCarrinho {

    public void cadastrarItensDeCarrinho(ItensDeCarrinho itensCarrinho);

    public void removerItensDeCarrinho(int codigo);

    public List<ItensDeCarrinho> listarItensDeCarrinho();

}
