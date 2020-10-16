package controller;

import java.util.List;
import model.Cliente;

public interface IControladorCliente {
    public void cadastrarCliente(Cliente cliente);

    public Cliente logarCliente(String login, String senha);

    public List<Cliente> listarClientes();

    public int validarSenha(String senha);

}
