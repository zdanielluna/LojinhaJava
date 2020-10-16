package util;

import model.Cliente;
import model.Produto;
import facade.Fachada;
import java.util.Random;

public class Inicializador {
    static Random random = new Random();
    private static Fachada fachada = Fachada.getInstancia();

    public void iniciarPrograma() {
        iniciarCliente();
        iniciarProduto();
    }

    // Popula automaticamente o repositório de Produto
    public static void iniciarProduto() {

        String[] farmacos = { "AEROLIM", "ALEGRA", "FOSTAIR DPI", "TIMOMODULINA", "VITAMINA C", "CLOROQUINA",
                "BENEGRIPE", "DAPSONA", "DIGOXINA", "DOXICICLINA", "PREDNISONA", "PERMETRINA", "RITONAVIR",
                "BUDESONIDA", "LORATADINA", "LAMIVUDINA", "HIDROCLOROTIAZIDA", "NORETISTERONA", "VERAPAMIL",
                "NISTATINA", "TALIDOMIDA", "TIAMINA" };

        for (int i = 0; i < farmacos.length; i++) {
            String nome = farmacos[i];
            Double preco = random.nextDouble() * (50 - 20) + 20;
            int qtdEstoque = random.nextInt(2000);

            preco = Math.round(preco * 100.0) / 100.0;

            Produto farmaco = new Produto(nome, preco, qtdEstoque);
            fachada.cadastrarProduto(farmaco);
        }
    }

    // Popula automaticamente o repositório de Cliente
    public static void iniciarCliente() {
        String[] nomes = { "Lana Gabriela", "Lara Luna", "Bruno Martins", "Kimberli Bilinskyj", "Bruna Lucht",
                "Luana Lima", "Mireli Lucarelli", "Kayo Savio", "João Araujo", "Letícia Vieira" };

        String[] logins = { "LaninhaG", "LaraL", "BrunoM", "KimberliB", "Bruna_Lucht", "yLua", "M_Lucarelli", "Kayo_S",
                "JaoA", "Lele_V" };

        String[] senhas = { "arroz123", "feijao123", "limonada123", "macarrao123", "alface123", "tomate123", "pudim123",
                "camarao123", "cebolinha123", "cebolao123" };

        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];
            String login = logins[i];
            String senha = senhas[i];

            Cliente cliente = new Cliente(nome, login, senha);
            fachada.cadastrarCliente(cliente);

        }
    }

}
