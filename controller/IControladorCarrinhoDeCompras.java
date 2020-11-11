package controller;

import java.util.List;

import model.CarrinhoDeCompras;
import model.Cliente;

public interface IControladorCarrinhoDeCompras {

    public void cadastrarCompra(CarrinhoDeCompras carrinhoCompras);

    public CarrinhoDeCompras retornarCarrinhoCliente(Cliente cliente);

    public void resetarCarrinho(Cliente cliente);

    public List<CarrinhoDeCompras> listarCarrinhos();
}
