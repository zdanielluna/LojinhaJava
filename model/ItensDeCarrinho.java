package model;

public class ItensDeCarrinho {

    private int id;
    private int quantidadeProduto;
    private Produto produto;
    private double valor;

    private static int sequencia = 0;

    public ItensDeCarrinho() {
        this.id = sequencia++;
        this.valor = Math.floor(valor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {

        this.quantidadeProduto = quantidadeProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return "\n\nProduto: " + produto.getNome() + "\nQuantidade selecionada (" + quantidadeProduto + ")"
                + "\nValor: " + valor + ")";
    }

}
