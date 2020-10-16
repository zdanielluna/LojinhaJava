package model;

import java.util.Random;

import state.ClienteBronze;
import state.ClienteState;

public class Cliente {
    protected ClienteState estado;
    private int pontuacao;
    private String nome;
    private String login;
    private String senha;
    private int qtdMeses;

    private static Random random = new Random();

    public Cliente(String nome, String login, String senha) {
        estado = new ClienteBronze();
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.qtdMeses = random.nextInt(12);
        this.pontuacao = qtdMeses * 10;
}

    public ClienteState getEstado() {
        return this.estado;
    }

    public void setEstado(ClienteState estado) {
        this.estado = estado;
    }

    public void subirRank(Cliente cliente) {
        estado = estado.subirRank(cliente);
    }

    public void descerRank(Cliente cliente) {
        estado = estado.descerRank(cliente);
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getQtdMeses() {
        return this.qtdMeses;
    }

    public void setQtdMeses(int qtdMeses) {
        this.qtdMeses = qtdMeses;
    }

    public void mostrarDados() {
        System.out.println(nome);
    }
}
