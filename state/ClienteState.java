package state;

import model.Cliente;

public interface ClienteState {
    ClienteState subirRank(Cliente cliente);

    ClienteState descerRank(Cliente cliente);

    void exibirBeneficios();
}
