package strategy;

import model.CarrinhoDeCompras;

public interface FormaDePagamento {
    void calculaPontuacao(CarrinhoDeCompras carrinho);
}
