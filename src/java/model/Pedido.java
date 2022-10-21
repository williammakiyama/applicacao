package model;

import enums.StatusPagamentoEnum;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int id;
    private Date dataCriaocao;
    private Date dataPagamento;
    private StatusPagamentoEnum pagamento;
    private String status;
    private boolean ativo;
    private Usuario usuario;
    private ArrayList<ItemPedido> itensPedido;

    public Pedido() {
    }

    public Pedido(int id, Date dataCriaocao, Date dataPagamento, StatusPagamentoEnum pagamento, String status, boolean ativo, Usuario usuario, ArrayList<ItemPedido> itensPedido) {
        this.id = id;
        this.dataCriaocao = dataCriaocao;
        this.dataPagamento = dataPagamento;
        this.pagamento = pagamento;
        this.status = status;
        this.ativo = ativo;
        this.usuario = usuario;
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

    public Date getDataCriaocao() {
        return dataCriaocao;
    }

    public void setDataCriaocao(Date dataCriaocao) {
        this.dataCriaocao = dataCriaocao;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<ItemPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(ArrayList<ItemPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

}
