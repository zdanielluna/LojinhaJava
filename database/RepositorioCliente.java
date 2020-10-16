package database;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class RepositorioCliente implements IRepositorioCliente {

    private List<Cliente> listaClientes;
    private static RepositorioCliente instancia;

    public static RepositorioCliente getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioCliente();
        }
        return instancia;
    }

    private RepositorioCliente() {
        listaClientes = new ArrayList<Cliente>();
    }

    public void cadastrarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return listaClientes;
    }

}