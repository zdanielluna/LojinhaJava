package model;

public class Produto {
    private String nome;
    private Double preco;
    private int qtdEstoque;
    private int id;
    private static int sequencia = 0;

    public Produto(String nome, Double preco, int qtdEstoque) {
        this.id = sequencia++;
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return this.preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQtdEstoque() {
        return this.qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String exibeProduto() {
        return "\nNome: " + nome + "\nPreço: " + preco;
    }

}
