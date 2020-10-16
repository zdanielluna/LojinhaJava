package database;

import java.util.List;
import model.Cliente;

public interface IRepositorioCliente {

    public void cadastrarCliente(Cliente cliente);

    public List<Cliente> listarClientes();
}
