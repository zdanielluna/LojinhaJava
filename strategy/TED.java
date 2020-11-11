package strategy;

import model.CarrinhoDeCompras;

public class TED implements FormaDePagamento {

    @Override
    public void calculaPontuacao(CarrinhoDeCompras carrinho) {
        carrinho.setFormaPagamento("TED");
        carrinho.getCliente().setPontuacao((int) (carrinho.getCliente().getPontuacao() + carrinho.getTotal() * 1.4));
    }

}
