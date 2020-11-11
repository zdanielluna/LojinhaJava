package strategy;

import model.CarrinhoDeCompras;

public class Boleto implements FormaDePagamento {

    @Override
    public void calculaPontuacao(CarrinhoDeCompras carrinho) {
        carrinho.setFormaPagamento("Boleto");
        carrinho.getCliente().setPontuacao((int) (carrinho.getCliente().getPontuacao() + carrinho.getTotal() * 1.6));
    }
}
