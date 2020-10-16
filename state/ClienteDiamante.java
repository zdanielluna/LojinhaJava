package state;

import model.Cliente;

public class ClienteDiamante implements ClienteState {

    @Override
    public ClienteState subirRank(Cliente cliente) {
        if (cliente.getPontuacao() >= 10000) {
            return new ClienteDiamante();
        }
        return this;
    }

    @Override
    public ClienteState descerRank(Cliente cliente) {
        cliente.setPontuacao(9400);
        return new ClienteOuro();
    }

    @Override
    public void exibirBeneficios() {
        System.out.println("\n**** BENEFÍCIOS CLIENTE DIAMANTE (8) ****");
        System.out.println("- Cashback R$50,00 em tecnologia(Em compras a partir de R$450,00)");
        System.out.println("- R$50,00 OFF em bebidas (Em compras a partir de R$246,00)");
        System.out.println("- R$37,00 OFF em farmácias (Em compras a partir de R$ 184,00)");
        System.out.println("- Cashback R$20,00 em lar (Em compras a partir de R$200,00)");
        System.out.println("- Ganhe pontos em cada compra");
        System.out.println("- Tenha pedidos prioritários");
        System.out.println("- Atendimento especializado");
        System.out.println("- Rappis avaliados como excelente");
    }

}
