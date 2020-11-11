package strategy;

import model.CarrinhoDeCompras;

public class CalculadorPontuacao {
    public void realizaCalculo(CarrinhoDeCompras carrinho, FormaDePagamento pagamento) {
        pagamento.calculaPontuacao(carrinho);
    }
}
