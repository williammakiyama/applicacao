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
public class Categoria {
    private int id;
    private String descricao;
    private boolean ativo;
    private Categoria categoria;

    public Categoria(int id, String descricao, boolean ativo, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.ativo = ativo;
        this.categoria = categoria;
    }
    
    public Categoria(int id) {
        this.id = id;
    }
    
    public Categoria() {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
