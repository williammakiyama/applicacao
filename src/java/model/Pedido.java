package model;

import enums.StatusPagamentoEnum;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int id;
    private Date dataCriacao;
    private Date dataPagamento;
    private StatusPagamentoEnum pagamento;
    private ArrayList<ItemPedido> itensPedido;

    public Pedido() {
    }

    public Pedido(int id, Date dataCriacao, Date dataPagamento, StatusPagamentoEnum pagamento, ArrayList<ItemPedido> itensPedido) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataPagamento = dataPagamento;
        this.pagamento = pagamento;
        this.itensPedido = itensPedido;
    }

    public StatusPagamentoEnum getPagamento() {
        return pagamento;
    }

    public void setPagamento(StatusPagamentoEnum pagamento) {
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public ArrayList<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

}
