package view;

import java.time.LocalDate;
import java.util.Scanner;
import facade.Fachada;
import model.CarrinhoDeCompras;
import model.Cliente;
import model.ItensDeCarrinho;
import model.Produto;
import model.TransacoesHistorico;

public class Menus {
    UiProduto uiProduto = new UiProduto();

    static Scanner scan = new Scanner(System.in);
    private Fachada fachada = Fachada.getInstancia();

    public void telaPrincipal() {
        System.out.println("1-Logar");
        // System.out.println("1-Logar como cliente| 2- Cadastrar | 3- Logar como ADM");
        int escolha = scan.nextInt();
        switch (escolha) {
            case 1:
                telaLogin();
                break;
            default:
                telaPrincipal();
                break;
        }
    }

    private void telaLogin() {
        Cliente cliente = null;
        String login, senha;

        System.out.println("Login: ");
        login = scan.next();
        System.out.println("Senha: ");
        senha = scan.next();

        cliente = fachada.logarCliente(login, senha);

        telaAreaCliente(cliente);
    }

    private void telaAreaCliente(Cliente cliente) {
        if (cliente != null) {
            cliente.subirRank(cliente);
            exibeInformacaoCliente(cliente);
            exibeInformativos(cliente);
            cliente.getEstado().exibirBeneficios();
            menuInferiorCliente(cliente);
        }
    }

    private void exibeInformacaoCliente(Cliente cliente) {
        System.out.println("\n-> Logado como: " + cliente.getNome());
        System.out.println("-> Cliente há: " + cliente.getQtdMeses() + " meses");
        System.out.println("-> Pontuação atual: " + cliente.getPontuacao() + "");
    }

    private void exibeInformativos(Cliente cliente) {
        LocalDate proximaSemana = LocalDate.now().plusDays(7);
        System.out.println("-> Realize uma compra até " + proximaSemana + " para não cair de rank");
    }

    private void menuInferiorCliente(Cliente cliente) {
        System.out.println("\n (1) Ver produtos (2) Histórico de compras (3) Sair ");
        int escolha = -1;
        escolha = scan.nextInt();

        switch (escolha) {
            case 1:
                telaSelecaoItens(cliente);
                break;
            case 2:
                telaHistoricoTransacoes(cliente);
                break;
            case 3:
                telaPrincipal();
                break;
            default:
                telaSelecaoItens(cliente);
        }
    }

    private void telaSelecaoItens(Cliente cliente) {
        LocalDate data = LocalDate.now();
        CarrinhoDeCompras carrinhoCompras = new CarrinhoDeCompras();

        UiProduto uiProduto = new UiProduto();
        int escolha;
        double somatorio = 0;

        do {
            System.out.println("\n(1) Escolher (0) Menu carrinho");

            escolha = scan.nextInt();
            uiProduto.menuProduto();

            if (escolha == 1) {
                System.out.println("\nSelecione um produto(nome): ");
                String nome = scan.next();

                Produto produto = null;
                produto = fachada.retornaProduto(nome);

                ItensDeCarrinho itensCarrinho = new ItensDeCarrinho();
                itensCarrinho.setProduto(produto);

                System.out.println("\nQuantidade:");
                int quantidade = scan.nextInt();
                itensCarrinho.setQuantidadeProduto(quantidade);
                double valorTotal = produto.getPreco() * itensCarrinho.getQuantidadeProduto();
                itensCarrinho.setValor(Math.round(valorTotal * 100.0) / 100.0);

                somatorio += itensCarrinho.getValor();

                carrinhoCompras.getControladorItens().add(itensCarrinho);
                fachada.cadastrarItensDeCarrinho(itensCarrinho);
            }

            carrinhoCompras.setTotal(somatorio);
            carrinhoCompras.setCliente(cliente);
            carrinhoCompras.setDataCompra(data);
            fachada.inserirCompra(carrinhoCompras);

        } while (escolha != 0);

        telaCarrinhoDeCompras(cliente);
    }

    private void telaCarrinhoCliente(Cliente cliente) {
        System.out.println("----- SEU CARRINHO -----\n");
        CarrinhoDeCompras carrinhoCliente = fachada.retornarCarrinhoCliente(cliente);
        System.out.println(carrinhoCliente.mostraCarrinho());
    }

    private void telaHistoricoTransacoes(Cliente cliente) {
        System.out.println("\n----- HISTÓRICO DE TRANSAÇÕES -----\n");
        TransacoesHistorico transacoes[] = fachada.retornarTransacoes(cliente);
        for (int i = 0; i < transacoes.length; i++) {
            System.out.println(transacoes[i].mostrarTransacao());
        }

        System.out.println("(1) Area do Cliente   (0) Sair");
        int resposta = -73;
        resposta = scan.nextInt();

        switch (resposta) {
            case 1:
                telaAreaCliente(cliente);
                break;
            case 0:
                telaPrincipal();
                break;
            default:
                telaPrincipal();
                break;
        }
    }

    private void telaCarrinhoDeCompras(Cliente cliente) {
        System.out.println("\n");
        System.out.println("                      | Carrinho de " + cliente.getNome() + " |" + "\n");
        telaCarrinhoCliente(cliente);
        System.out.println("(1) Forma de pagamento (2) Desistir");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                telaDePagamento(cliente);
                break;
            case 2:
                telaPrincipal();
            default:
                telaPrincipal();
                break;
        }
    }

    private void telaDePagamento(Cliente cliente) {
        int formaDePagamento = 0;

        System.out.println("(1) Boleto | (2) Parcelado");
        formaDePagamento = scan.nextInt();

        switch (formaDePagamento) {
            case 1:
                fachada.atribuiPontuacaoBoleto(cliente);
                break;
            case 2:
                fachada.atribuiPontuacaoParcelado(cliente);
                break;
        }
        telaConfirmacaoCompra(cliente);
    }

    private void telaConfirmacaoCompra(Cliente cliente) {
        System.out.println("Confirme a compra digitando a sua senha: ");
        String senha = scan.next();
        int validaSenha = fachada.validarSenha(senha);
        if (validaSenha != 0) {
            telaCarrinhoCliente(cliente);

            CarrinhoDeCompras carrinho = fachada.retornarCarrinhoCliente(cliente);
            TransacoesHistorico transacao = fachada.clone(carrinho);
            fachada.cadastrarTransacao(transacao);

            fachada.resetarCarrinho(cliente);
            System.out.println("\nCompra realizada com sucesso!");
            telaAreaCliente(cliente);
        } else {
            System.err.print("\nSenha incorreta!\n");
            telaDePagamento(cliente);
        }

    }

}
