package controller;

import java.util.List;
import database.IRepositorioCliente;
import database.RepositorioCliente;
import model.Cliente;

public class ControladorCliente implements IControladorCliente {
    private static ControladorCliente instancia;
    private IRepositorioCliente repositorioCliente;

    public static ControladorCliente getInstancia() {
        if (instancia == null) {
            instancia = new ControladorCliente();
        }
        return instancia;
    }

    private ControladorCliente() {
        repositorioCliente = RepositorioCliente.getInstancia();
    }

    public void cadastrarCliente(Cliente cliente) {
        repositorioCliente.cadastrarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return repositorioCliente.listarClientes();
    }

    public Cliente logarCliente(String login, String senha) {
        if (validarLogin(login) != 0 && validarSenha(senha) != 0) {
            int posicao = validarSenha(senha);
            Cliente cliente = repositorioCliente.listarClientes().get(posicao);
            return cliente;
        }
        return null;
    }

    public int validarLogin(String login) {
        for (int index = 0; index < repositorioCliente.listarClientes().size(); index++) {
            if (repositorioCliente.listarClientes().get(index).getLogin().equals(login)) {
                return index;
            }
        }
        return 0;
    }

    public int validarSenha(String senha) {
        for (int index = 0; index < repositorioCliente.listarClientes().size(); index++) {
            if (repositorioCliente.listarClientes().get(index).getSenha().equals(senha)) {
                return index;
            }
        }
        return 0;
    }

}
