package database;

import java.util.List;
import model.CarrinhoDeCompras;

public interface IRepositorioCarrinhoDeCompras {

    public void cadastrarCompra(CarrinhoDeCompras carrinhoCompras);

    public List<CarrinhoDeCompras> listarCarrinhos();

}
