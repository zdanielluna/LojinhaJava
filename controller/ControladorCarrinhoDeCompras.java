package controller;

import java.util.List;

import model.CarrinhoDeCompras;
import model.Cliente;
import database.IRepositorioCarrinhoDeCompras;
import database.RepositorioCarrinhoDeCompras;

public class ControladorCarrinhoDeCompras implements IControladorCarrinhoDeCompras {

    private IRepositorioCarrinhoDeCompras repositorioCarrinhoDeCompras;
    private static ControladorCarrinhoDeCompras instancia;

    private ControladorCarrinhoDeCompras() {
        repositorioCarrinhoDeCompras = RepositorioCarrinhoDeCompras.getInstancia();
    }

    public static ControladorCarrinhoDeCompras getInstancia() {
        if (instancia == null) {
            instancia = new ControladorCarrinhoDeCompras();
        }
        return instancia;
    }

    public void cadastrarCompra(CarrinhoDeCompras carrinhoCompras) {
        repositorioCarrinhoDeCompras.cadastrarCompra(carrinhoCompras);
    }

    public CarrinhoDeCompras retornarCarrinhoCliente(Cliente cliente) {
        for (int i = 0; i < listarCarrinhos().size(); i++) {
            if (listarCarrinhos().get(i).getCliente() == cliente) {
                return listarCarrinhos().get(i);
            }
        }
        return null;
    }

    public void resetarCarrinho(Cliente cliente) {
        CarrinhoDeCompras carrinho;
        for (int i = 0; i < repositorioCarrinhoDeCompras.listarCarrinhos().size(); i++) {
            if (cliente == repositorioCarrinhoDeCompras.listarCarrinhos().get(i).getCliente()) {
                carrinho = repositorioCarrinhoDeCompras.listarCarrinhos().get(i);
                carrinho.setCliente(null);
                carrinho.getControladorItens().clear();
                carrinho.setTotal(0);
            }
        }
    }

    public List<CarrinhoDeCompras> listarCarrinhos() {
        return repositorioCarrinhoDeCompras.listarCarrinhos();
    }
}
