package strategy;

import model.CarrinhoDeCompras;

public class CartaoCredito implements FormaDePagamento {

    @Override
    public void calculaPontuacao(CarrinhoDeCompras carrinho) {
        carrinho.getCliente().setPontuacao((int) (carrinho.getCliente().getPontuacao() + carrinho.getTotal() * 1.2));
        carrinho.setFormaPagamento("Parcelado");
    }
}
