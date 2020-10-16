package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransacoesHistorico {

    private Cliente cliente;
    private List<ItensDeCarrinho> controladorItens = new ArrayList<ItensDeCarrinho>();
    private LocalDate dataCompra;
    private double total;
    private String formaPagamento;

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItensDeCarrinho> getControladorItens() {
        return this.controladorItens;
    }

    public void setControladorItens(List<ItensDeCarrinho> controladorItens) {
        this.controladorItens = controladorItens;
    }

    public LocalDate getDataCompra() {
        return this.dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormaPagamento() {
        return this.formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String mostrarTransacao() {
        return "------------------------------" + "\nData da compra:" + dataCompra + "\n\nComprador: "
                + cliente.getNome() + "\n" + controladorItens + "\n" + "\nForma de pagamento: " + formaPagamento
                + "\nTotal: " + total + "\n------------------------------ \n";
    }
}
