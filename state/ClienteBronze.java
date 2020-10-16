package state;

import model.Cliente;

public class ClienteBronze implements ClienteState {

    @Override
    public ClienteState subirRank(Cliente cliente) {
        if (cliente.getPontuacao() < 1200) {
            return new ClienteBronze();
        }
        if (cliente.getPontuacao() >= 1200 && cliente.getPontuacao() < 5000) {
            return new ClientePrata();
        } else if (cliente.getPontuacao() >= 5000 && cliente.getPontuacao() < 10000) {
            return new ClienteOuro();
        }
        return new ClienteDiamante();
    }

    @Override
    public ClienteState descerRank(Cliente cliente) {
        cliente.setPontuacao(600);
        return this;
    }

    @Override
    public void exibirBeneficios() {
        System.out.println("\n**** BENEFÍCIOS CLIENTE BRONZE (1) ****");
        System.out.println("- Ganhe pontos por compra");
    }

}
