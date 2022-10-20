/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author willi
 */
public class Produto {
    private int id;
    private String descricao;
    private double ultimoValorCompra;
    private double valorVenda;
    private String nome;
    private Categoria categoria;
    private boolean ativo;
    private int quantidadeEstoque;
    private int quantidadeMinimo;
    private int totalProdutos;

    public Produto(int id, String descricao, double ultimoValorCompra, double valorVenda, String nome, Categoria categoria, boolean ativo, int quantidadeEstoque, int quantidadeMinimo, int totalProdutos) {
        this.id = id;
        this.descricao = descricao;
        this.ultimoValorCompra = ultimoValorCompra;
        this.valorVenda = valorVenda;
        this.nome = nome;
        this.categoria = categoria;
        this.ativo = ativo;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinimo = quantidadeMinimo;
        this.totalProdutos = totalProdutos;
    }

   
    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getUltimoValorCompra() {
        return ultimoValorCompra;
    }

    public void setUltimoValorCompra(double ultimoValorCompra) {
        this.ultimoValorCompra = ultimoValorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeMinimo() {
        return quantidadeMinimo;
    }

    public void setQuantidadeMinimo(int quantidadeMinimo) {
        this.quantidadeMinimo = quantidadeMinimo;
    }

    public int getTotalProdutos() {
        return totalProdutos;
    }

    public void setTotalProdutos(int totalProdutos) {
        this.totalProdutos = totalProdutos;
    }
    
}
