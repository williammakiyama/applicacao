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

    public Categoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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
}
