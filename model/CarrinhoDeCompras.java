package model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class CarrinhoDeCompras {

    private Cliente cliente;
    private List<ItensDeCarrinho> controladorItens = new ArrayList<ItensDeCarrinho>();
    private LocalDate dataCompra;
    private double total;
    private String formaPagamento;

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<ItensDeCarrinho> getControladorItens() {
        return controladorItens;
    }

    public void setControladorItens(List<ItensDeCarrinho> controladorItens) {
        this.controladorItens = controladorItens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate data) {
        this.dataCompra = data;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String imprimirObjeto() {
        return controladorItens + "\n" + "\nCompra finalizada:" + dataCompra + "\n";
    }

    public String imprimirComprador() {
        return "	     Comprador: " + cliente.getNome();
    }

    public String mostraCarrinho() {
        return "\nComprador: " + cliente.getNome() + controladorItens + "\n" + "\nTotal: " + total
                + "\nForma de pagamento: " + formaPagamento + "\nData da compra:" + dataCompra + "\n";
    }
}
