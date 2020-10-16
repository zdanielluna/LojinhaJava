package state;

import model.Cliente;

public class ClienteOuro implements ClienteState {

    @Override
    public ClienteState subirRank(Cliente cliente) {
        if (cliente.getPontuacao() >= 10000) {
            return new ClienteDiamante();
        }
        return this;
    }

    @Override
    public ClienteState descerRank(Cliente cliente) {
        cliente.setPontuacao(4400);
        return new ClientePrata();
    }

    @Override
    public void exibirBeneficios() {
        System.out.println("\n**** BENEFÍCIOS CLIENTE OURO (5) ****");
        System.out.println("- R$25,00 OFF em farmácias (Em compras a partir de R$123,00)");
        System.out.println("- R$37,00 OFF em bebidas(Em compras a partir de R$184,00)");
        System.out.println("- Tenha pedidos priorirátios");
        System.out.println("- Cashback R$15,00 em beleza(Em compras a partir de R$150,00)");
        System.out.println("- Ganhe ponto por compra");
        System.out.println("- Atendimento especializado");
    }

}
