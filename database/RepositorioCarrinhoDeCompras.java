
package database;

import java.util.ArrayList;
import java.util.List;
import model.CarrinhoDeCompras;

public class RepositorioCarrinhoDeCompras implements IRepositorioCarrinhoDeCompras {
    private List<CarrinhoDeCompras> listaCarrinhoDeCompras;
    private static RepositorioCarrinhoDeCompras instancia;

    private RepositorioCarrinhoDeCompras() {
        listaCarrinhoDeCompras = new ArrayList<CarrinhoDeCompras>();
    }

    public static RepositorioCarrinhoDeCompras getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCarrinhoDeCompras();
        }
        return instancia;
    }

    public void cadastrarCompra(CarrinhoDeCompras carrinhoCompras) {
        listaCarrinhoDeCompras.add(carrinhoCompras);
    }

    public List<CarrinhoDeCompras> listarCarrinhos() {
        return listaCarrinhoDeCompras;
    }

}
